package src.com.example.interpreter;
/**
 * Terminal expression to simulate notifying a role (e.g., Manager).
 */
public class NotifyExpression implements Expression {
    private final Role audience;
    private final String message;

    public NotifyExpression(Role audience, String message) {
        this.audience = audience; this.message = message;
    }

    @Override public void interpret(Context ctx) { ctx.notify(audience, message); }

    @Override public String toString() { return "Notify(" + audience + ")"; }
}
