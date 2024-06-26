package com.mycompany.swed2.main;

import com.mycompany.swed2.notification.Observer;
import com.mycompany.swed2.notification.Subject;
import com.mycompany.swed2.notification.NotificationManager;
import com.mycompany.swed2.user.User;
import com.mycompany.swed2.website.Website;
import com.mycompany.swed2.notification.Notification;

import java.util.ArrayList;
import java.util.List;

public class WebsiteMonitorSystem implements Subject {
    private List<Observer> observers;
    private NotificationManager notificationManager;
    private List<User> users;
    private List<Website> websites;

    public WebsiteMonitorSystem() {
        observers = new ArrayList<>();
        notificationManager = new NotificationManager();
        users = new ArrayList<>();
        websites = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void addUser(User user) {
        users.add(user);
        registerObserver(user);
    }

    public void addWebsite(Website website) {
        websites.add(website);
    }

    public void generateNotification(String websiteURL, String message) {
        System.out.println("Generating notification for website: " + websiteURL);
        for (Website website : websites) {
            if (website.getURL().equals(websiteURL)) {
                notificationManager.addNotification(message, null); // null recipient, handled by Observer pattern
                notifyObservers(message);
                break;
            }
        }
    }

    public List<Notification> getNotifications() {
        return notificationManager.getNotifications();
    }

    // Other methods...
}
