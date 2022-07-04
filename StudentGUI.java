import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import java.awt.Component;

public class StudentGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void GUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentGUI window = new StudentGUI();
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
	public StudentGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Color panelcolour = Color.decode("#fefcf4");
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(panelcolour);
		frame.setBounds(100, 100, 247, 266);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JButton btnNewButton = new JButton("Timetable");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 81, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, 140, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -10, SpringLayout.EAST, frame.getContentPane());
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TTGUI.TT();
			}
		});

		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View task");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 146, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, 205, SpringLayout.NORTH, frame.getContentPane());
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentViewTask();
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, -10, SpringLayout.EAST, frame.getContentPane());

		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -6, SpringLayout.NORTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(lblNewLabel);
		URL url2 = getClass().getResource("Resources/6.png");
		ImageIcon img2 = new ImageIcon(url2);
		lblNewLabel.setIcon(img2);
		
		JButton btnNewButton_2 = new JButton("Log out");
		btnNewButton_2.setAlignmentY(Component.TOP_ALIGNMENT);
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_2, 6, SpringLayout.SOUTH, btnNewButton_1);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_2, -86, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_2, 35, SpringLayout.SOUTH, btnNewButton_1);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_2, 0, SpringLayout.EAST, frame.getContentPane());
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				try
				{
					TTGUI.disframe();
					StudentTaskViewer.disframe();
				}
				catch(java.lang.NullPointerException e1)
				{
					;
				}
				LoginGUI_project.GUI();
			}
		});
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("change password");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_4, 211, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_4, 10, SpringLayout.WEST, frame.getContentPane());
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PasswordChange changepass = new PasswordChange();
				changepass.authpasschange();
			}
		});
		btnNewButton_4.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		frame.getContentPane().add(btnNewButton_4);
	}
	public void StudentViewTask()
	{
		 StudentTaskViewer.GUI();
	}
}


