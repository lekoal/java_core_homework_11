package ru.geekbrains.homework_11;

import java.util.ArrayList;

public class Box<T> { // Создание класса коробки
    private int quantity; // Количество фруктов
    private final T fruit; // Переменная фруктов любого ссылочного типа
    private float weight = 0.0F; // Переменная для хранения веса фруктов
    private float weight2 = 0.0F; // Переменная для хранения веса фруктов
    private ArrayList<T> box = new ArrayList<>(); // Создание ArrayList для хранения фруктовых объектов

    public Box(T fruit, int quantity) { // Конструктор принимает тип фрукта и количество
        this.fruit = fruit;
        this.quantity = quantity;
        if (fruit.equals("apple")) this.weight = 1.0F; // Вес по-умолчанию для яблок
        if (fruit.equals("orange")) this.weight = 1.5F; // Вес по-умолчанию для апельсинов
        fillBox(fruit, quantity); // Вызов метода заполнения коробки
    }

    public void fillBox(T fruit, int quantity) { // Метод заполнения коробки
        for (int i = 0; i < quantity; i++) {
            box.add(fruit);
        }
    }

    public ArrayList<T> getBox() {
        return box;
    }

    public boolean addFruit(T fruit) { // Метод добавления фрукта в коробку
        if (fruit.equals(box.get(0))) { // Проверка на совпадения типа фрукта
            box.add(fruit);
            return true;
        } else System.out.println("Wrong fruit type");
        return false;
    }

    public float getWeight() { // Метод вычисления веса коробки
        return box.size() * weight;
    }

    public float getWeight(ArrayList<T> boxTwo) { // Метод вычисления веса второй коробки
        if (boxTwo.get(0).equals("apple")) weight2 = 1.0F; // Определение типа фрукта и запись его веса в переменную
        if (boxTwo.get(0).equals("orange")) weight2 = 1.5F; // Определение типа фрукта и запись его веса в переменную
        return boxTwo.size() * weight2;
    }

    public boolean compare(Box<T> boxTwo) { // Метод сравнения весов двух коробок
        return (getWeight() == getWeight(boxTwo.getBox()));
    }

    public void shovel(Box<T> boxTwo) { // Метод пересыпания фруктов из одной коробки в другую
        if (boxTwo.getBox().isEmpty() || box.get(0).equals((boxTwo.getBox().get(0)))) { // Проверка условия пустоты коробки или совпадения типов фруктов
            if (boxTwo.getBox().isEmpty()) {
                boxTwo.getBox().addAll(0, box);
            } else {
                boxTwo.getBox().addAll(box.size(), box);
                box.clear(); // После очистки коробка становится пустой
            }
        } else System.out.println("Incompatible fruit types");
    }
}