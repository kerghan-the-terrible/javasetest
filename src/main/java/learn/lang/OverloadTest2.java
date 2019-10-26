package learn.lang;

import java.util.Set;
import java.util.SortedSet;

public class OverloadTest2 extends OverloadTest {

    @Override
    public final void a(Set d) {
        System.out.println("OverloadTest2");
    }

    public void a(SortedSet d) {
        System.out.println("OverloadTest2 GregorianCalendar");
    }

}


