package org.kas.demos.Prac.CoderpatQuest.DAY26_29_10;

import java.util.List;
import java.util.ArrayList;

public class RoundRobinLoadBalancer {

    private List<String> servers;
    private int currentIndex;

    public RoundRobinLoadBalancer(List<String> servers) {
        this.servers = new ArrayList<>(servers); // Create a copy to avoid external modification
        this.currentIndex = 0;
    }

    public String getNextServer() {
        if (servers.isEmpty()) {
            return null; // No servers available
        }
        String nextServer = servers.get(currentIndex);
        currentIndex = (currentIndex + 1) % servers.size(); // Move to the next server in a circular manner
        return nextServer;
    }

    public static void main(String[] args) {
        List<String> serverList = new ArrayList<>();
        serverList.add("Server A (192.168.1.10)");
        serverList.add("Server B (192.168.1.11)");
        serverList.add("Server C (192.168.1.12)");

        RoundRobinLoadBalancer loadBalancer = new RoundRobinLoadBalancer(serverList);

        System.out.println("Simulating requests:");
        for (int i = 0; i < 10; i++) {
            String server = loadBalancer.getNextServer();
            if (server != null) {
                System.out.println("Request " + (i + 1) + ": Routed to " + server);
            } else {
                System.out.println("Request " + (i + 1) + ": No servers available.");
            }
        }
    }
}