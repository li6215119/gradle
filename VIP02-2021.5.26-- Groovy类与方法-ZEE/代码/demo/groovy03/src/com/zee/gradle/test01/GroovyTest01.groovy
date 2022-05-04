package com.zee.gradle.test01

class Car {
    def miles
    def year

    def getMiles() {
        println "getMiles"
        return miles
    }

    private void setMiles(miles) {
//        throw new IllegalAccessException("can not set")
        println "setMiles"
        this.miles = miles
    }

    void execute(x = 1, y = 2, z=3) {
        println "$x $y $z"
    }

//    void execute(a) {
//        println "$x $y $z"
//    }

}

//def car = new Car()
//car.miles = 20000
//car.@year = 2027
//println car.miles
//// 通过'.变量名'进行访问
//println car.'miles'
//def str = "year"
//println car."$str"

// 1.Groovy对于private修饰的变量没有强制性
// 2.在类的构造方法中使用具名参数:
//def map = [miles: 20000, year: 2021]
//def car = new Car(miles: 20000, year: 2021)
//println(car.miles)// 它优先的是当成Map匹配构造方法，如果匹配不到，就无参构造方法，然后调用对应属性的getter/setter

// 3.方法不支持类似的具名参数
Car c = new Car()
//c.execute(x: 1, y: 2, z: 3, 2222, c: 111, 3333, a: 111, b: 222)
//c.execute( 1, 3, 6)
//c.execute()
c.execute(10)
c.execute(10, 20)
c.execute(10, 20, 30)

// 4.但是方法可以设置初始的默认值，注意方法重载


