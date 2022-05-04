package com.dongnaoedu.gradledemo07

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("TAG", "onCreate: ${this.classLoader}") // PathClassLoader：加载应用当中的这些类的
        Log.i("TAG", "onCreate: ${this.classLoader.parent}")
        Log.i("TAG", "onCreate: ${Activity::class.java.classLoader}") // BootClassLoader：用来加载Android SDK的这些类

        // 双亲委派机制：
        // 防止重复加载
        // 防止替换核心库中的类

        Activity.class

        this.classLoader.loadClass()


    }
}