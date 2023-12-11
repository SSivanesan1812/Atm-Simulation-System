
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;



public class signuptwo extends JFrame implements ActionListener {
    String formno;
    JTextField pannumber,adharnumber;
    JButton Next;
    JDateChooser dobField;
    JRadioButton yes,no,yesa,noa;
    JComboBox religion,category,income,education,occupation;
            
    
    
signuptwo(String formno){
    this.formno=formno;
    setLayout(null);
    setTitle("signup page two");
    
    
    JLabel personaldetails =new JLabel("Page 2:personal details");
    personaldetails.setFont(new Font("Osward",Font.BOLD,22));
    personaldetails.setBounds(250,80,400,30);
    add(personaldetails);
    
    
    
    
    JLabel name =new JLabel("Relegion");
    name.setFont(new Font("Osward",Font.BOLD,18));
    name.setBounds(100,140,100,30);
    add(name);
    
    String[] religionlist={"Hindu","Christian","Muslim","Aethist"};
    religion=new JComboBox(religionlist);
    religion.setBounds(300,140,400,25);
    add(religion);
    
    JLabel fname =new JLabel("Categoty");
    fname.setFont(new Font("Osward",Font.BOLD,18));
    fname.setBounds(100,180,300,30);
    add(fname);
    
    String[] categorylist={"BC","OBC","SC","No clue"};
   category=new JComboBox(categorylist);
    category.setBounds(300,180,400,25);
    add(category);
    
    JLabel dob =new JLabel("Income");
    dob.setFont(new Font("Osward",Font.BOLD,18));
    dob.setBounds(100,220,300,30);
    add(dob);
    
    String[] incomelist={"null","high","low","infinite"};
   income=new JComboBox(incomelist);
    income.setBounds(300,220,400,25);
    add(income);
    
    JLabel gender =new JLabel("Education");
    gender.setFont(new Font("Osward",Font.BOLD,18));
    gender.setBounds(100,260,200,30);
    add(gender);
    
    String[] educationlist={"padikamethai","10th","12th","UG","PG"};
    education=new JComboBox(educationlist);
    education.setBounds(300,270,400,25);
    add(education);

    
    
    JLabel email =new JLabel("Qualification");
    email.setFont(new Font("Osward",Font.BOLD,18));
    email.setBounds(100,280,200,30);
    add(email);
    
   
    
    
     JLabel martial =new JLabel("Occupation");
    martial.setFont(new Font("Osward",Font.BOLD,18));
    martial.setBounds(100,340,300,30);
    add(martial);
    
    String[] occupationlist={"VIP","Underpaid","Overpaid","Underpayer","Overpayer"};
    occupation=new JComboBox(occupationlist);
    occupation.setBounds(300,340,400,25);
    add(occupation);
    
//     married=new JRadioButton("Married");
//    married.setBounds(300,340,100,25);
//    married.setBackground(Color.white);
//    add(married);
//    
//     unmarried=new JRadioButton("Unmarried");
//    unmarried.setBounds(400,340,100,25);
//    unmarried.setBackground(Color.white);
//    add(unmarried);
//    
//    ButtonGroup maritalbuttongroup=new ButtonGroup();
//    maritalbuttongroup.add(married);
//        maritalbuttongroup.add(unmarried);
    
    JLabel address =new JLabel("PAN Number");
    address.setFont(new Font("Osward",Font.BOLD,18));
    address.setBounds(100,380,300,30);
    add(address);
    
      pannumber=new JTextField();
    pannumber.setBounds(300,380,400,25);
    add(pannumber);
    
    JLabel city =new JLabel("Adhar number");
    city.setFont(new Font("Osward",Font.BOLD,18));
    city.setBounds(100,420,300,30);
    add(city);
    
    
     adharnumber=new JTextField();
    adharnumber.setBounds(300,420,400,25);
    add(adharnumber);
    
    JLabel state =new JLabel("Senior Citizen");
    state.setFont(new Font("Osward",Font.BOLD,18));
    state.setBounds(100,460,300,30);
    add(state);
    
     yes=new JRadioButton("Yes");
    yes.setBounds(300,460,100,25);
    yes.setBackground(Color.white);
    add(yes);
    
     no=new JRadioButton("No");
    no.setBounds(400,460,100,25);
    no.setBackground(Color.white);
    add(no);
    
    ButtonGroup maritalbuttongroup=new ButtonGroup();
    maritalbuttongroup.add(yes);
        maritalbuttongroup.add(no);
    
    JLabel pincode =new JLabel("Exisiting account");
    pincode.setFont(new Font("Osward",Font.BOLD,18));
    pincode.setBounds(100,500,300,30);
    add(pincode);
    
     yesa=new JRadioButton("Yes");
    yesa.setBounds(300,500,100,25);
    yesa.setBackground(Color.white);
    add(yesa);
    
     noa=new JRadioButton("No");
    noa.setBounds(400,500,100,25);
    noa.setBackground(Color.white);
    add(noa);
    
    ButtonGroup maritalbuttongroupa=new ButtonGroup();
    maritalbuttongroupa.add(yesa);
        maritalbuttongroupa.add(noa);
    
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
            String Religion=(String) religion.getSelectedItem();
            String ran=formno;
            String Category=(String) category.getSelectedItem();
            String Income=(String) income.getSelectedItem();
            String Education=(String) education.getSelectedItem();
            String Occupation=(String) occupation.getSelectedItem();
            String Pannumber=pannumber.getText();
            String Adharnumber=adharnumber.getText();

            String Scitizen=null;
            if(yes.isSelected()){
                Scitizen="is";
            }
            else if(no.isSelected()){
                Scitizen="no";
                
            }

            String Eaccount=null;
            if(yesa.isSelected()){
                Eaccount="is";
                
            }
            else if(noa.isSelected()){
                Eaccount="no";
            }
            try{
            if(Adharnumber.isEmpty()){
                JOptionPane.showMessageDialog(null,"Adharnumber is required");
            }
                    
                    
                    
                
                else{
                    Conn C=new Conn();
                    String query="insert into signuptwo values('"+ran+"', '"+Religion+"', '"+Category+"', '"+Income+"', '"+Education+"', '"+Occupation+"', '"+Pannumber+"','"+Adharnumber+"', '"+Scitizen+"', '"+Eaccount+"')";   
                    C.s.executeUpdate(query);
                                setVisible(false);
            new signupthree(ran).setVisible(true);
                }
            }
            catch(Exception e){
            System.out.println(e);
        }

    
    }
            
       public static void main(String args[]) {
        new signuptwo("");
        
    }
}
