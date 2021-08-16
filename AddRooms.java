package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener {
    JTextField t1, t2;
    JComboBox c1, c2, c3;
    JButton b1, b2;

    AddRooms() {
        JLabel l1 = new JLabel("Add Rooms");
        l1.setFont(new Font("Tahoma", Font.BOLD, 17));
        l1.setBounds(110, 30, 100, 20);
        add(l1);

        JLabel room = new JLabel("Room Number");
        room.setFont(new Font("Tahoma", Font.PLAIN, 15));
        room.setBounds(30, 80, 100, 20);
        add(room);

        JLabel available = new JLabel("Available");
        available.setFont(new Font("Tahoma", Font.PLAIN, 15));
        available.setBounds(30, 110, 100, 20);
        add(available);
        c1 = new JComboBox(new String[]{"Available", "Occupied"});
        c1.setBounds(150, 110, 150, 25);
        c1.setBackground(Color.WHITE);
        add(c1);

        JLabel status = new JLabel("Clean Status");
        status.setFont(new Font("Tahoma", Font.PLAIN, 15));
        status.setBounds(30, 140, 100, 20);
        add(status);
        c2 = new JComboBox(new String[]{"Clean", "Dirty"});
        c2.setBounds(150, 140, 150, 25);
        c2.setBackground(Color.WHITE);
        add(c2);

        JLabel price = new JLabel("Price");
        price.setFont(new Font("Tahoma", Font.PLAIN, 15));
        price.setBounds(30, 170, 100, 20);
        add(price);

        t2 = new JTextField();
        t2.setBounds(150, 170, 150, 25);
        add(t2);


        t1 = new JTextField();
        t1.setBounds(150, 80, 150, 25);
        add(t1);


        JLabel type = new JLabel("Bed Type");
        type.setFont(new Font("Tahoma", Font.PLAIN, 15));
        type.setBounds(30, 200, 100, 20);
        add(type);

        c3 = new JComboBox(new String[]{"Single", "Double"});
        c3.setBounds(150, 200, 150, 25);
        c3.setBackground(Color.WHITE);
        add(c3);
        b1 = new JButton("Add Room");
        b1.addActionListener(this);
        b1.setBounds(30, 300, 100, 20);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        b2 = new JButton("Cancel");
        b2.addActionListener(this);
        b2.setBounds(140, 300, 100, 20);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("HotelManagementSystem/icon/twelve.jpg"));
        JLabel l5 = new JLabel(i1);
        l5.setBounds(310, 30, 510, 350);
        add(l5);

        getContentPane().setBackground(Color.WHITE);


        setBounds(400, 200, 850, 450);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
            String room=t1.getText();
            String available= (String)c1.getSelectedItem();
            String status=(String) c2.getSelectedItem();
            String price=t2.getText();
            String type=(String) c3.getSelectedItem();

            conn c=new conn();
            try{
                String str="insert into room values('"+room+"','"+available+"','"+status+"','"+price+"','"+type+"')";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "New Room Added");
                this.setVisible(false);

            }catch(Exception e){
                System.out.println(e);

            }

        }else if(ae.getSource()==b2){
            this.setVisible(false);
        }

    }


    public static void main(String[] args) {
        new AddRooms().setVisible(true);
    }
}
