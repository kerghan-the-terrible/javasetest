package org.kerghan.java.learn.jvm.classloaders;

public class TestPlugin implements PluginInterface {

    @Override
    public void doSomething() {
        System.out.println(String.format("do something\n%s\n%s\n%s",
                getClass(),
                getClass().getClassLoader(),
                getClass().getClassLoader().getParent()
        ));
    }
}
