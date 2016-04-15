package Messages;

import Main.GSON;

import java.io.*;
import java.util.Date;

public class Message implements Serializable {
    private static final long serialVersionUID = 1L;

    private Date date = new Date();
    private String from;
    private String to = "All";
    private String text;
    private String room = "MainRoom";

    @Override
    public String toString() {
        return new StringBuilder().append("[").append(date.toString())
                .append(", From: ").append(from).append(", To: ").append(to)
                .append("] ").append(text).toString();
    }

    public int send(String url) throws IOException {
        int code = GSON.send(this, url);
        return code;
    }

    public static Message get(String s) {
        Message message = (Message) GSON.fromJSON(s, Message.class);
        return message;
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
        this.to = to;
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
