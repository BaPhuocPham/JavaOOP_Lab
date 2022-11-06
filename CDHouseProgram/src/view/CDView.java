/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import tools.MyTool;

/**
 *
 * @author BaPhuoc
 */
public class CDView extends ArrayList<String> {
    Scanner sc = new Scanner(System.in);
        public CDView() {
        }

        public CDView(String[] items) {
            super();
            for (String item : items) {
                this.add(item);
            }
        }
    
        public int getChoice(String message){
            System.out.println(message);
            int i = 1;
            for (String thi : this) {
                System.out.println(i +"/ "+ thi);
                i++;
            }
            int choice = MyTool.inputInt("Enter a number: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                return choice;       
        }
}
