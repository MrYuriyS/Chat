package Main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class GSON {

    public static int send(Object obj,String urlStr) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("POST");
        conn.setDoOutput(true);

        try (OutputStream os = conn.getOutputStream();) {
            String json = toJSON(obj);
            os.write(json.getBytes());

            return conn.getResponseCode();
        }
    }

    public static String toJSON(Object obj) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(obj);
    }

    public static Object fromJSON(String s, Class<?> cls) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(s, cls);
    }
}
