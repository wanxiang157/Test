package ѧ����Ϣ����ϵͳ;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Teachers extends JFrame implements ActionListener
{
	JMenuBar bar = new JMenuBar();
	JMenu menu1 = new JMenu("��Ϣ");
	JMenu menu2 = new JMenu("�ɼ�");
	JMenuItem item1 = new JMenuItem("¼����Ϣ");
	JMenuItem item2 = new JMenuItem("¼��ɼ�");
	JPanel jpl = new JPanel();

	public Teachers()
	{
		super("��ʦ����");
		this.setSize(500,300);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(bar);
		this.add(jpl);
		jpl.setLayout(null);
		bar.add(menu1);
		bar.add(menu2);
		menu1.add(item1);
		menu2.add(item2);
		item1.addActionListener(this);
		item2.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==item1)
		{
			AddMsg msg = new AddMsg();
		}
		else
		{
			Addscore as = new Addscore();
		}
	}

	public static void main(String[] args)
	{
		Teachers tch = new Teachers();
	}
}

