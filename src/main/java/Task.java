public class Task {
    private String name;
    private boolean marked;

    public Task(String name) {
        this.name = name;
        this.marked = false;
    }

    public String getName() {
        return name;
    }

    public boolean isMarked() {
        return marked;
    }

    public void setMarkedStatus(boolean status) {
        this.marked = status;
    }
}