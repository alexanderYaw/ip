// Store all standard messages used in Malenia

public class Messages {
    public static String STANDARD_BAR() {
        return "_________________________________\n";
    }

    public static final String GREETING_MSG = STANDARD_BAR() +
                      "Hello! I'm Malenia\n" +
                      "What can I do for you?\n" +
                      STANDARD_BAR();

    public static final String GOODBYE_MSG = STANDARD_BAR() +
                      "Bye. Hope to see you again soon!\n" +
                      STANDARD_BAR();

    // Echo user entry when adding to task list
    public static String ADD_RESPONSE(String task) {
        return STANDARD_BAR() +
                       "added: " + task + "\n" +
                      STANDARD_BAR();
    }

    // Print task with its marked status
    public static String PRINT_TASK(Task task) {
        return task.isMarked() ? "[X] " + task.getName() : "[ ] " + task.getName();
    }
}