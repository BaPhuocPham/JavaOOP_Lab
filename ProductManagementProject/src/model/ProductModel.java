/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.ProductList;
import entity.Product;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BaPhuoc
 */
public class ProductModel {

    public void writeTextToFile(ProductList list) throws IOException {
        String fileName = "Product.dat";
        File file = new File(fileName);
        FileWriter fw = new FileWriter(file);
        try {
            if (file.exists() == false) {
                file.createNewFile();
            }
            for (Product product : list) {
                fw.write(product.toString());
                fw.write("\n");
            }
        } catch (Exception e) {

        } finally {
            if (fw != null) {
                fw.close();
            }
        }
    }

    public ProductList readFromFile() throws FileNotFoundException, IOException {
        ProductList list = new ProductList();
        String fileName = "Product.dat";
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        try {
            if (file.exists()) {
                String line = "";
                while ((line = br.readLine()) != null) {
                    String tmp[] = line.split(", ");
                    String productID = tmp[0];
                    String productName = tmp[1];
                    double unitPrice = Double.parseDouble(tmp[2]);
                    int quantity = Integer.parseInt(tmp[3]);
                    String status = tmp[4];
                    list.add(new Product(productID, productName, unitPrice, quantity, status));
                }
            }

        } catch (FileNotFoundException e) {
            Logger.getLogger(ProductList.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (br != null) {
                br.close();
            }
            if (fr != null) {
                fr.close();
            }
        }
        return list;
    }
}
