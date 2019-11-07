package org.kerghan.java.learn.collections;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class HashMapTest {

    @Test
    public void basicTest() {
        Map<String, String> map = new HashMap<>();
        map.put(null, "val");
        assertEquals("val", map.get(null));
        map.put(null, null);
        assertNull(map.get(null));
    }
}
