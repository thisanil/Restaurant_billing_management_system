import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;


public class Admin extends JFrame {

JLabel j,j1,j2,j3,j4,j5,j6;
JTextField t,t1,t2,t3;
JButton b,b1,b2,b3;
JPasswordField p;
 Container c;
Admin()
{
    Font f=new Font("Verdana",Font.BOLD,30);
    Font f1=new Font("Verdana",Font.BOLD,14);
    j3=new JLabel("LOGIN");
    j3.setBounds(620,140,200,30);
    j3.setForeground(Color.lightGray);
    j3.setFont(f);
    add(j3);
  j=new JLabel("User name ");
  j.setBounds(500,200,150,30);
    j.setForeground(Color.lightGray);
    j.setFont(f1);
  add(j);
  t=new JTextField();
  t.setBounds(630,205,190,25);
  add(t);
   j1=new JLabel("Password");
   j1.setBounds(500,270,150,30);
    j1.setForeground(Color.lightGray);
    j1.setFont(f1);
   add(j1);
   p=new JPasswordField();
   p.setBounds(630,275,190,25);
   add(p);

   b1=new JButton("Sign in");
   b1.setBounds(500,390,100,30);
   b1.setBackground(Color.pink);
    b1.setForeground(Color.white);
   add(b1);
   b2= new JButton("Close");
   b2.setBounds(700,390,100,30);
   b2.setBackground(Color.PINK);
    b2.setForeground(Color.WHITE);
   add(b2);
    j5=new JLabel("Create new Account ");
    j5.setBounds(760,460,200,30);

    j5.setFont(f1);
    j5.setForeground(Color.lightGray);
    add(j5);
    b3=new JButton("Click");
    b3.setBounds(920,470,70,15);
    b3.setBackground(Color.PINK);
    b3.setForeground(Color.WHITE);
    add(b3);
   ImageIcon img=new ImageIcon("D:\\Anil saini\\Intellij\\admin\\img\\main.jpg");
    ImageIcon img1=new ImageIcon("D:\\Anil saini\\Intellij\\admin\\img\\chef-gf380a5c16_1280.png");

    setIconImage(img1.getImage());
   //‪ D:\Intellij\admin\img\food.jpg
   j4=new JLabel("",img,JLabel.CENTER);
   j4.setBounds(0,0,1290,700);
   add(j4);

    setTitle("  Kitchen and Cafe ");
   setLayout(null);
   setVisible(true);
   setDefaultCloseOperation(EXIT_ON_CLOSE);
   setSize(1290,700);
   setLocation(0,0);

   b1.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {





          try
           {
               Class.forName("com.mysql.jdbc.Driver");    //register the driver class

               Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/food","root","0110"); //create connection

               String user=t.getText();
               String pass=String.valueOf(p.getPassword());
               PreparedStatement pstmt= pstmt = con.prepareStatement("select * from users where username=? and password=?");

                pstmt.setString(1,user);
                pstmt.setString(2,pass);
                ResultSet r = pstmt.executeQuery();
               if(r.next())
               {

                   Oder obj= new Oder();
               }
               else {

                   JOptionPane.showMessageDialog(null,"Not Correct User name and Password");
               }

               con.close();
           }
           catch(Exception z)

           {JOptionPane.showMessageDialog(null,"Connection Error"+z);
           Oder obj= new Oder();
           }
       }



   });

   b2.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {

           System.exit(0);
       }
   });
   b3.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {

         ADlogin show=new ADlogin();


       }
   });

}
    public static void main(String[] args) {

     new Admin();
    }
}
