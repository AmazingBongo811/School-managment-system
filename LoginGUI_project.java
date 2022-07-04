import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class LoginGUI_project {

	public static JFrame frame;
	public static JLabel errorLabel;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPanel panel;
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void GUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI_project window = new LoginGUI_project();
					window.frame.setVisible(true);
				} catch (Exception e) {
					;
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginGUI_project() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		Color panelcolour = Color.decode("#fefcf4");
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(panelcolour);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);

		JLabel NameLabel = new JLabel("Name");
		springLayout.putConstraint(SpringLayout.WEST, NameLabel, 66, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(NameLabel);

		JLabel PasswordLabel = new JLabel("Password");
		springLayout.putConstraint(SpringLayout.WEST, PasswordLabel, 66, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, NameLabel, -6, SpringLayout.NORTH, PasswordLabel);
		springLayout.putConstraint(SpringLayout.NORTH, PasswordLabel, 129, SpringLayout.NORTH, frame.getContentPane());
		frame.getContentPane().add(PasswordLabel);

		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, NameLabel, -68, SpringLayout.WEST, textField);
		springLayout.putConstraint(SpringLayout.NORTH, textField, 0, SpringLayout.NORTH, NameLabel);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		springLayout.putConstraint(SpringLayout.WEST, passwordField, 214, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, passwordField, -106, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, passwordField);
		springLayout.putConstraint(SpringLayout.EAST, PasswordLabel, -68, SpringLayout.WEST, passwordField);
		springLayout.putConstraint(SpringLayout.NORTH, passwordField, -1, SpringLayout.NORTH, PasswordLabel);
		frame.getContentPane().add(passwordField);

		JButton btnNewButton = new JButton("Login");
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 161, SpringLayout.WEST, frame.getContentPane());
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try{
					loginAction(evt);
				}
				catch(IOException e)
				{
					;
				}
			}
		});
		frame.getContentPane().add(btnNewButton);

		errorLabel = new JLabel("Error: User not found");
		springLayout.putConstraint(SpringLayout.SOUTH, PasswordLabel, -17, SpringLayout.NORTH, errorLabel);
		errorLabel.setVisible(false);
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 25, SpringLayout.SOUTH, errorLabel);
		springLayout.putConstraint(SpringLayout.WEST, errorLabel, 139, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, errorLabel, -91, SpringLayout.SOUTH, frame.getContentPane());
		errorLabel.setForeground(Color.RED);
		frame.getContentPane().add(errorLabel);

		panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, NameLabel, 23, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -204, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 450, SpringLayout.WEST, frame.getContentPane());
		panel.setBackground(panelcolour);
		frame.getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		lblNewLabel = new JLabel("");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 57, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel, 0, SpringLayout.SOUTH, panel);
		URL url = getClass().getResource("Resources/2.png");
		lblNewLabel.setIcon(new ImageIcon(url));
		panel.add(lblNewLabel);
	}
	authorization login1 = new authorization();
	public void loginAction (ActionEvent evt) throws IOException {
		String username = textField.getText();
		@SuppressWarnings("deprecation")
		String password = passwordField.getText(); 
		if(login1.login(username,password) == true)
		{

			frame.dispose();
			privligeID.getPrivlageID();

		}
		else
		{
			errorLabel.setVisible(true);
		}
	}
}
