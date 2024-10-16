package ru.magic3000.homework1;

public class Motorbike extends Transport {
    protected double leanAngle;
    protected DriveType driveType;
    protected boolean isKickstandExposed;

    public Motorbike(String color, double weight, double leanAngle, DriveType driveType) {
        super(color, weight);
        this.leanAngle = leanAngle;
        this.driveType = driveType;
    }

    @Override
    protected int getWheelCount() {
        return 2;
    }

    public void toggleKickstand() {
        isKickstandExposed = !isKickstandExposed;
        System.out.println(String.format("Kickstand is now %s", isKickstandExposed ? "exposed" : "folded"));
    }
}
