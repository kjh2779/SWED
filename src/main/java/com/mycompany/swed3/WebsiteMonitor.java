
package com.mycompany.swed3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class WebsiteMonitor implements Subject {
    private List<User> users;
    private NotificationService notificationService;
    private ScheduledExecutorService scheduler;

    public WebsiteMonitor() {
        this.users = new ArrayList<>();
        this.notificationService = new NotificationService();
        this.scheduler = Executors.newScheduledThreadPool(10);
    }

    public void registerUser(User user) {
        users.add(user);
        registerObserver(user);
        for (Subscription subscription : user.getSubscriptions()) {
            scheduleSubscriptionCheck(user, subscription);
        }
    }

    private void scheduleSubscriptionCheck(User user, Subscription subscription) {
        scheduler.scheduleAtFixedRate(() -> checkWebsiteForUpdates(user, subscription), 0, subscription.getFrequencyInSeconds(), TimeUnit.SECONDS);
    }
    private void checkWebsiteForUpdates(User user, Subscription subscription) {
        try {
            String content = fetchContent(subscription.getUrl());
            if (!subscription.getComparisonStrategy().compare(subscription.getLastContent(), content)) {
                subscription.setLastContent(content);
                user.update("Website " + subscription.getUrl() + " has been updated!", subscription.getComparisonStrategy().getClass().getSimpleName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String fetchContent(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        connection.disconnect();

        return content.toString();
    }

    @Override
    public void registerObserver(Observer observer) {
        if (observer instanceof User) {
            users.add((User) observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        if (observer instanceof User) {
            users.remove((User) observer);
        }
    }

    @Override
    public void notifyObservers(String message) {
        for (User user : users) {
            user.update(message);
        }
    }
}



