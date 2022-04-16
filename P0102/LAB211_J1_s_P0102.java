/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_j1_s_p0102;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class LAB211_J1_s_P0102 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean check;
        String input;
        //using loop to get correct input
        do{
            //step 1: input date with format [dd/mm/yyyy]
            input = inputDate("Please enter date with format [dd/mm/yyyy]: ");
            //step 2: Check user input date exist
            check = isExistDate(input);
        }
        while (!check);
        //step 3: Determine day of week with input date
        determineDayOfWeek(input);
    }

    public static String inputDate(String msg) {
        System.out.print(msg);
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        //correcting input if user enter incorrect input by using loop
        while (true) {
            //check whether input is empty or not
            if (input.isEmpty()) {
                System.out.println("Input can't be empty, try again");
                System.out.print(msg);
                input = sc.nextLine();
            } //check format input
            //regex: day's input and month's input is 2 integer(s), year's input is 4 integers, between each component is a slash
            //\d{1,2} input is 1-2 integer
            //[/] input is a slash
            //\d{4} input is 4 integer
            else if (!input.matches("\\d{2}[/]\\d{2}[/]\\d{4}")) {
                System.out.println("Incorrect format input, please enter follow format [dd/MM/yyyy]\nTry again");
                System.out.print(msg);
                input = sc.nextLine();
            } else {
                return input;
            }
        }

    }

    public static boolean isExistDate(String input) {
        boolean check = false;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            Date date = sdf.parse(input);
            check = true;
        } catch (ParseException e) {
            System.out.println("Entered date does not exist, try again");
        }
        return check;
    }

    public static void determineDayOfWeek(String input) {
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("EEEE");
        try {
            Date date = sdf1.parse(input);
            String output = sdf2.format(date);
            System.out.println("Your day is " + output);
        } catch (ParseException ex) {
            Logger.getLogger(LAB211_J1_s_P0102.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
