package src.com.example.interpreter;

/**
 * Boolean predicate used by Interpreter "if" rules.
 * Implementations live in src.com.example.interpreter.conditions.*
 */
public interface Condition {
    /**
     * Return true if the condition holds for the given runtime context.
     */
    boolean evaluate(Context context);
}
