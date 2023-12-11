
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;



public class signupone extends JFrame implements ActionListener {
    long random;
    JTextField nameTextField,fnameTextField,pincodeTextField,addressTextField,stateTextField,cityTextField,emailTextField;
    JButton Next;
    JDateChooser dobField;
    JRadioButton male,female,others,married,unmarried;
            
    
    
signupone(){
    
    setLayout(null);
    
    Random rn=new Random();
     random=Math.abs((rn.nextLong()%9000L)+1000L);
    
    
    
    System.out.println(random);
    
    JLabel text =new JLabel("Application form no:"+random);
    text.setFont(new Font("Osward",Font.BOLD,38));
    text.setBounds(140,20,600,40);
    add(text);
    
    JLabel personaldetails =new JLabel("Page1:personal details");
    personaldetails.setFont(new Font("Osward",Font.BOLD,22));
    personaldetails.setBounds(250,80,400,30);
    add(personaldetails);
    
    JLabel name =new JLabel("Card No:");
    name.setFont(new Font("Osward",Font.BOLD,18));
    name.setBounds(100,140,100,30);
    add(name);
    
     nameTextField=new JTextField();
    nameTextField.setBounds(300,140,400,25);
    add(nameTextField);
    
    JLabel fname =new JLabel("Father's name:");
    fname.setFont(new Font("Osward",Font.BOLD,18));
    fname.setBounds(100,180,300,30);
    add(fname);
    
     fnameTextField=new JTextField();
    fnameTextField.setBounds(300,180,400,25);
    add(fnameTextField);
    
    JLabel dob =new JLabel("Date of Birth:");
    dob.setFont(new Font("Osward",Font.BOLD,18));
    dob.setBounds(100,220,300,30);
    add(dob);
    
     dobField=new JDateChooser();
    dobField.setBounds(300,220,400,25);
    add(dobField);
    
    JLabel gender =new JLabel("Gender:");
    gender.setFont(new Font("Osward",Font.BOLD,18));
    gender.setBounds(100,260,300,30);
    add(gender);
    
     male=new JRadioButton("Male");
    male.setBounds(300,260,100,25);
    male.setBackground(Color.white);
    add(male);
    
     female=new JRadioButton("Female");
    female.setBounds(400,260,100,25);
    female.setBackground(Color.white);
    add(female);
    
    ButtonGroup genderbuttongroup=new ButtonGroup();
    genderbuttongroup.add(male);
        genderbuttongroup.add(female);

    
    
    JLabel email =new JLabel("Email address:");
    email.setFont(new Font("Osward",Font.BOLD,18));
    email.setBounds(100,300,300,30);
    add(email);
    
     emailTextField=new JTextField();
    emailTextField.setBounds(300,300,400,25);
    add(emailTextField);
    
    
     JLabel martial =new JLabel("Marital Status:");
    martial.setFont(new Font("Osward",Font.BOLD,18));
    martial.setBounds(100,340,300,30);
    add(martial);
    
     married=new JRadioButton("Married");
    married.setBounds(300,340,100,25);
    married.setBackground(Color.white);
    add(married);
    
     unmarried=new JRadioButton("Unmarried");
    unmarried.setBounds(400,340,100,25);
    unmarried.setBackground(Color.white);
    add(unmarried);
    
    ButtonGroup maritalbuttongroup=new ButtonGroup();
    maritalbuttongroup.add(married);
        maritalbuttongroup.add(unmarried);
    
    JLabel address =new JLabel("Address:");
    address.setFont(new Font("Osward",Font.BOLD,18));
    address.setBounds(100,380,300,30);
    add(address);
    
      addressTextField=new JTextField();
    addressTextField.setBounds(300,380,400,25);
    add(addressTextField);
    
    JLabel city =new JLabel("City");
    city.setFont(new Font("Osward",Font.BOLD,18));
    city.setBounds(100,420,300,30);
    add(city);
    
    
     cityTextField=new JTextField();
    cityTextField.setBounds(300,420,400,25);
    add(cityTextField);
    
    JLabel state =new JLabel("State:");
    state.setFont(new Font("Osward",Font.BOLD,18));
    state.setBounds(100,460,300,30);
    add(state);
    
     stateTextField=new JTextField();
    stateTextField.setBounds(300,460,400,25);
    add(stateTextField);
    
    JLabel pincode =new JLabel("Pincode:");
    pincode.setFont(new Font("Osward",Font.BOLD,18));
    pincode.setBounds(100,500,300,30);
    add(pincode);
    
     pincodeTextField=new JTextField();
    pincodeTextField.setBounds(300,500,400,25);
    add(pincodeTextField);
    
     Next=new JButton("Next");
    Next.setBounds(600,540,100,30);
    Next.setBackground(Color.BLACK);
    Next.setForeground(Color.white);
    Next.addActionListener(this);
    add(Next);
    
    
    
    
    
    
    getContentPane().setBackground(Color.WHITE);
    
    setSize(800,640);
    setVisible(true);
    setLocation(350,200);

    
}
    public void actionPerformed(ActionEvent ae){
            
        
        String name=nameTextField.getText();
            String ran=""+random;
            String fname=fnameTextField.getText();
            String address=addressTextField.getText();
            String email=emailTextField.getText();
            String city=cityTextField.getText();
            String dob=((JTextField) dobField.getDateEditor().getUiComponent()).getText();
            String pincode=pincodeTextField.getText();
            String state=stateTextField.getText();
            String gender=null;
            if(male.isSelected()){
                gender="Male";
            }
            else if(female.isSelected()){
                gender="Female";
                
            }

            String martial=null;
            if(married.isSelected()){
                martial="Married";
                
            }
            else if(unmarried.isSelected()){
                martial="Unmarried";
            }
            try{
                if(name.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Name is requuired");
                    
                    
                    
                }
                else{
                    Conn C=new Conn();
                    String query="insert into signup values('"+ran+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+martial+"','"+address+"', '"+city+"', '"+pincode+"', '"+state+"')";   
                    C.s.executeUpdate(query);
                    setVisible(false);
                    new signuptwo(ran).setVisible(true);
                }
            }
            catch(Exception e){
            System.out.println(e);
        }
    
    }
            
       public static void main(String args[]) {
        new signupone();
        
    }
}
