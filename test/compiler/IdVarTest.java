package compiler;
import static org.junit.Assert.*;

import org.junit.Test;

import compiler.IdVar;
import compiler.Type;


public class IdVarTest {

	
	@Test
	public void testOffset() {
		IdVar i1= new IdVar('a', Type.INTEGER);
		IdVar i2= new IdVar('a', Type.INTEGER);
		
		assertEquals(i1.getOffset(),-2);		
		assertEquals(i2.getOffset(),-4);
		
		i1.setVal('3');
		assertEquals(i1.getOffset(),-2);		
		
		
	}

}
