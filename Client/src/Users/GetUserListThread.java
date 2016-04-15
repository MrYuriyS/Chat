package Users;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Yuriy Salimov on 14.04.2016.
 */
public class GetUserListThread extends Thread {
    private String userListURL = "http://localhost:8080/userlist";

    @Override
    public void run() {
        try {
            URL url = new URL(userListURL);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            try (InputStream is = http.getInputStream()) {
                int sz = is.available();
                if (sz > 0) {
                    byte[] buf = new byte[is.available()];
                    is.read(buf);

                    Gson gson = new GsonBuilder().create();
                    User[] list = gson.fromJson(new String(buf), User[].class);

                    for (User m : list) {
                        System.out.println(m);
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void setUrl(String url) {
        userListURL = url;
    }

    public String getUrl() {
        return userListURL;
    }
}
