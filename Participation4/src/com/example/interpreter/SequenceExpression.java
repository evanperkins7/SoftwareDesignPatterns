package src.com.example.interpreter;

import java.util.*;

public class SequenceExpression implements Expression {
    private final List<Expression> steps = new ArrayList<>();
    public SequenceExpression(Expression... exprs) { steps.addAll(Arrays.asList(exprs)); }
    public SequenceExpression add(Expression e) { steps.add(e); return this; }

    @Override public void interpret(Context ctx) {
        for (Expression e : steps) e.interpret(ctx);
    }

    @Override public String toString() { return "Sequence(" + steps.size() + " steps)"; }
}
