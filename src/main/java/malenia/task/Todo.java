package malenia.task;

/**
 * The Todo class represents a to-do task, which is a specific type of task
 * that does not have a date or time associated with it.
 */
public class Todo extends Task {
    public Todo(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}