import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Dimension;
import net.miginfocom.swing.MigLayout;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.border.MatteBorder;

public class StudentTaskViewer {

	private static JFrame frame;
	private DefaultListModel<String> list1 = new DefaultListModel<String>();
	private JList list;
	private ArrayList<String> a1;
	private JLabel datelabel ;
	private ArrayList a2;
	private JLabel classlabel;
	private JLabel titlelable;
	private JTextArea textArea;
	private ArrayList a3;

	/**
	 * Launch the application.
	 */
	public static void GUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentTaskViewer window = new StudentTaskViewer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public StudentTaskViewer() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		Color panelcolour = Color.decode("#fefcf4");
		frame = new JFrame();
		frame.getContentPane().setBackground(panelcolour);
		frame.setBounds(100, 100, 454, 300);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		list = new JList(list1);
		list.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		addtolist();
		springLayout.putConstraint(SpringLayout.NORTH, list, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, list, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, list, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, list, 139, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(list);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2 && !e.isConsumed()) {
					e.consume();
					loaddata();
				}
			}
		});
		titlelable = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.WEST, titlelable, 6, SpringLayout.EAST, list);
		titlelable.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(titlelable);
		
		datelabel = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.NORTH, datelabel, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, datelabel, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(datelabel);
		
		classlabel = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.NORTH, classlabel, 0, SpringLayout.NORTH, datelabel);
		springLayout.putConstraint(SpringLayout.WEST, classlabel, 6, SpringLayout.EAST, list);
		frame.getContentPane().add(classlabel);
		
		textArea = new JTextArea();
		textArea.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		springLayout.putConstraint(SpringLayout.NORTH, textArea, 52, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textArea, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, titlelable, -6, SpringLayout.NORTH, textArea);
		textArea.setEditable(false);
		springLayout.putConstraint(SpringLayout.WEST, textArea, 6, SpringLayout.EAST, list);
		springLayout.putConstraint(SpringLayout.EAST, textArea, 305, SpringLayout.EAST, list);
		frame.getContentPane().add(textArea);
		
		
		list.setSelectedIndex(0);
		loaddata();
	}
	public void getClasses() throws IOException
	{
		a1 = new ArrayList<String>();
		File f1 = new File("Just Logged In.txt");
		Scanner s1 = new Scanner(f1);
		String currentsuser = s1.nextLine();
		s1.close();

		String[] currentuser2 = currentsuser.split(",");
		String name = currentuser2[1];
		String priv = currentuser2[3];

		File f2 = new File("Classes.txt");
		Scanner s3 = new Scanner(f2);
		Scanner s4 = new Scanner(f2);
		int counter = 0;
		while(s3.hasNextLine())
		{
			s3.nextLine();
			counter ++;
		}
		s3.close();
		String[] classes = new String[counter];
		for(int i = 0; i != counter; i ++)
		{
			classes[i] = s4.nextLine();
		}
		s4.close();
		for(int c = 0; c != counter; c ++)
		{
			String[] temp = classes[c].split(",");
			for(int k = 0; k != temp.length; k++)
			{
				if(temp[k].equals(name + " [" + priv + "]"))
				{
					a1.add(temp[2]);
				}
			}
		}
	}
	public void addtolist() throws IOException
	{
		a3 = new ArrayList();
		getClasses();
		a2 = new ArrayList<String>();
		File f1 = new File("HomewWork.txt");
		Scanner s1 = new Scanner(f1);
		while(s1.hasNextLine())
		{
			a2.add(s1.nextLine());
		}
		s1.close();
		for(int i= 0; i != a2.size(); i ++)
		{
			String temp1[] = ((String) a2.get(i)).split(",");
			
				if(a1.contains(temp1[2]))
				{
					list1.addElement(temp1[1] + "," + temp1[2] + "," + temp1[3]);
					a3.add(a2.get(i));
				}
			
		}

	}
	public void loaddata()
	{
		String temp2 = (String) a3.get(list.getSelectedIndex());
		String temp3[] = temp2.split(",");
		datelabel.setText(temp3[1]);
		classlabel.setText(temp3[2]);
		titlelable.setText(temp3[3]);
		textArea.setText(temp3[4]);
	}
	public static void disframe()
	{
		frame.dispose();
	}
}
