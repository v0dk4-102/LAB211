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
public class Calculator {
    public int[][] additionMatrix(int[][] matrix1,int[][] matrix2){
        int row = matrix1.length;
        int col = matrix1[0].length;
        int[][] result = new int[row][col];
        //traverse from the first element of row to last element of row
        for(int i=0;i<row;i++){
            //traverse from the first element of column to last element of column
            for(int j=0;j<col;j++){
                result[i][j]= matrix1[i][j]+matrix2[i][j];
            }
        }
        return result;
    }
    
    public int[][] subtractionMatrix(int[][] matrix1,int[][] matrix2){
        int row = matrix1.length;
        int col = matrix1[0].length;
        int[][] result = new int[row][col];
        //traverse from the first element of row to last element of row
        for(int i=0;i<row;i++){
            //traverse from the first element of column to last element of column
            for(int j=0;j<col;j++){
                result[i][j]= matrix1[i][j]-matrix2[i][j];
            }
        }
        return result;
    }
    
    public int[][] multiplicationMatrix(int[][] matrix1,int[][] matrix2){
        int rowMatrix1 = matrix1.length;
        int colMatrix1 = matrix1[0].length;
        int rowMatrix2 = matrix2.length;
        int colMatrix2 = matrix2[0].length;
        int[][] result = new int[rowMatrix1][colMatrix2];
        //traverse from first element of row to last element of row of matrix 1
        for (int i = 0; i < rowMatrix1; i++) {
            //traverse from first element of column to last element of column of matrix 2
            for (int j = 0; j < colMatrix2; j++) {
                //traverse from first element of column to last element of column of matrix 1
                for (int k = 0; k < colMatrix1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j] ;
                }
            }
        }
        return result; 
    }
}
