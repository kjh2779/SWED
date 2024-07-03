
package com.mycompany.swed3;

import java.util.ArrayList;
import java.util.List;

public class User implements Observer {
    private String username;
    private String email;
    private List<Subscription> subscriptions;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
        this.subscriptions = new ArrayList<>();
    }

    public void addSubscription(Subscription subscription) {
        subscriptions.add(subscription);
    }

    public void removeSubscription(Subscription subscription) {
        subscriptions.remove(subscription);
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public void update(String message) {
        System.out.println("Notification for " + username + ": " + message);
    }

    public void update(String message, String strategy) {
        System.out.println("Notification for " + username + ": " + message + " using strategy: " + strategy);
    }
}


