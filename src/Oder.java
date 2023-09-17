import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import static javax.print.attribute.standard.MediaSizeName.A;


public class Oder extends JFrame implements ActionListener{

    JLabel j,j1,j2,j3,j4,j5,j6,j7;
    JTextField t,t1,t2,t3;
    JButton b,b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,b11;


    Oder()
    {
        Font f1=new Font("Verdana",Font.BOLD,12);
        Font f2=new Font("Verdana",Font.BOLD,16);
        b=new JButton("View Order Log");
        b.setBounds(30,80,150,40);
        b.setBackground(Color.ORANGE);
        b.setForeground(Color.WHITE);
        b.setFont(f1);
        add(b);
        b1=new JButton("MenuBook");
        b1.setBounds(30,186,150,40);
        b1.setBackground(Color.ORANGE);
        b1.setForeground(Color.WHITE);
        b1.setFont(f1);
        add(b1);

        b2=new JButton("Change MenuBook");
        b2.setBounds(30,286,150,40);
        b2.setBackground(Color.ORANGE);
        b2.setForeground(Color.WHITE);
        b2.setFont(f1);
        add(b2);

        b3=new JButton("Table 1");
        b3.setBounds(350,120,150,60);
        b3.setBackground(Color.darkGray);
        b3.setForeground(Color.WHITE);
        b3.setFont(f2);
        add(b3);

        b4=new JButton("Table 2");
        b4.setBounds(650,120,150,60);
        b4.setBackground(Color.darkGray);
        b4.setForeground(Color.WHITE);
        b4.setFont(f2);
        add(b4);

        b5=new JButton("Table 3");
        b5.setBounds(950,120,150,60);
        b5.setBackground(Color.darkGray);
        b5.setForeground(Color.WHITE);
        b5.setFont(f2);
        add(b5);

        b6=new JButton("Table 4");
        b6.setBounds(350,300,150,60);
        b6.setBackground(Color.darkGray);
        b6.setForeground(Color.WHITE);
        b6.setFont(f2);
        add(b6);

        b7=new JButton("Table 5");
        b7.setBounds(650,300,150,60);
        b7.setBackground(Color.darkGray);
        b7.setForeground(Color.WHITE);
        b7.setFont(f2);
        add(b7);

        b8=new JButton("Table 6");
        b8.setBounds(950,300,150,60);
        b8.setBackground(Color.darkGray);
        b8.setForeground(Color.WHITE);
        b8.setFont(f2);
        add(b8);
        b9=new JButton("Table 7");
        b9.setBounds(350,480,150,60);
        b9.setBackground(Color.darkGray);
        b9.setForeground(Color.WHITE);
        b9.setFont(f2);
        add(b9);
        b0=new JButton("Table 8");
        b0.setBounds(650,480,150,60);
        b0.setBackground(Color.darkGray);
        b0.setForeground(Color.WHITE);
        b0.setFont(f2);
        add(b0);
        b11=new JButton("Table 9");
        b11.setBounds(950,480,150,60);
        b11.setBackground(Color.darkGray);
        b11.setForeground(Color.WHITE);
        b11.setFont(f2);
        add(b11);

        b.addActionListener( this);
        b1.addActionListener( this);
        b2.addActionListener(this);
        b3.addActionListener( this);
        b4.addActionListener( this);
        b5.addActionListener( this);
        b6.addActionListener( this);
        b7.addActionListener( this);
        b8.addActionListener( this);
        b9.addActionListener( this);
        b0.addActionListener( this);
        b11.addActionListener( this);


        ImageIcon img1=new ImageIcon("D:\\Intellij\\admin\\img\\icon2.png");
        setIconImage(img1.getImage());
        ImageIcon img=new ImageIcon("D:\\Intellij\\admin\\img\\main_area.jpg");
        j6=new JLabel("",img,JLabel.CENTER);
        j6.setBounds(0,0,1300,700);
        add(j6);
        setTitle("Order Menu");
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1300,700);

    }
    public void actionPerformed(ActionEvent A)
    {
      if(A.getSource()==b)
      {
        orderlog obj1=new orderlog();
      }
       else if(A.getSource()==b1)
        {
            Tablemenu obj = new Tablemenu(null);
        }
        else if(A.getSource()==b2)
        {
            Tablemenu obj = new Tablemenu(null);
        }
        else if(A.getSource()==b3)
        {
            Tablemenu obj = new Tablemenu("Table 1");
        }
       else  if(A.getSource()==b4)
        {
            Tablemenu obj = new Tablemenu("Table 2");
        }
        else if(A.getSource()==b5)
        {
            Tablemenu obj = new Tablemenu("Table 3");
        }
        else if(A.getSource()==b6)
        {
            Tablemenu obj = new Tablemenu("Table 4");
        }
       else  if(A.getSource()==b7)
        {
            Tablemenu obj = new Tablemenu("Table 5");
        }
         else if(A.getSource()==b8)
        {
            Tablemenu obj = new Tablemenu("Table 6");
        }
        else if(A.getSource()==b9)
        {
            Tablemenu obj = new Tablemenu("Table 7");
        }
       else if(A.getSource()==b0)
        {
            Tablemenu obj = new Tablemenu("Table 8");
        }
        else if (A.getSource()==b11)
        {
            Tablemenu obj = new Tablemenu("Table 9");
        }


    }

    public void print(Graphics g)
    {
        super.paint(g);
        g.setColor(Color.lightGray);
        g.drawRect(60,80,851,55);
    }
    public static void main(String[] args) {
       Oder obj= new Oder();

    }
}
