package compiler;



import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Link
 */
public class ScannerInput {
    
    public ScannerInput() {
    }
    
    public void scaning(String code){
        Scanner scan = new Scanner(code);
        String[] tokens = new String[10];
        if(code==null){
            JOptionPane.showMessageDialog(null, "Error, Null value", "Warning Message", JOptionPane.ERROR_MESSAGE);
        }
        else{
            int i,found=0,error=0;
            for (i=0;scan.hasNextLine();i++)
            {
                Scanner lineScanner = new Scanner(scan.nextLine());
                tokens[i]=lineScanner.nextLine();
                if(tokens[i].equals("$")){
                    lineScanner.close();
                    break;
                }

            }
        }    
         scan.close();
         compile c=new compile();
         c.comp(tokens);
         
    }
}
