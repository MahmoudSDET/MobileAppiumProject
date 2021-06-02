package GUI_Devices;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
//import jdk.nashorn.internal.runtime.NumberToString;
import net.bytebuddy.asm.Advice;

import java.sql.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


  public   class DeviceName extends JFrame {

  public  static  String un;
    public DeviceName() throws InterruptedException {

        un  = JOptionPane.showInputDialog("Please Enter a Device Name");
        if (un != null) {
            JOptionPane.showMessageDialog(null,"You Device"+un+" is connected is correctly ",
                    "information",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"You Device"+un+" is connected is correctly ",
                    "error",JOptionPane.ERROR_MESSAGE);

        }

      /*  setLayout(new BorderLayout());

        JLabel enterYourName = new JLabel("Enter Your Name Here:");
        JTextField textBoxToEnterName = new JTextField(21);
        JPanel panelTop = new JPanel();
        panelTop.add(enterYourName);
        panelTop.add(textBoxToEnterName);

        JButton submit = new JButton("Submit");
        submit.addActionListener(new SubmitButton (textBoxToEnterName));
        submit.addKeyListener(new SubmitButton(textBoxToEnterName));
        JPanel panelBottom = new JPanel();
        panelBottom.add(submit);

        //Add panelTop to JFrame
        add(panelTop, BorderLayout.NORTH);
        add(panelBottom, BorderLayout.SOUTH);

        //JFrame set-up
        setTitle("Name Prompt Program");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);*/


    }


  }




      /*  un  = JOptionPane.showInputDialog("Please Enter a Device Name");
// Now test the user input
        if (un != null) {
            JOptionPane.showMessageDialog(null,"You Device"+un+" is connected is correctly ",
                    "information",JOptionPane.INFORMATION_MESSAGE);
        }*/

    /*public static void main(String args[]) {
        DeviceName log = new DeviceName();
    }*/


/*class Welcome extends JFrame
{
    Welcome()
    {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Welcome");
        setSize(400, 200);
    }
}*/