package org.kerghan.java.learn.jvm.classloaders;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;

public class MetaspaceAllocationApp {

    private static List<Object> loadClass(String path, String className) throws Exception {
        List<Object> res = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            URLClassLoader loader = new URLClassLoader(new URL[]{new URL(path)});
            Class<?> loadedClass = Class.forName(className, true, loader);
            res.add(loadedClass.getConstructor().newInstance());
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        List<Object> refs = new ArrayList<>();
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("exit")) break;
            switch(command) {
                case "alloc":
                    refs.add(loadClass(
                            "file:///Users/kerghan/IdeaProjects/javasetest/classloader-plugin-impl/target/classloader-plugin-impl-1.0-SNAPSHOT-jar-with-dependencies.jar",
                            "org.kerghan.java.learn.jvm.classloaders.MemoryAllocationClass"
                    ));
                    System.out.println("Elements count: " + refs.size());
                    break;
                case "clean":
                    refs.clear();
                    System.out.println("Elements count: " + refs.size());
                    break;
                case "gc":
                    System.gc();
                    break;
            }
        }

    }

}
