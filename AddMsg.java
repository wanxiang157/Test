package ѧ����Ϣ����ϵͳ;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class AddMsg extends JFrame implements ActionListener
{
	static AddMsg s;
	/*���ѧ����Ϣ�ؼ�*/
	JPanel jpl = new JPanel();
	JLabel label1 = new JLabel("��ӻ�����Ϣ",JLabel.CENTER);
	JLabel label2 = new JLabel("ѧ�ţ�",JLabel.CENTER);
	JLabel label3 = new JLabel("������",JLabel.CENTER);
	JLabel label4 = new JLabel("�Ա�",JLabel.CENTER);
	JLabel label5 = new JLabel("�༶��",JLabel.CENTER);
	JLabel label6 = new JLabel("ѧԺ��",JLabel.CENTER);
	JTextField num = new JTextField(2);
	JTextField nam = new JTextField(4);
	ButtonGroup bgp = new ButtonGroup();
	JRadioButton man = new JRadioButton("��");
	JRadioButton women = new JRadioButton("Ů");
	JTextField clas = new JTextField();
	JTextField scl = new JTextField();
	JButton reset = new JButton("����");
	JButton addmsg = new JButton("���");

	public AddMsg()
	{
		super("���ѧ����Ϣ");
		this.setResizable(false);
		this.setSize(500,400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(jpl);
		jpl.setLayout(null);
		addmsg.addActionListener(this);
		reset.addActionListener(this);
		/*�������*/
		label1.setBounds(100,20,300,20);
		jpl.add(label1);
		label2.setBounds(100,50,70,20);
		jpl.add(label2);
		num.setBounds(190,50,140,20);
		jpl.add(num);
		label3.setBounds(100,90,70,20);
		jpl.add(label3);
		nam.setBounds(190,90,140,20);
		jpl.add(nam);
		label4.setBounds(100,130,70,20);
		jpl.add(label4);
		man.setBounds(190,130,60,20);
		women.setBounds(270,130,60,20);
		jpl.add(man);
		jpl.add(women);
		bgp.add(man);
		bgp.add(women);
		label5.setBounds(100,170,70,20);
		jpl.add(label5);
		clas.setBounds(190,170,140,20);
		jpl.add(clas);
		label6.setBounds(100,210,70,20);
		jpl.add(label6);
		scl.setBounds(190,210,140,20);
		jpl.add(scl);
		reset.setBounds(120,250,90,20);
		addmsg.setBounds(240,250,90,20);
		jpl.add(reset);
		jpl.add(addmsg);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==addmsg)
		{
			String sex;
			if(man.isSelected())
			{
			    sex="��";
			}
			else
		    {
			    sex="Ů";
		    }
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
				int a = stmt.executeUpdate("insert into STU(ID , Pwd , Name , Sex , Class , Collage)values('"+num.getText()+"','"+"12345678','"+nam.getText()+"','"+sex+"','"+clas.getText()+"','"+scl.getText()+"')");
				if(a==1)
				{
					JOptionPane.showMessageDialog(s,"�ѳɹ����");
				}
				else
				{
					JOptionPane.showMessageDialog(s,"���ʧ��");
				}
				stmt.close();
			}
			catch (SQLException se)
			{
				JOptionPane.showMessageDialog(s,se.getMessage());
			}
		}
		else
		{
			num.setText("");
			nam.setText("");
			clas.setText("");
			scl.setText("");
			num.requestFocus();
		}
	}

	public static void main(String[] args)
	{
		AddMsg amg = new AddMsg();
	}
}
