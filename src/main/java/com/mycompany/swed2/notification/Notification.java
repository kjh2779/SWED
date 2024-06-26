package com.mycompany.swed2.notification;

import java.util.Date;
import com.mycompany.swed2.user.User;

public class Notification {
    private String message;
    private Date timestamp;
    private User recipient;

    public Notification(String message, User recipient) {
        this.message = message;
        this.timestamp = new Date();
        this.recipient = recipient;
    }

    public String getMessage() {
        return message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public User getRecipient() {
        return recipient;
    }
}
