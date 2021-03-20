package ast;

import ast.visitor.ASTVisitor;
import compiler.Scope;

/**
 * A node for type-casting expressions
 * 
 * This has one child: the {@link ExpressionNode} being operated on
 */
public class CastNode extends ExpressionNode {

	
    private ExpressionNode expr;
    private Scope.Type newType;
	
	public CastNode(ExpressionNode expr, Scope.Type newType) {
		this.setExpr(expr);
        this.setType(expr.getType());
        this.setNewType(newType);
	}

	@Override
	public <R> R accept(ASTVisitor<R> visitor) {
		return visitor.visit(this);
	}

	public ASTNode getExpr() {
		return expr;
	}

	private void setExpr(ExpressionNode right) {
		this.expr = right;
    }
    
    private void setNewType(Scope.Type newType)
    {
        this.newType = newType;
    }

    public Scope.Type getNewType()
    {
        return newType;
    }

}
