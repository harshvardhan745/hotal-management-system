package HotelManagementSystem;

import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Room extends JFrame implements ActionListener {
    JTable t1;
    JButton b1,b2;
    Room(){
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("HotelManagementSystem/icon/eight.jpg"));
        Image i2=i1.getImage().getScaledInstance(380, 400, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel icon=new JLabel(i3);
        icon.setBounds(420,30, 360, 400);
        add(icon);

        JLabel l1=new JLabel("Room Number");
        l1.setBounds(12,2,50,50);
        add(l1);

        JLabel l2=new JLabel("Availability");
        l2.setBounds(100,2,50,50);
        add(l2);

        JLabel l3=new JLabel("Status");
        l3.setBounds(200,2,50,50);
        add(l3);

        JLabel l4=new JLabel("Price");
        l4.setBounds(270,2,50,50);
        add(l4);

        JLabel l5=new JLabel("Bed Type");
        l5.setBounds(340,2,50,50);
        add(l5);
        t1=new JTable();
        t1.setBounds(15,50,400,400);
        add(t1);
        
        b1=new JButton("Load Data");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setBounds(100,450,100,25);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("Back");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setBounds(250,450,100,25);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(350,200,800,550);
        setVisible(true);
        
    }
        public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
               conn c= new conn();
                String str="select * from room";
                ResultSet rs=c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                
            }
        }
        else if(ae.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args){

        new Room().setVisible(true);
    }
}
