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

import java.io.File;
import java.io.FileNotFoundException;

/**
 * This class is a tester for the BankTeller class's public behaviors.
 * @author Weihang Guo
 * @version 1.0
 */
public class BankTellerTester {
  
  /**
   * Checks whether the constructor of BankTeller class creates a new BankTeller object with an 
   * empty ArrayList of bank accounts.
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankTellerConstructor() {
    BankTeller test = new BankTeller();
    BankAccount account1 = new BankAccount("account1", 30);
    try {
      test.addBankAccount(account1);
    } catch (NullPointerException e) {
      return false;
    }
    return true;
    
  }
  
  /**
   * Checks whether the BankTeller.addBankAccount() method throws an IllegalStateException when it 
   * is passed a bank account with an identifier already used.
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankTellerAddBankAccountUsedIdentifier() {
    boolean isCorrect = false;
    BankTeller test = new BankTeller();
    BankAccount account1 = new BankAccount("account1", 30);
    BankAccount account2 = new BankAccount("account1", 30);
    BankAccount account3 = new BankAccount("account3", 30);
    test.addBankAccount(account1);
    try {
      test.addBankAccount(account2);////An invalid example.
    } catch (IllegalStateException e) {
      isCorrect = true;
    }
    try {
      test.addBankAccount(account3);////An valid example.
    } catch (IllegalStateException e) {
      isCorrect = false;
    }
    return isCorrect;
    
  }
  
  /**
   * This method checks whether the BankTeller.loadTransactions() method that takes a File 
   * parameter throws a FileNotFoundException, when it is passed a File object that does not 
   * correspond to an actual file within the file system, and a non null reference of type 
   * BankAccount.
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankTellerLoadTransactionsFileNotFound() {
    BankTeller test = new BankTeller();
    BankAccount account = new BankAccount("account", 30);
    File file = new File("fileNotExist");////An invalid example.
    try {
      test.loadTransactions(file, account);
    } catch (FileNotFoundException e) {
      return true;
    }
    return false;
  }
  

  /**
   * Calls the test methods defined in this BankTellerTester class
   * @param args input arguments
   */
  public static void main(String[] args) {
    System.out.println(testBankTellerConstructor() + " " + 
        testBankTellerAddBankAccountUsedIdentifier() + " " + 
            testBankTellerLoadTransactionsFileNotFound());
    //Prints out all the test results.
  }

}
