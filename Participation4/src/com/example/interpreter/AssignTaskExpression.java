package src.com.example.interpreter;
/**
 * Terminal expression that creates and assigns a Task to a department.
 */
public class AssignTaskExpression implements Expression {
    private final String dept;
    private final String taskName;

    public AssignTaskExpression(String dept, String taskName) {
        this.dept = dept; this.taskName = taskName;
    }

    @Override public void interpret(Context ctx) { ctx.assignTask(dept, taskName); }

    @Override public String toString() { return "AssignTask(" + dept + "," + taskName + ")"; }
}
