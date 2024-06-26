package com.mycompany.swed2.notification;

import com.mycompany.swed2.user.User;

public class CommunicationChannel {
    private String channelName;

    public CommunicationChannel(String channelName) {
        this.channelName = channelName;
    }

    public void deliverNotification(String message, User recipient) {
        System.out.println("Delivering message to " + recipient.getUsername() + " via " + channelName + ": " + message);
    }

    public String getChannelName() {
        return channelName;
    }
}
