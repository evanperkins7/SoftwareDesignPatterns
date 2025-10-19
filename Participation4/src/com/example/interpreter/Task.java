package src.com.example.interpreter;

/**
 * Minimal Task model.
 */
public class Task {
    private final String id;
    private Department department;
    private boolean completed = false;
    private boolean overdue = false;

    public Task(String id, Department department) {
        this.id = id;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public Department getDepartment() {
        return department;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        this.completed = true;
    }

    public boolean isOverdue() {
        return overdue;
    }

    public void setOverdue(boolean overdue) {
        this.overdue = overdue;
    }
}
