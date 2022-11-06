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
public class CD implements Comparable<Object>{
    
    private String collectionName;
    private String type;
    private String title;
    private double unitPrice;
    private String cdID;
    private int publicYear;

    public CD(String cdID, String collectionName, String type, String title, double unitPrice, int publicYear) {
        this.collectionName = collectionName;
        this.type = type;
        this.title = title;
        this.unitPrice = unitPrice;
        this.cdID = cdID;
        this.publicYear = publicYear;
    }

    public CD() {
        super();
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getCDId() {
        return cdID;
    }

    public void setCDId(String CDId) {
        this.cdID = CDId;
    }

    public int getPublicYear() {
        return publicYear;
    }

    public void setPublicYear(int publicYear) {
        this.publicYear = publicYear;
    }

    @Override
    public String toString() {
        return cdID + "," + collectionName + "," + type + "," + title + "," + unitPrice + "," + publicYear;
    }

    @Override
    public int compareTo(Object o) {
        CD cd= (CD) o;
        return this.title.compareToIgnoreCase(cd.getTitle());
    }
    
}
