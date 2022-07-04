import java.awt.EventQueue;
import java.io.*;
import java.util.*;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import java.util.List; 
import java.util.ArrayList;
import javax.swing.JTabbedPane; 

public class ClassesandSubjects {

	private static JFrame frame;
	public static DefaultListModel<String> list1 = new DefaultListModel<String>();
	public JList list;
	public String currentlist[] = {"Year Groups", "Subjects", "Classes", "Teachers & Studnets"};
	public static String searchtermpath[] = new String[3];
	public int counter = 0;
	private JTextField textField;
	private JTextField textField_1;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JScrollPane scrollPane_1;
	public DefaultListModel<String> list10 = new DefaultListModel<String>();
	public JList list11;
	/**
	 * Launch the application.
	 */
	public static void ClasseditorGUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClassesandSubjects window = new ClassesandSubjects();
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
	public ClassesandSubjects() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 487, 323);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		try {
		listupdate("Year Groups","null");
		}
		catch(java.io.FileNotFoundException exe1)
		{
			FileWriter f1 = new FileWriter("Yeargroup.txt");
			FileWriter f2 = new FileWriter("Subject.txt");
			FileWriter f3 = new FileWriter("Classes.txt");
			f1.close();
			f2.close();
			f3.close();
		}
		
			
			JLayeredPane layeredPane = new JLayeredPane();
			springLayout.putConstraint(SpringLayout.NORTH, layeredPane, 10, SpringLayout.NORTH, frame.getContentPane());
			springLayout.putConstraint(SpringLayout.WEST, layeredPane, 10, SpringLayout.WEST, frame.getContentPane());
			springLayout.putConstraint(SpringLayout.SOUTH, layeredPane, -61, SpringLayout.SOUTH, frame.getContentPane());
			frame.getContentPane().add(layeredPane);
			layeredPane.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 0, 417, 230);
			layeredPane.add(scrollPane);
			
			lblNewLabel = new JLabel("Year Groups");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			scrollPane.setColumnHeaderView(lblNewLabel);
			
			
			list = new JList(list1);
			list.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				if( counter != 3) {
					if (e.getClickCount() == 2 && !e.isConsumed()) {
	                    e.consume();
	                   String currentvalue = (String) list.getSelectedValue();
	                   if(currentvalue != null)
	                   {
	                   counter += 1;
	                   if(counter == 4)
	                	   counter -= 1;
	                   else
	                	  lblNewLabel.setText(currentlist[counter]);
	                   searchtermpath[counter-1] = currentvalue;
	             try {
						listupdate(currentlist[counter],searchtermpath[counter-1]);
					} 
	             catch (IOException| java.lang.ArrayIndexOutOfBoundsException e1) 
	             {
						;
				}
	             updatepath();
					}
					}
					}
				}
			});
			scrollPane.setViewportView(list);
			
			scrollPane.show(true);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setVisible(false);
		scrollPane_1.setBounds(107, 75, 225, 110);
		layeredPane.add(scrollPane_1);
		
		list11 = new JList(list10);
		scrollPane_1.setViewportView(list11);
		
		JLabel lblNewLabel_3 = new JLabel("Teachers & Students");
		lblNewLabel_3.setVisible(false);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_1.setColumnHeaderView(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("-");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					deleteitem(currentlist[counter]);
				} catch (IOException e1) {
					;
				}
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 433, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("«");
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_2, 433, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_2, -262, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_2, -10, SpringLayout.EAST, frame.getContentPane());
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				counter -= 1;
			
                 if(counter == -1) 
              	   counter += 1;
              	  else
                	 lblNewLabel.setText(currentlist[counter]);
                 try {
                	 if(counter != 0)
                		 listupdate(currentlist[counter],searchtermpath[counter-1]);
                	 else
                		 listupdate(currentlist[counter],"null");
				} catch (IOException e1) {
					;
				}
                 updatepath();
			}
		});
		

		JButton btnNewButton = new JButton("+");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 7, SpringLayout.SOUTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, 0, SpringLayout.EAST, btnNewButton);
		springLayout.putConstraint(SpringLayout.EAST, layeredPane, -6, SpringLayout.WEST, btnNewButton);
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 6, SpringLayout.SOUTH, btnNewButton_2);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 433, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -10, SpringLayout.EAST, frame.getContentPane());
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.show(false);
				panel.show(true);
				lblNewLabel_2.setText(currentlist[counter]);
				if(currentlist[counter].equals("Teachers & Studnets")) 
				{
					scrollPane_1.show(true);
					try {
						studentlistupdate();
					} catch (IOException e1) {
						;
					}
					textField_1.enable(false);

				}
			}
		});
		frame.getContentPane().add(btnNewButton);
		frame.getContentPane().add(btnNewButton_2);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 6, SpringLayout.SOUTH, layeredPane);
		springLayout.putConstraint(SpringLayout.EAST, textField, 0, SpringLayout.EAST, layeredPane);
		
		panel = new JPanel();
		panel.setVisible(false);
		
		panel.setBounds(70, 6, 284, 57);
		layeredPane.add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("New label");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_2, 124, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -12, SpringLayout.NORTH, textField_1);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 0, SpringLayout.NORTH, lblNewLabel_2);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1, -6, SpringLayout.WEST, lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton_3 = new JButton("Add");
		sl_panel.putConstraint(SpringLayout.NORTH, textField_1, 0, SpringLayout.NORTH, btnNewButton_3);
		sl_panel.putConstraint(SpringLayout.EAST, textField_1, -6, SpringLayout.WEST, btnNewButton_3);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton_3, 0, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_3, -10, SpringLayout.EAST, panel);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addname(currentlist[counter]);
				} catch (IOException e1) {
					;
				}
			}
			
		});
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("x");
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_4, 2, SpringLayout.NORTH, textField_1);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_4, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton_4, 0, SpringLayout.SOUTH, textField_1);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_4, -2, SpringLayout.WEST, textField_1);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.show(true);
				panel.show(false);
				scrollPane_1.show(false);
				textField_1.enable(true);
			}
		});
		btnNewButton_4.setFont(new Font("Lucida Grande", Font.PLAIN, 7));
		panel.add(btnNewButton_4);
		panel.show(false);
		springLayout.putConstraint(SpringLayout.WEST, textField, 10, SpringLayout.WEST, frame.getContentPane());
		textField.setEditable(false);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
	public static void listupdate(String currnetgroup, String searchitem) throws IOException
	{
		while(list1.isEmpty() == false)
        {
            list1.remove(0);
        }
		if(currnetgroup.equals("Year Groups"))
		{
			File yeargroup = new File("Yeargroup.txt");
			Scanner s1 = new Scanner(yeargroup);
			Scanner s2 = new Scanner(yeargroup);
			int counter2 = 0;
			while( s1.hasNext())
			{
				counter2 ++;
				s1.nextLine();
			}
			String process[] = new String[counter2];
			for(int i = 0; i!= counter2; i++)
			{
				process[i] = s2.nextLine();
				String splitlist[] = process[i].split(",");
				list1.addElement(splitlist[0]);
			}
			s1.close();
			s2.close();
		}
		if(currnetgroup.equals("Subjects"))
		{
			File yeargroup = new File("Yeargroup.txt");
			Scanner s1 = new Scanner(yeargroup);
			Scanner s2 = new Scanner(yeargroup);
			int counter2 = 0;
			while( s1.hasNext())
			{
				counter2 ++;
				s1.nextLine();
			}
			String process[] = new String[counter2];
			for(int i = 0; i!= counter2; i++)
			{
				process[i] = s2.nextLine();
				String splitlist[] = process[i].split(",");
				if(splitlist[0].equals(searchitem))
				{
					for(int c = 1; c != splitlist.length; c ++)
					{
						list1.addElement(splitlist[c]);
					}
				}
			}
			s1.close();
			s2.close();
		}
		if(currnetgroup.equals("Classes"))
		{
			File yeargroup = new File("Subject.txt");
			Scanner s1 = new Scanner(yeargroup);
			Scanner s2 = new Scanner(yeargroup);
			int counter2 = 0;
			while( s1.hasNext())
			{
				counter2 ++;
				s1.nextLine();
			}
			String process[] = new String[counter2];
			for(int i = 0; i!= counter2; i++)
			{
				process[i] = s2.nextLine();
				String splitlist[] = process[i].split(",");
				if(splitlist[1].equals(searchitem) && splitlist[0].equals(searchtermpath[0]))
				{
					for(int c = 2; c != splitlist.length; c ++)
					{
						list1.addElement(splitlist[c]);
					}
				}
			}
			s1.close();
			s2.close();
		}
		if(currnetgroup.equals("Teachers & Studnets"))
		{
			File yeargroup = new File("Classes.txt");
			Scanner s1 = new Scanner(yeargroup);
			Scanner s2 = new Scanner(yeargroup);
			int counter2 = 0;
			while( s1.hasNext())
			{
				counter2 ++;
				s1.nextLine();
			}
			String process[] = new String[counter2];
			for(int i = 0; i!= counter2; i++)
			{
				process[i] = s2.nextLine();
				String splitlist[] = process[i].split(",");
				if(splitlist[2].equals(searchitem) && splitlist[0].equals(searchtermpath[0]) && splitlist[1].equals(searchtermpath[1]))
				{
					for(int c = 3; c != splitlist.length; c ++)
					{
						list1.addElement(splitlist[c]);
					}
				}
			}
			s1.close();
			s2.close();
		}
	}
	public void updatepath()
	{
        textField.setText("");
        for( int v = 0; v != counter; v++)
         {
        	 String getcurrenttext = textField.getText();
        	 textField.setText(getcurrenttext + "/" + searchtermpath[v]);
         }
	}
	@SuppressWarnings("deprecation")
	public void addname(String currnetgroup) throws IOException
	{
		String currenttext = textField_1.getText();;
		if(currenttext.equals("") == false)
		{
		if(currnetgroup.equals("Year Groups"))
		{
			FileWriter f1 = new FileWriter("Yeargroup.txt",true);
			PrintWriter p1 = new PrintWriter(f1);
			p1.println(currenttext + ",");
			p1.close();
			f1.close();
	
			FileWriter f111 = new FileWriter("timetable.txt",true);
			PrintWriter p111 = new PrintWriter(f111);
			String days[] = {"Monday","Tuesday","Wednesday","Thursday","Friday"};
			for( int i = 0; i != 5 ; i ++)
			{
				p111.println(currenttext + ":" + days[i] + ":///,///,///,///,///,///,");
			}
			p111.close();
			f111.close();
		}
		if(currnetgroup.equals("Subjects"))
		{
			File f2 = new File("Yeargroup.txt");
			Scanner s1 = new Scanner(f2);
			Scanner s2 = new Scanner(f2);

			int counter1 = 0;
			while(s1.hasNextLine())
			{
				counter1++;
				s1.nextLine();
			}
			s1.close();
			String list1[] = new String[counter1];
			for(int i = 0; i != counter1; i++)
			{
				list1[i] = s2.nextLine();
			}
			s2.close();
			FileWriter f3 = new FileWriter("Yeargroup.txt", false);
			PrintWriter p2 = new PrintWriter(f3);
			String[] process1 = null;
			for(int b = 0; b != counter1; b++)
			{
				try 
				{
					process1 = list1[b].split(",");
				}
				catch(NullPointerException exe1)
				{
					;
				}
				if(process1[0].equals(searchtermpath[0]))
				{
					p2.println(list1[b] + currenttext + ",");
				}
				else
				{
					p2.println(list1[b]);
				}
			}
			f3.close();
			p2.close();
			FileWriter f4 = new FileWriter("Subject.txt",true);
			PrintWriter p3 = new PrintWriter(f4);
			p3.println(searchtermpath[0] +","+ currenttext + "," );
			p3.close();
			f4.close();
		}
		if(currnetgroup.equals("Classes"))
		{
			File f5 = new File("Subject.txt");
			Scanner s3 = new Scanner(f5);
			Scanner s4 = new Scanner(f5);

			int counter2 = 0;
			while(s3.hasNextLine())
			{
				counter2++;
				s3.nextLine();
			}
			s3.close();
			String list2[] = new String[counter2];
			for(int i = 0; i != counter2; i++)
			{
				list2[i] = s4.nextLine();
			}
			s4.close();
			FileWriter f6 = new FileWriter("Subject.txt", false);
			PrintWriter p4 = new PrintWriter(f6);
			String[] process2 = null;
			for(int b = 0; b != counter2; b++)
			{	
				try 
				{
					process2 = list2[b].split(",");
				}
				catch(NullPointerException exe1)
				{
					;
				}
				if(process2[0].equals(searchtermpath[0]) && process2[1].equals(searchtermpath[1]))
				{
					p4.println(list2[b] + currenttext + ",");
				}
				else
				{
					p4.println(list2[b]);
				}
			}
			f6.close();
			p4.close();
			FileWriter f7 = new FileWriter("Classes.txt",true);
			PrintWriter p5 = new PrintWriter(f7);
			p5.println(searchtermpath[0] +","+ searchtermpath[1] + "," + currenttext + "," );
			p5.close();
			f7.close();
		}
		}
		if(currnetgroup.equals("Teachers & Studnets"))
		{
			Object[] currentvalue1 = list11.getSelectedValues();
			int lengths = currentvalue1.length;
			File f8 = new File("Classes.txt");
			Scanner s5 = new Scanner(f8);
			Scanner s6 = new Scanner(f8);

			int counter3 = 0;
			while(s5.hasNextLine())
			{
				counter3++;
				s5.nextLine();
			}
			s5.close();
			String list3[] = new String[counter3];
			for(int i = 0; i != counter3; i++)
			{
				list3[i] = s6.nextLine();
			}
			s6.close();
			FileWriter f9 = new FileWriter("Classes.txt", false);
			PrintWriter p5 = new PrintWriter(f9);
			String[] process3 = null;
			for(int b = 0; b != counter3; b++)
			{
				try 
				{
					process3 = list3[b].split(",");
				}
				catch(NullPointerException exe1)
				{
					;
				}
				if(process3[0].equals(searchtermpath[0]) && process3[1].equals(searchtermpath[1]) && process3[2].equals(searchtermpath[2]))
				{
					String output = (list3[b]);
					for( int s = 0; s != lengths; s ++)
					{
						Object procces6[] = ((String) currentvalue1[s]).split(",");
						String temp4 = charRemoveAt((String) procces6[1], 0);
						output = (output + procces6[0] + " [" + temp4 + "]" + ",");
					}
					p5.println(output);
				}
				else
				{
					p5.println(list3[b]);
				}
			}
			p5.close();
			f9.close();
			list11.setSelectedValue(null, false);
			
		}
		textField_1.setText("");
		try
		{
			listupdate(currnetgroup,searchtermpath[counter-1]);
		}
		catch(ArrayIndexOutOfBoundsException exe1)
		{
			listupdate(currnetgroup,searchtermpath[counter]);
		}
	
	}
	public void studentlistupdate() throws IOException
	{
		while(list10.isEmpty() == false)
        {
            list10.remove(0);
        }
		File studentsandteachers = new File("Login.txt");
		Scanner scan1 = new Scanner(studentsandteachers);
		Scanner scan2 = new Scanner(studentsandteachers);
		int counter10 = 0;
		while (scan1.hasNextLine())
		{
			counter10 ++;
			scan1.nextLine();
		}
		scan1.close();
		String listofteachersandstudents[] = new String[counter10];
		for(int i = 0; i != counter10; i ++)
		{
			listofteachersandstudents[i] = scan2.nextLine();
		}
		scan2.close();
		for(int i = 0; i != counter10; i ++)
		{
			String process4[] = listofteachersandstudents[i].split(",");
			if( process4[3].equals("Student") || process4[3].equals("Teacher"))
			{
				list10.addElement(process4[1] + ", " + process4[3]);
			}
		}
	}
	public void deleteitem(String currnetgroup) throws IOException
	{
		String currenttext2 = (String) list.getSelectedValue();
		if( currnetgroup.equals("Teachers & Studnets"))
		{
			File deleteteachersandstudents = new File("Classes.txt");
			Scanner deletescan1 = new Scanner(deleteteachersandstudents);
			Scanner deletescan2 = new Scanner(deleteteachersandstudents);
			
			int counter5 = 0;
			while(deletescan1.hasNextLine())
			{
				counter5 ++;
				deletescan1.nextLine();
			}
			deletescan1.close();
			String list6[] = new String[counter5];
			for( int e = 0; e != counter5; e ++)
			{
				list6[e] = deletescan2.nextLine();
			}
			deletescan2.close();
			FileWriter f9 = new FileWriter("Classes.txt",false);
			PrintWriter p9 = new PrintWriter(f9);
			int counter11 = 0;
			for(int c = 0; c!= counter5; c ++)
			{
				String temp5[] = list6[c].split(",");
				for(int x = 0; x != temp5.length;  x++)
				{
					if(searchtermpath[0].equals(temp5[0]) && searchtermpath[1].equals(temp5[1]) && searchtermpath[2].equals(temp5[2]) && temp5[x].equals(currenttext2) && counter11 != 1)
					{
						counter11 ++;
					}
					else
					{
						p9.print(temp5[x] + ",");
					}
				}
				p9.println();

			}
			f9.close();
			p9.close();
		}
			if( currnetgroup.equals("Classes"))
			{
				String replist[] = {"Classes.txt","Subject.txt"};
				for( int g = 0; g != 2; g ++)
				{
				File deleteclass = new File(replist[g]);
				Scanner deleteclassscan = new Scanner(deleteclass);
				Scanner deleteclassscan2 = new Scanner(deleteclass);
				int counter22 = 0;
				while(deleteclassscan.hasNextLine())
				{
					counter22 ++;
					deleteclassscan.nextLine();
				}
				deleteclassscan.close();
				String templist[] = new String[counter22];
				for(int i = 0; i != counter22; i ++)
				{
					templist[i] = deleteclassscan2.nextLine();
				}
				deleteclassscan2.close();
				FileWriter file1 = new FileWriter(replist[g],false);
				PrintWriter print1 = new PrintWriter(file1);
				int counter44 = 0;
				if(g == 0)
				{
				for(int i = 0; i != counter22; i ++)
				{
					String[] tempsplitlist = templist[i].split(",");
					if(searchtermpath[0].equals(tempsplitlist[0]) && searchtermpath[1].equals(tempsplitlist[1]) && tempsplitlist[2].equals(currenttext2) && counter44 != 1)
					{
						counter44++;
					}
					else
					{
						print1.println(templist[i]);
					}
				}
				}
				else
				{
					int counter55 = 0;
					for(int i = 0; i != counter22; i ++)
					{
						String[] tempsplitlist = templist[i].split(",");
						for( int h = 0; h != tempsplitlist.length; h ++)
						{
							if(searchtermpath[0].equals(tempsplitlist[0]) && searchtermpath[1].equals(tempsplitlist[1]) &&tempsplitlist[h].equals(currenttext2) && counter55 != 1)
							{
								counter55++;
							}
							else
							{
								print1.print(tempsplitlist[h] + ",");
							}
						}
						print1.println();
					}
				}
				file1.close();
				print1.close();
				}
			}
				if( currnetgroup.equals("Subjects"))
				{
					String replist1[] = {"Classes.txt","Subject.txt","Yeargroup.txt"};
					for( int l = 0; l != 3; l ++)

					{
						

						File deleteclass2 = new File(replist1[l]);
						Scanner deleteclassscan3 = new Scanner(deleteclass2);
						Scanner deleteclassscan4 = new Scanner(deleteclass2);
						int counter33 = 0;
						while(deleteclassscan3.hasNextLine())
						{
							counter33 ++;
							deleteclassscan3.nextLine();
						}
						deleteclassscan3.close();
						String templist2[] = new String[counter33];
						for(int i = 0; i != counter33; i ++)
						{
							templist2[i] = deleteclassscan4.nextLine();
						}
						deleteclassscan4.close();
						FileWriter file2 = new FileWriter(replist1[l],false);
						PrintWriter print2 = new PrintWriter(file2);
						int counter66 = 0;
						if( l == 2)
						{
							
							for( int i = 0; i != counter33; i ++)
							{
								String splitlist2[] = templist2[i].split(",");
								for(int r = 0; r!= splitlist2.length; r++)
								{
									if(searchtermpath[0].equals(splitlist2[0]) && splitlist2[r].equals(currenttext2) && counter66 != 1)
									{
										counter66++;
									}
									else
									{
										print2.print(splitlist2[r] + ",");
									}
								}
								print2.println();
							}
						}
						else
						{
							int counter77 = 0;
							for( int i = 0; i != counter33; i ++)
							{
								String splitlist2[] = templist2[i].split(",");
								if(searchtermpath[0].equals(splitlist2[0]) && splitlist2[1].equals(currenttext2) && counter77 != 1)
								{
									counter77++;
								}
								else
								{
									print2.println(templist2[i]);
								}
							}
						}
						file2.close();
						print2.close();
					}
					}
				if( currnetgroup.equals("Year Groups"))
				{
					String replist2[] = {"Classes.txt","Subject.txt","Yeargroup.txt"};
					for( int l = 0; l != 3; l ++)

					{
						

						File deleteclass3 = new File(replist2[l]);
						Scanner deleteclassscan5 = new Scanner(deleteclass3);
						Scanner deleteclassscan6 = new Scanner(deleteclass3);
						int counter44 = 0;
						while(deleteclassscan5.hasNextLine())
						{
							counter44++;
							deleteclassscan5.nextLine();
						}
						deleteclassscan5.close();
						String templist3[] = new String[counter44];
						for(int i = 0; i != counter44; i ++)
						{
							templist3[i] = deleteclassscan6.nextLine();
						}
						deleteclassscan6.close();
						FileWriter file3 = new FileWriter(replist2[l],false);
						PrintWriter print3 = new PrintWriter(file3);
						int counter88 = 0;
							for( int i = 0; i != counter44; i ++)
							{
								String splitlist3[] = templist3[i].split(",");
								if(splitlist3[0].equals(currenttext2) && counter88 != 1)
								{
									counter88++;
								}
								else
								{
									print3.println(templist3[i]);
								}
							}
						file3.close();
						print3.close();
					}
					File file101 = new File("timetable.txt");
					Scanner scan101 = new Scanner(file101);
					Scanner scan202 = new Scanner(file101);
					int counter101 = 0;
					while(scan101.hasNextLine())
					{
						scan101.nextLine();
						counter101 ++;
					}
					scan101.close();
					String listofsomesort[] = new String[counter101];
					for(int i = 0; i != counter101; i ++)
					{
						listofsomesort[i] = scan202.nextLine();
					}
					scan202.close();
					FileWriter write = new FileWriter("timetable.txt",false);
					PrintWriter pw = new PrintWriter(write);
					for( int i = 0; i != counter101; i ++)
					{
						String temp[] = listofsomesort[i].split(":");
						if(temp[0].equals(currenttext2))
						{
							;
						}
						else
						{
							pw.println(listofsomesort[i]);
						}
					}
					pw.close();
					write.close();
					}
		try
		{
			listupdate(currnetgroup,searchtermpath[counter-1]);
		}
		catch(ArrayIndexOutOfBoundsException exe1)
		{
			listupdate(currnetgroup,searchtermpath[counter]);
		}
	}
	//https://www.javatpoint.com/how-to-remove-a-particular-character-from-a-string
	public static String charRemoveAt(String str, int p) 
	{  
        return str.substring(0, p) + str.substring(p + 1);  
     }  
	public static void disposeframe()
			{
				frame.dispose();
			}
}