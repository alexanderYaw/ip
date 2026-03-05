package malenia.commands;
import malenia.TaskList;
import malenia.Messages;
import malenia.task.Deadline;

public class DeadlineCommand extends Command {
    private String description;
    private String dueBy;

    public DeadlineCommand(String description, String dueBy) {
        this.description = description;
        this.dueBy = dueBy;
    }

    public void execute(TaskList taskList) {
        Deadline deadlineTask = new Deadline(description, dueBy);
        taskList.add(deadlineTask);
        Messages.addTaskResponse(deadlineTask, taskList);
    }
}
