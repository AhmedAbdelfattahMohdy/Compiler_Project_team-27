package compiler;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Link

        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.Border;


/**
 *
 * @author Ahmed Mohdy
 */


public class gui implements ActionListener {
   
    JPanel p;
    JButton b,b1;
    JTextField t1,t2;
    JLabel l1,l2,l3;
    JTextArea a,a1;
    public String str ;

    
    
    public gui()
    {
        Border border = BorderFactory.createLineBorder(Color.GREEN, 4);
        Border bor = BorderFactory.createLineBorder(Color.BLACK, 4);
        JFrame frame=new JFrame();
        frame.setTitle("OUR COMPILER");
        frame.setVisible(true);
        frame.setSize(1000,700);   
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(450, 150);
        frame.setResizable(false);
        
        p=new JPanel();
        p.setBackground(Color.LIGHT_GRAY);
        frame.add(p);
        p.setLayout(null);
        
        b =new JButton("Scan");
        b.setSize(200 ,60 );
        b.setLocation(400, 570);
        b.setFont(new Font("Algerian",Font.BOLD,40));
        b.setBackground(Color.CYAN);
        b.setBorder(bor);
        b.addActionListener(this);
        p.add(b);

        l1=new JLabel("Code :");
        l1.setSize(150 ,100 );
        l1.setLocation(15, 150);
        l1.setFont(new Font("Arial",Font.BOLD,32));
        p.add(l1);
        
        l2=new JLabel("Compiler");
        l2.setSize(280 ,90 );
        l2.setLocation(360, 10);
        l2.setFont(new Font("Century",Font.ITALIC,60));
        l2.setBorder(bor);
        p.add(l2);
        
        a =new JTextArea();
        a.setSize(800 ,370 );
        a.setLocation(130, 150);
        a.setBorder(border);
        a.setFont(new Font("tahoma",Font.TYPE1_FONT,20));
        p.add(a);
            
    }      
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()==b)
        {
            str = a.getText().toString();
            ScannerInput scan=new ScannerInput();
            scan.scaning(str);
            
        }
    }
    
}

