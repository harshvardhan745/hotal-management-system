package HotelManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Adddrivers extends JFrame implements ActionListener{
     JTextField t1,t2,t3,t4,t5;
     JComboBox c1,c2;
     JButton b1,b2;
     Adddrivers(){
         JLabel title=new JLabel("ADD DRIVERS");
         title.setBounds(100,10,140,40);
         title.setFont(new Font("Tohama",Font.BOLD,16));
         add(title);
         
         JLabel name=new JLabel("Name");
         name.setBounds(50,70,80,20);
         name.setFont(new Font("Tohama",Font.PLAIN,12));
         add(name);
         t1=new JTextField();
         t1.setBounds(170,70,100,20);
         add(t1);
         
         JLabel age=new JLabel("Age");
         age.setBounds(50,95,80,20);
         age.setFont(new Font("Tohama",Font.PLAIN,12));
         add(age);
         t2=new JTextField();
         t2.setBounds(170,95,100,20);
         add(t2);
         
         JLabel gender=new JLabel("Gender");
         gender.setBounds(50,120,80,20);
         gender.setFont(new Font("Tohama",Font.PLAIN,12));
         add(gender);
         c1=new JComboBox(new String[] {" ","Male","Female","Others"});
         c1.setBounds(170,120,100,20);
         c1.setBackground(Color.WHITE);
         add(c1);
         
         JLabel car=new JLabel("Car");
         car.setBounds(50,145,80,20);
         car.setFont(new Font("Tohama",Font.PLAIN,12));
         add(car);
         t3=new JTextField();
         t3.setBounds(170,145,100,20);
         add(t3);
         
         JLabel model=new JLabel("Model");
         model.setBounds(50,170,80,20);
         model.setFont(new Font("Tohama",Font.PLAIN,12));
         add(model);
         t4=new JTextField();
         t4.setBounds(170,170,100,20);
         add(t4);
         
         JLabel available=new JLabel("Available");
         available.setBounds(50,195,80,20);
         available.setFont(new Font("Tohama",Font.PLAIN,12));
         add(available);
         c2=new JComboBox(new String[] {" ","Available","Busy"});
         c2.setBounds(170,195,100,20);
         c2.setBackground(Color.WHITE);
         add(c2);
         
         JLabel location=new JLabel("Location");
         location.setBounds(50,220,80,20);
         location.setFont(new Font("Tohama",Font.PLAIN,12));
         add(location);
         t5=new JTextField();
         t5.setBounds(170,220,100,20);
         add(t5);
         
         b1=new JButton("Add Driver");
         b1.setBackground(Color.BLACK);
         b1.setForeground(Color.WHITE);
         b1.setBounds(50,260,100,20);
         b1.addActionListener(this);
         add(b1);
         
         b2=new JButton("Cancel");
         b2.setBackground(Color.BLACK);
         b2.setForeground(Color.WHITE);
         b2.setBounds(170,260,100,20);
         b2.addActionListener(this);
         add(b2);
         
         getContentPane().setBackground(Color.WHITE);
         
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("HotelManagementSystem/icon/eleven.jpg"));
         Image i2=i1.getImage().getScaledInstance(380, 280, Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel l1=new JLabel(i3);
         l1.setBounds(310, 15, 360, 285);
         add(l1);
         
         
         
         setLayout(null);
         setBounds(300,150,700,350);
         setVisible(true);
     }
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==b1){
             String name=t1.getText();
             String age=t2.getText();
             String gender=(String)c1.getSelectedItem();
             String company=t3.getText();
             String model=t4.getText();
             String available=(String)c2.getSelectedItem();
             String location=t5.getText();
             conn c=new conn();
             String str="insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+model+"','"+available+"','"+location+"')";
             try {
                 c.s.executeUpdate(str);
                 JOptionPane.showMessageDialog(null, "Driver Successfully Added");
             }catch(Exception e){

             }
         }else if(ae.getSource()==b2){
             setVisible(false);
         }
     }
     public static void main(String[] args){
         new Adddrivers().setVisible(true);
     }
}
