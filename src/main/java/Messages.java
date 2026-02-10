/**
Store all standard messages used in Malenia
*/

public class Messages {
    public static final String STANDARD_BAR = "_________________________________\n";
    public static final String GREETINGS_MSG = STANDARD_BAR +
                        "Hello! I'm Malenia\n" +
                        "What can I do for you?\n" +
                        STANDARD_BAR;
    public static final String GOODBYE_MSG = STANDARD_BAR +
                        "Bye. Hope to see you again soon!\n" + 
                        STANDARD_BAR;

    public static void wrapWithBars(String message) {
        System.out.println(STANDARD_BAR);
        System.out.println(message);
        System.out.println(STANDARD_BAR);
    }

    public static void addTaskResponse(Task task) {
        System.out.println(STANDARD_BAR);
        System.out.println("Got it. I've added this task: " + task);
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
}