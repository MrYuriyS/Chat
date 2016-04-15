package Users;

import Messages.MessageList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class GetUserListServlet extends HttpServlet {
    private UserList userList = UserList.getInstance();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String json = userList.toJSON();
        if (json != null) {
            OutputStream os = response.getOutputStream();
            os.write(json.getBytes());
        }
    }
}
