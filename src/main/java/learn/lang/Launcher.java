package learn.lang;

import java.util.HashSet;
import java.util.TreeSet;

public class Launcher {

    public static void main(String[] args) {
        long l = 4000000000L;
        System.out.println(l);
        int i = (int) l;
        System.out.println(i);
        System.out.println("-----");

        OverloadTest o1 = new OverloadTest2();
        o1.a(new HashSet(64, 1.5f));
        o1.a(new TreeSet());
        OverloadTest2 o2 = new OverloadTest2();
        o2.a(new HashSet());
        o2.a(new TreeSet());

        int notFinalVar;
        notFinalVar = 5;

        TestAnon anon = new TestAnon2(notFinalVar) {
            @Override
            public int a() {
                return 10+super.a();
            }
        };
        System.out.println(anon.a());

    }
}
