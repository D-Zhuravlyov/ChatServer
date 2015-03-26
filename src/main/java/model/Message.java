package model;



import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by nofuruct on 13.02.15.
 */
public class Message implements Serializable, Comparable<Message> {
    private Calendar date = new GregorianCalendar();
    private String ipAddressName;
    private String messageText;

    public Message(String ipAddressName, Calendar date, String messageText) {
        this.ipAddressName = ipAddressName;
        this.date = date;
        this.messageText = messageText;
    }

    public Message(String messageText) {
        this.messageText = messageText;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getIpAddressName() {
        return ipAddressName;
    }

    public void setIpAddressName(String ipAddressName) {
        this.ipAddressName = ipAddressName;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    @Override
    public String toString() {
        return// ", ipAddressName=" + ipAddressName +
                date.getTime() + "| " + ipAddressName + ": " + messageText;
    }


    @Override
    public int compareTo(Message o) {

        return 0;
    }
}