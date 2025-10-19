package src.com.example.interpreter;
/**
 * Terminal expression that flags delays (highlights tasks, raises an alert).
 */
public class FlagDelayExpression implements Expression {
    @Override public void interpret(Context ctx) {
        ctx.transitionProject("ATRISK");
        ctx.setDashboardBadge(Role.EXEC, "RED", "Delays detected");
    }
    @Override public String toString() { return "FlagDelay()"; }
}
