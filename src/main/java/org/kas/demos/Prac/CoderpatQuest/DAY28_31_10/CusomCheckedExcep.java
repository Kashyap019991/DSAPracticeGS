package org.kas.demos.Prac.CoderpatQuest.DAY28_31_10;

public class CusomCheckedExcep {
            public static void main(String[] args) {
                MyService service = new MyService();
                try {
                    service.performAction(-5);
                } catch (MyCustomCheckedException e) {
                    System.err.println("Error: " + e.getMessage());
                }
            }
        }