package org.kerghan.java.learn.jvm.classes;

import org.junit.Test;

public class ClassLoaderTest {

    @Test
    public void standardVisibilityTest() throws  Exception {
        Class.forName(
                "org.kerghan.java.learn.jvm.classes.ClassLoaderTest",
                true,
                ClassLoaderTest.class.getClassLoader()
        );
        Class.forName(
                "org.kerghan.java.learn.jvm.classes.ClassLoaderTest",
                true,
                ClassLoaderTest.class.getClassLoader()
        );
    }

    @Test(expected = ClassNotFoundException.class)
    public void standardVisibilityFailTest() throws  Exception {
        Class.forName(
                "org.kerghan.java.learn.jvm.classes.ClassLoaderTest",
                true,
                ClassLoaderTest.class.getClassLoader().getParent()
        );
    }

}
