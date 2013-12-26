package 学生信息管理系统;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class systems extends JFrame implements ActionListener
{
	static systems ss;
	JPanel panel = new JPanel();
	JLabel label1 = new JLabel("输入姓名：");
	JTextField name = new JTextField();
	JLabel label2 = new JLabel("密    码：");
	JPasswordField pwd = new JPasswordField();
	JButton Enter = new JButton("登录");
	JButton Exit = new JButton("退出");
	String url = "D:\\Systems\\title.jpg";
	ButtonGroup bgp = new ButtonGroup();
	JRadioButton stu = new JRadioButton("学生");
	JRadioButton tch = new JRadioButton("教师");

	public systems()
	{
		super("登录系统");
		this.setResizable(false);
	    JLabel img = new JLabel(new ImageIcon(url));
		img.setBounds(0,0,500,100);
		panel.add(img);
		stu.setBounds(165,210,70,20);
		tch.setBounds(265,210,70,20);
		bgp.add(stu);
		bgp.add(tch);
		panel.add(stu);
		panel.add(tch);
		Enter.setBounds(150,250,80,20);
		Exit.setBounds(270,250,80,20);
		Enter.addActionListener(this);
		Exit.addActionListener(this);
		panel.add(Enter);
		panel.add(Exit);
        panel.setLayout(null);
		this.add(panel);
		label1.setBounds(135,130,100,25);
		panel.add(label1);
        name.setBounds(265,130,100,25);
		panel.add(name);
		label2.setBounds(135,165,100,25);
		panel.add(label2);
        pwd.setBounds(265,165,100,25);
		panel.add(pwd);
		this.setBounds(100,100,500,350);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==Enter)
		{
			String username , password;
			username = name.getText();
		    password = pwd.getText();
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			}
			catch (ClassNotFoundException ce)
			{
				JOptionPane.showMessageDialog(ss,ce.getMessage());
			}
			if(stu.isSelected())
			{
				try
			    {
					Connection con = DriverManager.getConnection("jdbc:odbc:sysdb","sa","");
				    Statement stmt = con.createStatement();
				    ResultSet rs = stmt.executeQuery("select * from STU");
				    while(rs.next())
				    {
						if((rs.getString("ID").equals(username))&&(rs.getString("Pwd").equals(password)))
					    {        
							JOptionPane.showMessageDialog(ss,"登陆成功");
							Students stu = new Students();
					    }
					    else
					    {
						    JOptionPane.showMessageDialog(ss,"登录失败");
					    }
				    }
				    rs.close();
				    stmt.close();
			    }
			    catch (SQLException se)
			    {
				    JOptionPane.showMessageDialog(ss,se.getMessage());
			    }
			}
			else if(tch.isSelected())
			{
				try
				{
					Connection con = DriverManager.getConnection("jdbc:odbc:systchdb","sa","");
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("select * from TCH");
					while(rs.next())
					{
						if((rs.getString("ID").equals(username))&&(rs.getString("Pwd").equals(password)))
						{
							JOptionPane.showMessageDialog(ss,"登陆成功");
						}
						else
						{
							JOptionPane.showMessageDialog(ss,"登录失败");
						}
					}
				}
				catch (SQLException se)
				{
					JOptionPane.showMessageDialog(ss,se.getMessage());
				}
			}
		}
		else
		{
			System.exit(0);
		}
	}

	public static void main(String[] args)
	{
		systems sys = new systems();
	}
}
