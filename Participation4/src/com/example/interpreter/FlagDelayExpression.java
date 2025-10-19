package src.com.example.interpreter;

/**
 * Terminal expression that flags delays (highlights tasks, raises an alert).
 */
public class FlagDelayExpression implements Expression {
    private final String reason;

    public FlagDelayExpression(String reason) {
        this.reason = reason;
    }

    @Override
    public void interpret(Context context) {
        context.log("Flagging delay: " + reason);
        // Could mark items, inform managers, create tickets, etc.
    }
}
