/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_j1_s_p0001;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class LAB211_J1_S_P0001 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //step 1: User inputs a positive decimal number
        int size = InputSize();
        //step 2: Generate random integer in number range input for each array element
        int[] array = generateArray(size);
//        int[] array = {5,1,12,-5,16};
        //step 3: Display unsorted array
        display(array, "Unsorted array: ");
        //step 4: Display sorted array
        display(bubbleSort(array), "Sorted array: ");
    }

    private static int[] generateArray(int size) {
        int[] arr = new int[size];
        Random rd = new Random();
        /*using loop to access each element of array*/
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(size);
        }
        return arr;
    }

    private static void display(int[] arr, String message) {
        System.out.print(message);
        System.out.print("[");
        //avoid exception
        if(arr.length==0){
            if(message.equals("Unsorted array: ")) System.out.print("]\n");
            else System.out.print("]");
            return;
        }
        //using loop to acess each element of array except the last element
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ",");
        }
        //formatting interface
        if (message.equals("Unsorted array: ")) {
            System.out.print(arr[arr.length - 1] + "]\n");
        } else {
            System.out.print(arr[arr.length - 1] + "]");
        }
    }

    private static int[] bubbleSort(int[] array) {
        boolean testAlgorithm = false;
        /*Loop use to accessed from the first to last element of array, 
        after each loop, one element is sorted*/
        for (int i = 0; i < array.length; i++) {
            /*using loop to access from first element to the element before the
            last unsorted element of array*/
            for (int j = 0; j < array.length - i - 1; j++) {
                /*compare 2 elements that are adjacent*/
                if (array[j] > array[j + 1]) {
                    if(testAlgorithm){
                        display(array, "");
                        System.out.println("    " + array[j] + ">" + array[j + 1] + ", " + "swap");
                    }
                    int temp = array[j]; 
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }else{
                    if(testAlgorithm){
                         display(array, "");
                        System.out.println("    " + array[j] + "<" + array[j + 1] + ", " + "ok");
                    }
                }
            }
        }
        return array;
    }

    private static int InputSize() {
        Scanner sc = new Scanner(System.in);
        String input;
        double output;
        while(true){
            System.out.println("Enter number of array:");
            input = sc.nextLine();
            //check whether input is empty
            if(input.isEmpty()){
                System.out.println("Input can not be empty, try again");
                continue;
            }
            try{
                output = Double.parseDouble(input);
                //check whether input is greater than 0
                if(output<=0){
                    System.out.println("Input must be greater than zero(0)");
                    continue;
                } 
                //check whether input is integer
                if((output-(int)output)!=0){
                    System.out.println("Input must be integer");
                    continue;
                }
                break;
            }
            catch(NumberFormatException e){
                System.out.println("Input cannot contain non-digit characters");
            }
        }
        return (int)output;
    }

}
