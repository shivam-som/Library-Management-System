import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

class Add_Book extends JFrame
{
    Connection con=null;
    ResultSet rs=null;
    Statement st=null;
    
Add_Book()
{ 
    try
    {
        String url="jdbc:ucanaccess://E:\\Ashu\\MyLogin.accdb";
        con=DriverManager.getConnection(url);
        
       //rs=st.executeQuery("select * from Register"); 
    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null,e);
    }
            
//header
JPanel heading;
heading= new JPanel();
heading.setBounds(0,0,1300,80);
heading.setBackground(new Color(0,0,0,80));

JLabel lr=new JLabel("ADD BOOK");
lr.setBounds(550,30,150,50);
lr.setFont(new Font("Elephant",Font.BOLD,40));
lr.setForeground(Color.WHITE);
heading.add(lr);


//middle Panel
JPanel middle;
middle= new JPanel();
middle.setLayout(null);
middle.setBounds(300,100,700,550);
middle.setBackground(new Color(0,0,0,80));


JLabel add_new_book=new JLabel("Adding a New Book: ------------------------------------------------------------");
add_new_book.setBounds(20,10,650,30);
add_new_book.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
add_new_book.setForeground(new Color(255,255,153));
middle.add(add_new_book);

JLabel book_subject=new JLabel("The Book Subject: ");
book_subject.setBounds(20,50,300,30);
book_subject.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
book_subject.setForeground(new Color(255,255,153));
middle.add(book_subject);
JTextField t1=new JTextField();
t1.setBounds(350,50,300,30);
t1.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
t1.setBackground(new Color(255,255,204));
middle.add(t1);

JLabel book_name=new JLabel("The Book Name: ");
book_name.setBounds(20,90,300,30);
book_name.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
book_name.setForeground(new Color(255,255,153));
middle.add(book_name);
JTextField t2=new JTextField();
t2.setBounds(350,90,300,30);
t2.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
t2.setBackground(new Color(255,255,204));
middle.add(t2);

JLabel author_name =new JLabel("The name of the Author(s): ");
author_name.setBounds(20,130,300,30);
author_name.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
author_name.setForeground(new Color(255,255,153));
middle.add(author_name);
JTextField t3=new JTextField();
t3.setBounds(350,130,300,30);
t3.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
t3.setBackground(new Color(255,255,204));
middle.add(t3);

JLabel publisher_name=new JLabel("The name of the Publisher: ");
publisher_name.setBounds(20,170,300,30);
publisher_name.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
publisher_name.setForeground(new Color(255,255,153));
middle.add(publisher_name);
JTextField t4=new JTextField();
t4.setBounds(350,170,300,30);
t4.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
t4.setBackground(new Color(255,255,204));
middle.add(t4);

JLabel copyright=new JLabel("CopyRight for the Book: ");
copyright.setBounds(20,210,300,30);
copyright.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
copyright.setForeground(new Color(255,255,153));
middle.add(copyright);
JTextField t5=new JTextField();
t5.setBounds(350,210,300,30);
t5.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
t5.setBackground(new Color(255,255,204));
middle.add(t5);

JLabel edition_number=new JLabel("The Edition number: ");
edition_number.setBounds(20,250,300,30);
edition_number.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
edition_number.setForeground(new Color(255,255,153));
middle.add(edition_number);
JTextField t6=new JTextField();
t6.setBounds(350,250,300,30);
t6.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
t6.setBackground(new Color(255,255,204));
middle.add(t6);

JLabel page_number=new JLabel("The number of Pages: ");
page_number.setBounds(20,290,300,30);
page_number.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
page_number.setForeground(new Color(255,255,153));
middle.add(page_number);
JTextField t7=new JTextField();
t7.setBounds(350,290,300,30);
t7.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
t7.setBackground(new Color(255,255,204));
middle.add(t7);

JLabel book_id=new JLabel("Book ID : ");
book_id.setBounds(20,330,300,30);
book_id.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
book_id.setForeground(new Color(255,255,153));
middle.add(book_id);
JTextField t8=new JTextField();
t8.setBounds(350,330,300,30);
t8.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
t8.setBackground(new Color(255,255,204));
middle.add(t8);

JLabel copies_no=new JLabel("The number of Copies: ");
copies_no.setBounds(20,370,300,30);
copies_no.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
copies_no.setForeground(new Color(255,255,153));
middle.add(copies_no);
JTextField t9=new JTextField();
t9.setBounds(350,370,300,30);
t9.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
t9.setBackground(new Color(255,255,204));
middle.add(t9);

JLabel name_of_library=new JLabel("The name of the Library: ");
name_of_library.setBounds(20,410,300,30);
name_of_library.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
name_of_library.setForeground(new Color(255,255,153));
middle.add(name_of_library);
JTextField t10=new JTextField();
t10.setBounds(350,410,300,30);
t10.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
t10.setBackground(new Color(255,255,204));
middle.add(t10);

JLabel qty=new JLabel("Quantity : ");
qty.setBounds(20,450,300,30);
qty.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
qty.setForeground(new Color(255,255,153));
middle.add(qty);
JTextField t11=new JTextField();
t11.setBounds(350,450,300,30);
t11.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
t11.setBackground(new Color(255,255,204));
middle.add(t11);

JButton back_button=new JButton("Back");
back_button.setBounds(20,510,100,30);
back_button.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
middle.add(back_button);

JButton reset_button=new JButton("Reset");
reset_button.setBounds(170,510,100,30);
reset_button.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
middle.add(reset_button);

JButton insert_button=new JButton("Insert the Information");
insert_button.setBounds(350,510,290,30);
insert_button.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
middle.add(insert_button);


//background
ImageIcon background_image=new ImageIcon("E:\\Ashu\\first.jpg");
Image img =background_image.getImage();
Image temp_img= img.getScaledInstance(1300,700,Image.SCALE_SMOOTH);
background_image = new ImageIcon(temp_img);
JLabel background = new JLabel("", background_image, JLabel.CENTER);
background.setBounds(0,0,1300,700);
add(background);

background.add(heading);
background.add(middle);

//setContentPane(new JLabel(new ImageIcon("E:\\Ashu\\first.jpg")));
//setLayout(new FlowLayout());
//pack();

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

insert_button.addActionListener(new ActionListener()
{
		public void actionPerformed(ActionEvent e)
	{
            try
            {
                st=con.createStatement();
                String s1="INSERT INTO Add_Table(Book_Name,Book_Title,Author_Name,Publisher_Name,Copyright,Edition_No,Page_No,Book_Id,Copies_No,Name_Of_Library,Quantity) VALUES('"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"','"+t5.getText()+"','"+t6.getText()+"','"+t7.getText()+"','"+t8.getText()+"','"+t9.getText()+"','"+t10.getText()+"','"+t11.getText()+"')";
                st.executeUpdate(s1);
                rs=st.executeQuery("SELECT * FROM Add_Table");
                while(rs.next())
                System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8)+" "+rs.getString(9)+" "+rs.getString(10)+" "+rs.getString(11));
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    t6.setText("");
                    t7.setText("");
                    t8.setText("");
                    t9.setText("");
                    t10.setText("");
                    t11.setText("");
                    JOptionPane.showMessageDialog(null,"Data Entered Succesfully");
                Notify_Add na= new Notify_Add();
		na.setSize(1300,700);
		na.setVisible(true);
                na.setLayout(null);
		na.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
            catch(Exception i)
            {
                 JOptionPane.showMessageDialog(null,"Enter Valid Informatiion");
            }
	}	
});
reset_button.addActionListener(new ActionListener()
{
		public void actionPerformed(ActionEvent e)
        {
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                t7.setText("");
                t8.setText("");
                t9.setText("");
                t10.setText("");
                t11.setText("");
	}	
});

}

/*public static void main(String[] args)
{
Add_Book frame=new Add_Book();
frame.setVisible(true);
frame.setBounds(0,0,1300,700);
frame.setTitle("Registration Page");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}*/
}