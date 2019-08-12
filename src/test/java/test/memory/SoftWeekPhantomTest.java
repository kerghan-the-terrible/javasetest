package test.memory;

import org.junit.Test;

import java.lang.ref.*;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

import static org.junit.Assert.*;

public class SoftWeekPhantomTest {

    @Test
    public void weekRef() throws InterruptedException {
        ReferenceQueue<StringBuilder> queue = new ReferenceQueue<>();
        Reference<StringBuilder> ref = new WeakReference<>(new StringBuilder(), queue);
        ref.get().append("some stuff");
        assertEquals(ref.get().toString(), "some stuff");
        System.gc();
        assertNull(ref.get());
        assertEquals(queue.remove(), ref);
    }

    @Test
    public void softRef() {
        ReferenceQueue<StringBuilder> queue = new ReferenceQueue<>();
        Reference<StringBuilder> ref = new SoftReference<>(new StringBuilder(), queue);
        ref.get().append("some stuff");
        System.gc();
        assertEquals(ref.get().toString(), "some stuff");
        assertNull(queue.poll());
    }

    private static boolean resourceBusy = false;

    private static class PhantomResourceManagement extends PhantomReference<StringBuilder> {
        private PhantomResourceManagement(StringBuilder ref, ReferenceQueue<StringBuilder> queue) {
            super(ref, queue);
            resourceBusy = true;
        }
        private void freeResource() {
            resourceBusy = false;
        }
    }

    @Test
    public void phantomRef() throws InterruptedException {
        ReferenceQueue<StringBuilder> queue = new ReferenceQueue<>();
        Reference<StringBuilder> ref = new PhantomResourceManagement(new StringBuilder("gdfgdfgdf"), queue);
        System.gc();
        PhantomResourceManagement queueRef = (PhantomResourceManagement) queue.remove();
        assertEquals(queueRef, ref);
        queueRef.freeResource();
        assertFalse(resourceBusy);
    }

}
