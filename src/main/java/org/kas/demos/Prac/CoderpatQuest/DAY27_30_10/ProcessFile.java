package org.kas.demos.Prac.CoderpatQuest.DAY27_30_10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//You have a File that needs to be processed. That file have dependencies on other files such that those files need to be processed first. Now write the method for processing the files.
/**
 * Represents a file as a node in a dependency graph.
 */
class FileNode {
    private String name;
    private List<FileNode> dependencies = new ArrayList<>();

    public FileNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<FileNode> getDependencies() {
        return dependencies;
    }

    public void addDependency(FileNode file) {
        dependencies.add(file);
    }
}

/**
 * Processes files in the correct dependency order using topological sort.
 */
class FileProcessor {
    // Keeps track of files that have been fully processed and added to the processedOrder list.
    private Set<FileNode> visited = new HashSet<>();
    // Keeps track of files currently in the DFS recursion stack to detect cycles.
    private Set<FileNode> visiting = new HashSet<>();
    // The final list of files in the correct processing order.
    private List<FileNode> processedOrder = new ArrayList<>();

    /**
     * Initiates the processing of all files in the input list.
     * @param files The list of all files to process.
     * @return The files in the correct processing order.
     */
    public List<FileNode> processFiles(List<FileNode> files) {
        for (FileNode file : files) {
            // Only start DFS if the file hasn't been visited yet (to handle disconnected components).
            if (!visited.contains(file)) {
                dfs(file);
            }
        }
        return processedOrder;
    }

    /**
     * Recursive Depth First Search to perform topological sort.
     * @param file The current file node being processed.
     */
    private void dfs(FileNode file) {
        // If the node is already in the visiting set, a cycle is detected.
        if (visiting.contains(file)) {
            throw new RuntimeException("Cycle detected involving " + file.getName());
        }

        // If not visited yet, begin processing.
        if (!visited.contains(file)) {
            visiting.add(file); // Mark as visiting

            // Recursively process all dependencies first.
            for (FileNode dep : file.getDependencies()) {
                dfs(dep);
            }

            visiting.remove(file); // Done with this node's branch of recursion
            visited.add(file);     // Mark as visited (fully processed)
            processedOrder.add(file); // Add to the final ordered list (after all dependencies)
        }
    }
}

/**
 * Main class to demonstrate the FileProcessor.
 */
public class ProcessFile {
    public static void main(String[] args) {
        // 1. Create all file nodes
        FileNode A = new FileNode("A");
        FileNode B = new FileNode("B");
        FileNode C = new FileNode("C");
        FileNode D = new FileNode("D");
        FileNode X = new FileNode("X");
        FileNode Y = new FileNode("Y");

        // 2. Define dependencies based on the prompt:
        // A -> B, C, D
        // C -> X, Y
        // X -> B
        A.addDependency(B);
        A.addDependency(C);
        A.addDependency(D);

        C.addDependency(X);
        C.addDependency(Y);

        X.addDependency(B);

        // Create a list of all top-level files we want to process
        // (A is the main one in this specific hierarchy, but adding all ensures everything is covered)
        List<FileNode> allFiles = new ArrayList<>();
        allFiles.add(A);
        // We only really need to start with 'A', as all other nodes are dependencies of 'A'.

        // 3. Process the files
        FileProcessor processor = new FileProcessor();
        List<FileNode> order = processor.processFiles(allFiles);

        // 4. Print the result
        System.out.println("The correct file processing order is:");
        for (int i = 0; i < order.size(); i++) {
            System.out.print(order.get(i).getName());
            if (i < order.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("\n(Expected Order: B, X, Y, C, D, A)");
    }
}
