package malenia;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import malenia.task.*;

public class Storage {
    private Path filePath;

    public Storage(String filePath) {
        this.filePath = Paths.get(filePath);
    }

    /**
     * Formats a Task object into a string representation suitable for saving to a file.
     * 
     * @param task
     * @return A string representing the task in the file format.
     */
    public String toDataString(Task task) {
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
     * Loads the task list from the file specified by filePath.
     * If the file does not exist, an empty task list is returned.
     * Each line in the file is expected to be in the format (e.g.):
     * T | 0 | Task description
     * D | 1 | Task description | Due date
     * E | 0 | Task description | Start date | End date
     * The first part indicates the type of task (T for Todo, D for Deadline, E for Event),
     * the second part indicates whether the task is marked (1) or not (0),
     * and the remaining parts contain the task description and relevant dates.
     * 
     * @return A TaskList object containing the tasks loaded from the file.
     */
    public TaskList load() throws IOException {
        TaskList taskList = new TaskList();

        if (!Files.exists(filePath)) {
            return taskList;
        }

        for (String line : Files.readAllLines(filePath)) {
            if (line.isBlank()) {
                continue;
            }

            // split the pipe separators, trim whitespace
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

    /**
     * Saves the task list to the file specified by filePath.
     * 
     * @param taskList
     */
    public void save(TaskList taskList) {
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
