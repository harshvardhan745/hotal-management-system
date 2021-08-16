package HotelManagementSystem;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
    JMenuBar mb;
    JMenu m1,m2;
    JMenuItem i1,i2,i3,i4;
    Dashboard(){
        mb=new JMenuBar();
        add(mb);
        m1=new JMenu("HOTEL MANAGEMENT");
        mb.add(m1);
        m2=new JMenu("ADMIN");
        mb.add(m2);
        i1= new JMenuItem("RECEPTION");
        i1.addActionListener(this);
        m1.add(i1);
        i2= new JMenuItem("ADD EMPLOYEE");
        i2.addActionListener(this);
        m2.add(i2);
        i3= new JMenuItem("ADD ROOMS");
        i3.addActionListener(this);
        m2.add(i3);
        i4= new JMenuItem("ADD DRIVERS");
        i4.addActionListener(this);
        m2.add(i4);
        mb.setBounds(0, 0, 1370, 20);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("HotelManagementSystem/icon/third.jpg"));
        Image i2=i1.getImage().getScaledInstance(1370, 750, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel(i3);
        l1.setBounds(0,0,1370,726);
        add(l1);

        JLabel l2=new JLabel("THE DURGA GROUPS WELCOMES YOU");
        l2.setBounds(350, 0, 900, 300);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Tahome",Font.BOLD,40));
        l1.add(l2);

        setLayout(null);
        setBounds(30,0,1370,746);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("RECEPTION")){
            new Reception().setVisible(true);
        }else if(ae.getActionCommand().equals("ADD EMPLOYEE")){
            new Addemployee().setVisible(true);
        }else if(ae.getActionCommand().equals("ADD ROOMS")){
            new AddRooms().setVisible(true);
        }else if(ae.getActionCommand().equals("ADD DRIVERS")){
            new Adddrivers().setVisible(true);
        }
        }

    public static void main(String[] args){
        new Dashboard().setVisible(true);
    }
}
