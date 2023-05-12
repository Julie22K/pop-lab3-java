package com.company;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int storageSize = 3;
        int itemNumbers = 10;
        int num_consumers=4;
        int num_producers=8;
        main.starter(storageSize, itemNumbers,num_consumers,num_producers);
    }

    private void starter(int storageSize, int itemNumbers,int num_consumers,int num_producers) {
        Manager manager = new Manager(storageSize);
        for (int i=0;i<num_consumers;i++){
            new Consumer(itemNumbers, manager,"Consumer#" + i);
        }
        for (int i=0;i<num_producers;i++){
            new Producer(itemNumbers, manager,"Producer#"+i);

        }
    }
}
