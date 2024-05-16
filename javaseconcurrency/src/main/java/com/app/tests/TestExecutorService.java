/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.tests;

import com.app.dao.UserDao;
import com.app.runnables.UserProcessor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WaterShurikenNinja
 */
public class TestExecutorService {

    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        List<String> users = getUsersFromFile("C:\\Users\\WaterShurikenNinja\\Documents\\Ex_Files_Java_EE_Concurrency\\Ex_Files_Java_EE_Concurrency\\Exercise Files\\Chapter3\\03_04\\begin\\new_users.txt");
        UserDao dao = new UserDao();
        for (String user : users) {
            try {
                Future<Integer> future = service.submit(new UserProcessor(user, dao));
                System.out.println("Result of the operation is: " + future.get());
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(TestExecutorService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        service.shutdown();
        System.out.println("Main execution over!");
    }

    public static List<String> getUsersFromFile(String fileName) {
        List<String> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                users.add(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestExecutorService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestExecutorService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
}
