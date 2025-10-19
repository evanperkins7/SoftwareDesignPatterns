package src.com.example.interpreter;

import src.com.example.interpreter.conditions.ProjectApprovedCondition;
import src.com.example.interpreter.conditions.TaskOverdueCondition;

/**
 * Demo: manually build an AST and run it.
 */
public class InterpreterDemo {
    public static void main(String[] args) {
        // Prepare project and context
        Project project = new Project("PROJECT-123");
        Context context = new Context(project);

        // Build workflow:
        // CREATE_PROJECT THEN
        // IF PROJECT_APPROVED THEN ( ASSIGN_TASK(Design) THEN NOTIFY(Manager) ) ELSE ( REVIEW_PROJECT THEN NOTIFY(Executive) )
        // IF TASK_OVERDUE THEN ( FLAG_DELAY THEN NOTIFY(Manager) )
        // LOG_PERFORMANCE

        Expression workflow = new SequenceExpression(
            new CreateProjectExpression(project.getId()),

            new IfExpression(
                new ProjectApprovedCondition(),
                new SequenceExpression(
                    new AssignTaskExpression("T-001", Department.DESIGN),
                    new NotifyExpression(Role.MANAGER, "Task assigned to Design")
                ),
                new SequenceExpression(
                    new // quick inline action to signal review; reuse CreateProjectExpression as placeholder
                        CreateProjectExpression("REVIEW-" + project.getId()),
                    new NotifyExpression(Role.EXECUTIVE, "Project requires review")
                )
            ),

            new IfExpression(
                new TaskOverdueCondition(),
                new SequenceExpression(
                    new FlagDelayExpression("Task is overdue"),
                    new NotifyExpression(Role.MANAGER, "A task is overdue")
                )
            ),

            new LogPerformanceExpression()
        );

        // First run with project not approved and no tasks -> triggers else branch
        System.out.println("=== Run 1 (not approved) ===");
        workflow.interpret(context);

        // Now approve project and run again
        project.setApproved(true);
        System.out.println("\n=== Run 2 (approved) ===");
        workflow.interpret(context);

        // Simulate overdue: mark a task overdue and run
        if (!project.getTasks().isEmpty()) {
            project.getTasks().get(0).setOverdue(true);
        }
        System.out.println("\n=== Run 3 (task overdue) ===");
        workflow.interpret(context);
    }
}
