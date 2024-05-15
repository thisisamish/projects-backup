/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.tests;

import com.app.runnables.AppThread;

/**
 *
 * @author WaterShurikenNinja
 */
public class TestThreads {
    public static void main(String[] args) {
        AppThread thread1 = new AppThread();
        AppThread thread2 = new AppThread();
        AppThread thread3 = new AppThread();
        
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
