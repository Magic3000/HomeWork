package ru.magic3000.homework1;

public abstract class Transport implements Fuelable {
    protected String color;
    protected double weight;
    protected static int maxSpeed = 60;
    protected int fuel;

    public Transport(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    protected abstract int getWheelCount();

    public static int getMaxSpeed() {
        return maxSpeed;
    }

    public static void setMaxSpeed(int maxSpeed) {
        Transport.maxSpeed = maxSpeed;
    }

    @Override
    public int getFuel() {
        return fuel;
    }

    @Override
    public void addFuel(int fuelCount) {
        for (int i = 0; i < fuelCount; i++) {
            fuel++;
        }
        System.out.println(String.format("Added %d fuel; Current fuel: %d", fuelCount, fuel));
    }

    @Override
    public void consumeFuel() {
        if (fuel <= 0) {
            throw new RuntimeException("Not enough fuel");
        }
        fuel--;
        System.out.println(String.format("Fuel consumed, fuel left: %d", fuel));
    }
}
