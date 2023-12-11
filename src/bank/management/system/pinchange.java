
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.lang.*;
import java.util.Date;
import java.sql.*;

import java.awt.event.*;



public class pinchange extends JFrame implements ActionListener{
    String pinno;
    JTextField newpin;
    JButton cpin,back;
    pinchange(String pinno){
         this.pinno=pinno;
                ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("./icons/atm.jpg"));
    Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel label=new JLabel(i3);
    label.setBounds(70,10,100,100);
    
    add(label);     
        
    
     JLabel enterdetails =new JLabel("Enter new PIN");
    enterdetails.setFont(new Font("Osward",Font.BOLD,18));
    enterdetails.setBounds(220,300,400,30);
    enterdetails.setForeground(Color.white);
    label.add(enterdetails);
    
     newpin=new JTextField();
    newpin.setBounds(200,350,250,35);
    label.add(newpin);
        
    
    cpin=new JButton("Change the PIN");
      cpin.setBounds(360,460,150,30);
    cpin.setBackground(Color.white);
    cpin.setForeground(Color.black);
    cpin.addActionListener(this);
    label.add(cpin);
    
            back=new JButton("Back");
      back.setBounds(360,495,150,30);
    back.setBackground(Color.white);
    back.setForeground(Color.black);
    back.addActionListener(this);
    label.add(back);
    
    
        getContentPane().setBackground(Color.WHITE);
            
            setSize(900,900);
            setLocation(300,0);
//            setUndecorated(true);
            setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new transaction(pinno).setVisible(true);
        }
        else{
            String pin=newpin.getText();
            try{
                
            if(pin.isEmpty()){
                JOptionPane.showMessageDialog(null,"Type something baka");
            }
            else{
            Conn c=new Conn();
            String query1="Update login set pinno='"+pin+"' where pinno='"+pinno+"'";
            String query2="Update bank set pinno='"+pin+"' where pinno='"+pinno+"'";
            String query3="Update signupthree set pinno='"+pin+"' where pinno='"+pinno+"'";
            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);
            c.s.executeUpdate(query3);
            
            JOptionPane.showMessageDialog(null,"PIN changed succefully");
                     setVisible(false);
                     new transaction(pinno).setVisible(true);
            }
            }
            catch(Exception e){
                System.out.println(e);
                
            }
            
        }
    }

    public static void main(String args[]) {
      new pinchange("");
    }
}
