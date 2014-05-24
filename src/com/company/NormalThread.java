package com.company;

/**
 * Created by kruczjak on 19.05.14.
 */
public class NormalThread extends Thread implements Priority{
    private final Resource resource;
    public final static int TYPE=1;
    private final int id;

    public NormalThread(Resource resource, int id) {
        this.resource = resource;
        this.id = id;
    }

    @Override
    public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource.doIt(id,true);
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
