package Users;

import Main.GSON;

import java.io.IOException;
import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String login;
    private /*transient*/ String password;
    private String status = "ofline";
    private String room = "MainRoom";

    public User() {

    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public int send(String url) throws IOException {
        int code = GSON.send(this, url);
        return code;
    }


    public static User get(String s) {
        User user = (User) GSON.fromJSON(s, User.class);
        return user;
    }

    @Override
    public int hashCode() {
        return (login.hashCode() + password.hashCode());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else if (object == null) {
            return false;
        } else if (this.getClass() != object.getClass()) {
            return false;
        }
        User user = (User) object;
        if (user.login.equals(this.login) && user.password.equals(this.password)) {
            return true;
        } else {
            return false;
        }
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getRoom() {
        return room;
    }
}