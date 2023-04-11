package org.example.PetrolStation;
import java.util.concurrent.Semaphore;

public class PetrolStation {
    private int amount;
    private Semaphore semaphore = new Semaphore(3);

    public PetrolStation(int amount) {
        this.amount = amount;
    }

    public void doRefuel(int fuelAmount) throws InterruptedException {
        semaphore.acquire();
        System.out.println("Starting refueling for " + fuelAmount + " liters");
        Thread.sleep((long)(Math.random() * 7000) + 3000);
        synchronized (this) {
            if (amount < fuelAmount) {
                fuelAmount = amount;
            }
            amount -= fuelAmount;
        }
        System.out.println("Finished refueling " + fuelAmount + " liters, remaining fuel: " + amount + " liters");
        semaphore.release();
    }
}