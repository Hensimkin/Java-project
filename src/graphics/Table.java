package graphics;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * The class that take care of info option(which animal is in the zoo)
 * @author Adir Melker 316614569 and Hen Simkin 208514109
 *
 */
public class Table 
{
	JFrame frame;
	public Table(JTable table)
	{
		frame=new JFrame("Animal Table");
		frame.setSize(500,300);
		frame.setVisible(true);
		JScrollPane scroll=new JScrollPane(table);
		frame.add(scroll);
	}

}
