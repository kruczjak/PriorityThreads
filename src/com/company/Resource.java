package com.company;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kruczjak on 19.05.14.
 */
public class Resource {
    private final int n;
    private int i=0;
    private Set<Thread> priorityThreads;

    public Resource(int n) {
        this.n = n;
        priorityThreads = new HashSet<Thread>();
    }

    public synchronized void doIt()  {
        if (!priorityThreads.contains(Thread.currentThread()))    {
            while (i<n-1) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            i=0;
        } else {
            i++;
        }

        System.out.println("Thread " + priorityThreads.contains(Thread.currentThread()));
        notifyAll();
    }

    public synchronized void register(Thread t) {
        priorityThreads.add(t);
    }

}
