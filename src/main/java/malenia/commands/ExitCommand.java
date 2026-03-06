package malenia.commands;
import malenia.Ui;
import malenia.TaskList;

/**
 * The ExitCommand class represents the command to exit the application.
 * It extends the Command class and overrides the execute and isExit methods.
 */
public class ExitCommand extends Command {
    public void execute(TaskList taskList) {
        System.out.println(Ui.GOODBYE_MSG);
    }

    public boolean isExit() {
        return true;
    }
}
