package learn.generics;

import java.io.Serializable;

public class BridgeMethodTest2<T extends BridgeMethodTestBase & Serializable /*& Comparable<GregorianCalendar>*/> {
}
