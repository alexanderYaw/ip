package malenia.commands;
import malenia.TaskList;
import malenia.Messages;
import malenia.task.Todo;

public class TodoCommand extends Command {
    private String description;

    public TodoCommand(String parameter) {
        this.description = parameter;
    }

    public void execute(TaskList taskList) {
        Todo todoTask = new Todo(description);
        taskList.add(todoTask);
        Messages.addTaskResponse(todoTask, taskList);
    }
}
