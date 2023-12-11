
package bank.management.system;

import java.awt.Color;

import java.awt.*;
import javax.swing.*;
import java.lang.*;
import java.awt.event.*;
import java.util.Date;
import java.util.Random;


public class withdrawal extends JFrame implements ActionListener{
    JTextField amount;
    JButton deposit,back;
    String pinno;
    withdrawal(String pinno){
       this.pinno=pinno;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("./icons/atm.jpg"));
    Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel label=new JLabel(i3);
    label.setBounds(70,10,100,100);
    
    add(label);
    
    
     JLabel enterdetails =new JLabel("Enter the amount to be withdrawed");
    enterdetails.setFont(new Font("Osward",Font.BOLD,15));
    enterdetails.setBounds(200,300,300,30);
    enterdetails.setForeground(Color.white);
    label.add(enterdetails);
    
         amount=new JTextField();
    amount.setBounds(200,350,250,35);
    label.add(amount);
    
            deposit=new JButton("withdraw");
      deposit.setBounds(360,460,150,30);
    deposit.setBackground(Color.white);
    deposit.setForeground(Color.black);
    deposit.addActionListener(this);
    label.add(deposit);
    
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
        if(ae.getSource()==deposit){
            String Amount=amount.getText();
            Date date=new Date();
            String type="Withdraw";
            try{
                if(Amount.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Enter something lol");
                }
                else{
                     Conn c=new Conn();
                     String query="insert into bank values('"+pinno+"', '"+type+"', '"+date+"', '"+Amount+"')";   
                     c.s.executeUpdate(query);
                     JOptionPane.showMessageDialog(null,"Amount "+Amount+" is Withdrawed sucessfully");
                     setVisible(false);
                     new transaction(pinno).setVisible(true);
                }
                      
            }
                catch(Exception e){
                        System.out.println(e);
                        }
            
        }
        else if(ae.getSource()==back){
            setVisible(false);
            new transaction(pinno).setVisible(true);
        }
    }
    
    
    public static void main(String args[]) {
        new withdrawal("");
    }
}
