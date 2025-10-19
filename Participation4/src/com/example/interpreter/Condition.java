package src.com.example.interpreter;

/**
 * Condition interface used by conditional expressions.
 */
public interface Condition {
    boolean evaluate(Context context);
}
