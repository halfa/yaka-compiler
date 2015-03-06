import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ExpressionTest {

	Expression e;

	@Before
	public void intitialize() {
		e = new Expression();
	}

	@Test
	public void testEvaluateArithIntInt() {
		e.pushOp(Operator.MINUS);
		e.pushValue(Type.INTEGER);
		e.pushValue(Type.INTEGER);
		assertEquals(Type.INTEGER, e.evaluate());
	}

	@Test
	public void testEvaluateArithBoolInt() {

		e.pushOp(Operator.MINUS);
		e.pushValue(Type.BOOLEAN);
		e.pushValue(Type.INTEGER);
		assertEquals(Type.ERROR, e.evaluate());
	}

	@Test
	public void testEvaluateArithBoolBool() {

		e.pushOp(Operator.MINUS);
		e.pushValue(Type.BOOLEAN);
		e.pushValue(Type.BOOLEAN);
		assertEquals(Type.ERROR, e.evaluate());

	}

	@Test
	public void testEvaluateLogicIntInt() {

		e.pushOp(Operator.AND);
		e.pushValue(Type.INTEGER);
		e.pushValue(Type.INTEGER);
		assertEquals(Type.ERROR, e.evaluate());
	}

	@Test
	public void testEvaluateLogicBoolInt() {

		e.pushOp(Operator.AND);
		e.pushValue(Type.BOOLEAN);
		e.pushValue(Type.BOOLEAN);
		assertEquals(Type.BOOLEAN, e.evaluate());
	}

	@Test
	public void testEvaluateLogicIntBool() {

		e.pushOp(Operator.AND);
		e.pushValue(Type.INTEGER);
		e.pushValue(Type.BOOLEAN);
		assertEquals(Type.ERROR, e.evaluate());

	}

	@Test
	public void testEvaluateCompBoolInt() {

		e.pushOp(Operator.DIFF);
		e.pushValue(Type.BOOLEAN);
		e.pushValue(Type.INTEGER);
		assertEquals(Type.ERROR, e.evaluate());
	}

	@Test
	public void testEvaluateCompBoolBool() {

		e.pushOp(Operator.DIFF);
		e.pushValue(Type.BOOLEAN);
		e.pushValue(Type.BOOLEAN);
		assertEquals(Type.BOOLEAN, e.evaluate());

	}

	@Test
	public void testEvaluateCompIntInt() {

		e.pushOp(Operator.DIFF);
		e.pushValue(Type.INTEGER);
		e.pushValue(Type.INTEGER);
		assertEquals(Type.BOOLEAN, e.evaluate());

	}

}
