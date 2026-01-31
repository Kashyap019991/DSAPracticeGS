// src/main/java/com/notifications/DefMetImpl.java

package org.kas.demos.Prac.CoderpatQuest.DAY23_21_10.NotificationSystem;


import java.util.ArrayList;
import java.util.List;

public class Main {

    /**
     * The main method, the entry point of the application.
     * It showcases how to use the NotificationManager to send messages.
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        // Get the single instance of the NotificationManager
        //NotificationManager manager = NotificationManager.getInstance();

        // 1. Send an email notification
        System.out.println("Attempting to send an email notification...");
        //Message emailMessage = new Message("recipient@example.com", "Hello from the Notification System!", "Important Update");
        //manager.send("emailMessage", NotificationType.EMAIL);
        //System.out.println("Email notification sent successfully.\n");
        Notification notification = new EmailNotification("avb@gmail.com","kas",NotificationType.EMAIL);
        List<NotificationSender> senders = new ArrayList<>();
        senders.add(new EmailSender());
        senders.add(new PushSender());
        senders.add(new SmsSender());

        NotificationManager notificationManager = NotificationManager.getInstance(senders);
        notificationManager.send(notification);
        //NotificationManager sender = new EmailNotification();
        //NotificationService service  = new NotificationService();

    }
}
