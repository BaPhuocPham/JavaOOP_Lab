/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.CD;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CDList;

/**
 *
 * @author BaPhuoc
 */
public class CDModel {
    public void writeTextToFile(CDList list) throws IOException {
        String fileName = "CD.dat";
        File file = new File(fileName);
        FileWriter fw = new FileWriter(file);
        try {
            if (file.exists() == false) {
                file.createNewFile();
            }
            for (CD cd : list) {
                fw.write(cd.toString());
                fw.write("\n");
            }
        } catch (Exception e) {

        } finally {
            if (fw != null) {
                fw.close();
            }
        }
    }

    public CDList readFromFile() throws FileNotFoundException, IOException {
        CDList list = new CDList();
        String fileName = "CD.dat";
        File file = new File(fileName);
        if(file.exists()) {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            try {
                if (file.exists()) {
                    String line = "";
                    while ((line = br.readLine()) != null) {
                        String tmp[] = line.split(",");
                        String cdID = tmp[0];
                        String collectionName = tmp[1];
                        String type = tmp[2];
                        String title = tmp[3];
                        double unitPrice = Double.parseDouble(tmp[4]);
                        int publicYear = Integer.parseInt(tmp[5]);
                        list.add(new CD(cdID, collectionName, type, title, unitPrice, publicYear));
                    }
                }
                else return list;
            } catch (FileNotFoundException e) {
                Logger.getLogger(CDList.class.getName()).log(Level.SEVERE, null, e);
            } finally {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            }
        }
        
        return list;
    }
}
