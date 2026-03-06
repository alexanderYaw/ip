/**
 * Author: Alexander Yaw Kai Mun
 * Description: This is the main entry point for Malenia application.
 * Malenia is a Command Line Interface task management application that allows users to create, manage
 * and save their tasks locally.
 */

package malenia;
import java.io.IOException;
import malenia.commands.*;

/**
 * Main class for Malenia application.
 */
public class Malenia {
    private Storage storage;
    private TaskList taskList;
    private Ui ui;

    /**
     * Constructs a Malenia instance.
     * It initializes the necessary components such as Storage, TaskList and Ui.
     * Corrupted or missing storage file will be handled by initializing an empty TaskList.
     */
    public Malenia(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            taskList = storage.load();
        }
        
        catch (IOException e) {
            Ui.wrapWithBars("Failed to load saved tasks: " + e.getMessage());
            taskList = new TaskList();
        }
    }

    /**
     * Runs the Malenia application, continuously accepting user input until the exit command is issued.
     */
    public void run() {
        System.out.println(Ui.GREETINGS_MSG);
        boolean isExit = false;
        String userInput;
        while (!isExit) {
            try {
                userInput = ui.readUserInput();
                Command c = Parser.parse(userInput, taskList);
                c.execute(taskList);
                isExit = c.isExit();
            }

            catch (MaleniaExceptions e) {
                Ui.wrapWithBars(e.getMessage());
            }

            catch (IllegalArgumentException e) {
                Ui.wrapWithBars(e.getMessage());
            }
        }

        storage.save(taskList);
        ui.closeScanner();
    }

    /**
     * The main entry point for the Malenia application. It creates an instance of Malenia and runs it.
     */
    public static void main(String[] args) {
        new Malenia("./data/maleniaTaskList.txt").run();
    }
}
