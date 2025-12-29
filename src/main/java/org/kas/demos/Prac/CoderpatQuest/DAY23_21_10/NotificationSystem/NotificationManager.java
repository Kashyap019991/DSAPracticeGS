// src/main/java/com/notifications/manager/NotificationManager.java

package org.kas.demos.Prac.CoderpatQuest.DAY23_21_10.NotificationSystem;


import java.util.List;

/**
 * A Singleton class that serves as the public-facing entry point for the notification system.
 * It manages the single instance and delegates the sending of notifications to the NotificationService.
 */
public class NotificationManager {

    // The single instance of the NotificationManager.
    private static NotificationManager instance;

    // The NotificationService that handles the core logic of sending notifications.
    private final NotificationService notificationService;

    /**
     * Private constructor to prevent direct instantiation from outside the class.
     * Initializes the NotificationService.
     */
    private NotificationManager(List<NotificationSender> senders) {
        this.notificationService = new NotificationService(senders);
    }

    /**
     * Provides the global access point to the single instance of NotificationManager.
     * This method is synchronized to be thread-safe, ensuring that multiple threads
     * cannot create separate instances simultaneously.
     *
     * @return The single instance of NotificationManager.
     */
    public static synchronized NotificationManager getInstance(List<NotificationSender> senders) {
        if (instance == null) {
            instance = new NotificationManager(senders);
        }
        return instance;
    }

    /**
     * Sends a notification using the specified message and channel type.
     * This method simply delegates the request to the underlying NotificationService.
     *
     *he channel through which the notification should be sent.
     */
    public void send(Notification notification) {
        notificationService.sendNotification(notification);
    }
}
