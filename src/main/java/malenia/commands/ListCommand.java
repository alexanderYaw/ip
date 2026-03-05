package malenia.commands;
import malenia.TaskList;
import malenia.Messages;

public class ListCommand extends Command {
    public void execute(TaskList taskList) {
        if (taskList.getNumOfItems() == 0) {
            Messages.wrapWithBars("Your task list is currently empty.");
        }
        
        else {
            Messages.wrapWithBars("Here are the tasks in your list:");
            for (int i = 0; i < taskList.getNumOfItems(); i++) {
            System.out.println((i + 1) + "." + taskList.getTask(i));
            System.out.println(Messages.STANDARD_BAR);
            }
        }
    }
}
