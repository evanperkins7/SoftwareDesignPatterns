package src.com.example.interpreter;

import java.util.ArrayList;
import java.util.List;

/**
 * Minimal Project domain object.
 */
public class Project {
    private String id;
    private boolean approved = false;
    private final List<Task> tasks = new ArrayList<>();

    public Project(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task t) {
        tasks.add(t);
    }
}
