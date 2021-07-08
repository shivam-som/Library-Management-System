import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

class Admin_Registration extends JFrame
{
    Connection con=null;
    ResultSet rs=null;
    Statement st=null;
    
    Admin_Registration()
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
        //arrays of comboBox
        String[] day_arr = new String[32];
        day_arr[0]="Select";
        for(int i=1;i<=31;i++)
                day_arr[i] = Integer.toString(i);
        String[] month_arr = {"Select","Jan","Feb","Mar","Apr","May","June","July","Aug","Sep","Oct","Nov","Dec"};
        String[] year_arr = new String[71];
        year_arr[0]="Select";
        for(int i=1951;i<=2020;i++)
                year_arr[i-1950]= Integer.toString(i);
        //header
        JPanel heading;
        heading= new JPanel();
        heading.setBounds(0,0,1300,80);
        heading.setBackground(new Color(0,0,0,80));

        JLabel lr=new JLabel("Registration Form");
        lr.setBounds(550,30,150,50);
        lr.setFont(new Font("Elephant",Font.BOLD,40));
        lr.setForeground(Color.WHITE);
        heading.add(lr);

        //middle
        JPanel middle;
        middle= new JPanel();
        middle.setLayout(null);
        middle.setBounds(270,110,750,510);
        middle.setBackground(new Color(0,0,0,80));

        JLabel name = new JLabel("Name: ");
        name.setBounds(50,20,200,25);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Franklin Gothic Book",Font.BOLD,25));
        middle.add(name);
        JTextField t1 = new JTextField();
        t1.setBounds(280,20,200,25);
        t1.setFont(new Font("Consolas", Font.ITALIC, 20));
        middle.add(t1);

        JLabel mobile = new JLabel("Mobile No.: ");
        mobile.setBounds(50,70,200,25);
        mobile.setForeground(Color.WHITE);
        mobile.setFont(new Font("Franklin Gothic Book",Font.BOLD,25));
        middle.add(mobile);
        JTextField t2 = new JTextField();
        t2.setBounds(280,70,200,25);
        t2.setFont(new Font("Consolas", Font.ITALIC, 20));
        middle.add(t2);

        JLabel password = new JLabel("Password: ");
        password.setBounds(50,120,200,25);
        password.setForeground(Color.WHITE);
        password.setFont(new Font("Franklin Gothic Book",Font.BOLD,25));
        middle.add(password);
        JPasswordField p1 = new JPasswordField();
        p1.setBounds(280,120,200,25);
        p1.setFont(new Font("Consolas", Font.ITALIC, 20));
        middle.add(p1);

        JLabel dob = new JLabel("Date Of Birth: ");
        dob.setBounds(50,170,200,25);
        dob.setForeground(Color.WHITE);
        dob.setFont(new Font("Franklin Gothic Book",Font.BOLD,25));
        middle.add(dob);
        JComboBox day = new JComboBox(day_arr);
        day.setBounds(280,170,70,25);
        //day.setForeground(Color.WHITE);
        middle.add(day);
        JComboBox month = new JComboBox(month_arr);
        month.setBounds(370,170,70,25);
        //month.setForeground(Color.WHITE);
        middle.add(month);
        JComboBox year = new JComboBox(year_arr);
        year.setBounds(460,170,70,25);
        //year.setForeground(Color.WHITE);
        middle.add(year);

        JLabel gender = new JLabel("Gender: ");
        gender.setBounds(50,220,200,25);
        gender.setForeground(Color.WHITE);
        gender.setFont(new Font("Franklin Gothic Book",Font.BOLD,25));
        middle.add(gender);
        JRadioButton male = new JRadioButton("Male");
        male.setBounds(280,220,100,25);
        male.setFont(new Font("Franklin Gothic Book",Font.BOLD,18));
        middle.add(male);
        JRadioButton female = new JRadioButton("Female");
        female.setBounds(410,220,100,25);
        female.setFont(new Font("Franklin Gothic Book",Font.BOLD,18));
        middle.add(female);
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        JLabel address = new JLabel("Address: ");
        address.setBounds(50,270,200,25);
        address.setForeground(Color.WHITE);
        address.setFont(new Font("Franklin Gothic Book",Font.BOLD,25));
        middle.add(address);
        JTextArea ta = new JTextArea();
        ta.setFont(new Font("Consolas", Font.ITALIC, 20));
        ta.setBounds(280,270,350,50);
        middle.add(ta);

        JCheckBox cbx = new JCheckBox("  I Accept All Terms And Conditions");
        cbx.setBounds(50,360,450,25);
        cbx.setFont(new Font("Consolas", Font.ITALIC, 20));
        middle.add(cbx);

        JButton back =new JButton("Back");
        back.setBounds(100,450,150,40);
        back.setFont(new Font("Franklin Gothic Book",Font.BOLD,25));
        middle.add(back);

        JButton submit =new JButton("Register");
        submit.setBounds(300,450,150,40);
        submit.setFont(new Font("Franklin Gothic Book",Font.BOLD,25));
        middle.add(submit);

        JButton reset =new JButton("Reset");
        reset.setBounds(500,450,150,40);
        reset.setFont(new Font("Franklin Gothic Book",Font.BOLD,25));
        middle.add(reset);

        //background
        ImageIcon background_image=new ImageIcon("E:\\Ashu\\sixth.jpg");
        Image img =background_image.getImage();
        Image temp_img= img.getScaledInstance(1300,700,Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.setBounds(0,0,1300,700);
        add(background);

        background.add(heading);
        background.add(middle);

        back.addActionListener(new ActionListener()
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

        submit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                // Here next four lines are extra for showing that all deatils are filled or not
                if(t1.getText().equals("")||t2.getText()==""||p1.getText()==""||ta.getText()==""||day.getSelectedItem()=="Select"||month.getSelectedItem()=="Select"||year.getSelectedItem()=="Select")
                {
                    JOptionPane.showMessageDialog(null,"Please Enter All Details");
                }
                else
                {
                    if(cbx.isSelected()==true)
                    {
                        try 
                        {
            //              next three lines are only for gender radiobutton
                            String rb="Male";
                            if(female.isSelected())
                            {
                                rb="Female";
                            }
                            st=con.createStatement();
                            String s1="INSERT INTO Admin_Registration_Table(Name,Mobile,Password,Day,Month,Year,Gender,Address) VALUES('"+t1.getText()+"','"+t2.getText()+"','"+p1.getText()+"','"+day.getSelectedItem().toString()+"','"+month.getSelectedItem().toString()+"','"+year.getSelectedItem().toString()+"','"+rb+"','"+ta.getText()+"')";
                            String s2="INSERT INTO Admin_Login_Table(UserName,Password) VALUES('"+t1.getText()+"','"+p1.getText()+"')";
                            st.executeUpdate(s1);
                            st.executeUpdate(s2);

                            rs=st.executeQuery("SELECT * FROM Admin_Login_Table");
                            rs=st.executeQuery("SELECT * FROM Admin_Registration_Table");
                            while(rs.next())
                            System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8));
                            day.setSelectedItem("Select");
                            month.setSelectedItem("Select");
                            year.setSelectedItem("Select");
                            t1.setText("");
                            t2.setText("");
                            p1.setText("");
                            ta.setText("");
                            JOptionPane.showMessageDialog(null,"Succesfully Registered");
                        }
                        catch(HeadlessException | SQLException i){JOptionPane.showMessageDialog(null,i);}
                        Admin_Login lp = new Admin_Login();
                        lp.setSize(1300, 700);
                        lp.setVisible(true);
                        lp.setLayout(null);
                        lp.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Please Accept Terms and Conditions");
                    }
                }
            }
        });
        reset.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                t1.setText(null);
                t2.setText(null);
                p1.setText(null);
                ta.setText(null);
                day.setSelectedItem("Select");
                month.setSelectedItem("Select");
                year.setSelectedItem("Select");
                male.setSelected(true);
            }
        });
    }
    /*public static void main(String[] args)
    {
        Admin_Registration frame=new Admin_Registration();
        frame.setVisible(true);
        frame.setBounds(0,0,1300,700);
        frame.setTitle("Registration Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }*/
}