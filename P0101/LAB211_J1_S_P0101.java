/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_j1_s_p0101;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class LAB211_J1_S_P0101 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int choice;
        Manager manager = new Manager();
        GetData getData = new GetData();
        ArrayList<Employee> list = new ArrayList<>();
        list = initialize(list);
        do {
            //step 1: display menu
            manager.displayMenu();
            //step 2: Ask user to select an option
            choice = getData.getInteger("Enter your choice:", 1, 6);
            //step 3: perform selected option
            switch (choice) {
                //option 1: add an employee
                case 1: {
                    manager.addEmployee(list);
                    break;
                }
                //option 2: update an employee
                case 2: {
                    manager.updateAnEmployee(list);
                    break;
                }
                //option 3: remove an employee
                case 3: {
                    manager.removeAnEmployee(list);
                    break;
                }
                //option 4: remove an employee
                case 4: {
                    manager.searchEmployee(list);
                    break;
                }
                //option 5: sort employees
                case 5: {
                    manager.sortEmployeesBySalary(list);
                    break;
                }
                //option 6: exit
                case 6: {
                    break;
                }
            }
            //continue loop until user choose option 6
        } while (choice != 6);

    }
    
    public static ArrayList<Employee> initialize(ArrayList<Employee> employeeList){
        Employee e = new Employee("HE161776", "Vu", "Dang Khoa", "khoavdhe161776@fpt.edu.vn", "Bac Ninh", "0392659310", "male", "FPT", new Date(), 10000);
        Employee e1 = new Employee("HE161775", "Luu", "Bich Thuong", "khoadkbt2109@gmail.com", "Bac Ninh", "0123456789", "female", "APEC", new Date(), 9000);
        Employee e2 = new Employee("HE161777", "Luu", "Bich Ngoc", "bong@outlook.com", "Ha Noi", "0341236789", "female", "unknown", new Date(), 5000);
        Employee e3 = new Employee("HE161774", "Nguyen", "Van A", "unknown@gmail.com", "Thai Binh", "84123456789", "male", "RMIT", new Date(), 7000);
        Employee e4 = new Employee("HE161779", "Vu", "Manh Hung", "hung@yahoo.com.vn", "Nam Dinh", "0987654321", "male", "KMA", new Date(), 11000);
        employeeList.add(e);
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        return employeeList;
    }
}
