package malenia;
import java.util.Scanner;
import malenia.task.*;

/**
 * The Ui class is responsible for handling user interactions, including reading user input and displaying messages.
 * It provides methods to read user input, display greetings and goodbye messages, and wrap messages with
 * standard bars for better readability.
 * It also includes methods to display responses for adding, marking, unmarking,
 * and deleting tasks, which include the relevant task information and the current number of tasks in the list.
 */
public class Ui {
    private Scanner scanner;
    public static final String STANDARD_BAR = "_________________________________\n";
    public static final String GREETINGS_MSG = STANDARD_BAR +
                        "Hello! I'm Malenia\n" +
                        "What can I do for you?\n" +
                        STANDARD_BAR;
    public static final String GOODBYE_MSG = STANDARD_BAR +
                        "Bye. Hope to see you again soon!\n" + 
                        STANDARD_BAR;

    public Ui() {
        scanner = new Scanner(System.in);
    }

    public String readUserInput() {
        return scanner.nextLine();
    }
    
    public void closeScanner() {
        scanner.close();
    }
                        
    public static void wrapWithBars(String message) {
        System.out.println(STANDARD_BAR);
        System.out.println(message);
        System.out.println(STANDARD_BAR);
    }

    public static void addTaskResponse(Task task, TaskList taskList) {
        System.out.println(STANDARD_BAR);
        System.out.println("Got it. I've added this task: " + task);
        System.out.println("Now you have " + taskList.getNumOfItems() + " tasks in the list.");
        System.out.println(STANDARD_BAR);
    }

    public static void markedResponse(Task task) {
                System.out.println(STANDARD_BAR);
                System.out.println("Nice! I've marked this task as done:");
                System.out.println(task);
                System.out.println(STANDARD_BAR);
    }

    public static void unmarkedResponse(Task task) {
                System.out.println(STANDARD_BAR);
                System.out.println("OK, I've marked this task as not done yet:");
                System.out.println(task);
                System.out.println(STANDARD_BAR);
    }

    public static void deleteTaskResponse(Task task, TaskList taskList) {
        System.out.println(STANDARD_BAR);
        System.out.println("Noted. I've removed this task:");
        System.out.println(task);
        System.out.println("Now you have " + taskList.getNumOfItems() + " tasks in the list.");
        System.out.println(STANDARD_BAR);
    }
}