package org.kas.demos.Prac.CoderpatQuest.DAY2_17_09;

import java.util.*;
import java.util.stream.Collectors;
/**
 * Represents Station in the rail network. Each station is identified by unique name.
 * Station is connected with other stations - this information is stored in the 'neighbours' field.
 * Two station objects with the same name are equal therefore they are considered to be same station.
 */
 class Station {
    private String name;
    private List<Station> neighbours;

    Station(String name) {
        this.name = name;
        this.neighbours = new ArrayList<>(3);
    }

    String getName() {
        return name;
    }

    void addNeighbour(Station v) {
        this.neighbours.add(v);
    }

    List<Station> getNeighbours() {
        return this.neighbours;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Station && this.name.equals(((Station) obj).getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }
}

/**
 * class TrainMap
 * <p>
 * Respresents whole rail network - consists of number of the Station objects.
 * Stations in the map are bi-directionally connected. Distance between any 2 stations
 * is of same constant distance unit. This implies that shortest distance between any
 * 2 stations depends only on number of stations in between
 */
public class TrainMap {

    private HashMap<String, Station> stations;

    TrainMap() {
        this.stations = new HashMap<>();
    }

    TrainMap addStation(String name) {
        Station s = new Station(name);
        this.stations.putIfAbsent(name, s);
        return this;
    }

    Station getStation(String name) {
        return this.stations.get(name);
    }

    TrainMap connectStations(Station fromStation, Station toStation) {
        if (fromStation == null) throw new IllegalArgumentException("From station is null");
        if (toStation == null) throw new IllegalArgumentException("From station is null");

        fromStation.addNeighbour(toStation);
        toStation.addNeighbour(fromStation);
        return this;
    }

    public List<Station> shortestPath(String fromStationName, String toStationName) {
        // Handle invalid station names
        if (!stations.containsKey(fromStationName) || !stations.containsKey(toStationName)) {
            System.err.println("Error: One or both station names are invalid.");
            return Collections.emptyList();
        }

        Station startStation = stations.get(fromStationName);
        Station endStation = stations.get(toStationName);

        // If start and end stations are the same, the path is just that station
        if (startStation.equals(endStation)) {
            return Arrays.asList(startStation);
        }

        // Queue for BFS traversal, storing paths to current stations
        Queue<List<Station>> queue = new LinkedList<>();
        // Set to keep track of visited stations to avoid cycles and redundant processing
        Set<Station> visited = new HashSet<>();

        // Start with a path containing only the starting station
        List<Station> initialPath = new ArrayList<>();
        initialPath.add(startStation);
        queue.offer(initialPath);
        visited.add(startStation);

        while (!queue.isEmpty()) {
            List<Station> currentPath = queue.poll();
            Station currentStation = currentPath.get(currentPath.size() - 1); // Get the last station in the path

            // Explore neighbors of the current station
            for (Station neighbor : currentStation.getNeighbours()) {
                if (!visited.contains(neighbor)) {
                    // Create a new path by extending the current path with the neighbor
                    List<Station> newPath = new ArrayList<>(currentPath);
                    newPath.add(neighbor);

                    // If the neighbor is the destination, we found the shortest path
                    if (neighbor.equals(endStation)) {
                        return newPath;
                    }

                    // Add the new path to the queue and mark the neighbor as visited
                    queue.offer(newPath);
                    visited.add(neighbor);
                }
            }
        }

        // If the queue becomes empty and the destination was not reached, no path exists
        return Collections.emptyList();
    }
/*
 List<Station> shortestPath(final String from, final String to) {
    	Queue<Station> queue = new LinkedList<>();
        Map<Station, Station> parentMap = new HashMap<>();

        Station startStation = stations.get(from);
        Station endStation = stations.get(to);

        queue.add(startStation);
        parentMap.put(startStation, null);

        while (!queue.isEmpty()) {
        	Station currentStation = queue.poll();

            if (currentStation == endStation) {
                break; // Found the destination
            }

            for (Station neighbor : currentStation.getNeighbours()) {
                if (!parentMap.containsKey(neighbor)) {
                    queue.add(neighbor);
                    parentMap.put(neighbor, currentStation);
                }
            }
        }

        // Reconstruct the path
        List<Station> path = new ArrayList<>();
        Station current = endStation;
        while (current != null) {
            path.add(current);
            current = parentMap.get(current);
        }
        Collections.reverse(path);

        return path;
    }

 */
    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("Tests fail.");
        }
    }


    private static boolean doTestsPass() {
        // todo: implement more tests, please
        // feel free to make testing more elegant
        TrainMap trainMap = new TrainMap();

        trainMap.addStation("King's Cross St Pancras").addStation("Angel").addStation("Old Street").addStation("Moorgate")
                .addStation("Farringdon").addStation("Barbican").addStation("Russel Square").addStation("Holborn")
                .addStation("Chancery Lane").addStation("St Paul's").addStation("Bank");

        trainMap.connectStations(trainMap.getStation("King's Cross St Pancras"), trainMap.getStation("Angel"))
                .connectStations(trainMap.getStation("King's Cross St Pancras"), trainMap.getStation("Farringdon"))
                .connectStations(trainMap.getStation("King's Cross St Pancras"), trainMap.getStation("Russel Square"))
                .connectStations(trainMap.getStation("Russel Square"), trainMap.getStation("Holborn"))
                .connectStations(trainMap.getStation("Holborn"), trainMap.getStation("Chancery Lane"))
                .connectStations(trainMap.getStation("Chancery Lane"), trainMap.getStation("St Paul's"))
                .connectStations(trainMap.getStation("St Paul's"), trainMap.getStation("Bank"))
                .connectStations(trainMap.getStation("Angel"), trainMap.getStation("Old Street"))
                .connectStations(trainMap.getStation("Old Street"), trainMap.getStation("Moorgate"))
                .connectStations(trainMap.getStation("Moorgate"), trainMap.getStation("Bank"))
                .connectStations(trainMap.getStation("Farringdon"), trainMap.getStation("Barbican"))
                .connectStations(trainMap.getStation("Barbican"), trainMap.getStation("Moorgate"));

        String solution = "King's Cross St Pancras->Russel Square->Holborn->Chancery Lane->St Paul's";
        List<Station> result = trainMap.shortestPath("King's Cross St Pancras", "St Paul's");
        return solution.equals(result.stream().map(Station::getName).collect(Collectors.joining("->")));
    }

}