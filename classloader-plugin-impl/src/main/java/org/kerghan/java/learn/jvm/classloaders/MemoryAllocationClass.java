package org.kerghan.java.learn.jvm.classloaders;

import java.util.ArrayList;
import java.util.List;

public class MemoryAllocationClass {

    public static int[] heap = new int[4*1024];

    public static List<Object> list = new ArrayList<>();

    static {
        System.out.println("init " + MemoryAllocationClass.class + " by " + MemoryAllocationClass.class.getClassLoader());
        try {
            Class.forName("org.postgresql.PGConnection", true, MemoryAllocationClass.class.getClassLoader());
            Class.forName("org.postgresql.PGNotification", true, MemoryAllocationClass.class.getClassLoader());
            Class.forName("org.postgresql.PGProperty", true, MemoryAllocationClass.class.getClassLoader());
            Class.forName("org.postgresql.PGResultSetMetaData", true, MemoryAllocationClass.class.getClassLoader());
            Class.forName("org.postgresql.PGStatement", true, MemoryAllocationClass.class.getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
