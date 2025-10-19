package src.com.example.interpreter;

import java.time.LocalDate;
import java.util.*;

public class Context {
    // Domain
    public Project project;
    public final Map<String, Task> tasksByName = new HashMap<>();
    public final Map<String, Object> intakeData = new HashMap<>();
    public final Map<String, Number> metrics = new HashMap<>();
    public final List<String> auditLog = new ArrayList<>();

    // --- getters if you prefer them in conditions ---
    public Project getProject() { return project; }

    // --- helpers used by actions ---
    public Task getTask(String name) { return tasksByName.get(name); }

    public boolean hasApproval(String name) {
        return project != null && project.isApprovalDone(name);
    }

    public void assignTask(String dept, String taskName) {
        Task t = tasksByName.computeIfAbsent(taskName, Task::new);
        t.department = Department.valueOf(dept);
        t.status = "Assigned";
        record("Assigned task '" + taskName + "' to " + dept);
        notify(roleForDept(dept), "New task assigned: " + taskName);
    }

    public void notify(Role audience, String message) {
        record("Notify " + audience + ": " + message);
    }

    public void setDashboardBadge(Role role, String level, String text) {
        record("Dashboard badge for " + role + " -> " + level + " : " + text);
    }

    public void transitionProject(String nextState) {
        if (project != null) {
            String prev = project.state;
            project.state = nextState;
            record("Project state: " + prev + " -> " + nextState);
        }
    }

    public int blockers() { return project == null ? 0 : project.blockers; }
    public int lateMilestones() { return project == null ? 0 : project.lateMilestones; }

    public void record(String entry) {
        auditLog.add(LocalDate.now() + " | " + entry);
        System.out.println(entry);
    }

    private Role roleForDept(String dept) {
        switch (Department.valueOf(dept)) {
            case DESIGN: return Role.DESIGN_LEAD;
            case ENGINEERING: return Role.ENGINEERING_LEAD;
            case FINANCE: return Role.FINANCE_LEAD;
            case HR: return Role.HR_LEAD;
            default: return Role.MANAGER;
        }
    }
}
