package com.example.factorymethod;

import com.example.strategy.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        Car c = new Car();
//        c.go();
        Moveable m = new CarFactory().createCar();
        m.go();



    }
}
