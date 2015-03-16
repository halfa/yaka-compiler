package compiler;
import java.util.Stack;

public class Expression {

	private YVM yvm;
	private Stack<Operator> ops;
	private Stack<Type> types;

	public Expression(YVM y) {
		yvm = y;
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
				yvm.iconst(((IdConst) i).getVal());
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
	 * Retourne l'opérateur en haut de la pile des opérateurs
	 * @return opérateur en haut de pile
	 */
	public Operator popOp(){
		return ops.pop();
	}
	
	/**
	 * Retourne la valeur en haut de la pile des types
	 * @return valeur en haut de pile
	 */
	public Type popValue(){
		return types.pop();
	}
	
	/**
	 * Teste l'opérateur en sommet de pile et appelle la fonction associée de YVM
	 * pour un opAdd.
	 */
	public void whatAdd(){
		Operator op = popOp();
		switch (op) {
		case PLUS :
			yvm.iadd();
			break;
		case MINUS : 
			yvm.isub();
			break;
		case OR :
			yvm.ior();
			break;
		default:
			System.err.println("Wrong Operator at the top of the stack, and opAdd is expected");
			break;
		}				
	}
	
	/**
	 * Teste l'opérateur en sommet de pile et appelle la fonction associée de YVM
	 * pour un opMul.
	 */
	public void whatMul(){
		Operator op = popOp();
		switch (op) {
		case MULT :
			yvm.imul();
			break;
		case DIV : 
			yvm.idiv();
			break;
		case AND :
			yvm.iand();
			break;
		default:
			System.err.println("Wrong Operator at the top of the stack, and opMul is expected");
			break;
		}			
	}
	
	/**
	 * Teste l'opérateur en sommet de pile et appelle la fonction associée de YVM
	 * pour un opNeg.
	 */
	public void whatNeg(){
		Operator op = popOp();
		switch (op) {
		case OPP :
			yvm.ineg();
			break;
		case NOT : 
			yvm.inot();
			break;
		default:
			System.err.println("Wrong Operator at the top of the stack, and opNeg is expected");
			break;
		}
	}
	
	/**
	 * Teste l'opérateur en sommet de pile et appelle la fonction associée de YVM
	 * pour un opRel.
	 */
	public void whatRel(){
		Operator op = popOp();
		switch (op) {
		case EGAL :
			yvm.iegal();
			break;
		case DIFF : 
			yvm.idiff();
			break;
		case LOW_STRICT : 
			yvm.iinf();
			break;
		case LOW_EGAL : 
			yvm.iinfegal();
			break;
		case UP_STRICT : 
			yvm.isup();
			break;
		case UP_EGAL : 
			yvm.isupegal();
			break;
		default:
			System.err.println("Wrong Operator at the top of the stack, and opRel is expected");
			break;
		}
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
