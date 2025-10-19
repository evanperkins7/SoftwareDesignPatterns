package src.com.example.interpreter;

/**
 * Core Expression interface for the Interpreter pattern.
 */
public interface Expression {
    /**
     * Execute/interprete this expression against the provided context.
     * @param context runtime data: project, tasks, roles, etc.
     */
    void interpret(Context context);
}

