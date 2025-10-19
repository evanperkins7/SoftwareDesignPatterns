package src.com.example.interpreter;
/**
 * Terminal expression that "creates" a project – here it's a no-op since context already holds project,
 * but in a full implementation it might persist to DB, set deadlines, etc.
 */
import java.time.LocalDate;

public class CreateProjectExpression implements Expression {
    @Override public void interpret(Context ctx) {
        Project p = new Project();
        p.id = (String) ctx.intakeData.getOrDefault("id", "P-" + System.currentTimeMillis());
        p.type = (String) ctx.intakeData.getOrDefault("type", "General");
        p.deadline = (LocalDate) ctx.intakeData.getOrDefault("deadline", LocalDate.now().plusDays(14));
        ctx.project = p;
        ctx.record("Project created: id=" + p.id + ", type=" + p.type + ", deadline=" + p.deadline);
    }
    @Override public String toString() { return "CreateProject()"; }
}

