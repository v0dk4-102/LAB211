/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_j1_s_p0105;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class LAB211_J1_S_P0105 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Manager manager = new Manager();
        GetData getData = new GetData();
        int choice;
        ArrayList<Storekeeper> storekeeperList = new ArrayList<>();
        ArrayList<Product> productList = new ArrayList<>();
        do {
            //step 1:display menu
            manager.displayMenu();
            //step 2:ask user to select an option
            choice = getData.getInteger("Your choice:", 1, 6);
            //step 3:perform function based on user's selection
            switch(choice){
                //option 1: Add storekeeper
                case 1:{
                    manager.addStorekeeper(storekeeperList);
                    break;
                }
                //option 2:Add product
                case 2:{
                    manager.addProduct(storekeeperList,productList);
                    break;
                }
                //option 3:Update product
                case 3:{
                    manager.updateProduct(storekeeperList,productList);
                    break;
                }
                //option 4:Search product by Name, Category, Storekeeper, ReceiptDate
                case 4:{
                    manager.searchProduct(productList);
                    break;
                }
                //option 5:Sort product by Expiry date, Date of manufacture
                case 5:{
                    manager.sortProduct(productList);
                    break;
                }
                //option 6: Exit
                case 6:{
                    return;
                }
            }
            //using loop to continue program until user choose exit option
        } while (true);

    }
    
//    public static void initialize(ArrayList<Storekeeper> storekeeperList,ArrayList<Product> productList){
//        Storekeeper sk = new Storekeeper(1, "Vinmart");
//        Storekeeper sk1 = new Storekeeper(2, "BigC");
//        Storekeeper sk2 = new Storekeeper(3, "Bach hoa");
//        Storekeeper sk3 = new Storekeeper(4, "Aeon");
//        Storekeeper sk4 = new Storekeeper(5, "Circle K");
//        storekeeperList.add(sk);
//        storekeeperList.add(sk1);
//        storekeeperList.add(sk2);
//        storekeeperList.add(sk3);
//        storekeeperList.add(sk4);
//        Product p = new Product(1, 50000, "Mochi", "Bac Ninh", "Cake", sk3, new Date(), new Date(), new Date());
//        Product p1 = new Product(2, 10000, "Cocacola", "Ha Noi", "Drink", sk4, new Date(), new Date(), new Date());
//        Product p2 = new Product(4, 35000, "Banh Canh", "Sai Gon", "Noodle", sk2, new Date(), new Date(), new Date());
//        Product p3 = new Product(3, 30000, "Flant", "Thai Binh", "Cake", sk, new Date(), new Date(), new Date());
//        Product p4 = new Product(5, 100000, "Beef", "Bac Ninh", "Meat", sk4, new Date(), new Date(), new Date());
//        productList.add(p);
//        productList.add(p1);
//        productList.add(p2);
//        productList.add(p3);
//        productList.add(p4);
//    }
}
