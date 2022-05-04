package com.zee.gradle

class Car {
    // var val
    def miles
    private year = 2027

//    private void setYear(year) {
//        this.year = year
//    }
//
//    private def getYear() {
//        year
//    }

//    def plus(){
//
//
//    }

    def closureTest(def param1, Closure closure) {

    }


}

new Car().closureTest{

}

//class Test{
//    public static void main(String[] args) {
//
//    }
//}

//def car = new Car(miles: 1000)
//println car.miles.getClass

//def name = 'carName'
////def realName = "$name:AAAA"
////def string='''
////carName
////is
////$name
////'''
////
//////println name.getClass()
//////println realName.getClass()
////println string

//def method(Object obj) {
//    1
//}
//
//def method(String str) {
//    2
//}
//
//Object o = "AAA"
//println("method${method(o)} is invoked")

//def array = ["1", "2", 3]
//println array.getClass()
//// int []
//String[] array2 = ["1", new Object(), "3"]
////def array2 = [1, 2, 3] as int[]
//println array2.getClass()
//
//println array2[1].toString()
//println array2[1].getClass()

// [0,10]
// [0,10)
// 'a'..'x'
//('a'..'x').forEach{
//    println it
//}
//
//def range = 0..10
//println range.getClass()

// [k1：v1，k2：v2]
def map = [a: 11, b: 12]
map.forEach { k, v ->
    println "key=${k.class} , value=$v"
}

def value = map['a']
println value
//map[a]

//Car car1 = new Car();
//Car car2 = new Car();
//println car1+car2

Integer.metaClass.add1000 {
    delegate + 1000
}

println 250.add1000()



