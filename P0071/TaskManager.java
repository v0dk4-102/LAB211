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
public class TaskManager {

    private final GetData getData = new GetData();

    void displayMenu() {
        System.out.println("======= Task program =======");
        System.out.println("\t1. Add task");
        System.out.println("\t2. Delete task");
        System.out.println("\t3. Display task");
        System.out.println("\t4. Exit");
    }

    public int addTask(ArrayList<Task> taskList, int id) {
        HandleFile handleFile = new HandleFile();
        getDataTask(taskList);
        System.out.println("------------ Add Task ------------");
        String requirementName = getData.getString("Requirement Name: ", "", "");
        String taskType = getData.getTaskType("Task Type: ");

        String date = getData.getDate("Date: ");
        double planFrom = getData.getDouble("From: ", 8.0, 17.0);
        double planTo = getData.getDouble("To: ", planFrom + 0.5, 17.5);
        String assignee = getData.getString("Assignee: ", "", "");
        boolean isExisted = checkDuplicate(date, assignee, planFrom, planTo, taskList);
        //check duplicate
        if (checkDuplicate(date, assignee, planFrom, planTo, taskList)) {
            System.out.println("Task overlap!");
            
            for (Task task : taskList) {
                if (task.getAssignee().equals(assignee) && task.getDate().equals(date) && task.getPlanFrom() < planTo) {
                    System.out.println(assignee + " have to do another task from "+task.getPlanFrom()+" to "+task.getPlanTo()
                    +" at "+task.getDate());
                    displayDuplicateTask(task);
                }
            }
            System.out.println("Add fail");
            return id;
        }
        String reviewer = getData.getString("Reviewer: ", "", "");
        taskList.add(new Task(id, taskType, requirementName, date, planFrom, planTo, assignee, reviewer));
        id++;
        System.out.println("Add successfully");
        handleFile.WriteToFile(taskList);
        return id;
    }

    private boolean checkDuplicate(String date, String assignee, double planFrom, double planTo, ArrayList<Task> taskList) {
        boolean isExisted = false;
        //using loop to access each element of task ist
        for (Task task : taskList) {
            /*compare date of task in list with date input and assignee of task 
             in list with asignee input*/
            if (date.equals(task.getDate()) && assignee.equals(task.getAssignee())) {
                /*compare variable plan From and plan To with every plan To and plan
                 From in task list*/
                /*variable plan To must be before plan From of the task or variable
                 plan From must be after plan To of the task*/
                if ((planTo < task.getPlanFrom()) || (planFrom > task.getPlanTo())) {
                    isExisted = false;
                } else {
                    isExisted = true;
                    break;
                }
            }
        }
        return isExisted;
    }

    public void deleteTask(ArrayList<Task> taskList) {
        HandleFile handleFile = new HandleFile();
        //check empty
        if (taskList.isEmpty()) {
            System.out.println("Task list is currently empty, can not delete task");
            System.out.println("Please choose option 1 to add task first");
            return;
        }
        getDataTask(taskList);
        System.out.println("------------ Del Task ------------");
        int pos = -1;
        int taskID = getData.getInteger("ID:", 1, Integer.MAX_VALUE);
        //using loop to access each element in task list
        for (Task task : taskList) {
            if (task.getTaskID() == taskID) {
                pos = taskList.indexOf(task);
            }
        }
        //check id existence
        if (pos == -1) {
            System.out.println("That ID does not exist in task list");
            return;
        }
        taskList.remove(pos);
        handleFile.WriteToFile(taskList);
        System.out.println("Deleting task successfully");
        System.out.println("After deleting");
        getDataTask(taskList);
    }

    public void getDataTask(ArrayList<Task> taskList) {
        HandleFile handleFile = new HandleFile();
        taskList = handleFile.ReadFile(taskList);
        //check empty
        if (taskList.isEmpty()) {
            System.out.println("Task list is currently empty, can not get data");
            return;
        }
        System.out.println("---------------------------------------- Task -------------------------------------");
        System.out.format("%-7s%-20s%-12s%-15s%-7s%-15s%-15s\n", "Id", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        //using loop to access each element in task list
        for (Task task : taskList) {
            System.out.println(task);
        }
    }

    public void getDataTask() {

    }

    private void displayDuplicateTask(Task task) {
        System.out.format("%-7s%-20s%-12s%-13s%-7s%-7s%-12s%-15s\n", "ID", "Requirement Name",
                "Task Type", "Date", "From", "To", "Assignee", "Reviewer");
        System.out.format("%-7s%-20s%-12s%-13s%-7s%-7s%-12s%-15s\n", task.getTaskID(),
                task.getRequirementName(), task.getTaskTypeID(), task.getDate(), task.getPlanFrom(),
                task.getPlanTo(), task.getAssignee(), task.getReviewer());
    }
}
