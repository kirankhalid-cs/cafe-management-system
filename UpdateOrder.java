/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cafe.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Random;

public class UpdateOrder extends JFrame implements ActionListener 
{
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11;
    JButton bt1, bt2;
    JPanel p1, p2, p3;
    Choice ch1;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6,tf7,tf8,tf9,tf10;
    Font f, f1;
 UpdateOrder()
 {
    super("Update Order");
        setLocation(50, 10);
        setSize(800, 650);

        f = new Font("Arial", Font.BOLD, 25);
        f1 = new Font("Arial", Font.BOLD, 18);
        ch1 = new Choice();
        try {
            ConnectionClass obj = new ConnectionClass();
            String q = "SELECT DISTINCT OrderId FROM OrderItem";
            ResultSet rest = obj.stm.executeQuery(q);
            while (rest.next()) {
                ch1.add(rest.getString("OrderId"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        ch1.setFont(f1);
        l1 = new JLabel("Update Order");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont(f);

        l2 = new JLabel("Order ID");
        l3 = new JLabel("Source");
        l4 = new JLabel("Item Name");
        l5 = new JLabel("Username");
        l6 = new JLabel("Employee Name");
        l7 = new JLabel("One Item Price");
        l8 = new JLabel("Customer Name");
        l9 = new JLabel("Customer Phone");
        l10 = new JLabel("No of Items");
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);
        l7.setFont(f1);
        l8.setFont(f1);
        l9.setFont(f1);
        l10.setFont(f1);

        
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();
        tf6 = new JTextField();
        tf7 = new JTextField();
        tf8 = new JTextField();
        tf9 = new JTextField();
        tf10 = new JTextField();
        tf1.setFont(f1);
        tf2.setFont(f1);
        tf3.setFont(f1);
        tf4.setFont(f1);
        tf5.setFont(f1);
        tf6.setFont(f1);
        tf7.setFont(f1);
        tf8.setFont(f1);
        
        tf1.setEditable(false);
        tf2.setEditable(false);
        tf3.setEditable(false);
        tf4.setEditable(false);
        tf5.setEditable(false);
        tf6.setEditable(false);
        
        bt1 = new JButton("Update Order");
        bt2 = new JButton("Back");

        bt1.setFont(f1);
        bt2.setFont(f1);

        bt1.setForeground(Color.WHITE);
        bt2.setForeground(Color.WHITE);

        bt1.setBackground(Color.BLACK);
        bt2.setBackground(Color.RED);
        
        bt1.setFont(f1);
        bt2.setFont(f1);
        
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1, 10, 10));
        p1.add(l1);

       
        p2 = new JPanel(new GridLayout(11, 2, 10, 10));
        p2.add(l2); 
        p2.add(ch1);
        p2.add(l3);
        p2.add(tf1);
        p2.add(l4);
        p2.add(tf2);
        p2.add(l5);
        p2.add(tf3);
        p2.add(l6);
        p2.add(tf4);
        p2.add(l7); 
        p2.add(tf5);
        p2.add(l8);
        p2.add(tf6);
        p2.add(l9); 
        p2.add(tf7);
        p2.add(l10); 
        p2.add(tf8);
        p2.add(bt1); 
        p2.add(bt2);
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Restaurant Management/Icon/veg.png"));
        Image i1 = img.getImage().getScaledInstance(370, 350, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i1);
        l11 = new JLabel(img1);
        p3 = new JPanel();
        p3.setLayout(new GridLayout(1, 1, 10, 10));
        p3.add(l11);

        setLayout(new BorderLayout(10, 10));
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.WEST);
        ch1.addMouseListener(new MouseAdapter()
        {
           @Override 
           public void mouseClicked(MouseEvent arg0)
           {  try{
                  ConnectionClass obj =new ConnectionClass(); 
                  String orderid=ch1.getSelectedItem();
                  String q1="select* from OrderItem where OrderId= '"+orderid+"'";
                  ResultSet rest1 =obj.stm.executeQuery(q1);
                  while(rest1.next())
                  {
                      tf1.setText(rest1.getString("Source"));
                      tf2.setText(rest1.getString("ItemName"));
                      tf3.setText(rest1.getString("Username"));
                      tf4.setText(rest1.getString("name"));
                      tf5.setText(rest1.getString("price"));
                      tf6.setText(rest1.getString("customer_name"));
                      tf7.setText(rest1.getString("customer_phone"));
                      tf8.setText(rest1.getString("quantity"));
                      
                  }
                }
             catch(Exception exx)
             {
                 exx.printStackTrace();
             }
           }
        });
 }   
public void actionPerformed (ActionEvent e)
{
    if(e.getSource() == bt1)
    {
        String order_Id = ch1.getSelectedItem();
            String source = tf1.getText();
            String item_name = tf2.getText();
            String username = tf3.getText();
            String name = tf4.getText();
            String price = tf5.getText();
            String cname = tf6.getText();
            String phone = tf7.getText();
            String qnt= tf8.getText();
            String total_price = (Integer.parseInt(qnt)*Integer.parseInt(price))+"" ;
            
            try{
                  ConnectionClass obj =new ConnectionClass(); 
                  
                  String q1="update OrderItem set customer_phone='"+phone+"',quantity='"+qnt+"',total='"+total_price+"'where OrderId= '"+order_Id+"'";
                  int aa=obj.stm.executeUpdate(q1);
                  if(aa==1)
                  {
                      JOptionPane.showMessageDialog(null,"Your data successfully updated");
                      this.setVisible(false);
                  }
                  else{
                      JOptionPane.showMessageDialog(null,"Your data could not updated");
                  }
               
                }
             catch(Exception exx)
             {
                 exx.printStackTrace();
             }
    }
    if(e.getSource() == bt2)
    {
        this.setVisible(false);
    }
}
    public static void main(String[] args)
    {
        new UpdateOrder().setVisible(true);
    }
}