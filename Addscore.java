package ѧ����Ϣ����ϵͳ;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Addscore extends JFrame implements ActionListener
{
	static Addscore ss;
	JLabel[] label = {new JLabel("ѧ�ţ�") , new JLabel("��������磺") , new JLabel("Linux����ϵͳ��") , new JLabel("�����רҵӢ�") , new JLabel("�������Ϣ����������") , new JLabel("Java������ƣ�") , new JLabel("���ݿ�Ӧ��ʵѵ�̳̣�") , new JLabel("�ߵ���ѧ��") , new JLabel("XML��")}; 
	JTextField[] txt = {new JTextField() , new JTextField() , new JTextField() , new JTextField() , new JTextField() ,new JTextField() , new JTextField() ,new JTextField() ,new JTextField() };
	JButton add = new JButton("���");
	JButton reset = new JButton("����");
	JPanel jpl = new JPanel();
	JLabel title = new JLabel("���ѧ���ɼ�" , JLabel.CENTER);
	Font f = new Font("����" , Font.BOLD , 16 );
	int s = 100;

	public Addscore()
	{
		super("���ѧ����Ϣ");
		this.setResizable(false);
		this.setSize(500,600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.add(jpl);
		add.addActionListener(this);
		reset.addActionListener(this);
		jpl.setLayout(null);
		title.setBounds(150,40,200,20);
		title.setFont(f);
		title.setForeground(Color.red);
		jpl.setBackground(Color.LIGHT_GRAY);
		jpl.add(title);
		for(int i = 0 ; i <label.length ; i++)
		{
			label[i].setBounds(100,s,140,20);
			jpl.add(label[i]);
			txt[i].setBounds(260,s,140,20);
			jpl.add(txt[i]);
			s=s+40;
		}
		add.setBounds(150,s,80,20);
		reset.setBounds(250,s,80,20);
		jpl.add(add);
		jpl.add(reset);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==add)
		{
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			}
			catch (ClassNotFoundException ce)
			{
				JOptionPane.showMessageDialog(ss,ce.getMessage());
			}
			try
			{
				Connection con = DriverManager.getConnection("jdbc:odbc:sysdb","sa","");
				Statement stmt = con.createStatement();
				int a = stmt.executeUpdate("insert into �����ϵ�ɼ�(SID , ��������� , Linux����ϵͳ , �����רҵӢ�� , �������Ϣ�������� , Java������� , ���ݿ�Ӧ��ʵѵ�̳� , �ߵ���ѧ , Xml)values('"+txt[0].getText()+"','"+txt[1].getText()+"','"+txt[2].getText()+"','"+txt[3].getText()+"','"+txt[4].getText()+"','"+txt[5].getText()+"','"+txt[6].getText()+"','"+txt[7].getText()+"','"+txt[8].getText()+"')");
				if(a==1)
				{
					JOptionPane.showMessageDialog(ss,"��ӳɹ�");
				}
				else
				{
					JOptionPane.showMessageDialog(ss,"���ʧ��");
				}
			}
			catch (SQLException se)
			{
				JOptionPane.showMessageDialog(ss,se.getMessage());
			}
		}
		else
		{
			for(int i = 0 ; i<txt.length ; i++)
			{
				txt[i].setText("");
				txt[0].requestFocus();
			}
		}
	}

	public static void main(String[] args)
	{
		Addscore as = new Addscore();
	}
}