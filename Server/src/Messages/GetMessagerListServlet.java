package Messages;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetMessagerListServlet extends HttpServlet {

    private MessageList messageList = MessageList.getInstance();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String room = request.getParameter("room");
        String to = request.getParameter("to");
        String num = request.getParameter("last");
        int number = Integer.parseInt(num);

        String json = messageList.toJSON(room, to, number);
        if (json != null) {
            OutputStream os = response.getOutputStream();
            os.write(json.getBytes());
        }
    }
}
