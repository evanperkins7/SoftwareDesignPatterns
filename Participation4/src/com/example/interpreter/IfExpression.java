package src.com.example.interpreter;

public class IfExpression implements Expression {
    private final Condition condition;
    private final Expression thenExpr;
    private final Expression elseExpr; // nullable

    public IfExpression(Condition condition, Expression thenExpr) {
        this(condition, thenExpr, null);
    }

    public IfExpression(Condition condition, Expression thenExpr, Expression elseExpr) {
        this.condition = condition;
        this.thenExpr = thenExpr;
        this.elseExpr = elseExpr;
    }

    @Override
    public void interpret(Context ctx) {
        boolean ok = condition.evaluate(ctx); // IMPORTANT: evaluate(Context)
        ctx.record("IF " + condition + " => " + ok);
        if (ok) {
            if (thenExpr != null) thenExpr.interpret(ctx);
        } else if (elseExpr != null) {
            elseExpr.interpret(ctx);
        }
    }

    @Override public String toString() { return "If(" + condition + ")"; }
}
