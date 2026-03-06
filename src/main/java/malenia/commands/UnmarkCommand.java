package malenia.commands;
import malenia.TaskList;
import malenia.Ui;

/**
 * Represents a command to unmark a task as not done in the Malenia application.
 */
public class UnmarkCommand extends Command {
    private int indexToUnmark;

    public UnmarkCommand(String parameters) {
        indexToUnmark = Integer.parseInt(parameters) - 1;
    }

    @Override
    public void execute(TaskList taskList) {
        taskList.getTask(indexToUnmark).setMarkedStatus(false);
        Ui.unmarkedResponse(taskList.getTask(indexToUnmark));
    }   
}
