package org.kas.demos.Prac.CoderpatQuest.DAY36_11_11;

import java.util.Arrays;
import java.util.List;

class Order {
    private int amount;

    public Order(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Order{" +
               "amount=" + amount +
               '}';
    }
}

public class StreamOrderSum {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
            new Order(25),
            new Order(40),
            new Order(15),
            new Order(50),
            new Order(30),
            new Order(60)
        );

        int sumOfLargeOrders = orders.stream()
                                     .filter(order -> order.getAmount() > 30)
                                     .mapToInt(Order::getAmount)
                                     .sum();

        System.out.println("Sum of orders with amount > 30: " + sumOfLargeOrders);
    }
}