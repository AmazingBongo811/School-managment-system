import java.awt.EventQueue;
import java.io.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

public class THWGUI {

	private static JFrame frame;
	private static  JTextField textField;
	private static JTextField textField_1;
	private static JTextArea textArea;
	private static JComboBox comboBox;
	JButton btnNewButton;
	JButton btnNewButton_1;


	/**
	 * Launch the application.
	 */
	public static void Task() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					THWGUI window = new THWGUI();
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
	public THWGUI() throws IOException  {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws IOException{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		Color panelcolour = Color.decode("#fefcf4");
		panel.setBackground(panelcolour);

		JLabel lblNewLabel = new JLabel("Title of task");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, panel);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		sl_panel.putConstraint(SpringLayout.NORTH, textField, 12, SpringLayout.SOUTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, textField);
		sl_panel.putConstraint(SpringLayout.WEST, textField, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textField, 215, SpringLayout.WEST, panel);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Task description");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, textField);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -176, SpringLayout.SOUTH, panel);
		panel.add(lblNewLabel_1);

		textArea = new JTextArea();
		textArea.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		sl_panel.putConstraint(SpringLayout.NORTH, textArea, 6, SpringLayout.SOUTH, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.WEST, textArea, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, textArea, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textArea, -115, SpringLayout.EAST, panel);
		panel.add(textArea);

		JLabel lblNewLabel_2 = new JLabel("due day - dd/mm/yy");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 0, SpringLayout.NORTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_2, -49, SpringLayout.EAST, panel);
		panel.add(lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		sl_panel.putConstraint(SpringLayout.NORTH, textField_1, 12, SpringLayout.SOUTH, lblNewLabel_2);
		sl_panel.putConstraint(SpringLayout.WEST, textField_1, 0, SpringLayout.WEST, lblNewLabel_2);
		sl_panel.putConstraint(SpringLayout.EAST, textField_1, 130, SpringLayout.WEST, lblNewLabel_2);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Choose class");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 0, SpringLayout.NORTH, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_3, -21, SpringLayout.EAST, panel);
		panel.add(lblNewLabel_3);

		comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		sl_panel.putConstraint(SpringLayout.NORTH, comboBox, 0, SpringLayout.NORTH, textArea);
		sl_panel.putConstraint(SpringLayout.WEST, comboBox, 6, SpringLayout.EAST, textArea);
		comboBox.setPrototypeDisplayValue("class");
		panel.add(comboBox);
		addalloption();

		btnNewButton = new JButton("Set task");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, btnNewButton);
		sl_panel.putConstraint(SpringLayout.EAST, comboBox, 0, SpringLayout.EAST, btnNewButton);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton, -10, SpringLayout.EAST, panel);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					setTask();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton, -38, SpringLayout.SOUTH, panel);
		panel.add(btnNewButton);

		btnNewButton_1 = new JButton("Cancel");
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_1, 6, SpringLayout.SOUTH, btnNewButton);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1, 10, SpringLayout.WEST, btnNewButton);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -3, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_1, -10, SpringLayout.EAST, btnNewButton);
		btnNewButton_1.setMinimumSize(new Dimension(94, 29));
		btnNewButton_1.setMaximumSize(new Dimension(94, 29));
		btnNewButton_1.setPreferredSize(new Dimension(94, 29));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		panel.add(btnNewButton_1);
	}
	public static void setTask() throws IOException
	{
		try
		{
			if(!textField.getText().equals("") && !textField_1.getText().equals("") && !textArea.getText().equals("") && !comboBox.getSelectedItem().equals(""))
			{
				String title = textField.getText();
				String discription = textArea.getText();
				String date = textField_1.getText();
				String classe = (String) comboBox.getSelectedItem();
				FileWriter f1 = new FileWriter("HomewWork.txt",true);
				PrintWriter p1 = new PrintWriter(f1);
				int ID = createUserID.createID("", "HomewWork.txt", 1);
				p1.println(ID + "," + date + "," + classe  + "," + title  + "," + discription);
				p1.close();
				f1.close();
				textField.setText("");
				textField_1.setText("");
				textArea.setText("");
				comboBox.setSelectedIndex(0);
			}
		}
		catch(java.lang.NullPointerException e1)
		{
			;
		}

	}
	public void addalloption() throws IOException
	{
		try
		{
			comboBox.removeAllItems();
		}
		catch(java.lang.NullPointerException e)
		{
			;
		}


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
			String[] temp = classes[c].split(",");
			for(int k = 0; k != temp.length; k++)
			{
				if(temp[k].equals(name + " [" + priv + "]"))
				{
					comboBox.addItem(temp[2]);
				}
			}
		}
	}
	public static void dissframe()
	{
		frame.dispose();
	}
}

