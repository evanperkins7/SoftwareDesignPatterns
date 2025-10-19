package src.com.example.interpreter.conditions;

import src.com.example.interpreter.Condition;
import src.com.example.interpreter.Context;
import src.com.example.interpreter.Project;

/** True when the current project is approved. */
public class ProjectApprovedCondition implements Condition {
    @Override
    public boolean evaluate(Context context) {
        Project p = context.getProject(); // works with Context#getProject()
        return p != null && p.isApproved();
    }
    @Override public String toString() { return "ProjectApproved"; }
}
