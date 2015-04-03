package compiler;

import java.util.List;
import java.util.Stack;

import compiler.IdFun.Parameter;
import exception.UnknownFunctionException;
import exception.UnknownIdentException;
import exception.BadTypeException;
import exception.YakaException;

public class Expression {

	private YVM yvm;
	private Stack<Operator> ops;
	private Stack<Type> types;
	private boolean unaryOperator;
	// Pile d'appel
	private Stack<String> functionCall;

	public Expression(YVM y) {
		yvm = y;
		ops = new Stack<Operator>();
		types = new Stack<Type>();
		functionCall = new Stack<String>();
		unaryOperator = false;
	}
	
	
	/**
	 * Rend le type de la dernière expression évaluée
	 * @return le type de la dernière expression évaluée
	 */
	
	public Type getCurrentType() {
		return types.pop();
	}

	/**
	 * Met la valeur et le type sur le sommet de leur piles respectives
	 * 
	 * @param i l'identifiant de la variable
	 * @throws UnknownIdentException
	 */
	public void pushValue(Ident i) throws UnknownIdentException {
		Type t = i.getType();
		types.push(t);

		/*
		 * if (t == Type.INTEGER) if (i instanceof IdVar) yvm.iload(((IdVar)
		 * i).getOffset()); else if (i instanceof IdConst) yvm.iconst(((IdConst)
		 * i).getVal()); else { throw new UnknownIdentException("" + t); //
		 * FIXME UnknowIdentExeption }
		 */
	}

	/**
	 * Met l'opérateur sur la pile opérateur
	 */
	public void pushOp(Operator o) {
		ops.push(o);
		unaryOperator = (o.equals(Operator.OPP) || o.equals(Operator.NOT));

	}

	/**
	 * Utilisé pour les tests
	 */
	public void pushValue(Type t) {
		types.push(t);
	}

	/**
	 * Retourne l'opérateur en haut de la pile des opérateurs
	 * 
	 * @return opérateur en haut de pile
	 */
	public Operator popOp() {
		return ops.pop();
	}

	/**
	 * Retourne la valeur en haut de la pile des types
	 * 
	 * @return valeur en haut de pile
	 */
	public Type popValue() {
		return types.pop();
	}

	/**
	 * Ajoute une fonction à la pile d'appel. Met également le compteur de
	 * paramètres de la fonction à -1
	 * 
	 * @throws UnknownFunctionException
	 */
	public void pushFunction(String name) throws UnknownFunctionException {
		//System.out.println("Push " + name + " to stack");
		if (TabIdent.existFunction(name)) {
			functionCall.push(name);
		} else {
			throw new exception.UnknownFunctionException(name);
		}
	}

	/**
	 * Retourne le nom de la fonction qui se trouve en haut de la pile.
	 */
	public String popFunction() {
		return functionCall.pop();
	}

	public Type getCurrentFunctionType() throws UnknownFunctionException {
		String name = functionCall.peek();
		if (TabIdent.existFunction(name)) {
			return TabIdent.getFunction(name).getType();
		} else {
			throw new exception.UnknownFunctionException(name);
		}
	}

	/**
	 * Evalue et test la validitée du typage.
	 * 
	 * @return the type of expression result
	 * @throws BadTypeException
	 */
	public Type syntaxeEvaluation() throws BadTypeException {
		Type t1 = types.pop();
		Operator op = ops.pop();
		if (unaryOperator) {
			unaryOperator = false;
			switch (t1) {
			case INTEGER:
				switch (op) {
				case OPP:
					types.push(Type.INTEGER);
					return Type.INTEGER;
				default:
					types.push(Type.ERROR);
					throw new BadTypeException("boolean","integer");
				}
			case BOOLEAN:
				switch (op) {
				case NOT:
					types.push(Type.BOOLEAN);
					return Type.BOOLEAN;

				default:
				}

			default:
				types.push(Type.ERROR);
				throw new BadTypeException("integer","boolean");
			}
		} else {
			Type t2 = types.pop();

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
					case LOW_STRICT:
					case UP_STRICT:
					case LOW_EGAL:
					case UP_EGAL:
						types.push(Type.BOOLEAN);
						return Type.BOOLEAN;
					default:
						break;
					}
				default:
					types.push(Type.ERROR);
					throw new BadTypeException("boolean","integer");
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
			throw new BadTypeException("integer","boolean");

		}

	}

	/**
	 * Evalue l'expression sur le haut de la pile
	 * 
	 * @return true si l'opération se déroule sans erreur
	 * @return false sinon
	 * @throws BadTypeException
	 */
	public boolean evaluate() throws BadTypeException {
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
		case LOW_STRICT:
			yvm.iinf();
			break;
		case UP_STRICT:
			yvm.isup();
			break;
		case LOW_EGAL:
			yvm.iinfegal();
			break;
		case UP_EGAL:
			yvm.isupegal();
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
		case OPP:
			yvm.ineg();
			break;
		case NOT:
			yvm.inot();
			break;
		default:
			return false;
		}
		return true;
	}

	public void clear() {
		System.out.println("***************************\n"+types.size()+"\n"+ops.size()+"\n***************************");
		
	}

	public boolean assertType(Type t) throws BadTypeException {
		Type expected = types.peek();
		if(!t.equals(expected))throw new BadTypeException(expected,t);
		return true;
	}

	public boolean assertAssignementType() throws BadTypeException, UnknownIdentException {
		Type received = types.pop();
		Type t = TabIdent.getIdent(Declaration.getCurrentIdent()).getType();
		
		if(!t.equals(received) && !received.equals(Type.ERROR))throw new BadTypeException(t,received);

		if (received.equals(Type.ERROR))throw new BadTypeException("Evaluation error");

		return true;
	}

	public void checkArgumentType() throws YakaException, UnknownFunctionException {//TODO UnknownFunctionException to remove
		IdFun f = TabIdent.getFunction(functionCall.peek());
		List<Parameter> parameters = f.getParameters();
		for(int e =parameters.size()-1;e>=0;e--){
			Type type = types.pop();
			Type expected = parameters.get(e).getIdent().getType();
			if(!type.equals(expected))throw new BadTypeException(e,type,expected);
		}
		
	}

}
