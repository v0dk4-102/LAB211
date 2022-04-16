/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_j1_s_p0021;

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

}
