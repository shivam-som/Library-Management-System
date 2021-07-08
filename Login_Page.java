
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

class Login_Page extends JFrame{
    Connection con;
    ResultSet rs;
    Statement st;
    PreparedStatement pst = null;
    PreparedStatement cst = null;

Login_Page() {
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

//font
        Font f= new Font("Times New Roman", Font.BOLD, 50);

//header
        JPanel heading;
        heading = new JPanel();
        heading.setLayout(null);
    //heading.setBackground(Color.RED);
        heading.setBackground(new Color(0, 0, 0, 80));
        heading.setBounds(0, 0, 1300, 150);
        
        ImageIcon left_icon = new ImageIcon("E:\\Ashu\\1st.jpeg");
        Image img1 = left_icon.getImage();
        Image temp_img1 = img1.getScaledInstance(200, 150, Image.SCALE_SMOOTH);
        left_icon= new ImageIcon(temp_img1);
        JLabel label_icon= new JLabel("", left_icon, JLabel.CENTER);
        label_icon.setBounds(30,10,200,150);
        heading.add(label_icon);
        
        JLabel name = new JLabel("-:Librarian Login:-");
        name.setBounds(450, 50, 500, 60);
        name.setForeground(Color.WHITE);
        name.setFont(f);
        heading.add(name);

//middle panel
        JPanel login = new JPanel();
        login.setLayout(null);
        login.setSize(410, 350);
        login.setBackground(new Color(204, 204, 204,100));
        login.setBounds(450, 200, 410, 350);
        
        ImageIcon user_icon = new ImageIcon("E:\\Ashu\\usericon.jpg");
        Image img2 = user_icon.getImage();
        Image temp_img2 = img2.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        user_icon= new ImageIcon(temp_img2);
        JLabel user_icon1= new JLabel("", user_icon, JLabel.CENTER);
        user_icon1.setBounds(30,50,50,50);
        login.add(user_icon1);
        JTextField username = new JTextField();
        username.setBounds(80, 50, 300, 50);
    //username.setOpaque(false);
    //username.setForeground(Color.WHITE);
        username.setBackground(new Color(210, 180, 140));
    //username.setBackground(new Color(210,180,140,50));
        login.add(username);

        ImageIcon user_pass = new ImageIcon("E:\\Ashu\\userpass.jpg");
        Image img3 = user_pass.getImage();
        Image temp_img3 = img3.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        user_pass= new ImageIcon(temp_img3);
        JLabel user_pass1= new JLabel("", user_pass, JLabel.CENTER);
        user_pass1.setBounds(30,150,50,50);
        login.add(user_pass1);
        JPasswordField password = new JPasswordField();
        password.setBounds(80, 150, 300, 50);
    //password.setOpaque(false);
    //password.setForeground(Color.WHITE);
        password.setBackground(new Color(210, 180, 140));
    //password.setBackground(new Color(210,180,140,50));
        login.add(password);
        
        JButton signup = new JButton("Sign Up");
        signup.setBounds(50, 250, 100, 50);
        signup.setBackground(new Color(51, 153, 255));
    //signup.setBackground(new Color(100,12,45));
        login.add(signup);

        JButton logup = new JButton("Login");
        logup.setBounds(250, 250, 100, 50);
        logup.setBackground(new Color(51, 153, 255));
        login.add(logup);

        ImageIcon back_icon = new ImageIcon("E:\\Ashu\\exit2.jpg");
        Image img4 = back_icon.getImage();
        Image temp_img4 = img4.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        back_icon= new ImageIcon(temp_img4);
        JButton back_button= new JButton(back_icon);
        back_button.setBounds(35,530,100,100);
        add(back_button);
        
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

signup.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        Registration_Form rf = new Registration_Form();
            rf.setSize(1300, 700);
            rf.setVisible(true);
            rf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    });

logup.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e)
    {                 
        String user=username.getText();
        String pass=password.getText();
        try{
            String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
            Class.forName(driver);
            Connection con=DriverManager.getConnection("jdbc:ucanaccess://E:\\Ashu/MyLogin.accdb");
            String sql="Select * from Login_Table where UserName=? and Password=?";
            pst=con.prepareStatement(sql);
            pst.setString(1,user);
            pst.setString(2,pass);
            rs=pst.executeQuery();
            rs.next();
            if(user.contains(rs.getString("UserName"))&& pass.contains(rs.getString("Password")));
            {
                Library_Management lm = new Library_Management();
                lm.setSize(1300, 700);
                lm.setVisible(true);
                lm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                username.setText(null);
//                password.setText(null);  
            }
        }
        catch(Exception aa)
        {
            JOptionPane.showMessageDialog(null,"Invalid Login Details","Login Error",JOptionPane.ERROR_MESSAGE);
        }
        username.setText(null);
        password.setText(null);
    }
});

back_button.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e)
    {
        first lp = new first();
        lp.setSize(1300, 700);
        lp.setVisible(true);
        lp.setLayout(null);
        lp.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
});

}
    /*public static void main(String[] args) {
        Login_Page lp = new Login_Page();
        lp.setSize(1300, 700);
        lp.setVisible(true);
        lp.setLayout(null);
        lp.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }*/
}