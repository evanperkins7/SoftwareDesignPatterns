package src.com.example.interpreter;

/**
 * Terminal expression that creates and assigns a Task to a department.
 */
public class AssignTaskExpression implements Expression {
    private final String taskId;
    private final Department department;

    public AssignTaskExpression(String taskId, Department department) {
        this.taskId = taskId;
        this.department = department;
    }

    @Override
    public void interpret(Context context) {
        Task t = new Task(taskId, department);
        context.getProject().addTask(t);
        context.log("Assigned task '" + taskId + "' to " + department);
    }
}
