package com.company;

public class Producer implements Runnable{
    private final int itemNumbers;
    private final Manager manager;
    private final String name;
    public Producer(int itemNumbers, Manager manager,String name) {
        this.itemNumbers = itemNumbers;
        this.manager = manager;
        this.name=name;

        new Thread(this).start();
    }

    @Override
    public void run() {
        while (manager.counter<this.itemNumbers) {
            try {
                manager.full.acquire();
                manager.access.acquire();
                if(manager.counter>=this.itemNumbers){
                    manager.full.release();
                    manager.access.release();
                    break;
                }

                manager.storage.add("item " + manager.counter);
                System.out.println(this.name+" added item " + manager.counter);
                manager.counter++;

                manager.access.release();
                manager.empty.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
