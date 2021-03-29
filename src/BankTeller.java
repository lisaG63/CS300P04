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

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

/**
 * This class models the BankTeller data type.
 * @author Weihang Guo
 * @version 1.0
 */
public class BankTeller {
  private ArrayList<BankAccount> accounts;
  
  /**
   * Creates a new BankTeller object with an empty list of accounts.
   */
  public BankTeller() {
    accounts = new ArrayList<BankAccount>();
  }
  
  /**
   * Adds newAccount to the list of accounts of this BankTeller
   * @param newAccount a new account to add
   * @throws IllegalStateException with a descriptive error message if the accountID of newAccount 
   * is used by another account already added to the list of accounts
   * @throws IllegalArgumentException with a descriptive error message if newAccount is null
   */
  public void addBankAccount(BankAccount newAccount) {
    if (newAccount == null) {
      throw new IllegalArgumentException("This is an invalid account.");
    }
    for (int i = 0; i < accounts.size(); i ++) {
      if (newAccount.equals(accounts.get(i))) {//Compares two accounts' ID.
        throw new IllegalStateException("This account is already used.");
      }
    }
    accounts.add(newAccount);
    //When an account with an unused ID is created, adds it to the account list.   
  }
  
  /**
   * Returns the bank account that has exactly the provided identifier. 
   * @param id a string that represents an identifier of a bank account
   * @return a reference to the bank account whose account identifier has an exact match with the 
   * provided string
   * @throws NoSuchElementException with a descriptive error message if no account in this 
   * bankTeller's accounts list has the provided id
   */
  public BankAccount findAccount(String id) throws NoSuchElementException {
    for (int i = 0; i < accounts.size(); i ++) {
      if (id.equals(accounts.get(i).getID())) {
        return accounts.get(i);
      }
    }
    throw new NoSuchElementException("ID not found.");
  }
  
  /**
   * Adds a new transaction to the account's list of transactions.
   * @param transaction to add
   * @param account bank account
   * @throws DataFormatException if the format of the transaction is not correct
   * @throws NullPointerException if account is null
   */
  public void addTransaction(String transaction, BankAccount account) throws DataFormatException {
    try {
      if (account == null) {
        throw new NullPointerException("This account is invalid.");
      }
    } catch (NullPointerException e) {
      e.getMessage();
    }
    String transactionCode = transaction.trim().split("\\s+")[0];
    //Separates the transaction String and get the first part of it.
    String transactionAmount = transaction.trim().split("\\s+")[1];
  //Separates the transaction String and get the second part of it.
    try{
      if (!transactionCode.equals("0") && !transactionCode.equals("1")) {
        throw new DataFormatException("The transaction format is invalid.");
      } else if (transactionCode.equals("0")) {
        account.withdraw(Integer.valueOf(transactionAmount));
        //Treats the transaction as a withdrawal when the code is 0.
      } else {
        account.deposit(Integer.valueOf(transactionAmount));
        //Treats the transaction as a deposit operation when the code is 1.
      }
    } catch (IllegalStateException e) {
      System.out.println(e.getMessage());
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }
  
  /**
   * Loads a set of transactions from a provided file object.
   * @param file a java.io.File object referring to a file that contains a set of transactions, 
   * each in one line
   * @param account a reference to a BankAccount object
   * @throws FileNotFoundException if the file object does not correspond to an actual file within 
   * the file system.
   * @throws NullPointerException if account is null
   */
  public void loadTransactions(java.io.File file, BankAccount account) throws FileNotFoundException 
  {
    if (account == null) {
      throw new NullPointerException("This account is invalid.");
    }
    if (!file.exists()) {
      throw new FileNotFoundException("File not found.");
    }
    Scanner input = new Scanner(file);
    while(input.hasNext()) {
      String transaction = input.nextLine();//Stores the contents of the file line by line.
      try {
        addTransaction(transaction, account);
      } catch (DataFormatException e) {
        e.getMessage();
      }
    input.close();
    }
      
  }
  
  /**
   * Returns the total number of accounts created so far 
   * @return the total number of accounts added to this BankTeller
   */
  public int getAccountsCount() {
    return accounts.size();
  }






      



  
}
