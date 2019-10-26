package org.kerghan.java.testtasks;

import org.junit.Test;

import static org.junit.Assert.*;

public class CompressString {

    private static String compressString(String input) {
        StringBuilder result = new StringBuilder();
        char[] arr = input.toCharArray();
        Character currChar = arr[0];
        int counter = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == currChar) counter++;
            else {
                result.append(currChar).append(counter);
                currChar = arr[i];
                counter = 1;
            }
        }
        result.append(currChar).append(counter);
        return result.toString();
    }

    @Test
    public void testCompress() {
        assertEquals("A3N2B1U2W2F1", compressString("AAANNBUUWWF"));
    }

}
