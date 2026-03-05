package malenia.commands;
import malenia.Messages;
import malenia.TaskList;

public class ExitCommand extends Command {
    public void execute(TaskList taskList) {
        // No action needed
    }

    public boolean isExit() {
        System.out.println(Messages.GOODBYE_MSG);
        return true;
    }
}
