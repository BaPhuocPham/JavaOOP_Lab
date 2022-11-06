/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productmanagementproject;

import java.io.IOException;
import view.ProductView;

/**
 *
 * @author BaPhuoc
 */
public class ProductManagementProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ProductView pv = new ProductView();
        pv.showMenu();
    }

}
