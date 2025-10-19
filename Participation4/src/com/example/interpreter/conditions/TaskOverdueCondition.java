package src.com.example.interpreter.conditions;

import src.com.example.interpreter.Condition;
import src.com.example.interpreter.Context;

/**
 * True when any task in the project is overdue.
 */
public class TaskOverdueCondition implements Condition {
    @Override
    public boolean evaluate(Context context) {
        return context.getProject().getTasks().stream().anyMatch(t -> t.isOverdue());
    }
}
