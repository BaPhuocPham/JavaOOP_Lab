/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author BaPhuoc
 */
import controller.MenuInput;
import controller.ProductList;
import java.io.IOException;
import model.ProductModel;

/**
 *
 * @author BaPhuoc
 */
public class ProductView {

    private MenuInput menu = new MenuInput();
    private ProductList list = new ProductList();

    public void showMenu() throws IOException {
        ProductModel pm = new ProductModel();
        list = pm.readFromFile();
        boolean checkMenu = true;
        do {
            System.out.println("=#=#=#=#=#=#=# PRODUCT MENU #=#=#=#=#=#=#=");
            System.out.println("1. Print all list Products");
            System.out.println("2. Create a product");
            System.out.println("3. Check exists Product");
            System.out.println("4. Search Product’ information by Name");
            System.out.println("5. Update Product by ID");
            System.out.println("6. Delete Product by ID");
            System.out.println("7. Save Products to file");
            System.out.println("8. Print list from file ");
            System.out.println("Others- Quit");
            int choice = menu.inputInt("Enter a number: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
            switch (choice) {
                case 1:
                    list.showAll();
                    checkMenu = confirmMenu();
                    break;
                case 2:
                    list.add();
                    checkMenu = confirmMenu();
                    break;
                case 3:
                    String productName = menu.inputString("Enter productName: ");
                    boolean check = list.checkExistName(productName, "");
                    if (check) {
                        System.out.println("Exist Product");
                    } else {
                        System.out.println("No Product Found!");
                    }
                    checkMenu = confirmMenu();
                    break;
                case 4:
                    list.search();
                    checkMenu = confirmMenu();
                    break;
                case 5:
                    list.update();
                    checkMenu = confirmMenu();
                    break;
                case 6:
                    list.delete();
                    checkMenu = confirmMenu();
                    break;
                case 7:
                    list.saveToFile();
                    checkMenu = confirmMenu();
                    break;
                case 8:
                    list.printListFromFile();
                    checkMenu = confirmMenu();
                    break;
                default:
                    checkMenu = confirmMenu();
            }
        } while (checkMenu == true);

    }

    public boolean confirmMenu() {
        boolean result = true;
        String confirm = "";
        do {
            confirm = menu.inputString("Do you want to go back menu? Y/N  ");
        } while ("Y".equalsIgnoreCase(confirm) == false && "N".equalsIgnoreCase(confirm) == false);
        if ("N".equalsIgnoreCase(confirm)) {
            result = false;
        }
        return result;
    }
}
