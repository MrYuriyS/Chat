package Users;

import Main.GSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private static final UserList userList = new UserList();

    private final List<User> list = new ArrayList<>();

    public static UserList getInstance() {
        return userList;
    }

    private UserList() {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("--All users:--\n");
        for (User user : list) {
            sb.append(user).append("\n");
        }
        return sb.toString();
    }

    public boolean contains(User user) {
        return list.contains(user);
    }

    public synchronized void add(User user) {
        list.add(user);
    }

    public static UserList get(String s) {
        UserList list = (UserList) GSON.fromJSON(s, User.class);
        return list;
    }
}
