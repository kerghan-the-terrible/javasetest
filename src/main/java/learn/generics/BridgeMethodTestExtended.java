package learn.generics;

import java.util.Calendar;

public class BridgeMethodTestExtended extends BridgeMethodTestBase /*implements Comparable<GregorianCalendar>*/ {
    public BridgeMethodTestExtended(Calendar cl) {
        super(cl);
    }
}
