package HotelManagementSystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Addemployee extends JFrame implements ActionListener{
    JTextField t1,t2,t3,t4,t5,t6;
    JRadioButton r1,r2;
    JComboBox c1;
    JButton b1,b2;
    Addemployee(){
        JLabel name=new JLabel("Name");
        name.setFont(new Font("Tahoma",Font.BOLD, 12));
        name.setBounds(60,30,120,30);
        add(name);
        t1=new JTextField();
        t1.setBounds(130,35,150,20);
        add(t1);

        JLabel age=new JLabel("Age");
        age.setFont(new Font("Tahoma",Font.BOLD, 12));
        age.setBounds(60,65,120,30);
        add(age);
        t2=new JTextField();
        t2.setBounds(130,70,150,20);
        add(t2);

        JLabel gender=new JLabel("Gender");
        gender.setFont(new Font("Tahoma",Font.BOLD, 12));
        gender.setBounds(60,100,120,30);
        add(gender);
        r1=new JRadioButton("Male");
        r1.setBounds(130, 105, 70 , 20);
        r1.setBackground(Color.WHITE);
        add(r1);

        r2=new JRadioButton("Female");
        r2.setBounds(205, 105, 70 , 20);
        r2.setBackground(Color.WHITE);
        add(r2);

        JLabel job=new JLabel("Job");
        job.setFont(new Font("Tahoma",Font.BOLD, 12));
        job.setBounds(60,135,120,30);
        add(job);
        String str[]={"   ","Front Desk Clerk","Poster","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Cheff"};
        c1=new JComboBox(str);
        c1.setBounds(130,140,150,20);
        c1.setBackground(Color.WHITE);
        add(c1);

        JLabel salary=new JLabel("Salary");
        salary.setFont(new Font("Tahoma",Font.BOLD, 12));
        salary.setBounds(60,170,120,30);
        add(salary);
        t3=new JTextField();
        t3.setBounds(130,175,150,20);
        add(t3);

        JLabel phone=new JLabel("Phone");
        phone.setFont(new Font("Tahoma",Font.BOLD, 12));
        phone.setBounds(60,205,120,30);
        add(phone);
        t4=new JTextField();
        t4.setBounds(130,210,150,20);
        add(t4);

        JLabel aadhar=new JLabel("Aadhar");
        aadhar.setFont(new Font("Tahoma",Font.BOLD, 12));
        aadhar.setBounds(60,240,120,30);
        add(aadhar);
        t5=new JTextField();
        t5.setBounds(130,245,150,20);
        add(t5);

        JLabel email=new JLabel("Email");
        email.setFont(new Font("Tahoma",Font.BOLD, 12));
        email.setBounds(60,275,120,30);
        add(email);
        t6=new JTextField();
        t6.setBounds(130,280,150,20);
        add(t6);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("HotelManagementSystem/icon/tenth.jpg"));
        Image i2=i1.getImage().getScaledInstance(350,350, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel(i3);
        l1.setBounds(295, 70, 360, 280);
        add(l1);

        JLabel l2=new JLabel("ADD EMPLOYEE DETAILS");
        l2.setForeground(Color.BLACK);
        l2.setBounds(330, 30, 360, 25);
        l2.setFont(new Font("Tahoma",Font.BOLD,22));
        add(l2);

        b1=new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(130, 350, 150, 30);
        b1.addActionListener(this);
        add(b1);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(400,210,650,450);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String name=t1.getText();
        String age=t2.getText();
        String salary=t3.getText();
        String phone=t4.getText();
        String aadhar=t5.getText();
        String email=t6.getText();
        String gender=null;
        if(r1.isSelected()){
            gender="Male";
        }else if(r2.isSelected()){
            gender="Female";
        }
        String job=(String)c1.getSelectedItem();
        conn c=new conn();
        String str="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+aadhar+"','"+email+"')";
        try{
            c.s.executeUpdate(str);
             JOptionPane.showMessageDialog(null,"New Employee Added");
             this.setVisible(false);

        }catch(Exception e){
            System.out.println(e);

        }
    }
    public static void main(String[] args){
        new Addemployee().setVisible(true);
    }
}
