/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_j1_s_p0071;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class LAB211_J1_S_P0071 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TaskManager manager = new TaskManager();
        GetData getData = new GetData();
        ArrayList<Task> taskList = new ArrayList<>();
        int id = 1;
        while(true){
            //step 1: display menu
            manager.displayMenu();
            //step 2: ask user to select an option
            int choice = getData.getInteger("Your choice:",1,4);
            //step 3: perform function based on selected option
            switch(choice){
                //option 1: Add Task
                case 1:{
                    id = manager.addTask(taskList, id);
                    break;
                }
                //option 2: Delete Task
                case 2:{
                    manager.deleteTask(taskList);
                    break;
                }
                //option 3: Get Data Task
                case 3:{
                    manager.getDataTask(taskList);
                    break;
                }
                //option 4: Exit
                case 4:{
                    return;
                }
            }
        }
    }
    
//    public static void initialize(ArrayList<Task> taskList){
//        Task t = new Task(1, "Code", "Dev Program", "24-03-2022", 8.0, 16.5, "Dev", "Lead");
//        Task t1 = new Task(2, "Design", "Design something", "24-03-2022", 8.0, 16.5, "Designer", "Lead");
//        Task t2 = new Task(3, "Review", "Dev Program", "24-03-2022", 8.0, 16.5, "Lead", "Manager");
//        Task t3 = new Task(4, "Test", "Penetration test", "24-03-2022", 8.0, 16.5, "Pentester", "Manager");
//        Task t4 = new Task(5, "Code", "Dev Web Application", "25-03-2022", 8.0, 16.5, "Dev", "Lead");
//        Task t5 = new Task(6, "Test", "Test Program", "26-03-2022", 8.0, 16.5, "Dev", "Lead");
//        taskList.add(t);
//        taskList.add(t1);
//        taskList.add(t2);
//        taskList.add(t3);
//        taskList.add(t4);
//        taskList.add(t5);
//    }
    
}
