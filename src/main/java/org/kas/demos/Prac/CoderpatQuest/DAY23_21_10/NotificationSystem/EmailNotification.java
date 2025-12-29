package org.kas.demos.Prac.CoderpatQuest.DAY23_21_10.NotificationSystem;

    class EmailNotification implements Notification {
        public EmailNotification(String recipientEmail, String subject, NotificationType type) {
            this.recipientEmail = recipientEmail;
            this.subject = subject;
            this.type = type;
        }

        private String recipientEmail;
        private String subject;
        private NotificationType type;

        @Override
        public String getRecipient() {
            return "";
        }

        @Override
        public String getMessageContent() {
            return "";
        }

        @Override
        public NotificationType getType() {
            return type;
        }
        // Constructor, getters, and implementation of Notification methods
    }

    class SmsNotification implements Notification {
        private String phoneNumber;
        private String message;

        @Override
        public String getRecipient() {
            return "";
        }

        @Override
        public String getMessageContent() {
            return "";
        }

        @Override
        public NotificationType getType() {
            return null;
        }
        // Constructor, getters, and implementation of Notification methods
    }

    class PushNotification implements Notification {
        private String deviceToken;
        private String title;
        private String body;

        @Override
        public String getRecipient() {
            return "";
        }

        @Override
        public String getMessageContent() {
            return "";
        }

        @Override
        public NotificationType getType() {
            return null;
        }
        // Constructor, getters, and implementation of Notification methods
    }