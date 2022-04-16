/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_j1_s_p0105;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class GetData {

    private Scanner sc = new Scanner(System.in);

    public int getInteger(String msg, int min, int max) {
        String input;
        int output;
        //using loop to get correct input
        while (true) {
            System.out.print(msg);
            input = sc.nextLine();
            //check empty
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty, try again");
                continue;
            }
            try {
                output = Integer.parseInt(input);
                //check in range
                if (output < min || output > max) {
                    throw new Exception();
                }
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Input must be integer, try again");
            } catch (Exception e) {
                System.out.println("Input must be in range [" + min + "," + max + "], try again");
            }
        }
        return output;
    }

    public String getString(String msg, String exampleOfRegex, String regex) {
        String input;
        do {
            System.out.print(msg);
            input = sc.nextLine();
            //check empty
            if (input.isEmpty()) {
                System.out.println("Input could not be empty!!!");
                continue;
            }
            //check regex
            if (regex.isEmpty()||input.matches(regex)) {
                break;
            } else {
                System.out.println("Incorrect format input");
                System.out.println("Correct format of input like:"+exampleOfRegex);
                continue;
            }
        } while (true);
        return input;
    }

    Date getDate(String msg) {
        String input;
        Date date;
        do {
            System.out.print(msg);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false);
            input = sc.nextLine();
            //check empty
            if (input.isEmpty()) {
                System.out.println("Input could not be empty!!!");
                continue;
            } // \d{1,2}: the number have 1 or 2 digit number
            //[/]: contain character /
            //\d{4}: the number must have 4 digit
            //check regex
            else if (!input.matches("\\d{1,2}[/]\\d{1,2}[/]\\d{4}")) {
                System.out.println("Incorrect format input");
                System.out.println("Please enter date like dd/mm/yyyy");
                continue;
            }
            try {
                date = dateFormat.parse(input);
                break;
            } catch (ParseException exception) {
                System.out.println("Date doesn't existed!!");
            }
        } while (true);
        return date;
    }
}
