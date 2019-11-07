package org.kerghan.java.learn.basics;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrimitiveWrappers {

    @Test
    public void testWrappers() {

        Integer int1 = 5;
        Integer int2 = 5;
        assertTrue(int1 == int2);

        Integer int3 = 150;
        Integer int4 = 150;
        assertFalse(int3 == int4);

        Integer int5 = Integer.valueOf(5);
        assertTrue(int1 == int5);

        Integer int6 = Integer.valueOf(150);
        Integer int7 = Integer.valueOf(150);
        assertFalse(int6 == int7);

        Integer int8 = new Integer(5);
        Integer int9 = new Integer(5);
        assertFalse(int8 == int9);

        Integer int10 = Integer.valueOf("5");
        assertTrue(int5 == int10);

        Long long1 = 5l;
        Long long2 = Long.valueOf(5l);
        assertTrue(long1 == long2);

        Long long3 = 500l;
        Long long4 = 500l;
        assertFalse(long3 == long4);

        Short short1 = Short.valueOf((short)5);
        Short short2 = 5;
        assertTrue(short1 == short2);

        Byte byte1 = Byte.valueOf((byte)5);
        Byte byte2 = 5;
        assertTrue(byte1 == byte2);

        Character char1 = Character.valueOf('a');
        Character char2 = 'a';
        assertTrue(char1 == char2);

        Float float1 = Float.valueOf(5.0f);
        Float float2 = 5.0f;
        assertFalse(float1 == float2);

        Double double1 = Double.valueOf(5.0d);
        Double double2 = 5.0d;
        assertFalse(double1 == double2);

    }

}
