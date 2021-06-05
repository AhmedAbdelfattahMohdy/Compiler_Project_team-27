package compiler;


import javax.swing.JOptionPane;
import javax.swing.JTextArea;


/**
 *
 * @author Link
 */
public class compile {

    public compile() {
    }
    
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
    
    public void comp(String[] tokens){
      int i,error=0;
      language lan=new language();
      ScannerOutput out= new ScannerOutput(0,null,null,0,false);
      JTextArea area = new JTextArea();
      area.setText("   |\tLine NO\t  |\t" +"Lexeme\t|" +"        Return Token\t|" +"    Lexeme NO in Line                   |   " +"         matchability                       |\n");
      area.setText(area.getText()+"   ____________________________________________________________________________________________________________________________   \n");
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
                                    area.setText(area.getText()+"   |  \t"+out.LineNo+"\t  |\t"+out.Lexeme+"\t|\t"+out.ReturnToken+"\t|\t"+out.LexemeNOinLine+"\t|\t"+out.matchability+"       \t|   \n");
                                    area.setText(area.getText()+"   ____________________________________________________________________________________________________________________________   \n");
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
                        
                        area.setText(area.getText()+"   |  \t"+out.LineNo+"\t  |\t"+out.Lexeme+"\t|\t"+out.ReturnToken+"\t|\t"+out.LexemeNOinLine+"\t|\t"+out.matchability+"       \t|   \n");
                        area.setText(area.getText()+"   _____________________________________________________________________________________________________________________________   \n");
                        
                        out= new ScannerOutput(0,null,null,0,false);
                    }
                    
                    line=new String[10];
                }
                else{
                    continue;
                }
            }
            area.setText(area.getText()+"   Total NO of errors: "+error+"\n");
            JOptionPane.showConfirmDialog(null,area,"",JOptionPane.OK_CANCEL_OPTION);
    }
}
