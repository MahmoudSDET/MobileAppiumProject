import java.sql.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public   class DeviceName {

  private JLabel l1;
  private JLabel l2;

private    JTextField tf1;
 private   JButton btn1;

public  static  String un;

  public DeviceName() {
      initComponents();
      handlingEvents();
  }

  private void initComponents() {


          JFrame frame = new JFrame("Mobile Test Automation");
          l1 = new JLabel("Rent Centric Mobile Ui Test");
          l1.setForeground(Color.blue);
          l1.setFont(new Font("Serif", Font.BOLD, 20));

          l2 = new JLabel("Device Name");

          tf1 = new JTextField();

          btn1 = new JButton("Test");

          l1.setBounds(100, 30, 400, 30);
          l2.setBounds(80, 70, 200, 30);

          tf1.setBounds(200, 70, 100, 23);

          btn1.setBounds(150, 100, 200, 30);

          frame.add(l1);
          frame.add(l2);
          frame.add(tf1);


          frame.add(btn1);

          frame.setSize(400, 400);
          frame.setLayout(null);
          frame.setVisible(true);


  }

  private void handlingEvents() {
      btn1.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent event) {
              un = tf1.getText();

              boolean valid = false;
              String username="";
              String uid="";
              try {
                  if(un!=null)
                  {
                      JOptionPane.showMessageDialog(null,"You Device"+un+" is connected is correctly ",
                              "information",JOptionPane.INFORMATION_MESSAGE);
                  }
                  else
                  {
                      JOptionPane.showMessageDialog(null,"please enter your device Name To Test ",
                              "Error",JOptionPane.ERROR_MESSAGE);
                  }

              }
              catch (Exception e) {
                  System.out.println(e);
              }

          }
      });

  }

  /*public static void main(String args[]) {
      DeviceName log = new DeviceName();
  }*/

}
/*class Welcome extends JFrame
{
    Welcome()
    {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Welcome");
        setSize(400, 200);
    }
}*/