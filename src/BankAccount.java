//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P04 Exceptional Bank Teller
// Files:           BankAccount.java, BankAccountTester.java, BankTeller.java, 
//                  BankTellerTester.java
// Course:          CS300, fall, 2019
//
// Author:          Weihang Guo
// percentage:           wguo63@wisc.edu
// Lecturer's Name: Mouna Kacem
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Milks: None
// Online Sources: None
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.ArrayList;
import java.util.zip.DataFormatException;

/**
 * This class models a very simple account at a bank.
 * @author Weihang Guo
 * @version 1.0
 */
public class BankAccount {
  private String accountID;//Stores the identifier of an account.
  private int balance;//Stores the balance in an account.
  private ArrayList<String> transactions;//Stores all the transactions made on an account.  
  
  /**
   * Creates a new bank account with a given account identifier and an initial balance.
   * @param accountID this account's unique identifier
   * @param initialBalance this account's initial balance
   * @throws IllegalArgumentException with a descriptive error message if initBalance is 
   * less than 10
   */
  public BankAccount(String accountID, int initialBalance) {
    this.accountID = accountID;
    balance = initialBalance;
    transactions = new ArrayList<String>();
    if (initialBalance < 10) {
      throw new IllegalArgumentException("Initial balance is less than 10.");
    }
    transactions.add("1 " + initialBalance);//Stores the initial balance as the first transaction.
  } 
  
  /**
   * This method deposits an amount to this bank account.
   * @param depositAmount the amount of money to deposit to this bank account
   * @throws IllegalArgumentException with a descriptive error message if depositAmount is negative
   */
  public void deposit(int depositAmount) {
    if (depositAmount < 0) {
      throw new IllegalArgumentException("Deposit amount is negative.");
    }
    transactions.add("1 " + depositAmount);
    //When the deposit amount is positive, stores this deposit in transaction records.
    balance  += depositAmount;//Updates the balance of this account.
  }
  
  /**
   * Checks if an other bank account is equal to this one.
   * @param other another BankAccount object
   * @return true if this bankAccount's identifier equals the other bankAccount's identifier. 
   * The comparison is case sensitive.
   */
  public boolean equals(BankAccount other) {
    if (other.getID().equals(accountID)) {
      return true;
    }
    return false;
  }
  
  /**
   * Gets the current balance of this bank account
   * @return the current balance of this bank account
   */
  public int getBalance() {
    return balance;
  }
  
  /**
   * Gets the unique identifier of this account
   * @return the unique identifier of this account
   */
  public String getID() {
    return accountID;
  }
  
  /**
   * Gets the most recent FIVE transactions in an array of length 5.
   * @return the most recent transactions in an array that may contain up to 5 string references
   */
  public String[] getMostRecentTransactions() {
    String[] mostRecentTransactions = new String[5];
    for (int i = 0; i < Math.min(transactions.size(), mostRecentTransactions.length); i ++) {
      mostRecentTransactions[i] = transactions.get(transactions.size() - 1 - i);
    }
    return mostRecentTransactions;
  }
  
  /**
   * Gets the total number of transactions performed on this bank account, meaning the size of the 
   * ArrayList of transactions of this bank account.
   * @return the total number of transactions performed on this account
   */
  public int getTransactionsCount() {
    return transactions.size();
  }
  
  /**
   * This method withdraws a specific amount of money. 
   * It also adds the transaction /"0 " + withdrawAmount/ to this accunt's list of transactions 
   * and updates this bank account's balance.
   * @param withdrawAmount the amount of money to withdraw from this bank account
   * @throws DataFormatException with a descriptive error message if withdrawAmount is negative 
   * or is not a multiple of 10
   * @throws IllegalStateException if the withdrawAmount is larger than this bank account's 
   * balance
   */
  public void withdraw(int withdrawAmount) throws DataFormatException {
    if (withdrawAmount < 0 || withdrawAmount%10 != 0) {
      throw new DataFormatException("Invalid withdraw amount.");
    }
    if (withdrawAmount > balance) {
      throw new IllegalStateException("The withdraw amount is larger than the acounts' balance.");
    }
    transactions.add("0 " + withdrawAmount);
    //When the withdraw amount is valid, stores this withdrawal in transaction records.
    balance -= withdrawAmount;
    //Updates the balance of this account.
  }
  
  
  
  
  

}
