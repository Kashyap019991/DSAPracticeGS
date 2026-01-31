package org.kas.demos.Prac.CoderpatQuest.DAY23_21_10.NotificationSystem;

public class EmailSender implements NotificationSender {
        // Dependencies for email sending (e.g., JavaMail API)
        @Override
        public void send(Notification notification) {
            // Logic to send email using recipientEmail, subject, body from EmailNotification
        }
        @Override
        public NotificationType getSupportedType() {
            return NotificationType.EMAIL;
        }
    }

    class SmsSender implements NotificationSender {
        // Dependencies for SMS sending (e.g., Twilio API)
        @Override
        public void send(Notification notification) {
            // Logic to send SMS using phoneNumber, message from SmsNotification
        }
        @Override
        public NotificationType getSupportedType() {
            return NotificationType.SMS;
        }
    }

    class PushSender implements NotificationSender {
        // Dependencies for push notification sending (e.g., Firebase Cloud Messaging)
        @Override
        public void send(Notification notification) {
            // Logic to send push notification using deviceToken, title, body from PushNotification
        }
        @Override
        public NotificationType getSupportedType() {
            return NotificationType.PUSH;
        }
    }