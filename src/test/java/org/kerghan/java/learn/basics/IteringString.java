package org.kerghan.java.learn.basics;

import org.junit.Test;

import static org.junit.Assert.*;

public class IteringString {

    @Test
    public void stringLiteralItering() {

        String str1 = "10";
        String str2 = "10";
        assertTrue(str1 == str2);

        String str3 = new String("10");
        String str4 = new String("10");
        assertFalse(str3 == str4);
        assertEquals(str3, str4);

        assertFalse(str1 == str3);
        assertEquals(str1, str3);

        String str5 = str3.intern();
        assertTrue(str1 == str5);

        String str6 = String.valueOf(10);
        assertFalse(str1 == str6);
        assertEquals(str1, str6);

        StringBuilder builder = new StringBuilder();
        builder.append("str").append("ing1");
        assertFalse(str1 == builder.toString());

    }
}
