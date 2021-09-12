package ru.geekbrains.homework_11;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Integer[] temp = {1, 2, 3, 4, 5, 2, 3}; // Создание массива для тестирования методов
        System.out.println(convertToArrayList(temp)); // Преобразование массива в ArrayList
        System.out.println(Arrays.toString(exchangeByIndex(temp, 0, 1))); // Обмен местами двух переменных по индексу
        System.out.println(Arrays.toString(exchangeByValue(temp, 2, 3))); // Обмен местами двух переменных по значению. Метод заменит все найденные переменные

        Fruit<String> apple = new Apple<>("apple"); // Создание объекта Apple
        Fruit<String> orange = new Orange<>("orange"); // Создание объекта Orange

        Box<String> appleBox = new Box<>(apple.getFruit(), 5); // Создание коробки с 5 яблоками
        Box<String> orangeBox = new Box<>(orange.getFruit(), 4); // Создание коробки с 4 апельсинами
        Box<String> appleBox2 = new Box<>(apple.getFruit(), 11); // Создание коробки с 11 яблоками
        System.out.println(appleBox.getBox()); // Вывод содержимого коробки
        System.out.println(orangeBox.getBox());
        appleBox.addFruit(apple.getFruit()); // Добавление яблок в коробку
        System.out.println(appleBox.getBox());
        appleBox.addFruit(orange.getFruit()); // Попытка добавления апельсинов в коробку с яблоками
        System.out.println(appleBox.getBox());
        System.out.println(appleBox.getWeight()); // Получение веса коробки с яблоками
        System.out.println(orangeBox.getWeight()); // Получение веса коробки с апельсинами
        System.out.println(appleBox.compare(orangeBox)); // Сравнение веса двух коробок
        System.out.println(appleBox2.getBox());
        appleBox.shovel(appleBox2); // Пересыпание яблок из одной коробки в другую
        System.out.println(appleBox2.getBox());
        System.out.println(appleBox.getBox());
        orangeBox.shovel(appleBox); // Пересыпание апельсинов в пустую коробку из-под яблок. Так как в коробке нет яблок, апельсины успешно кладутся в неё
        System.out.println(appleBox.getBox());
        appleBox.shovel(appleBox2); // Попытка пересыпания апельсинов в коробку с яблоками. Так как объекты несовместимых типов, данная процедура не увенчалась успехом
        System.out.println(appleBox2.getBox());
    }

    public static <T> T[] exchangeByIndex(T[] arr, int x, int y) { // Метод смены мест двух элементов массива по индексу
        T temp;
        if (x >= 0 && x < arr.length && y >= 0 && y < arr.length) {
            temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
            return arr;
        } else System.out.println("Index is out of bounds of array");
        return null;
    }

    public static <T> T[] exchangeByValue(T[] arr, T val1, T val2) { // Метод смены мест двух элементов массива по значению
        ArrayList<Integer> tempArr1 = new ArrayList<>();
        ArrayList<Integer> tempArr2 = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(val1)) {
                tempArr1.add(i);
            }
            if (arr[i].equals(val2)) {
                tempArr2.add(i);
            }
        }
        if (tempArr1.isEmpty()) {
            System.out.println("Value " + val1 + " not found");
            return null;
        }
        if (tempArr2.isEmpty()) {
            System.out.println("Value " + val2 + " not found");
            return null;
        }
        for (Integer i : tempArr1) {
            arr[i] = val2;
        }
        for (Integer j : tempArr2) {
            arr[j] = val1;
        }
        return arr;
    }

    public static <T> ArrayList<T> convertToArrayList(T[] arr) { // Метод преобразования массива в ArrayList
        ArrayList<T> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, arr);
        return arrayList;
    }
}
