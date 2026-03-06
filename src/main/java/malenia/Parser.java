package malenia;
import malenia.commands.*;

public class Parser {
    public static Command parse(String input, TaskList taskList) throws MaleniaExceptions {
        String[] parsedInput = input.split(" ", 2);
        String command = parsedInput[0].toLowerCase();
        String parameters = (parsedInput.length > 1) ? parsedInput[1] : "";
        parsedInput = input.split(" ");
            switch (command) {
            case "list":
                CommandCheck.checkList(parsedInput);
                return new ListCommand();
                
            case "mark":
                CommandCheck.checkMarkUnmark(parsedInput, taskList);
                return new MarkCommand(parameters);

            case "unmark":
                CommandCheck.checkMarkUnmark(parsedInput, taskList);
                return new UnmarkCommand(parameters);

            case "todo":
                CommandCheck.checkTodo(parsedInput);
                return new TodoCommand(parameters);

            case "deadline":
                CommandCheck.checkDeadline(parsedInput);
                return parseDeadlineCommand(parameters);

            case "event":
                CommandCheck.checkEvent(parsedInput);
                return parseEventCommand(parameters);

            case "find":
                CommandCheck.checkFind(parsedInput);
                return new FindCommand(parameters);
            
            case "delete":
                CommandCheck.checkDelete(parsedInput, taskList);                 
                return new DeleteCommand(parameters);

            case "bye":
                CommandCheck.checkBye(parsedInput);
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