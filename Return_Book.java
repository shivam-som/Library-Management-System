import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class Return_Book extends JFrame
{
    Connection con=null;
    ResultSet rs=null;
    Statement st=null;
    
Return_Book()
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

JLabel lr=new JLabel("Return Book");
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
book_id.setBounds(50,30,150,30);
book_id.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
book_id.setForeground(new Color(255,255,153));
middle.add(book_id);
JTextField t1=new JTextField();
t1.setBounds(250,30,150,30);
t1.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
t1.setBackground(new Color(255,255,204));
middle.add(t1);
JButton details=new JButton("Details");
details.setBounds(450,30,120,30);
details.setFont(new Font("Franklin Gothic Book",Font.BOLD,18));
middle.add(details);

JLabel student_id=new JLabel("Student ID:");
student_id.setBounds(50,80,150,30);
student_id.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
student_id.setForeground(new Color(255,255,153));
middle.add(student_id);
JTextField t2=new JTextField();
t2.setBounds(250,80,150,30);
t2.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
t2.setBackground(new Color(255,255,204));
middle.add(t2);

JLabel name=new JLabel("Student Name: ");
name.setBounds(50,130,200,30);
name.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
name.setForeground(new Color(255,255,153));
middle.add(name);
JTextField t3=new JTextField();
t3.setBounds(250,130,150,30);
t3.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
t3.setBackground(new Color(255,255,204));
middle.add(t3);

JLabel book_name=new JLabel("Book Name:");
book_name.setBounds(50,180,150,30);
book_name.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
book_name.setForeground(new Color(255,255,153));
middle.add(book_name);
JTextField t4=new JTextField();
t4.setBounds(250,180,150,30);
t4.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
t4.setBackground(new Color(255,255,204));
middle.add(t4);

JLabel author_name=new JLabel("Author name: ");
author_name.setBounds(50,230,150,30);
author_name.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
author_name.setForeground(new Color(255,255,153));
middle.add(author_name);
JTextField t5=new JTextField();
t5.setBounds(250,230,150,30);
t5.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
t5.setBackground(new Color(255,255,204));
middle.add(t5);

JLabel return_date=new JLabel("Returning Date: ");
return_date.setBounds(50,280,200,30);
return_date.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
return_date.setForeground(new Color(255,255,153));
middle.add(return_date);
JComboBox day = new JComboBox(day_arr);
day.setBounds(250,280,70,25);
middle.add(day);
JComboBox month = new JComboBox(month_arr);
month.setBounds(330,280,70,25);
middle.add(month);
JComboBox year = new JComboBox(year_arr);
year.setBounds(410,280,70,25);
middle.add(year);

JLabel fine=new JLabel("Issuing Date :");
fine.setBounds(50,330,200,30);
fine.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
fine.setForeground(new Color(255,255,153));
middle.add(fine);
JTextField ta6=new JTextField();
ta6.setBounds(250,330,70,30);
ta6.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
ta6.setBackground(new Color(255,255,204));
middle.add(ta6);
JTextField ta7=new JTextField();
ta7.setBounds(330,330,70,30);
ta7.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
ta7.setBackground(new Color(255,255,204));
middle.add(ta7);
JTextField ta8=new JTextField();
ta8.setBounds(410,330,70,30);
ta8.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
ta8.setBackground(new Color(255,255,204));
middle.add(ta8);

JButton return_books=new JButton("Return Books");
return_books.setBounds(50,400,150,40);
return_books.setFont(new Font("Franklin Gothic Book",Font.BOLD,18));
middle.add(return_books);

JButton back=new JButton("Back");
back.setBounds(370,400,130,40);
back.setFont(new Font("Franklin Gothic Book",Font.BOLD,18));
middle.add(back);

JButton reset=new JButton("Reset");
reset.setBounds(220,400,130,40);
reset.setFont(new Font("Franklin Gothic Book",Font.BOLD,18));
middle.add(reset);

//background
ImageIcon background_image=new ImageIcon("E:\\Ashu\\seventh.jpg");
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
        PreparedStatement pst = null;
        try
        {
            String did=t1.getText();
            //here t1 is the textfield of book_Id
            String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
            Class.forName(driver);
            Connection con=DriverManager.getConnection("jdbc:ucanaccess://E:\\Ashu/MyLogin.accdb");
            String sql="Select * from Issue_Table where Book_Id=?";
            pst=con.prepareStatement(sql);
            pst.setString(1,did);
            rs=pst.executeQuery();
            while(rs.next())
            {            
                if(did.contains(rs.getString("Book_Id")))
                {
                    String nt6=rs.getString("Day");
                    ta6.setText(nt6);
                    ta6.setEditable(false);
                    String nt7=rs.getString("Month");
                    ta7.setText(nt7);
                    ta7.setEditable(false);
                    String nt8=rs.getString("Year");
                    ta8.setText(nt8);
                    ta8.setEditable(false);
                    String nt4=rs.getString("Book_Name");
                    t4.setText(nt4);
                    t4.setEditable(false);
                    String nt5=rs.getString("Author_Name");
                    t5.setText(nt5);
                    t5.setEditable(false);
                    String nt3=rs.getString("Student_Name");
                    t3.setText(nt3);
                    t3.setEditable(false);
                    String nt2=rs.getString("Member_Id");
                    t2.setText(nt2);
                    t2.setEditable(false);
                }
            }
        } 
            catch(Exception di)
                {
                    JOptionPane.showMessageDialog(null,"Enter Valid Book_ID");
                }
    }
});

/*fine.addActionListener(new ActionListener (){
    public void actionPerformed(ActionEvent e){
        PreparedStatement pst = null;
        try{
            String did=t1.getText();
            String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
            Class.forName(driver);
            Connection con=DriverManager.getConnection("jdbc:ucanaccess://E:\\Ashu/MyLogin.accdb");
            String sql="Select * from Issue_Table where Book_Id=?";
            pst=con.prepareStatement(sql);
            pst.setString(1,did);
            rs=pst.executeQuery();
            while(rs.next())
            {}
        }});*/

back.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
	Library_Management frame1=new Library_Management();
	frame1.setSize(1300,700);
	frame1.setVisible(true);
	frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }	
});

return_books.addActionListener(new ActionListener()
{
		public void actionPerformed(ActionEvent e)
	{
            
            try
            {
                String a7=t1.getText();
                   
                st=con.createStatement();
                String s1="INSERT INTO Return_Table(Book_Id,Student_Id,Student_Name,Book_Name,Author_Name,Day,Month,Year) VALUES('"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"','"+t5.getText()+"','"+day.getSelectedItem().toString()+"','"+month.getSelectedItem().toString()+"','"+year.getSelectedItem().toString()+"')";
                st.executeUpdate(s1);
                
                rs=st.executeQuery("SELECT * FROM Return_Table");
                while(rs.next())
                System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8));
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    ta6.setText("");
                    ta7.setText("");
                    ta8.setText("");
                    day.setSelectedItem("Select");
                    month.setSelectedItem("Select");
                    year.setSelectedItem("Select");
                
                String sql1="SELECT * FROM Add_Table WHERE Book_Id=?";
                PreparedStatement ps=con.prepareStatement(sql1);
                ps.setString(1,a7);
                rs=ps.executeQuery();
                if(rs.next())
                {
                    String a1=rs.getString("Quantity");
                    int a2=Integer.parseInt(a1);
                    int a3=a2+1;
                    String a4=Integer.toString(a3);

                    PreparedStatement ps2=con.prepareStatement("UPDATE Add_Table SET Quantity=? WHERE Book_Id="+a7+"");
//                  pst=con.prepareStatement(sql);
                    ps2.setString(1,a4);
                    ps2.executeUpdate();
                }   
                
                JOptionPane.showMessageDialog(null,"Book Returned Succesfully");
            }
            catch(Exception i)
            {
                 JOptionPane.showMessageDialog(null,"Enter Valid Informatiion");
            }
		Notify_Return nr= new Notify_Return();
		nr.setSize(1300,700);
		nr.setVisible(true);
		nr.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
        ta6.setText("");
        ta7.setText("");
        ta8.setText("");
        day.setSelectedItem("Select");
        month.setSelectedItem("Select");
        year.setSelectedItem("Select");
    }
});

}
/*public static void main(String[] args)
{
Return_Book frame=new Return_Book();
frame.setVisible(true);
frame.setBounds(0,0,1300,700);
frame.setTitle("Registration Page");
frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
}*/
}