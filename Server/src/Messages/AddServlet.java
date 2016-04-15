package Messages;

import java.io.IOException;
import java.io.InputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet {

    private MessageList messageList = MessageList.getInstance();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        InputStream is = request.getInputStream();
        byte[] buf = new byte[request.getContentLength()];
        is.read(buf);

        Message message = Message.get(new String(buf));
        if (message != null) {
            messageList.add(message);
        } else {
            response.setStatus(400); // Bad request
        }
    }
}
