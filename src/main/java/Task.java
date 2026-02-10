public class Task {
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