package ru.geekbrains.homework_11;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Integer[] temp = {1, 2, 3};
        System.out.println(convertToArrayList(temp));
        System.out.println(Arrays.toString(exchangeByIndex(temp, 0, 1)));
        System.out.println(Arrays.toString(exchangeByValue(temp, 2, 3)));
        final String typeApple = "apple";
        final String typeOrange = "orange";
        Fruit<String> apple = new Apple<>(typeApple);
        System.out.println(apple.getFruit());
        Fruit<String> orange = new Orange<>(typeOrange);
        System.out.println(orange.getFruit());
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

    public static <T> T[] exchangeByValue(T[] arr, T val1, T val2) {
        T tempVal;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(val1)) {
                tempVal = arr[i];
                for (int j = i; j < arr.length; j++) {
                    if (arr[j].equals(val2)) {
                        arr[i] = arr[j];
                        arr[j] = tempVal;
                    } else if (j == arr.length - 1 && !arr[j].equals(tempVal)) {
                        System.out.println("Cannot found value " + val2);
                        return null;
                    }
                }
            } else if (i == arr.length - 1 && !arr[i].equals(val1)) {
                System.out.println("Cannot found value " + val1);
                return null;
            }
        }
        return arr;
    }

    public static <T> ArrayList<T> convertToArrayList(T[] arr) {
        ArrayList<T> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, arr);
        return arrayList;
    }
}
