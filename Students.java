package 学生信息管理系统;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Students extends JFrame implements ActionListener
{
	JMenuBar jmb = new JMenuBar();
	JMenu Message = new JMenu("信息");
	JMenu Score = new JMenu("成绩");
	JMenuItem Item1 = new JMenuItem("插入");
	JMenuItem Item2 = new JMenuItem("查询");
	JMenuItem Item3 = new JMenuItem("查询");

	public Students()
	{
		super("学生界面");
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
