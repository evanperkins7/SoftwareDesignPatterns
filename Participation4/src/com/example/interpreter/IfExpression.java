package src.com.example.interpreter;

/**
 * Conditional expression: IF condition THEN trueBranch [ELSE falseBranch].
 */
public class IfExpression implements Expression {
    private final Condition condition;
    private final Expression trueBranch;
    private final Expression falseBranch; // may be null

    public IfExpression(Condition condition, Expression trueBranch, Expression falseBranch) {
        this.condition = condition;
        this.trueBranch = trueBranch;
        this.falseBranch = falseBranch;
    }

    public IfExpression(Condition condition, Expression trueBranch) {
        this(condition, trueBranch, null);
    }

    @Override
    public void interpret(Context context) {
        if (condition.evaluate(context)) {
            trueBranch.interpret(context);
        } else if (falseBranch != null) {
            falseBranch.interpret(context);
        }
    }
}

