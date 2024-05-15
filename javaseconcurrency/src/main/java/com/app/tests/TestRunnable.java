/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.tests;

import com.app.runnables.AppRunnable;
import com.app.runnables.AppThread;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WaterShurikenNinja
 */
public class TestRunnable {
    
    public static void main(String[] args) {
        Runnable runnable = () -> {
            try (BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\WaterShurikenNinja\\Documents\\Ex_Files_Java_EE_Concurrency\\Ex_Files_Java_EE_Concurrency\\Exercise Files\\Chapter2\\02_03\\begin\\sample.txt")))) {
                String line = null;
                while ((line = reader.readLine()) != null) {
                    System.out.println(Thread.currentThread().getName() + " reading the line: " + line);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AppThread.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AppThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        };

        // In Java, there are a couple of common ways to create threads, which involve using the Runnable interface.
        // 1. Using lambda expressions: Runnable is a functional interface (an interface with only one abstract method) so the JVM knows that the lambda expression is for the run() method.
        // 2. Creating a seperate class that implements the Runnable interface
        
//        Thread thread1 = new Thread(runnable);
//        thread1.start();
//
//        Thread thread2 = new Thread(new AppRunnable());
//        thread2.start();

        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(runnable);
        
        
    }
}
