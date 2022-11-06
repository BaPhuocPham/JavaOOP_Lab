
package model;
import entity.Account;
import java.io.IOException;
import tools.MyTool;
import java.util.List;
public class AccountChecker {
    private String accFile;
    private String SEPARATOR=",";
    public AccountChecker() throws IOException{
        setUpAccFile();
    }
    private void setUpAccFile() throws IOException{
        Config cF = new Config();
        //        get location acc.txt
        accFile = cF.getAccountFile();
    }
    //check validity on an account
    public boolean check(Account acc) throws IOException{
        List<String> lines = MyTool.readLinesFromFile(accFile);
        //traverse each line for checking
        for (String line : lines) {
            String[] parts = line.split(SEPARATOR);
            if(parts.length<3) return false;
            if(parts[0].equalsIgnoreCase(acc.getAccName()) &&
                    parts[1].equals(acc.getPwd())&&
                    parts[2].equalsIgnoreCase(acc.getRole()))
                return true;
        }
        return false;
    }
}
