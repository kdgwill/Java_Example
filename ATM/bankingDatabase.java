package com.BOA.ATM;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * This class utilizes an Arraylist for keeping track of Accounts within this Banking Program
 * @author Kyle D. Williams
 */
public class bankingDatabase {
    
    private final ArrayList<Account> database;
    
    public bankingDatabase() {
        database = new ArrayList<Account>();
    }

    /**
     * Generates a new Account and Adds to the BankingDatabase
     * @param num The Account Number 
     * @param pin The Pin Number for this Account
     */
    public Account createAccount(int num, int pin) {
        
        if (getAccount(num) != null) {
            JOptionPane.showMessageDialog(null, "The Account Number:\n" + num + "\n is unavailable please choose another");
            return null;
        } else {
            Account acc = new Account(num, pin);
            database.add(acc);
            return acc;
        }
    }
    
    public void createTestAccount(int num, int pin, float chck, float sav) {
        Account acc = createAccount(num, pin);
        acc.depositToChecking(chck);
        acc.depositToSavings(sav);
    }

    /*
     * This method searches through the list of Accounts for a specific one
     * @param aN the identification number for the account
     */
    public Account getAccount(int aN) {
        for (Account acc : database) {
            if (acc.getAccountNumer() == aN) {
                return acc;
            }
        }
        return null;
    }
}
