/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdhouseprogram;

import controller.CDController;
import java.io.IOException;

/**
 *
 * @author BaPhuoc
 */
public class CDHouseProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        CDController menu = new CDController();
        menu.showMenu();
    }
}
