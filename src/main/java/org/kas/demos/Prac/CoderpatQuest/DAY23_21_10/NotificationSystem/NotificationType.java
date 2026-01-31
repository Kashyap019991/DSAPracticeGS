// src/main/java/com/notifications/NotificationType.java

package org.kas.demos.Prac.CoderpatQuest.DAY23_21_10.NotificationSystem;

/**
 * Represents the type of a notification channel.
 * Using an enum provides compile-time safety and a fixed set of options.
 * It's a best practice to use enums for a closed set of related constants.
 */
public enum NotificationType {
    EMAIL,
    SMS,
    PUSH
}
