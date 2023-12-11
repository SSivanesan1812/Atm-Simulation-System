
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.lang.*;
import java.util.Date;
import java.sql.*;

import java.awt.event.*;

public class balanceinquiry extends JFrame implements ActionListener{
        String pinno;
    JTextField newpin;
    JButton cpin,back;
    balanceinquiry(String pinno){
         this.pinno=pinno;
                ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("./icons/atm.jpg"));
    Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel label=new JLabel(i3);
    label.setBounds(70,10,100,100);
    
    add(label);     
        
    

    
     try{
       
                    
                    
                long balance=0;
                Conn c=new Conn();
                String query="Select * from bank where pinno='"+pinno+"'";
                ResultSet rs=c.s.executeQuery(query);
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        int m=Integer.parseInt(rs.getString("amount"));
                        balance+=m;
                    }
                    else{
                        int m=Integer.parseInt(rs.getString("amount"));
                        balance-=m;
                    }
                }
                
     JLabel enterdetails =new JLabel("The Balance is "+balance);
    enterdetails.setFont(new Font("Osward",Font.BOLD,18));
    enterdetails.setBounds(250,300,400,30);
    enterdetails.setForeground(Color.white);
    label.add(enterdetails);
               
                }
                catch(Exception e){
                    System.out.println(e);
                }
    
    
    
    
    
    
    
    
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
     }

    public static void main(String args[]) {
            new balanceinquiry("");
    }
}
