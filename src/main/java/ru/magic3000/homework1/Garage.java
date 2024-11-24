package ru.magic3000.homework1;

public class Garage<T extends Transport> implements Repairer<T> {
    private String repairerName;

    public Garage() {
        this("Petrovich");
    }

    public Garage(String repairerName) {
        this.repairerName = repairerName;
    }

    @Override
    public void repairTransport(T transport) {
        System.out.println(String.format("Your transport %s was repaired by %s", transport.getClass().getSimpleName(), repairerName));
    }
}
