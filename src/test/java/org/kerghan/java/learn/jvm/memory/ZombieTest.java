package org.kerghan.java.learn.jvm.memory;

import org.junit.Test;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

import static org.junit.Assert.*;

public class ZombieTest {

    static private Zombie staticRef = null;

    static private class Zombie {
        public int[] data = new int[1024*1024];
        @Override
        public void finalize() {
            System.out.println("Brains!");
            staticRef = this;
        }
    }

    @Test
    public void zombieRef() throws InterruptedException {
        staticRef = null;
        ReferenceQueue<Zombie> queue = new ReferenceQueue<>();
        Zombie zombie = new Zombie();
        Reference<Zombie> ref = new WeakReference<>(zombie, queue);
        zombie = null;
        assertNull(staticRef);
        System.gc();
        Thread.sleep(500); //the assertion below can fail from time to time without the sleep (HotSpot JDK)
        assertNotNull(staticRef);
        assertEquals(queue.remove(), ref);
    }

    @Test
    public void phantomZombieRef() throws InterruptedException {
        staticRef = null;
        ReferenceQueue<Zombie> queue = new ReferenceQueue<>();
        Zombie zombie = new Zombie();
        Reference<Zombie> ref = new PhantomReference<>(zombie, queue);
        zombie = null;
        System.gc();
        Thread.sleep(500); //the assertion below can fail from time to time without the sleep (HotSpot JDK)
        assertNotNull(staticRef);
        Reference<? extends Zombie> queueRef;
        //queueRef = queue.remove(); //will hang
        queueRef = queue.poll();
        assertNull(queueRef);
        staticRef = null;
        System.gc();
        queueRef = queue.remove();
        assertEquals(queueRef, ref);
    }

}
