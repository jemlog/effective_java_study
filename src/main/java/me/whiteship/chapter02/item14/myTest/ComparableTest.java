package me.whiteship.chapter02.item14.myTest;

import java.util.Arrays;

public class ComparableTest {

    public static void main(String[] args) {
        Car car1 = new Car(1);
        Car car2 = new Car(2);
        Car[] cars = new Car[]{car2,car1};
        Arrays.sort(cars);
        for (Car car : cars) {
            System.out.println(car.getNum());
        }
    }
}
