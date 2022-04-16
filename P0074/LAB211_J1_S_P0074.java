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
public class LAB211_J1_S_P0074 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Controller controller = new Controller();
        Calculator calculator = new Calculator();
        GetData getData = new GetData();
        int choice;
        while (true) {
            //step 1: display a menu
            controller.displayMenu();
            //step 2: ask user selection option
            choice = getData.getInteger("Your choice:", 1, 4);
            //step 3: perform function based on the selected option of user and display result:
            switch (choice) {
                //perform addition function
                case 1: {
                    System.out.println("-------- Addition --------");
                    int[][] matrix1 = controller.inputMatrix1();
                    int[][] matrix2 = controller.inputMatrix2(matrix1, choice);
                    int[][] result = calculator.additionMatrix(matrix1, matrix2);
                    controller.displayResult(matrix1, matrix2, result, choice);
                    break;
                }
                //perform suctraction function
                case 2:{
                    System.out.println("-------- Subtraction --------");
                    int[][] matrix1 = controller.inputMatrix1();
                    int[][] matrix2 = controller.inputMatrix2(matrix1, choice);
                    int[][] result = calculator.subtractionMatrix(matrix1, matrix2);
                    controller.displayResult(matrix1, matrix2, result, choice);
                    break;
                }
                //perform multiplication function
                case 3:{
                    System.out.println("-------- Multiplication --------");
                    int[][] matrix1 = controller.inputMatrix1();
                    int[][] matrix2 = controller.inputMatrix2(matrix1, choice);
                    int[][] result = calculator.multiplicationMatrix(matrix1, matrix2);
                    controller.displayResult(matrix1, matrix2, result, choice);
                    break;
                }
                //quit
                case 4:{
                    return;
                }
            }
        }

    }

}
