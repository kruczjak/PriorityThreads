package com.company;

/**
 * Created by kruczjak on 19.05.14.
 */
public class PriorityThread extends Thread implements Priority{
    private final Resource resource;
    public final static int TYPE=0;
    private final int id;

    public PriorityThread(Resource resource, int id) {
        this.resource = resource;
        this.id = id;
        resource.add(this);
    }

    @Override
    public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource.doIt(id,false);

        resource.remove(this);

    }

    @Override
    public int getType() {
        return TYPE;
    }

    @Override
    public int getID() {
        return id;
    }
}
