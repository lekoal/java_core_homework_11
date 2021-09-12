package ru.geekbrains.homework_11;

public abstract class Fruit<T> { // Создание абстрактного класса фруктов
    private final T fruit;

    public Fruit(T fruit) {
        this.fruit = fruit;
    }

    public T getFruit() {
        return fruit;
    }

}