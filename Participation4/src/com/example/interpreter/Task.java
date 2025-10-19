package src.com.example.interpreter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Task {
    public String name;
    public String status = "Pending"; // Pending, Assigned, InProgress, Done
    public String priority = "Medium";
    public LocalDate due;
    public Department department;
    public String assignee;

    public Task(String name) { this.name = name; }

    public long ageDays() {
        if (due == null) return 0;
        return ChronoUnit.DAYS.between(due, LocalDate.now());
    }

    public boolean isOverdue() {
        return due != null && LocalDate.now().isAfter(due) && !"Done".equalsIgnoreCase(status);
    }
}
