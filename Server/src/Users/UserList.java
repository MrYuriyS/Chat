package Users;

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

    public boolean contains(User user) {
        return list.contains(user);
    }

    public synchronized void add(User user) {
        list.add(user);
    }

    public synchronized String toJSON() {
        if (list.size() > 0) {
            Gson gson = new GsonBuilder().create();
            return gson.toJson(list.toArray());
        } else
            return null;
    }
}
