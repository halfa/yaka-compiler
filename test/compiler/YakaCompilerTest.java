package compiler;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.security.auth.login.FailedLoginException;

import org.junit.Before;
import org.junit.Test;

public class YakaCompilerTest {

	public static Scanner scf1;
	public static Scanner scf2;
	public static File f1;
	public static File f2;

/**
 * 
 * @param genFile the generated file
 * @param refFile the reference file
 * @throws FileNotFoundException
 */
	
	private void testFile(String genFile, String refFile){
		try {
			f1 = new File(genFile);
			scf1 = new Scanner(f1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			fail("No generated file found");
		}

		
		try {
			f2 = new File(refFile);
			scf2 = new Scanner(f2);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			assertTrue(false);
		}
		

		
		while (scf2.hasNext()) {
			if (!scf1.hasNext()) {
				assertTrue(false);
			} else {
				String s1 = scf1.nextLine().replaceAll("\\s+$", "");
				String s2 = scf2.nextLine().replaceAll("\\s+$", "");


				
				assertTrue(s1.equals(s2));

			}
		}

	}

	@Test
	public void maxTest() throws FileNotFoundException {
		String[] args = { "./test/max.yak" };
		Yaka.main(args);

		
		testFile("./max.asm","./test/ref/max.asm");


	}

}
