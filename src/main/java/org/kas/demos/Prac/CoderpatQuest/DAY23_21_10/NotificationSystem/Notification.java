package org.kas.demos.Prac.CoderpatQuest.DAY23_21_10.NotificationSystem;

public interface Notification {
        String getRecipient();
        String getMessageContent();
        NotificationType getType(); // Enum: EMAIL, SMS, PUSH
        // Add other common attributes like subject, sender, etc. if needed
    }