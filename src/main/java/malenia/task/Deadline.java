package malenia.task;

/**
 * The Deadline class represents a task that has a specific due date. It extends the Task class.
 * It overrides the toString method to include the type of task (Deadline)
 * and the due date in the string representation of the task.
 */
public class Deadline extends Task {
    private String dueDate;

    public Deadline(String name, String dueDate) {
        super(name);
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + dueDate + ")";
    }
}