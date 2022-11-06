/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import model.DealerList;
import model.DeliveryList;
import model.AccountList;
import tools.MyTool;
import model.LogIn;
import view.Menu;

/**
 *
 * @author BaPhuoc
 */
public class MenuManagement {

    public static void dealerManagement() throws IOException {
        System.out.println("Hello ACC-1!");
        String[] options = {
            "Add new dealer", "Search a dealer", "Remove a dealer", "Update a dealer",
            "Print all dealers", "Print Un-continuing dealers", "Print Continuing dealers", "Save to file", "Log out"
        };
        LogIn logIn = new LogIn();
        Menu menu = new Menu(options);
        DealerList dList = new DealerList(); //dealer list
        dList.iniWithFile();
        int choice = 0;
        boolean finish = false;
        boolean logOut = false;
        do {
            choice = menu.getChoice("=#=#=#=#=#=#=# Manage dealer =#=#=#=#=#=#=#");
            switch (choice) {
                case 1:
                    dList.addDealer();
                    finish = !MyTool.confirm("Back to menu? (Y/N): ");
                    break;
                case 2:
                    dList.searchDealer();
                    finish = !MyTool.confirm("Back to menu? (Y/N): ");
                    break;
                case 3:
                    dList.removeDealer();
                    finish = !MyTool.confirm("Back to menu? (Y/N): ");
                    break;
                case 4:
                    dList.updateDealer();
                    finish = !MyTool.confirm("Back to menu? (Y/N): ");
                    break;
                case 5:
                    dList.printAllDealers();
                    finish = !MyTool.confirm("Back to menu? (Y/N): ");
                    break;
                case 6:
                    dList.printUnContinuingDealers();
                    finish = !MyTool.confirm("Back to menu? (Y/N): ");
                    break;
                case 7:
                    dList.printContinuingDealers();
                    finish = !MyTool.confirm("Back to menu? (Y/N): ");
                    break;
                case 8:
                    dList.writeDealerToFile();
                    finish = !MyTool.confirm("Back to menu? (Y/N): ");
                    break;
                case 9: 
                    logOut = MyTool.confirm("Log out? (Y/N): ");
                    if(logOut) {
                        finish = true;
                    }
                    else finish = !MyTool.confirm("Back to menu? (Y/N): ");
                    break;
                default:
                    if (dList.isChanged()) {
                        boolean res = MyTool.confirm("Data changed. Save to file? (Y/N): ");
                        if (res == true) {
                            dList.writeDealerToFile();
                        }
                    }
                    if(!logOut) finish = MyTool.confirm("Quit? (Y/N): ");
            }
        } while (!finish);
        if (dList.isChanged()) {
            boolean res = MyTool.confirm("Data changed. Save to file? (Y/N): ");
            if (res == true) {
                dList.writeDealerToFile();
            }
        }
        if(logOut)  logIn.handleLogIn();
        else System.out.println("Finish");
    }

    public static void deliveryManagement() throws IOException {
        System.out.println("Hello ACC-2!");
        String[] options = {
            "Add new delivery", "Search a delivery", "Remove a delivery", "Update a delivery",
            "Print all delivery", "Print Un-continuing delivery", "Print Continuing delivery", "Save to file", "Log out"
        };
        Menu menu = new Menu(options);
        LogIn logIn = new LogIn();
        DeliveryList dList = new DeliveryList(); // delivery list
        dList.iniWithFile();
        int choice = 0;
        boolean finish = true;
        boolean logOut = false;
        do {
            choice = menu.getChoice("=#=#=#=#=#=#=# Manage delivery =#=#=#=#=#=#=#");
            switch (choice) {
                case 1:
                    dList.addDelivery();
                    finish = !MyTool.confirm("Back to menu? (Y/N): ");
                    break;
                case 2:
                    dList.searchDelivery();
                    finish = !MyTool.confirm("Back to menu? (Y/N): ");
                    break;
                case 3:
                    dList.removeDelivery();
                    finish = !MyTool.confirm("Back to menu? (Y/N): ");
                    break;
                case 4:
                    dList.updateDelivery();
                    finish = !MyTool.confirm("Back to menu? (Y/N): ");
                    break;
                case 5:
                    dList.printAllDeliveris();
                    finish = !MyTool.confirm("Back to menu? (Y/N): ");
                    break;
                case 6:
                    dList.printUnContinuingDeliveris();
                    finish = !MyTool.confirm("Back to menu? (Y/N): ");
                    break;
                case 7:
                    dList.printContinuingDeliveris();
                    finish = !MyTool.confirm("Back to menu? (Y/N): ");
                    break;
                case 8:
                    dList.writeDeliveryToFile();
                    finish = !MyTool.confirm("Back to menu? (Y/N): ");
                    break;
                case 9: 
                    logOut = MyTool.confirm("Log out? (Y/N): ");
                    if(logOut) {
                        finish = true;
                    }
                    else finish = !MyTool.confirm("Back to menu? (Y/N): ");
                    break;
                default:
                    if (dList.isChanged()) {
                        boolean res = MyTool.confirm("Data changed. Save to file? (Y/N): ");
                        if (res == true) {
                            dList.writeDeliveryToFile();
                        }
                    }
                    if(!logOut) finish = MyTool.confirm("Quit? (Y/N): ");
            }
        } while (!finish);
        if (dList.isChanged()) {
            boolean res = MyTool.confirm("Data changed. Save to file? (Y/N): ");
            if (res == true) {
                dList.writeDeliveryToFile();
            }
        }
        if(logOut)  logIn.handleLogIn();
        else System.out.println("Finish");
    }

    public static void accountManagement() throws IOException {
        System.out.println("Hello BOSS!");
        String[] options = {
            "Add new Account", "Search a Account by accName", "Remove a Account by accName", 
            "Update Account by accName", "Print all Account", "Save file", "Log out"
        };
        Menu menu = new Menu(options);
        LogIn logIn = new LogIn();
        AccountList aList = new AccountList();
        aList.iniWithFile();
        int choice = 0;
        boolean finish = true;
        boolean logOut = false;
        do {
            choice = menu.getChoice("=#=#=#=#=#=#=# Manage Account =#=#=#=#=#=#=#");
            switch (choice) {
                case 1:
                    aList.addAccount();
                    finish = !MyTool.confirm("Back to menu? (Y/N): ");
                    break;
                case 2:
                    aList.searchAccount();
                    finish = !MyTool.confirm("Back to menu? (Y/N): ");
                    break;
                case 3:
                    aList.removeAccount();
                    finish = !MyTool.confirm("Back to menu? (Y/N): ");
                    break;
                case 4:
                    aList.updateAccount();
                    finish = !MyTool.confirm("Back to menu? (Y/N): ");
                    break;
                case 5:
                    aList.printAllAccount();
                    finish = !MyTool.confirm("Back to menu? (Y/N): ");
                    break;
                case 6:
                    aList.writeAccountToFile();
                    finish = !MyTool.confirm("Back to menu? (Y/N): ");
                    break;
                case 7: 
                    logOut = MyTool.confirm("Log out? (Y/N): ");
                    if(logOut) {
                        finish = true;
                    }
                    else finish = !MyTool.confirm("Back to menu? (Y/N): ");
                    break;
                default:
                    if (aList.isChanged()) {
                        boolean res = MyTool.confirm("Data changed. Save to file? (Y/N): ");
                        if (res == true) {
                            aList.writeAccountToFile();
                        }
                    }
                    if(!logOut) finish = MyTool.confirm("Quit? (Y/N): ");
            }
        } while (!finish);
        if (aList.isChanged()) {
            boolean res = MyTool.confirm("Data changed. Save to file? (Y/N): ");
            if (res == true) {
                aList.writeAccountToFile();
            }
        }
        if(logOut)  logIn.handleLogIn();
        else System.out.println("Finish");
    }

}
