import java.util.Arrays;

public class TaskList {
    private String[] list;
    private int numOfItems;

    // Create a Task List with a maximum of 100 items
    public TaskList() {
        list = new String[100];
        numOfItems = 0;
    }

    // Add a new item to the end of the task list
    public void add(String item) {
        if (numOfItems == list.length) {
            System.out.println("Task list is full! Please remove some tasks before adding new ones.");
        }

        list[numOfItems] = item;
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

    // Print all items in the task list
    public void printList() {
        if (numOfItems == 0) {
            System.out.println("The task list is empty.");
            return;
        }

        System.out.println(Messages.STANDARD_BAR());
        for (int i = 0; i < numOfItems; i++) {
            System.out.println((i + 1) + ". " + list[i]);
        }

        System.out.println(Messages.STANDARD_BAR());
    }
}