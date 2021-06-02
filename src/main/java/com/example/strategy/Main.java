package com.example.strategy;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        int a[] = {9, 2, 5, 7, 4, 3, 1, 8};
        Cat[] c = {new Cat(3,3), new Cat(5,5), new Cat(1,1) };
        Sorter<Cat> sorter = new Sorter();
        sorter.sort(c, new CatComparator());
        System.out.println(Arrays.toString(c));

        Dog[] a = { new Dog(5), new Dog(7), new Dog(2),  };
        Sorter<Dog> sorter2 = new Sorter();
        sorter2.sort(a, new DogComparator());
        System.out.println(Arrays.toString(a));
    }
}
