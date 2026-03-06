package malenia.commands;
import malenia.TaskList;
import malenia.Ui;
import malenia.task.Deadline;

/**
 * The DeadlineCommand class represents a command to add a deadline task to the task list.
 */
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
        Ui.addTaskResponse(deadlineTask, taskList);
    }
}
