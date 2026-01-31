package org.kas.demos.Prac.DesignPat.Decorator;

public class CoffeeShop {
        public static void main(String[] args) {
            Coffee myCoffee = new BasicCoffee();
            System.out.println("Order: " + myCoffee.getDescription() + ", Cost: $" + myCoffee.getCost());

            // Add milk
            myCoffee = new MilkDecorator(myCoffee);
            System.out.println("Order: " + myCoffee.getDescription() + ", Cost: $" + myCoffee.getCost());

            // Add sugar
            myCoffee = new SugarDecorator(myCoffee);
            System.out.println("Order: " + myCoffee.getDescription() + ", Cost: $" + myCoffee.getCost());

            // Create another coffee with only milk
            Coffee anotherCoffee = new MilkDecorator(new BasicCoffee());
            System.out.println("Order: " + anotherCoffee.getDescription() + ", Cost: $" + anotherCoffee.getCost());
        }
    }