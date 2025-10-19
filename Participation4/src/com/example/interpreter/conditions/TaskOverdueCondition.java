package src.com.example.interpreter.conditions;

import src.com.example.interpreter.Condition;
import src.com.example.interpreter.Context;
import src.com.example.interpreter.Task;

/** True when any task is overdue. */
public class TaskOverdueCondition implements Condition {
    @Override
    public boolean evaluate(Context context) {
        // Check tasks known by the Context map
        if (!context.tasksByName.isEmpty()) {
            return context.tasksByName.values().stream().anyMatch(Task::isOverdue);
        }
        // Fall back to project's task list if present
        if (context.getProject() != null && !context.getProject().tasks.isEmpty()) {
            return context.getProject().tasks.stream().anyMatch(Task::isOverdue);
        }
        return false;
    }
    @Override public String toString() { return "AnyTaskOverdue"; }
}
