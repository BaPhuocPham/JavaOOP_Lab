package view;
import java.util.ArrayList;
import java.util.Scanner;
import tools.MyTool;

public class Menu extends ArrayList<String>{
    Scanner sc = new Scanner(System.in);
        public Menu() {
            super();
        }

        public Menu(String[] items) {
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
            int choice;
                choice = MyTool.inputInt("Enter Choice: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                return choice;       
        }
}
