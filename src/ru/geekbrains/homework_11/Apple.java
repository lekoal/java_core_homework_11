package ru.geekbrains.homework_11;

public class Apple<T> extends Fruit<T> { // Создание класса яблок с наследованием классу фруктов
    public Apple(T apple) {
        super(apple);
    }
}