/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import model.CDList;
import model.CDModel;
import tools.MyTool;
import view.CDView;

/**
 *
 * @author BaPhuoc
 */
public class CDController {
    public void showMenu() throws IOException {
        CDModel cdm = new CDModel();
        String[] options = {
            "Add CD to the catalog", "Search CD by CD title", "Display the catalog", "Update CD",
            "Delate CD", "Save account to file", "Print list CDs from file"
        };
        CDView menu = new CDView(options);
        CDList cdList = new CDList(); //CDList 
        cdList = cdm.readFromFile();
        cdList.setCdCounter(cdList.size());
        int choice = 0;
        boolean finish = false;
        boolean logOut = false;
        do {
            choice = menu.getChoice("=#=#=#=#=#=#=# Manage CD Catalog #=#=#=#=#=#=#=");
            switch (choice) {
                case 1:
                    cdList.addCD();
                    finish = !MyTool.confirm("Back to menu? (Y/N): ");
                    break;
                case 2:
                    cdList.searchCD();
                    finish = !MyTool.confirm("Back to menu? (Y/N): ");
                    break;
                case 3:
                    cdList.showAll();
                    finish = !MyTool.confirm("Back to menu? (Y/N): ");
                    break;
                case 4:
                    cdList.updateCD();
                    finish = !MyTool.confirm("Back to menu? (Y/N): ");
                    break;
                case 5:
                    cdList.removeCD();
                    finish = !MyTool.confirm("Back to menu? (Y/N): ");
                    break;
                case 6:
                    cdList.saveToFile();
                    finish = !MyTool.confirm("Back to menu? (Y/N): ");
                    break;
                case 7:
                    cdList.printListFromFile();
                    finish = !MyTool.confirm("Back to menu? (Y/N): ");
                    break;
                default:
                    if (cdList.isChanged()) {
                        boolean res = MyTool.confirm("Data changed. Save to file? (Y/N): ");
                        if (res == true) {
                            cdList.saveToFile();
                        }
                    }
                    if(!logOut) finish = MyTool.confirm("Quit? (Y/N): ");
            }
        } while (!finish);
        if (cdList.isChanged()) {
            boolean save = MyTool.confirm("Data changed. Save to file? (Y/N): ");
            if (save == true) {
                cdList.saveToFile();
            }
        }
        System.out.println("Finish");
    }
}
