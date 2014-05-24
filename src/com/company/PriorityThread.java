package com.company;

/**
 * Created by kruczjak on 19.05.14.
 */
public class PriorityThread extends NormalThread {

    public PriorityThread(Resource resource, int id) {
        super(resource,id);
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
