package com.mycompany.swed2.main;

import com.mycompany.swed2.notification.CommunicationChannel;
import com.mycompany.swed2.notification.Notification;
import com.mycompany.swed2.utils.Frequency;
import com.mycompany.swed2.user.NotificationPreferences;
import com.mycompany.swed2.user.User;
import com.mycompany.swed2.website.Website;

public class Swed2 {

    public static void main(String[] args) {
        System.out.println("Starting application...");

        CommunicationChannel emailChannel = new CommunicationChannel("Email");
        System.out.println("Created CommunicationChannel.");
        System.out.println(emailChannel.getChannelName());

        NotificationPreferences preferences = new NotificationPreferences(Frequency.DAILY, emailChannel);
        System.out.println("Created NotificationPreferences.");
        System.out.println(preferences.getFrequency());
        System.out.println(preferences.getPreferredChannel().getChannelName());

        User user = new User(1, "JohnDoe", "john.doe@example.com", preferences);
        System.out.println("Created User.");
        System.out.println(user.getEmail());

        WebsiteMonitorSystem system = new WebsiteMonitorSystem();
        system.addUser(user);
        system.addWebsite(new Website("http://example.com"));
        System.out.println("Added user and website to system.");

        system.generateNotification("http://example.com", "New update available!");
        System.out.println("Generated notification.");

        // Print out the notifications to verify
        System.out.println("Printing notifications:");
        for (Notification notification : system.getNotifications()) {
            System.out.println("Notification message: " + notification.getMessage());
        }

        System.out.println("Application finished.");
    }
}
