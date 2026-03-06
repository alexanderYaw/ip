/**
Check if what the user entered is a valid command or contains invalid parameters
*/
package malenia;
import java.util.Arrays;

public class CommandCheck {
    public static void checkList(String[] parsedInput) {
        if (parsedInput.length > 1) {
            throw new IllegalArgumentException("The command does not take any parameters.");
        }
    }

    public static void checkBye(String[] parsedInput) {
        if (parsedInput.length > 1) {
            throw new IllegalArgumentException("The command does not take any parameters.");
        }
    }

    public static void checkTodo(String[] parsedInput) throws MaleniaExceptions {
        if (parsedInput.length == 1) {
            throw MaleniaExceptions.missingDescriptionException("Please enter a description for the task.");
        }
    }

    public static void checkDeadline(String[] parsedInput) throws MaleniaExceptions {
        if (Arrays.asList(parsedInput).contains("/by") && parsedInput.length > 3) {
            return;
        }
        
        else {
            throw MaleniaExceptions.missingDescriptionException("Please enter a deadline and description for the task.");
        }
    }

    public static void checkEvent(String[] parsedInput) throws MaleniaExceptions {
        if (Arrays.asList(parsedInput).contains("/from") && Arrays.asList(parsedInput).contains("/to")) {
            if (parsedInput.length > 4) {
                return;
            }
            
            else {
                throw MaleniaExceptions.missingDescriptionException("Please enter a description for the task.");
            }
        }
        
        else {
            throw MaleniaExceptions.missingDescriptionException("Please enter an event time and description for the task.");
        }
    }

    public static void checkFind(String[] parsedInput) throws MaleniaExceptions {
        if (parsedInput.length == 1) {
            throw MaleniaExceptions.missingDescriptionException("Please enter a keyword to search for.");
        }
        
        if (parsedInput.length > 2) {
            throw MaleniaExceptions.missingDescriptionException("Please enter only one keyword.");
        }
    }

    public static void checkMarkUnmark(String[] parsedInput, TaskList taskList) throws MaleniaExceptions {
        if (parsedInput.length == 2 && parsedInput[1].matches("\\d+")) {
            int indexToMark = Integer.parseInt(parsedInput[1]);
            if (indexToMark > 0 && indexToMark <= taskList.getNumOfItems()) {
                return;
            }
            
            else {
                throw MaleniaExceptions.taskIndexOutOfRangeException();
            }
        }
        
        else {
            throw MaleniaExceptions.listInvalidParameterException();
        }
    }

    public static void checkDelete(String[] parsedInput, TaskList taskList) throws MaleniaExceptions {
        if (parsedInput.length == 2 && parsedInput[1].matches("\\d+")) {
            int indexToDelete = Integer.parseInt(parsedInput[1]);
            if (indexToDelete > 0 && indexToDelete <= taskList.getNumOfItems()) {
                return;
            }
            
            else {
                throw MaleniaExceptions.taskIndexOutOfRangeException();
            }
        }
        
        else {
            throw MaleniaExceptions.listInvalidParameterException();
        }
    }
}