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

    /**
     * Reads the task file (if it exists) and converts each line back into a
     * Task object, which is added to a newly created TaskList. The task list
     * is returned; the caller can then operate on it. Any I/O errors are
     * propagated to the caller.
     */
    public static TaskList load() throws IOException {
        Path filePath = Paths.get(".", "data", "maleniaTaskList.txt");
        TaskList taskList = new TaskList();

        if (!Files.exists(filePath)) {
            // no file yet, return empty list
            return taskList;
        }

        for (String line : Files.readAllLines(filePath)) {
            if (line.isBlank()) {
                continue;
            }

            // split on the pipe separators, trim whitespace
            String[] parts = line.split("\\|");
            for (int i = 0; i < parts.length; i++) {
                parts[i] = parts[i].trim();
            }

            String type = parts[0];
            boolean isMarked = parts.length > 1 && parts[1].equals("1");
            String name = parts.length > 2 ? parts[2] : "";

            Task task;
            switch (type) {
            case "T":
                task = new Todo(name);
                break;

            case "D":
                String by = parts.length > 3 ? parts[3] : "";
                task = new Deadline(name, by);
                break;

            case "E":
                String start = parts.length > 3 ? parts[3] : "";
                String end = parts.length > 4 ? parts[4] : "";
                task = new Event(name, start, end);
                break;

            default:
                continue;
            }

            task.setMarkedStatus(isMarked);
            taskList.add(task);
        }

        return taskList;
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
