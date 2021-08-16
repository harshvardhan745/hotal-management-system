
package HotelManagementSystem;

import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class Searchroom extends JFrame implements ActionListener {
    JComboBox c1;
    JCheckBox c2;
    JButton b1,b2;
    JTable t1;
    Searchroom(){
        JLabel l1=new JLabel("Search for Room");
        l1.setFont(new Font("Tohama",Font.BOLD,16));
        l1.setBounds(180,20,230,20);
        add(l1);
        
        JLabel l2=new JLabel("Room Bed Type");
        l2.setFont(new Font("Tohama",Font.BOLD,12));
        l2.setBounds(60,70,230,20);
        add(l2);
        c1=new JComboBox(new String[] {"Single Bed","Double Bed"});
        c1.setBounds(200,70,130,20);
        c1.setBackground(Color.WHITE);
        add(c1);
        c2=new JCheckBox("Display Available only");
        c2.setBounds(500,70,150,25);
        c2.setBackground(Color.WHITE);
        add(c2); 
        
        t1=new JTable();
        t1.setBounds(10,200,765,300);

        add(t1);
        
         b1=new JButton("Submit");
         b1.setBackground(Color.BLACK);
         b1.setForeground(Color.WHITE);
         b1.setBounds(250,550,100,30);
         b1.addActionListener(this);
         add(b1);
         
         b2=new JButton("Cancel");
         b2.setBackground(Color.BLACK);
         b2.setForeground(Color.WHITE);
         b2.setBounds(500,550,100,30);
         b2.addActionListener(this);
         add(b2);
        getContentPane().setBackground(Color.lightGray);
        setLayout(null);
        setBounds(500,100,800,650);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                String str="select * from Room where bed_type='"+c1.getSelectedItem()+"'";
                String str2="select * from Room where available=''available' AND bed_type='"+c1.getSelectedItem()+"'";
                conn c=new conn();
                ResultSet rs=c.s.executeQuery(str);

                t1.setModel(DbUtils.resultSetToTableModel(rs));

            }catch(Exception e){
                System.out.println(e);

            }
        }
        else if(ae.getSource()==b2){
           new Reception().setVisible(true);
           this.setVisible(false);
        }
    }
    public static void main(String[] main){
        new Searchroom().setVisible(true);
    }
}
