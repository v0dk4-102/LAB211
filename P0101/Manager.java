/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_j1_s_p0101;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class Manager {

    private GetData getData = new GetData();

    public void displayMenu() {
        System.out.println("Main menu:");
        System.out.println("\t1. Add employees");
        System.out.println("\t2. Update employees");
        System.out.println("\t3. Remove employees");
        System.out.println("\t4. Search employees");
        System.out.println("\t5. Sort employees by salary");
        System.out.println("\t6. Exit");
    }

    public void displayAnEmployeeOfList(ArrayList<Employee> list, int index) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateofBirth = dateFormat.format(list.get(index).getDateOfBirth());
        System.out.format("%10s%15s%15s%15s%30s%20s%15s%7s%10d%10s\n",
                list.get(index).getId(), list.get(index).getFirstName(), list.get(index).getLastName(),
                list.get(index).getPhone(), list.get(index).getEmail(), list.get(index).getAddress(), dateofBirth,
                list.get(index).getSex(), list.get(index).getSalary(), list.get(index).getAgency());
    }

    public void DisplayAllList(ArrayList<Employee> list) {
        System.out.println("The Employees List: ");
        System.out.format("%10s%15s%15s%15s%30s%20s%15s%7s%10s%10s\n", "Id", "First Name",
                "Last Name", "Phone Number", "Email", "Address", "Birthday", "Gender", "Salary", "Agency");
        //loop use to access each element of arraylist from begining to the end
        for (int i = 0; i < list.size(); i++) {
            displayAnEmployeeOfList(list, i);
        }
    }

    private boolean checkIdExist(String id, ArrayList<Employee> list) {
        boolean isExisted = false;
        if (list.isEmpty()) {
            return isExisted;
        }
        //using loop to access each element of list from beginning to the end
        for (Employee employee : list) {
            //compare ID from input with each ID of employee in list
            if (id.equals(employee.getId())) {
                System.out.println("ID has existed");
                isExisted = true;
                break;
            }
        }
        return isExisted;
    }

    public void addEmployee(ArrayList<Employee> list) {
        String id;
        if (list.isEmpty()) {
            System.out.println("Employee list is currently empty");
        } else {
            DisplayAllList(list);
        }
        while (true) {
            //regex:
            //a-zA-Z characters in alphabet ignore case
            //0-9 digits from 0 to 9
            //+ match previous token between 1 and unlimited time
            id = getData.getString("Enter employee's id:", "HE000001", "[a-zA-Z0-9]+");
            boolean isExistedId = checkIdExist(id, list);
            //check whether id exists
            if (isExistedId) {
                continue;
            } else {
                break;
            }
        }
        //regex:
        // \+ plus sign
        // ? match previous token between 0 and 1 time
        // (0|84) include '0' or '84' exactly 1 time
        // \d{9} include digits from 0-9 exactly 9 times
        // \w include characters in alphabet ignore case or digits from 0 to 9 or a underscore
        // \. a dot
        // \@ special character @
        // {a,b} match previous token between a and b times
        // \s whitespace character
        // + match previous token between 1 and unlimited times
        //regex: name include characters in English alphabet and whitespace 
        String firstName = getData.getString("Enter employee's first name:", "Vu", "([a-zA-Z]{1,10}\\s?)+");
        //regex: name include characters in English alphabet and whitespace 
        String lastName = getData.getString("Enter employee's last name:", "Dang Khoa", "([a-zA-Z]{1,10}\\s?)+");
        //regex: vietnamese phone number. Example: 0123456789 or 84123456789
        String phone = getData.getString("Enter employee's phone number:", "0123456789 or 84123456789", "\\+?(0|84)\\d{9}");
        //regex: email format. Example abc@def.geh or abc@def.ghi.jkl
        String email = getData.getString("Enter employee's email:", "abc@def.geh or abc@def.ghi.jkl", "\\w{1,32}\\@\\w{1,32}\\.\\w{1,32}\\.?\\w{1,32}?");
        //regex: name format
        String address = getData.getString("Enter employee's address:", "Bac Ninh", "([a-zA-Z]{1,10}\\s?)+");
        String sex = getData.getString("Enter employee's sex:", "", "");
        String agency = getData.getString("Enter employee's agency:", "", "");
        Date dateOfBirth = getData.getDate("Enter employee's date of birth:");
        int salary = getData.getInteger("Enter employee's salary:", 0, Integer.MAX_VALUE);
        Employee employee = new Employee(id, firstName, lastName, email, address, phone, sex, agency, dateOfBirth, salary);
        list.add(employee);
    }

    private int searchById(ArrayList<Employee> list, String id) {
        int pos = -1;
        //check empty
        if (list.isEmpty()) {
            System.out.println("Employee list is empty");
        } else {
            /*loop use to access each element of employee list from
             the beginning to the end*/
            for (Employee employee : list) {
                //compare id input and each id of employee in the list
                if (id.equals(employee.getId())) {
                    pos = list.indexOf(employee);
                    break;
                }
            }
        }
        return pos;
    }

    public void updateAnEmployee(ArrayList<Employee> list) {
        if (list.isEmpty()) {
            System.out.println("There is no employee to update, please "
                    + "choose option 1 to add employee before update");
            return;
        }
        int pos;
        String id;
        while (true) {
            DisplayAllList(list);
            //regex:
            //a-zA-Z characters in alphabet ignore case
            //0-9 digits from 0 to 9
            //+ match previous token between 1 and unlimited time
            id = getData.getString("Enter employee's id:", "HE000001", "[a-zA-Z0-9]+");
            pos = searchById(list, id);
            //compare pos with -1
            if (pos == -1) {
                System.out.println("That id does not exist in the list, please try again");
                continue;
            } else {
                break;
            }
        }
        do {
            System.out.println("Choose update option:");
            System.out.println("\t1. Update firstname of employee");
            System.out.println("\t2. Update last name of employee");
            System.out.println("\t3. Update phone number of employee");
            System.out.println("\t4. Update email of employee");
            System.out.println("\t5. Update address of employee");
            System.out.println("\t6. Update birthday of employee");
            System.out.println("\t7. Update gender of employee");
            System.out.println("\t8. Update salary of employee");
            System.out.println("\t9. Update agency of employee");
            System.out.println("\t10. Update Id of employee");
            int choice = getData.getInteger("Your choice: ", 1, 10);
            switch (choice) {
                case 1: {
                    //regex:
                    // \+ plus sign
                    // ? match previous token between 0 and 1 time
                    // (0|84) include '0' or '84' exactly 1 time
                    // \d{9} include digits from 0-9 exactly 9 times
                    // \w include characters in alphabet ignore case and digits from 0 to 9 or a underscore
                    // \. a dot
                    // \@ special character @
                    // {a,b} match previous token between a and b times
                    // \s whitespace character
                    // + match previous token between 1 and unlimited times
                    //regex: name include characters in English alphabet and whitespace
                    String firstName = getData.getString("Enter employee's first name:", "Vu", "([a-zA-Z]{1,10}\\s?)+");
                    list.get(pos).setFirstName(firstName);
                    break;
                }
                case 2: {
                    //regex: name include characters in English alphabet and whitespace
                    String lastName = getData.getString("Enter employee's last name:", "Dang Khoa", "([a-zA-Z]{1,10}\\s?)+");
                    list.get(pos).setLastName(lastName);
                    break;
                }
                case 3: {
                    //regex: Vietnamese phone number
                    String phone = getData.getString("Enter employee's phone number:", "0123456789 or 84123456789", "\\+?(0|84)\\d{9}");
                    list.get(pos).setPhone(phone);
                    break;
                }
                case 4: {
                    //regex: format of an email
                    String email = getData.getString("Enter employee's email:", "abc@def.geh or abc@def.ghi.jkl", "\\w{1,32}\\@\\w{1,32}\\.\\w{1,32}\\.?\\w{1,32}?");
                    list.get(pos).setEmail(email);
                    break;
                }
                case 5: {
                    //regex: name include characters in English alphabet and whitespace
                    String address = getData.getString("Enter employee's address:", "Bac Ninh", "([a-zA-Z]{1,10}\\s?)+");
                    list.get(pos).setAddress(address);
                    break;
                }
                case 6: {
                    Date dateOfBirth = getData.getDate("Enter employee's date of birth:");
                    list.get(pos).setDateOfBirth(dateOfBirth);
                    break;
                }
                case 7: {
                    String sex = getData.getString("Enter employee's sex:", "", "");
                    list.get(pos).setSex(sex);
                    break;
                }
                case 8: {
                    int salary = getData.getInteger("Enter employee's salary", 0, Integer.MAX_VALUE);
                    list.get(pos).setSalary(salary);
                    break;
                }
                case 9: {
                    String agency = getData.getString("Enter employee's agency:", "", "");
                    list.get(pos).setAgency(agency);
                    break;
                }
                case 10: {
                    String idUpdate;
                    while (true) {
                        //regex:
                        //a-zA-Z characters in alphabet ignore case
                        //0-9 digits from 0 to 9
                        //+ match previous token between 1 and unlimited time
                        idUpdate = getData.getString("Enter employee's id:", "HE000001", "[a-zA-Z0-9]+");
                        //check whether update id equals to old id
                        if (idUpdate.equals(id)) {
                            System.out.println("You have entered old Id, please"
                                    + " enter a new Id");
                            continue;
                        }
                        boolean isExistedId = checkIdExist(idUpdate, list);
                        //check whether id exists
                        if (isExistedId) {
                            continue;
                        } else {
                            break;
                        }
                    }
                    list.get(pos).setId(idUpdate);
                    break;
                }
            }
            DisplayAllList(list);
            //[yn]: input must be y or n
            String answer = getData.getString("Do you want to continue?", "y or n", "[yn]");
            //compare value of answer to n
            if (answer.equals("n")) {
                break;
            }
        } while (true);
    }

    public void removeAnEmployee(ArrayList<Employee> list) {
        if (list.isEmpty()) {
            System.out.println("There is no employee to remove, please "
                    + "choose option 1 to add employee before remove");
            return;
        }
        String id;
        int pos;
        while (true) {
            DisplayAllList(list);
            //regex:
            //a-zA-Z characters in alphabet ignore case
            //0-9 digits from 0 to 9
            //+ match previous token between 1 and unlimited time
            id = getData.getString("Enter employee's id:", "HE000001", "[a-zA-Z0-9]+");
            pos = searchById(list, id);
            //compare pos with -1
            if (pos == -1) {
                System.out.println("That id does not exist in the list, please try again");
                continue;
            } else {
                break;
            }
        }
        list.remove(pos);
        DisplayAllList(list);
    }

    public void searchEmployee(ArrayList<Employee> list) {
        if (list.isEmpty()) {
            System.out.println("There is no employee to search, please "
                    + "choose option 1 to add employee before search");
            return;
        }
        String nameForSearch = getData.getString("Enter employee's name to search:", "", "");
        int pos = -1;
        int count = 0;
        System.out.println("Search result: ");
        /*using loop to access each element of employee list from
         the beginning to the end*/
        for (int i = 0; i < list.size(); i++) {
            String fullname = list.get(i).getFirstName() + " " + list.get(i).getLastName();
            //check whether variable fullname contains input's search from user
            if (fullname.contains(nameForSearch)) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("That name does not exist in employee list");
            return;
        }
        System.out.println("Found " + count + " employee(s)");
        System.out.format("%10s%15s%15s%15s%30s%20s%15s%7s%10s%10s\n", "Id", "First Name",
                "Last Name", "Phone Number", "Email", "Address", "Birthday", "Gender", "Salary", "Agency");
        //using loop to display search result by access each 
        for (int i = 0; i < list.size(); i++) {
            String fullname = list.get(i).getFirstName() + " " + list.get(i).getLastName();
            //check whether variable fullname contains input's search from user
            if (fullname.contains(nameForSearch)) {
                displayAnEmployeeOfList(list, i);
            }
        }
    }

    public void sortEmployeesBySalary(ArrayList<Employee> list) {
        Collections.sort(list);
        DisplayAllList(list);
    }

}
