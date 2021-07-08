import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Notify_Return extends JFrame
{
Notify_Return()
{
//font
Font f=new Font("Times New Roman", Font.BOLD, 30);


//header
JPanel heading ;
heading = new JPanel();
heading.setLayout(null);
//heading.setBackground(Color.RED);
heading.setBackground(new Color(0,0,0,80));
heading.setBounds(0,0,1300,150);
JLabel name = new JLabel("Notification");
name.setBounds(560,50,200,50);
name.setForeground(Color.WHITE);
name.setFont(f);
heading.add(name);


//middle panel
JPanel login= new JPanel();
login.setLayout(null);
login.setSize(550,350);
login.setBackground(new Color(0,0,0,60));
login.setBounds(380,200,550,350);

JLabel l1= new JLabel("Book Returned Successfully ");
l1.setBounds(100,100,450,50);
//username.setOpaque(false);
l1.setForeground(Color.WHITE);
l1.setFont(new Font("Times New Roman", Font.BOLD, 33));
//username.setBackground(new Color(210,180,140));
//username.setBackground(new Color(210,180,140,50));
login.add(l1);

JButton back_button = new JButton("Back");
back_button.setBounds(20,270,150,50);
//password.setOpaque(false);
back_button.setBackground(new Color(210,180,140));
back_button.setFont(new Font("Times New Roman", Font.BOLD, 30));
//back_button.setBackground(new Color(210,180,140,50));
login.add(back_button);

JButton new_record = new JButton("Do it Again");
new_record.setBounds(320,270,200,50);
new_record.setBackground(new Color(210,180,140));
new_record.setFont(new Font("Times New Roman", Font.BOLD, 30));
//new_record.setBackground(new Color(51,153,255));
//signup.setBackground(new Color(100,12,45));
login.add(new_record);

    ImageIcon exit_icon = new ImageIcon("E:\\Ashu\\exit2.jpg");
    Image img4 = exit_icon.getImage();
    Image temp_img4 = img4.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
    exit_icon= new ImageIcon(temp_img4);
    JButton exit_button= new JButton(exit_icon);
    exit_button.setBounds(20,560,80,80);
    add(exit_button);
            exit_button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
            });

//background
ImageIcon background_image= new ImageIcon("E:\\Ashu\\eighth.jpg");
Image img =background_image.getImage();
Image temp_img = img.getScaledInstance(1300,700,Image.SCALE_SMOOTH);
background_image = new ImageIcon(temp_img);
JLabel background = new JLabel("",background_image, JLabel.CENTER);
background.add(login);
background.add(heading);
background.setBounds(0,0,1300,700);
add(background);

new_record.addActionListener(new ActionListener()
{
	public void actionPerformed(ActionEvent e)
	{
		Return_Book frame=new Return_Book();
		frame.setVisible(true);
		frame.setBounds(0,0,1300,700);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}
});
back_button.addActionListener(new ActionListener()
{
	public void actionPerformed(ActionEvent e)
	{
		Library_Management frame1=new Library_Management();
		frame1.setSize(1300,700);
		frame1.setVisible(true);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
});
}
/*public static void main(String[] args)
{
Notify_Return nr= new Notify_Return();
nr.setSize(1300,700);
nr.setVisible(true);
nr.setLayout(null);
nr.setDefaultCloseOperation(EXIT_ON_CLOSE);
}*/
}