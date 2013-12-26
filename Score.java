package 学生信息管理系统;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.font.*;
import java.sql.*;

public class Score extends JFrame implements ActionListener
{
	static Score s;
	JLabel title = new JLabel("查询成绩",JLabel.CENTER);
	Font f = new Font("楷体",Font.BOLD+Font.ITALIC,16);
	JPanel jpl = new JPanel();
	JLabel label1 = new JLabel("请输入学号：",JLabel.CENTER);
	JTextField num = new JTextField();
	JButton serch = new JButton("查询成绩");
	JButton reset = new JButton("重置");
	JLabel label2 = new JLabel("计算机网络：",JLabel.LEFT);
	JLabel label3 = new JLabel("Linux操作系统：",JLabel.LEFT);
	JLabel label4 = new JLabel("计算机专业英语：",JLabel.LEFT);
	JLabel label5 = new JLabel("计算机信息技术基础：",JLabel.LEFT);
	JLabel label6 = new JLabel("Java程序设计：",JLabel.LEFT);
	JLabel label7 = new JLabel("数据库：",JLabel.LEFT);
	JLabel label8 = new JLabel("高等数学：",JLabel.LEFT);
	JLabel label9 = new JLabel("XML：",JLabel.LEFT);
	
	JTextField[] txt ={ new JTextField() , new JTextField() , new JTextField() , new JTextField() , new JTextField() , new JTextField() ,new JTextField() , new JTextField()};
	static int p = 140;

	public Score()
	{
		super("查询分数");
		this.setResizable(false);
		this.setSize(500,550);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    title.setFont(f);
		this.add(jpl);
		jpl.setLayout(null);
		title.setBounds(100,20,300,20);
		jpl.add(title);
		label1.setBounds(100,60,90,20);
		jpl.add(label1);
		num.setBounds(210,60,140,20);
		jpl.add(num);
		serch.setBounds(130,100,90,20);
		reset.setBounds(240,100,90,20);
		jpl.add(serch);
		jpl.add(reset);
		serch.addActionListener(this);
		reset.addActionListener(this);
		label2.setBounds(100,140,140,20);
		label3.setBounds(100,180,140,20);
		label4.setBounds(100,220,140,20);
		label5.setBounds(100,260,140,20);
		label6.setBounds(100,300,140,20);
		label7.setBounds(100,340,140,20);
		label8.setBounds(100,380,140,20);
		label9.setBounds(100,420,140,20);
		jpl.add(label2);
		jpl.add(label3);
		jpl.add(label4);
		jpl.add(label5);
		jpl.add(label6);
		jpl.add(label7);
		jpl.add(label8);
		jpl.add(label9);
		
		for(int i = 0 ;i<txt.length ; i++)
		{
			txt[i].setBounds(260,p,140,20);
			jpl.add(txt[i]);
			p=p+40;
		}
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==serch)
		{
			String id = num.getText();
			try
		    {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		    }
		    catch (ClassNotFoundException ce)
		    {
			    JOptionPane.showMessageDialog(s,ce.getMessage());
		    }
			try
			{
				Connection con = DriverManager.getConnection("jdbc:odbc:sysdb","sa","");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select 计算机系成绩.* from STU , 计算机系成绩 where STU.ID ='" + id + "' AND STU.ID = 计算机系成绩.SID");
				while(rs.next())
				{
					for(int i = 0 ; i<txt.length ; i++)
					{
						txt[i].setText(rs.getString(i+2));
					}
				}
			}
			catch (SQLException se)
			{
				JOptionPane.showMessageDialog(s,se.getMessage());
			}
		}
		else
		{
			for(int i = 0;i<txt.length ; i++)
			{
				txt[i].setText("");
			}
			num.setText("");
		}
	}

	public static void main(String[] args)
	{
		Score s = new Score();
	}
}