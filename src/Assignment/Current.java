/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment;

/**
 *
 * @author ganws
 */
public class Current extends Account {

    private static int freeTransactions = 3;
    private static double transactionFees = 2.50;
    private int transactionCount;

    public Current(String accNo, double balance) {
        super(accNo, balance);
        this.transactionCount = 0;
    }

    public void increaseTransactionCount() {
        transactionCount++;
    }

    public void deductTransactionFees() {
        if (getBalance() < transactionFees) {
            System.out.println("Transaction fees deduction failed!");
        } else {
            super.withdrawal(transactionFees);
            System.out.println("Transaction fees deducted!");
        }

    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        increaseTransactionCount();
        System.out.println("Transaction count" + getTransactionCount());
        System.out.println("Deposit successful");//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void withdrawal(double amount) {

        if (getBalance() > amount) {
            super.withdrawal(amount);
            increaseTransactionCount();
            increaseTransactionCount();
            System.out.println("Transaction count " + getTransactionCount());
            System.out.println("Payment successsful");
        } else {
            System.out.println("Insufficient fundS!");
        }

    }

    @Override
    public String toString() {
        return super.toString()
                + "\ntransactionCount :" + transactionCount;
    }

    public boolean equals(Object obj) {
        Account otherAcc = (Account) obj;
        if(this.getAccNo() == otherAcc.getAccNo())
        return true;
        else
             return false;
    }

    public static int getFreeTransactions() {
        return freeTransactions;
    }

    public static void setFreeTransactions(int freeTransactions) {
        Current.freeTransactions = freeTransactions;
    }

    public static double getTransactionFees() {
        return transactionFees;
    }

    public static void setTransactionFees(double transactionFees) {
        Current.transactionFees = transactionFees;
    }

    public int getTransactionCount() {
        return transactionCount;
    }

    public void setTransactionCount(int transactionCount) {
        this.transactionCount = transactionCount;
    }

}
