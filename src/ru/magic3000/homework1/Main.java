package ru.magic3000.homework1;

public class Main {
    public static void main(String[] args) {
        Calculator calc = v -> (v % 13) == 0;
        Discriminant d = (a, b, c) -> b * b - 4 * a * c;
    }
}
