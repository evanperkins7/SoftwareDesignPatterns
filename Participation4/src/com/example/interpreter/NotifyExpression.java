package src.com.example.interpreter;

/**
 * Terminal expression to simulate notifying a role (e.g., Manager).
 */
public class NotifyExpression implements Expression {
    private final Role role;
    private final String message;

    public NotifyExpression(Role role, String message) {
        this.role = role;
        this.message = message;
    }

    @Override
    public void interpret(Context context) {
        // In real system this would publish to notification service.
        context.log("Notify " + role + ": " + message);
    }
}
