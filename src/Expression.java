import java.util.Stack;

public class Expression {

	private static YVM yvm;

	private Stack<Operator> ops;
	private Stack<Type> types;

	public Expression() {
		ops = new Stack<Operator>();
		types = new Stack<Type>();

	}

	/**
	 * Push the value to the different stacks
	 * 
	 * @param i
	 *            : the ident to push
	 */
	public void pushValue(Ident i) {
		Type t = i.getType();
		types.push(t);

		if (t == Type.INTEGER)
			if (i instanceof IdVar)
				yvm.iload(((IdVar) i).getOffset());
			else
				yvm.iconst(((IdConst) i).getVal());// FIXME depends on the way
													// to manage constants
	}

	/**
	 * Push the value to the different stacks
	 * 
	 * @param i
	 *            the integer to push
	 */
	public void pushValue(int i) {
		types.push(Type.INTEGER);
		yvm.iconst(i);
	}

	/**
	 * push the operator to the stack
	 * 
	 * @param o
	 *            the operator
	 */
	public void pushOp(Operator o) {
		ops.push(o);

	}

	/**
	 * only useful for test
	 * 
	 * @param t
	 */
	public void pushValue(Type t) {
		types.push(t);
	}

	/**
	 * syntax test
	 * 
	 * @return the type of expression result
	 */
	public Type syntaxeEvaluation() {
		Type t1 = types.pop();
		Type t2 = types.pop();
		Operator op = ops.pop();
		switch (t1) {
		case INTEGER:
			switch (t2) {
			case INTEGER:
				switch (op) {
				case PLUS:
				case MINUS:
				case DIV:
				case MULT:
					types.push(Type.INTEGER);
					return Type.INTEGER;
				case EGAL:
				case DIFF:
					types.push(Type.BOOLEAN);
					return Type.BOOLEAN;
				default:
					break;
				}
			default:
				types.push(Type.ERROR);
				return Type.ERROR;
			}
		case BOOLEAN:
			switch (t2) {
			case BOOLEAN:
				switch (op) {
				case EGAL:
				case DIFF:
				case AND:
				case OR:
					types.push(Type.BOOLEAN);
					return Type.BOOLEAN;
				default:
					break;
				}
			default:
				break;
			}
		default:
			break;
		}

		ops.push(op);

		types.push(Type.ERROR);
		return Type.ERROR;
	}

	// TODO
	/**
	 * evaluate the expression on the top of the stack
	 * 
	 * @return true if no syntax error
	 */
	public boolean evaluate() {
		Operator op = ops.peek();
		if (syntaxeEvaluation() == Type.ERROR)
			return false;

		switch (op) {
		case PLUS:
			yvm.iadd();
			break;
		case MINUS:
			yvm.isub();
			break;
		case DIV:
			yvm.idiv();
			break;
		case MULT:
			yvm.imul();
			break;
		case EGAL:
			yvm.iegal();
			break;
		case DIFF:
			yvm.idiff();
			break;
		case AND:
			yvm.iand();
			break;
		case OR:
			yvm.ior();
			break;
		default:
			return false;
		}
		return true;
	}

}
