package cafe.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Indexpage extends JFrame implements ActionListener {

    JLabel L1, L2, L3, L4;
    JButton bt1, bt2;
    JPanel p1, p2, p3;
    Font f, f1;

    Indexpage() {
        super("Index Page");
        setLocation(450, 250);
        setSize(500, 300);
        f = new Font("Arial", Font.BOLD, 15);
        f1 = new Font("Arial", Font.BOLD, 20);

      
        L1 = new JLabel("Cafe Management");
        L2 = new JLabel("Admin Login");
        L3 = new JLabel("Employee Login");

        L1.setHorizontalAlignment(JLabel.CENTER);
        L1.setFont(f1);
        L2.setFont(f);
        L3.setFont(f);

    
        bt1 = new JButton("Login");
        bt2 = new JButton("Login");
        bt1.setFont(f);
        bt2.setFont(f); // Fixed: Set font for bt2

        bt1.addActionListener(this);
        bt2.addActionListener(this);

        
        ImageIcon ic = null;
        try {
            ic = new ImageIcon(ClassLoader.getSystemResource("cafe/management/system/icon/index2.jpeg")); // Ensure "index2.jpeg" is in the correct folder
        } catch (Exception e) {
            System.out.println("Image not found");
        }

        if (ic != null) {
            Image img = ic.getImage().getScaledInstance(200, 250, Image.SCALE_SMOOTH);
            ImageIcon ic1 = new ImageIcon(img);
            L4 = new JLabel(ic1);
        } else {
            L4 = new JLabel("No Image"); // Fallback if image not found
        }

  
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1, 10, 10));
        p1.add(L1);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(1, 1, 10, 10));
        p2.add(L4);

        p3 = new JPanel();
        p3.setLayout(new GridLayout(2, 2, 10, 10));
        p3.add(L2);
        p3.add(bt1);
        p3.add(L3);
        p3.add(bt2);

       
        p1.setBackground(Color.PINK);
        p2.setBackground(Color.LIGHT_GRAY);
        p3.setBackground(Color.WHITE);

     
        setLayout(new BorderLayout(10, 10));
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.WEST);
        add(p3, BorderLayout.CENTER);

        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt1) {
            this.setVisible(false); // Fixed: Corrected method name
            new AdminSection().setVisible(true);
        }
        if (e.getSource() == bt2) {
            System.out.println("Employee Login");
        }
    }

    public static void main(String[] args) {
        new Indexpage().setVisible(true);
    }
}
