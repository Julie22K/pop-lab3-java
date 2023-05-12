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
        for (int i = 0; i < itemNumbers; i++) {
            try {
                manager.full.acquire();
                manager.access.acquire();

                if(manager.item_counter<itemNumbers) {
                    manager.storage.add("item " + manager.item_counter);
                    System.out.println(name + " added item " + manager.item_counter);
                    manager.item_counter++;

                    manager.access.release();
                    manager.empty.release();
                }
                else{
                    manager.access.release();
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
