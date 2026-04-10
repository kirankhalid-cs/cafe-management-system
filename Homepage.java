package cafe.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Homepage extends JFrame implements ActionListener {

    JLabel L1;
    Font f, f1;

    public Homepage() {
        super("Restaurant Management Home Page for Employee");
        setLocation(0, 0);
        setSize(1280, 780);

        f = new Font("Arial", Font.BOLD, 20);
        f1 = new Font("Arial", Font.BOLD, 35);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("cafe/management/system/icon/add_employee.jpeg"));
        Image i1 = img.getImage().getScaledInstance(1280, 780, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i1);
        L1 = new JLabel(img1);

        JMenuBar m1 = new JMenuBar();
        JMenu menu1 = new JMenu("Menu Item");
        JMenu menu2 = new JMenu("Manage Order");
        JMenu menu3 = new JMenu("Bill");
        JMenu menu4 = new JMenu("About");

        menu1.setFont(f1);
        menu2.setFont(f1);
        menu3.setFont(f1);
        menu4.setFont(f1);

        JMenuItem mt1 = new JMenuItem("Add items");
        JMenuItem mt2 = new JMenuItem("Delete item");
        JMenuItem mt3 = new JMenuItem("Create Order ");
        JMenuItem mt4 = new JMenuItem("Update Order");
        JMenuItem mt5 = new JMenuItem("Delete Order");
        JMenuItem mt6 = new JMenuItem("Check Bill");
        JMenuItem mt7 = new JMenuItem("Update Bill");
        JMenuItem mt8 = new JMenuItem("About ");
        JMenuItem mt9 = new JMenuItem("Exit");

        mt1.setFont(f);
        mt2.setFont(f);
        mt3.setFont(f);
        mt4.setFont(f);
        mt5.setFont(f);
        mt6.setFont(f);
        mt7.setFont(f);
        mt8.setFont(f);
        mt9.setFont(f);

        menu1.add(mt1);
        menu1.add(mt2);
        menu2.add(mt3);
        menu2.add(mt4);
        menu2.add(mt5);
        menu3.add(mt6);
        menu3.add(mt7);
        menu4.add(mt8);
        menu4.add(mt9);

        m1.add(menu1);
        m1.add(menu2);
        m1.add(menu3);
        m1.add(menu4);
        
        m1.setBackground(Color.BLACK);
        
        menu1.setForeground(Color.GRAY);
        menu2.setForeground(Color.GRAY);
        menu3.setForeground(Color.GRAY);
        menu4.setForeground(Color.GRAY);
        
        mt1.setForeground(Color.YELLOW);
        mt1.setBackground(Color.BLACK);
        
        mt2.setForeground(Color.YELLOW);
        mt2.setBackground(Color.BLACK);
        
        mt3.setForeground(Color.YELLOW);
        mt3.setBackground(Color.BLACK);
        mt4.setForeground(Color.YELLOW);
        mt4.setBackground(Color.BLACK);
        mt5.setForeground(Color.YELLOW);
        mt5.setBackground(Color.BLACK);
        
        mt6.setForeground(Color.YELLOW);
        mt6.setBackground(Color.BLACK);
        mt7.setForeground(Color.YELLOW);
        mt7.setBackground(Color.BLACK);
        
        mt8.setForeground(Color.YELLOW);
        mt8.setBackground(Color.BLACK);
        mt9.setForeground(Color.YELLOW);
        mt9.setBackground(Color.BLACK);
        
        mt1.addActionListener(this);
        mt2.addActionListener(this);
        mt3.addActionListener(this);
        mt4.addActionListener(this);
        mt5.addActionListener(this);
        mt6.addActionListener(this);
        mt7.addActionListener(this);
        mt8.addActionListener(this);
        mt9.addActionListener(this);
        
        setJMenuBar(m1);
        add(L1);
    }

    public void actionPerformed(ActionEvent e) {
        String cmnd = e.getActionCommand();

        if (cmnd.equals(("Add Items"))) {
            new Add_Items().setVisible(true);
        }
        if (cmnd.equals(("Delete Item"))) {
            new Delete_Item().setVisible(true);}
         if (cmnd.equals("Create Order")) {
            new CreateOrder().setVisible(true);
        }
        if (cmnd.equals(("Update Order"))) {
            new Delete_Item().setVisible(true);
        }
        if (cmnd.equals(("Delete Order"))) {
            new Delete_Item().setVisible(true);
        }
        if (cmnd.equals(("Check Bill"))) {
            new Delete_Item().setVisible(true);
        }
        if (cmnd.equals(("Update Bill"))) {
            new Delete_Item().setVisible(true);
        }
        if (cmnd.equals(("About"))) {
            new Delete_Item().setVisible(true);
        }
        if (cmnd.equals(("Exit"))) {
            System.exit(0);
        }
    }
   
    public static void main(String[] args) {
        new Homepage().setVisible(true);
    }
} 