package src.com.example.interpreter;

import java.time.LocalDate;
import java.util.*;

public class Project {
    public String id;
    public String type = "General";
    public String state = "DRAFT";
    public LocalDate deadline;

    // Simple global approved flag + optional named approvals
    private boolean approved = false;
    private final Map<String, Boolean> namedApprovals = new HashMap<>();

    // For dashboard metrics
    public int blockers = 0;
    public int lateMilestones = 0;

    // Tasks owned by the project (handy for scanning)
    public final List<Task> tasks = new ArrayList<>();

    // --- approvals API ---
    public void setApproved(boolean approved) { this.approved = approved; }
    public boolean isApproved() {
        // If any named approvals exist, consider "approved" true if all are true; otherwise use flag
        if (!namedApprovals.isEmpty()) {
            return namedApprovals.values().stream().allMatch(Boolean::booleanValue);
        }
        return approved;
    }

    public void approve(String name) { namedApprovals.put(name, true); }
    public boolean isApprovalDone(String name) { return namedApprovals.getOrDefault(name, false); }
}
