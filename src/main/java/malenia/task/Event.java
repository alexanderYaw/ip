package malenia.task;

/**
 * The Event class represents a task that has a specific start and end time. It extends the Task class.
 * It overrides the toString method to include the type of task (Event)
 * and the start and end times in the string representation of the task.
 */
public class Event extends Task {
    private String eventStartTime;
    private String eventEndTime;

    public Event(String name, String eventStartTime, String eventEndTime) {
        super(name);
        this.eventStartTime = eventStartTime;
        this.eventEndTime = eventEndTime;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + eventStartTime + " to: " + eventEndTime + ")";
    }
}