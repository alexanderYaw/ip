/**
Check if what the user entered is a valid command or contains invalid parameters
*/ 
import java.util.Arrays;

public class CommandCheck {
    public static boolean isList(String[] parsedInput) {
        if (parsedInput.length > 1) {
            Messages.wrapWithBars("The list command does not take any parameters.");
            return false;
        }

        return true;
    }

    public static boolean isTodo(String[] parsedInput) {
        if (parsedInput.length > 1) {
            return true;
        }
        
        else {
            Messages.wrapWithBars("Please enter a description for the todo task.");
            return false;
        }
    }

    public static boolean isDeadline(String[] parsedInput) {
        if (Arrays.asList(parsedInput).contains("/by") && parsedInput.length > 3) {
            return true;
        }
        
        else {
            Messages.wrapWithBars("Please enter a deadline and description for the task.");
            return false;
        }
    }

    public static boolean isEvent(String[] parsedInput) {
        if (Arrays.asList(parsedInput).contains("/from") && Arrays.asList(parsedInput).contains("/to")) {
            if ((Arrays.asList(parsedInput).indexOf("/to") - Arrays.asList(parsedInput).indexOf("/from")) > 1
                && parsedInput.length > 4) {
                return true;
            }
            
            else {
                Messages.wrapWithBars("Please enter a valid event time and description for the task.");
                return false;
            }
        }
        
        else {
            Messages.wrapWithBars("Please enter an event time and description for the task.");
            return false;
        }
    }

    public static boolean isMarkUnmark(String[] parsedInput, TaskList taskList) {
        if (parsedInput.length == 2 && parsedInput[1].matches("\\d+")) {
            int indexToMark = Integer.parseInt(parsedInput[1]);
            if (indexToMark > 0 && indexToMark <= taskList.getNumOfItems()) {
                return true;
            }
            
            else {
                Messages.wrapWithBars("Task index out of range!");
                return false;
            }
        }
        
        else {
            Messages.wrapWithBars("Invalid mark command");
            return false;
        }
    }
}