/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_j1_s_p0071;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class GetData {

    private final Scanner sc = new Scanner(System.in);

    public int getInteger(String msg, int min, int max) {
        String input;
        int output;
        //using loop to get correct input
        while (true) {
            System.out.print(msg);
            input = sc.nextLine();
            //check empty
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty, please try again");
                continue;
            }
            try {
                output = Integer.parseInt(input);
                //check in range
                if (output < min || output > max) {
                    System.out.println("Input must be in range [" + min + "," + max + "], please try again");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input must be integer");
            }
        }
        return output;
    }

    public String getString(String msg, String regex, String exampleOfRegex) {
        String output;
        while (true) {
            System.out.print(msg);
            output = sc.nextLine();
            //check empty
            if (output.isEmpty()) {
                System.out.println("Input cannot be empty, please try again");
                continue;
            }
            //check follow format
            if (regex.isEmpty() || output.matches(regex)) {
                break;
            } else {
                System.out.println("Incorrect format input");
                System.out.println("Correct input like:" + exampleOfRegex);
            }
        }
        return output;
    }
    
    public String getDate(String msg) {
        String input;
        Date date;
        String resultDate;
        do {
            System.out.print(msg);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            dateFormat.setLenient(false);
            input = sc.nextLine();
            //check empty
            if (input.isEmpty()) {
                System.out.println("Input could not be empty");
                continue;
            } // \d{1,2}: the number have 1 or 2 digit number
            //[-]: contain character - (dash)
            //\d{4}: the number must have 4 digit
            else if (!input.matches("\\d{1,2}[-]\\d{1,2}[-]\\d{4}")) {
                System.out.println("Wrong format input, please try again");
                System.out.println("Correct format is [dd-mm-yyyy] like: 21-03-2022");
                continue;
            }
            try {
                date = dateFormat.parse(input);
                Date now = new Date();
                //check date must be before now
                if (date.before(now)) {
                    System.out.println("Date could not be the past. Please enter again!");
                    continue;
                }
                break;
            } catch (ParseException exception) {
                System.out.println("Date doesn't exist, please try again");
            }
        } while (true);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        resultDate = dateFormat.format(date);
        return resultDate;
    }

    public String getTaskType(String msg) {
        int taskTypeID;
        String result = "";
//        System.out.println("----- Menu task type -----");
//        System.out.println("\t1. Code");
//        System.out.println("\t2. Test");
//        System.out.println("\t3. Design");
//        System.out.println("\t4. Review");
        taskTypeID = getInteger(msg, 1, 4);
        //assign value to variable result base on taskTypeID
        switch (taskTypeID) {
            case 1: {
                result = "Code";
                break;
            }
            case 2: {
                result = "Test";
                break;
            }
            case 3: {
                result = "Design";
                break;
            }
            case 4: {
                result = "Review";
                break;
            }
        }
        return result;
    }

    public double getDouble(String msg, double min, double max) {
        double output;
        String input;
        do {
            //\d: accept input be a digit from 0-9
            //{1,2} match previous token between 1-2 time
            //\.: after digit is a dot
            //([5]|[0])): after a dot just accept only one digit 5 or 0
            input = getString(msg, "^(\\d{1,2}\\.([5]|[0]))$", "8.0 or 8.5");
            //check empty
            if (input.isEmpty()) {
                System.out.println("Input could not be empty!");
            } else {
                try {
                    output = Double.parseDouble(input);
                    //check in range
                    if (output < min || output > max) {
                        System.out.println("Input must be in range [" + min + "," + max + "]");
                        System.out.println("Your current value:" + output);
                        System.out.println("Please try again");
                        continue;
                    }
                    break;
                } catch (NumberFormatException ex) {
                    System.out.println("Input must be a real number!");
                }
            }
        } while (true);
        return output;
    }
}
