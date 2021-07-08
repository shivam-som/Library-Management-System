import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

class Admin_Management extends JFrame
{   
    Admin_Management()
    {
        //header
        JPanel heading;
        heading= new JPanel();
        heading.setBounds(0,0,1300,100);
        heading.setLayout(null);
        heading.setBackground(new Color(0,0,0,80));

        ImageIcon left_icon = new ImageIcon("E:\\Ashu\\adminSection.jpg");
        Image img1 = left_icon.getImage();
        Image temp_img1 = img1.getScaledInstance(250, 100, Image.SCALE_SMOOTH);
        left_icon= new ImageIcon(temp_img1);
        JLabel label_icon= new JLabel("", left_icon, JLabel.CENTER);
        label_icon.setBounds(0,0,250,100);
        heading.add(label_icon);

        JLabel lr=new JLabel("-:Admin's Management:-");
        lr.setBounds(385,20,550,50);
        lr.setFont(new Font("Elephant",Font.BOLD,40));
        lr.setForeground(Color.WHITE);
        heading.add(lr);
        
        //middle Panel
        JPanel middle;
        middle= new JPanel();
        middle.setLayout(null);
        middle.setBounds(400,130,500,500);
        middle.setBackground(new Color(0,0,0,80));

        JButton add_librarian =new JButton("Add Librarian");
        add_librarian.setBounds(120,40,250,65);
        add_librarian.setFont(new Font("Franklin Gothic Book",Font.BOLD,25));
        add_librarian.setBackground(new Color(255,255,153));
        middle.add(add_librarian);

        JButton remove_librarian =new JButton("Remove Librarian");
        remove_librarian.setBounds(120,160,250,65);
        remove_librarian.setFont(new Font("Franklin Gothic Book",Font.BOLD,25));
        remove_librarian.setBackground(new Color(255,255,153));
        middle.add(remove_librarian);

        JButton view_librarian =new JButton("View Librarian");
        view_librarian.setBounds(120,280,250,65);
        view_librarian.setFont(new Font("Franklin Gothic Book",Font.BOLD,25));
        view_librarian.setBackground(new Color(255,255,153));
        middle.add(view_librarian);

        JButton logout =new JButton("Logout");
        logout.setBounds(120,400,250,65);
        logout.setFont(new Font("Franklin Gothic Book",Font.BOLD,25));
        logout.setBackground(new Color(255,255,153));
        middle.add(logout);
        
        add_librarian.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Add_Librarian frame=new Add_Librarian();
                frame.setVisible(true);
                frame.setBounds(0,0,1300,700);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }	
        });
        remove_librarian.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                
            }	
        });
        view_librarian.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                View_Librarian vbook=new View_Librarian();
                vbook.setVisible(true);
                vbook.setBounds(0,0,1300,700);
                vbook.setTitle("-:Books Availability Information:-");
                vbook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }	
        });
        logout.addActionListener(new ActionListener()
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
        
        //icon buttons
        ImageIcon add_icon1 = new ImageIcon("E:\\Ashu\\addLibrarian.jpg");
        Image icon1 = add_icon1.getImage();
        Image temp_icon1 = icon1.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        add_icon1= new ImageIcon(temp_icon1);
        JButton add_icon= new JButton(add_icon1);
        add_icon.setBounds(100,130,200, 200);
        add(add_icon);
        add_icon.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Add_Librarian frame=new Add_Librarian();
                frame.setVisible(true);
                frame.setBounds(0,0,1300,700);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });   
        ImageIcon delete_icon1 = new ImageIcon("E:\\Ashu\\removeLibrarian.png");
        Image icon2 = delete_icon1.getImage();
        delete_icon1= new ImageIcon(icon2.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
        JButton delete_icon= new JButton(delete_icon1);
        delete_icon.setBounds(1000,130,200, 200);
        add(delete_icon);
        delete_icon.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                
            }
        });
        ImageIcon view_icon1 = new ImageIcon("E:\\Ashu\\viewLibrarian.jpg");
        Image icon3 = view_icon1.getImage();
        view_icon1= new ImageIcon(icon3.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
        JButton view_icon= new JButton(view_icon1);
        view_icon.setBounds(100,420,200, 200);
        add(view_icon);
        view_icon.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                View_Librarian vbook=new View_Librarian();
                vbook.setVisible(true);
                vbook.setBounds(0,0,1300,700);
                vbook.setTitle("-:Books Availability Information:-");
                vbook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
        ImageIcon logout_icon1 = new ImageIcon("E:\\Ashu\\logoutLibrarian.jpg");
        Image icon4 = logout_icon1.getImage();
        Image temp_icon2 = icon4.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        logout_icon1= new ImageIcon(temp_icon2);
        JButton logout_icon= new JButton(logout_icon1);
        logout_icon.setBounds(1000,420,200, 200);
        add(logout_icon);
        logout_icon.addActionListener(new ActionListener()
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
        
        //background
        ImageIcon background_image=new ImageIcon("E:\\Ashu\\fourth.jpg");
        Image img =background_image.getImage();
        Image temp_img= img.getScaledInstance(1300,700,Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.setBounds(0,0,1300,700);
        add(background);

        background.add(heading);
        background.add(middle);
    }
    /*public static void main(String[] args)
    {
        Admin_Management frame1=new Admin_Management();
        frame1.setVisible(true);
        frame1.setBounds(0,0,1300,700);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }*/
}