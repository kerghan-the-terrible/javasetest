package org.kerghan.java.learn.jvm.classloaders;

import org.junit.Test;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.Map;

public class PluginLoaderTest {

    private static PluginInterface loadPlugin(String path, String className) throws Exception {
        URLClassLoader loader = new URLClassLoader(new URL[]{new URL(path)});
        Class<?> pluginClass = loader.loadClass(className);
        return (PluginInterface) pluginClass.getConstructor().newInstance();
    }

    @Test
    public void testPlugin() throws Exception {
        PluginInterface plugin;
        plugin = loadPlugin(
                "file:///Users/kerghan/IdeaProjects/javasetest/classloader-plugin-impl/target/classloader-plugin-impl-1.0-SNAPSHOT-jar-with-dependencies.jar",
                "org.kerghan.java.learn.jvm.classloaders.TestPlugin"
        );
        plugin.doSomething();
        plugin = loadPlugin(
                "file:///Users/kerghan/IdeaProjects/javasetest/classloader-plugin-imp-alt/target/classloader-plugin-imp-alt-1.0-SNAPSHOT.jar",
                "org.kerghan.java.learn.jvm.classloaders.TestPlugin"
        );
        plugin.doSomething();
    }

}
