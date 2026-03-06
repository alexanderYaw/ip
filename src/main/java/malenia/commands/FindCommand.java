package malenia.commands;
import malenia.TaskList;
import malenia.Ui;
import malenia.task.*;

public class FindCommand extends Command{
    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    public void execute(TaskList taskList) {
        int numOfTasksFound = 0;
        Task task;
        Ui.wrapWithBars("Here are the matching tasks in your list:");
        for (int i =0; i < taskList.getNumOfItems(); i++) {
            task = taskList.getTask(i);
            if (task.getName().contains(keyword)) {
                System.out.println((i + 1) + ". " + task);
                numOfTasksFound++;
            }
        }

        if (numOfTasksFound == 0) {
            Ui.wrapWithBars("No tasks found matching the keyword: " + keyword);
        }
    }
}
