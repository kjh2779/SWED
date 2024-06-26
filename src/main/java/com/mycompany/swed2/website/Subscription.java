package com.mycompany.swed2.website;

import com.mycompany.swed2.user.User;
import com.mycompany.swed2.user.NotificationPreferences;

public class Subscription {
    private User user;
    private Website website;
    private NotificationPreferences notificationPreferences;

    public Subscription(User user, Website website, NotificationPreferences notificationPreferences) {
        this.user = user;
        this.website = website;
        this.notificationPreferences = notificationPreferences;
    }

    public void updateNotificationPreferences(NotificationPreferences preferences) {
        this.notificationPreferences = preferences;
    }

    public User getUser() {
        return user;
    }

    public Website getWebsite() {
        return website;
    }

    public NotificationPreferences getNotificationPreferences() {
        return notificationPreferences;
    }
}
