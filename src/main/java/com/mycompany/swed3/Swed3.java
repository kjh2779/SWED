

package com.mycompany.swed3;

/**
 *
 * @author kjh27
 */
public class Swed3 {

    public static void main(String[] args) {
        WebsiteMonitor monitor = new WebsiteMonitor();

        User user1 = new User("kim", "kim@gmail.com");
        Subscription sub1 = new Subscription("http://www.google.com", 10, "email", new ContentSizeComparison()); // Check every 10 seconds using content size comparison
        Subscription sub2 = new Subscription("http://www.google.com", 15, "email", new HtmlContentComparison()); // Check every 15 seconds using HTML content comparison
        Subscription sub3 = new Subscription("http://www.google.com", 20, "email", new TextContentComparison()); // Check every 20 seconds using text content comparison

        user1.addSubscription(sub1);
        user1.addSubscription(sub2);
        user1.addSubscription(sub3);

        monitor.registerUser(user1);
    }
}
