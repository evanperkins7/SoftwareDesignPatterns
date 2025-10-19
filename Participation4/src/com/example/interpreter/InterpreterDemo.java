package src.com.example.interpreter;

import java.time.LocalDate;
import java.util.Arrays;

import src.com.example.interpreter.conditions.ProjectApprovedCondition;
import src.com.example.interpreter.conditions.TaskOverdueCondition;

public class InterpreterDemo {
    public static void main(String[] args) {
        // ----- Build Context -----
        Context ctx = new Context();

        // Project
        Project project = new Project();
        project.id = "P-1001";
        project.type = "Design";
        project.state = "ACTIVE";
        project.blockers = 2;          // demo value
        project.lateMilestones = 0;
        project.setApproved(true);     // simple approved flag
        project.approve("Legal");      // named approval also true

        // Tasks
        Task spec = new Task("SpecDoc");
        spec.status = "InProgress";
        spec.priority = "High";
        spec.due = LocalDate.now().minusDays(3); // overdue

        Task wires = new Task("Wireframes");
        wires.status = "Pending";
        wires.due = LocalDate.now().plusDays(5);

        project.tasks.addAll(Arrays.asList(spec, wires));

        // Reflect tasks in Context map (used by actions/conditions)
        ctx.tasksByName.put(spec.name, spec);
        ctx.tasksByName.put(wires.name, wires);

        // Attach project to context
        ctx.project = project;

        // ----- Conditions -----
        Condition approved   = new ProjectApprovedCondition();
        Condition anyOverdue = new TaskOverdueCondition();

        // ----- Rules -----
        // Rule 1: If any task overdue -> notify manager + flag delay
        Expression rule1 = new IfExpression(
                anyOverdue,
                new SequenceExpression(
                        new NotifyExpression(Role.MANAGER, "A task is overdue"),
                        new FlagDelayExpression()
                )
        );

        // Rule 2: If project approved -> assign Wireframes to DESIGN and notify Design Lead
        Expression rule2 = new IfExpression(
                approved,
                new SequenceExpression(
                        new AssignTaskExpression("DESIGN", "Wireframes"),
                        new NotifyExpression(Role.DESIGN_LEAD, "Wireframes task assigned")
                )
        );

        // ----- Run -----
        System.out.println("=== EVALUATING RULES ===");
        rule1.interpret(ctx);
        rule2.interpret(ctx);

        System.out.println("\n=== AUDIT LOG ===");
        for (String line : ctx.auditLog) System.out.println(line);

        System.out.println("\nProject state: " + ctx.project.state);
        System.out.println("Wireframes status: " + ctx.getTask("Wireframes").status);
    }
}
