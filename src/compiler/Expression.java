package compiler;
import java.util.Stack;

import exception.UnknownIdentException;
import exception.YakaException;

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
	 * Met la valeur et le type sur le sommet de leur piles respectives 
	 * @param i l'identifiant de la variable
	 * @throws UnknownIdentException 
	 */
	public void pushValue(Ident i) throws UnknownIdentException {
		Type t = i.getType();
		types.push(t);

		if (t == Type.INTEGER)
			if (i instanceof IdVar)
				yvm.iload(((IdVar) i).getOffset());
			else if (i instanceof IdConst)
				yvm.iconst(((IdConst) i).getVal());
			else {
				throw new UnknownIdentException(""+t);
				// FIXME UnknowIdentExeption
			}
	}
	/**
	 * Met l'opérateur sur la pile opérateur
	 */
	public void pushOp(Operator o) {
		ops.push(o);

	}

	/**
	 * Utilisé pour les tests
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
	 * Teste l'opérateur en sommet de pile et appelle la fonction associée de YVM pour un opAdd.
	 * @throws YakaException 
	 */
	public void whatAdd() throws YakaException{
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
			throw new YakaException("Wrong Operator at the top of the stack, and opAdd is expected");
		}				
	}
	
	/**
	 * Teste l'opérateur en sommet de pile et appelle la fonction associée de YVM pour un opMul.
	 * @throws YakaException 
	 */
	public void whatMul() throws YakaException{
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
			throw new YakaException("Wrong Operator at the top of the stack, and opMul is expected");
		}			
	}
	
	/**
	 * Teste l'opérateur en sommet de pile et appelle la fonction associée de YVM pour un opNeg.
	 * @throws YakaException 
	 */
	public void whatNeg() throws YakaException{
		Operator op = popOp();
		switch (op) {
		case OPP :
			yvm.ineg();
			break;
		case NOT : 
			yvm.inot();
			break;
		default:
			throw new YakaException("Wrong Operator at the top of the stack, and opNeg is expected");
		}
	}
	
	/**
	 * Teste l'opérateur en sommet de pile et appelle la fonction associée de YVM pour un opRel.
	 * @throws YakaException 
	 */
	public void whatRel() throws YakaException{
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
			throw new YakaException("Wrong Operator at the top of the stack, and opRel is expected");
		}
	}

	/**
	 * Evalue et test la validitée du typage.
	 * @return the type of expression result
	 * @throws YakaException 
	 */
	public Type syntaxeEvaluation() throws YakaException {
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
				throw new YakaException("Error in expression: use of boolean operator on an integer");
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
		/* aucun cas ne correspond */
		
		types.push(Type.ERROR);
		throw new YakaException ("Error in expression: use of integer operator on a boolean");
	}


	/**
	 * Evalue l'expression sur le haut de la pile
	 * @return true si l'opération se déroule sans erreur
	 * @return false sinon
	 * @throws YakaException 
	 */
	public boolean evaluate() throws YakaException {
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
