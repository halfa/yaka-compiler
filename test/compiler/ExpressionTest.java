package compiler;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import compiler.Expression;
import compiler.Operator;
import compiler.Type;
import compiler.YVM;
import exception.YakaException;

public class ExpressionTest {

	Expression e;

	@Before
	public void intitialize() {
		e = new Expression(new YVM());
	}

	@Test
	public void testEvaluateArithIntInt() throws YakaException {
		e.pushOp(Operator.MINUS);
		e.pushValue(Type.INTEGER);
		e.pushValue(Type.INTEGER);
		assertEquals(Type.INTEGER, e.syntaxeEvaluation());
	}

	@Test(expected=YakaException.class)
	public void testEvaluateArithBoolInt() throws YakaException {

		e.pushOp(Operator.MINUS);
		e.pushValue(Type.BOOLEAN);
		e.pushValue(Type.INTEGER);
		assertEquals(Type.ERROR, e.syntaxeEvaluation());
	}

	@Test
	public void testEvaluateArithBoolBool() throws YakaException {

		e.pushOp(Operator.MINUS);
		e.pushValue(Type.BOOLEAN);
		e.pushValue(Type.BOOLEAN);
		assertEquals(Type.ERROR, e.syntaxeEvaluation());

	}

	@Test(expected=YakaException.class)
	public void testEvaluateLogicIntInt() throws YakaException {

		e.pushOp(Operator.AND);
		e.pushValue(Type.INTEGER);
		e.pushValue(Type.INTEGER);
		assertEquals(Type.ERROR, e.syntaxeEvaluation());
	}

	@Test
	public void testEvaluateLogicBoolInt() throws YakaException {

		e.pushOp(Operator.AND);
		e.pushValue(Type.BOOLEAN);
		e.pushValue(Type.BOOLEAN);
		assertEquals(Type.BOOLEAN, e.syntaxeEvaluation());
	}

	@Test(expected=YakaException.class)
	public void testEvaluateLogicIntBool() throws YakaException {

		e.pushOp(Operator.AND);
		e.pushValue(Type.INTEGER);
		e.pushValue(Type.BOOLEAN);
		assertEquals(Type.ERROR, e.syntaxeEvaluation());

	}

	@Test(expected=YakaException.class)
	public void testEvaluateCompBoolInt() throws YakaException {

		e.pushOp(Operator.DIFF);
		e.pushValue(Type.BOOLEAN);
		e.pushValue(Type.INTEGER);
		assertEquals(Type.ERROR, e.syntaxeEvaluation());
	}

	@Test
	public void testEvaluateCompBoolBool() throws YakaException {

		e.pushOp(Operator.DIFF);
		e.pushValue(Type.BOOLEAN);
		e.pushValue(Type.BOOLEAN);
		assertEquals(Type.BOOLEAN, e.syntaxeEvaluation());

	}

	@Test
	public void testEvaluateCompIntInt() throws YakaException {

		e.pushOp(Operator.DIFF);
		e.pushValue(Type.INTEGER);
		e.pushValue(Type.INTEGER);
		assertEquals(Type.BOOLEAN, e.syntaxeEvaluation());

	}

}
