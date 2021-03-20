package assembly.instructions;

/**
 * Class corresponding to RISC-V instruction IMOVF.S
 * 
 * Models IMOVF.S dest src # dest = Float, src = int
 */

public class IMOVF extends InstructionCAST {

    /**
     * Initializes SW instruction that prints SW src offset(baseAddress)
     * 
     * @param src source operand
     * @param baseAddress register holding base address
     * @param offset immediate holding address offset
     */
    public IMOVF(String src, String dest) {
        super(dest, src);
        this.oc = OpCode.IMOVF;
    }
    
}