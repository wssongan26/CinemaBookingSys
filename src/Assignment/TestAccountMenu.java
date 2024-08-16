/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment;

/**
 *
 * @author ganws
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author FOCS
 */
//public class TestAccountMenu extends JFrame implements ActionListener { //button function
//
//    public TestAccountMenu() {
//        Scanner sc = new Scanner(System.in);
//        Current cu = new Current("Jie", 5);
//        Ticket a = new Ticket();
//        int choice;
//        do {
//            choice = CurrentMenu();
//            switch (choice) {
//                case 1:
//                    System.out.println("\n ---------------------------------------");
//                    System.out.println("\n                  Deposit");
//                    System.out.println("\n ---------------------------------------");
//                    System.out.println("Current Balance : " + cu.getBalance());
//                    System.out.println("Enter amount of deposit : ");
//                    double amount = sc.nextDouble();
//                    cu.deposit(amount);
//
//                    break;
//
//                case 2:
//                    System.out.println("\n ---------------------------------------");
//                    System.out.println("\n                  Payment");
//                    System.out.println("\n ---------------------------------------");
//                    System.out.println("Current Balance" + cu.getBalance());
//                    System.out.println("Enter amount of Payment :");
//                   
//                   double amount1 = sc.nextDouble();
//                    cu.withdrawal(amount1);
//                    break;
//                case 3:
//                    System.out.println("\n ---------------------------------------");
//                    System.out.println("\n             Balance Enquiry");
//                    System.out.println("\n ---------------------------------------");
//                    System.out.println("  Current Balance : " + cu.getBalance());
//                    System.out.println("\n ---------------------------------------");
//                    break;
//
//                case 4:
//                    System.out.println(cu.toString());
//                    System.out.println("Exit, good bye, please give a rating and reviews!");
//                    break;
//                default:
//                    System.out.println("Invalid choice Please re-enter again!!");
//            }
//        } while (choice != 4);
//
//    }
//
//    public static int CurrentMenu() {
//
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("-----------Welcome To Touch N Go EWallet-----------");
//        System.out.println("1. Deposit");
//        System.out.println("2. Payment");
//        System.out.println("3. Balance Enquiry");
//        System.out.println("4. Exit to give A Review");
//        System.out.println("---------------------------------------------------");
//        System.out.print("Enter Choice :");
//        int choice = sc.nextInt();
//        System.out.println("---------------------------------------------------");
//        return choice;
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//   
//}
import java.util.Scanner;

/**
 *
 * @author FOCS
 */
public class TestAccountMenu extends JFrame implements ActionListener{

    public TestAccountMenu() {
        Scanner sc = new Scanner(System.in);
        Current cu = new Current("778899", 5);
        
        int choice;
        do {
            choice = CurrentMenu();
            switch (choice) {
                case 1:
                    System.out.println("\nDeposit");
                    System.out.println("\n-------");
                    System.out.println("Current Balance : " + cu.getBalance());
                    System.out.println("Enter amount of deposit");
                    double amount = sc.nextDouble();
                    cu.deposit(amount);
                   
                    break;

                case 2:
                    System.out.println("\nPayment");
                    System.out.println("\n-------");
                    System.out.println("Current Balance" + cu.getBalance());
                    System.out.println("Enter amount of Payment");
                    amount = sc.nextDouble();
                    cu.withdrawal(amount);
                    break;
                case 3:
                    System.out.println("\n Balance Enquiry");
                    System.out.println("\n -----------------");
                    System.out.println("Current Balance : " + cu.getBalance());
                    break;
                
                case 4:
                    System.out.println(cu.toString());
                    System.out.println("Exit, good bye!");
                    break;
                default:
                    System.out.println("Invalid choice Please re-enter again");
            }
        } while (choice != 4);

    }

    public static int CurrentMenu() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Touch And Go Ewallet");
        System.out.println("1. Deposit");
        System.out.println("2. Payment");
        System.out.println("3. Balance Enquiry");
        System.out.println("4. Exit");
        System.out.print("Choice :");

        int choice = sc.nextInt();
        return choice;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
