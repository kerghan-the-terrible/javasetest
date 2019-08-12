package test.exceptions;

import org.junit.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class FinallyTest {

    private int returnFunc(boolean throwExc) {
        try {
            if (throwExc) throw new Exception();
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }

    @Test
    public void testReturnFunc() {
        assertEquals(returnFunc(false), 3);
        assertEquals(returnFunc(true), 3);
    }

}
