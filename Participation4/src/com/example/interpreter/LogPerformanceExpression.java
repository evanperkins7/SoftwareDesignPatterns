package src.com.example.interpreter;
/**
 * Terminal expression to record performance metrics.
 */
public class LogPerformanceExpression implements Expression {
    @Override public void interpret(Context ctx) {
        Number n = ctx.metrics.getOrDefault("events.logged", 0);
        ctx.metrics.put("events.logged", n.intValue() + 1);
        ctx.record("Performance logged (events.logged=" + ctx.metrics.get("events.logged") + ")");
    }
    @Override public String toString() { return "LogPerformance()"; }
}
