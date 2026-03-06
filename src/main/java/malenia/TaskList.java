package malenia;
import malenia.task.*;
import java.util.ArrayList;

/**
 * Represents a list of tasks. Provides methods to add, remove, and retrieve tasks from the list.
 */
public class TaskList {
    private ArrayList<Task> list;

    /**
     * Constructs an empty TaskList. The list is implemented as an ArrayList of Task objects.
     */
    public TaskList() {
        list = new ArrayList<>();
    }

    /**
     * Adds a task to the task list.
     * 
     * @param task
     */
    public void add(Task task) {
        list.add(task);
    }

    /**
     * Removes a task from the task list based on the provided index. If the index is invalid (negative or out of bounds),
     * throws an IndexOutOfBoundsException.
     * 
     * @param index
     */
    public void remove(int index) {
        if (index < 0 || index >= list.size()) {
            System.out.println("Invalid index! Please provide a valid task index to remove.");
            return;
        }

        list.remove(index);
    }

    /**
     * Returns the number of tasks currently in the task list.
     * 
     * @return The number of tasks in the list.
     */
    public int getNumOfItems() {
        return list.size();
    }

    /**
     * Retrieves a task from the task list based on the provided index. If the index is invalid (negative or out of bounds),
     * prints an error message and returns null.
     * 
     * @param index
     * @return The Task object at the specified index, or null if the index is invalid.
     */
    public Task getTask(int index) {
        if (index < 0 || index >= list.size()) {
            System.out.println("Invalid index! Please provide a valid task index.");
            return null;
        }

        return list.get(index);
    }
}