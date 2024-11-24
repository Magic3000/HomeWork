package ru.magic3000.homework1;

import java.util.HashMap;
import java.util.Map;

public class Car extends Transport implements TransportWithDoors {
    protected int doors;
    protected TransmissionType transmissionType;
    protected Map<Integer, Boolean> doorStates;

    public Car(String color, double weight, int doors, TransmissionType transmissionType) {
        super(color, weight);
        this.doors = doors;
        this.transmissionType = transmissionType;
        this.doorStates = new HashMap<>();
        for (int i = 0; i < doors; i++) {
            this.doorStates.put(i, false);
        }
    }

    @Override
    protected int getWheelCount() {
        return 4;
    }

    @Override
    public void openDoor(int doorIndex) {
        if (doorIndex < 0 || doorIndex >= doors) {
            throw new RuntimeException("Door out of range");
        }
        if (Boolean.FALSE.equals(doorStates.get(doorIndex))) {
            doorStates.put(doorIndex, true);
            System.out.println(String.format("Door %d opened", doorIndex));
        }
        else {
            System.out.println(String.format("Door %d is already opened", doorIndex));
        }
    }

    @Override
    public void closeDoor(int doorIndex) {
        if (doorIndex < 0 || doorIndex >= doors) {
            throw new RuntimeException("Door out of range");
        }
        if (Boolean.TRUE.equals(doorStates.get(doorIndex))) {
            doorStates.put(doorIndex, false);
            System.out.println(String.format("Door %d closed", doorIndex));
        }
        else {
            System.out.println(String.format("Door %d is already closed", doorIndex));
        }
    }

    @Override
    public boolean getDoorState(int doorIndex) {
        if (doorIndex < 0 || doorIndex >= doors) {
            throw new RuntimeException("Door out of range");
        }
        return Boolean.TRUE.equals(doorStates.get(doorIndex));
    }
}
