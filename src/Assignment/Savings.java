/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment;

/**
 *
 * @author ganws
 */
public class Savings extends Account{
    private double interest;
    private static double interestRate = 0.8;

    public Savings(String accNo, double balance) {
        super(accNo, balance);
    }
    
    public double calcInterest(){
        return (getBalance() * interestRate/100/12);
    }
    
    public void addInterest(){
        deposit(calcInterest());
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        Savings.interestRate = interestRate;
    }
    
    
}
