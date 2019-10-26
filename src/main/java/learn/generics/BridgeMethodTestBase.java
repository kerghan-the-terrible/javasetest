package learn.generics;

import java.util.Calendar;

public class BridgeMethodTestBase implements Comparable<Calendar> {

    private Calendar cl;

    @Override
    public int compareTo(Calendar o) {
        return cl.compareTo(o);
    }

    public BridgeMethodTestBase(Calendar cl) {
        this.cl = cl;
    }
}
