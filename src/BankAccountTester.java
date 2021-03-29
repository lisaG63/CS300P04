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

import java.util.zip.DataFormatException;

/**
 * This class represents a tester for the BankAccount class's public behaviors.
 * @author Weihang Guo
 * @version 1.0
 */
public class BankAccountTester {
  
  /**
   * This method checks whether the BankAccount constructor throws an IllegalArgumentException when 
   * it is passed a balance smaller than 10.
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankAccountConstructorNotValidInitialBalance() {
    try {
      BankAccount test = new BankAccount("test", 5);//An invalid example.
      return false;
    } catch (IllegalArgumentException e) {
      e.getMessage();
    }
    try {
      BankAccount test = new BankAccount("test", -1);//An invalid example.
      return false;
    } catch(IllegalArgumentException e) {
      e.getMessage();
    }
    return true;
  }
  
  /**
   * Calls the constructor of BankAccount class to create a new BankAccount object with a given id 
   * and a valid initial balance (greater of equal to 10).
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankAccountConstructorValidInitialBalance() {
    try {
      BankAccount test = new BankAccount("test", 10);//A valid example.
    } catch (IllegalArgumentException e) {
      e.getMessage();
      return false;
    }
    try {
      BankAccount test = new BankAccount("test", 15);//a valid example
    } catch (IllegalArgumentException e) {
      e.getMessage();
      return false;
      }
    return true;
    
  }
  
  /**
   * Checks whether BankAccount.deposit() method throws an IllegalArgumentException when it is 
   * passed a negative number.
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankAccountDepositNegativeAmount() {
    BankAccount test = new BankAccount("test", 20);//Creates a non null valid BankAccount.
    try {
      test.deposit(-10);//An invalid example.
      return false;
    } catch (IllegalArgumentException e) {
      e.getMessage();
    }
    try {
      test.deposit(-103);//An invalid example.
      return false;
    } catch (IllegalArgumentException e) {
      e.getMessage();
    }
    return true;
  }
  
  /**
   * Checks whether BankAccount.equals() method returns true when it compares a bank account to 
   * another one having the same account identifier (case sensitive comparison); and it returns 
   * false otherwise.
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankAccountEquals() {
    BankAccount test1 = new BankAccount("Test", 20);
    BankAccount test2 = new BankAccount("Test", 20);
    BankAccount test3 = new BankAccount("test", 20);
    //Create three valid BankAccounts, two of which have the same account ID.
    if (!test1.equals(test2)) {//Compare two BankAccounts that have the same account ID.
      return false;
    }
    if (test1.equals(test3)) {//Compare two BankAccounts that have different account ID.
      return false;
    }
    return true;
  }
  
  /**
   * Checks whether BankAccount.withdraw() method throws a DataFormatException when it is passed a 
   * negative number or a number not multiple of 10.
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankAccountWithdrawInvalidAmount() {
    BankAccount test = new BankAccount("test", 20);//Creates a valid BankAccount.
    try {
      test.withdraw(15);//An invalid example(not multiple of 10).
      return false;
    } catch (DataFormatException e) {
      e.getMessage();
    }
    try {
      test.withdraw(-30);//An invalid example(negative number).
      return false;
    } catch (DataFormatException e) {
      e.getMessage();
    }
    return true;
  }
  
  /**
   * Checks whether BankAccount.withdraw() method throws an IllegalStateException when it is passed 
   * a number larger than the account's balance.
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankAccountWithdrawLargerOfBalanceAmount() {
    BankAccount test = new BankAccount("test", 20);
    //Creates a valid BankAccount with an initial balance of 20.
    try {
      test.withdraw(40);//An invalid example.
      return false;
    } catch (IllegalStateException e) {
      e.getMessage();
    } catch (DataFormatException e) {
      e.getMessage();
    }
    try {
      test.withdraw(30);//An invalid example.
      return false;
    } catch (IllegalStateException e) {
      e.getMessage();
    } catch (DataFormatException e) {
      e.getMessage();
    }
    return true;
  }
  
  
  /**
   * Checks whether BankAccount.withdraw() method returns without any exception when it is passed a 
   * positive number smaller than the account's balance.
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankAccountWithdrawValidAmount() {
    BankAccount test = new BankAccount("test", 20);
    //Creates a valid BankAccount.
    try {
      test.withdraw(10);//An valid example.
      return true;
    } catch (Exception e) {
      return false;
    }
    
  }
  
  /**
   * Calls the different test methods
   * @param args input arguments
   */
  public static void main(String[] args) {
    System.out.println(testBankAccountConstructorNotValidInitialBalance() + " " + 
        testBankAccountConstructorValidInitialBalance() + " " + 
            testBankAccountDepositNegativeAmount() + " " + testBankAccountEquals() + " " + 
                testBankAccountWithdrawInvalidAmount() + " " + 
                    testBankAccountWithdrawLargerOfBalanceAmount() + " " + 
                        testBankAccountWithdrawValidAmount());
    //Prints out all the test results.
  }

}
