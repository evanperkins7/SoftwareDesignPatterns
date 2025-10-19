package src.com.example.interpreter;

import java.util.Arrays;
import java.util.List;

/**
 * Executes a list of expressions in order.
 */
public class SequenceExpression implements Expression {
    private final List<Expression> expressions;

    public SequenceExpression(Expression... expressions) {
        this.expressions = Arrays.asList(expressions);
    }

    @Override
    public void interpret(Context context) {
        for (Expression expr : expressions) {
            expr.interpret(context);
        }
    }
}
