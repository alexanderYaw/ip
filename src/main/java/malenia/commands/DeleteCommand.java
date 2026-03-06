package malenia.commands;
import malenia.TaskList;
import malenia.task.Task;
import malenia.Ui;

/**
 * The DeleteCommand class represents a command to delete a task from the task list.
 * It takes the index of the task to be deleted as a parameter and
 * removes the corresponding task from the task list when executed.
 */
public class DeleteCommand extends Command {
    private int indexToDelete;

    public DeleteCommand(String parameters) {
        indexToDelete = Integer.parseInt(parameters) - 1;
    }

    public void execute(TaskList taskList) {
        Task deletedTask = taskList.getTask(indexToDelete);
        taskList.remove(indexToDelete);
        Ui.deleteTaskResponse(deletedTask, taskList);
    }
}
