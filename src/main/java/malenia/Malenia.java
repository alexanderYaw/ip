package malenia;
import java.io.IOException;
import malenia.commands.*;

public class Malenia {
    private Storage storage;
    private TaskList taskList;
    private Ui ui;

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
    public static void main(String[] args) {
        new Malenia("./data/maleniaTaskList.txt").run();
    }
}
