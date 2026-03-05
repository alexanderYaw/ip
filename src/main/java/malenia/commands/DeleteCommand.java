package malenia.commands;
import malenia.TaskList;
import malenia.task.Task;
import malenia.Messages;

public class DeleteCommand extends Command {
    private int indexToDelete;

    public DeleteCommand(String parameters) {
        indexToDelete = Integer.parseInt(parameters) - 1;
    }

    public void execute(TaskList taskList) {
        Task deletedTask = taskList.getTask(indexToDelete);
        taskList.remove(indexToDelete);
        Messages.deleteTaskResponse(deletedTask, taskList);
    }
}
