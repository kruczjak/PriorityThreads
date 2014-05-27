package com.company;

public class Main {

    public static void main(String[] args) {
        Resource resource = new Resource(5);
        for (int i=0;i<5;i++)   {
            new NormalThread(resource, i).start();
        }

        for (int i=0;i<5;i++)   {
            Thread t = new NormalThread(resource, i);
            resource.register(t);
            t.start();
        }
    }
}
