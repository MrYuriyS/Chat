package Users;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

public class LogoutServlet extends HttpServlet {
    private UserList userList = UserList.getInstance();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        InputStream is = request.getInputStream();
        byte[] buf = new byte[request.getContentLength()];
        is.read(buf);

        User user = User.get(new String(buf));
        if (user != null && userList.contains(user)) {
            user.setStatus("ofline");
            response.setStatus(200);
        } else {
            response.setStatus(400); // Bad request
        }
    }
}
