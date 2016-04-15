package Users;

public class MainUser extends User {
    private static final long serialVersionUID = 1L;

    private static User mainUser = new User();

    private MainUser() {

    }

    public static User getInstance() {
        return mainUser;
    }
}