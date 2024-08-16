/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment;

import java.util.Date;

/**
 *
 * @author ganws
 */
public class Account {
    private String accNo;
    private double balance;
    private Date dateCreated;

    public Account(String accNo, double balance) {
        this.accNo = accNo;
        this.balance = balance;
        this.dateCreated = new Date();
    }
    
    public void deposit(double amount){
        balance += amount;
    }
    
    public void withdrawal(double amount){
      
            balance -= amount;
     
    }

    @Override
    public String toString() {
        return "\nSUMMARY \nAccount"  + accNo +
                "\nBalance: " + balance + 
                "\nDateCreated=" + dateCreated ;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    
}
