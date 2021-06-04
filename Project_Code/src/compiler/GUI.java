/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.LineBorder;
import javax.swing.table.*;

/**
 *
 * @author Ahmed Mohdy
 */


public class GUI extends JFrame implements ActionListener {
   
    JPanel p;
    JButton b,b1;
    JTextField t1,t2;
    JLabel l1,l2,l3;
    JTextArea a,a1;
    public String str ;

    
    
    public GUI()
    {
        this.setTitle("OUR COMPILER");
        this.setVisible(true);
        this.setSize(1300,1000);   
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(300, 10);
        this.setResizable(false);
        
        p=new JPanel();
        p.setBackground(Color.cyan);
        this.add(p);
        p.setLayout(null);
        
        b =new JButton("Scan");
        b.setSize(200 ,60 );
        b.setLocation(530, 420);
        b.setFont(new Font("Arial",Font.BOLD,40));
        b.addActionListener(this);
//        b.setForeground(Color.yellow);
        p.add(b);

        l1=new JLabel("Enter the Code :");
        l1.setSize(250 ,100 );
        l1.setLocation(10, 200);
        l1.setFont(new Font("Arial",Font.BOLD,32));
        p.add(l1);
        
        l2=new JLabel("Hello To Our Editor");
        l2.setSize(950 ,150 );
        l2.setLocation(150, 2);
        l2.setFont(new Font("Century",Font.BOLD,90));
        p.add(l2);
        
        a =new JTextArea();
        a.setSize(800 ,230 );
        a.setLocation(300, 180);
        a.setFont(new Font("monospaced",Font.BOLD,20));
        p.add(a);
        
        a1 =new JTextArea();
        a1.setSize(1100 ,400 );
        a1.setLocation(100, 500);
        a1.setFont(new Font("monospaced",Font.BOLD,20));
        p.add(a1);
            
    }      
    
   // event e =new event();

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()==b)
        {
            str = a.getText().toString();
    //      e.even();
            
        }
    }
    
}
