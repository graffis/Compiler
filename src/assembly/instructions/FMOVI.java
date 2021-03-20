package assembly.instructions;

// import compiler.Scope;

/**
 * Class corresponding to RISC-V instruction FMOVI.S
 * 
 * Models FMOVI dest src # dest = INT, src = FLOAT
 */
public class FMOVI extends InstructionCAST {

    /**
     * Initializes SW instruction that prints SW src offset(baseAddress)
     * 
     * @param src source operand
     * @param baseAddress register holding base address
     * @param offset immediate holding address offset
     */
    public FMOVI(String src, String dest) {
        super(dest, src);
        this.oc = OpCode.FMOVI;
    }
    
}