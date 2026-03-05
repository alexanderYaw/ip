package malenia;
import malenia.commands.*;

public class Parser {
    public static Command parse(String input, TaskList taskList) throws MaleniaExceptions {
        String[] parsedInput = input.split(" ", 2);
        String command = parsedInput[0].toLowerCase();
        String parameters = (parsedInput.length > 1) ? parsedInput[1] : "";
            switch (command) {
            case "list":
                CommandCheck.isList(parsedInput);
                return new ListCommand();
                
            case "mark":
                CommandCheck.isMarkUnmark(parsedInput, taskList);
                return new MarkCommand(parameters);

            case "unmark":
                CommandCheck.isMarkUnmark(parsedInput, taskList);
                return new UnmarkCommand(parameters);

            case "todo":
                CommandCheck.isTodo(parsedInput);
                return new TodoCommand(parameters);

            case "deadline":
                CommandCheck.isDeadline(input.split(" "));
                return parseDeadlineCommand(parameters);

            case "event":
                CommandCheck.isEvent(input.split(" "));
                return parseEventCommand(parameters);
            
            case "delete":
                CommandCheck.isDelete(parsedInput, taskList);                 
                return new DeleteCommand(parameters);

            case "bye":
                CommandCheck.isBye(parsedInput);
                return new ExitCommand();

            default:
                throw MaleniaExceptions.invalidCommandException();
            }
    }

    private static Command parseDeadlineCommand(String parameters) {
        String[] deadlineParts = parameters.split(" /by ");
        String description = deadlineParts[0];
        String dueBy = deadlineParts[1];
        return new DeadlineCommand(description, dueBy);
    }

    private static Command parseEventCommand(String parameters) {
        String[] eventParts = parameters.split(" /from | /to ");
        String description = eventParts[0];
        String from = eventParts[1];
        String to = eventParts[2];
        return new EventCommand(description, from, to);
    }
}