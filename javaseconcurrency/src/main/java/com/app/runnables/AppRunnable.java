/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.runnables;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WaterShurikenNinja
 */
public class AppRunnable implements Runnable {

    @Override
    public void run() {
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
    }
}
