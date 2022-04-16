/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_j1_s_p0101;

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
        while (true) {
            System.out.print(msg);
            input = sc.nextLine();
            //check empty
            if (input.isEmpty()) {
                System.out.println("Input can not be empty");
                continue;
            }
            try {
                output = Integer.parseInt(input);
                //check whether input is in range
                if (output < min || output > max) {
                    System.out.println("Input is not in range [" + min + "," + max + "]");
                    System.out.println("Current value: " + output);
                    continue;
                }
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Input must be integer");
            }
        }
        return output;
    }

    public String getString(String msg,String exampleOfRegex, String regex) {
        String input;
        do {
            System.out.print(msg);
            input = sc.nextLine();
            //check whether input is empty
            if (input.isEmpty()) {
                System.out.println("Input could not be empty");
                continue;
            }
            //check whether input matches regex
            if (regex.isEmpty()) {
                break;
            } else if (input.matches(regex)) {
                break;
            } else {
                System.out.println("Input not match format require");
                System.out.println("Correct format input like: "+exampleOfRegex);
                continue;
            }

        } while (true);
        return input;
    }

    public Date getDate(String msg) {
        String input;
        Date date;
        do {
            System.out.print(msg);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false);
            input = sc.nextLine();
            //check whether input is empty
            if (input.isEmpty()) {
                System.out.println("Input could not be empty!!!");
                continue;
            }
            /*Regex: input's date and input's month include 1-2 digit(s)
            input's year include 4 digits, between each component is a slash*/
            // \d{1,2}: the number have 1 or 2 digit number
            //[/]: contain character /
            //\d{4}: the number must have 4 digit
            else if (!input.matches("\\d{1,2}[/]\\d{1,2}[/]\\d{4}")) {
                System.out.println("Input is wrong format");
                System.out.println("Please follow format dd/mm/yyyy");
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
