/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author BaPhuoc
 */
public class Account {
    public final char SEPARATOR = ',';
    private String accName;
    private String pwd;
    private String role;
    
    //constructor

    public Account(String accName, String pwd, String role) {
        this.accName = accName;
        this.pwd = pwd;
        this.role = role;
    }
    public Account(String line){
        String[] parts = line.split(""+this.SEPARATOR);
        accName = parts[0].trim();
        pwd = parts[1].trim();
        role = parts[2].trim();
    }
    public Account() {
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return accName + SEPARATOR + pwd + SEPARATOR + role;
    }
    
    
}
