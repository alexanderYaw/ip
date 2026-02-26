package malenia;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import malenia.task.*;

public class Storage {
    public static String toDataString(Task task) {
        String formattedTask = task.toString();
        formattedTask = formattedTask.substring(1); // Remove the opening bracket "["
        formattedTask = formattedTask.replace("[ ]", "0 |");
        formattedTask = formattedTask.replace("[X]", "1 |");
        formattedTask = formattedTask.replace("]", " | ");
        formattedTask = formattedTask.replace("(by: ", "| ");
        formattedTask = formattedTask.replace(")", "");
        formattedTask = formattedTask.replace("(from: ", "| ");
        formattedTask = formattedTask.replace(" to: ", " | ");

        return formattedTask;
    }

    public static void save(TaskList taskList) {
        Path dirPath = Paths.get(".", "data"); 
        Path filePath = Paths.get(".", "data", "maleniaTaskList.txt"); 

        try {
            if (!Files.exists(dirPath)) {
                Files.createDirectories(dirPath);
            }

            StringBuilder formattedTasks = new StringBuilder();
            Task task;
            for (int i = 0; i < taskList.getNumOfItems(); i++) {
                task = taskList.getTask(i);
                formattedTasks.append(toDataString(task)).append("\n");
            }

            Files.writeString(
                filePath, 
                formattedTasks, 
                StandardOpenOption.CREATE, 
                StandardOpenOption.TRUNCATE_EXISTING
            );

            System.out.println("Tasks saved successfully!");
        }
        
        catch (IOException e) {
            System.out.println("An error occurred while saving tasks: " + e.getMessage());
        }
    }
}
