package malenia;
import malenia.task.*;
import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> list;

    // Create a Task List
    public TaskList() {
        list = new ArrayList<>();
    }

    // Add a new Task item to the end of the task list
    public void add(Task task) {
        list.add(task);
    }

    // Remove an item from the task list by its index
    public void remove(int index) {
        if (index < 0 || index >= list.size()) {
            System.out.println("Invalid index! Please provide a valid task index to remove.");
            return;
        }

        list.remove(index);
    }

    // Return the number of items in the task list
    public int getNumOfItems() {
        return list.size();
    }

    public Task getTask(int index) {
        if (index < 0 || index >= list.size()) {
            System.out.println("Invalid index! Please provide a valid task index.");
            return null;
        }

        return list.get(index);
    }

    // Print all items in the task list
    public void printList() {
        if (list.size() == 0) {
            Messages.wrapWithBars("Your task list is empty!");
            return;
        }

        System.out.println(Messages.STANDARD_BAR);
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + "." + list.get(i));
        }

        System.out.println(Messages.STANDARD_BAR);
    }
}