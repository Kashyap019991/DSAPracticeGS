package org.kas.demos.Prac.CoderpatQuest.DAY28_31_10;

public class MyCustomCheckedException extends Exception {
        public MyCustomCheckedException() {
            super();
        }

        public MyCustomCheckedException(String message) {
            super(message);
        }

        public MyCustomCheckedException(String message, Throwable cause) {
            super(message, cause);
        }

        public MyCustomCheckedException(Throwable cause) {
            super(cause);
        }
    }