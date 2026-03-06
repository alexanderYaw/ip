package malenia.commands;
import malenia.TaskList;
import malenia.Ui;
import malenia.task.Todo;

/**
 * The TodoCommand class represents a command to add a "Todo" task to the task list.
 */
public class TodoCommand extends Command {
    private String description;

    public TodoCommand(String parameter) {
        this.description = parameter;
    }

    public void execute(TaskList taskList) {
        Todo todoTask = new Todo(description);
        taskList.add(todoTask);
        Ui.addTaskResponse(todoTask, taskList);
    }
}
