import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class first extends JFrame
{
    Connection con;
    Statement st;
    ResultSet rst;
    PreparedStatement pst;
    
    first()
    {
        try
        {
            String url="jdbc:ucanaccess://E:\\Ashu\\MyLogin.accdb";
            con=DriverManager.getConnection(url);
           //rs=st.executeQuery("select * from Register");

        }
        catch(SQLException e)
        {
             JOptionPane.showMessageDialog(null,e);
        }
        Font f=new Font("Engravers MT",Font.BOLD,30);
        
        //heading
        JPanel heading;
        heading = new JPanel();
        heading.setLayout(null);
        heading.setBackground(new Color(0, 0, 0, 80));
        heading.setBounds(0, 0, 1300, 150);
        
        ImageIcon left_icon = new ImageIcon("E:\\Ashu\\1st.jpeg");
        Image img1 = left_icon.getImage();
        Image temp_img1 = img1.getScaledInstance(200, 150, Image.SCALE_SMOOTH);
        left_icon= new ImageIcon(temp_img1);
        JLabel label_icon= new JLabel("", left_icon, JLabel.CENTER);
        label_icon.setBounds(30,10,200,150);
        heading.add(label_icon);
        
        JLabel name = new JLabel("-:Library Management System:-");
        name.setBounds(300, 50, 770, 60);
        name.setForeground(Color.WHITE);
        name.setFont(f);
        heading.add(name);

        //middle panel
        JPanel login = new JPanel();
        login.setLayout(null);
        login.setSize(410, 350);
        login.setBackground(new Color(10,10,155,50));
        login.setBounds(220, 210, 860, 400);
        
        //background
        ImageIcon background_image = new ImageIcon("E:\\Ashu\\fifth.jpg");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(1300, 700, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);

        background.add(login);
        background.add(heading);
        background.setBounds(0, 0, 1300, 700);
        add(background);
        
        JButton admin = new JButton("Admin Login");
        admin.setBounds(50, 280, 300, 50);
        admin.setFont(new Font("Engravers MT",Font.BOLD,20));
        //admin.setBackground(new Color(25, 255, 25));
        login.add(admin);
        
        JButton librarian= new JButton("Librarian Login");
        librarian.setBounds(510, 280, 300, 50);
        librarian.setFont(new Font("Engravers MT",Font.BOLD,20));
        //librarian.setBackground(new Color(25, 255, 25));
        login.add(librarian);
        
        ImageIcon adminIcon=new ImageIcon("E:\\Ashu\\f1.jpg");
        Image ad1=adminIcon.getImage();
        Image ad2=ad1.getScaledInstance(220,180,Image.SCALE_SMOOTH);
        adminIcon = new ImageIcon(ad2);
        JButton adminButton = new JButton(adminIcon);
        adminButton.setBounds(80,80,220,180);
        login.add(adminButton);
        
        ImageIcon lbIcon=new ImageIcon("E:\\Ashu\\f3.jpg");
        Image lb1=lbIcon.getImage();
        Image lb2=lb1.getScaledInstance(220,180,Image.SCALE_SMOOTH);
        lbIcon = new ImageIcon(lb2);
        JButton lbButton = new JButton(lbIcon);
        lbButton.setBounds(550,80,220,180);
        login.add(lbButton);
        
        ImageIcon exit_icon = new ImageIcon("E:\\Ashu\\exiticon.jpeg");
        Image img4 = exit_icon.getImage();
        Image temp_img4 = img4.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        exit_icon= new ImageIcon(temp_img4);
        JButton exit_button= new JButton(exit_icon);
        exit_button.setBounds(20,560,80,80);
        background.add(exit_button);
        
        admin.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                Admin_Login lp = new Admin_Login();
                lp.setSize(1300, 700);
                lp.setVisible(true);
                lp.setLayout(null);
                lp.setDefaultCloseOperation(EXIT_ON_CLOSE);
            }
        });
        
        librarian.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                Login_Page lp = new Login_Page();
                lp.setSize(1300, 700);
                lp.setVisible(true);
                lp.setLayout(null);
                lp.setDefaultCloseOperation(EXIT_ON_CLOSE);
            }
        });
        adminButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                Admin_Login lp = new Admin_Login();
                lp.setSize(1300, 700);
                lp.setVisible(true);
                lp.setLayout(null);
                lp.setDefaultCloseOperation(EXIT_ON_CLOSE);
            }
        });
        
        lbButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                Login_Page lp = new Login_Page();
                lp.setSize(1300, 700);
                lp.setVisible(true);
                lp.setLayout(null);
                lp.setDefaultCloseOperation(EXIT_ON_CLOSE);
            }
        });
        
        exit_button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        
    }
    public static void main(String[] args)
    {
        first lp = new first();
        lp.setSize(1300, 700);
        lp.setVisible(true);
        lp.setLayout(null);
        lp.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
