/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Scanner;

/**
 *
 * @author BaPhuoc
 */
public class MenuInput {

    public int inputInt(String Content, int min, int max) {
        boolean check = true;
        int number = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(Content);
                number = Integer.parseInt(sc.nextLine());
                check = false;
            } catch (Exception e) {
                System.out.println("Input integer number!!!");
            }
        } while (check || number > max || number < min);
        return number;
    }

    public double inputDouble(String Content, double min, double max) {
        boolean check = true;
        double number = 0.0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(Content);
                number = Double.parseDouble(sc.nextLine());
                check = false;
            } catch (Exception e) {
                System.out.println("Input double number!!!");
            }
        } while (check || number > max || number < min);
        return number;
    }

    public String inputString(String Content) {
        boolean check = true;
        String text = "";
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print(Content);
            text = sc.nextLine();
            if (text.isEmpty()) {
                System.out.println("Input text!!!");
            } else {
                check = false;
            }
        } while (check);
        return text;
    }

    public String updateString(String Content, String oldString) {
        String text = oldString;
        Scanner sc = new Scanner(System.in);
        System.out.print(Content);
        String tmp = sc.nextLine();
        if (!tmp.isEmpty()) {
            text = tmp;
        }
        return text;
    }

    public int updateInt(String Content, int min, int max, int oldData) {
        boolean check = true;
        int number = oldData;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(Content);
                String tmp = sc.nextLine();
                if (tmp.isEmpty()) {
                    check = false;
                } else {
                    number = Integer.parseInt(tmp);
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("Input integer number!!!");
            }
        } while (check || number > max || number < min);
        return number;
    }

    public double updateDouble(String Content, double min, double max, double oldData) {
        boolean check = true;
        double number = oldData;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(Content);
                String tmp = sc.nextLine();
                if (tmp.isEmpty()) {
                    check = false;
                } else {
                    number = Double.parseDouble(tmp);
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("Input double number!!!");
            }
        } while (check || number > max || number < min);
        return number;
    }
}
