package com.company;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kruczjak on 19.05.14.
 */
public class Resource {
    private final int n;
    private int i=0;
    private Set<Thread> priorityThreads = new HashSet<Thread>();


    public Resource(int n) {
        this.n = n;
    }

    public synchronized void doIt(int i, boolean isNormal)  {
        if (!priorityThreads.isEmpty()&&!priorityThreads.contains(Thread.currentThread()))    {
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

        System.out.println("Thread " + i + " " + isNormal);
        notifyAll();
    }

    public synchronized void add(Thread thread) {
        priorityThreads.add(thread);
    }

    public synchronized void remove(Thread thread) {
        priorityThreads.remove(thread);
    }
}
