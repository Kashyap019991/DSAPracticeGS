package org.kas.demos.Prac.CoderpatQuest.DAY28_31_10;

public class MyService {
        public void performAction(int value) throws MyCustomCheckedException {
            if (value < 0) {
                throw new MyCustomCheckedException("Value cannot be negative.");
            }
            // ... further logic
        }
    }