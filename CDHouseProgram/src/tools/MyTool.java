/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.Scanner;

/**
 *
 * @author BaPhuoc
 */
public class MyTool {
    
    public static String inputCollectionName(String Content) {
        boolean check = true;
        String text = "";
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print(Content);
            text = sc.nextLine().toLowerCase();
            if (text.isEmpty()) {
                System.out.println("Chose one of three options!");
            } else {
                if(text.equalsIgnoreCase("game")|| text.equalsIgnoreCase("movie") || text.equalsIgnoreCase("music")) {
                    check = false;
                }
                else {
                    System.out.println("Chose one of three options!");
                }
            }
        } while (check);
        return text;
    }
    
    public static String updateCollectionName(String Content, String oldcollectionName) {
        boolean check = true;
        String text = "";
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print(Content);
            text = sc.nextLine().toLowerCase();
            if (text.isEmpty()) {
                text = oldcollectionName;
                check = false;
            } else {
                if(text.equalsIgnoreCase("game")|| text.equalsIgnoreCase("movie") || text.equalsIgnoreCase("music")) {
                    check = false;
                }
                else {
                    System.out.println("Chose one of three options!");
                }
            }
        } while (check);
        return text;
    }
    
    public static String inputType(String Content) {
        boolean check = true;
        String text = "";
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print(Content);
            text = sc.nextLine().toLowerCase();
            if (text.isEmpty()) {
                System.out.println("Chose one of two options!");
            } else {
                if(text.equalsIgnoreCase("audio")|| text.equalsIgnoreCase("video")) {
                    check = false;
                }
                else {
                    System.out.println("Chose one of two options!");
                }
            }
        } while (check);
        return text;
    }
    
    public static String updateType(String Content, String oldType) {
        boolean check = true;
        String text = "";
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print(Content);
            text = sc.nextLine().toLowerCase();
            if (text.isEmpty()) {
                text = oldType;
                check = false;
            } else {
                if(text.equalsIgnoreCase("audio")|| text.equalsIgnoreCase("video")) {
                    check = false;
                }
                else {
                    System.out.println("Chose one of two options!");
                }
            }
        } while (check);
        return text;
    }
    
    public static int inputInt(String Content, int min, int max) {
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

    public static double inputDouble(String Content, double min, double max) {
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

    public static String inputString(String Content) {
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

    public static String updateString(String Content, String oldString) {
        String text = oldString;
        Scanner sc = new Scanner(System.in);
        System.out.print(Content);
        String tmp = sc.nextLine();
        if (!tmp.isEmpty()) {
            text = tmp;
        }
        return text;
    }

    public static int updateInt(String Content, int min, int max, int oldData) {
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

    public static double updateDouble(String Content, double min, double max, double oldData) {
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
    
    public static boolean confirm(String message) {
        boolean result = true;
        String confirm = "";
        do {
            confirm = inputString(message);
        } while ("Y".equalsIgnoreCase(confirm) == false && "N".equalsIgnoreCase(confirm) == false);
        if ("N".equalsIgnoreCase(confirm)) {
            result = false;
        }
        return result;
    }
}
