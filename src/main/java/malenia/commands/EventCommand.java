package malenia.commands;
import malenia.task.Event;
import malenia.TaskList;
import malenia.Messages;

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
        Messages.addTaskResponse(eventTask, taskList);
    }
}