package src.com.example.interpreter;

/**
 * Terminal expression to record performance metrics.
 */
public class LogPerformanceExpression implements Expression {
    @Override
    public void interpret(Context context) {
        // Example: summarize project progress
        int total = context.getProject().getTasks().size();
        long completed = context.getProject().getTasks().stream().filter(Task::isCompleted).count();
        context.log("Performance: " + completed + " / " + total + " tasks completed.");
    }
}
