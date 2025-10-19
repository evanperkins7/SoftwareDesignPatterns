package src.com.example.interpreter;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds runtime state (project, tasks, logs). Expand this as your domain grows.
 */
public class Context {
    private Project project;
    private List<String> logs = new ArrayList<>();

    public Context(Project project) {
        this.project = project;
    }

    public Project getProject() {
        return project;
    }

    public void log(String entry) {
        logs.add(entry);
        System.out.println("[LOG] " + entry);
    }

    public List<String> getLogs() {
        return logs;
    }
}
