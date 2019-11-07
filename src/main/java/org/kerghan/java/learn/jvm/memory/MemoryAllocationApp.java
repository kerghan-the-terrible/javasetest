package org.kerghan.java.learn.jvm.memory;

import java.util.*;

public class MemoryAllocationApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Object> mem = new ArrayDeque<>();
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("exit")) break;
            switch(command) {
                case "alloc":
                    List<Object> lst = new ArrayList<>(1024);
                    for (int i = 0; i < 1024; i++) {
                        List<Long> nList = new ArrayList<>(1024);
                        for (int j = 0; j < 1024; j++) nList.add(Long.valueOf(128+i*j));
                        lst.add(nList);
                    }
                    mem.addFirst(lst);
                    break;
                case "allocBig":
                    mem.addFirst(new int[16*1024*1024]);
                    break;
                case "clean":
                    mem.clear();
                    break;
                case "gc":
                    System.gc();
                    break;
            }
        }
    }

}
