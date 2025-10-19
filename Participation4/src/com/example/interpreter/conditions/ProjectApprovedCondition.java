package src.com.example.interpreter.conditions;

import src.com.example.interpreter.Condition;
import src.com.example.interpreter.Context;

/**
 * True when the project is approved.
 */
public class ProjectApprovedCondition implements Condition {
    @Override
    public boolean evaluate(Context context) {
        return context.getProject().isApproved();
    }
}
