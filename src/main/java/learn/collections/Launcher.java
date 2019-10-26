package learn.collections;

import java.util.*;

public class Launcher {
    public static void main(String[] args) {
        Collection<String> lst1 = new ArrayList<>();
        lst1.add("val1");
        //lst.add(Integer.valueOf(1));

        List<String> lst2_l = new LinkedList<>();
        List<String> lst2_a = new ArrayList<>();
        List<String> lst2 = lst2_l;
        lst2.add("v1"); lst2.add("v2"); lst2.add("v3");
        (new Thread(new Runnable() {
            @Override
            public void run() {
                ListIterator<String> iter = lst2.listIterator();
                System.out.println("THREAD : " + iter.next());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("THREAD : " + iter.next());
                System.out.println("THREAD : " + iter.next());
                System.out.println("-----");
            }
        })).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ListIterator<String> iter1 = lst2.listIterator();
        ListIterator<String> iter2 = lst2.listIterator();
        iter1.next();
        iter1.set("v1_new");
        System.out.println("iter2 : "+iter2.next());
        iter2.next();
        //iter2.remove();
        System.out.println("iter2 : "+iter2.next());;
        iter2.set("v3_new");
        System.out.println("iter2 set");
        //lst2.add("v4");
        System.out.println("iter1 : "+iter1.next());
        System.out.println("iter1 : "+iter1.next());
        System.out.println(lst2);
        System.out.println("-----");

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Collection<Comparable> in1 = Arrays.asList("v5", "v2", "v3", "v1", "v4");
        int limit = 3;
        Iterator<Comparable> iter = in1.iterator();
        SortedSet<Comparable> topN = new TreeSet<>();
        Comparable item, min;
        while (iter.hasNext()) {
            if (topN.size() < limit) topN.add(iter.next());
            else {
                item = iter.next();
                min = topN.first();
                if (min.compareTo(item)<0) {
                    topN.remove(min);
                    topN.add(item);
                }
            }
        }
        System.out.println(topN);
        System.out.println("-----");

        String in2 = "Some sentence including chars";
        Character ch;
        Map<Character, Integer> res2 = new HashMap<>();
        for (char c : in2.toCharArray()) {
            ch = Character.valueOf(c);
            if (res2.containsKey(ch))
                res2.put(ch, res2.get(ch)+1);
            else
                res2.put(ch, 1);
        }
        System.out.println(res2);
    }
}
