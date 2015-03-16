package compiler;
import static org.junit.Assert.*;

import org.junit.Test;

import compiler.IdVar;
import compiler.Type;


public class IdVarTest {

	
	@Test
	public void testOffset() {
		IdVar i1= new IdVar(Type.INTEGER);
		IdVar i2= new IdVar(Type.INTEGER);
		
		TabIdent t = new TabIdent();
		t.addIdent("a", i1);
		t.addIdent("a", i2);
		
		assertEquals(i1.getOffset(),-2);		
		assertEquals(i2.getOffset(),-4);
		
		t.addIdent("3",i1);
		assertEquals(i1.getOffset(),-2);		
		
		
	}

}
