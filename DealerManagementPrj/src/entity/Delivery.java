/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import static entity.Dealer.SEPARATOR;
import tools.MyTool;

/**
 *
 * @author BaPhuoc
 */
public class Delivery {
    public static final char SEPARATOR = ',';
    public static final String ID_FORMAT = "D\\d{3}";
    public static final String PHONE_FORMAT = "\\d{9}|\\d{11}";
    private String ID;// template D000
    private String name;// delivery's name
    private String addr;// delivery's address
    private String phone;// 9 or 11 digits
    private boolean continuing;// whether this dealer still cooperates or not
    private String type; // type of delivery service

    public String getID() {
        return ID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isContinuing() {
        return continuing;
    }

    public void setContinuing(boolean continuing) {
        this.continuing = continuing;
    }

    @Override
    public String toString() {
        return ID + SEPARATOR + name + SEPARATOR + addr + SEPARATOR + phone + SEPARATOR + continuing + SEPARATOR + type;
    }
    
    public Delivery(String ID, String name, String addr, String phone, boolean continuing, String type) {
        this.ID = ID;
        this.name = name;
        this.addr = addr;
        this.phone = phone;
        this.continuing = continuing;
        this.type = type;
    }
    
    public Delivery(String line){
        String [] parts = line.split("" + this.SEPARATOR);
        ID = parts[0].trim();// delivery ID
        name = parts[1].trim();//delivery's name
        addr = parts[2].trim();//delivery's address 
        phone = parts[3].trim();// 9 or 11 digits
        continuing = MyTool.parseBool(parts[4]);
        type = parts[5].trim();
    }
    
//    @Override
//    public int compareTo(Delivery o) {
//       return o.ID.compareTo(ID);
//    } 
}
