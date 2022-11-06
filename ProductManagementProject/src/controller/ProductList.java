/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author BaPhuoc
 */
import entity.Product;
import java.io.IOException;
import java.util.ArrayList;

public class ProductList extends ArrayList<Product> {

    private MenuInput menu = new MenuInput();
    private model.ProductModel pm = new model.ProductModel();

    public ProductList() {
    }

    public void showAll() {
        for (Product p : this) {
            System.out.println(p.toString());
        }
    }

    public void add() {
        String productID = "";
        do {
            productID = menu.inputString("Enter productID: ");
            if (this.checkExistId(productID, "")) {
                System.out.println("productId already exists!");
            }
        } while (this.checkExistId(productID, ""));
        String productName = "";
        do {
            productName = menu.inputString("Enter productName: ");
            if (productName.length() < 5) {
                System.out.println("productName must be at least 5 character!");
            }
            if (productName.contains(" ")) {
                System.out.println("productName cannot have spaces!");
            }
            if (this.checkExistName(productName, "")) {
                System.out.println("productName already exists!");
            }
        } while (productName.length() < 5 || productName.contains(" ") || this.checkExistName(productName, ""));
        double unitPrice = menu.inputDouble("Enter unitPrice: ", 0, 10000);
        int quantity = menu.inputInt("Enter quantity: ", 0, 1000);
        String status = "";
        do {
            status = menu.inputString("Enter status (Available or Not Available): ");
        } while (!"Available".equalsIgnoreCase(status) && !"Not Available".equalsIgnoreCase(status));
        Product p = new Product(productID, productName, unitPrice, quantity, status);
        this.add(p);
        System.out.println("Add new product successfully");
    }

    public boolean checkExistName(String productName, String except) {
        boolean check = false;
        for (Product p : this) {
            if (p.getProductName().equalsIgnoreCase(productName) && p.getProductName() != except) {
                check = true;
            }
        }
        return check;
    }

    public boolean checkExistId(String productId, String except) {
        boolean check = false;
        for (Product p : this) {
            if (p.getProductID().equalsIgnoreCase(productId) && p.getProductID() != except) {
                check = true;
            }
        }
        return check;
    }

    public void search() {
        boolean check = false;
        String productName = menu.inputString("Enter productName: ");
        for (Product p : this) {
            if (p.getProductName().toLowerCase().contains(productName.toLowerCase())) {
                System.out.println(p.toString());
                check = true;
            }
        }
        if (!check) {
            System.out.println("Have no any Product");
        }
    }

    public void update() {
        boolean check = false;
        this.showAll();
        String productID = menu.inputString("Enter productID: ");
        for (Product p : this) {
            if (p.getProductID().equalsIgnoreCase(productID)) {
                String productName = "";
                do {
                    productName = menu.updateString("Enter new productName: ", p.getProductName());
                    if (productName.length() < 5 && productName != "") {
                        System.out.println("productName must be at least 5 character!");
                    }
                    if (productName.contains(" ")) {
                        System.out.println("productName cannot have spaces!");
                    }
                    if (this.checkExistName(productName, p.getProductName())) {
                        System.out.println("productName already exists!");
                    }
                } while (productName.length() < 5 || productName.contains(" ") || this.checkExistName(productName, p.getProductName()));
                double unitPrice = menu.updateDouble("Enter new unitPrice: ", 0, 10000, p.getUnitPrice());
                int quantity = menu.updateInt("Enter new quantity: ", 0, 1000, p.getQuantity());
                String status = "";
                do {
                    status = status = menu.updateString("Enter new status (Available or Not Available): ", p.getStatus());
                } while (!"Available".equalsIgnoreCase(status) && !"Not Available".equalsIgnoreCase(status));
                p.setProductName(productName);
                p.setQuantity(quantity);
                p.setUnitPrice(unitPrice);
                p.setStatus(status);
                this.showAll();
                System.out.println("Update successfully!");
                check = true;
            }
        }
        if (!check) {
            System.out.println("Productname does not exist");
        }
    }

    public void delete() {
        boolean check = false;
        this.showAll();
        String productID = menu.inputString("Enter productID: ");
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getProductID().equalsIgnoreCase(productID)) {
                this.remove(i);
                this.showAll();
                System.out.println("Delete successfully!");
                check = true;
            }
        }
        if (!check) {
            System.out.println("ProductID does not exist");
        }
    }

    public void saveToFile() throws IOException {
        pm.writeTextToFile(this);
        System.out.println("Save products to file successfully!");
    }

    public void printListFromFile() throws IOException {
        ProductList listFromFile = new ProductList();
        listFromFile = pm.readFromFile();
        listFromFile.sort();
        listFromFile.showAll();
    }

    public void sort() {
        for (int i = 0; i < this.size(); i++) {
            for (int j = i + 1; j < this.size(); j++) {
                if (this.get(i).getQuantity() < this.get(j).getQuantity()) {
                    Product tmp = this.get(i);
                    this.set(i, this.get(j));
                    this.set(j, tmp);
                } else if (this.get(i).getQuantity() == this.get(j).getQuantity()) {
                    if (this.get(i).getUnitPrice() > this.get(j).getUnitPrice()) {
                        Product tmp = this.get(i);
                        this.set(i, this.get(j));
                        this.set(j, tmp);
                    }
                }
            }
        }
    }
}
