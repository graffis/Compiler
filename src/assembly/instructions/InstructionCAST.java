package assembly.instructions;

public abstract class InstructionCAST extends Instruction {

    InstructionCAST(String reg1, String reg2) {
		super();

		this.dest = reg1;
		this.src1 = reg2;
    }
    
    /**
	 * @return "op dest label(src1)"
	 */
	public String toString() {
		return this.oc + " " + this.dest + ", " + this.src1;
	}
    
}
