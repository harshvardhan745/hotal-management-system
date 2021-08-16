
package HotelManagementSystem;
import javax.swing.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener{
    HotelManagementSystem() throws InterruptedException{
        setBounds(50,100,1366,565);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("HotelManagementSystem/icon/first.jpg"));
        JLabel l1=new JLabel(i1);
        l1.setBounds(0,0,1366,565);
        add(l1);

        JLabel l2=new JLabel("Hotel Management System");
        l2.setBounds(20, 430, 1100, 90);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("serif", Font.BOLD, 70));
        l1.add(l2);
        setLayout(null);
        setVisible(true);

        JButton b1=new JButton("Next");
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b1.setBounds(930, 460, 150,45);
        b1.addActionListener(this);
        l1.add(b1);

        while(true){
            l2.setVisible(false);
            try{
                Thread.sleep(500);
            }catch(Exception e){}
            l2.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e){}
        }
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        new Login().setVisible(true);
        this.setVisible(false);
    }
    public static void main(String[] args) throws InterruptedException {
        new HotelManagementSystem();
    }

}
