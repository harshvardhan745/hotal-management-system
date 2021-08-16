
package HotelManagementSystem;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;

    Login(){
        l1=new JLabel("Username");
        l1.setBounds(30, 15, 95, 20);
        add(l1);

        l2=new JLabel("Password");
        l2.setBounds(30, 50, 95, 20);
        add(l2);

        t1=new JTextField();
        t1.setBounds(115, 15, 95, 20);
        add(t1);

        t2=new JPasswordField();
        t2.setBounds(115, 50, 95, 20);
        add(t2);

        b1=new JButton("Login");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(30, 90, 85, 20);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(125, 90, 85, 20);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("HotelManagementSystem/icon/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l3=new JLabel(i3);
        l3.setBounds(245, 1, 150, 150);
        add(l3);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(400,250,450,250);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String username=t1.getText();
            String password= String.valueOf(t2.getPassword());
            conn c=new conn();
            String str="select * from Login where username='"+username+"' and password = '"+password+"'";
            try {
                ResultSet rs= c.s.executeQuery(str);
                if(rs.next()){
                    new Dashboard().setVisible(true);
                    this.setVisible(false);

                }else{
                    JOptionPane.showMessageDialog(null, "invalid username and password");
                    this.setVisible(false);
                }
            }catch(Exception e){
                e.printStackTrace();

            }
        }
        else if(ae.getSource()==b2){
            System.exit(0);
        }

    }
    public static void main(String[] args){
        new Login();
    }
}

