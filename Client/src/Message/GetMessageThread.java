package Message;

import Message.Message;
import Users.MainUser;
import Users.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetMessageThread extends Thread {
    private int n;
    private String urlStr = "http://localhost:8080/get?room=%s&to=%s&last=%s";
    private User user = MainUser.getInstance();

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                URL url = new URL(String.format(urlStr, user.getRoom(), user.getLogin(), n));
                HttpURLConnection http = (HttpURLConnection) url.openConnection();
                try (InputStream is = http.getInputStream()) {
                    int sz = is.available();
                    if (sz > 0) {
                        byte[] buf = new byte[is.available()];
                        is.read(buf);

                        Gson gson = new GsonBuilder().create();
                        Message[] list = gson.fromJson(new String(buf), Message[].class);

                        for (Message message : list) {
                            System.out.println(message);
                            n++;
                        }
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
    }

    public void setUrl(String url) {
        urlStr = url;
    }

    public String getUrl() {
        return urlStr;
    }
}