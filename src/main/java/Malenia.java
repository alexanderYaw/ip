import java.util.Scanner;

public class Malenia {
    public static void addToListResponse(String message) {
        System.out.println(Messages.ADD_RESPONSE(message));
    }

    public static void main(String[] args) {
        TaskList taskList = new TaskList();
        System.out.println(Messages.GREETING_MSG);

        Scanner scanner = new Scanner(System.in);
        String userInput;
        String[] parsedInput;
        String command;
        while (!(userInput = scanner.nextLine()).equals("bye")) {
            parsedInput = userInput.split(" ");

            if (CommandCheck.isList(parsedInput)) {
                taskList.printList();
            }

            else if (CommandCheck.isMark(parsedInput)) {
                int index = Integer.parseInt(parsedInput[1]) - 1;
                if (index < 0 || index >= taskList.getNumOfItems()) {
                    System.out.println("Invalid index! Please provide a valid task index to mark.");
                }
                
                else {
                    taskList.getTask(index).setMarkedStatus(true);
                    System.out.println(Messages.STANDARD_BAR());
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println(Messages.PRINT_TASK(taskList.getTask(index)));
                    System.out.println(Messages.STANDARD_BAR());
                }
            }

            else if (CommandCheck.isUnmark(parsedInput)) {
                int index = Integer.parseInt(parsedInput[1]) - 1;
                if (index < 0 || index >= taskList.getNumOfItems()) {
                    System.out.println("Invalid index! Please provide a valid task index to unmark.");
                }
                
                else {
                    taskList.getTask(index).setMarkedStatus(false);
                    System.out.println(Messages.STANDARD_BAR());
                    System.out.println("OK, I've marked this task as not done yet:");
                    System.out.println(Messages.PRINT_TASK(taskList.getTask(index)));
                    System.out.println(Messages.STANDARD_BAR());
                }
            }

            else {
                taskList.add(userInput);
                addToListResponse(userInput);
            }
        }

        System.out.println(Messages.GOODBYE_MSG);
        scanner.close();
    }
}
