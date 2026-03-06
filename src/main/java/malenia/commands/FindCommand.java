package malenia.commands;
import malenia.TaskList;
import malenia.Ui;
import malenia.task.*;
import java.util.ArrayList;

public class FindCommand extends Command{
    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    public void execute(TaskList taskList) {
        Task task;
        ArrayList<Task> matchingTasks = new ArrayList<>();
        for (int i = 0; i < taskList.getNumOfItems(); i++) {
            task = taskList.getTask(i);
            if (task.getName().contains(keyword)) {
                System.out.println((i + 1) + ". " + task);
                matchingTasks.add(task);
            }
        }

        if (matchingTasks.isEmpty()) {
            Ui.wrapWithBars("No tasks found matching the keyword: " + keyword);
        }

        else {
            System.out.println(Ui.STANDARD_BAR);
            System.out.println("Here are the matching tasks in your list:\n");
            for (int i = 0; i < matchingTasks.size(); i++) {
                System.out.println((i + 1) + ". " + matchingTasks.get(i));
            }

            System.out.println(Ui.STANDARD_BAR);
        }
    }
}
