package malenia.commands;
import malenia.TaskList;
import malenia.Ui;

/**
 * The MarkCommand class represents a command to mark a task as "done" in the task list.
 */
public class MarkCommand extends Command {
    private int indexToMark;

    public MarkCommand(String parameters) {
        indexToMark = Integer.parseInt(parameters) - 1;
    }

    @Override
    public void execute(TaskList taskList) {
        taskList.getTask(indexToMark).setMarkedStatus(true);
        Ui.markedResponse(taskList.getTask(indexToMark));
    }
}
