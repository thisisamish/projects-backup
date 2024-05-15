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
        AppThread thread1 = new AppThread(); // thread is in NEW state
        AppThread thread2 = new AppThread();
        AppThread thread3 = new AppThread();

        thread1.start(); // thread is in RUNNABLE state
        thread2.start();
        thread3.start();
        
        // when JVM executes the thread using the run() method, the thread is in RUNNNING state
        // when the job is completed, the thread is in TERMINATED/DEAD state
        // if the thread is put to sleep or is waiting for a resource, it is in WAITING/BLOCKED state
    }
}
