package com.mycompany.swed2.user;

import com.mycompany.swed2.notification.Observer;
import com.mycompany.swed2.website.Subscription;
import com.mycompany.swed2.website.Website;

import java.util.ArrayList;
import java.util.List;

public class User implements Observer {
    private int userID;
    private String username;
    private String email;
    private NotificationPreferences notificationPreferences;
    private List<Subscription> subscriptions;

    public User(int userID, String username, String email, NotificationPreferences notificationPreferences) {
        this.userID = userID;
        this.username = username;
        this.email = email;
        this.notificationPreferences = notificationPreferences;
        this.subscriptions = new ArrayList<>();
    }

    public void register(String websiteURL, NotificationPreferences preferences) {
        System.out.println("Registering user " + username + " to " + websiteURL);
        Subscription subscription = new Subscription(this, new Website(websiteURL), preferences);
        subscriptions.add(subscription);
        System.out.println("User " + username + " subscribed to " + websiteURL + ". Total subscriptions: " + subscriptions.size());
    }

    public void updateNotificationPreferences(NotificationPreferences preferences) {
        this.notificationPreferences = preferences;
    }

    public void manageSubscriptions(String websiteURL, NotificationPreferences newPreferences) {
        for (Subscription subscription : subscriptions) {
            if (subscription.getWebsite().getURL().equals(websiteURL)) {
                subscription.updateNotificationPreferences(newPreferences);
                return;
            }
        }
        register(websiteURL, newPreferences);
    }

    @Override
    public void update(String message) {
        System.out.println("User " + username + " received notification: " + message);
        notificationPreferences.getPreferredChannel().deliverNotification(message, this);
    }

    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public NotificationPreferences getNotificationPreferences() {
        return notificationPreferences;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }
}
