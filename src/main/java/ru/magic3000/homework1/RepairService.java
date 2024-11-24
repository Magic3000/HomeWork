package ru.magic3000.homework1;

public class RepairService<T extends Transport> implements Repairer<T> {
    @Override
    public void repairTransport(T transport) {
        System.out.println(String.format("Transport %s repaired", transport.getClass().getSimpleName()));
    }
}
