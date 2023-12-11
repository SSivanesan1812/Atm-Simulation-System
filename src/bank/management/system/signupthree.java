
package bank.management.system;


import java.awt.*;
import javax.swing.*;
import java.lang.*;
import java.awt.event.*;
import java.util.Random;


public class signupthree extends JFrame implements ActionListener{
    String formno;
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    
    
    
    signupthree(String formno){
       
    this.formno=formno;
      setLayout(null);
      setTitle("Signup page three");
      
    JLabel personaldetails =new JLabel("Page 3:Card Details");
    personaldetails.setFont(new Font("Osward",Font.BOLD,22));
    personaldetails.setBounds(280,80,400,30);
    add(personaldetails);
    
    JLabel name =new JLabel("Account Type");
    name.setFont(new Font("Osward",Font.BOLD,18));
    name.setBounds(180,160,200,30);
    add(name);
    
    r1=new JRadioButton("Saving Account");
    r1.setBackground(Color.white);
    r1.setBounds(200,190,180,30);
    add(r1);
    
    r2=new JRadioButton("Fixed Deposit Account");
    r2.setBackground(Color.white);
    r2.setBounds(430,190,180,30);
    add(r2);
    
    r3=new JRadioButton("Current Account");
    r3.setBackground(Color.white);
    r3.setBounds(200,220,180,30);
    add(r3);
    
    r4=new JRadioButton("Recurring Deposit Account");
    r4.setBackground(Color.white);
    r4.setBounds(430,220,180,30);
    add(r4);
    
    ButtonGroup accounttype=new ButtonGroup();
    accounttype.add(r1);
    accounttype.add(r2);
    accounttype.add(r3);
    accounttype.add(r4);
    
    JLabel dob =new JLabel("Card Number");
    dob.setFont(new Font("Osward",Font.BOLD,18));
    dob.setBounds(180,270,300,30);
    add(dob);
    
    JLabel cardnumber =new JLabel("XXXX XXXX XXXX 4615");
    cardnumber.setFont(new Font("Osward",Font.BOLD,18));
    cardnumber.setBounds(420,270,300,30);
    add(cardnumber);
    
    JLabel digit =new JLabel("your 16 digit card number");
    digit.setFont(new Font("Osward",Font.BOLD,10));
    digit.setBounds(180,290,300,30);
    add(digit);
    
    JLabel pin =new JLabel("PIN");
    pin.setFont(new Font("Osward",Font.BOLD,18));
    pin.setBounds(180,320,300,30);
    add(pin);
    
    JLabel pinnumber =new JLabel("XXXX");
    pinnumber.setFont(new Font("Osward",Font.BOLD,18));
    pinnumber.setBounds(420,320,300,30);
    add(pinnumber);
    
    JLabel pindigit =new JLabel("your 4 digit pin number");
    pindigit.setFont(new Font("Osward",Font.BOLD,10));
    pindigit.setBounds(180,340,300,30);
    add(pindigit);
    
    JLabel service =new JLabel("Service Required");
    service.setFont(new Font("Osward",Font.BOLD,18));
    service.setBounds(180,370,300,30);
    add(service);

    c1=new JCheckBox("ATM CARD");
    c1.setBackground(Color.white);
    c1.setBounds(200,400,180,30);
    add(c1);
    
    c2=new JCheckBox("Internet Banking");
    c2.setBackground(Color.white);
    c2.setBounds(430,400,180,30);
    add(c2);
    
        c3=new JCheckBox("Mobile Banking");
    c3.setBackground(Color.white);
    c3.setBounds(200,430,180,30);
    add(c3);
    
        c4=new JCheckBox("Email and SMS alerts");
    c4.setBackground(Color.white);
    c4.setBounds(430,430,180,30);
    add(c4);
    
        c5=new JCheckBox("Cheque Book");
    c5.setBackground(Color.white);
    c5.setBounds(200,460,180,30);
    add(c5);
    
        c6=new JCheckBox("E-Statement");
    c6.setBackground(Color.white);
    c6.setBounds(430,460,180,30);
    add(c6);
    
    c7=new JCheckBox("I hereby Declare that the above entered details are true tp my best of knowledge");
    c7.setBackground(Color.white);
    c7.setFont(new Font("Osward",Font.BOLD,10));
    c7.setBounds(180,500,500,30);
    add(c7);
    
    
         submit=new JButton("Submit");
    submit.setBounds(200,540,100,30);
    submit.setBackground(Color.BLACK);
    submit.setForeground(Color.white);
    submit.addActionListener(this);
    add(submit);
    
             cancel=new JButton("Cancel");
    cancel.setBounds(420,540,100,30);
    cancel.setBackground(Color.BLACK);
    cancel.setForeground(Color.white);
    cancel.addActionListener(this);
    add(cancel);
    
    
    
    
    
    
    
        
    getContentPane().setBackground(Color.WHITE);
    
    setSize(800,640);
    
    setLocation(350,200);
    setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
        String accounttype = null;
        String cardno;
        String pinno;
        String facility="";
        
        String ran=formno;
        if(r1.isSelected()){
            accounttype="Saving Account";
        }
        else if(r2.isSelected()){
            accounttype="Fixed Deposit Account";
            
        }
                if(r3.isSelected()){
            accounttype="Current Account";
            
        }
                        if(r4.isSelected()){
            accounttype="Recurring Deposit Account";
            
        }
        if(c1.isSelected()){
            facility+=" ATM card";
        }
        if(c2.isSelected()){
            facility+=" Internet Banking";
        }
        if(c3.isSelected()){
            facility+=" Mobile BAnking";
        }
        if(c4.isSelected()){
            facility+=" Email and SMS Service";
        }
        if(c5.isSelected()){
            facility+=" Cheque Book";
        }
        if(c6.isSelected()){
            facility+=" E-Staqtement";
        }
        Random rn=new Random();
        cardno=""+Math.abs((rn.nextLong()%90000000L)+4321230000000000L);
        pinno=""+Math.abs((rn.nextLong()%9000L)+1000L);
 
        
                        
        
        try{
            if(!(c7.isSelected())){
                JOptionPane.showMessageDialog(null,"Accept the decleration");
            }
            else{
                Conn c=new Conn();
                System.out.println(facility);
                String query="insert into signupthree values('"+ran+"', '"+accounttype+"', '"+cardno+"', '"+pinno+"', '"+facility+"')";   
                String query1="insert into login values('"+ran+"','"+cardno+"', '"+pinno+"')";   
                c.s.executeUpdate(query);
                c.s.executeUpdate(query1);
                JOptionPane.showMessageDialog(null,"Card No:"+cardno+"\nPin:"+pinno);
                setVisible(false);
                new transaction(pinno).setVisible(true);
            }
            
            
        }
        catch(Exception e){
            System.out.println(e);
        }
        }
        if(ae.getSource()==cancel){
           setVisible(false);
           new Login().setVisible(true);
        }
    }

    public static void main(String args[]) {
        new signupthree("123124");
    }
}
