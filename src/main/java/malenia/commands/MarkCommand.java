package malenia.commands;
import malenia.TaskList;
import malenia.Messages;

public class MarkCommand extends Command {
    private int indexToMark;

    public MarkCommand(String parameters) {
        indexToMark = Integer.parseInt(parameters) - 1;
    }

    @Override
    public void execute(TaskList taskList) {
        taskList.getTask(indexToMark).setMarkedStatus(true);
        Messages.markedResponse(taskList.getTask(indexToMark));
    }
}
