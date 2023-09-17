import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.sql.*;

  public class orderlog  extends JFrame implements ActionListener {

    JLabel j;
    JButton b;
    static JTable j1;

    orderlog() {

        Font f1 = new Font("Verdana", Font.BOLD, 15);
        j = new JLabel("Total Order Summary");
        j.setBounds(5, 15, 250, 40);
        j.setFont(f1);
        add(j);
        b = new JButton("Total Amount");
        b.setBounds(450, 500, 140, 25);
        add(b);

        ImageIcon img1=new ImageIcon("D:\\Intellij\\admin\\img\\icon2.png");
        setIconImage(img1.getImage());
        JScrollPane sp=new JScrollPane();
        add(sp);
        b.addActionListener( this);
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        setSize(450, 450);
        setTitle(" Order Log ");
        setResizable(false);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        Line2D lin = new Line2D.Float(10, 100, 780, 100);
        g2.draw(lin);
    }



      @Override
      public void actionPerformed(ActionEvent e) {

          if (e.getSource()==b) {
              DefaultTableModel model = (DefaultTableModel) j1.getModel();
              try {


                  Connection con;

                  Class.forName("com.mysql.jdbc.Driver");

                  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/food", "root", "0110");
                  PreparedStatement ps = con.prepareStatement
                          ("select * from orders");

                  ResultSet rs = ps.executeQuery();
                  while (rs.next()) {
                      int number = rs.getInt(1);
                      String item = rs.getString(2);
                      int qunatity = rs.getInt(3);
                      String comments = rs.getString(4);
                      int prize = rs.getInt(5);

                      model.addRow(new Object[]{number, item, qunatity, comments, prize});
                      j1.setModel(model);
                      j1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                      j1.setFillsViewportHeight(true);
                      add(j1);
                      // model.getDataVector().removeAllElements();
                      // j1.repaint();


                  }


                  con.close();

                  JOptionPane.showMessageDialog(null, " Total Order ");
              } catch (Exception z) {
                  JOptionPane.showMessageDialog(null, " Error in Fetching data" + z);
              }
          }
      }

      public static void main(String...q) {


          }


  }

