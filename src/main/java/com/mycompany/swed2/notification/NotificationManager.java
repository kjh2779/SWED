package com.mycompany.swed2.notification;

import com.mycompany.swed2.user.User;

import java.util.ArrayList;
import java.util.List;

public class NotificationManager {
    private List<Notification> notifications;

    public NotificationManager() {
        this.notifications = new ArrayList<>();
    }

    public void addNotification(String message, User recipient) {
        Notification notification = new Notification(message, recipient);
        notifications.add(notification);
        deliverNotification(notification);
    }

    private void deliverNotification(Notification notification) {
        User recipient = notification.getRecipient();
        if (recipient != null && recipient.getNotificationPreferences() != null) {
            CommunicationChannel channel = recipient.getNotificationPreferences().getPreferredChannel();
            channel.deliverNotification(notification.getMessage(), recipient);
        }
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void clearNotifications() {
        notifications.clear();
    }
}
