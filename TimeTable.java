import java.awt.Component;
import java.awt.EventQueue;
import java.io.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.Canvas;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TimeTable {

	private static JFrame frame;
	private JTable table;
	private JTabbedPane tabbedPane_1;
	private JTabbedPane tabbedPane;
	private static JComboBox[][] comboxes;
	private String[] years;
	private String days[] = {"Monday","Tuesday", "Wednesday", "Thursday", "Friday"};
	private boolean slist = true;

	/**
	 * Launch the application.
	 */
	public static void TimeTableGUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimeTable window = new TimeTable();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TimeTable() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws IOException {

		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 522, 451);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 26, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 522, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		sl_panel.putConstraint(SpringLayout.NORTH, tabbedPane, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, tabbedPane, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, tabbedPane, 26, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, tabbedPane, 522, SpringLayout.WEST, panel);
		panel.add(tabbedPane);
		springLayout.putConstraint(SpringLayout.NORTH, tabbedPane, 102, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, tabbedPane, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, tabbedPane, 450, SpringLayout.WEST, frame.getContentPane());
		try
		{
		File file1 = new File("Yeargroup.txt");
		Scanner scan1 = new Scanner(file1);
		Scanner scan2 = new Scanner(file1);
		int counter1 = 0;
		while(scan1.hasNextLine())
		{
			counter1 ++;
			scan1.nextLine();
		}
		scan1.close();
		String[] loadlist = new String[counter1];
		years = new String[counter1];
		for(int i = 0; i != counter1; i++)
		{
			loadlist[i] = scan2.nextLine();
		}
		scan2.close();
		for(int i =0; i != counter1; i++)
		{
			String temp1[] = loadlist[i].split(",");
			tabbedPane.addTab(temp1[0], null);
			years[i] = temp1[0];
		}
		}
		catch(java.io.FileNotFoundException e)
		{
			FileWriter fsadasd  = new FileWriter("Yeargroup.txt");
			fsadasd.close();
		}
		try
		{
			tabbedPane.setSelectedIndex(0);	
		}
		catch(java.lang.IndexOutOfBoundsException e)
		{
			;
		}
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				try {
					slist = false;
					addalloption();
					slist = true;
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					;
				}
			}
		});
		//frame.getContentPane().add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 6, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, 10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.EAST, panel);
		frame.getContentPane().add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JSeparator separator = new JSeparator();
		sl_panel_1.putConstraint(SpringLayout.WEST, separator, 0, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, separator, 0, SpringLayout.EAST, panel_1);
		panel_1.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		sl_panel_1.putConstraint(SpringLayout.WEST, separator_1, 0, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, separator_1, 0, SpringLayout.EAST, separator);
		panel_1.add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		sl_panel_1.putConstraint(SpringLayout.WEST, separator_1_1, 0, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, separator_1_1, 0, SpringLayout.EAST, separator);
		panel_1.add(separator_1_1);
		
		JSeparator separator_1_1_1 = new JSeparator();
		sl_panel_1.putConstraint(SpringLayout.SOUTH, separator_1_1, -6, SpringLayout.NORTH, separator_1_1_1);
		sl_panel_1.putConstraint(SpringLayout.NORTH, separator_1_1_1, 155, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, separator_1_1_1, 0, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, separator_1_1_1, 0, SpringLayout.EAST, separator);
		panel_1.add(separator_1_1_1);
		
		JSeparator separator_1_1_2 = new JSeparator();
		sl_panel_1.putConstraint(SpringLayout.WEST, separator_1_1_2, 0, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, separator_1_1_2, -177, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, separator_1_1_2, 0, SpringLayout.EAST, panel_1);
		panel_1.add(separator_1_1_2);
		
		JLabel lblNewLabel = new JLabel("Period 1");
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel, -18, SpringLayout.NORTH, separator_1);
		panel_1.add(lblNewLabel);
		
		JLabel lblPeriod = new JLabel("Period 2");
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblPeriod, -284, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.NORTH, separator_1_1, 14, SpringLayout.SOUTH, lblPeriod);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, separator_1, -6, SpringLayout.NORTH, lblPeriod);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblPeriod, 0, SpringLayout.EAST, lblNewLabel);
		panel_1.add(lblPeriod);
		
		JLabel lblPeriod_1 = new JLabel("Period 3");
		sl_panel_1.putConstraint(SpringLayout.SOUTH, separator_1_1_1, -6, SpringLayout.NORTH, lblPeriod_1);
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblPeriod_1, 182, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblPeriod_1, 10, SpringLayout.WEST, panel_1);
		panel_1.add(lblPeriod_1);
		
		JSeparator separator_1_1_2_1 = new JSeparator();
		sl_panel_1.putConstraint(SpringLayout.WEST, separator_1_1_2_1, 0, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, separator_1_1_2_1, 0, SpringLayout.EAST, panel_1);
		panel_1.add(separator_1_1_2_1);
		
		JLabel lblPeriod_1_1 = new JLabel("Period 4");
		sl_panel_1.putConstraint(SpringLayout.SOUTH, separator_1_1_2_1, -48, SpringLayout.NORTH, lblPeriod_1_1);
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblPeriod_1_1, 236, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblPeriod_1_1, 10, SpringLayout.WEST, separator_1_1_2);
		panel_1.add(lblPeriod_1_1);
		
		tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		for(String i: days)
		{
			tabbedPane_1.addTab(i, null);
		}
		tabbedPane_1.setSelectedIndex(0);
		tabbedPane_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				try {
					slist = false;
					addalloption();
					slist = true;
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					;
				}
			}
		});
		sl_panel_1.putConstraint(SpringLayout.WEST, tabbedPane_1, 0, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, tabbedPane_1, 0, SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.NORTH, separator, 6, SpringLayout.SOUTH, tabbedPane_1);
		sl_panel_1.putConstraint(SpringLayout.NORTH, tabbedPane_1, 0, SpringLayout.NORTH, panel_1);
		panel_1.add(tabbedPane_1);


		
		JLabel lblPeriod_1_1_1 = new JLabel("Period 5");
		sl_panel_1.putConstraint(SpringLayout.EAST, lblPeriod_1_1_1, 0, SpringLayout.EAST, lblNewLabel);
		panel_1.add(lblPeriod_1_1_1);
		
		JLabel lblPeriod_1_1_1_1 = new JLabel("Period 6");
		sl_panel_1.putConstraint(SpringLayout.WEST, lblPeriod_1_1_1_1, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblPeriod_1_1_1_1, -28, SpringLayout.SOUTH, panel_1);
		panel_1.add(lblPeriod_1_1_1_1);
		
		JSeparator separator_1_1_2_1_1 = new JSeparator();
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblPeriod_1_1_1, -13, SpringLayout.NORTH, separator_1_1_2_1_1);
		sl_panel_1.putConstraint(SpringLayout.NORTH, separator_1_1_2_1_1, 341, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, separator_1_1_2_1_1, 0, SpringLayout.WEST, separator);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, separator_1_1_2_1_1, -6, SpringLayout.NORTH, lblPeriod_1_1_1_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, separator_1_1_2_1_1, 0, SpringLayout.EAST, separator);
		panel_1.add(separator_1_1_2_1_1);
		
		JComboBox comboBox61 = new JComboBox();
		comboBox61.setMaximumSize(comboBox61.getPreferredSize());
		sl_panel_1.putConstraint(SpringLayout.NORTH, comboBox61, -4, SpringLayout.NORTH, lblPeriod_1_1_1_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, comboBox61, 27, SpringLayout.EAST, lblPeriod_1_1_1_1);
		panel_1.add(comboBox61);
		
		JComboBox comboBox62 = new JComboBox();
		sl_panel_1.putConstraint(SpringLayout.NORTH, comboBox62, -4, SpringLayout.NORTH, lblPeriod_1_1_1_1);
		comboBox62.setMaximumSize(comboBox62.getPreferredSize());
		panel_1.add(comboBox62);
		
		JComboBox comboBox63 = new JComboBox();
		comboBox63.setMaximumSize(comboBox63.getPreferredSize());
		sl_panel_1.putConstraint(SpringLayout.NORTH, comboBox63, -4, SpringLayout.NORTH, lblPeriod_1_1_1_1);
		panel_1.add(comboBox63);
		
		JComboBox comboBox51 = new JComboBox();
		comboBox51.setMaximumSize(comboBox51.getPreferredSize());
		sl_panel_1.putConstraint(SpringLayout.NORTH, comboBox51, -4, SpringLayout.NORTH, lblPeriod_1_1_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, comboBox51, 0, SpringLayout.WEST, comboBox61);
		panel_1.add(comboBox51);
		
		JComboBox comboBox52 = new JComboBox();
		sl_panel_1.putConstraint(SpringLayout.EAST, comboBox62, 0, SpringLayout.EAST, comboBox52);
		sl_panel_1.putConstraint(SpringLayout.NORTH, comboBox52, -4, SpringLayout.NORTH, lblPeriod_1_1_1);
		comboBox52.setMaximumSize(comboBox52.getPreferredSize());
		panel_1.add(comboBox52);
		
		JComboBox comboBox53 = new JComboBox();
		comboBox53.setMaximumSize(comboBox53.getPreferredSize());
		sl_panel_1.putConstraint(SpringLayout.WEST, comboBox63, 0, SpringLayout.WEST, comboBox53);
		sl_panel_1.putConstraint(SpringLayout.NORTH, comboBox53, -4, SpringLayout.NORTH, lblPeriod_1_1_1);
		panel_1.add(comboBox53);
		
		JComboBox comboBox41 = new JComboBox();
		comboBox41.setMaximumSize(comboBox41.getPreferredSize());
		sl_panel_1.putConstraint(SpringLayout.NORTH, separator_1_1_2_1, 25, SpringLayout.SOUTH, comboBox41);
		sl_panel_1.putConstraint(SpringLayout.NORTH, comboBox41, -4, SpringLayout.NORTH, lblPeriod_1_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, comboBox41, 0, SpringLayout.WEST, comboBox61);
		panel_1.add(comboBox41);
		
		JComboBox comboBox42 = new JComboBox();
		sl_panel_1.putConstraint(SpringLayout.EAST, comboBox52, 0, SpringLayout.EAST, comboBox42);
		sl_panel_1.putConstraint(SpringLayout.NORTH, comboBox42, 6, SpringLayout.SOUTH, separator_1_1_2);
		comboBox42.setMaximumSize(comboBox42.getPreferredSize());
		panel_1.add(comboBox42);
		
		JComboBox comboBox43 = new JComboBox();

		sl_panel_1.putConstraint(SpringLayout.WEST, comboBox53, 0, SpringLayout.WEST, comboBox43);
		sl_panel_1.putConstraint(SpringLayout.NORTH, comboBox43, -4, SpringLayout.NORTH, lblPeriod_1_1);
		panel_1.add(comboBox43);
		
		JComboBox comboBox31 = new JComboBox();
		comboBox31.setMaximumSize(comboBox31.getPreferredSize());
		sl_panel_1.putConstraint(SpringLayout.WEST, comboBox31, 0, SpringLayout.WEST, comboBox61);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, comboBox31, -6, SpringLayout.NORTH, separator_1_1_2);
		panel_1.add(comboBox31);
		
		JComboBox comboBox32 = new JComboBox();
		sl_panel_1.putConstraint(SpringLayout.EAST, comboBox42, 0, SpringLayout.EAST, comboBox32);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, comboBox32, -6, SpringLayout.NORTH, separator_1_1_2);
		comboBox32.setMaximumSize(comboBox32.getPreferredSize());
		panel_1.add(comboBox32);
		
		JComboBox comboBox33 = new JComboBox();
		comboBox33.setMaximumSize(comboBox33.getPreferredSize());
		sl_panel_1.putConstraint(SpringLayout.WEST, comboBox43, 0, SpringLayout.WEST, comboBox33);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, comboBox33, -6, SpringLayout.NORTH, separator_1_1_2);
		panel_1.add(comboBox33);
		
		JSeparator separator_2 = new JSeparator();
		sl_panel_1.putConstraint(SpringLayout.NORTH, separator_2, 25, SpringLayout.SOUTH, comboBox41);
		sl_panel_1.putConstraint(SpringLayout.WEST, separator_2, 0, SpringLayout.WEST, separator);
		sl_panel_1.putConstraint(SpringLayout.EAST, separator_2, 0, SpringLayout.EAST, separator);
		panel_1.add(separator_2);
		
		JSeparator separator_1_1_2_2 = new JSeparator();
		sl_panel_1.putConstraint(SpringLayout.WEST, separator_1_1_2_2, -71, SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, separator_1_1_2_2, -130, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, separator_1_1_2_2, -71, SpringLayout.EAST, panel_1);
		panel_1.add(separator_1_1_2_2);
		
		JSeparator separator_3 = new JSeparator();
		sl_panel_1.putConstraint(SpringLayout.NORTH, separator_3, -18, SpringLayout.NORTH, separator_1_1_2_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, separator_3, 0, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, separator_3, -6, SpringLayout.NORTH, separator_2);
		sl_panel_1.putConstraint(SpringLayout.EAST, separator_3, 0, SpringLayout.EAST, separator);
		panel_1.add(separator_3);
		
		JComboBox comboBox21 = new JComboBox();
		comboBox21.setMaximumSize(comboBox21.getPreferredSize());
		sl_panel_1.putConstraint(SpringLayout.WEST, comboBox21, 0, SpringLayout.WEST, comboBox61);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, comboBox21, -6, SpringLayout.NORTH, separator_1_1);
		panel_1.add(comboBox21);
		
		JComboBox comboBox22 = new JComboBox();
		sl_panel_1.putConstraint(SpringLayout.EAST, comboBox32, 0, SpringLayout.EAST, comboBox22);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, comboBox22, -6, SpringLayout.NORTH, separator_1_1);
		comboBox22.setMaximumSize(comboBox22.getPreferredSize());
		panel_1.add(comboBox22);
		
		JComboBox comboBox23 = new JComboBox();
		comboBox23.setMaximumSize(comboBox23.getPreferredSize());
		sl_panel_1.putConstraint(SpringLayout.WEST, comboBox33, 0, SpringLayout.WEST, comboBox23);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, comboBox23, -6, SpringLayout.NORTH, separator_1_1);
		panel_1.add(comboBox23);
		
		JComboBox comboBox11 = new JComboBox();
		comboBox11.setMaximumSize(new Dimension(52, 27));
		sl_panel_1.putConstraint(SpringLayout.WEST, comboBox11, 0, SpringLayout.WEST, comboBox61);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, comboBox11, -6, SpringLayout.NORTH, separator_1);
		panel_1.add(comboBox11);
		
		JComboBox comboBox12 = new JComboBox();
		sl_panel_1.putConstraint(SpringLayout.EAST, comboBox22, 0, SpringLayout.EAST, comboBox12);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, comboBox12, -6, SpringLayout.NORTH, separator_1);
		comboBox12.setMaximumSize(comboBox12.getPreferredSize());
		panel_1.add(comboBox12);
		
		JComboBox comboBox13 = new JComboBox();
		sl_panel_1.putConstraint(SpringLayout.EAST, comboBox12, -28, SpringLayout.WEST, comboBox13);
		comboBox13.setMaximumSize(comboBox13.getPreferredSize());
		sl_panel_1.putConstraint(SpringLayout.WEST, comboBox23, 0, SpringLayout.WEST, comboBox13);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, comboBox13, -6, SpringLayout.NORTH, separator_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, comboBox13, -48, SpringLayout.EAST, panel_1);
		panel_1.add(comboBox13);
		
		comboxes = new JComboBox[6][3];
		
		comboxes[0][0] = comboBox11;
		comboxes[0][1] = comboBox12;
		comboxes[0][2] = comboBox13;
		
		comboxes[1][0] = comboBox21;
		comboxes[1][1] = comboBox22;
		comboxes[1][2] = comboBox23;
		
		comboxes[2][0] = comboBox31;
		comboxes[2][1] = comboBox32;
		comboxes[2][2] = comboBox33;

		comboxes[3][0] = comboBox41;
		comboxes[3][1] = comboBox42;
		comboxes[3][2] = comboBox43;
		
		comboxes[4][0] = comboBox51;
		comboxes[4][1] = comboBox52;
		comboxes[4][2] = comboBox53;

		comboxes[5][0] = comboBox61;
		comboxes[5][1] = comboBox62;
		comboxes[5][2] = comboBox63;



		for(int y = 0; y!= comboxes.length;y++)
		{
			for( int x = 0; x != comboxes[y].length;x++)
			{
				comboxes[y][x].setPrototypeDisplayValue("class123");
			}
		}
		
//		emptyfile();
		slist = false;
		addalloption();
		slist = true;
		comboBox13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					savelist();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					;
				}
			}
		});
		comboBox12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					savelist();
				} catch (IOException e1) {
				;
				
			}
		}});
		comboBox11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					savelist();
				} catch (IOException e1) {
				;
				}
			}
		});
		comboBox23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					savelist();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
				;
				}
			}
		});
		comboBox22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					savelist();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
				;
				}
			}
		});
		comboBox21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					savelist();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
				;
				}
			}
		});
		comboBox33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					savelist();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
				;
				}
			}
			
		});
		comboBox32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					savelist();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
				;
				}
			}
		});
		comboBox31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					savelist();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
				;
				}
			}
		});
		comboBox43.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					savelist();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
				;
				}
			}
		});
		comboBox42.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					savelist();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
				;
				}
			}
		});
		comboBox41.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					savelist();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
				;
				}
			}
		});
		comboBox53.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					savelist();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
				;
				}
			}
		});
		comboBox52.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					savelist();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
				;
				}
			}
		});
		comboBox51.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					savelist();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
				;
				}
			}
		});
		comboBox63.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					savelist();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
				;
				}
			}
		});
		comboBox62.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					savelist();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
				;
				}
			}
		});
		comboBox61.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					savelist();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
				;
				}
			}
		});
		
	}
	public void updatelist1(String year, String day) throws IOException
	{
		try
		{
		File f1 = new File("timetable.txt");
		Scanner s1 = new Scanner(f1);
		Scanner s2 = new Scanner(f1);
		int counterSOMENUMBER = 0;
		while(s1.hasNextLine())
		{
			s1.nextLine();
			counterSOMENUMBER++;
		}
		s1.close();
		String[] YearDayClass = new String[counterSOMENUMBER];
		for(int i = 0; i!= counterSOMENUMBER; i ++)
		{
			YearDayClass[i] = s2.nextLine();
			//System.out.println(YearDayClass[i]);
		}
		s2.close();
		for(int i = 0; i != counterSOMENUMBER; i ++)
		{
			String[] year_day_class = YearDayClass[i].split(":");
			if(year.equals(year_day_class[0]) && day.equals(year_day_class[1]))
			{
				String temp2[] = year_day_class[2].split(",");
				String sameperiodsplit[] = null;
				for( int n = 0; n != temp2.length; n++)
				{
					try
					{
						sameperiodsplit = temp2[n].split("/");
					}
					catch (java.lang.ArrayIndexOutOfBoundsException e1)
					{
						;
					}
					for( int t = 0; t != sameperiodsplit.length; t++)
					{
						int size = comboxes[n][t].getItemCount();
						for(int c = 0; c != size; c ++)
						{
							String temp1 = ((String) comboxes[n][t].getItemAt(c)).trim();
							String temp3 = sameperiodsplit[t].trim();
							if(temp1.equals(temp3))
							{
								comboxes[n][t].setSelectedIndex(c);
							}
						}
					}
				}
			}
		}
		}
		catch(java.io.FileNotFoundException e)
		{
			FileWriter asdsadasd = new FileWriter("timetable.txt");
			asdsadasd.close();
		}
		
	}
	public void savelist() throws IOException
	{
		if( slist == true)
		{
		String year = years[tabbedPane.getSelectedIndex()];
		String day = days[tabbedPane_1.getSelectedIndex()];

		File savetofile = new File("timetable.txt");
		Scanner scan1 = new Scanner(savetofile);
		Scanner scan2 = new Scanner(savetofile);
		int counterSOMENUMBERPLUSONE = 0;
		while(scan1.hasNextLine())
		{
			scan1.nextLine();
			counterSOMENUMBERPLUSONE ++;
		}
		scan1.close();
		String[] all_line_by_line = new String[counterSOMENUMBERPLUSONE];
		for(int i = 0; i != counterSOMENUMBERPLUSONE; i ++)
		{
			all_line_by_line[i] = scan2.nextLine();
		}
		scan2.close();

		FileWriter f1 = new FileWriter("timetable.txt", false);
		PrintWriter print = new PrintWriter(f1);
		String tosave = (year + ":" + day + ":");
		
		for(int y = 0; y != comboxes.length;y++)
		{
			for(int x = 0; x != comboxes[y].length;x++)
			{
				if(comboxes[y][x].getSelectedItem() == null)
				{
					;
				}
				else
				{
					tosave += comboxes[y][x].getSelectedItem() + "/";
				}
			}
			tosave += ",";
		}
		String[] temp22 = tosave.split(":");
		for( int i = 0; i != all_line_by_line.length; i ++)
		{
			String[] temp11 = all_line_by_line[i].split(":");
			if(temp11[0].equals(temp22[0]) && temp11[1].equals(temp22[1]))
			{
				print.println(tosave);
			}
			else
			{
				print.println(all_line_by_line[i]);
			}
		}
		print.close();
		f1.close();
		}
	}
	public void addalloption() throws IOException
	{
		try
		{
		try
		{
		for( int y = 0; y != comboxes.length; y ++)
		{
			for( int x = 0; x != comboxes[y].length; x ++)
			{
				comboxes[y][x].removeAllItems();
			}
			
		}
		}
		catch(java.lang.NullPointerException e)
		{
			;
		}
		
		for( int y = 0; y != comboxes.length; y ++)
		{
			for( int x = 0; x != comboxes[y].length; x ++)
			{
				comboxes[y][x].addItem("");
			}
			
		}
		try
		{
		File file1 = new File("Classes.txt");
		Scanner scan4 = new Scanner(file1);
		Scanner scan5 = new Scanner(file1);
		int counterSOMENUMBERPLUSTWO = 0;
		while( scan4.hasNextLine())
		{
			scan4.nextLine();
			counterSOMENUMBERPLUSTWO ++;
		}
		scan4.close();
		String classfile[] = new String[counterSOMENUMBERPLUSTWO];
		for( int i = 0; i != counterSOMENUMBERPLUSTWO; i ++)
		{
			classfile[i] = scan5.nextLine();
		}
		scan5.close();
		String classes[] = new String[counterSOMENUMBERPLUSTWO];
		for( int i  = 0; i != counterSOMENUMBERPLUSTWO; i ++)
		{
			String temp[] = classfile[i].split(",");
			//System.out.println(temp[0]);
			if( temp[0].equals( years[tabbedPane.getSelectedIndex()]))
			{
				classes[i] = temp[2];
			}

			
		}
		for( int i = 0; i != classes.length; i ++)
		{
			for( int y = 0; y != comboxes.length; y ++)
			{
				for( int x = 0; x != comboxes[y].length; x ++)
				{
					if(classes[i] != null)
					{
						comboxes[y][x].addItem(classes[i]);
					}
				}
				
			}
		}
		}
		catch(java.io.FileNotFoundException e)
		{
			FileWriter adfadsf = new FileWriter("Classes.txt");
			adfadsf.close();
		}
		

		
		}
		catch(java.lang.ArrayIndexOutOfBoundsException e)
		{
			;
		}
		String year  = "";
		try
		{
			year = years[tabbedPane.getSelectedIndex()];
		}
		catch(java.lang.ArrayIndexOutOfBoundsException|java.lang.NullPointerException e)
		{
			;
		}
		String day = days[tabbedPane_1.getSelectedIndex()];
		updatelist1(year,day);
		
	}

//	public void emptyfile() throws IOException
//	{
//		try
//		{
//			File file3 = new File("timetable.txt");
//			Scanner scan11 = new Scanner(file3);
//			scan11.nextLine();
//			scan11.close();
//		}
//		catch(java.util.NoSuchElementException e)
//		{
//			File file2 = new File("Yeargroup.txt");
//			Scanner scan1 = new Scanner(file2);
//			Scanner scan2 = new Scanner(file2);
//			int counterone = 0;
//			while(scan1.hasNextLine())
//			{
//				scan1.nextLine();
//				counterone ++;
//
//			}
//			scan1.close();
//			String[] list1 = new String[counterone];
//			for( int i = 0; i != counterone; i ++)
//			{
//				String temp1[] = scan2.nextLine().split(",");
//				list1[i] = temp1[0];
//			}
//			scan2.close();
//			FileWriter f1 = new FileWriter("timetable.txt",false);
//			PrintWriter p1 = new PrintWriter(f1);
//			for(int i = 0; i != list1.length; i ++)
//			{
//				for( int c = 0; c != 5; c ++)
//				{
//					p1.println(list1[i] + ":" + days[c] + ":" + "///,///,///,///,///,///");
//				}
//			}
//			f1.close();
//			p1.close();
//		}
//	}
	public static void framedispose()
	{
		frame.dispose();
	}
}
