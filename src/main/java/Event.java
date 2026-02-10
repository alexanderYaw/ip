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