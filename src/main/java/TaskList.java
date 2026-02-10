import java.util.Arrays;

public class TaskList {
    private Task[] list;
    private int numOfItems;
    private static final int MAX_TASKS = 100;

    // Create a Task List with a maximum of 100 items
    public TaskList() {
        list = new Task[MAX_TASKS];
        numOfItems = 0;
    }

    // Add a new Todo item to the end of the task list
    public void add(Task task) {
        if (numOfItems == list.length) {
            System.out.println("Task list is full! Please remove some tasks before adding new ones.");
            return;
        }

        list[numOfItems] = task;
        numOfItems++;
    }

    // Remove an item from the task list by its index
    public void remove(int index) {
        if (index < 0 || index >= numOfItems) {
            System.out.println("Invalid index! Please provide a valid task index to remove.");
            return;
        }

        for (int i = index; i < numOfItems - 1; i++) {  // Shift items to the left at the removal point
            list[i] = list[i + 1];
        }

        list[numOfItems - 1] = null;
        numOfItems--;
    }

    // Return the number of items in the task list
    public int getNumOfItems() {
        return numOfItems;
    }

    public Task getTask(int index) {
        if (index < 0 || index >= numOfItems) {
            System.out.println("Invalid index! Please provide a valid task index.");
            return null;
        }

        return list[index];
    }

    // Print all items in the task list
    public void printList() {
        if (numOfItems == 0) {
            Messages.wrapWithBars("Your task list is empty!");
            return;
        }

        System.out.println(Messages.STANDARD_BAR);
        System.out.println("Here are the tasks in your list:");
        boolean markedStatus;
        String taskName;
        for (int i = 0; i < numOfItems; i++) {
            markedStatus = list[i].isMarked();
            taskName = list[i].getName();
            System.out.println((i + 1) + "." + list[i]);
        }

        System.out.println(Messages.STANDARD_BAR);
    }
}