package cafe.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AdminSection extends JFrame implements ActionListener {
    JLabel l1, l2;
    JButton bt1, bt2, bt3, bt4;
    JPanel p1, p2;
    Font f, f1;

    AdminSection() {
        super("Admin section");
        setSize(450, 250);
        setLocation(400, 270);
        
        f = new Font("MS UI Gothic", Font.BOLD, 20);
        f1 = new Font("MS UI Gothic", Font.BOLD, 15);

        l1 = new JLabel("Admin home page");
        l1.setHorizontalAlignment(JLabel.CENTER);
        
        bt1 = new JButton("Add Employee");
        bt2 = new JButton("Update Employee");
        bt3 = new JButton("Edit Employee");
        bt4 = new JButton("Logout");
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);
        bt4.addActionListener(this);
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("cafe/management/system/icon/add_employee.jpeg"));
        Image i1 = img.getImage().getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i1);
        l2 = new JLabel(img1);
        
        l1.setFont(f);
        bt1.setFont(f1);
        bt2.setFont(f1);
        bt3.setFont(f1);
        bt4.setFont(f1);
       
        p1 = new JPanel();
        p1.setLayout(new GridLayout(5, 1, 10, 10));
        p1.add(l1);
        p1.add(bt1);
        p1.add(bt2);
        p1.add(bt3);
        p1.add(bt4);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(1, 1, 10, 10));
        p2.add(l2);
        
        setLayout(new BorderLayout(10, 10));
        add(p1, "Center");
        add(p2, "East");
    }

    public void actionPerformed(ActionEvent arg) {
        if (arg.getSource() == bt1) {
            new Add_Employee();
        }
        
        if (arg.getSource() == bt2) {
            new Update_Employee();
        }
        if (arg.getSource() == bt3) {
            new Delete_Employee().setVisible(true);
        }
        if (arg.getSource() == bt4) {
            this.setVisible(false);
            new Indexpage().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new AdminSection().setVisible(true);
    }
}
 