package malenia;
import java.io.IOException;
import java.util.Scanner;
import malenia.task.*;

public class Malenia {
    public static void main(String[] args) {
        TaskList taskList;
        try {
            taskList = Storage.load();
        }
        
        catch (IOException e) {
            Messages.wrapWithBars("Failed to load saved tasks: " + e.getMessage());
            taskList = new TaskList();
        }

        System.out.println(Messages.GREETINGS_MSG);
        Scanner scanner = new Scanner(System.in);
        String userInput;
        String[] parsedInput;
        String command;
        while (!(userInput = scanner.nextLine()).equals("bye")) {
            parsedInput = userInput.split(" ");
            command = parsedInput[0];
            try {
                switch (command) {
                case "list":
                    if (!CommandCheck.isList(parsedInput)) {
                        break;
                    }

                    taskList.printList();
                    break;

                case "mark":
                    if (!CommandCheck.isMarkUnmark(parsedInput, taskList)) {
                        break;
                    }

                    int indexToMark = Integer.parseInt(parsedInput[1]) - 1;
                    taskList.getTask(indexToMark).setMarkedStatus(true);
                    Messages.markedResponse(taskList.getTask(indexToMark));
                    break;

                case "unmark":
                    if (!CommandCheck.isMarkUnmark(parsedInput, taskList)) {
                        break;
                    }

                    int indexToUnmark = Integer.parseInt(parsedInput[1]) - 1;
                    taskList.getTask(indexToUnmark).setMarkedStatus(false);
                    Messages.unmarkedResponse(taskList.getTask(indexToUnmark));
                    break;

                case "todo":
                    if (!CommandCheck.isTodo(parsedInput)) {
                        break;
                    }

                    String taskName = userInput.substring(5);
                    Todo todoTask = new Todo(taskName);
                    taskList.add(todoTask);
                    Messages.addTaskResponse(todoTask);
                    break;

                case "deadline":
                    if (!CommandCheck.isDeadline(parsedInput)) {
                        break;
                    }

                    String[] deadlineParts = userInput.substring(9).split(" /by ");
                    String deadlineName = deadlineParts[0];
                    String dueBy = deadlineParts[1];
                    Deadline deadlineTask = new Deadline(deadlineName, dueBy);
                    taskList.add(deadlineTask);
                    Messages.addTaskResponse(deadlineTask);
                    break;

                case "event":
                    if (!CommandCheck.isEvent(parsedInput)) {
                        break;
                    }

                    String[] eventParts = userInput.substring(6).split(" /from | /to ");
                    String eventName = eventParts[0];
                    String eventStartTime = eventParts[1];
                    String eventEndTime = eventParts[2];
                    Event eventTask = new Event(eventName, eventStartTime, eventEndTime);
                    taskList.add(eventTask);
                    Messages.addTaskResponse(eventTask);
                    break;

                default:
                    throw MaleniaExceptions.invalidCommandException();
                }
            }

            catch (MaleniaExceptions e) {
                Messages.wrapWithBars(e.getMessage());
            }

            catch (IllegalArgumentException e) {
                Messages.wrapWithBars(e.getMessage());
            }
        }

        Storage.save(taskList);
        System.out.println(Messages.GOODBYE_MSG);
        scanner.close();
    }
}
