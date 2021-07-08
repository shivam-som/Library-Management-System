import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class Issue_Book extends JFrame{
    
    Connection con=null;
    ResultSet rs=null;
    Statement st=null;
    PreparedStatement pst=null;
    PreparedStatement ps=null;
    PreparedStatement ps2=null;
    
Issue_Book()
{
     try
    {
        String url="jdbc:ucanaccess://E:\\Ashu\\MyLogin.accdb";
        con=DriverManager.getConnection(url);
    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null,e);
    }
                // Arrays of ComboBox
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

JLabel lr=new JLabel("Issue Book");
lr.setBounds(650,30,150,50);
lr.setFont(new Font("Elephant",Font.BOLD,40));
lr.setForeground(Color.WHITE);
heading.add(lr);

//middle Panel
JPanel middle;
middle= new JPanel();
middle.setLayout(null);
middle.setBounds(250,120,800,500);
middle.setBackground(new Color(0,0,0,100));

JLabel member_id=new JLabel("Member ID:");
member_id.setBounds(30,20,200,30);
member_id.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
member_id.setForeground(new Color(255,255,153));
middle.add(member_id);
JTextField t1=new JTextField();
t1.setBounds(300,20,100,30);
t1.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
t1.setBackground(new Color(255,255,204));
middle.add(t1);

JLabel name=new JLabel("Student Name: ");
name.setBounds(30,70,200,30);
name.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
name.setForeground(new Color(255,255,153));
middle.add(name);
JTextField t2=new JTextField();
t2.setBounds(300,70,400,30);
t2.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
t2.setBackground(new Color(255,255,204));
middle.add(t2);

JLabel book_id=new JLabel("Book ID:");
book_id.setBounds(30,120,200,30);
book_id.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
book_id.setForeground(new Color(255,255,153));
middle.add(book_id);
JTextField t3=new JTextField();
t3.setBounds(300,120,100,30);
t3.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
t3.setBackground(new Color(255,255,204));
middle.add(t3);
JButton details=new JButton("Details");
details.setBounds(550,120,150,30);
details.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
middle.add(details);

JLabel book_name=new JLabel("Book Name: ");
book_name.setBounds(30,190,200,30);
book_name.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
book_name.setForeground(new Color(255,255,153));
middle.add(book_name);
JTextField t4=new JTextField();
t4.setBounds(300,190,400,30);
t4.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
t4.setBackground(new Color(255,255,204));
t4.setEditable(false);
middle.add(t4);

JLabel author_name=new JLabel("Author Name: ");
author_name.setBounds(30,240,200,30);
author_name.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
author_name.setForeground(new Color(255,255,153));
middle.add(author_name);
JTextField t5=new JTextField();
t5.setBounds(300,240,400,30);
t5.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
t5.setBackground(new Color(255,255,204));
t5.setEditable(false);
middle.add(t5);

JLabel availability=new JLabel("Availability: ");
availability.setBounds(30,290,200,30);
availability.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
availability.setForeground(new Color(255,255,153));
middle.add(availability);
JTextField t6=new JTextField();
t6.setBounds(300,290,400,30);
t6.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
t6.setBackground(new Color(255,255,204));
t6.setEditable(false);
middle.add(t6);

JLabel issue_date=new JLabel("Issuing Date: ");
issue_date.setBounds(30,340,200,30);
issue_date.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
issue_date.setForeground(new Color(255,255,153));
middle.add(issue_date);
JComboBox day = new JComboBox(day_arr);
day.setBounds(300,340,110,30);
//day.setForeground(Color.WHITE);
middle.add(day);
JComboBox month = new JComboBox(month_arr);
month.setBounds(440,340,120,30);
//month.setForeground(Color.WHITE);
middle.add(month);
JComboBox year = new JComboBox(year_arr);
year.setBounds(590,340,110,30);
//year.setForeground(Color.WHITE);
middle.add(year);

JButton reset=new JButton("Reset");
reset.setBounds(100,430,150,50);
reset.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
middle.add(reset);
JButton issue_book=new JButton("Issue Book");
issue_book.setBounds(300,430,150,50);
issue_book.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
middle.add(issue_book);
JButton back=new JButton("Back");
back.setBounds(500,430,150,50);
back.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
middle.add(back);

//background
ImageIcon background_image=new ImageIcon("E:\\Ashu\\third.jpg");
Image img =background_image.getImage();
Image temp_img= img.getScaledInstance(1300,700,Image.SCALE_SMOOTH);
background_image = new ImageIcon(temp_img);
JLabel background = new JLabel("", background_image, JLabel.CENTER);
background.setBounds(0,0,1300,700);
add(background);

background.add(heading);
background.add(middle);

details.addActionListener(new ActionListener()
{
    public void actionPerformed(ActionEvent e)
    {
//        PreparedStatement pst = null;
//        PreparedStatement cst = null;
        try
        {
            String iid=t3.getText();
            //here t3 is the textfield of book_Id
            
            String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
            Class.forName(driver);
            Connection con=DriverManager.getConnection("jdbc:ucanaccess://E:\\Ashu/MyLogin.accdb");
            
            String sql="Select * from Add_Table where Book_Id=?";
            pst=con.prepareStatement(sql);
            pst.setString(1,iid);
            rs=pst.executeQuery();
            while(rs.next())
            {            
                if(iid.contains(rs.getString("Book_Id")))
                {
                    String nt4=rs.getString("Book_Name");
                    t4.setText(nt4);
                    t4.setEditable(false);
                    String nt5=rs.getString("Author_Name");
                    t5.setText(nt5);
                    t5.setEditable(false);
                    String nt6=rs.getString("Quantity");
                    t6.setText(nt6);
                    t6.setEditable(false);
                }
            }
        } 
            catch(Exception ii)
                {
                    JOptionPane.showMessageDialog(null,"Enter Valid Book_ID");
                }
    }
});

issue_book.addActionListener(new ActionListener()
{
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            String a7=t3.getText();
                        String b1=t6.getText();
                        int b2=Integer.parseInt(b1);
                        int b3=b2-1;
                        String b4=Integer.toString(b3);
            String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
            Class.forName(driver);
            Connection con=DriverManager.getConnection("jdbc:ucanaccess://E:\\Ashu/MyLogin.accdb");
            
            st=con.createStatement();
            String s1="INSERT INTO Issue_Table(Member_Id,Student_Name,Book_Id,Book_Name,Author_Name,Availability,Day,Month,Year) VALUES('"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"','"+t5.getText()+"','"+b4+"','"+day.getSelectedItem().toString()+"','"+month.getSelectedItem()+"','"+year.getSelectedItem().toString()+"')";
            st.executeUpdate(s1);
            rs=st.executeQuery("SELECT * FROM Issue_Table");
            while(rs.next())
            System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8)+" "+rs.getString(9));
                day.setSelectedItem("Select");
                month.setSelectedItem("Select");
                year.setSelectedItem("Select");            
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
            
//            PreparedStatement ps=con.prepareStatement("SELECT Quantity=? FROM Add_Table WHERE Book_Id=?");
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
//                pst=con.prepareStatement(sql);
                ps2.setString(1,a4);
                ps2.executeUpdate();
            }       
                JOptionPane.showMessageDialog(null,"Book Issued Successfully");
                Notify_Issue ni= new Notify_Issue();
                ni.setSize(1300,700);
                ni.setVisible(true);
                ni.setLayout(null);
                ni.setDefaultCloseOperation(EXIT_ON_CLOSE);
            con.close();
        }
        catch(Exception i)
        {
            JOptionPane.showMessageDialog(null,i);
        }
    }
});

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

reset.addActionListener(new ActionListener()
{
		public void actionPerformed(ActionEvent e)
        {
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                day.setSelectedItem("Select");
                month.setSelectedItem("Select");
                year.setSelectedItem("Select");
                
	}	
});

}
/*public static void main(String[] args)
{
Issue_Book frame=new Issue_Book();
frame.setVisible(true);
frame.setBounds(0,0,1300,700);
frame.setTitle("Registration Page");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}*/
}