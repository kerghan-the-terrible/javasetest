package org.kerghan.java.learn.memory;

import org.junit.Test;

import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class WeekMapTest {

    private static class WeekKey {
        int k;
        private WeekKey(int k) {
            this.k = k;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            WeekKey weekKey = (WeekKey) o;
            return k == weekKey.k;
        }
        @Override
        public int hashCode() {
            return Objects.hash(k);
        }
    }

    private static class MetaData {
        String s;
        private MetaData(String s) {
            this.s = s;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MetaData metaData = (MetaData) o;
            return Objects.equals(s, metaData.s);
        }
        @Override
        public int hashCode() {
            return Objects.hash(s);
        }
    }

    @Test
    public void weekMap() {
        Map<WeekKey, MetaData> m = new WeakHashMap<>();
        m.put(new WeekKey(1), new MetaData("s1"));
        WeekKey k = new WeekKey(2);
        MetaData d = new MetaData("s2");
        m.put(k, d);
        assertEquals(m.get(new WeekKey(1)), new MetaData("s1"));
        System.gc();
        assertNull(m.get(new WeekKey(1)));
        assertEquals(m.get(k), d);
    }

}
