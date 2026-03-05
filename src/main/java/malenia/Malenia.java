package malenia;
import java.io.IOException;
import java.util.Scanner;
import malenia.commands.*;

public class Malenia {
    public static void main(String[] args) {
        TaskList taskList;
        try {
            taskList = Storage.load();
        }
        
        catch (IOException e) {
            Messages.wrapWithBars("Failed to load saved tasks: " + e.getMessage());
            taskList = new TaskList();
        }

        System.out.println(Messages.GREETINGS_MSG);
        Scanner scanner = new Scanner(System.in);
        boolean isExit = false;
        String userInput;
        while (!isExit) {
            try {
                userInput = scanner.nextLine();
                Command c = Parser.parse(userInput, taskList);
                c.execute(taskList);
                isExit = c.isExit();
            }

            catch (MaleniaExceptions e) {
                Messages.wrapWithBars(e.getMessage());
            }

            catch (IllegalArgumentException e) {
                Messages.wrapWithBars(e.getMessage());
            }
        }

        Storage.save(taskList);
        scanner.close();
    }
}
