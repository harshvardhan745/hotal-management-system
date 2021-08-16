
package HotelManagementSystem;

import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class Pickup extends JFrame implements ActionListener{
    Choice c1;
    JButton b1,b2;
    JTable t1;
    Pickup(){
        JLabel l1=new JLabel("Pickup Service");
        l1.setFont(new Font("Tohama",Font.BOLD,16));
        l1.setBounds(180,20,230,20);
        add(l1);
        
        JLabel l2=new JLabel("Types of Car");
        l2.setFont(new Font("Tohama",Font.BOLD,12));
        l2.setBounds(60,100,100,20);
        add(l2);
        c1=new Choice();
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from driver");
            while(rs.next()){
                c1.add(rs.getString("brand"));
            }
            
        }catch(Exception e){}

        c1.setBounds(180,100,200,35);
        add(c1);
        t1=new JTable();
        t1.setBounds(10,200,1000,300);
        add(t1);

        JLabel l3=new JLabel("Name");
        l3.setBounds(30,150,100,20);
        add(l3);

        JLabel l4=new JLabel("Age");
        l4.setBounds(170,150,100,20);
        add(l4);

        JLabel l5=new JLabel("Gender");
        l5.setBounds(300,150,100,20);
        add(l5);

        JLabel l6=new JLabel("Company");
        l6.setBounds(460,150,100,20);
        add(l6);

        JLabel l7=new JLabel("Brand");
        l7.setBounds(600,150,100,20);
        add(l7);

        JLabel l8=new JLabel("Availability");
        l8.setBounds(730,150,100,20);
        add(l8);

        JLabel l9=new JLabel("Location");
        l9.setBounds(880,150,100,20);
        add(l9);
        
         b1=new JButton("Submit");
         b1.setBackground(Color.BLACK);
         b1.setForeground(Color.WHITE);
         b1.setBounds(300,520,120,30);
         b1.addActionListener(this);
         add(b1);
         
         b2=new JButton("Cancel");
         b2.setBackground(Color.BLACK);
         b2.setForeground(Color.WHITE);
         b2.setBounds(500,520,120,30);
         b2.addActionListener(this);
         add(b2);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(500,200,1000,650);
        setVisible(true);
    }
        public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                String str="select * from driver where brand='"+c1.getSelectedItem()+"'";
                conn c=new conn();
                ResultSet rs=c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e){
                
            }
        }
        else{
           new Reception().setVisible(true);
           this.setVisible(false);
        }
    }
    public static void main(String[] args)
    {
        new Pickup().setVisible(true);
    }
}
