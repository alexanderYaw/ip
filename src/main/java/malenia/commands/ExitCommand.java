package malenia.commands;
import malenia.Ui;
import malenia.TaskList;

public class ExitCommand extends Command {
    public void execute(TaskList taskList) {
        // No action needed
    }

    public boolean isExit() {
        System.out.println(Ui.GOODBYE_MSG);
        return true;
    }
}
