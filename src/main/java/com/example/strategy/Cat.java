package com.example.strategy;

public class Cat implements Comparable<Cat>{

    int weight, height;

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }
    // 猫比较大小的策略 灵活指定
    public int compareTo(Cat c){
        if(this.weight < c.weight) return -1;
        else if(this.weight > c.weight) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Car{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }

}
