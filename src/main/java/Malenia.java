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
        while (!(userInput = scanner.nextLine()).equals("bye")) {
            switch (userInput) {
                case "list":
                    taskList.printList();
                    break;
                    
                default:
                    taskList.add(userInput);
                    addToListResponse(userInput);
                    break;
            }
        }

        System.out.println(Messages.GOODBYE_MSG);
        scanner.close();
    }
}
