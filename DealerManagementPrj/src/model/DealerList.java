package model;

import model.LogIn;
import entity.Dealer;
import java.io.IOException;
import java.util.AbstractList;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import tools.MyTool;

public class DealerList extends ArrayList<Dealer> {

    Scanner sc = new Scanner(System.in);
    LogIn logInObj = null;
    public static final String ID_FORMAT = "D\\d{3}";
    public static final String PHONE_FORMAT = "\\d{9}|\\d{11}";
    private static final String PHONEPATTERN = "\\d{9}|\\d{11}";
    private String dataFile = "";
    boolean changed = false; // whether data in the list changed or not 

    public DealerList() {
        super();
    }

    private void loadDealerFromFile() throws IOException {
        List<String> readDealer = MyTool.readLinesFromFile(dataFile);
        for (String element : readDealer) {
            Dealer newDealer = new Dealer(element);
            this.add(newDealer);
        }
    }

    public void iniWithFile() throws IOException {
        Config cR = new Config();
        dataFile = cR.getDealerFile();
        loadDealerFromFile();
    }

    public DealerList getContinuingList() {
        DealerList result = new DealerList();
        for (Dealer thi : this) {
            if (thi.isContinuing() == true) {
                result.add(thi);
            }
        }
        return result;
    }

    public DealerList getUnContinuingList() {
        DealerList result = new DealerList();
        for (Dealer thi : this) {
            if (thi.isContinuing() == false) {
                result.add(thi);
            }
        }
        return result;
    }

    private int searchDealer(String ID) {
        int count = this.size();
        for (int i = 0; i < count; i++) {
            if (this.get(i).getID().equalsIgnoreCase(ID)) {
                return i;
            }
        }
        return -1;
    }

    public void searchDealer() {
        System.out.println("Enter ID to find Dealer: ");
        String IdDealer = sc.nextLine().toUpperCase();
        int pos = searchDealer(IdDealer);
        if (pos < 0) {
            System.out.println("Not Found");
        } else {
            System.out.println("Position is: " + pos);
            System.out.println(this.get(pos).toString());
        }
    }

    public void addDealer() {
        String ID;
        String name; // dealer's name
        String addr; // dealer's address
        String phone; // 9 or 11 digits
        boolean continuing;
        int pos;
        do {
            ID = MyTool.inputStringWithValidate("ID of new dealer: ", Dealer.ID_FORMAT, "Format: Dxxx with x is a digit").toUpperCase();
            pos = searchDealer(ID);
            if (pos >= 0) {
                System.out.println("ID is duplicated");
            }
        } while (pos >= 0);
        name = MyTool.inputString("Name of new dealer: ");
        addr = MyTool.inputString("Address of new dealer: ");
        phone = MyTool.inputStringWithValidate("Phone number: ", Dealer.PHONE_FORMAT, "Format: 9 or 11 digits");
        continuing = true; // default value for new dealer
        Dealer d = new Dealer(ID, name, addr, phone, continuing);
        this.add(d);
        System.out.println("New dealer has been added");
        changed = true;
    }

    public void removeDealer() {
        int pos;
        printAllDealers();
        String ID = MyTool.inputString("Dealer's ID needs remove: ").toUpperCase();
        pos = searchDealer(ID);
        if (pos < 0) {
            System.out.println("Not Found");
        } else {
            this.remove(pos);
            System.out.println("Removed");
            changed = true;
        }
    }

    public void updateDealer() {
        System.out.println("Dealer's ID needs updating: ");
        String ID = MyTool.inputString("Dealer's ID needs update: ").toUpperCase();
        int pos = searchDealer(ID);
        if (pos < 0) {
            System.out.println("Dealer: " + ID + " Not Found!");
        } else {
            Dealer d = this.get(pos);
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
            phone = MyTool.inputStringWithValidate("Enter new phone number: ", Dealer.PHONE_FORMAT, "Format: 9 or 11 digits").trim();
            if (!phone.isEmpty()) {
                d.setPhone(phone);
                changed = true;
            }
            String continuing = ""; // update continuing
            continuing = MyTool.inputString("Enter new continuing: ").trim();
            if (!continuing.isEmpty()) {
                d.setContinuing(Boolean.parseBoolean(continuing));
                changed = true;
            }
            System.out.println("Updated!");
        }

    }

    public void printAllDealers() {
        if (this.isEmpty()) {
            System.out.println("Empty List!");
        } else {
            for (Dealer thi : this) {
                System.out.println(thi.toString());
            }
        }
    }

    public void printContinuingDealers() {
        this.getContinuingList().printAllDealers();
    }

    public void printUnContinuingDealers() {
        this.getUnContinuingList().printAllDealers();
    }

    public void writeDealerToFile() throws IOException {
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
