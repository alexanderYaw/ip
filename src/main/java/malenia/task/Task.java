package malenia.task;

/**
 * The Task class represents a generic task. It is an abstract class that provides common functionality for all types of tasks.
 */
public abstract class Task {
    private String name;
    private boolean isMarked;

    public Task(String name) {
        this.name = name;
        this.isMarked = false;
    }

    public String getName() {
        return name;
    }

    public boolean isMarked() {
        return isMarked;
    }

    public void setMarkedStatus(boolean status) {
        this.isMarked = status;
    }

    @Override
    public String toString() {
        return (isMarked ? "[X] " : "[ ] ") + name;
    }
}