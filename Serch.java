package ѧ����Ϣ����ϵͳ;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Serch extends JFrame implements ActionListener
{
	/*��ѯѧ����Ϣ�ؼ�*/
	static Serch s;
	JPanel jpl = new JPanel();
	JLabel SCH = new JLabel("��ѯѧ����Ϣ",JLabel.CENTER);
	JLabel label1 = new JLabel("������ѧ�ţ�",JLabel.CENTER);
	JButton serch = new JButton("��ѯ");
	JLabel label2 = new JLabel("������",JLabel.CENTER);
	JLabel label3 = new JLabel("�༶��",JLabel.CENTER);
	JLabel label4 = new JLabel("ѧУ��",JLabel.CENTER);
	JLabel label5 = new JLabel("�Ա�",JLabel.CENTER);
	ButtonGroup bgp = new ButtonGroup();
	JRadioButton man = new JRadioButton("��");
	JRadioButton women = new JRadioButton("Ů");
	JTextField num = new JTextField();
	JTextField nam = new JTextField();
	JTextField clas = new JTextField();
	JTextField scl = new JTextField();
	JButton reset = new JButton("����");

	public Serch()
	{
		this.setSize(500,400);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(jpl);
		jpl.setLayout(null);
		serch.addActionListener(this);
		reset.addActionListener(this);
		/*��ѯ���*/
		SCH.setBounds(100,20,300,20);
		jpl.add(SCH);
		label1.setBounds(100,60,100,20);
		jpl.add(label1);
		num.setBounds(220,60,140,20);
		jpl.add(num);
		serch.setBounds(120,100,90,20);
		reset.setBounds(260,100,90,20);
		jpl.add(serch);
		jpl.add(reset);
		label2.setBounds(100,140,70,20);
		jpl.add(label2);
		nam.setBounds(190,140,140,20);
		jpl.add(nam);
		label5.setBounds(100,180,70,20);
		jpl.add(label5);
		man.setBounds(205,180,60,20);
		women.setBounds(285,180,60,20);
		bgp.add(man);
		bgp.add(women);
		jpl.add(man);
		jpl.add(women);
		label3.setBounds(100,220,70,20);
		jpl.add(label3);
		clas.setBounds(190,220,140,20);
		jpl.add(clas);
		label4.setBounds(100,260,70,20);
		jpl.add(label4);
		scl.setBounds(190,260,140,20);
		jpl.add(scl);
	}

	public void actionPerformed(ActionEvent e)
	{
		String id = num.getText();
		if(e.getSource()==serch)
		{
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
				ResultSet rs = stmt.executeQuery("select * from STU where ID = '" + id + "'");
				while(rs.next())
				{
					nam.setText(rs.getString("Name"));
					if(rs.getString("Sex").equals("��"))
					{
						man.setSelected(true);
					}
					else
					{
						women.setSelected(true);
					}
					clas.setText(rs.getString("Class"));
					scl.setText(rs.getString("Collage"));
				}
			}
			catch (SQLException se)
			{
				JOptionPane.showMessageDialog(s,se.getMessage());
			}
		}
	}

	public static void main(String[] args)
	{
		Serch sch = new Serch();
	}
}
