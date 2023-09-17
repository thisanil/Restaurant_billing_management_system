import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
public class Tablemenu extends JFrame implements ActionListener {

    JLabel j, j1, j2, j3, j4, j5, j6, j7;
    JTextField t, t1, t2, t3;
    JPasswordField p, p1;
    JButton b, b1,b2,b3,b4;
    JComboBox cb;

    Tablemenu(String table) {
        Font f1 = new Font("Verdana", Font.BOLD, 13);
        j = new JLabel("" + table + " Menu");
        j.setBounds(5, 15, 120, 40);
        j.setFont(f1);
        add(j);

        j1= new JLabel("Number of people");
        j1.setBounds(10,95,180,25);
        add(j1);
        t=new JTextField();
        t.setBounds(135,100,500,20);
        add(t);
        j1=new JLabel("Add order");
        j1.setBounds(10,160,100,20);
        add(j1);
        j2 =new JLabel("Item Name");
        j2.setBounds(135,140,100,20);
        add(j2);
        t1=new JTextField();
        t1.setBounds(135,165,150,20);
       add(t1);
        j3=new JLabel("Quantity");
        j3.setBounds(315,140,150,20);
        add(j3);
        String number[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"};
         cb=new JComboBox(number);
         cb.setBounds(315,165,130,20);
         add(cb);
         j4=new JLabel("Comments");
         j4.setBounds(470,140,150,20);
         add(j4);
         t2=new JTextField();
         t2.setBounds(470,165,150,20);
         add(t2);
         j4=new JLabel("Add Order");
         j4.setBounds(650,140,150,20);
         add(j4);
         b =new JButton("Add ");
         b.setBounds(650,165,70,20);
         add(b);
         b1=new JButton("save");
         b1.setBounds(550,500,80,25);
         add(b1);
         b2=new JButton("Cancel");
         b2.setBounds(650,500,80,25);
         add(b2);
        b3=new JButton("Pay");
        b3.setBounds(450,500,80,25);
        add(b3);
      b4=new JButton("Total pay");
      b4.setBounds(10,500,100,25);
      add(b4);
      j5=new JLabel(" =   "+"   0");
      j5.setBounds(130,500,70,20);
      j5.setFont(f1);
      add(j5);
       j6=new JLabel("Prize");
       j6.setBounds(135,200,100,20);
       add(j6);
        t3=new JTextField();
        t3.setBounds(135,225,150,20);
       add(t3);

        b.addActionListener( this);
        b1.addActionListener( this);
        b2.addActionListener(this);
        b3.addActionListener( this);
        ImageIcon img1=new ImageIcon("D:\\Intellij\\admin\\img\\icon2.png");

        setIconImage(img1.getImage());
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        setSize(450, 450);
        setTitle("Table Menu ");
        setResizable(false);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        Line2D lin = new Line2D.Float(10,100,780,100);
        g2.draw(lin);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

      if(e.getSource()==b)
      {
          try

          {
              Connection con;

              Class.forName("com.mysql.jdbc.Driver");

              con=DriverManager.getConnection("jdbc:mysql://localhost:3306/food","root","0110");
              PreparedStatement ps=con.prepareStatement
                      ("Insert into order (number,item,,qunatity,comments,prize)values(?,?,?,?,?,?)");


              String number=t.getText();
              String item=t1.getText();
              String quna= (String) cb.getEditor().getItem();
              String com=t2.getText();
              String prize=t3.getText();

              int tity=Integer.parseInt(quna);
              ps.setString(1,number);

              ps.setString(2,item);

              ps.setInt(3,tity);
              ps.setString(4,com);
              ps.setString(5,prize);



              con.close();

              JOptionPane.showMessageDialog(null,"Successfully Add  Order ");
          }


          catch(Exception z)
          {
              JOptionPane.showMessageDialog(null," Order Not Add"+z);
          }

      } else if (e.getSource()==b4) {



      }

    }
}