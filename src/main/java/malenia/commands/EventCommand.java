package malenia.commands;
import malenia.task.Event;
import malenia.TaskList;
import malenia.Ui;

/**
 * The EventCommand class represents a command to add an event task to the task list.
 * It takes the description, start time and end time of the event as parameters and
 * creates an Event task which is added to the task list when executed.
 */
public class EventCommand extends Command {
    private String description;
    private String from;
    private String to;

    public EventCommand(String description, String from, String to) {
        this.description = description;
        this.from = from;
        this.to = to;
    }

    public void execute(TaskList taskList) {
        Event eventTask = new Event(description, from, to);
        taskList.add(eventTask);
        Ui.addTaskResponse(eventTask, taskList);
    }
}