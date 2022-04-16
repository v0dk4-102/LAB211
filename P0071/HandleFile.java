/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template fileInput, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_j1_s_p0071;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/**
 *
 * @author DELL
 */
public class HandleFile {
    
    public void WriteToFile(ArrayList<Task> list) {
        try {
            FileOutputStream file = new FileOutputStream("DataTask.txt", false);
            ObjectOutputStream objectTaskOutput = new ObjectOutputStream(file);
            //Loop through from the first to the last element of list
            for (Task task : list) {
                objectTaskOutput.writeObject(task);
            }
            objectTaskOutput.close();
            file.close();
        } catch (Exception fileException) {
        }
    }

    public ArrayList<Task> ReadFile(ArrayList<Task> taskList) {
        File file = new File("DataTask.txt");
        if (file.exists() == false) {
            System.out.println("File does not exist");
            return null;
        }
        try {
            FileInputStream fileInput = new FileInputStream(file);
            ObjectInputStream objectTaskInput = new ObjectInputStream(fileInput);
            Task task = (Task) objectTaskInput.readObject();
            //loop until there are no more objects to read 
            while (task != null) {
                taskList.add(task);
                task = (Task) objectTaskInput.readObject();
            }
            objectTaskInput.close();
            fileInput.close();
        } catch (Exception fileException) {
        }
        return taskList;
    }
}
