package Messages;

import java.util.ArrayList;
import java.util.List;

import Users.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MessageList {

    private static final MessageList messageList = new MessageList();

    private final List<Message> list = new ArrayList<Message>();

    public static MessageList getInstance() {
        return messageList;
    }

    private MessageList() {
    }

    public synchronized void add(Message m) {
        list.add(m);
    }

    public synchronized String toJSON(String room, String to, int n) {
        List<Message> res = new ArrayList<>();
        Message message;
        for (int i = n; i < list.size(); i++) {
            message = list.get(i);
            if (message.getRoom().equals(room) && (message.getTo().equals(to) || message.getFrom().equals(to) || message.getTo().equalsIgnoreCase("All"))) {
                res.add(message);
            }
        }

        if (res.size() > 0) {
            Gson gson = new GsonBuilder().create();
            return gson.toJson(res.toArray());
        } else {
            return null;
        }
    }
}
