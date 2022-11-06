/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Account;
import java.io.IOException;
import tools.MyTool;
import controller.MenuManagement;
/**
 *
 * @author BaPhuoc
 */
public class LogIn {
    private static Account acc;
    private static MyTool tools = new MyTool();
    private static final String ACC_FORMAT = "D\\d{3}";
    
    //constructor
    public LogIn(Account acc) {
        this.acc = acc;
    }

    public LogIn() {
    }

    public Account getAcc() {
        return acc;
    }
    
    public static Account inputAccount() {
        System.out.println("=#=#=#=#=#=#=# Login =#=#=#=#=#=#=#");
        String accName = tools.inputAccount("Enter your account name: ", ACC_FORMAT);
        String pwd = tools.inputString("Enter your password: ");
        String role = tools.inputRole("Enter your role (BOSS/ACC-1/ACC-2): ");
        Account LoginAccount = new Account(accName, pwd, role);
        return LoginAccount;
    }
    public static void handleLogIn() throws IOException {
        acc = null;
        boolean valid = false;
        boolean confirmYN = false;
        AccountChecker accCheck = new AccountChecker();
        do {
           acc = inputAccount();
           //check account valid?
           valid = accCheck.check(acc);
           confirmYN = false;
           if(!valid) {
               confirmYN = tools.confirm("Invalid account - Try agin? (Y/N)");
           }
           if (!valid && !confirmYN) {
                System.exit(0);
            }
        } while (!valid);
        System.out.println("=#=#=#=#=#=#=# Login success =#=#=#=#=#=#=#");
        MenuManagement menu = new MenuManagement();
        switch(acc.getRole().toUpperCase()) {
            case "ACC-1":
                menu.dealerManagement();
                break;
            case "ACC-2":
                menu.deliveryManagement();
                break;
            case "BOSS":
                menu.accountManagement();
                break;
        }
    }
    public static void main(String[] args) throws IOException {
        handleLogIn();
    }
}
