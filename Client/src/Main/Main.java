package Main;

import Message.GetMessageThread;
import Message.Messenger;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Menu.setScanner(scanner);
        Menu.start();

        GetMessageThread thread = new GetMessageThread();
        thread.setDaemon(true);
        thread.start();

        Messenger messenger = new Messenger(scanner);
        messenger.start();
    }
}
