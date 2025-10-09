package org.kas.demos.Prac.CoderpatQuest.DAY12_1_10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyCustomClassLoader extends ClassLoader {

    private String classDir;

    public MyCustomClassLoader(String classDir, ClassLoader parent) {
        super(parent);
        this.classDir = classDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] classData = loadClassData(name);
            return defineClass(name, classData, 0, classData.length);
        } catch (IOException e) {
            throw new ClassNotFoundException("Could not load class: " + name, e);
        }
    }

    private byte[] loadClassData(String name) throws IOException {
        String fileName = name.replace('.', '/') + ".class";
        Path filePath = Paths.get(classDir, fileName);
        return Files.readAllBytes(filePath);
    }
}