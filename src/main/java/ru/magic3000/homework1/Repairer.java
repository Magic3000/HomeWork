package ru.magic3000.homework1;

public interface Repairer<T extends Transport> {
    void repairTransport(T transport);
}
