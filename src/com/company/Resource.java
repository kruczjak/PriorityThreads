package com.company;

/**
 * Created by kruczjak on 19.05.14.
 */
public class Resource {
    private final int n;
    private int i=0;

    public Resource(int n) {
        this.n = n;
    }

    public synchronized void doIt()  {
        if (!(Thread.currentThread() instanceof PriorityThread))    {
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

        System.out.println("Thread " + (Thread.currentThread() instanceof PriorityThread));
        notifyAll();
    }
}
