
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.lang.*;
import java.util.Date;
import java.sql.*;

import java.awt.event.*;

public class fastcash extends JFrame implements ActionListener{
    JButton deposit,cashwithdrawal,fastcash,ministatement,pinchange,balanceinquiry,exit;
String pinno;
        fastcash(String pinno){
            this.pinno=pinno;
                ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("./icons/atm.jpg"));
    Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel label=new JLabel(i3);
    label.setBounds(70,10,100,100);
    
    add(label);
    
     JLabel enterdetails =new JLabel("Select the amount to withdraw");
    enterdetails.setFont(new Font("Osward",Font.BOLD,18));
    enterdetails.setBounds(220,300,400,30);
    enterdetails.setForeground(Color.white);
    label.add(enterdetails);
    
    deposit=new JButton("Rs 500");
      deposit.setBounds(150,390,150,30);
    deposit.setBackground(Color.white);
    deposit.setForeground(Color.black);
    deposit.addActionListener(this);
    label.add(deposit);
    
        cashwithdrawal=new JButton("Rs 1000");
      cashwithdrawal.setBounds(360,390,150,30);
    cashwithdrawal.setBackground(Color.white);
    cashwithdrawal.setForeground(Color.black);
    cashwithdrawal.addActionListener(this);
    label.add(cashwithdrawal);
    
        fastcash=new JButton("Rs 1500");
      fastcash.setBounds(150,425,150,30);
    fastcash.setBackground(Color.white);
    fastcash.setForeground(Color.black);
    fastcash.addActionListener(this);
    label.add(fastcash);
    
        ministatement=new JButton("Rs 2000");
      ministatement.setBounds(360,425,150,30);
    ministatement.setBackground(Color.white);
    ministatement.setForeground(Color.black);
    ministatement.addActionListener(this);
    label.add(ministatement);
    
        pinchange=new JButton("Rs 5000");
      pinchange.setBounds(150,460,150,30);
    pinchange.setBackground(Color.white);
    pinchange.setForeground(Color.black);
    pinchange.addActionListener(this);
    label.add(pinchange);
    
        balanceinquiry=new JButton("Rs 10000");
      balanceinquiry.setBounds(360,460,150,30);
    balanceinquiry.setBackground(Color.white);
    balanceinquiry.setForeground(Color.black);
    balanceinquiry.addActionListener(this);
    label.add(balanceinquiry);
    
        exit=new JButton("Back");
      exit.setBounds(255,495,150,30);
    exit.setBackground(Color.white);
    exit.setForeground(Color.black);
    exit.addActionListener(this);
    label.add(exit);
    
    
    
           
             getContentPane().setBackground(Color.WHITE);
            
            setSize(900,900);
            setLocation(300,0);
//            setUndecorated(true);
            setVisible(true);
            
            
            
        }
        
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()== exit){
                setVisible(false);
                new transaction(pinno).setVisible(true);
            }
            else {
                try{
                    String a=((JButton)ae.getSource()).getText().substring(3);
                    int amount=Integer.parseInt(a);
                    Date date=new Date();
                    String type="Withdraw";
                    
                    
                int balance=0;
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
                if(balance>amount){
                    String query1="insert into bank values('"+pinno+"','"+type+"', '"+date+"', '"+amount+"')";  
                    c.s.executeUpdate(query1);
                     JOptionPane.showMessageDialog(null,"Amount "+amount+" is Withdrawed sucessfully");
                     setVisible(false);
                     new transaction(pinno).setVisible(true);
                }
                else{
                    System.out.println(balance);
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                }
                }
                catch(Exception e){
                    System.out.println(e);
                }
                
             
            }
            
        }
    public static void main(String args[]) {
            new fastcash("");
    }
}
