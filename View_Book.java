import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JTable;

class View_Book extends JFrame
{
    Connection con=null;
    ResultSet rs=null;
    Statement st=null;
    PreparedStatement pst = null;
    PreparedStatement cst = null;
    
    View_Book()
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
            
        //middle Panel
        JPanel middle;
        middle= new JPanel();
        middle.setLayout(null);
        middle.setBounds(1,1,1300,700);
        middle.setBackground(new Color(107,76,154,90));
        add(middle);

        String data[][]=null;
        String column[]=null;
	try
        {
            Connection con=DriverManager.getConnection("jdbc:ucanaccess://E:\\Ashu/MyLogin.accdb");
            PreparedStatement pst=con.prepareStatement("select * from Add_Table",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=pst.executeQuery();

            ResultSetMetaData rsmd=rs.getMetaData();
            int cols=rsmd.getColumnCount();
            column=new String[cols];
            for(int i=1;i<=cols;i++)
            {
                column[i-1]=rsmd.getColumnName(i);
            }
            rs.last();
            int rows=rs.getRow();
            rs.beforeFirst();

            data=new String[rows][cols];
            int count=0;
            while(rs.next())
            {
                for(int i=1;i<=cols;i++)
                {
                    data[count][i-1]=rs.getString(i);
                }
                count++;
            }
            con.close();
        }
        catch(Exception e){System.out.println(e);}

        JTable jt= new JTable(data,column);
        JScrollPane sp=new JScrollPane(jt);
        add(sp);
        
        JButton back_button=new JButton("Back");
        back_button.setBounds(20,590,100,30);
        back_button.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
        middle.add(back_button);
        
        ImageIcon back_icon = new ImageIcon("E:\\Ashu\\home.jpg");
        Image img3 = back_icon.getImage();
        Image temp_img3 = img3.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        back_icon= new ImageIcon(temp_img3);
        JButton backbutton= new JButton(back_icon);
        backbutton.setBounds(30,500,80,80);
        middle.add(backbutton);

        JButton logout_button=new JButton("Change Background Color");
        logout_button.setBounds(960,590,300,30);
        logout_button.setFont(new Font("Franklin Gothic Book",Font.BOLD,22));
        middle.add(logout_button);
        
        ImageIcon logout_icon = new ImageIcon("E:\\Ashu\\funFace.jpg");
        Image img4 = logout_icon.getImage();
        Image temp_img4 = img4.getScaledInstance(150, 80, Image.SCALE_SMOOTH);
        logout_icon= new ImageIcon(temp_img4);
        JButton logoutbutton= new JButton(logout_icon);
        logoutbutton.setBounds(1050,500,150,80);
        middle.add(logoutbutton);

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
        logout_button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
//                first lp = new first();
//                lp.setSize(1300, 700);
//                lp.setVisible(true);
//                lp.setLayout(null);
//                lp.setDefaultCloseOperation(EXIT_ON_CLOSE);
                
                        //Generating random numbers by using formula
                        //double x = (Math.random()*((max-min)+1))+min;
                        double p1 = Math.random()*256;
                        double p2 = Math.random()*256;
                        double p3 = Math.random()*256;
                        double p4 = Math.random()*101;
                        int q1=(int)p1;
                        int q2=(int)p2;
                        int q3=(int)p3;
                        int q4=(int)p4;
                        middle.setBackground(new Color(q1,q2,q3,q4));
            }	
        });
        backbutton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Library_Management frame1=new Library_Management();
                frame1.setSize(1300,700);
                frame1.setVisible(true);
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }	
        });
        logoutbutton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
//                first lp = new first();
//                lp.setSize(1300, 700);
//                lp.setVisible(true);
//                lp.setLayout(null);
//                lp.setDefaultCloseOperation(EXIT_ON_CLOSE);
                
                        double p1 = Math.random()*256;
                        double p2 = Math.random()*256;
                        double p3 = Math.random()*256;
                        double p4 = Math.random()*101;
                        int q1=(int)p1;
                        int q2=(int)p2;
                        int q3=(int)p3;
                        int q4=(int)p4;
                        middle.setBackground(new Color(q1,q2,q3,q4));
            }	
        });
    }
    /*public static void main(String[] args)
    {
        View_Book vbook=new View_Book();
        vbook.setVisible(true);
        vbook.setBounds(0,0,1300,700);
        vbook.setTitle("-:Books Availability Information:-");
        vbook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }*/
}