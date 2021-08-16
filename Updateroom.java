
package HotelManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class Updateroom extends JFrame implements ActionListener{
    Choice c1;
    JTextField t1,t2,t3;
    JButton b1,b2,b3;
    Updateroom(){
        JLabel l1=new JLabel("Update Room Status");
        l1.setFont(new Font("Tohama",Font.BOLD,16));
        l1.setBounds(100,20,230,20);
        add(l1);
        JLabel l2=new JLabel("Guest ID");
        l2.setFont(new Font("Tohama",Font.PLAIN,12));
        l2.setBounds(30,70,130,20);
        add(l2);
        c1=new Choice();
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            while(rs.next()){
                c1.add(rs.getString("number"));
            }
            
        }catch(Exception e){}
        c1.setBounds(170,70,130,20);
        add(c1);
        JLabel l3=new JLabel("Room No.");
        l3.setFont(new Font("Tohama",Font.PLAIN,12));
        l3.setBounds(30,100,130,20);
        add(l3);
        t1=new JTextField();
        t1.setBounds(170,100,130,20);
        add(t1);
        JLabel l4=new JLabel("Availability");
        l4.setFont(new Font("Tohama",Font.PLAIN,12));
        l4.setBounds(30,130,130,20);
        add(l4);
        t2=new JTextField();
        t2.setBounds(170,130,130,20);
        add(t2);
        JLabel l5=new JLabel("Clean Status");
        l5.setFont(new Font("Tohama",Font.PLAIN,12));
        l5.setBounds(30,160,130,20);
        add(l5);
        t3=new JTextField();
        t3.setBounds(170,160,130,20);
        add(t3);
        b1=new JButton("Check");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(40,220,70,30);
        b1.addActionListener(this);
        add(b1);
        b2=new JButton("Update");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(130,220,80,30);
        b2.addActionListener(this);
        add(b2);
        b3=new JButton("Back");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(230,220,70,30);
        b3.addActionListener(this);
        add(b3);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("HotelManagementSystem/icon/seventh.jpg"));
        Image i2=i1.getImage().getScaledInstance(385, 385, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l6=new JLabel(i3);
        l6.setBounds(350, 5, 350, 385);
        add(l6);
        
        setLayout(null);
        setBounds(400,150,800,350);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
                String room=null;
                String s1=c1.getSelectedItem();
                conn c=new conn();
                try{
                 ResultSet rs=c.s.executeQuery("select * from customer where number='"+s1+"'");

                 while(rs.next()){
                     t1.setText(rs.getString("room"));
                     room=rs.getString("room");
                 }
                    ResultSet rs2=c.s.executeQuery("select * from room where room_number='"+room+"'");
                 while(rs2.next()){
                     t2.setText(rs2.getString("available"));
                     t3.setText(rs2.getString("status"));

                 }
                
            }catch(Exception e){
                
            }
        }
        else if(ae.getSource()==b2){
            try{
                conn c=new conn();
                String room=t1.getText();
                String available=t2.getText();
                String status=t3.getText();
                String str="update room set available='"+available+"',status='"+status+"'";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "room updated successfully");
                new Reception().setVisible(true);
                this.setVisible(false);

            }catch(Exception e){

            }
            
        }
        else if(ae.getSource()==b3){
           new Reception().setVisible(true);
           this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new Updateroom().setVisible(true);
    }
}
