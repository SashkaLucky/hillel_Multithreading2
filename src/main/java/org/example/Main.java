package org.example;

import org.example.PetrolStation.PetrolStation;

public class Main {
    public static void main(String[] args) {
        PetrolStation petrolStation = new PetrolStation(100);

        Thread thread1 = new Thread(() -> {
            try {
                petrolStation.doRefuel(30);
                System.out.println("Thread 1 refueled successfully!");
            } catch (InterruptedException e) {
                System.out.println("Thread 1 was interrupted while refueling!");
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                petrolStation.doRefuel(50);
                System.out.println("Thread 2 refueled successfully!");
            } catch (InterruptedException e) {
                System.out.println("Thread 2 was interrupted while refueling!");
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                petrolStation.doRefuel(20);
                System.out.println("Thread 3 refueled successfully!");
            } catch (InterruptedException e) {
                System.out.println("Thread 3 was interrupted while refueling!");
            }
        });

        Thread thread4 = new Thread(() -> {
            try {
                petrolStation.doRefuel(10);
                System.out.println("Thread 4 refueled successfully!");
            } catch (InterruptedException e) {
                System.out.println("Thread 4 was interrupted while refueling!");
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}