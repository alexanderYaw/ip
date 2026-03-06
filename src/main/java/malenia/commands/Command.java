package malenia.commands;
import malenia.TaskList;

/**
 * The Command class is an abstract class that represents a command that can be executed in the Malenia application.
 */
public abstract class Command {
    public abstract void execute(TaskList taskList);
    public boolean isExit() {
        return false;
    }
}