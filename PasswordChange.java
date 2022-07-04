import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.*;
import javax.swing.SwingConstants;
public class PasswordChange {

	private static JFrame frame;
	private JPasswordField oldpasswordField;
	private JPasswordField newpasswordField;
	private JPasswordField confpasswordField;
	private JLabel Status;

	/**
	 * Launch the application.
	 */
	public void authpasschange() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswordChange window = new PasswordChange();
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
	public PasswordChange() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Color panelcolour = Color.decode("#fefcf4");
		frame.getContentPane().setBackground(panelcolour);
		frame.setBounds(100, 100, 450, 200);
		frame.setLocationRelativeTo(null);

		SpringLayout springLayout = new SpringLayout();
		
		frame.getContentPane().setLayout(springLayout);
		
		JLabel changepasswordlabel = new JLabel("Change Password");
		springLayout.putConstraint(SpringLayout.NORTH, changepasswordlabel, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, changepasswordlabel, 161, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(changepasswordlabel);
		
		JLabel oldpasswordlabel = new JLabel("Current Password\n");
		springLayout.putConstraint(SpringLayout.NORTH, oldpasswordlabel, 49, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, oldpasswordlabel, 50, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(oldpasswordlabel);
		
		JLabel newpasswordlabel = new JLabel("New Password");
		springLayout.putConstraint(SpringLayout.NORTH, newpasswordlabel, 6, SpringLayout.SOUTH, oldpasswordlabel);
		springLayout.putConstraint(SpringLayout.WEST, newpasswordlabel, 0, SpringLayout.WEST, oldpasswordlabel);
		frame.getContentPane().add(newpasswordlabel);
		
		JLabel confirmpasswordlabel = new JLabel("Confirm New Password");
		springLayout.putConstraint(SpringLayout.NORTH, confirmpasswordlabel, 6, SpringLayout.SOUTH, newpasswordlabel);
		springLayout.putConstraint(SpringLayout.WEST, confirmpasswordlabel, 0, SpringLayout.WEST, oldpasswordlabel);
		frame.getContentPane().add(confirmpasswordlabel);
		
		oldpasswordField = new JPasswordField();
		springLayout.putConstraint(SpringLayout.NORTH, oldpasswordField, -5, SpringLayout.NORTH, oldpasswordlabel);
		springLayout.putConstraint(SpringLayout.WEST, oldpasswordField, -224, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, oldpasswordField, 11, SpringLayout.NORTH, oldpasswordlabel);
		springLayout.putConstraint(SpringLayout.EAST, oldpasswordField, -27, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(oldpasswordField);
		
		newpasswordField = new JPasswordField();
		springLayout.putConstraint(SpringLayout.NORTH, newpasswordField, 0, SpringLayout.NORTH, newpasswordlabel);
		springLayout.putConstraint(SpringLayout.WEST, newpasswordField, 31, SpringLayout.EAST, confirmpasswordlabel);
		springLayout.putConstraint(SpringLayout.SOUTH, newpasswordField, 16, SpringLayout.NORTH, newpasswordlabel);
		springLayout.putConstraint(SpringLayout.EAST, newpasswordField, -27, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(newpasswordField);
		
		confpasswordField = new JPasswordField();
		springLayout.putConstraint(SpringLayout.NORTH, confpasswordField, 0, SpringLayout.NORTH, confirmpasswordlabel);
		springLayout.putConstraint(SpringLayout.WEST, confpasswordField, 0, SpringLayout.WEST, oldpasswordField);
		springLayout.putConstraint(SpringLayout.SOUTH, confpasswordField, 0, SpringLayout.SOUTH, confirmpasswordlabel);
		springLayout.putConstraint(SpringLayout.EAST, confpasswordField, -27, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(confpasswordField);
		
		JButton ChangeButton = new JButton("Change Password");
		springLayout.putConstraint(SpringLayout.EAST, ChangeButton, -27, SpringLayout.EAST, frame.getContentPane());
		ChangeButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					String pass1 = oldpasswordField.getText();
					String newPass1 = newpasswordField.getText();
					String newPass2 = confpasswordField.getText();
					Status.setVisible(true);
					Status.setText(passchange(pass1,newPass1,newPass2));
				} catch (IOException | InterruptedException e1) {
				}
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, ChangeButton, -10, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(ChangeButton);
		
		JButton CancelButton = new JButton("Cancel");
		CancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, CancelButton, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, CancelButton, 0, SpringLayout.SOUTH, ChangeButton);
		frame.getContentPane().add(CancelButton);
		
		Status = new JLabel((String) null);
		Status.setHorizontalAlignment(SwingConstants.CENTER);
		Status.setVisible(false);
		springLayout.putConstraint(SpringLayout.NORTH, Status, 14, SpringLayout.SOUTH, confirmpasswordlabel);
		springLayout.putConstraint(SpringLayout.WEST, Status, 0, SpringLayout.WEST, changepasswordlabel);
		frame.getContentPane().add(Status);
	}
	public String passchange(String pass1, String newPass1, String newPass2) throws IOException, InterruptedException
	{


		String authchangepass = "";
		File file1 = new File("Just Logged In.txt");
		Scanner scan1 = new Scanner(file1);
		String user = scan1.nextLine();
		scan1.close();
		String userelements[] = user.split(",");
		String originalpass = userelements[2];
		hash hash1 = new hash();
		if (originalpass.equals(hash1.cypher(pass1)))
		{
			if(newPass1.equals(newPass2))
			{
				FileWriter changejustloggedin = new FileWriter("Just Logged In.txt", false);
				PrintWriter print1 = new PrintWriter(changejustloggedin);
				print1.println(userelements[0] + "," + userelements[1] + "," + hash1.cypher(newPass1) + "," + userelements[3]);
				changejustloggedin.close();
				print1.close();
				File file2 = new File("Login.txt");
				Scanner scan2 = new Scanner(file2);
				Scanner scan3 = new Scanner(file2);
				int counter = 0;
				while(scan2.hasNextLine())
				{
					counter ++;
					scan2.nextLine();
				}
				String listofusers[] = new String[counter];
				for(int i = 0; i != counter; i ++)
				{
					listofusers[i] = scan3.nextLine();
					
				}
				scan2.close();
				String listofusers2[] = new String[counter];
				scan3.close();
				FileWriter write3 = new FileWriter("Login.txt",false);
				PrintWriter print3 = new PrintWriter(write3);
				for(int i = 0; i != counter; i ++)
				{
					String temp[] = listofusers[i].split(",");
					if( temp[0].equals(userelements[0]))
					{
						listofusers2[i] = userelements[0] + "," + userelements[1] + "," + hash1.cypher(newPass1) + "," + userelements[3];
					}
					else
					{
						listofusers2[i] = listofusers[i];
					}
					print3.println(listofusers2[i]);
				}
				write3.close();
				print3.close();
				frame.dispose();
			}
			
			else
			{
				authchangepass = "Password confirmation doesn't match";
			}
		}
		else
		{
			authchangepass = "Old password doesn't match";
		}
		return authchangepass;
	
	}
	public static void dissframe()
	{
		frame.dispose();
	}
}
