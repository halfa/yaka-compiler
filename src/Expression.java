import java.util.Stack;

public class Expression {

	private Stack<Operator> ops;
	private Stack<Type> types;

	public Expression() {
		ops = new Stack<Operator>();
		types = new Stack<Type>();

	}

	public void pushValue(Ident i) {
		types.push(i.getType());
	}

	public void pushOp(Operator c) {
		ops.push(c);

	}

	public Type evaluate() {
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
				break;
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

		types.push(Type.ERROR);
		return Type.ERROR;
	}
}
