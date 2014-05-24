package com.company;

/**
 * Created by kruczjak on 19.05.14.
 */
public class NormalThread extends Thread {
    protected final Resource resource;

    public NormalThread(Resource resource, int id) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true)    {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource.doIt();
        }
    }

}
