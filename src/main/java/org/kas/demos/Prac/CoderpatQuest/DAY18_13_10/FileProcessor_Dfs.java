package org.kas.demos.Prac.CoderpatQuest.DAY18_13_10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Q. You have a File that needs to be processed.
// That file have dependencies on other files such that those files need
// to be processed first. Now write the method for processing the files.

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

class FileProcessor_Dfs {
    private Set<FileNode> visited = new HashSet<>();
    private Set<FileNode> visiting = new HashSet<>();
    private List<FileNode> processedOrder = new ArrayList<>();

    // Process all files in dependency order
    public List<FileNode> processFiles(List<FileNode> files) {
        for (FileNode file : files) {
            if (!visited.contains(file)) {
                dfs(file);
            }
        }
        return processedOrder;
    }
    // A -> B,C,D
//C -> X, Y
//X -> B
    private void dfs(FileNode file) {
        if (visiting.contains(file)) {
            throw new RuntimeException("Cycle detected involving " + file.getName());
        }

        if (!visited.contains(file)) {
            visiting.add(file);

            for (FileNode dep : file.getDependencies()) {
                dfs(dep);
            }

            visiting.remove(file);
            visited.add(file);
            processedOrder.add(file);
        }
    }

        public static void main(String[] args) {
            // 1. Create FileNode objects for all files
            FileNode a = new FileNode("A");
            FileNode b = new FileNode("B");
            FileNode c = new FileNode("C");
            FileNode d = new FileNode("D");
            FileNode x = new FileNode("X");
            FileNode y = new FileNode("Y");

            // 2. Define dependencies based on the problem description
            // A -> B,C,D
            a.addDependency(b);
            a.addDependency(c);
            a.addDependency(d);

            // C -> X,Y
            c.addDependency(x);
            c.addDependency(y);

            // X -> B
            x.addDependency(b);

            // 3. Create a list of all files to be processed
            List<FileNode> allFiles = new ArrayList<>();
            allFiles.add(a);
            allFiles.add(b);
            allFiles.add(c);
            allFiles.add(d);
            allFiles.add(x);
            allFiles.add(y);

            // 4. Instantiate and run the FileProcessor
            FileProcessor_Dfs processor = new FileProcessor_Dfs();
            try {
                List<FileNode> processedOrder = processor.processFiles(allFiles);
                System.out.println("Processing Order:");
                for (FileNode file : processedOrder) {
                    System.out.println(file.getName());
                }
            } catch (RuntimeException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
}
/*
Q. Suppose below is the dependency of files. What will be the order or processing of files.
        A -> B,C,D
C -> X, Y
X -> B
*/

