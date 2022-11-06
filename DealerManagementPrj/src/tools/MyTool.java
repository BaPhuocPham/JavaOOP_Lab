/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author BaPhuoc
 */
public class MyTool {
    public static boolean parseBool(String boolStr){
        char c = boolStr.trim().toUpperCase().charAt(0);
        return (c == 'T');
    }
    
    //valid String
    public static boolean validStr(String str, String regEx) {
        return str.matches(regEx);
    }
    
    //valid password
    public static boolean validPassword(String str, int minLen) {
        if (str.length() < minLen) {
            return false;
        }
        return str.matches(".*[a-zA-Z]+.*") && str.matches(".*[\\d]+.*") && str.matches(".*[\\W]+.*");
    } 
    
    public static List<String> readLinesFromFile(String filename) throws IOException{
        FileReader f = new FileReader(filename);
        BufferedReader bf = new BufferedReader(f);
        List<String> list = new ArrayList<>();
        while(bf.ready()){
           String s = bf.readLine();
           list.add(s);
        }
        f.close();
        bf.close();
        return list;
    } 
    public static void writeFile(String filename,List list) throws IOException{
          FileWriter writer = new FileWriter(filename); 
        String str = "";
         for (int i = 0; i < list.size(); i++) {
            str += list.get(i) + "\n";
          }
        writer.write(str);
        writer.close();
    }
    public static String inputStringWithValidate(String message, String pattern, String invalidMessage) {
        String input = "";
        boolean valid;
        do {            
            input = inputString(message);
            valid = validStr(input, pattern);
            if(!valid) {
                System.out.println("Invalid - " + invalidMessage);
            }
        } while (!valid);
        return input;
    }
    public static String inputPassword(String message, String invalidMessage) {
        String input = "";
        boolean valid;
        do {            
            Scanner sc = new Scanner(System.in);
            System.out.print(message);
            input = sc.nextLine().trim();
            valid = validPassword(input, 6);
            if(!valid) {
                System.out.println("Invalid - " + invalidMessage);
            }
        } while (!valid);
        return input;
    }
    public static int inputInt(String message, int min, int max) {
        boolean check = true;
        int number = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(message);
                number = Integer.parseInt(sc.nextLine());
                check = false;
            } catch (Exception e) {
                System.out.println("Enter integer number!!!");
            }
        } while (check || number > max || number < min);
        return number;
    }

    public double inputDouble(String message, double min, double max) {
        boolean check = true;
        double number = 0.0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(message);
                number = Double.parseDouble(sc.nextLine());
                check = false;
            } catch (Exception e) {
                System.out.println("Input double number!!!");
            }
        } while (check || number > max || number < min);
        return number;
    }

    public static String inputString(String message) {
        boolean check = true;
        String text = "";
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print(message);
            text = sc.nextLine().trim();
            if (text.isEmpty()) {
                System.out.println("Input text!!!");
            } else {
                check = false;
            }
        } while (check);
        return text;
    }
    public static String inputAccount(String message, String pattern) {
        boolean check = true;
        String acc = "";
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print(message);
            acc = sc.nextLine().trim();
            boolean valid = validStr(acc, pattern);
            if (acc.isEmpty() || acc.contains(" ")) {
                System.out.println("Invalid account - Format: Exxx with x is a digit");
            } else {
                check = false;
            }
        } while (check);
        return acc;
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
    
    public static String inputRole(String message) {
        String str = "";
        boolean cont = true;
        Scanner sc = new Scanner(System.in);
        String acc1 = "Acc-1";
        String acc2 = "Acc-2";
        String boss = "BOSS";
        do {
            try {
                System.out.print(message);
                str = sc.nextLine().toUpperCase();
                if (!str.isEmpty()) {
                    if (str.equalsIgnoreCase(acc1) || str.equalsIgnoreCase(acc2) || str.equalsIgnoreCase(boss)) {
                        cont = false;
                    } else {
                        cont = true;
                    }
                }
            } catch (Exception e) {
                System.out.print("Choose one of three options to input");
            }
        } while (cont);
        return str;
    }
    public static String inputTypeDelivery(String message) {
        String str = "";
        boolean cont = true;
        String normal = "normal";
        String fast = "fast";
        do {
            try {
                str = inputString(message).toLowerCase();
                if (!str.isEmpty()) {
                    if (str.equalsIgnoreCase(normal) || str.equalsIgnoreCase(fast)) {
                        cont = false;
                    } else {
                        cont = true;
                    }
                }
            } catch (Exception e) {
                System.out.print("Choose one of two options to input");
            }
        } while (cont);
        return str;
    } 
}
