/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_j1_s_p0001;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class GetData {
    private static final Scanner sc = new Scanner(System.in);
    
    public static int getInteger(String mess, int min, int max){
        String input;
        int output;
        while(true){
            System.out.println(mess);
            input = sc.nextLine();
            //check whether input is empty
            if(input.isEmpty()){
                System.out.println("Input can not be empty, try again");
                continue;
            }
            try{
                output = Integer.parseInt(input);
                //check whether input is in range
                if(output<min || output>max){
                    System.out.println("Enterer number is out of range ["+min+","+max+"]");
                    System.out.println("You have entered:"+output);
                    System.out.println("Try again");
                    continue;
                } 
                break;
            }
            catch(NumberFormatException e){
                System.out.println("Entered input is not integer, please enter an positive integer");
            }
        }
        return output;
    }
}
