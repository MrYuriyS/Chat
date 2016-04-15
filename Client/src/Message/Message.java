package Message;

import Main.GSON;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    private static SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");

    private Date date = new Date();
    private String from;
    private String to = "All";
    private String room = "MainRoom";
    private String text;

    @Override
    public String toString() {
        return new StringBuilder().append("[").append(format.format(date))
                .append(", From: ").append(from).append(", To: ").append(to)
                .append("] ").append(text).toString();
    }

    public int send(String url) throws IOException {
        int code = GSON.send(this, url);
        return code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        if (to != null) {
            this.to = to;
        } else {
            this.to = "All";
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getRoom() {
        return room;
    }
}
