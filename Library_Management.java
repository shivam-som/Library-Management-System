import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

class Library_Management extends JFrame
{
JPanel heading,middle;
JLabel lr;
JButton add_book,remove_book,issue_book,return_book;
Library_Management()
{
//header
JPanel heading;
heading= new JPanel();
heading.setBounds(0,0,1300,80);
heading.setLayout(null);
heading.setBackground(new Color(0,0,0,80));

    ImageIcon left_icon = new ImageIcon("E:\\Ashu\\librarymanagement.jpeg");
    Image img1 = left_icon.getImage();
    Image temp_img1 = img1.getScaledInstance(300, 80, Image.SCALE_SMOOTH);
    left_icon= new ImageIcon(temp_img1);
    JLabel label_icon= new JLabel("", left_icon, JLabel.CENTER);
    label_icon.setBounds(0,0,300,80);
    heading.add(label_icon);

JLabel lr=new JLabel("Library Management");
lr.setBounds(420,20,500,50);
lr.setFont(new Font("Elephant",Font.BOLD,40));
lr.setForeground(Color.WHITE);
heading.add(lr);


//middle Panel
JPanel middle;
middle= new JPanel();
middle.setLayout(null);
middle.setBounds(400,120,500,500);
middle.setBackground(new Color(0,0,0,80));

JButton add_book =new JButton("Add Book");
add_book.setBounds(150,30,200,50);
add_book.setFont(new Font("Franklin Gothic Book",Font.BOLD,25));
add_book.setBackground(new Color(255,255,153));
middle.add(add_book);

JButton remove_book =new JButton("Remove Book");
remove_book.setBounds(150,105,200,50);
remove_book.setFont(new Font("Franklin Gothic Book",Font.BOLD,25));
remove_book.setBackground(new Color(255,255,153));
middle.add(remove_book);

JButton issue_book =new JButton("Issue Book");
issue_book.setBounds(150,185,200,50);
issue_book.setFont(new Font("Franklin Gothic Book",Font.BOLD,25));
issue_book.setBackground(new Color(255,255,153));
middle.add(issue_book);

JButton return_book =new JButton("Return Book");
return_book.setBounds(150,265,200,50);
return_book.setFont(new Font("Franklin Gothic Book",Font.BOLD,25));
return_book.setBackground(new Color(255,255,153));
middle.add(return_book);

JButton view_book =new JButton("View Book");
view_book.setBounds(150,345,200,50);
view_book.setFont(new Font("Franklin Gothic Book",Font.BOLD,25));
view_book.setBackground(new Color(255,255,153));
middle.add(view_book);

JButton logout =new JButton("Logout");
logout.setBounds(150,420,200,50);
logout.setFont(new Font("Franklin Gothic Book",Font.BOLD,25));
logout.setBackground(new Color(255,255,153));
middle.add(logout);

//icon buttons
    ImageIcon add_icon1 = new ImageIcon("E:\\Ashu\\add_image.jpeg");
    Image icon1 = add_icon1.getImage();
    Image temp_icon1 = icon1.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
    add_icon1= new ImageIcon(temp_icon1);
    JButton add_icon= new JButton(add_icon1);
    add_icon.setBounds(100,120,200, 200);
    add(add_icon);
            add_icon.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
               Add_Book ab=new Add_Book();
		ab.setSize(1300,700);
		ab.setVisible(true);
		ab.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
            });
            
    ImageIcon delete_icon1 = new ImageIcon("E:\\Ashu\\delete_image.jpg");
    Image icon2 = delete_icon1.getImage();
    delete_icon1= new ImageIcon(icon2.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
    JButton delete_icon= new JButton(delete_icon1);
    delete_icon.setBounds(1000,120,200, 200);
    add(delete_icon);
            delete_icon.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
               Delete_Book db=new Delete_Book();
		db.setSize(1300,700);
		db.setVisible(true);
		db.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
            });
            
    ImageIcon issue_icon1 = new ImageIcon("E:\\Ashu\\issue_image.png");
    Image icon3 = issue_icon1.getImage();
    issue_icon1= new ImageIcon(icon3.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
    JButton issue_icon= new JButton(issue_icon1);
    issue_icon.setBounds(100,415,200, 200);
    add(issue_icon);
            issue_icon.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
               Issue_Book ib=new Issue_Book();
		ib.setSize(1300,700);
		ib.setVisible(true);
		ib.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
            });
            
    ImageIcon return_icon1 = new ImageIcon("E:\\Ashu\\return_image.png");
    Image icon4 = return_icon1.getImage();
    return_icon1= new ImageIcon(icon4.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
    JButton return_icon= new JButton(return_icon1);
    return_icon.setBounds(1000,415,200, 200);
    add(return_icon);
            return_icon.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
               Return_Book rb=new Return_Book();
		rb.setSize(1300,700);
		rb.setVisible(true);
		rb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

logout.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
        Login_Page lp = new Login_Page();
        lp.setSize(1300, 700);
        lp.setVisible(true);
        lp.setLayout(null);
        lp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }	
});

add_book.addActionListener(new ActionListener()
{
		public void actionPerformed(ActionEvent e)
	{
		Add_Book ab=new Add_Book();
		ab.setSize(1300,700);
		ab.setVisible(true);
		ab.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}	
});

issue_book.addActionListener(new ActionListener()
{
		public void actionPerformed(ActionEvent e)
	{
		Issue_Book ib=new Issue_Book();
		ib.setSize(1300,700);
		ib.setVisible(true);
		ib.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}	
});

remove_book.addActionListener(new ActionListener()
{
		public void actionPerformed(ActionEvent e)
	{
		Delete_Book db=new Delete_Book();
		db.setSize(1300,700);
		db.setVisible(true);
		db.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}	
});

return_book.addActionListener(new ActionListener()
{
		public void actionPerformed(ActionEvent e)
	{
		Return_Book rb=new Return_Book();
		rb.setSize(1300,700);
		rb.setVisible(true);
		rb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}	
});

    view_book.addActionListener(new ActionListener()
    {
	public void actionPerformed(ActionEvent e)
	{
            View_Book vbook=new View_Book();
            vbook.setVisible(true);
            vbook.setBounds(0,0,1300,700);
            vbook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
    });

}
/*public static void main(String[] args)
{
Library_Management frame1=new Library_Management();
frame1.setVisible(true);
frame1.setBounds(0,0,1300,700);
//frame.setSize(900,600);
//frame.setLocation(200,50);
frame1.setTitle("Registration Page");
frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}*/
}