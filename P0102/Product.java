/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_j1_s_p0105;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class Product implements Comparable<Product> {

    private int productId, price;
    private String productName, location, category;
    private Storekeeper storekeeper;
    private Date expiryDate, dateOfManufacture, receiptDate;

    public Product(int id, int price, String name, String location, String category, Storekeeper storekeeper, Date expiryDate, Date dateOfManufacture, Date receiptDate) {
        this.productId = id;
        this.price = price;
        this.productName = name;
        this.location = location;
        this.category = category;
        this.storekeeper = storekeeper;
        this.expiryDate = expiryDate;
        this.dateOfManufacture = dateOfManufacture;
        this.receiptDate = receiptDate;
    }

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public int getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }

    public String getLocation() {
        return location;
    }

    public String getCategory() {
        return category;
    }

    public Storekeeper getStorekeeper() {
        return storekeeper;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public Date getDateOfManufacture() {
        return dateOfManufacture;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setStorekeeper(Storekeeper storekeeper) {
        this.storekeeper = storekeeper;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setDateOfManufacture(Date dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    @Override
    public int compareTo(Product o) {
        //compare expiry date of o1 with expiry o2
        if (this.getExpiryDate().equals(o.getExpiryDate())) {
            return this.getDateOfManufacture().compareTo(o.getDateOfManufacture());
        } else {
            return this.getExpiryDate().compareTo(o.getExpiryDate());
        }
    }

}
