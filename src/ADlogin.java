import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ADlogin extends JFrame {

  JLabel j,j1,j2,j3,j4,j5,j6,j7,j8;
  JTextField t,t1,t2,t3;
  JPasswordField p,p1;
  JButton b,b1;

  ADlogin()
  {
      Font f1=new Font("Verdana",Font.BOLD,14);
      Font f=new Font("Verdana",Font.BOLD,30);
      j=new JLabel("Create New Account");
      j.setBounds(500,70,400,30);
      j.setFont(f);
      j.setForeground(Color.lightGray);
      add(j);

      j1=new JLabel("Name ");
      j1.setBounds(500,150,150,30);
      j1.setForeground(Color.lightGray);
      j1.setFont(f1);
      add(j1);
      t=new JTextField();
      t.setBounds(630,155,190,25);
      add(t);

      j2=new JLabel("User Name");
      j2.setBounds(500,220,150,30);
      j2.setForeground(Color.lightGray);
      j2.setFont(f1);
      add(j2);
      t1=new JTextField();
      t1.setBounds(630,225,190,25);
      add(t1);
       j3=new JLabel("Mobile No...");
       j3.setBounds(500,290,150,30);
      j3.setForeground(Color.lightGray);
      j3.setFont(f1);
      add(j3);
      t2=new JTextField();
      t2.setBounds(630,295,190,25);
      add(t2);
      j5=new JLabel("Password");
      j5.setBounds(500,360,150,30);
      j5.setFont(f1);
      j5.setForeground(Color.lightGray);
      add(j5);
      p=new JPasswordField();
      p.setBounds(630,365,190,25);
      add(p);
      j7=new JLabel("Confirm Pass..");
      j7.setBounds(500,430,150,30);
      j7.setFont(f1);
      j7.setForeground(Color.lightGray);
      add(j7);
      p1=new JPasswordField();
      p1.setBounds(630,435,190,25);
      add(p1);
      b=new JButton("Create");
      b.setBounds(520,540,100,30);
      b.setBackground(Color.PINK);
      b.setForeground(Color.WHITE);
      add(b);
      b1= new JButton("Exit");
      b1.setBounds(790,540,100,30);
      b1.setBackground(Color.PINK);
      b1.setForeground(Color.WHITE);
      add(b1);
    /*  ImageIcon img=new ImageIcon("D:\\Intellij\\admin\\img\\login.jpg");
      j6=new JLabel("",img,JLabel.CENTER);
      j6.setBounds(0,0,1300,700);
      add(j6);*/
      ImageIcon img=new ImageIcon("D:\\Intellij\\admin\\img\\food.jpg");
      ImageIcon img1=new ImageIcon("D:\\Intellij\\admin\\img\\icon2.png");

      setIconImage(img1.getImage());
      //‪ D:\Intellij\admin\img\food.jpg
      j8=new JLabel("",img,JLabel.CENTER);
      j8.setBounds(0,0,1290,700);
      add(j8);
      setTitle("Create new Account");
      setLayout(null);
      setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setSize(1300,700);
      b.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              try

              {
                  Connection con;

                  Class.forName("com.mysql.jdbc.Driver");

                  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/food","root","0110");
                 PreparedStatement ps=con.prepareStatement
                          ("Insert into users (name,username,mobile,password,copassword)values(?,?,?,?,?)");


                  String name=t.getText();
                  String username=t1.getText();
                  String mobile=t2.getText();
                  String pass=String.valueOf(p.getPassword());
                  String copass=String.valueOf(p1.getPassword());

                  int mob=Integer.parseInt(mobile);
                  ps.setString(1,name);

                  ps.setString(2,username);

                  ps.setInt(3,mob);
                  ps.setString(4,pass);
                  ps.setString(5,copass);



                  con.close();

                  JOptionPane.showMessageDialog(null,"Successfully, Create New Account");
              }


              catch(Exception z)
              {
                  JOptionPane.showMessageDialog(null," Account not Create"+z);
              }


              Admin obj=new Admin();

          }
      });


      b1.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {

              new Admin();
           // System.exit(0);


          }
      });

  }



}
