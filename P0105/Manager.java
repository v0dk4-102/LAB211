/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_j1_s_p0105;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class Manager {

    private GetData getData = new GetData();

    public void displayMenu() {
        System.out.println("Main menu:");
        System.out.println("\t1. Add Storekeeper");
        System.out.println("\t2. Add product");
        System.out.println("\t3. Update product");
        System.out.println("\t4. Search product by Name, Category, Storekeeper, ReceiptDate");
        System.out.println("\t5. Sort product by Expiry date, Date of manufacture");
        System.out.println("\t6. Exit");
    }

    private boolean checkDuplicateStorekeeperID(ArrayList<Storekeeper> storekeeperList, int storekeeperId) {
        boolean isDuplicate = false;
        /*Using loop to access each element of storekeeper list 
         from the beginning to the end*/
        for (Storekeeper storekeeper : storekeeperList) {
            //compare variable storekeeperName with storekeeper's name in the list
            if (storekeeper.getStorekeeperId() == storekeeperId) {
                System.out.print("That ID has already existed");
                isDuplicate = true;
                break;
            }
        }
        return isDuplicate;
    }

    public void addStorekeeper(ArrayList<Storekeeper> storekeeperList) {
        System.out.println("--------Add storekeeper--------");
        displayStorekeeperList(storekeeperList);
        String storekeeperName;
        int storekeeperId;
        //using loop to get new storekeeper
        while (true) {
            storekeeperId = getData.getInteger("Enter new storekeeper's id:", 0, Integer.MAX_VALUE);
            boolean isDuplicated = checkDuplicateStorekeeperID(storekeeperList, storekeeperId);
            //check duplicate
            if (isDuplicated) {
                System.out.println(", please try again");
                continue;
            }
            storekeeperName = getData.getString("Enter new storekeeper's name:", "", "");
            Storekeeper storekeeper = new Storekeeper(storekeeperId, storekeeperName);
            storekeeperList.add(storekeeper);
            break;
        }
        System.out.println("********After add********");
        displayStorekeeperList(storekeeperList);

    }

    private boolean checkDuplicateIdOfProduct(ArrayList<Product> productList, int productId) {
        boolean isDuplicated = false;
        /*using loop to access each element of product list from the 
         beginning to the end*/
        for (Product product : productList) {
            //compare variable productId to each product's id in product list
            if (productId == product.getProductId()) {
                System.out.println("Product's ID has already existed, please try again");
                isDuplicated = true;
                break;
            }
        }
        return isDuplicated;
    }

    public void addProduct(ArrayList<Storekeeper> storekeeperList, ArrayList<Product> productList) {
        System.out.println("--------Add Product--------");
        //check empty
        if(storekeeperList.isEmpty()){
            System.out.println("Storekeeper list is empty, can not add product");
            System.out.println("Please choose option 1 to add storekeeper first");
            return;
        }
        displayProductList(productList);
        int productId;
        boolean isExisted;
        //using loop to get non-duplicate product id
        while (true) {
            productId = getData.getInteger("Enter product's id:", 0, Integer.MAX_VALUE);
            isExisted = checkDuplicateIdOfProduct(productList, productId);
            //check duplicate
            if (isExisted) {
                continue;
            }
            break;
        }
        String productName = getData.getString("Enter product's name:", "", "");
        String productLocation = getData.getString("Enter product's location: ", "", "");
        int price = getData.getInteger("Enter product's price:", 1, Integer.MAX_VALUE);
        Date dateOfManufacturer, expiryDate;
        //using loop to get expected value of variable dateOfManufacturer
        while (true) {
            dateOfManufacturer = getData.getDate("Enter product's manufacture date that follow format dd/mm/yyyy:");
            Date now = new Date();
            //compare manufacture date with today
            if (dateOfManufacturer.after(now)) {
                System.out.println("Date of manufacture must be in the past");
                continue;
            }
            break;
        }
        //using loop to get expected value of variable expiryDate
        while (true) {
            expiryDate = getData.getDate("Enter product's expiry date that follow format dd/mm/yyyy:");
            //compare expiry date with date of manufacture
            if (expiryDate.before(dateOfManufacturer)) {
                System.out.println("Expiry date must be after date of manufacture");
                continue;
            }
            break;
        }
        String category = getData.getString("Enter product's category:", "", "");
        Storekeeper storekeeper = null;
        displayStorekeeperList(storekeeperList);
        //check empty
        if (storekeeperList.isEmpty()) {
            System.out.println("Please choose option 1 to add storekeeper first");
            return;
        }
        int storekeeperChoice = getData.getInteger("Choose storekeeper by ID:", 1, storekeeperList.size());
        /*using loop to access each element of storekeeper list 
         from the beginning to the end*/
        for (Storekeeper storeInList : storekeeperList) {
            //compare ID of storekeeper in the list with variable storekeeperChoice
            if (storeInList.getStorekeeperId() == storekeeperChoice) {
                storekeeper = new Storekeeper(storeInList.getStorekeeperId(), storeInList.getStorekeeperName());
                break;
            }
        }
        Date receiptDate;
        //using loop to get expected input
        while (true) {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String manufactoringDate = dateFormat.format(dateOfManufacturer);
            String expiryDateS = dateFormat.format(expiryDate);
            receiptDate = getData.getDate("Enter receipt date:");
            if (receiptDate.before(dateOfManufacturer) || receiptDate.after(expiryDate)) {
                System.out.println("Receipt date must be from " + manufactoringDate + " to " + expiryDateS);
                continue;
            }
            break;
        }
        Product newProduct = new Product(productId, price, productName, productLocation, category, storekeeper, expiryDate, dateOfManufacturer, receiptDate);
        productList.add(newProduct);
        displayProductList(productList);
    }

    private int searchProductById(ArrayList<Product> productList, int id) {
        int pos = -1;
        //check empty
        if (productList.isEmpty()) {
            System.out.println("Product list is empty");
        } else {
            /*loop use to access each element of employee list from
             the beginning to the end*/
            for (Product product : productList) {
                //compare id input and each id of employee in the list
                if (id == product.getProductId()) {
                    pos = productList.indexOf(product);
                    break;
                }
            }
        }
        return pos;
    }

    public boolean checkStorekeeperExist(ArrayList<Storekeeper> storekeeperList, int storekeeperId) {
        boolean isExisted = false;
        for (Storekeeper storekeeper : storekeeperList) {
            if (storekeeper.getStorekeeperId() == storekeeperId) {
                isExisted = true;
                break;
            }
        }
        return isExisted;
    }

    public void updateProduct(ArrayList<Storekeeper> storekeeperList, ArrayList<Product> productList) {
        System.out.println("--------Update Product--------");
        //check empty
        if (productList.isEmpty()) {
            System.out.println("Product list is currently empty"
                    + ", please choose option 2 to add product"
                    + " before update");
            return;
        }
        int pos, id;
        //using loop to get position of product which is needed to update
        while (true) {
            displayProductList(productList);
            id = getData.getInteger("Enter product's id to update:", 0, Integer.MAX_VALUE);
            pos = searchProductById(productList, id);
            //check id existed
            if (pos == -1) {
                System.out.println("That product's id does not exist in the list"
                        + ", please try again");
                continue;
            }
            break;
        }
        do {
            System.out.println("Choose update option:");
            System.out.println("\t1. Update ID of product");
            System.out.println("\t2. Update name of product");
            System.out.println("\t3. Update location of product");
            System.out.println("\t4. Update price of product");
            System.out.println("\t5. Update expiry date of product");
            System.out.println("\t6. Update date of manufacture of product");
            System.out.println("\t7. Update category of product");
            System.out.println("\t8. Update storekeeper of product");
            System.out.println("\t9. Update receipt date of product");
            int choice = getData.getInteger("Your choice: ", 1, 9);
            switch (choice) {
                case 1: {
                    int idUpdate;
                    while (true) {
                        idUpdate = getData.getInteger("Enter new ID of product:", 0, Integer.MAX_VALUE);
                        //check whether variable idUpdate equals to product's old id
                        if (id == idUpdate) {
                            System.out.println("You have entered old Id, please"
                                    + " enter a new Id");
                            continue;
                        }
                        boolean isExisted = checkDuplicateIdOfProduct(productList, idUpdate);
                        //check duplicate
                        if (isExisted) {
                            continue;
                        }
                        break;
                    }
                    productList.get(pos).setProductId(idUpdate);
                    break;
                }
                case 2: {
                    String nameUpdate = getData.getString("Enter name of product:", "", "");
                    productList.get(pos).setProductName(nameUpdate);
                    break;
                }
                case 3: {
                    String locationUpdate = getData.getString("Enter location of product:", "", "");
                    productList.get(pos).setLocation(locationUpdate);
                    break;
                }
                case 4: {
                    int priceUpdate = getData.getInteger("Enter price of product:", 0, Integer.MAX_VALUE);
                    productList.get(pos).setPrice(priceUpdate);
                    break;
                }
                case 5: {
                    Date expiryDateUpdate;
                    //using loop to get expected input
                    while (true) {
                        expiryDateUpdate = getData.getDate("Enter expiry date of product:");
                        //compare expiry date with date of manufacture
                        if (expiryDateUpdate.before(productList.get(pos).getDateOfManufacture())) {
                            System.out.println("Expiry date must be after date of manufacture");
                            continue;
                        }
                        break;
                    }
                    productList.get(pos).setExpiryDate(expiryDateUpdate);
                    break;
                }
                case 6: {
                    Date manufactureDateUpdate;
                    while (true) {
                        manufactureDateUpdate = getData.getDate("Enter manufacture of product:");
                        //compare manufacture date with expiry date
                        if (manufactureDateUpdate.after(productList.get(pos).getExpiryDate())) {
                            System.out.println("Manufacture date must be before expiry date");
                            continue;
                        }
                        //compare manufacture date with receipt date
                        if (manufactureDateUpdate.after(productList.get(pos).getReceiptDate())) {
                            System.out.println("Manufacture date must be before receipt date");
                            continue;
                        }
                        break;
                    }
                    productList.get(pos).setDateOfManufacture(manufactureDateUpdate);
                    break;
                }
                case 7: {
                    String categoryUpdate = getData.getString("Enter category of product:", "", "");
                    productList.get(pos).setCategory(categoryUpdate);
                    break;
                }
                case 8: {
                    Storekeeper storekeeperUpdate = null;
                    displayStorekeeperList(storekeeperList);
                    int storekeeperId, storekeeperIdUpdate;
                    while (true) {
                        storekeeperId = productList.get(pos).getStorekeeper().getStorekeeperId();
                        boolean checkExistence;
                        storekeeperIdUpdate = getData.getInteger("Enter new storekeeper's ID:", 0, Integer.MAX_VALUE);
                        checkExistence = checkStorekeeperExist(storekeeperList, storekeeperIdUpdate);
                        if(storekeeperId == storekeeperIdUpdate){
                            System.out.println("You have enter old storekeeper's ID, please try again");
                            continue;
                        }
                        if (!checkExistence) {
                            System.out.println("That storekeeper does not exist in storekeeper list");
                            continue;
                        }
                        break;
                    }
                    for(Storekeeper storekeeper:storekeeperList){
                        if(storekeeper.getStorekeeperId()==storekeeperIdUpdate)
                            storekeeperUpdate = storekeeper;
                    }
                    productList.get(pos).setStorekeeper(storekeeperUpdate);
                    break;
                }
                case 9: {
                    Date receiptDateUpdate;
                    //using loop to get expected receipt date
                    while (true) {
                        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        String manufactoringDate = dateFormat.format(productList.get(pos).getDateOfManufacture());
                        String expiryDateS = dateFormat.format(productList.get(pos).getExpiryDate());
                        receiptDateUpdate = getData.getDate("Enter receipt date:");
                        //compare receipt date with manufacture date and expiry date
                        if (receiptDateUpdate.before(productList.get(pos).getDateOfManufacture()) || receiptDateUpdate.after(productList.get(pos).getExpiryDate())) {
                            System.out.println("Receipt date must be from " + manufactoringDate + " to " + expiryDateS);
                            continue;
                        }
                        break;
                    }
                    productList.get(pos).setReceiptDate(receiptDateUpdate);
                    break;
                }
            }
            displayProductList(productList);
            //[yn]: input must be y or n
            String answer = getData.getString("Do you want to continue?", "y or n", "[yn]");
            //compare value of answer to n
            if (answer.equals("n")) {
                break;
            }
        } while (true);
    }

    public void searchProduct(ArrayList<Product> productList) {
        System.out.println("--------Search Product--------");
        int choice;
        if(productList.isEmpty()){
            System.out.println("There is no product to search in product list");
            return;
        }
        //using loop to continue searching until user dont want to search anymore
        while (true) {
            System.out.println("Menu Search:");
            System.out.println("\t1. Search by Name");
            System.out.println("\t2. Search by category");
            System.out.println("\t3. Search by storekeeper");
            System.out.println("\t4. Search by receipt date");
            choice = getData.getInteger("Enter your choice:", 1, 4);
            switch (choice) {
                case 1: {
                    searchByName(productList);
                    break;
                }
                case 2: {
                    searchByCategory(productList);
                    break;
                }
                case 3: {
                    searchByStorekeeper(productList);
                    break;
                }
                case 4: {
                    searchByReceiptDate(productList);
                    break;
                }
            }
            //[yn]: input must be y or n
            String answer = getData.getString("Do you want to continue?", "y or n", "[yn]");
            //compare value of answer to n
            if (answer.equals("n")) {
                break;
            }
        }
    }

    public void sortProduct(ArrayList<Product> productList) {
        //check empty
        if(productList.isEmpty()){
            System.out.println("There is no product in list");
            return;
        }
        displayProductList(productList);
        Collections.sort(productList);
        System.out.println("********After sorting********");
        displayProductList(productList);
    }

    private void displayStorekeeperList(ArrayList<Storekeeper> storekeeperList) {
        //check empty
        if (storekeeperList.isEmpty()) {
            System.out.println("Storekeeper list is currently empty");
            return;
        }
        System.out.println("---------Storekeeper list----------");
        System.out.format("%5s%20s\n", "ID", "Name");
        /*using loop to access each element of storekeeper list from
         the beginning to the end*/
        for (Storekeeper storekeeper : storekeeperList) {
            System.out.format("%5s%20s\n", storekeeper.getStorekeeperId(), storekeeper.getStorekeeperName());
        }
    }

    private void displayProduct(Product product) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String expiryDate = dateFormat.format(product.getExpiryDate());
        String dateOfManu = dateFormat.format(product.getDateOfManufacture());
        String receiptDate = dateFormat.format(product.getReceiptDate());
        System.out.format("%3d%15s%10s%10d%20s%20s%15s%20s%20s\n", product.getProductId(), product.getProductName(), product.getLocation(),
                product.getPrice(), dateOfManu, expiryDate, product.getCategory(), product.getStorekeeper(),
                receiptDate);
    }

    private void displayProductList(ArrayList<Product> productList) {
        //check empty
        if (productList.isEmpty()) {
            System.out.println("Product list is currently empty");
            return;
        }
        System.out.println("---------Product list----------");
        System.out.format("%3s%15s%10s%10s%20s%20s%15s%20s%20s\n",
                "Id", "Name", "Location", "Price", "Manufacture date", "Expiry date",
                "Category", "Storekeeper", "Receipt date");
        /*using loop to access each element of product list 
         from the beginning to the end*/
        for (Product product : productList) {
            displayProduct(product);
        }
    }

    private void searchByName(ArrayList<Product> productList) {
        System.out.println("--------Search by name--------");
        if (productList.isEmpty()) {
            System.out.println("Product list is currently empty"
                    + ", please choose option 2 to add product first");
            return;
        }
        String nameSearch = getData.getString("Enter name for searching", "", "");
        ArrayList<Product> resultList = new ArrayList<>();
        /*using loop to access each element of product list from 
         the beginning to the end*/
        for (Product product : productList) {
            //compare variable nameSearch with name of product in list
            if (product.getProductName().equals(nameSearch)) {
                resultList.add(product);
            }
        }
        //check empty
        if (resultList.isEmpty()) {
            System.out.println("That product doesn't exist in list");
        } else {
            displayProductList(resultList);
        }
    }

    private void searchByCategory(ArrayList<Product> productList) {
        System.out.println("--------Search by category--------");
        //check empty
        if (productList.isEmpty()) {
            System.out.println("Product list is currently empty"
                    + ", please choose option 2 to add product first");
            return;
        }
        String categorySearch = getData.getString("Enter category for searching", "", "");
        ArrayList<Product> resultList = new ArrayList<>();
        /*using loop to access each element of product list from 
         the beginning to the end*/
        for (Product product : productList) {
            //compare variable categorySearch with name of product in list
            if (product.getCategory().equals(categorySearch)) {
                resultList.add(product);
            }
        }
        //check empty
        if (resultList.isEmpty()) {
            System.out.println("That product doesn't exist in list");
        } else {
            displayProductList(resultList);
        }
    }

    private void searchByStorekeeper(ArrayList<Product> productList) {
        System.out.println("--------Search By Storekeeper--------");
        //check empty
        if (productList.isEmpty()) {
            System.out.println("Product list is currently empty"
                    + ", please choose option 2 to add product first");
            return;
        }
        String storekeeperName = getData.getString("Enter storekeeper name for searching: ", "", "");
        ArrayList<Product> resultList = new ArrayList<>();
        //loop use to access each element of arraylist from begining to the end
        for (Product product : productList) {
            //compare variable of storekeeper input with storekeeper in list
            if (product.getStorekeeper().getStorekeeperName().equals(storekeeperName)) {
                resultList.add(product);
            }
        }
        //check empty
        if (resultList.isEmpty()) {
            System.out.println("That product doesn't exist in list");
        } else {
            displayProductList(resultList);
        }

    }

    private void searchByReceiptDate(ArrayList<Product> productList) {
        System.out.println("--------Search by receipt date--------");
        //check empty
        if (productList.isEmpty()) {
            System.out.println("Product list is currently empty"
                    + ", please choose option 2 to add product first");
            return;
        }
        Date receiptdate = getData.getDate("Enter receipt date for search: ");
        ArrayList<Product> resultList = new ArrayList<>();
        //loop use to access each element of arraylist from begining to the end
        for (Product product : productList) {
            //compare variable of receiptdate input with receiptdate of product in list
            if (product.getReceiptDate().equals(receiptdate)) {
                resultList.add(product);
            }
        }
        //check empty
        if (resultList.isEmpty()) {
            System.out.println("Product is not found!");
        } else {
            displayProductList(resultList);
        }
    }

}
