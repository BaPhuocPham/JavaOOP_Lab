/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import entity.CD;
import model.CDModel;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import tools.MyTool;
/**
 *
 * @author BaPhuoc
 */
public class CDList extends ArrayList<CD>{
    private boolean changed = false; // check data in the list changed or not 
    private int cdCounter;
    
    public CDList() {
    }
    
    public void showAll() {
        for (CD cd : this) {
            System.out.println(cd.toString());
        }
    }
    
    
    public void addCD(){
        String cdID = "";
        if(cdCounter >= 100) {
            System.out.println("Unable to add CD!");
            System.out.println("Catalog is full!");
            return;
        }
        do
        {
            cdID = MyTool.inputString("Enter ID: ");
        }while(this.checkExistId(cdID));
        String collectionName = MyTool.inputCollectionName("Enter collection name (game/movie/music): ");
        String type = MyTool.inputType("Enter type (audio/video): ");
        String title = ""; 
        boolean checkTitle = false;
        do{
            title = MyTool.inputString("Enter new title: ");
            checkTitle = this.checkExistTitle(title, "");
            if(checkTitle) {
                System.out.println("Title exits!");
            }
        }while(checkTitle);
        Double unitPrice = MyTool.inputDouble("Enter unitPrice: ", Double.MIN_VALUE, Double.MAX_VALUE);
        int publicYear = MyTool.inputInt("Enter publishing year: ", 0, Integer.MAX_VALUE);
        CD cd = new CD(cdID, collectionName, type, title, unitPrice, publicYear);
        this.add(cd);
        changed = true;
        cdCounter ++;
        System.out.println("Add new CD successfully!");
    }
    
    public void updateCD() {
        this.showAll();
        boolean check = false;
        String cdID = MyTool.inputString("Enter CD ID update: ");
        for(CD i : this) {
            if(i.getCDId().equalsIgnoreCase(cdID)){
                String collectionName = MyTool.updateCollectionName("Enter new collection name (game/movie/music): ", i.getCollectionName());
                String type = MyTool.updateType("Enter new type (audio/video): ", i.getType());
                String title = ""; 
                boolean checkTitle = false;
                do{
                    title = MyTool.inputString("Enter new title: ");
                    checkTitle = this.checkExistTitle(title, i.getTitle());
                    if(checkTitle) {
                        System.out.println("Title exits!");
                    }
                }while(checkTitle);
                Double unitPrice = MyTool.inputDouble("Enter new unitPrice: ", Double.MIN_VALUE, Double.MAX_VALUE);
                int publicYear = MyTool.inputInt("Enter new publishing year: ", 0, Integer.MAX_VALUE);
                CD cd = new CD(cdID, collectionName, type, title, unitPrice, publicYear);
                this.add(cd);
                check = true;
                changed = true;
                System.out.println("Updated CD successfully!");
            }
        }
        if(!check) System.out.println("This ID not exists!");
    }
    
    public void removeCD() {
        this.showAll();
        boolean check = false;
        String cdID = MyTool.inputString("Enter CD ID remove: ");
        for(CD cd : this) {
            if(cd.getCDId().equalsIgnoreCase(cdID)) {
                this.remove(cd);
                check = true;
                changed = true;
                cdCounter --;
                System.out.println("Removed CD successfully!");
            }
        }
        if(!check) System.out.println("This ID not exists!");
    }
    
    public void searchCD() {
        boolean check = false;
        String title = MyTool.inputString("Enter title need to search: ").trim().toLowerCase();
        for(CD cd : this) {
            if(cd.getTitle().contains(title.toLowerCase())) {
                System.out.println(cd.toString());;
                check = true;
            }
        }
        if(!check) System.out.println("This title not exists!");
    }
    
    
    
    public boolean checkExistId(String productId) {
        boolean check = false;
        for (CD p : this) {
            if (p.getCDId().equalsIgnoreCase(productId)) {
                check = true;
            }
        }
        return check;
    }
    
    public boolean checkExistTitle(String title, String except) {
        boolean check = false;
        for (CD p : this) {
            if (p.getTitle().equalsIgnoreCase(title) && !p.getTitle().equalsIgnoreCase(except)) {
                check = true;
            }
        }
        return check;
    }
    
    public void saveToFile() throws IOException {
        CDModel cdm = new CDModel();
        cdm.writeTextToFile(this);
        changed = false;
        System.out.println("Save products to file successfully!");
    }
    
    public void printListFromFile() throws IOException {
        CDModel cdm = new CDModel();
        CDList listFromFile = new CDList();
        listFromFile = cdm.readFromFile();
        listFromFile.sort();
        listFromFile.showAll();
    }
    
    public void sort() {
        Collections.sort(this);
    }
    
    public boolean isChanged() {
        return changed;
    }

    public int getCdCounter() {
        return cdCounter;
    }

    public void setCdCounter(int cdCounter) {
        this.cdCounter = cdCounter;
    }
    
}
