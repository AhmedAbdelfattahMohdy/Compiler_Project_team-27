/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Link
 */
public class Compiler {
    
    
    public static String[] Tokens(String line,char seprator)
    {
        String[] Result=new String[10];
        String Word="";
        int ctr=0;
        for(int i=0;i<line.length();i++)
        {
            if(line.charAt(i)!=seprator&&line.charAt(i)!=' ')
            {
                Word+=line.charAt(i);
            }
            else
            {
                Result[ctr]=Word;
                ctr++;
                Word=new String();
            }
        }
        Result[ctr]=Word;
        
        return Result;
    }
    
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
    public static boolean isID(String str){
        if(str.charAt(0)>='A'&&str.charAt(0)<='Z'){
            return true;
        }
        else if(str.charAt(0)>='a'&&str.charAt(0)<='z'){
            return true;
        }
        else if (str.charAt(0)>='_'){
            return true;
        }
        return false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        GUI gui =new GUI();
        Scanner scan = new Scanner(gui.str);
        String[] tokens = new String[10];
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
         scan.close();

      language lan=new language();
      ScannerOutput out= new ScannerOutput(0,null,null,0,false);
      System.out.println("|    Line NO\t  |\t" +"Lexeme\t   |\t" +"Return Token\t|\t" +"Lexeme NO in Line\t|\t" +"matchability    |");
      System.out.println("_________________________________________________________________________________________________________________");
            for(i=0;i<tokens.length;i++)
            {
                if(tokens[i]!=null){
                    String[]line=Tokens(tokens[i],'#');
                    for(int j=0;j<line.length;j++)
                    {
                        if(line[j]==null||line[j].equals(" ")){
                            continue;
                        }
                        else if(line[j].equals("^")||line[j].equals("/0")){
                            break;
                        }
                        else{
                            out.LineNo=i+1;
                            out.Lexeme=line[j];
                            out.LexemeNOinLine=j+1;
                            for(int k=0;k<lan.lang.length;k++){
                                if(line[j].equals(lan.lang[k])){
                                    out.ReturnToken=lan.RT[k];
                                    out.matchability=true;
                                    break;
                                }
                            }
                            if(out.matchability==false){
                                if (isNumeric(line[j])){
                                    out.ReturnToken="Number";
                                    out.matchability=true;
                                }
                                else if(line[j].equals("--")){
                                    out.ReturnToken="Comment";
                                    out.matchability=true;
                                    System.out.println("|  \t"+out.LineNo+"\t  |\t"+out.Lexeme+"\t   |\t"+out.ReturnToken+"\t\t|\t\t"+out.LexemeNOinLine+"\t\t|\t"+out.matchability+"       \t|");
                                    System.out.println("_________________________________________________________________________________________________________________");
                                    System.out.println("Total NO of errors:"+error);
                                    break;
                                }
                                else if(isID(line[j])){
                                    out.ReturnToken="ID";
                                    out.matchability=true;
                                }
                                else if(!isID(line[j])){
                                    out.ReturnToken="ID";
                                    out.matchability=false;
                                    error++;
                                }
                            }
     
                        }
                        
                        System.out.println("|  \t"+out.LineNo+"\t  |\t"+out.Lexeme+"\t   |\t"+out.ReturnToken+"\t\t|\t\t"+out.LexemeNOinLine+"\t\t|\t"+out.matchability+"       \t|");
                        System.out.println("_________________________________________________________________________________________________________________");
                        System.out.println("Total NO of errors:"+error);
                        out= new ScannerOutput(0,null,null,0,false);
                    }
                    line=new String[10];
                }
                else{
                    continue;
                }
            }    
        
    }
    
    
}
