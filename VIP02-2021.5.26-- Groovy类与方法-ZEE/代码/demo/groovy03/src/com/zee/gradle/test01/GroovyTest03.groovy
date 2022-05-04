package com.zee.gradle.test01

// Groovy中闭包转接口

//interface Action {
//    void aaa()
//}
//def closure = {
//    println "aaa"
//}
//Action action = closure
//action.aaa()
//println closure.class
//println action.class


//interface Action {
//    void aaa()
//    void bbb()
//    void ccc()
//}
//def addTextWatcher(Action action) {
//    action.aaa()
//}
//addTextWatcher({
//    println "aaa"
//} as Action)
//// 当有接口有多个方法时，传入的闭包要强转为Action，使用as关键字