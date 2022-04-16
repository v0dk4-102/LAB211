/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_j1_s_p0101;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class Employee implements Comparable<Employee>{

    private String id, firstName, lastName, email, address, phone, sex, agency;
    private Date dateOfBirth;
    private int salary;

    public Employee() {
    }

    public Employee(String id, String firstName, String lastName, String email, String address, String phone, String sex, String agency, Date dateOfBirth, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.sex = sex;
        this.agency = agency;
        this.dateOfBirth = dateOfBirth;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", address=" + address + ", phone=" + phone + ", sex=" + sex + ", agency=" + agency + ", dateOfBirth=" + dateOfBirth + ", salary=" + salary + '}';
    }

    @Override
    public int compareTo(Employee o) {
        return this.getSalary() - o.getSalary();
    }

}
