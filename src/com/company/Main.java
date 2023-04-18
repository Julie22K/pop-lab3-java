package com.company;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int storageSize = 3;
        int itemNumbers = 10;
        int сonsumers=7;
        int producers=7;
        main.starter(storageSize, itemNumbers,producers,сonsumers);
    }

    private void starter(int storageSize, int itemNumbers,int producers,int сonsumers) {
        Manager manager = new Manager(storageSize);
        for(int i=0;i<сonsumers;i++){
            new Consumer(itemNumbers, manager,"Consumer "+i);
        }
        
        for(int i=0;i<producers;i++){
            new Producer(itemNumbers, manager,"Producer "+i);

        }
    }
}
