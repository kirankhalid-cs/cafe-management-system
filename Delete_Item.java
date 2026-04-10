package cafe.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Delete_Item extends JFrame implements ActionListener {
    JTable t;
    JButton bt1;
    JTextField tf1;
    JPanel p1, p2, p3;
    JLabel l1, l2;
    Font f, f1;
    String x[] = {"Item ID", "Source", "Item Name", "Employee username", "Employee Name", "Price"};
    String y[][] = new String[20][6];
    int i = 0;

    Delete_Item() {
        super("All items records");
        setSize(1480, 400);
        setLocation(0, 10);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f = new Font("MS UI Gothic", Font.BOLD, 17);

        try {
    ConnectionClass obj = new ConnectionClass();
    String q = "SELECT * FROM item";
    ResultSet rest = obj.stm.executeQuery(q);
    while (rest.next()) {
        y[i][0] = rest.getString("item_id");
        y[i][1] = rest.getString("source");
        y[i][2] = rest.getString("ItemName"); 
        y[i][3] = rest.getString("username");
        y[i][4] = rest.getString("name");
        y[i][5] = rest.getString("price");
        i++;
    }

   
    t = new JTable(y, x);
    t.setBackground(Color.BLACK);
    t.setForeground(Color.WHITE);
    t.setFont(f);

} catch (Exception ex) {
    ex.printStackTrace();
}

        t.setBackground(Color.BLACK);
        t.setForeground(Color.WHITE);
        t.setFont(f);

        JScrollPane js = new JScrollPane(t);
        
        f1 = new Font("Lucida Fax", Font.BOLD, 25);
        l1 = new JLabel("Delete Any Item");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont(f1);
        l1.setForeground(Color.YELLOW);
        
        l2 = new JLabel("Item ID");
        l2.setFont(f1);
        l2.setForeground(Color.GRAY);
        
        tf1 = new JTextField();
        bt1 = new JButton("Delete Item");
        bt1.setBackground(Color.BLACK);
        bt1.setForeground(Color.RED);
        
        bt1.setFont(f);
        tf1.setFont(f);
        bt1.addActionListener(this);
        
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1, 10, 10));
        p1.add(l1);
        
        p2 = new JPanel();
        p2.setLayout(new GridLayout(1, 3, 10, 10));
        p2.add(l2);
        p2.add(tf1);
        p2.add(bt1);
        
        p3 = new JPanel();
        p3.setLayout(new GridLayout(2, 1, 10, 10));
        p3.add(p1);
        p3.add(p2);
        
        p1.setBackground(Color.BLACK);
        p2.setBackground(Color.BLACK);
        p3.setBackground(Color.BLACK);
        
        add(p3, "South");
        add(js);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent arg) {
        if (arg.getSource() == bt1) {
            String item_id = tf1.getText();
            if (item_id.isEmpty()) {
                JOptionPane.showMessageDialog(null, "item_id should not be Empty");
            } else {
                try {
                    ConnectionClass obj = new ConnectionClass();
                    String q = "DELETE FROM item WHERE item_id='" + item_id + "'";
                    int res = obj.stm.executeUpdate(q);
                    if (res == 1) {
                        JOptionPane.showMessageDialog(null, "Your item detail data successfully deleted");
                        this.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Your item detail could not be successfully deleted");
                        this.setVisible(true);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Delete_Item();
    }
}
