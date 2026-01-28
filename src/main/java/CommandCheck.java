// Check if what the user entered is a valid command or just a random string that starts
// with one of the command keywords.

public class CommandCheck {
    public static boolean isList(String[] parsedInput) {
        return parsedInput[0].equals("list") && parsedInput.length == 1;
    }

    public static boolean isMark(String[] parsedInput) {
        return parsedInput[0].equals("mark") && parsedInput.length == 2 && parsedInput[1].matches("\\d+");
    }

    public static boolean isUnmark(String[] parsedInput) {
        return parsedInput[0].equals("unmark") && parsedInput.length == 2 && parsedInput[1].matches("\\d+");
    }
}