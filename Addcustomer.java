package HotelManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Addcustomer extends JFrame implements ActionListener{
    JTextField t1,t2,t3,t4,t5;
    JComboBox c1;
    Choice c2;
    JButton b1,b2;
    JRadioButton r1,r2;
    Addcustomer(){
        JLabel l1=new JLabel("New Customer Form");
        l1.setBounds(80,10,180,20);
        l1.setFont(new Font("Tohama",Font.BOLD,16));
        add(l1);
        
        JLabel l2=new JLabel("Id");
        l2.setBounds(40,50,110,20);
        l2.setFont(new Font("Tohama",Font.PLAIN,12));
        add(l2);
        c1=new JComboBox(new String[] {" ","Passport","Voter ID","Driving Licence","Aadhar"});
        c1.setBounds(180,50,150,20);
        c1.setBackground(Color.WHITE);
        add(c1);
        
        JLabel l3=new JLabel("Number");
        l3.setBounds(40,80,110,20);
        l3.setFont(new Font("Tohama",Font.PLAIN,12));
        add(l3);
        t1=new JTextField();
        t1.setBounds(180,80,150,20);
        add(t1);
        
        JLabel l4=new JLabel("Name");
        l4.setBounds(40,110,110,20);
        l4.setFont(new Font("Tohama",Font.PLAIN,12));
        add(l4);
        t2=new JTextField();
        t2.setBounds(180,110,150,20);
        add(t2);
        
        JLabel l5=new JLabel("Gender");
        l5.setBounds(40,140,110,20);
        l5.setFont(new Font("Tohama",Font.PLAIN,12));
        add(l5);
        r1=new JRadioButton("Male");
        r1.setBounds(180, 140, 70 , 20);
        r1.setBackground(Color.WHITE);
        add(r1);
        r2=new JRadioButton("Female");
        r2.setBounds(250, 140, 70 , 20);
        r2.setBackground(Color.WHITE);
        add(r2);
        
        JLabel l6=new JLabel("Country");
        l6.setBounds(40,170,110,20);
        l6.setFont(new Font("Tohama",Font.PLAIN,12));
        add(l6);
        t3=new JTextField();
        t3.setBounds(180,170,150,20);
        add(t3);
        
        JLabel l7=new JLabel("Allocated Room");
        l7.setBounds(40,200,110,20);
        l7.setFont(new Font("Tohama",Font.PLAIN,12));
        add(l7);
        c2=new Choice();
        try{
            conn c= new conn();
            String str="select * from room";
            ResultSet rs=c.s.executeQuery(str);
            while(rs.next()){
                c2.add(rs.getString("room_number"));
            }
        }catch(Exception e){ }
        c2.setBounds(180,200,150,25);
        add(c2);
        JLabel l8=new JLabel("Checked In");
        l8.setBounds(40,230,110,20);
        l8.setFont(new Font("Tohama",Font.PLAIN,12));
        add(l8);
        t4=new JTextField();
        t4.setBounds(180,230,150,20);
        add(t4);
        
        JLabel l9=new JLabel("Amount Deposited");
        l9.setBounds(40,260,110,20);
        l9.setFont(new Font("Tohama",Font.PLAIN,12));
        add(l9);
        t5=new JTextField();
        t5.setBounds(180,260,150,20);
        add(t5);
        
        b1=new JButton("Add Customer");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setBounds(70,300,150,25);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("Back");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setBounds(230,300,100,25);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("HotelManagementSystem/icon/fifth.png"));
        Image i2=i1.getImage().getScaledInstance(385, 385, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l10=new JLabel(i3);
        l10.setBounds(350, 5, 350, 385);
        add(l10);
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(350,130,720,400);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String id = (String) c1.getSelectedItem();
            String number = t1.getText();
            String name = t2.getText();
            String gender = null;
            if (r1.isSelected()) {
                gender = "Male";
            } else if (r2.isSelected()) {
                gender = "Female";
            }
            String country = t3.getText();
            String room = c2.getSelectedItem();
            String status = t4.getText();
            String deposit = t5.getText();
            String str = "insert into customer values('" + id + "','" + number + "','" + name + "','" + gender + "','" + country + "','" + room + "','" + status + "','" + deposit + "')";

            try {
                conn c = new conn();
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "New Customer Added");
                new Reception().setVisible(true);
                this.setVisible(false);

            } catch (Exception e) {
            }
            }else if (ae.getSource() == b2) {
                new Reception().setVisible(true);
                this.setVisible(false);
            }
        }

            public static void main (String[]args){

                new Addcustomer().setVisible(true);
            }
        }

