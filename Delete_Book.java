import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

class Delete_Book extends JFrame
{
     Connection con=null;
    ResultSet rs=null;
    Statement st=null;
    
Delete_Book()
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

JLabel lr=new JLabel("Delete Book");
lr.setBounds(550,30,150,50);
lr.setFont(new Font("Elephant",Font.BOLD,40));
lr.setForeground(Color.WHITE);
heading.add(lr);

//middle Panel
JPanel middle;
middle= new JPanel();
middle.setLayout(null);
middle.setBounds(350,120,600,460);
middle.setBackground(new Color(0,0,0,80));

JLabel book_id=new JLabel("Book ID:");
book_id.setBounds(50,50,150,30);
book_id.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
book_id.setForeground(new Color(255,255,153));
middle.add(book_id);
JTextField t1=new JTextField();
t1.setBounds(250,50,150,30);
t1.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
//t1.setBackground(new Color(255,255,204));
middle.add(t1);

JLabel book_name=new JLabel("Book Name: ");
book_name.setBounds(50,120,150,30);
book_name.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
book_name.setForeground(new Color(255,255,153));
middle.add(book_name);
JTextField t2=new JTextField();
t2.setBounds(250,120,150,30);
t2.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
//t2.setForeground(new Color(255,255,153));
t2.setEditable(false);
middle.add(t2);

JLabel author_name=new JLabel("Author name: ");
author_name.setBounds(50,190,150,30);
author_name.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
author_name.setForeground(new Color(255,255,153));
middle.add(author_name);
JTextField t3=new JTextField("");
t3.setBounds(250,190,150,30);
t3.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
//t3.setBackground(new Color(255,255,204));
t3.setEditable(false);
middle.add(t3);


JLabel publisher=new JLabel("Publisher:");
publisher.setBounds(50,260,150,30);
publisher.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
publisher.setForeground(new Color(255,255,153));
middle.add(publisher);
JTextField t4=new JTextField("");
t4.setBounds(250,260,150,30);
t4.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
//t4.setBackground(new Color(255,255,204));
t4.setEditable(false);
middle.add(t4);

JLabel qty=new JLabel("Quantity: ");
qty.setBounds(50,330,150,30);
qty.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
qty.setForeground(new Color(255,255,153));
middle.add(qty);
JTextField t5=new JTextField("");
t5.setBounds(250,330,150,30);
t5.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
//t5.setBackground(new Color(255,255,204));
t5.setEditable(false);
middle.add(t5);

JButton details=new JButton("Details");
details.setBounds(480,50,100,30);
details.setFont(new Font("Franklin Gothic Book",Font.BOLD,18));
middle.add(details);

JButton delete_book=new JButton("Delete Book");
delete_book.setBounds(50,400,150,40);
delete_book.setFont(new Font("Franklin Gothic Book",Font.BOLD,18));
middle.add(delete_book);

JButton back=new JButton("Back");
back.setBounds(370,400,130,40);
back.setFont(new Font("Franklin Gothic Book",Font.BOLD,18));
middle.add(back);

JButton reset=new JButton("Reset");
reset.setBounds(220,400,130,40);
reset.setFont(new Font("Franklin Gothic Book",Font.BOLD,18));
middle.add(reset);

//background
ImageIcon background_image=new ImageIcon("E:\\Ashu\\second.jpg");
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
		Library_Management frame1=new Library_Management();
		frame1.setSize(1300,700);
		frame1.setVisible(true);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}	
});

details.addActionListener(new ActionListener()
{
    public void actionPerformed(ActionEvent e)
    {
        PreparedStatement pst = null;
        PreparedStatement cst = null;
        try
        {
            String did=t1.getText();
            //here t1 is the textfield of book_Id
            String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
            Class.forName(driver);
            Connection con=DriverManager.getConnection("jdbc:ucanaccess://E:\\Ashu/MyLogin.accdb");
            String sql="Select * from Add_Table where Book_Id=?";
            pst=con.prepareStatement(sql);
            pst.setString(1,did);
            rs=pst.executeQuery();
            while(rs.next())
            {            
                if(did.contains(rs.getString("Book_Id")))
                {
                    String nt2=rs.getString("Book_Name");
                    t2.setText(nt2);
                    t2.setEditable(false);
                    String nt3=rs.getString("Author_Name");
                    t3.setText(nt3);
                    t3.setEditable(false);
                    String nt4=rs.getString("Publisher_Name");
                    t4.setText(nt4);
                    t4.setEditable(false);
                    String nt5=rs.getString("Quantity");
                    t5.setText(nt5);
                    t5.setEditable(false);
                }
            }
        } 
            catch(Exception di)
                {
                    JOptionPane.showMessageDialog(null,"Enter Valid Book_ID");
                }
    }
});

delete_book.addActionListener(new ActionListener()
{
		public void actionPerformed(ActionEvent e)
	{
            try
            {
                String a7=t1.getText();
                        String b1=t5.getText();
                        int b2=Integer.parseInt(b1);
                        int b3=b2-1;
                        String b4=Integer.toString(b3);
                
                st=con.createStatement();
                String s1="INSERT INTO Delete_Table(Book_Id,Name,Author_Name,Publisher,Quantity) VALUES('"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"','"+b4+"')";
                st.executeUpdate(s1);
                
                rs=st.executeQuery("SELECT * FROM Delete_Table");
                while(rs.next())
                System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                
                String sql1="SELECT * FROM Add_Table WHERE Book_Id=?";
            PreparedStatement ps=con.prepareStatement(sql1);
            ps.setString(1,a7);
            rs=ps.executeQuery();
            if(rs.next())
            {
		String a1=rs.getString("Quantity");
                int a2=Integer.parseInt(a1);
                int a3=a2-1;
                String a4=Integer.toString(a3);

                PreparedStatement ps2=con.prepareStatement("UPDATE Add_Table SET Quantity=? WHERE Book_Id="+a7+"");
                ps2.setString(1,a4);
                ps2.executeUpdate();
            }               
                JOptionPane.showMessageDialog(null,"Data Deleted Succesfully");
                
                Notify_Delete nd= new Notify_Delete();
		nd.setSize(1300,700);
		nd.setVisible(true);
		nd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
            catch(Exception i)
            {
                 JOptionPane.showMessageDialog(null,"Enter Valid Informatiion");
            }
	}	
});

reset.addActionListener(new ActionListener()
{
		public void actionPerformed(ActionEvent e)
        {
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
        }	
});

}
/*public static void main(String[] args)
{
Delete_Book frame=new Delete_Book();
frame.setVisible(true);
frame.setBounds(0,0,1300,700);
frame.setTitle("Registration Page");
frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
}*/
}