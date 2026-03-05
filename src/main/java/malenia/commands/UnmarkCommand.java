package malenia.commands;
import malenia.TaskList;
import malenia.Messages;

public class UnmarkCommand extends Command {
    private int indexToUnmark;

    public UnmarkCommand(String parameters) {
        indexToUnmark = Integer.parseInt(parameters) - 1;
    }

    @Override
    public void execute(TaskList taskList) {
        taskList.getTask(indexToUnmark).setMarkedStatus(false);
        Messages.unmarkedResponse(taskList.getTask(indexToUnmark));
    }   
}
