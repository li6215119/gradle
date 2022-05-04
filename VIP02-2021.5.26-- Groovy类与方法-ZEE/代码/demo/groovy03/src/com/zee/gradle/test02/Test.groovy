package com.zee.gradle.test02

import com.zee.gradle.test01.Car

class Test {

    public static void main(String[] args) {
        def car = new Car()
        car.miles = 2000
        println car.miles
    }
}
