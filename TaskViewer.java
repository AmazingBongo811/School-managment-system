import java.awt.EventQueue;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.border.MatteBorder;

public class TaskViewer {

	private static JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private DefaultListModel<String> list1 = new DefaultListModel<String>();
	public JList list;
	private JTextArea textArea;
	private ArrayList arry;
	private JComboBox comboBox;
	private ArrayList t1;
	/**
	 * Launch the application.
	 */
	public static void TV() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaskViewer window = new TaskViewer();
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
	public TaskViewer() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		Color panelcolour = Color.decode("#fefcf4");
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(panelcolour);
		frame.setBounds(100, 100, 481, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		SpringLayout sl_layeredPane = new SpringLayout();
		layeredPane.setLayout(sl_layeredPane);

		JScrollPane scrollPane = new JScrollPane();
		sl_layeredPane.putConstraint(SpringLayout.NORTH, scrollPane, 10, SpringLayout.NORTH, layeredPane);
		sl_layeredPane.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, layeredPane);
		sl_layeredPane.putConstraint(SpringLayout.SOUTH, scrollPane, 268, SpringLayout.NORTH, layeredPane);
		layeredPane.add(scrollPane);

		list = new JList(list1);
		list.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2 && !e.isConsumed()) {
					e.consume();
					loadData();
				}
			}
		});
		scrollPane.setViewportView(list);

		JLabel lblNewLabel = new JLabel("Current set tasks");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(lblNewLabel);

		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					updateTask();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
				}
			}
		});
		sl_layeredPane.putConstraint(SpringLayout.WEST, btnNewButton, 402, SpringLayout.WEST, layeredPane);
		sl_layeredPane.putConstraint(SpringLayout.SOUTH, btnNewButton, 0, SpringLayout.SOUTH, layeredPane);
		sl_layeredPane.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, layeredPane);
		layeredPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancel");
		sl_layeredPane.putConstraint(SpringLayout.NORTH, btnNewButton_1, 0, SpringLayout.NORTH, btnNewButton);
		sl_layeredPane.putConstraint(SpringLayout.EAST, btnNewButton_1, -6, SpringLayout.WEST, btnNewButton);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textArea.setText("");
				comboBox.setSelectedIndex(0);
			}
		});
		layeredPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					delete();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
				}
			}
		});
		sl_layeredPane.putConstraint(SpringLayout.WEST, btnNewButton_2, 232, SpringLayout.WEST, layeredPane);
		sl_layeredPane.putConstraint(SpringLayout.EAST, btnNewButton_2, -170, SpringLayout.EAST, layeredPane);
		sl_layeredPane.putConstraint(SpringLayout.WEST, btnNewButton_1, 6, SpringLayout.EAST, btnNewButton_2);
		sl_layeredPane.putConstraint(SpringLayout.EAST, scrollPane, -6, SpringLayout.WEST, btnNewButton_2);
		sl_layeredPane.putConstraint(SpringLayout.NORTH, btnNewButton_2, 0, SpringLayout.NORTH, btnNewButton);
		layeredPane.add(btnNewButton_2);

		JLabel lblNewLabel_1 = new JLabel("Title");
		sl_layeredPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 0, SpringLayout.NORTH, scrollPane);
		sl_layeredPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 92, SpringLayout.EAST, scrollPane);
		layeredPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		sl_layeredPane.putConstraint(SpringLayout.NORTH, textField, 6, SpringLayout.SOUTH, lblNewLabel_1);
		sl_layeredPane.putConstraint(SpringLayout.EAST, textField, 0, SpringLayout.EAST, btnNewButton_1);
		layeredPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Due Date");
		sl_layeredPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 6, SpringLayout.SOUTH, textField);
		sl_layeredPane.putConstraint(SpringLayout.EAST, lblNewLabel_2, 0, SpringLayout.EAST, btnNewButton_2);
		layeredPane.add(lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setToolTipText("dd/mm/yy\n");
		sl_layeredPane.putConstraint(SpringLayout.WEST, textField_1, 6, SpringLayout.EAST, scrollPane);
		layeredPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Discription");
		sl_layeredPane.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 118, SpringLayout.NORTH, layeredPane);
		sl_layeredPane.putConstraint(SpringLayout.SOUTH, textField_1, -6, SpringLayout.NORTH, lblNewLabel_3);
		sl_layeredPane.putConstraint(SpringLayout.WEST, lblNewLabel_3, 79, SpringLayout.EAST, scrollPane);
		sl_layeredPane.putConstraint(SpringLayout.EAST, lblNewLabel_3, -106, SpringLayout.EAST, layeredPane);
		layeredPane.add(lblNewLabel_3);

		textArea = new JTextArea();
		textArea.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		sl_layeredPane.putConstraint(SpringLayout.NORTH, textArea, 6, SpringLayout.SOUTH, lblNewLabel_3);
		sl_layeredPane.putConstraint(SpringLayout.WEST, textArea, 6, SpringLayout.EAST, scrollPane);
		sl_layeredPane.putConstraint(SpringLayout.SOUTH, textArea, -6, SpringLayout.NORTH, btnNewButton);
		sl_layeredPane.putConstraint(SpringLayout.EAST, textArea, 245, SpringLayout.EAST, scrollPane);
		layeredPane.add(textArea);

		comboBox = new JComboBox();
		sl_layeredPane.putConstraint(SpringLayout.WEST, comboBox, 5, SpringLayout.EAST, lblNewLabel_3);
		comboBox.setPrototypeDisplayValue("Class");
		layeredPane.add(comboBox);
		loadoption();
		UpdateList();

		JLabel lblNewLabel_4 = new JLabel("Class");
		sl_layeredPane.putConstraint(SpringLayout.NORTH, comboBox, 20, SpringLayout.SOUTH, lblNewLabel_4);
		sl_layeredPane.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 0, SpringLayout.NORTH, lblNewLabel_2);
		sl_layeredPane.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, btnNewButton);
		layeredPane.add(lblNewLabel_4);
	}
	public void UpdateList() throws IOException
	{
		while(list1.isEmpty() == false)
		{
			list1.remove(0);
		}
		try {
			File f1 = new File("HomewWork.txt");
			Scanner s1 = new Scanner(f1);
			arry = new ArrayList();
			while(s1.hasNextLine())
			{
				arry.add(s1.nextLine());
			}

			for(int i = 0; i != arry.size(); i ++)
			{
				String[] temp = ((String) arry.get(i)).split(",");
				if(t1.contains(temp[2]))
				{
					list1.addElement(temp[0] + "," + temp[2] + "," + temp[3]);
				}
				
			}
			s1.close();
		}
		catch(java.io.FileNotFoundException e)
		{
			;
		}
	}
	public void loadData()
	{
		try
		{
			textField.setText("");
			textField_1.setText("");
			textArea.setText("");
			comboBox.setSelectedIndex(0);
			int index = list.getSelectedIndex();
			String[] temp2 = ((String) arry.get(index)).split(",");
			textField.setText(temp2[3]);
			textField_1.setText(temp2[1]);
			textArea.setText(temp2[4]);
			comboBox.setSelectedItem(temp2[2]);
		}
		catch(java.lang.IndexOutOfBoundsException e1)
		{
			;
		}
	}
	public void loadoption() throws IOException
	{
		try
		{
			comboBox.removeAllItems();
		}
		catch(java.lang.NullPointerException e)
		{
			;
		}
		t1 = new ArrayList();
		comboBox.addItem("");
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
			String[] temp6 = classes[c].split(",");
			for(int k = 0; k != temp6.length; k++)
			{
				if(temp6[k].equals(name + " [" + priv + "]"))
				{
					t1.add(temp6[2]);
					comboBox.addItem(temp6[2]);
				}
			}
		}
	}
	public void updateTask() throws IOException
	{
		if(!textField.getText().equals("") && !textField_1.getText().equals("") && !textArea.getText().equals("") && !comboBox.getSelectedItem().equals(""))
		{
			try
			{
				int index2 = list.getSelectedIndex();
				String duedate = textField_1.getText();
				String classs = (String) comboBox.getSelectedItem();
				String title = textField.getText();
				String discription = textArea.getText();
				String[] temp4 = ((String) arry.get(index2)).split(",");
				String ID = temp4[0];

				FileWriter f1 = new FileWriter("HomewWork.txt",false);
				PrintWriter p2 = new PrintWriter(f1);
				for(int i = 0; i != arry.size(); i ++)
				{
					String[] temp5 = ((String) arry.get(i)).split(",");
					if(temp5[0].equals(ID))
					{
						p2.println(ID + "," + duedate + "," + classs + "," + title + "," + discription);
					}
					else
					{
						p2.println(arry.get(i));
					}
				}
				p2.close();
				f1.close();
				textField.setText("");
				textField_1.setText("");
				textArea.setText("");
				comboBox.setSelectedIndex(0);
				UpdateList();
			}
			catch(java.lang.IndexOutOfBoundsException e1)
			{
				;
			}
		}
	}
	public void delete() throws IOException
	{
		try
		{
			String index3 = (String) list.getSelectedValue();
			String[] temp00 = index3.split(",");
			String ID4 = temp00[0];
		//	System.out.println("id of task to be deleted: " + ID4);
			//String[] temp11 = ((String) arry.get(index3)).split(",");
			//String ID4 = temp11[0];
			FileWriter f3 = new FileWriter("HomewWork.txt",false);
			PrintWriter p3 = new PrintWriter(f3);
			for(int i = 0 ; i != arry.size(); i ++)
			{
				String[] temp6 = ((String) arry.get(i)).split(",");
				//System.out.println("id of all tasks: " + temp6[0]);
				if(!temp6[0].equals(ID4))
				{
					//System.out.println("task printed back into the file: " + arry.get(i));
					p3.println(arry.get(i));
				}
			}
			p3.close();
			f3.close();
			UpdateList();
		}
		catch(java.lang.IndexOutOfBoundsException e1)
		{
			;
		}
	}
	public static void disframe()
	{
		frame.dispose();
	}
}

