package com.company;

public class Main {

    public static void main(String[] args) {
        Resource resource = new Resource(5);
        for (int i=0;i<100;i++)   {
            new NormalThread(resource, i).start();
        }

        for (int i=0;i<100;i++)   {
            new PriorityThread(resource, i).start();
        }
    }
}
