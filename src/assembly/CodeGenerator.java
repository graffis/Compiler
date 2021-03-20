package assembly;

import java.util.List;

import compiler.Scope.InnerType;
import compiler.Scope.SymbolTableEntry;
import compiler.Scope.Type;
import ast.visitor.AbstractASTVisitor;

import ast.*;
import assembly.instructions.*;
import compiler.Scope;

public class CodeGenerator extends AbstractASTVisitor<CodeObject> {

	int intRegCount;
	int floatRegCount;
	static final public char intTempPrefix = 't';
	static final public char floatTempPrefix = 'f';

	int loopLabel;
	int elseLabel;
	int outLabel;

	String currFunc;

	public CodeGenerator() {
		loopLabel = 0;
		elseLabel = 0;
		outLabel = 0;
		intRegCount = 0;
		floatRegCount = 0;
	}

	public int getIntRegCount() {
		return intRegCount;
	}

	public int getFloatRegCount() {
		return floatRegCount;
	}

	/**
	 * Generate code for Variables
	 *
	 * Create a code object that just holds a variable
	 *
	 * Important: add a pointer from the code object to the symbol table entry
	 *            so we know how to generate code for it later (we'll need to find
	 *            the address)
	 *
	 * Mark the code object as holding a variable, and also as an lval
	 */
	@Override
	protected CodeObject postprocess(VarNode node) {

		Scope.SymbolTableEntry sym = node.getSymbol();

		CodeObject co = new CodeObject(sym);
		co.lval = true;
		co.type = node.getType();

		return co;
	}

	/** Generate code for IntLiterals
	 *
	 * Use load immediate instruction to do this.
	 */
	@Override
	protected CodeObject postprocess(IntLitNode node) {
		CodeObject co = new CodeObject();

		//Load an immediate into a register
		//The li and la instructions are the same, but it's helpful to distinguish
		//for readability purposes.
		//li tmp' value
		Instruction i = new Li(generateTemp(Scope.InnerType.INT), node.getVal());

		co.code.add(i); //add this instruction to the code object
		co.lval = false; //co holds an rval -- data
		co.temp = i.getDest(); //temp is in destination of li
		co.type = node.getType();

		return co;
	}

	/** Generate code for FloatLiteras
	 *
	 * Use load immediate instruction to do this.
	 */
	@Override
	protected CodeObject postprocess(FloatLitNode node) {
		CodeObject co = new CodeObject();

		//Load an immediate into a regisster
		//The li and la instructions are the same, but it's helpful to distinguish
		//for readability purposes.
		//li tmp' value
		Instruction i = new FImm(generateTemp(Scope.InnerType.FLOAT), node.getVal());

		co.code.add(i); //add this instruction to the code object
		co.lval = false; //co holds an rval -- data
		co.temp = i.getDest(); //temp is in destination of li
		co.type = node.getType();

		return co;
	}

	/**
	 * Generate code for binary operations.
	 *
	 * Step 0: create new code object
	 * Step 1: add code from left child
	 * Step 1a: if left child is an lval, add a load to get the data
	 * Step 2: add code from right child
	 * Step 2a: if right child is an lval, add a load to get the data
	 * Step 3: generate binary operation using temps from left and right
	 *
	 * Don't forget to update the temp and lval fields of the code object!
	 * 	   Hint: where is the result stored? Is this data or an address?
	 *
	 */
	@Override
 	protected CodeObject postprocess(BinaryOpNode node, CodeObject left, CodeObject right) {

		CodeObject co = new CodeObject(); // create new code CodeObject

 		// add code from left child
 		assert (left.lval == true);

 		// step 1
 		if (left.lval == true) {
 			left = rvalify(left);
 		}

 		co.code.addAll(left.code);

 		// step 2
 		if (right.lval == true) {
 			right = rvalify(right);
 		}

 		co.code.addAll(right.code);

 		switch (node.getOp()) {
 			case ADD:

				Instruction add = null;
				
 				if (left.getType().toString() == "INT" && right.getType().toString() == "INT")
 				{
					add = new Add(left.temp, right.temp, generateTemp(Scope.InnerType.INT));
					co.type = right.type;
 					
 				}
				else if (left.getType().toString() == "FLOAT" && right.getType().toString() == "INT" )
				{
					CodeObject temporary = new CodeObject();
					temporary = toFloat(right);
					co.code.addAll(temporary.code);
					add = new FAdd(left.temp, temporary.temp, generateTemp(Scope.InnerType.FLOAT));
					co.type = left.type;
				}

				else if (left.getType().toString() == "INT" && right.getType().toString() == "FLOAT")
				{
					CodeObject temporary = new CodeObject();
					temporary = toFloat(left);
					co.code.addAll(temporary.code);
					add = new FAdd(temporary.temp, right.temp, generateTemp(Scope.InnerType.FLOAT));
					co.type = right.type;
				}
				else
				{
					add = new FAdd(left.temp, right.temp, generateTemp(Scope.InnerType.FLOAT));
					co.type = left.type;
				}
				

 				co.code.add(add);
 				co.temp = add.getDest();
 				break;

 			case SUB:

 				Instruction sub;

				if (left.getType().toString() == "INT" && right.getType().toString() == "INT")
 				{
					sub = new Sub(left.temp, right.temp, generateTemp(Scope.InnerType.INT));
					co.type = right.type;
 					
 				}
				else if (left.getType().toString() == "FLOAT" && right.getType().toString() == "INT" )
				{
					CodeObject temporary = new CodeObject();
					temporary = toFloat(right);
					co.code.addAll(temporary.code);
					sub = new FSub(left.temp, temporary.temp, generateTemp(Scope.InnerType.FLOAT));
					co.type = left.type;
				}

				else if (left.getType().toString() == "INT" && right.getType().toString() == "FLOAT")
				{
					CodeObject temporary = new CodeObject();
					temporary = toFloat(left);
					co.code.addAll(temporary.code);
					sub = new FSub(temporary.temp, right.temp, generateTemp(Scope.InnerType.FLOAT));
					co.type = right.type;
				}
				else
				{
					sub = new FSub(left.temp, right.temp, generateTemp(Scope.InnerType.FLOAT));
					co.type = left.type;
				}

 				co.code.add(sub);
 				co.temp = sub.getDest();
 				break;

 			case MUL:
 				Instruction mul;


 				if (left.getType().toString() == "INT" && right.getType().toString() == "INT")
 				{
					mul = new Mul(left.temp, right.temp, generateTemp(Scope.InnerType.INT));
					co.type = right.type;
 					
 				}
				 else if (left.getType().toString() == "FLOAT" && right.getType().toString() == "INT" )
				{
					CodeObject temporary = new CodeObject();
					temporary = toFloat(right);
					co.code.addAll(temporary.code);
					mul = new FMul(left.temp, temporary.temp, generateTemp(Scope.InnerType.FLOAT));
					co.type = left.type;
				}

				else if (left.getType().toString() == "INT" && right.getType().toString() == "FLOAT")
				{
					CodeObject temporary = new CodeObject();
					temporary = toFloat(left);
					co.code.addAll(temporary.code);
					mul = new FMul(temporary.temp, right.temp, generateTemp(Scope.InnerType.FLOAT));
					co.type = right.type;
				}
				else
				{
					mul = new FMul(left.temp, right.temp, generateTemp(Scope.InnerType.FLOAT));
					co.type = left.type;
				}

 				co.code.add(mul);
 				co.temp = mul.getDest();
 				break;

 			case DIV:

 				Instruction div;

 				if (left.getType().toString() == "INT" && right.getType().toString() == "INT")
 				{
					div = new Div(left.temp, right.temp, generateTemp(Scope.InnerType.INT));
					co.type = right.type;
 					
 				}
				else if (left.getType().toString() == "FLOAT" && right.getType().toString() == "INT" )
				{
					CodeObject temporary = new CodeObject();
					temporary = toFloat(right);
					co.code.addAll(temporary.code);
					div = new FDiv(left.temp, temporary.temp, generateTemp(Scope.InnerType.FLOAT));
					co.type = left.type;
				}

				else if (left.getType().toString() == "INT" && right.getType().toString() == "FLOAT")
				{
					CodeObject temporary = new CodeObject();
					temporary = toFloat(left);
					co.code.addAll(temporary.code);
					div = new FDiv(temporary.temp, right.temp, generateTemp(Scope.InnerType.FLOAT));
					co.type = right.type;
				}
				else
				{
					div = new FDiv(left.temp, right.temp, generateTemp(Scope.InnerType.FLOAT));
					co.type = left.type;
				}

 				co.code.add(div);
 				co.temp = div.getDest();
 				break;
 		}

 		co.lval = false;

 		return co;
 	}

	/**
	 * Generate code for unary operations.
	 *
	 * Step 0: create new code object
	 * Step 1: add code from child expression
	 * Step 1a: if child is an lval, add a load to get the data
	 * Step 2: generate instruction to perform unary operation
	 *
	 * Don't forget to update the temp and lval fields of the code object!
	 * 	   Hint: where is the result stored? Is this data or an address?
	 *
	 */
	@Override
 	protected CodeObject postprocess(UnaryOpNode node, CodeObject expr) {


 		CodeObject co = new CodeObject();

 		if (expr.lval == true) {
 			expr = rvalify(expr);
 		}

 		co.code.addAll(expr.code);

 		Instruction neg = new Neg(expr.temp, generateTemp(Scope.InnerType.INT));
 		co.code.add(neg);
 		co.temp = neg.getDest();
 		co.lval = false;

 		return co;
 	}

	/**
	 * Generate code for assignment statements
	 *
	 * Step 0: create new code object
	 * Step 1: if LHS is a variable, generate a load instruction to get the address into a register
	 * Step 1a: add code from LHS of assignment (make sure it results in an lval!)
	 * Step 2: add code from RHS of assignment
	 * Step 2a: if right child is an lval, add a load to get the data
	 * Step 3: generate store
	 *
	 * Hint: it is going to be easiest to just generate a store with a 0 immediate
	 * offset, and the complete store address in a register:
	 *
	 * sw rhs 0(lhs)
	 */
	@Override
	 protected CodeObject postprocess(AssignNode node, CodeObject left,
 			CodeObject right) {
 				CodeObject co = new CodeObject();

			
 				assert(left.lval == true); //left hand side had better hold an address

 				//Step 1a
 				if (left.lval == true && left.isVar())
 				{
					InstructionList varAddr = generateAddrFromVariable_beta(left);
					co.code.addAll(varAddr);
					left.temp = co.code.getLast().getDest();
				}

 				co.code.addAll(left.code);

 				if (right.lval == true)
 				{
 					CodeObject varAddr = rvalify(right);
 					co.code.addAll(varAddr.code);
 					right.temp = varAddr.temp; //set the output of the load as the new temp for left
 				}

				co.code.addAll(right.code);
				 
			
				
				Instruction store;
				if (left.getType().toString() == "FLOAT" && right.getType().toString() == "FLOAT") 				{
					store = new Fsw(right.temp, left.temp, "0");
					co.type = new Scope.Type(InnerType.FLOAT);
				}

				else if (left.getType() .toString() == "INT" && right.getType().toString() == "FLOAT")
				{
					CodeObject temporary = toInt(right);
					co.code.addAll(temporary.code);
					store = new Sw(temporary.temp, left.temp, "0");
					co.type = new Scope.Type(InnerType.INT);
				}
				
				else if (left.getType() .toString() == "FLOAT" && right.getType().toString() == "INT")
				{
					CodeObject temporary = toFloat(right);
					co.code.addAll(temporary.code);
					store = new Fsw(temporary.temp, left.temp, "0");
					co.type = new Scope.Type(InnerType.FLOAT);
			    }
				 
				else
				{
					store = new Sw(right.temp, left.temp, "0");
					co.type = new Scope.Type(InnerType.INT);
				} 
				

 				co.code.add(store);
 				co.lval = false;
				co.temp = left.temp;
				

 				return co;

 	}

	 @Override
	 protected CodeObject postprocess(CastNode node, CodeObject expr)
	 {
		CodeObject co = new CodeObject();

		if (node.getNewType().toString() ==  "INT") {

			if (expr.lval == true)
			{
				expr = rvalify(expr);
			}

			co.code.addAll(expr.code);

			CodeObject move = toInt(expr);
			co.code.addAll(move.code);
			co.temp = move.code.getLast().getDest();
		}

		else if (node.getNewType().toString() ==  "FLOAT")
		{

			if (expr.lval == true)
			{
				expr = rvalify(expr);
			}

			co.code.addAll(expr.code);

			CodeObject move = toFloat(expr);
			co.code.addAll(move.code);
			co.temp = move.code.getLast().getDest();
				
		}

		co.type = node.getNewType();

		return co;
	}

	/**
	 * Add together all the lists of instructions generated by the children
	 */
	@Override
	protected CodeObject postprocess(StatementListNode node, List<CodeObject> statements) {
		CodeObject co = new CodeObject();
		//add the code from each individual statement
		for (CodeObject subcode : statements) {
			co.code.addAll(subcode.code);
		}
		co.type = null; //set to null to trigger errors
		return co;
	}

	/**
	 * Generate code for read
	 *
	 * Step 0: create new code object
	 * Step 1: add code from VarNode (make sure it's an lval)
	 * Step 2: generate GetI instruction, storing into temp
	 * Step 3: generate store, to store temp in variable
	 */
	@Override
	protected CodeObject postprocess(ReadNode node, CodeObject var) {

		//Step 0
		CodeObject co = new CodeObject();

		//Generating code for read(id)
		assert(var.getSTE() != null); //var had better be a variable

		InstructionList il = new InstructionList();
		switch(node.getType().type) {
			case INT:
				//Code to generate if INT:
				//geti tmp
				//if var is global: la tmp', <var>; sw tmp 0(tmp')
				//if var is local: sw tmp offset(fp)
				Instruction geti = new GetI(generateTemp(Scope.InnerType.INT));
				il.add(geti);
				InstructionList store = new InstructionList();
				if (var.getSTE().isLocal()) {
					store.add(new Sw(geti.getDest(), "fp", String.valueOf(var.getSTE().addressToString())));
				} else {
					store.addAll(generateAddrFromVariable_beta(var));
					store.add(new Sw(geti.getDest(), store.getLast().getDest(), "0"));
				}
				il.addAll(store);
				break;
			case FLOAT:
				//Code to generate if FLOAT:
				//getf tmp
				//if var is global: la tmp', <var>; fsw tmp 0(tmp')
				//if var is local: fsw tmp offset(fp)
				Instruction getf = new GetF(generateTemp(Scope.InnerType.FLOAT));
				il.add(getf);
				InstructionList fstore = new InstructionList();
				if (var.getSTE().isLocal()) {
					fstore.add(new Fsw(getf.getDest(), "fp", String.valueOf(var.getSTE().addressToString())));
				} else {
					fstore.addAll(generateAddrFromVariable_beta(var));
					fstore.add(new Fsw(getf.getDest(), fstore.getLast().getDest(), "0"));
				}
				il.addAll(fstore);
				break;
			default:
				throw new Error("Shouldn't read into other variable");
		}

		co.code.addAll(il);

		co.lval = false; //doesn't matter
		co.temp = null; //set to null to trigger errors
		co.type = null; //set to null to trigger errors

		return co;
	}

	/**
	 * Generate code for print
	 *
	 * Step 0: create new code object
	 *
	 * If printing a string:
	 * Step 1: add code from expression to be printed (make sure it's an lval)
	 * Step 2: generate a PutS instruction printing the result of the expression
	 *
	 * If printing an integer:
	 * Step 1: add code from the expression to be printed
	 * Step 1a: if it's an lval, generate a load to get the data
	 * Step 2: Generate PutI that prints the temporary holding the expression
	 */
	@Override
	protected CodeObject postprocess(WriteNode node, CodeObject expr) {
		CodeObject co = new CodeObject();

		//generating code for write(expr)

		//for strings, we expect a variable
		if (node.getWriteExpr().getType().type == Scope.InnerType.STRING) {
			//Step 1:
			assert(expr.getSTE() != null);

			System.out.println("; generating code to print " + expr.getSTE());

			//Get the address of the variable
			InstructionList addrCo = generateAddrFromVariable_beta(expr);
			co.code.addAll(addrCo);

			//Step 2:
			Instruction write = new PutS(addrCo.getLast().getDest());
			co.code.add(write);
		} else {
			//Step 1a:
			//if expr is an lval, load from it
			if (expr.lval == true) {
				expr = rvalify(expr);
			}

			//Step 1:
			co.code.addAll(expr.code);

			//Step 2:
			//if type of writenode is int, use puti, if float, use putf
			Instruction write = null;
			switch(node.getWriteExpr().getType().type) {
			case STRING: throw new Error("Shouldn't have a STRING here");
			case INT:
			case PTR: //should work the same way for pointers
				write = new PutI(expr.temp); break;
			case FLOAT: write = new PutF(expr.temp); break;
			default: throw new Error("WriteNode has a weird type");
			}

			co.code.add(write);
		}

		co.lval = false; //doesn't matter
		co.temp = null; //set to null to trigger errors
		co.type = null; //set to null to trigger errors

		return co;
	}

	/**
	 * FILL IN FROM STEP 3
	 *
	 * Generating an instruction sequence for a conditional expression
	 *
	 * Implement this however you like. One suggestion:
	 *
	 * Create the code for the left and right side of the conditional, but defer
	 * generating the branch until you process IfStatementNode or WhileNode (since you
	 * do not know the labels yet). Modify CodeObject so you can save the necessary
	 * information to generate the branch instruction in IfStatementNode or WhileNode
	 *
	 * Alternate idea 1:
	 *
	 * Don't do anything as part of CodeGenerator. Create a new visitor class
	 * that you invoke *within* your processing of IfStatementNode or WhileNode
	 *
	 * Alternate idea 2:
	 *
	 * Create the branch instruction in this function, then tweak it as necessary in
	 * IfStatementNode or WhileNode
	 *
	 * Hint: you may need to preserve extra information in the returned CodeObject to
	 * make sure you know the type of branch code to generate (int vs float)
	 */
	@Override
 	protected CodeObject postprocess(CondNode node, CodeObject left, CodeObject right) {
 		CodeObject co = new CodeObject();

 		co.branch_type = node.getReversedOp();
 		co.branchScope = left.type;

 		if (left.lval == true)
 		{
 			CodeObject temp = rvalify(left);
 			left.temp = temp.temp;
 			co.code.addAll(temp.code);
 		}

 		co.code.addAll(left.code);

 		if (right.lval == true)
 		{
 			CodeObject temp = rvalify(right);
 			right.temp = temp.temp;
 			co.code.addAll(temp.code);
 		}

 		co.code.addAll(right.code);

 		co.leftTemp = left.temp;
 		co.rightTemp = right.temp;

 		return co;
 	}

	/**
	 * FILL IN FROM STEP 3
	 *
	 * Step 0: Create code object
	 *
	 * Step 1: generate labels
	 *
	 * Step 2: add code from conditional expression
	 *
	 * Step 3: create branch statement (if not created as part of step 2)
	 * 			don't forget to generate correct branch based on type
	 *
	 * Step 4: generate code
	 * 		<cond code>
	 *		<flipped branch> elseLabel
	 *		<then code>
	 *		j outLabel
	 *		elseLabel:
	 *		<else code>
	 *		outLabel:
	 *
	 * Step 5 insert code into code object in appropriate order.
	 */
	@Override
 	protected CodeObject postprocess(IfStatementNode node, CodeObject cond, CodeObject tlist, CodeObject elist) {
 		CodeObject co = new CodeObject();
 		Scope.Type loopType = cond.branchScope; //float or integer comparison
 		CondNode.OpType branchOP = cond.branch_type;
 		Instruction floatComparator;
 		Instruction compareZero;

 		co.code.addAll(cond.code);
 		String output = generateOutLabel(); //string for output location

 		if (loopType.type == Scope.InnerType.FLOAT)
 		{
 			switch(branchOP)
 			{
 				case EQ:
 					floatComparator = new Feq(cond.leftTemp, cond.rightTemp, generateTemp(Scope.InnerType.INT));
 					break;
 				case GE:
 					floatComparator = new Fle(cond.rightTemp, cond.leftTemp, generateTemp(Scope.InnerType.INT));
 					break;
 				case GT:
 					floatComparator = new Flt(cond.rightTemp, cond.leftTemp, generateTemp(Scope.InnerType.INT));
 					break;
 				case LE:
 					floatComparator = new Fle(cond.leftTemp, cond.rightTemp, generateTemp(Scope.InnerType.INT));
 					break;
 				case LT:
 					floatComparator = new Flt(cond.leftTemp, cond.rightTemp, generateTemp(Scope.InnerType.INT));
 					break;
 				case NE:
					 floatComparator = new Feq(cond.leftTemp, cond.rightTemp, generateTemp(Scope.InnerType.INT));
 					break;
 				default:
 					throw new Error ("Bad op type");
 			}

 			co.code.add(floatComparator);

 			if (elist == null) //just if statement
 			{
 				if (branchOP  == CondNode.OpType.NE)
 				{

 					compareZero = new Beq(floatComparator.getDest(), "x0", output);
 				}
 				else
 				{

 					compareZero = new Bne(floatComparator.getDest(), "x0", output);
 				}

 				co.code.add(compareZero);
 				co.code.addAll(tlist.code);
 				Instruction labOut = new Label(output);
 				co.code.add(labOut);
 				co.temp = tlist.temp;
 			}

 			else
 			{
 				//else block present
 				String elseLabel_temp = generateElseLabel();

 				if (branchOP  == CondNode.OpType.NE)
 				{
 					compareZero = new Beq(floatComparator.getDest(), "x0", elseLabel_temp);
 				}
 				else
 				{
 					compareZero = new Bne(floatComparator.getDest(), "x0", elseLabel_temp);
 				}

 				co.code.add(compareZero);
 				co.code.addAll(tlist.code);
 				Instruction branch = new J(output);
 				co.code.add(branch);
 				Instruction labElse = new Label(elseLabel_temp);
 				co.code.add(labElse);
 				co.code.addAll(elist.code);
 				Instruction labOut = new Label(output);
 				co.code.add(labOut);

 				co.temp = elist.temp;

 			}

 			//nested if/else
 			//if else is null
 		}

 		else if (loopType.type == Scope.InnerType.INT)
 		{

 			if (elist == null)
 			{
 				switch(branchOP)
 				{
 				case EQ:
 					floatComparator = new Beq(cond.leftTemp, cond.rightTemp, output);
 					break;
 				case GE:
 					floatComparator = new Bge(cond.leftTemp, cond.rightTemp, output);
 					break;
 				case GT:
 					floatComparator = new Bgt(cond.leftTemp, cond.rightTemp, output);
 					break;
 				case LE:
 					floatComparator = new Ble(cond.leftTemp, cond.rightTemp, output);
 					break;
 				case LT:
 					floatComparator = new Blt(cond.leftTemp, cond.rightTemp, output);
 					break;
 				case NE:
 					floatComparator = new Bne(cond.leftTemp, cond.rightTemp, output);
 					break;
 				default:
 					throw new Error ("Bad op type");
 				}

 				co.code.add(floatComparator);
 				co.code.addAll(tlist.code);
 				Instruction labOut = new Label(output);
 				co.code.add(labOut);
 				co.temp = tlist.temp;
 			}

 			else //if else statement present
 			{
 				String elseLabel_temp = generateElseLabel();

 				switch(branchOP)
 				{
 				case EQ:
 					floatComparator = new Beq(cond.leftTemp, cond.rightTemp, elseLabel_temp);
 					break;
 				case GE:
 					floatComparator = new Bge(cond.leftTemp, cond.rightTemp, elseLabel_temp);
 					break;
 				case GT:
 					floatComparator = new Bgt(cond.leftTemp, cond.rightTemp, elseLabel_temp);
 					break;
 				case LE:
 					floatComparator = new Ble(cond.leftTemp, cond.rightTemp, elseLabel_temp);
 					break;
 				case LT:
 					floatComparator = new Blt(cond.leftTemp, cond.rightTemp, elseLabel_temp);
 					break;
 				case NE:
 					floatComparator = new Bne(cond.leftTemp, cond.rightTemp, elseLabel_temp);
 					break;
 				default:
 					throw new Error ("Bad op type");
 				}

 				co.code.add(floatComparator);
 				co.code.addAll(tlist.code);
 				Instruction branch = new J(output);
 				co.code.add(branch);
 				Instruction labElse = new Label(elseLabel_temp);
 				co.code.add(labElse);
 				co.code.addAll(elist.code);
 				Instruction labOut = new Label(output);
 				co.code.add(labOut);
 				co.temp = elist.temp;
 			}

 		}



 		return co;
 	}

		/**
	 * FILL IN FROM STEP 3
	 *
	 * Step 0: Create code object
	 *
	 * Step 1: generate labels
	 *
	 * Step 2: add code from conditional expression
	 *
	 * Step 3: create branch statement (if not created as part of step 2)
	 * 			don't forget to generate correct branch based on type
	 *
	 * Step 4: generate code
	 * 		loopLabel:
	 *		<cond code>
	 *		<flipped branch> outLabel
	 *		<body code>
	 *		j loopLabel
	 *		outLabel:
	 *
	 * Step 5 insert code into code object in appropriate order.
	 */
	@Override
 	protected CodeObject postprocess(WhileNode node, CodeObject cond, CodeObject slist) {
 		//Step 0:
 		CodeObject co = new CodeObject();

 		String loopLab = generateLoopLabel();
 		Scope.Type loopType = cond.branchScope; //float or integer comparison
 		CondNode.OpType branchOP = cond.branch_type;
 		Instruction floatComparator;
 		Instruction compareZero;
 		String output = generateOutLabel();

 		co.code.add(new Label(loopLab));
 		co.code.addAll(cond.code);


 		if (loopType.type == Scope.InnerType.FLOAT)
 		{
 			switch(branchOP)
 			{
 				case EQ:
 					floatComparator = new Feq(cond.leftTemp, cond.rightTemp, generateTemp(Scope.InnerType.INT));
 					break;
 				case GE:
 					floatComparator = new Fle(cond.rightTemp, cond.leftTemp, generateTemp(Scope.InnerType.INT));
 					break;
 				case GT:
 					floatComparator = new Flt(cond.rightTemp, cond.leftTemp, generateTemp(Scope.InnerType.INT));
 					break;
 				case LE:
 					floatComparator = new Fle(cond.leftTemp, cond.rightTemp, generateTemp(Scope.InnerType.INT));
 					break;
 				case LT:
 					floatComparator = new Flt(cond.leftTemp, cond.rightTemp, generateTemp(Scope.InnerType.INT));
 					break;
 				case NE:
 					floatComparator = new Feq(cond.leftTemp, cond.rightTemp, generateTemp(Scope.InnerType.INT));
 					break;
 				default:
 					throw new Error ("Bad op type");
 			}

 			co.code.add(floatComparator);

 			if (branchOP  == CondNode.OpType.NE)
 			{
 				compareZero = new Beq(floatComparator.getDest(), "x0", output);
 			}
 			else
 			{
 				compareZero = new Bne(floatComparator.getDest(), "x0", output);
 			}

 			co.code.add(compareZero);
 			co.code.addAll(slist.code);
 			Instruction branch = new J(loopLab);
 			co.code.add(branch);
 			Instruction labOut = new Label(output);
 			co.code.add(labOut);
 			co.temp = slist.temp;

 			//nested if/else
 			//if else is null
 		}

 		else
 		{
 			switch(branchOP)
 			{
 				case EQ:
 					floatComparator = new Beq(cond.leftTemp, cond.rightTemp, output);
 					break;
 				case GE:
 					floatComparator = new Bge(cond.leftTemp, cond.rightTemp, output);
 					break;
 				case GT:
 					floatComparator = new Bgt(cond.leftTemp, cond.rightTemp, output);
 					break;
 				case LE:
 					floatComparator = new Ble(cond.leftTemp, cond.rightTemp, output);
 					break;
 				case LT:
 					floatComparator = new Blt(cond.leftTemp, cond.rightTemp, output);
 					break;
 				case NE:
 					floatComparator = new Bne(cond.leftTemp, cond.rightTemp, output);
 					break;
 				default:
 					throw new Error ("Bad op type");
 				}

 				co.code.add(floatComparator);
 				co.code.addAll(slist.code);
 				Instruction branch = new J(loopLab);
 				co.code.add(branch);
 				Instruction labOut = new Label(output);
 				co.code.add(labOut);
 				co.temp = slist.temp;


 		}
 		return co;

 	}

	/**
	 * FILL IN FOR STEP 4
	 *
	 * Generating code for returns
	 *
	 * Step 0: Generate new code object
	 *
	 * Step 1: Add retExpr code to code object (rvalify if necessary)
	 *
	 * Step 2: Store result of retExpr in appropriate place on stack (fp + 8)
	 *
	 * Step 3: Jump to out label (use @link{generateFunctionOutLabel()})
	 */
	@Override
 	protected CodeObject postprocess(ReturnNode node, CodeObject retExpr) {
 		CodeObject co = new CodeObject();

		if (retExpr != null)
		{
			if (retExpr.lval == true)
			{
				CodeObject temp = rvalify(retExpr);
				co.code.addAll(temp.code);
				retExpr.temp = temp.temp;
			}

			co.code.addAll(retExpr.code);
			co.temp = retExpr.temp;
			Instruction storeResult;

			if (node.getRetExpr().getType().type == Scope.InnerType.FLOAT)
			{ 
				storeResult = new Fsw(co.temp, "fp", "8");
			}
			else
			{
				storeResult = new Sw(co.temp, "fp", "8");
			}

			co.code.add(storeResult);

			co.lval = false;
		}

 		return co;
 	}

	@Override
	protected void preprocess(FunctionNode node) {
		// Generate function label information, used for other labels inside function
		currFunc = node.getFuncName();

		//reset register counts; each function uses new registers!
		intRegCount = 0;
		floatRegCount = 0;
	}

	/**
	 * FILL IN FOR STEP 4
	 *
	 * Generate code for functions
	 *
	 * Step 1: add the label for the beginning of the function
	 *
	 * Step 2: manage frame  pointer
	 * 			a. Save old frame pointer
	 * 			b. Move frame pointer to point to base of activation record (current sp)
	 * 			c. Update stack pointer
	 *
	 * Step 3: allocate new stack frame (use scope infromation from FunctionNode)
	 *
	 * Step 4: save registers on stack (Can inspect intRegCount and floatRegCount to know what to save)
	 *
	 * Step 5: add the code from the function body
	 *
	 * Step 6: add post-processing code:
	 * 			a. Label for `return` statements inside function body to jump to
	 * 			b. Restore registers
	 * 			c. Deallocate stack frame (set stack pointer to frame pointer)
	 * 			d. Reset fp to old location
	 * 			e. Return from function
	 */
	@Override
 	protected CodeObject postprocess(FunctionNode node, CodeObject body) {
 		CodeObject co = new CodeObject();

 		Instruction func_label = new Label(generateFunctionLabel(node.getFuncName()));
 		co.code.add(func_label);

 		//manage frame pointer
 		// -- save old frame pointer
 		Instruction save_fp = new Sw("fp", "sp", "0");
 		co.code.add(save_fp);

 		// -- move frame pointer to point to current sp
 		Instruction move = new Mv("sp", "fp");
 		co.code.add(move);

 		// -- update stack pointer
 		Instruction push = new Addi("sp", "-4", "sp");
 		co.code.add(push);

 		int numLocals = node.getScope().getNumLocals();
 		String spaceNeeded = Integer.toString(numLocals * 4);

 		Instruction push2 = new Addi("sp", "-" + spaceNeeded, "sp");
 		co.code.add(push2);

 		// allocate new stack frame
 		for (int i = 1; i <= intRegCount; i++)
 		{
 			Instruction store = new Sw("t" + i, "sp", "0");
 			Instruction add = new Addi("sp", "-4", "sp");
 			co.code.add(store);
 			co.code.add(add);
 		}

 		// allocate new stack frame
 		for (int j = 1; j <= floatRegCount; j++)
 		{
 			Instruction store = new Fsw("f" + j, "sp", "0");
 			Instruction add = new Addi("sp", "-4", "sp");
 			co.code.add(store);
 			co.code.add(add);

 		}

 		//add code from body
 		co.code.addAll(body.code);

 		//insert jump statement
 		Instruction jump_Ret = new J(generateFunctionOutLabel());
 		co.code.add(jump_Ret);

 		//insert return function
 		Instruction ret_val = new Label(generateFunctionOutLabel());
 		co.code.add(ret_val);

 		for (int j = floatRegCount; j > 0; j--)
 		{
 			Instruction add = new Addi("sp", "4", "sp");
 			Instruction store = new Flw("f" + j, "sp", "0");
 			co.code.add(add);
 			co.code.add(store);
 		}

 		//restore registers
 		for (int i = intRegCount; i > 0; i--)
 		{
 			Instruction add = new Addi("sp", "4", "sp");
 			Instruction store = new Lw("t" + i, "sp", "0");
 			co.code.add(add);
 			co.code.add(store);
 		}

 		Instruction move_Ret = new Mv("fp", "sp");
 		co.code.add(move_Ret);

 		Instruction load_return = new Lw("fp", "fp", "0");
 		co.code.add(load_return);



 		Instruction return_Label = new Ret();
 		co.code.add(return_Label);

 		return co;
 	}

	/**
	 * Generate code for the list of functions. This is the "top level" code generation function
	 *
	 * Step 1: Set fp to point to sp
	 *
	 * Step 2: Insert a JR to main
	 *
	 * Step 3: Insert a HALT
	 *
	 * Step 4: Include all the code of the functions
	 */
	@Override
	protected CodeObject postprocess(FunctionListNode node, List<CodeObject> funcs) {
		CodeObject co = new CodeObject();

		co.code.add(new Mv("sp", "fp"));
		co.code.add(new Jr(generateFunctionLabel("main")));
		co.code.add(new Halt());
		co.code.add(new Blank());

		//add code for each of the functions
		for (CodeObject c : funcs) {
			co.code.addAll(c.code);
			co.code.add(new Blank());
		}

		return co;
	}

	/**
	*
	* FILL IN FOR STEP 4
	*
	* Generate code for a call expression
	 *
	 * Step 1: For each argument:
	 *
	 * 	Step 1a: insert code of argument (don't forget to rvalify!)
	 *
	 * 	Step 1b: push result of argument onto stack
	 *
	 * Step 2: alloate space for return value
	 *
	 * Step 3: push current return address onto stack
	 *
	 * Step 4: jump to function
	 *
	 * Step 5: pop return address back from stack
	 *
	 * Step 6: pop return value into fresh temporary (destination of call expression)
	 *
	 * Step 7: remove arguments from stack (move sp)
	 *
	 * Add special handling for malloc and free
	 */

	 /**
	  * FOR STEP 6: Make sure to handle VOID functions properly
	  */
		@Override
		protected CodeObject postprocess(CallNode node, List<CodeObject> args) {

			//STEP 0
			CodeObject co = new CodeObject();

			Instruction store_variable_onto_stack = null;

			//iterate through each argument
			for (CodeObject arg: args)
			{
				if(arg.lval == true)
				{
					CodeObject vessel_for_arg_variable = rvalify(arg);
					co.code.addAll(vessel_for_arg_variable.code);//loads address of argument, always lco(?)

					if (arg.getType().type == Scope.InnerType.INT || arg.getType().type == Scope.InnerType.PTR)
					{
						store_variable_onto_stack = new Sw(vessel_for_arg_variable.code.getLast().getDest(), "sp", "0");
					}
					else
					{
						store_variable_onto_stack = new Fsw(vessel_for_arg_variable.code.getLast().getDest(), "sp", "0");
					}

					co.code.add(store_variable_onto_stack);

				}

				else
				{
					co.code.addAll(arg.code);
					store_variable_onto_stack = new Sw(arg.temp, "sp", "0");
					co.code.add(store_variable_onto_stack);
				}

				Instruction increase_stack_pointer = new Addi("sp", "-4", "sp");
				co.code.add(increase_stack_pointer);
			}

			//allocate space for return

			Instruction ret = new Addi("sp", "-4", "sp");
			co.code.add(ret);
			

			//push return address onto stack
			Instruction save_Return = new Sw("ra", "sp", "0");
			co.code.add(save_Return);

			Instruction off_ret = new Addi("sp", "-4", "sp");
			co.code.add(off_ret);

			//jump to function
			Instruction jump = new Jr(generateFunctionLabel(node.getFuncName()));
			co.code.add(jump);

			//pop return address back form stack
			Instruction pop_RA = new Addi("sp", "4", "sp");
			co.code.add(pop_RA);
			Instruction load_RA = new Lw("ra", "sp", "0"); //zero offset since already accounted for with Addi instruction
			co.code.add(load_RA);

			// pop return value


			Instruction pop_RV = new Addi("sp", "4", "sp");
			co.code.add(pop_RV);


			// load return value based off type
			Instruction load_RV;
			if (node.getType().type == Scope.InnerType.INT)
			{
				load_RV = new Lw(generateTemp(Scope.InnerType.INT), "sp", "0");
				co.code.add(load_RV);
				co.temp = load_RV.getDest();
			}
			else if (node.getType().type == Scope.InnerType.FLOAT)
			{
				load_RV = new Flw(generateTemp(Scope.InnerType.FLOAT), "sp", "0");
				co.code.add(load_RV);
				co.temp = load_RV.getDest();
			}
			else if (node.getType().type == Scope.InnerType.PTR)
			{
				load_RV = new Lw(generateTemp(Scope.InnerType.INT), "sp", "0");
				co.code.add(load_RV);
				co.temp = load_RV.getDest();
			}

			int numLocals = node.getArgs().size();
			String spaceNeeded = Integer.toString(numLocals * 4);
			Instruction pop = new Addi("sp", spaceNeeded, "sp");
			co.code.add(pop);

			co.lval = false;

			return co;
		}

	/**
	 * Generate code for * (expr)
	 *
	 * Goal: convert the r-val coming from expr (a computed address) into an l-val (an address that can be loaded/stored)
	 *
	 * Step 0: Create new code object
	 *
	 * Step 1: Rvalify expr if needed
	 *
	 * Step 2: Copy code from expr (including any rvalification) into new code object
	 *
	 * Step 3: New code object has same temporary as old code, but now is marked as an l-val
	 *
	 * Step 4: New code object has an "unwrapped" type: if type of expr is * T, type of temporary is T. Can get this from node
	 */
	@Override
	protected CodeObject postprocess(PtrDerefNode node, CodeObject expr) {

		CodeObject co = new CodeObject();
		CodeObject temp = null;

		if (expr.lval == true)
		{
			temp = rvalify(expr);
			co.code.addAll(temp.code);
			co.temp = temp.temp;
		}
		else
		{
			co.code.addAll(expr.code);
			co.temp = expr.temp;
		}

		co.lval = true;

		co.type =  new Scope.Type(node.getType().type); //null exception
		
		return co;
	}

	/**s
	 * Generate code for a & (expr)
	 *
	 * Goal: convert the lval coming from expr (an address) to an r-val (a piece of data that can be used)
	 *
	 * Step 0: Create new code object
	 *
	 * Step 1: If lval coming from expr is a variable, generate code to put address into a register (e.g., generateAddressFromVar)
	 *			Otherwise just copy code from other code object
	 *
	 * Step 2: New code object has same temporary as existing code, but is an r-val
	 *
	 * Step 3: New code object has a "wrapped" type. If type of expr is T, type of temporary is *T. Can get this from node
	 */
	@Override
	protected CodeObject postprocess(AddrOfNode node, CodeObject expr) {

		CodeObject co = new CodeObject();

		if (expr.isVar())
		{
			InstructionList il = generateAddrFromVariable_beta(expr);
			co.code.addAll(il);
			co.temp = il.getLast().getDest();
		}

		else
		{
			co.code.addAll(expr.code);
			co.temp = expr.temp;
		}

		co.lval = false;
		Scope.Type T = node.getType().getWrappedType();
		co.type = T;

		return co;
	}

	/**
	 * Generate code for malloc
	 *
	 * Step 0: Create new code object
	 *
	 * Step 1: Add code from expression (rvalify if needed)
	 *
	 * Step 2: Create new MALLOC instruction
	 *
	 * Step 3: Set code object type to INFER
	 */
	@Override
	protected CodeObject postprocess(MallocNode node, CodeObject expr) {

		CodeObject co = new CodeObject();

		if (expr.lval)
		{
			CodeObject tmp = rvalify(expr);
			co.code.addAll(tmp.code);
			co.temp = tmp.temp;
		}
		else
		{
			co.code.addAll(expr.code);
			co.temp = expr.temp;
		}
		
		String dest = generateTemp(node.getArg().getType().type);

		Instruction mallc = new Malloc(co.temp, dest);
		co.code.add(mallc);

		co.type = new Scope.Type(InnerType.INFER);
		co.temp = dest;

		return co;
	}

	/**
	 * Generate code for free
	 *
	 * Step 0: Create new code object
	 *
	 * Step 1: Add code from expression (rvalify if needed)
	 *
	 * Step 2: Create new FREE instruction
	 */
	@Override
	protected CodeObject postprocess(FreeNode node, CodeObject expr) {
		
		CodeObject co = new CodeObject();

		if (expr.lval)
		{
			CodeObject tmp = rvalify(expr);
			co.code.addAll(tmp.code);
			co.temp = tmp.temp;
		}
		else
		{
			co.code.addAll(expr.code);
			co.temp = expr.temp;
		}

		Instruction free = new Free(co.temp);
		co.code.add(free);

		return co;
	}

	/**
	 * Generate a fresh temporary
	 *
	 * @return new temporary register name
	 */
	protected String generateTemp(Scope.InnerType t) {
		switch(t) {
			case INT:
			case PTR: //works the same for pointers
				return intTempPrefix + String.valueOf(++intRegCount);
			case FLOAT: return floatTempPrefix + String.valueOf(++floatRegCount);
			default: throw new Error("Generating temp for bad type");
		}
	}

	protected String generateLoopLabel() {
		return "loop_" + String.valueOf(++loopLabel);
	}

	protected String generateElseLabel() {
		return  "else_" + String.valueOf(++elseLabel);
	}

	protected String generateOutLabel() {
		return "out_" +  String.valueOf(++outLabel);
	}

	protected String generateFunctionLabel() {
		return "func_" + currFunc;
	}

	protected String generateFunctionLabel(String func) {
		return "func_" + func;
	}

	protected String generateFunctionOutLabel() {
		return "func_ret_" + currFunc;
	}

	/**
	 * Take a code object that results in an lval, and create a new code
	 * object that adds a load to generate the rval.
	 *
	 * @param lco The code object resulting in an address
	 * @return A code object with all the code of <code>lco</code> followed by a load
	 *         to generate an rval
	 */
	 protected CodeObject rvalify(CodeObject lco) {

 		CodeObject co = new CodeObject();

 		/* 		   Step 1: Add all the lco code to the new code object
 		* 		   (If lco is just a variable, create a new code object that
 		*          stores the address of variable in a code object; see
 		*          generateAddrFromVariable)
 		*/

 		InstructionList varAddr = null; //CodeObject holding register of variable
		Instruction loadOffset = null;
		 
		if (lco.isVar() == false)
		{
			co.code.addAll(lco.code);

			if (lco.getType().type == Scope.InnerType.INT || lco.getType().type == InnerType.PTR)
			{
				loadOffset = new Lw(generateTemp(Scope.InnerType.INT), lco.temp, "0");
			}
			else
			{
				loadOffset = new Flw(generateTemp(Scope.InnerType.FLOAT), lco.temp, "0");
			}

			co.code.add(loadOffset);
			co.temp = loadOffset.getDest();
			
		}

		else if (lco.getType().type == InnerType.PTR)
		{
			co.code.addAll(lco.code);

			loadOffset = new Lw(generateTemp(Scope.InnerType.INT), "fp", Integer.toString(lco.getSTE().getAddress()));

			co.code.add(loadOffset);
			co.temp = loadOffset.getDest();
		}

 		else if (lco.getType().type == Scope.InnerType.INT)
 		{
			varAddr = generateAddrFromVariable_beta(lco);
			loadOffset = new Lw(generateTemp(Scope.InnerType.INT), varAddr.getLast().getDest(), "0");
			co.code.addAll(varAddr);
			co.code.add(loadOffset);
			lco.temp = co.code.getLast().getDest();
			co.temp = lco.temp;
 		}
 		else if (lco.getType().type == Scope.InnerType.FLOAT)
 		{
			varAddr = generateAddrFromVariable_beta(lco);
			loadOffset = new Flw(generateTemp(Scope.InnerType.FLOAT), varAddr.getLast().getDest(), "0");
			co.code.addAll(varAddr);
			co.code.add(loadOffset);
			lco.temp = co.code.getLast().getDest();
			co.temp = lco.temp;
		}
 		

 		/*		  Step 2: Generate a load to load from lco's temp into a new temporary
 		* 		   Hint: it'll be easiest to generate a load with no offset:
 		* 				lw newtemp 0(oldtemp)
 		*         Don't forget to generate the right kind of load based on the type
 		*         stored in the address
 		*/
		co.lval = false;
		co.type = lco.getType();

 		/* FILL IN FOR STEP 2 */

 		return co;
 	}

	/**
	 * Generate an instruction sequence that holds the address of the variable in a code object
	 *
	 * If it's a global variable, just get the address from the symbol table
	 *
	 * If it's a local variable, compute the address relative to the frame pointer (fp)
	 *
	 * @param lco The code object holding a variable
	 * @return a list of instructions that puts the address of the variable in a register
	 */
	private InstructionList generateAddrFromVariable_beta(CodeObject lco) {

		InstructionList il = new InstructionList();

		//Step 1:
		SymbolTableEntry symbol = lco.getSTE();
		Instruction compAddr = null;
		
		if (symbol.isLocal()) {
			//If local, address is offset
			//need to load fp + offset
			//addi tmp' fp offset
			
			String address = symbol.addressToString();
			compAddr = new Addi("fp", address, generateTemp(Scope.InnerType.INT));
			il.add(compAddr); //add instruction to code object
		} 
		else
		{
			//If global, address in symbol table is the right location
			//la tmp' addr //Register type needs to be an int
			String address = symbol.addressToString();
			compAddr = new La(generateTemp(Scope.InnerType.INT), address);
			il.add(compAddr); //add instruction to code object
		}
		

		return il;
	}

	private CodeObject toInt(CodeObject floatExpr)
	{
		CodeObject co = new CodeObject();

		Instruction move = new FMOVI(floatExpr.temp, generateTemp(InnerType.INT));
		co.code.add(move);
		co.temp = move.getDest();
		return co;
	}

	private CodeObject toFloat(CodeObject intExpr)
	{
		CodeObject co = new CodeObject();

		Instruction move = new IMOVF(intExpr.temp, generateTemp(InnerType.FLOAT));
		co.code.add(move);
		co.temp = move.getDest();
		return co;
	}

}