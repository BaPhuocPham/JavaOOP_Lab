package model;

import model.LogIn;
import entity.Delivery;
import entity.Delivery;
import java.io.IOException;
import java.util.AbstractList;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import tools.MyTool;

public class DeliveryList extends ArrayList<Delivery> {

    Scanner sc = new Scanner(System.in);
    LogIn logInObj = null;
    private static final String PHONEPATTERN = "\\d{9}|\\d{11}";
    private String dataFile = "";
    boolean changed = false; // whether data in the list changed or not 


    public DeliveryList() {
        super();
    }


    private void loadDeliveryFromFile() throws IOException {
        List<String> readDelivery = MyTool.readLinesFromFile(dataFile);
        for (String element : readDelivery) {
            Delivery newDelivery = new Delivery(element);
            this.add(newDelivery);
        }
    }

    public void iniWithFile() throws IOException {
        Config cR = new Config();
        dataFile = cR.getDeliveryFile();
        loadDeliveryFromFile();
    }

    public DeliveryList getContinuingList() {
        DeliveryList result = new DeliveryList();
        for (Delivery thi : this) {
            if (thi.isContinuing() == true) {
                result.add(thi);
            }
        }
        return result;
    }

    public DeliveryList getUnContinuingList() {
        DeliveryList result = new DeliveryList();
        for (Delivery thi : this) {
            if (thi.isContinuing() == false) {
                result.add(thi);
            }
        }
        return result;
    }

    private int searchDelivery(String ID) {
        int count = this.size();
        for (int i = 0; i < count; i++) {
            if (this.get(i).getID().endsWith(ID)) {
                return i;
            }
        }
        return -1;
    }

    public void searchDelivery() {
        System.out.println("Enter ID to find Delivery: ");
        String IdDelivery = sc.nextLine().toUpperCase();
        int pos = searchDelivery(IdDelivery);
        if (pos < 0) {
            System.out.println("Not Found");
        } else {
            System.out.println("Position is: " + pos);
            System.out.println(this.get(pos).toString());
        }
    }

    public void addDelivery() {
        String ID;
        String name; // delivery's name
        String addr; // delivery's address
        String phone; // 9 or 11 digits
        String type; //type of delivery
        boolean continuing;
        int pos;
        do {
            ID = MyTool.inputStringWithValidate("ID of new delivery: ", Delivery.ID_FORMAT, "Format: Dxxx with x is a digit");
            ID = ID.toUpperCase();
            pos = searchDelivery(ID);
            if (pos >= 0) {
                System.out.println("ID is duplicated");
            }
        } while (pos >= 0);
        name = MyTool.inputString("Name of new delivery: ");
        addr = MyTool.inputString("Address of new delivery: ");
        phone = MyTool.inputStringWithValidate("Phone number: ", Delivery.PHONE_FORMAT, "Format: 9 or 11 digits");
        continuing = true; // default value for new delivery
        type = MyTool.inputTypeDelivery("Type of product (fast/normal): ");
        Delivery d = new Delivery(ID, name, addr, phone, continuing, type);
        this.add(d);
        System.out.println("New Delivery has been added");
        changed = true;
    }

    public void removeDelivery() {
        int pos;
        printAllDeliveris();
        System.out.println("Enter ID to remove Delivery: ");
        String IdDelivery = sc.nextLine().toUpperCase();
        pos = searchDelivery(IdDelivery);
        if (pos < 0) {
            System.out.println("Not Found");
        } else {
            this.remove(pos);
            System.out.println("Removed");
            changed = true;
        }
    }

    public void updateDelivery() {
        String ID = MyTool.inputString("Delivery's ID needs updating: ").toUpperCase();
        int pos = searchDelivery(ID);
        if (pos < 0) {
            System.out.println("Delivery " + ID + " Not Found!");
        } else {
            Delivery d = this.get(pos);
            String newName = ""; // update name
            newName = MyTool.inputString("Enter new name: ").trim();
            if (!newName.isEmpty()) {
                d.setName(newName);
                changed = true;
            }
            String addr = ""; // update address
            addr = MyTool.inputString("Enter new address: ").trim();
            if (!addr.isEmpty()) {
                d.setAddr(addr);
                changed = true;
            }
            String phone = ""; // update phone
            phone = MyTool.inputStringWithValidate("Enter new phone number: ", Delivery.PHONE_FORMAT, "Format: 9 or 11 digits").trim();
            if (!phone.isEmpty()) {
                d.setPhone(phone);
                changed = true;
            }
            String type = ""; // update type
            type = MyTool.inputTypeDelivery("Enter new type (fast/normal): ").trim();
            if (!type.isEmpty()) {
                d.setType(type);
                changed = true;
            }
            System.out.println("Updated!");
        }

    }

    public void printAllDeliveris() {
        if (this.isEmpty()) {
            System.out.println("Empty List!");
        } else {
            for (Delivery thi : this) {
                System.out.println(thi.toString());
            }
        }
    }

    public void printContinuingDeliveris() {
        this.getContinuingList().printAllDeliveris();
    }

    public void printUnContinuingDeliveris() {
        this.getUnContinuingList().printAllDeliveris();
    }

    public void writeDeliveryToFile() throws IOException {
        if (changed) {
            MyTool.writeFile(dataFile, this);
            changed = false;
            System.out.println("Saved!");
        }
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

}
