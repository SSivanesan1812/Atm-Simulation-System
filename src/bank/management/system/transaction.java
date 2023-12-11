
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.lang.*;

import java.awt.event.*;

public class transaction extends JFrame implements ActionListener{
    JButton deposit,cashwithdrawal,fastcash,ministatement,pinchange,balanceinquiry,exit;
String pinno;
        transaction(String pinno){
            this.pinno=pinno;
                ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("./icons/atm.jpg"));
    Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel label=new JLabel(i3);
    label.setBounds(70,10,100,100);
    
    add(label);
    
     JLabel enterdetails =new JLabel("Select your transaction");
    enterdetails.setFont(new Font("Osward",Font.BOLD,18));
    enterdetails.setBounds(220,300,400,30);
    enterdetails.setForeground(Color.white);
    label.add(enterdetails);
    
    deposit=new JButton("Deposit");
      deposit.setBounds(150,390,150,30);
    deposit.setBackground(Color.white);
    deposit.setForeground(Color.black);
    deposit.addActionListener(this);
    label.add(deposit);
    
        cashwithdrawal=new JButton("Cash Withdrawal");
      cashwithdrawal.setBounds(360,390,150,30);
    cashwithdrawal.setBackground(Color.white);
    cashwithdrawal.setForeground(Color.black);
    cashwithdrawal.addActionListener(this);
    label.add(cashwithdrawal);
    
        fastcash=new JButton("Fast Cash");
      fastcash.setBounds(150,425,150,30);
    fastcash.setBackground(Color.white);
    fastcash.setForeground(Color.black);
    fastcash.addActionListener(this);
    label.add(fastcash);
    
        ministatement=new JButton("Mini Statement");
      ministatement.setBounds(360,425,150,30);
    ministatement.setBackground(Color.white);
    ministatement.setForeground(Color.black);
    ministatement.addActionListener(this);
    label.add(ministatement);
    
        pinchange=new JButton("Pin Change");
      pinchange.setBounds(150,460,150,30);
    pinchange.setBackground(Color.white);
    pinchange.setForeground(Color.black);
    pinchange.addActionListener(this);
    label.add(pinchange);
    
        balanceinquiry=new JButton("Balance Inquiry");
      balanceinquiry.setBounds(360,460,150,30);
    balanceinquiry.setBackground(Color.white);
    balanceinquiry.setForeground(Color.black);
    balanceinquiry.addActionListener(this);
    label.add(balanceinquiry);
    
        exit=new JButton("Exit");
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
                System.exit(0);
            }
            else if(ae.getSource()==deposit){
                setVisible(false);
                new deposit(pinno).setVisible(true);
            }
            else if(ae.getSource()==cashwithdrawal){
                setVisible(false);
                new withdrawal(pinno).setVisible(true);
            }
                        else if(ae.getSource()==fastcash){
                setVisible(false);
                new fastcash(pinno).setVisible(true);
            }
             else if(ae.getSource()==pinchange){
                setVisible(false);
                new pinchange(pinno).setVisible(true);
            }
            else if(ae.getSource()==balanceinquiry){
                setVisible(false);
                new balanceinquiry(pinno).setVisible(true);
            }
            else if(ae.getSource()==ministatement){
                setVisible(false);
                new MiniStatement(pinno).setVisible(true);
            }
        }
    public static void main(String args[]) {
            new transaction("");
    }
}
