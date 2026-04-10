
package cafe.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener
{
    JFrame f;
    JLabel l1, l2, l3, l4;
    JButton bt1, bt2;
    JTextField tf1;
    JPasswordField pf1;
    
    Login()
    {
        f=new JFrame("Login Account");
        f.setBackground(Color.WHITE);
        f.setLayout(null);
        
        l1=new JLabel();
        l1.setBounds(0,0,580,350);
        l1.setLayout(null);
      ImageIcon img =new ImageIcon(ClassLoader.getSystemResource("cafe/management/system/icon/login2.jpg"));
        
      Image i1=img.getImage().getScaledInstance(580, 350, Image.SCALE_SMOOTH);
      ImageIcon img1=new ImageIcon(i1);
      l1.setIcon(img1);
      
      l2=new JLabel("Login Account");
      l2.setBounds(190,30,500,50);
      l2.setFont(new Font("Arial",Font.BOLD,30));
      l2.setForeground(Color.BLACK);
      l1.add(l2);
      f.add(l1);
      
      l3=new JLabel("Username:");
      l3.setBounds(120,120,150,30);
      l3.setForeground(Color.WHITE);
      l3.setFont(new Font("Arial",Font.BOLD,20));
      l1.add(l3);
      
      tf1=new JTextField();
      tf1.setBounds(320,120,150,30);
      l1.add(tf1);
      
      l4=new JLabel("Password:");
      l4.setBounds(120,170,150,30);
      l4.setForeground(Color.WHITE);
      l4.setFont(new Font("Arial",Font.BOLD,20));
      l1.add(l4);
      
      pf1=new JPasswordField();
      pf1.setBounds(320,170,150,30);
      l1.add(pf1);
      
      bt1=new JButton("Login");
      bt1.setBackground(Color.BLACK);
      bt1.setForeground(Color.WHITE);
      bt1.setBounds(120,220,150,40);
      l1.add(bt1);
      
      bt2=new JButton("Back");
      bt2.setBackground(Color.RED);
      bt2.setForeground(Color.WHITE);
      bt2.setBounds(320,220,150,40);
      l1.add(bt2);
      
      bt1.addActionListener(this);
      bt2.addActionListener(this);
      f.setVisible(true);
      f.setSize(580,350);
      f.setLocation(300,100);
      f.setResizable(false);
      
      
            }
 public void actionPerformed(ActionEvent e)
    {  
      if(e.getSource()==bt1)
      {
        try
        {
          ConnectionClass obj =new ConnectionClass();
          String username =tf1.getText();
          String pass =pf1.getText();
          String q= "select* from employee where username'"+username+"'and password'"+pass+"'";
          ResultSet rest=obj.stm.executeQuery(q);
          if(username.equals(" "));
          {
           JOptionPane.showMessageDialog(null, "Username cannot be empty. Please enter your username.");
           f.setVisible(false);
           f.setVisible(true);
          }
          if(rest.next())
          {
            JOptionPane.showMessageDialog(null, "You have successfully loged in.");
            f.setVisible(false);
           // new HomePage().setVisible(true);
          }
          else
          {
           JOptionPane.showMessageDialog(null, "You have entered wrong username and password.");
           f.setVisible(false);
           f.setVisible(true);
          }  
        }
        catch(Exception ex)
        {
        
        }
      }
      if(e.getSource()==bt2)
      {
          f.setVisible(false);
          
      }   
    } 
    public static void main(String[] args)
    {
        new Login();
    }
 }