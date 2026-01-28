import java.util.Scanner;

public class Malenia {
    public static void echo(String message) {
        System.out.println(Messages.echoTemplate(message));
    }

    public static void main(String[] args) {
  
        System.out.println(Messages.GREETING_MSG);

        Scanner scanner = new Scanner(System.in);
        String userInput;
        while (!(userInput = scanner.nextLine()).equals("bye")) {
            echo(userInput);
        }

        System.out.println(Messages.GOODBYE_MSG);
        scanner.close();
    }
}
