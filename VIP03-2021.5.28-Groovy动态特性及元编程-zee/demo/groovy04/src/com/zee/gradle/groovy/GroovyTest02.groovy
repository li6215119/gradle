package com.zee.gradle.groovy

import groovy.transform.TypeChecked
import groovy.transform.TypeCheckingMode

// 1.不会进行安全检查，在运行时候才抛出异常？

class Person1 {
    def dream() {
        println "I have a dream!"
    }
}

class Person2 {
    def dream() {
        println "I have a dream!"
    }
}

// 使用@TypeChecked强制编译检查，但是会损失动态特性
@TypeChecked
def func(Person1 person) {
    person.dream()
}

def person1 = new Person1()
def person2 = new Person2()

func(person1)
func(person2)

@TypeChecked
class Test {

    @TypeChecked(TypeCheckingMode.SKIP)
    def func(person) {
        person.dream()
    }
}