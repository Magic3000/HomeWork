package ru.magic3000.homework1;

public interface TransportWithDoors {
    void openDoor(int doorIndex);
    void closeDoor(int doorIndex);
    boolean getDoorState(int doorIndex);
}
