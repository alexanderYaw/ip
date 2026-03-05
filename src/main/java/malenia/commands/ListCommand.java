package malenia.commands;
import malenia.TaskList;
import malenia.Ui;

public class ListCommand extends Command {
    public void execute(TaskList taskList) {
        if (taskList.getNumOfItems() == 0) {
            Ui.wrapWithBars("Your task list is currently empty.");
        }
        
        else {
            Ui.wrapWithBars("Here are the tasks in your list:");
            for (int i = 0; i < taskList.getNumOfItems(); i++) {
            System.out.println((i + 1) + "." + taskList.getTask(i));
            System.out.println(Ui.STANDARD_BAR);
            }
        }
    }
}
