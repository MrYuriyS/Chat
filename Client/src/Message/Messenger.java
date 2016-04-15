package Message;

import Users.MainUser;
import Users.User;

import java.util.Scanner;

public class Messenger extends Thread {
    private static User user = MainUser.getInstance();

    private static Scanner scanner;

    public Messenger(Scanner sc) {
        scanner = sc;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            System.out.print("Enter message to: ");
            String to = scanner.nextLine();
            if (to.isEmpty()) {
               to = "all";
            }

            System.out.print("Text: ");
            String text = scanner.nextLine();
            if (text.isEmpty()) {
                break;
            }

            Message message = new Message();
            message.setText(text);
            message.setFrom(user.getLogin());
            message.setTo(to);
            message.setRoom(user.getRoom());

            try {
                int res = message.send("http://localhost:8080/add");
                if (res != 200) {
                    System.out.println("HTTP error: " + res);
                    return;
                }
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
                return;
            }
        }
    }
}
