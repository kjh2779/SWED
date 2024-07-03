
package com.mycompany.swed3;

public class NotificationService {
    public void sendNotification(User user, String message) {
        
        System.out.println("Sending notification to " + user.getEmail() + ": " + message);
    }
}
