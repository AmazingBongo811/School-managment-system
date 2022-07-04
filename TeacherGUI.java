import java.awt.Color;
import java.awt.EventQueue;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Dimension;

public class TeacherGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void Teacher() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherGUI window = new TeacherGUI();
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
	public TeacherGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Color panelcolour = Color.decode("#fefcf4");
		frame = new JFrame();
		frame.getContentPane().setBackground(panelcolour);
		frame.setBounds(100, 100, 247, 340);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JButton btnNewButton = new JButton("Timetable");
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -10, SpringLayout.EAST, frame.getContentPane());
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TTGUI.TT();
			}
		});

		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Set task");
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -2, SpringLayout.NORTH, btnNewButton_1);
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 161, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -102, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, -10, SpringLayout.EAST, frame.getContentPane());
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				THWGUI.Task();
			}
		});

		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("View tasks");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1_1, 4, SpringLayout.SOUTH, btnNewButton_1);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1_1, 12, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1_1, -8, SpringLayout.EAST, frame.getContentPane());
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TaskViewer.TV();
			}
		});

		frame.getContentPane().add(btnNewButton_1_1);
		
		JLabel lblNewLabel = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 3, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -212, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(lblNewLabel);
		URL url2 = getClass().getResource("Resources/6.png");
		ImageIcon img2 = new ImageIcon(url2);
		lblNewLabel.setIcon(img2);
		
		JButton btnNewButton_2 = new JButton("Log out");
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1_1, -12, SpringLayout.NORTH, btnNewButton_2);
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_2, 274, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_2, -9, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_2, -4, SpringLayout.EAST, frame.getContentPane());
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				frame.dispose();
				TTGUI.disframe();
				PasswordChange.dissframe();
				THWGUI.dissframe();
				TaskViewer.disframe();
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
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_2, 2, SpringLayout.EAST, btnNewButton_4);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_4, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_4, -9, SpringLayout.SOUTH, frame.getContentPane());
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PasswordChange changepass = new PasswordChange();
				changepass.authpasschange();
			}
		});
		btnNewButton_4.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		frame.getContentPane().add(btnNewButton_4);
	}
}
