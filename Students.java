package ѧ����Ϣ����ϵͳ;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Students extends JFrame implements ActionListener
{
	JMenuBar jmb = new JMenuBar();
	JMenu Message = new JMenu("��Ϣ");
	JMenu Score = new JMenu("�ɼ�");
	JMenuItem Item1 = new JMenuItem("����");
	JMenuItem Item2 = new JMenuItem("��ѯ");
	JMenuItem Item3 = new JMenuItem("��ѯ");

	public Students()
	{
		super("ѧ������");
		this.setSize(500,400);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(jmb);
		jmb.add(Message);
		jmb.add(Score);
		Message.add(Item1);
		Message.add(Item2);
		Score.add(Item3);
		Item1.addActionListener(this);
		Item2.addActionListener(this);
		Item3.addActionListener(this);
   }

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==Item1)
		{
			AddMsg ad = new AddMsg();
		}
		else if(e.getSource()==Item2)
		{
			Serch ser = new Serch();
		}
		else
		{
			Score so = new Score();
		}
	}

	public static void main(String[] args)
	{
		Students stu = new Students();
	}
}
