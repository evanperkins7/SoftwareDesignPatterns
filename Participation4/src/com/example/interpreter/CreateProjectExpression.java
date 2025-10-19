package src.com.example.interpreter;

/**
 * Terminal expression that "creates" a project – here it's a no-op since context already holds project,
 * but in a full implementation it might persist to DB, set deadlines, etc.
 */
public class CreateProjectExpression implements Expression {
    private final String projectId;

    public CreateProjectExpression(String projectId) {
        this.projectId = projectId;
    }

    @Override
    public void interpret(Context context) {
        context.log("Create project " + projectId);
        // If Context didn't have a project, we might create and attach one here.
    }
}
