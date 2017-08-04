/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creditcard;

/**
 *
 * @author ryan
 */
public class CreditCard {
    
    // Instance variables
    private String customer;
    private String bank;
    private String account;
    private int limit;
    protected double balance;
    
    // Constructors
    public CreditCard(String cust, String bk, String acnt, int lim, double initialBal) {
        customer = cust;
        bank = bk;
        account = acnt;
        limit = lim;
        balance = initialBal;
    }
    public CreditCard(String cust, String bk, String acnt, int lim) {
        this(cust, bk, acnt, lim, 0.0);
    }
    
    // Accessor Methods
    public String getCustomer() { 
        return customer; 
    }
    public String getBank() {
        return bank;
    }
    public String getAccount() {
        return account;
    }
    public int getLimit() {
        return limit;
    }
    public double getBalance() {
        return balance;
    }
    
    // Update Methods
    public boolean charge(double price) {
        if (price + balance > limit) {
            return false;
        } 
        // at this point, the charge is successful.
        balance += price;
        return true;
    }
    public void makePayment(double amount) {
        if (amount > 0) {
            balance -= amount; 
        }
        else {
            System.out.println("You must enter a positive payment amount.");
        }
        
    }
    public void setLimit(int theLimit) {
        limit = theLimit;
    }
    
    // Utility method to print a card's information
    public void printSummary() {
        System.out.println("Customer = " + customer);
        System.out.println("Bank = " + bank);
        System.out.println("Account = " + account);
        System.out.println("Balance = " + balance); // implicit cast
        System.out.println("Limit = " + limit);     // implicit cast
    } 
    
    // Returns a string representation of all of the card information
    public String toString() {
        String cardInfo = "Customer: " + customer + ", " +
                "Bank: " + bank + ", " +
                "Account: " + account + ", " +
                "Balance: " + balance + ", " +
                "Limit = " + limit;
        return cardInfo;
    } 
 
    // Main method
    public static void main(String[] args) {
        CreditCard[] wallet = new CreditCard[3];
        wallet[0] = new CreditCard("John Bowman", "California Savings", "5391 0375 9387 5309", 5000);
        wallet[1] = new CreditCard("John Bowman", "California Federal", "5391 0375 9387 5310", 3500);
        wallet[2] = new CreditCard("John Bowman", "California Financial", "5391 0375 9387 5311", 2500, 300);
        
        for (int val = 1; val <= 16; val++) {
            wallet[0].charge(3 * val);
            wallet[1].charge(2 * val);
            wallet[2].charge(val);
        }
        
        for (CreditCard card : wallet) {
            System.out.println(card.toString());
            while (card.getBalance() > 200.0) {
                card.makePayment(200);
                System.out.println("New balance = " + card.getBalance());
            }
            
        }
        
    }
    
}
