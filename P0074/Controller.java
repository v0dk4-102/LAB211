/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_j1_s_p0074;

/**
 *
 * @author DELL
 */
public class Controller {

    GetData getData = new GetData();

    public void displayMenu() {
        System.out.println("=====Calculator program====");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
    }

    public int[][] inputMatrix1() {
        int row = getData.getInteger("Enter Row Matrix 1:", 1, Integer.MAX_VALUE);
        int column = getData.getInteger("Enter Column Matrix 1:", 1, Integer.MAX_VALUE);
        int[][] matrix = new int[row][column];
        //traverse from first element of row to last element of row of matrix
        for (int i = 0; i < row; i++) {
            //traverse from first element of column to last element of column of matrix
            for (int j = 0; j < column; j++) {
                String message = String.format("Enter Matrix1" + "[%d][%d]:", i + 1, j + 1);
                matrix[i][j] = getData.getInteger(message);
            }
        }
        return matrix;
    }

    public int[][] inputMatrix2(int[][] matrix1, int choice) {
        int[][] matrix2;
        int rowMatrix1 = matrix1.length;
        int colMatrix1 = matrix1[0].length;
        int rowMatrix2, colMatrix2;
        /*if multiplication function is call,correcting value of column
         of matrix 1 such that equal to row of matrix 2*/
        if (choice == 3) {
            while (true) {
                rowMatrix2 = getData.getInteger("Enter Row Matrix 2:", 1, Integer.MAX_VALUE);
                //check value of row of matrix 2 with column of matrix 1
                if (rowMatrix2 != colMatrix1) {
                    System.out.println("Row Matrix 2 must equal to Column Matrix 1");
                    continue;
                }
                colMatrix2 = getData.getInteger("Enter Column Matrix 2:", 1, Integer.MAX_VALUE);
                break;
            }
        } //Correcting Row and Column of Matrix 2 such that equal to Row and Column of Matrix 1
        else {
            while (true) {
                rowMatrix2 = getData.getInteger("Enter Row Matrix 2:", 1, Integer.MAX_VALUE);
                //check value of row of matrix 2 with row of matrix 1
                if (rowMatrix2 != rowMatrix1) {
                    System.out.println("Row Matrix 2 must equal to Row Matrix 1");
                    continue;
                }
                break;
            }
            while (true) {
                colMatrix2 = getData.getInteger("Enter Column Matrix 2:", 1, Integer.MAX_VALUE);
                //check value of column of matrix 2 with column of matrix 1
                if (colMatrix2 != colMatrix1) {
                    System.out.println("Column Matrix 2 must equal to Column Matrix 1");
                    continue;
                }
                break;
            }
        }
        matrix2 = new int[rowMatrix2][colMatrix2];
        //traverse from first element of row to last element of row of matrix 2
        for (int i = 0; i < rowMatrix2; i++) {
            //traverse from first element of column to last element of column of matrix
            for (int j = 0; j < colMatrix2; j++) {
                String message = String.format("Enter Matrix2" + "[%d][%d]:", i + 1, j + 1);
                matrix2[i][j] = getData.getInteger(message);
            }
        }
        return matrix2;
    }

    public void displayMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        //traverse from first element of row to last element of row of matrix
        for (int i = 0; i < row; i++) {
            //traverse from first element of column to last element of column of matrix
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }

    public void displayResult(int[][] matrix1,int[][] matrix2,int[][] result,int choice) {
        System.out.println("-------- Result --------");
        displayMatrix(matrix1);
        switch(choice){
            case 1:{
                System.out.println("+");
                break;
            }
            case 2:{
                System.out.println("-");
                break;
            }
            case 3:{
                System.out.println("*");
                break;
            }
        }
        displayMatrix(matrix2);
        System.out.println("=");
        displayMatrix(result);
    }
}
