package compiler;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Link
 */
public class ScannerOutput {
    public int LineNo;
    public String Lexeme;
    public String ReturnToken;
    public int LexemeNOinLine;
    public boolean matchability;

    public ScannerOutput(int LineNo, String Lexeme, String ReturnToken, int LexemeNOinLine, boolean matchability) {
        this.LineNo = LineNo;
        this.Lexeme = Lexeme;
        this.ReturnToken = ReturnToken;
        this.LexemeNOinLine = LexemeNOinLine;
        this.matchability = matchability;
    }
    
    
}
