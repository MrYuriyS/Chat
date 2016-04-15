package Main;

import Users.GetUserListThread;
import Users.MainUser;
import Users.User;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

    private static Scanner scanner;
    private static String loginURL = "http://localhost:8080/login";
    private static String registrationURL = "http://localhost:8080/registration";

    public static void setScanner(Scanner sc) {
        scanner = sc;
    }

    public static void start() {
        String menu = "-------\n"
                + "Menu:\n"
                + "r - registration\n"
                + "l - log in\n"
                + "u - get user`s list\n"
                + "e - exit\n"
                + "-------";
        boolean flag = true;

        while (flag) {
            System.out.println(menu);
            System.out.print("Your choice: ");
            String answer = scanner.nextLine();
            switch (answer) {
                case "r":
                    registration();
                    flag = false;
                    break;
                case "l":
                    logIn();
                    flag = false;
                    break;
                case "u":
                    showUserList();
                    flag = true;
                case "e":
                    System.exit(0);
                    flag = true;
                    break;
                default:
                    System.out.println("Unknown command - " + answer);
                    System.out.println("Try again...");
                    flag = false;
                    break;
            }
        }
    }

    public static int registration() {
        System.out.println("\n--Registration--");
        int code = data(registrationURL);
        return code;
    }

    public static int logIn() {
        System.out.println("\n--Log in--");
        int code = data(loginURL);
        return code;
    }

    private static int data(String url) {
        try {
            System.out.print("Enter login: ");
            String login = scanner.nextLine();

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            User user = MainUser.getInstance();
            user.setLogin(login);
            user.setPassword(password);

            int code = user.send(url);
            return code;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    private static void showUserList() {
        GetUserListThread thread = new GetUserListThread();
        //thread.setDaemon(true);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setLoginURL(String url) {
        loginURL = url;
    }

    public String getLoginURL() {
        return loginURL;
    }

    public void setRegistrationURL(String url) {
        registrationURL = url;
    }

    public String getRegistrationURL() {
        return registrationURL;
    }
}
