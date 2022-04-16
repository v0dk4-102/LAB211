/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_j1_s_p0074;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class GetData {

    Scanner sc = new Scanner(System.in);

    public int getInteger(String msg, int min, int max) {
        String input;
        int output;
        do{
            System.out.print(msg);
            input = sc.nextLine();
            //check whether input is empty
            if(input.isEmpty()){
                System.out.println("Input can not be empty, try again");
                continue;
            }
            try{
                output = Integer.parseInt(input);
                //check value of input
                if(output < min || output > max)
                    throw new Exception();
                else break;
            }
            catch(NumberFormatException e){
                System.out.println("Input must be integer, try again");
            } catch (Exception ex) {
                System.out.println("Input must be in range ["+min+","+max+"], try again");
            }
        }while(true);
        return output;
    }
    
    public int getInteger(String msg){
        String input;
        int output;
        do{
            System.out.print(msg);
            input = sc.nextLine();
            //check whether input is empty
            if(input.isEmpty()){
                System.out.println("Input can not be empty, try again");
                continue;
            }
            try{
                output = Integer.parseInt(input);
                break;
            }
            catch(NumberFormatException e){
                System.out.println("Values of matrix is digit");
            }
        }while(true);
        return output;
    }
}
