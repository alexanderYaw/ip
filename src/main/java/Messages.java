// Store all standard messages used in Malenia

public class Messages {
    public static final String GREETING_MSG = "_________________________________\n" +
                      "Hello! I'm Malenia\n" +
                      "What can I do for you?\n" +
                      "_________________________________\n";

    public static final String GOODBYE_MSG = "_________________________________\n" +
                      "Bye. Hope to see you again soon!\n" +
                      "_________________________________";

    public static String echoTemplate(String task) {
        return "_________________________________\n" +
                       task + "\n" +
                      "_________________________________";
    }
}