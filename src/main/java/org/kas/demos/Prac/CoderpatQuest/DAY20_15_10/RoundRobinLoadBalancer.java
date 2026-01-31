package org.kas.demos.Prac.CoderpatQuest.DAY20_15_10;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RoundRobinLoadBalancer {

    private final List<String> servers;
    private final AtomicInteger currentIndex = new AtomicInteger(0);

    public RoundRobinLoadBalancer(List<String> servers) {
        if (servers == null || servers.isEmpty()) {
            throw new IllegalArgumentException("Server list cannot be null or empty.");
        }
        this.servers = servers;
    }

    public String getNextServer() {
        int index = currentIndex.getAndIncrement();
        // Ensure index wraps around to the beginning of the list
        int serverIndex = index % servers.size();
        return servers.get(serverIndex);
    }

    public static void main(String[] args) {
        List<String> serverList = List.of("Server1", "Server2", "Server3");
        RoundRobinLoadBalancer loadBalancer = new RoundRobinLoadBalancer(serverList);

        System.out.println("Simulating 10 requests:");
        for (int i = 0; i < 10; i++) {
            String nextServer = loadBalancer.getNextServer();
            System.out.println("Request " + (i + 1) + ": Routed to " + nextServer);
        }
    }
}