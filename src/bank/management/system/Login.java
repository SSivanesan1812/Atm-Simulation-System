
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    JButton login,clear,signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
    setTitle("Automated Teller Macihine");
    
    setLayout(null);
    
    
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("./icons/logo.jpg"));
    Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel label=new JLabel(i3);
    label.setBounds(70,10,100,100);
    
    add(label);
    
    JLabel text =new JLabel("Welcome to the ATM");
    text.setFont(new Font("Osward",Font.BOLD,36));
    text.setBounds(200,40,400,40);
    add(text);
    
    JLabel cardno =new JLabel("Card No:");
    cardno.setFont(new Font("Osward",Font.BOLD,28));
    cardno.setBounds(150,140,400,40);
    add(cardno);
    
    JLabel pin =new JLabel("Pin:");
    pin.setFont(new Font("Osward",Font.BOLD,28));
    pin.setBounds(150,220,400,40);
    add(pin);
    
     cardTextField=new JTextField();
    cardTextField.setBounds(300,150,250,30);
    add(cardTextField);
    
     pinTextField=new JPasswordField();
    pinTextField.setBounds(300,220,250,30);
    add(pinTextField);
    
     login=new JButton("SIGN IN");
    login.setBounds(300,300,100,30);
    login.setBackground(Color.BLACK);
    login.setForeground(Color.white);
    login.addActionListener(this);
    add(login);
    
     clear=new JButton("CLEAR");
    clear.setBounds(430,300,100,30);
    clear.setBackground(Color.BLACK);
    clear.setForeground(Color.white);
        clear.addActionListener(this);

    add(clear);
    
      signup=new JButton("SIGN UP");
    signup.setBounds(300,350,230,30);
    signup.setBackground(Color.BLACK);
    signup.setForeground(Color.white);
        signup.addActionListener(this);

    add(signup);
    
    
    
    getContentPane().setBackground(Color.WHITE);
    
    setSize(800,450);
    setVisible(true);
    setLocation(350,200);
    
    
    
    
    
    }
    public  void actionPerformed(ActionEvent ae){
        if(ae.getSource()== clear){
            cardTextField.setText("");
            pinTextField.setText("");
            
        }
        else if(ae.getSource()==signup){
            
            setVisible(false);
            new signupone().setVisible(true);
        }
        else if(ae.getSource()==login){
            String cardno=cardTextField.getText();
            String pinno=pinTextField.getText();
            
            try{
                if(cardno.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Dont just click fill it");
                }
                
                Conn c=new Conn();
                String resultquery="Select * from login where cardno='"+cardno+"' and pinno='"+pinno+"'";
                ResultSet rs=c.s.executeQuery(resultquery);
                if(rs.next()){
                    setVisible(false);
                    new transaction(pinno).setVisible(true);
                    
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Credentials");
                }
                
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
   
    public static void main(String args[]) {
        new Login();
    }
}
