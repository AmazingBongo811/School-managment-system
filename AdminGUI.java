import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.io.*;
import java.util.*;

import javax.swing.SpringLayout;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Point;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JLayeredPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JToggleButton;
import javax.swing.UIManager;

public class AdminGUI {

	private JFrame frame;
	public DefaultListModel<String> list1 = new DefaultListModel<String>();
	private JTextField NameField;
	private JTextField PasswordField;
	public JPanel adduserpanel;
	public JComboBox<String> privlagebox;
	public JList list;
	public JScrollPane scrollPane;
	private JPasswordField passwordField;
	public JPanel panel;
	public JLabel InccorectPasswordLabel;
	public JComboBox<String> ShowListUser;
	public JPanel userpanel;
	/**
	 * Launch the application.
	 */
	public static void GUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminGUI window = new AdminGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					;
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public AdminGUI() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 657, 427);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		
		File file3 = new File("Just Logged In.txt");
		Scanner gab = new Scanner(file3);
		String user = gab.nextLine();
		gab.close();
		String userelements3[] = user.split(",");
		
		JLayeredPane layeredPane = new JLayeredPane();
		springLayout.putConstraint(SpringLayout.WEST, layeredPane, 197, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(layeredPane);

		
		JButton addButton = new JButton("Add");
		springLayout.putConstraint(SpringLayout.WEST, addButton, 197, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, layeredPane, -6, SpringLayout.NORTH, addButton);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				useradd();
			}
			});
		springLayout.putConstraint(SpringLayout.NORTH, addButton, 148, SpringLayout.NORTH, frame.getContentPane());
		frame.getContentPane().add(addButton);
		
		JButton deleteButton = new JButton("Delete");
		springLayout.putConstraint(SpringLayout.WEST, deleteButton, 379, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, addButton, -87, SpringLayout.WEST, deleteButton);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					deleteuser();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					;
				}
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, deleteButton, 0, SpringLayout.NORTH, addButton);
		frame.getContentPane().add(deleteButton);
		
		JLabel LogidInLabel = new JLabel("Logged In as:");
		springLayout.putConstraint(SpringLayout.NORTH, layeredPane, 0, SpringLayout.NORTH, LogidInLabel);
		springLayout.putConstraint(SpringLayout.EAST, layeredPane, -77, SpringLayout.WEST, LogidInLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 266, 132);
		layeredPane.add(scrollPane);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 138, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, addButton);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -6, SpringLayout.NORTH, addButton);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, -194, SpringLayout.EAST, frame.getContentPane());
		
		list = new JList(list1);
		scrollPane.setViewportView(list);
		UpdateList("all");
		panel = new JPanel();
		panel.setVisible(false);
		panel.setBounds(0, 0, 266, 126);
		layeredPane.add(panel);
		springLayout.putConstraint(SpringLayout.NORTH, LogidInLabel, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, LogidInLabel, -33, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(LogidInLabel);
		
		JLabel loggedInUser = new JLabel();
		springLayout.putConstraint(SpringLayout.NORTH, loggedInUser, 6, SpringLayout.SOUTH, LogidInLabel);
		springLayout.putConstraint(SpringLayout.WEST, loggedInUser, 10, SpringLayout.WEST, LogidInLabel);
		frame.getContentPane().add(loggedInUser);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		passwordField = new JPasswordField();
		sl_panel.putConstraint(SpringLayout.WEST, passwordField, 57, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, passwordField, -54, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, passwordField, -50, SpringLayout.EAST, panel);
		panel.add(passwordField);
		
		JLabel deletepromtlabel = new JLabel("Are you sure you want to delete this user?");
		sl_panel.putConstraint(SpringLayout.NORTH, deletepromtlabel, 0, SpringLayout.NORTH, panel);
		panel.add(deletepromtlabel);
		
		JButton YesButton = new JButton("Yes");
		sl_panel.putConstraint(SpringLayout.EAST, YesButton, -3, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, deletepromtlabel, 0, SpringLayout.EAST, YesButton);
		YesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					authdelete();
				} catch (IOException | NullPointerException e1) {
					;
					
				}
			}
		});
		sl_panel.putConstraint(SpringLayout.SOUTH, YesButton, 0, SpringLayout.SOUTH, panel);
		panel.add(YesButton);
		
		JButton CancelDelete = new JButton("Cancel");
		CancelDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				scrollPane.setVisible(true);
				passwordField.setText("");
				InccorectPasswordLabel.setVisible(false);
			}
		});
		sl_panel.putConstraint(SpringLayout.WEST, CancelDelete, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, CancelDelete, 0, SpringLayout.SOUTH, YesButton);
		panel.add(CancelDelete);
		
		InccorectPasswordLabel = new JLabel("Error: Inncorrect password");
		sl_panel.putConstraint(SpringLayout.NORTH, InccorectPasswordLabel, 6, SpringLayout.SOUTH, passwordField);
		sl_panel.putConstraint(SpringLayout.WEST, InccorectPasswordLabel, 0, SpringLayout.WEST, passwordField);
		InccorectPasswordLabel.setVisible(false);
		InccorectPasswordLabel.setForeground(Color.RED);
		panel.add(InccorectPasswordLabel);
		
		JLabel lblNewLabel = new JLabel("Enter password");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 79, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel, -6, SpringLayout.NORTH, passwordField);
		panel.add(lblNewLabel);

		
		ShowListUser = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, ShowListUser, 0, SpringLayout.NORTH, loggedInUser);
		springLayout.putConstraint(SpringLayout.EAST, ShowListUser, -8, SpringLayout.WEST, layeredPane);
		ShowListUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usertodisplay = ShowListUser.getSelectedItem().toString();
				try {
					UpdateList(usertodisplay);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					;
					e1.printStackTrace();
				}
				
			}
		});
		frame.getContentPane().add(ShowListUser);
		ShowListUser.addItem("All");
		ShowListUser.addItem("Admin");
		ShowListUser.addItem("Teacher");
		ShowListUser.addItem("Student");
		ShowListUser.setSelectedItem("All");
		
		JLabel DisplayUsersLabel = new JLabel("Display users:");
		springLayout.putConstraint(SpringLayout.SOUTH, DisplayUsersLabel, -6, SpringLayout.NORTH, ShowListUser);
		springLayout.putConstraint(SpringLayout.EAST, DisplayUsersLabel, -15, SpringLayout.WEST, layeredPane);
		frame.getContentPane().add(DisplayUsersLabel);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		springLayout.putConstraint(SpringLayout.NORTH, layeredPane_1, 6, SpringLayout.SOUTH, addButton);
		springLayout.putConstraint(SpringLayout.WEST, layeredPane_1, 143, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, layeredPane_1, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, layeredPane_1, -154, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(layeredPane_1);
		SpringLayout sl_layeredPane_1 = new SpringLayout();
		layeredPane_1.setLayout(sl_layeredPane_1);
		
		adduserpanel = new JPanel();
		sl_layeredPane_1.putConstraint(SpringLayout.NORTH, adduserpanel, 0, SpringLayout.NORTH, layeredPane_1);
		sl_layeredPane_1.putConstraint(SpringLayout.WEST, adduserpanel, 0, SpringLayout.WEST, layeredPane_1);
		sl_layeredPane_1.putConstraint(SpringLayout.SOUTH, adduserpanel, 212, SpringLayout.NORTH, layeredPane_1);
		sl_layeredPane_1.putConstraint(SpringLayout.EAST, adduserpanel, 360, SpringLayout.WEST, layeredPane_1);
		layeredPane_1.add(adduserpanel);
		springLayout.putConstraint(SpringLayout.NORTH, adduserpanel, 6, SpringLayout.SOUTH, addButton);
		springLayout.putConstraint(SpringLayout.EAST, adduserpanel, -156, SpringLayout.EAST, frame.getContentPane());
		SpringLayout sl_adduserpanel = new SpringLayout();
		adduserpanel.setVisible(false);
		adduserpanel.setLayout(sl_adduserpanel);
		
		JLabel NameLabel = new JLabel("Name");
		sl_adduserpanel.putConstraint(SpringLayout.WEST, NameLabel, 42, SpringLayout.WEST, adduserpanel);
		adduserpanel.add(NameLabel);
		
		JLabel PasswordLabel = new JLabel("Password");
		sl_adduserpanel.putConstraint(SpringLayout.WEST, PasswordLabel, 0, SpringLayout.WEST, NameLabel);
		adduserpanel.add(PasswordLabel);
		
		JLabel privilegeLabel = new JLabel("Privilege");
		sl_adduserpanel.putConstraint(SpringLayout.WEST, privilegeLabel, 0, SpringLayout.WEST, NameLabel);
		adduserpanel.add(privilegeLabel);
		
		JButton adduserbutton = new JButton("Add User");
		adduserbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					adduser();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					;
				}
			}
		});
		sl_adduserpanel.putConstraint(SpringLayout.SOUTH, adduserbutton, -10, SpringLayout.SOUTH, adduserpanel);
		sl_adduserpanel.putConstraint(SpringLayout.EAST, adduserbutton, -10, SpringLayout.EAST, adduserpanel);
		adduserpanel.add(adduserbutton);
		
		NameField = new JTextField();
		sl_adduserpanel.putConstraint(SpringLayout.NORTH, NameField, 10, SpringLayout.NORTH, adduserpanel);
		sl_adduserpanel.putConstraint(SpringLayout.NORTH, NameLabel, 0, SpringLayout.NORTH, NameField);
		sl_adduserpanel.putConstraint(SpringLayout.EAST, NameField, -37, SpringLayout.EAST, adduserpanel);
		adduserpanel.add(NameField);
		NameField.setColumns(10);
		
		PasswordField = new JTextField();
		sl_adduserpanel.putConstraint(SpringLayout.NORTH, PasswordField, 16, SpringLayout.SOUTH, NameField);
		sl_adduserpanel.putConstraint(SpringLayout.NORTH, PasswordLabel, 5, SpringLayout.NORTH, PasswordField);
		sl_adduserpanel.putConstraint(SpringLayout.EAST, PasswordField, 0, SpringLayout.EAST, NameField);
		adduserpanel.add(PasswordField);
		PasswordField.setColumns(10);
		
		privlagebox = new JComboBox<String>();
		sl_adduserpanel.putConstraint(SpringLayout.NORTH, privilegeLabel, 4, SpringLayout.NORTH, privlagebox);
		sl_adduserpanel.putConstraint(SpringLayout.NORTH, privlagebox, 26, SpringLayout.SOUTH, PasswordField);
		sl_adduserpanel.putConstraint(SpringLayout.WEST, privlagebox, 0, SpringLayout.WEST, NameField);
		privlagebox.addItem("Admin");
		privlagebox.addItem("Teacher");
		privlagebox.addItem("Student");
		adduserpanel.add(privlagebox);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel();
			}
		});
		sl_adduserpanel.putConstraint(SpringLayout.WEST, cancelButton, 10, SpringLayout.WEST, adduserpanel);
		sl_adduserpanel.putConstraint(SpringLayout.SOUTH, cancelButton, 0, SpringLayout.SOUTH, adduserbutton);
		adduserpanel.add(cancelButton);
		
		JButton generatepassworButton = new JButton("Genertae password");
		sl_adduserpanel.putConstraint(SpringLayout.NORTH, generatepassworButton, 4, SpringLayout.SOUTH, PasswordField);
		sl_adduserpanel.putConstraint(SpringLayout.WEST, generatepassworButton, 10, SpringLayout.WEST, PasswordField);
		sl_adduserpanel.putConstraint(SpringLayout.SOUTH, generatepassworButton, -6, SpringLayout.NORTH, privlagebox);
		sl_adduserpanel.putConstraint(SpringLayout.EAST, generatepassworButton, -10, SpringLayout.EAST, PasswordField);
		generatepassworButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name4 = NameField.getText();
				try {
					String namesplit[] = name4.split(" ");
					String namesplit1 = namesplit[0];
					String namesplit2 = namesplit[1];
					String password5 = "" + namesplit1.charAt(0) +  namesplit1.charAt(1) + namesplit1.charAt(2) + namesplit2.charAt(0) +namesplit2.charAt(1);
					PasswordField.setText(password5);
				} catch (ArrayIndexOutOfBoundsException | StringIndexOutOfBoundsException e1) {
					;
				}
	
			}
		});
		generatepassworButton.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		adduserpanel.add(generatepassworButton);
		springLayout.putConstraint(SpringLayout.WEST, adduserpanel, 24, SpringLayout.EAST, layeredPane_1);
		
		JPanel panel_1 = new JPanel();
		
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 5, SpringLayout.SOUTH, loggedInUser);

		springLayout.putConstraint(SpringLayout.WEST, panel_1, -146, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, 137, SpringLayout.SOUTH, loggedInUser);
		springLayout.putConstraint(SpringLayout.EAST, panel_1, -15, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JToggleButton YourNameLabel = new JToggleButton();
		YourNameLabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(YourNameLabel.getModel().isSelected() == true)
				{
					userpanel.setVisible(true);
				}
				else
				{
					userpanel.setVisible(false);
				}
			}
		});
		sl_panel_1.putConstraint(SpringLayout.NORTH, YourNameLabel, 0, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, YourNameLabel, -4, SpringLayout.EAST, panel_1);
		springLayout.putConstraint(SpringLayout.NORTH, YourNameLabel, 2, SpringLayout.NORTH, panel_1);
		springLayout.putConstraint(SpringLayout.EAST, YourNameLabel, -1, SpringLayout.EAST, panel_1);
		panel_1.add(YourNameLabel);

		YourNameLabel.setText(userelements3[1]);
		
		userpanel = new JPanel();
		
		sl_panel_1.putConstraint(SpringLayout.NORTH, userpanel, 35, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, userpanel, 0, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, userpanel, 131, SpringLayout.WEST, panel_1);
		userpanel.setVisible(false);
		userpanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		sl_panel_1.putConstraint(SpringLayout.WEST, userpanel, 0, SpringLayout.WEST, panel_1);
		panel_1.add(userpanel);
		SpringLayout sl_userpanel = new SpringLayout();
		userpanel.setLayout(sl_userpanel);
		
		JButton LogoutButton = new JButton("Logout");
		sl_userpanel.putConstraint(SpringLayout.NORTH, LogoutButton, 0, SpringLayout.NORTH, userpanel);
		sl_userpanel.putConstraint(SpringLayout.WEST, LogoutButton, 20, SpringLayout.WEST, userpanel);
		userpanel.add(LogoutButton);
		
		JButton btnNewButton = new JButton("Change Password");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PasswordChange passchange1 = new PasswordChange();
				passchange1.authpasschange();
			}
		});
		sl_userpanel.putConstraint(SpringLayout.NORTH, btnNewButton, 6, SpringLayout.SOUTH, LogoutButton);
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		userpanel.add(btnNewButton);
		LogoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				frame.dispose();
				ClassesandSubjects.disposeframe();
				TimeTable.framedispose();
				PasswordChange.dissframe();
				}
				catch(java.lang.NullPointerException e1)
				{
					;
				}
				LoginGUI_project login = new LoginGUI_project();
				login.GUI();
			}
		});
		
		JButton ClassButton = new JButton("Class editor");
		springLayout.putConstraint(SpringLayout.NORTH, ClassButton, 6, SpringLayout.SOUTH, ShowListUser);
		springLayout.putConstraint(SpringLayout.EAST, ClassButton, -23, SpringLayout.WEST, layeredPane);
		ClassButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClassesandSubjects.ClasseditorGUI();
			}
		});
		frame.getContentPane().add(ClassButton);
		
		JButton btnNewButton_1 = new JButton("Timetable editor");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimeTable.TimeTableGUI();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 6, SpringLayout.SOUTH, ClassButton);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, -6, SpringLayout.WEST, layeredPane);
		frame.getContentPane().add(btnNewButton_1);
		
		
}
	public  void UpdateList(String listtype) throws IOException
    {
        
        while(list1.isEmpty() == false)
        {
            list1.remove(0);
        }
        File file = new File("Login.txt");
        Scanner s = new Scanner(file);
        Scanner f = new Scanner(file);
        int counter = 0;
        String splitlist[] = new String[4];
        while(s.hasNextLine())
        {
            counter += 1;
            s.nextLine();
        }
        String allusers[] = new String[counter];
        for(int i = 0; i != counter; i ++)
        {
            splitlist = f.nextLine().split(","); 
            allusers[i] = splitlist[0] + ", " + splitlist[1] + ", " + splitlist[3];
            if(listtype.equals("All"))
            {
            	list1.addElement(allusers[i]);
            }
            if(listtype.equals("Admin")) 
            {
            	if(splitlist[3].equals("Admin"))
            	{
            		list1.addElement(allusers[i]);
            	}
            }
            if(listtype.equals("Student")) 
               {
                if(splitlist[3].equals("Student"))
                {
                	list1.addElement(allusers[i]);
                }
              }
             if(listtype.equals("Teacher")) 
                {
            	 if(splitlist[3].equals("Teacher"))
                {
                	list1.addElement(allusers[i]);
                }
                }
            splitlist = null;
        }
        s.close();
        f.close();
    } 
	
	public void useradd() {
		adduserpanel.setVisible(true);
		
	}
	public void cancel()
	{
		PasswordField.setText("");
		NameField.setText("");
		privlagebox.setSelectedItem("Admin");
		adduserpanel.setVisible(false);
		
	}
	public void adduser() throws IOException
	{
		String name = NameField.getText();
		String password = PasswordField.getText();
		if(!name.equals("") && !password.equals(""))
		{
			String priviladge = privlagebox.getSelectedItem().toString();
		
			hash createhash = new hash();
		
			String user = createUserID.createID(name,"IDnumber.txt",2) + "," + name +"," + createhash.cypher(password) +"," + priviladge;
			FileWriter writetofile = new FileWriter("Login.txt",true);
			PrintWriter printer = new PrintWriter(writetofile);
			printer.println(user);
			writetofile.close();
			printer.close();
			UpdateList(ShowListUser.getSelectedItem().toString());
			PasswordField.setText("");
			NameField.setText("");
			privlagebox.setSelectedItem("Admin");
		}
	}
	public void deleteuser() throws IOException
	{
		panel.setVisible(true);
		scrollPane.setVisible(false);
	}
	public void authdelete() throws IOException
	{
			
		String password = passwordField.getText();
		boolean auth = false;
		File file = new File("Just Logged In.txt");
		Scanner g = new Scanner(file);
		String user = g.nextLine();
		g.close();
		String userelements[] = user.split(",");
		String password2 = userelements[2];
		hash passwordhash = new hash();

		if(passwordhash.cypher(password).equals(password2))
		{
			auth = true;
			panel.setVisible(false);
			scrollPane.setVisible(true);
			passwordField.setText("");
			InccorectPasswordLabel.setVisible(false);
		}
		else
		{
			InccorectPasswordLabel.setVisible(true);
		}
		if( auth == true)
		{
			String value = (String) list.getSelectedValue();
			String[] user1 = value.split(",");
			File loginFile = new File("Login.txt");
			Scanner b = new Scanner(loginFile);
			Scanner c = new Scanner(loginFile);
			int counter = 0;
			while(b.hasNextLine())
			{
				counter ++;
				b.nextLine();

			}
			String users[] = new String[counter];
			for(int i = 0; i != counter; i++)
			{
				users[i] = c.nextLine();
			}
			b.close();
			c.close();
			String users2[] = new String[counter-1];
			int counter2 = 0;
			int counter3 = 0;
			for(int i1 = 0; i1 != counter; i1++)
			{
				String temps[] = users[counter3].split(",");
				if(!user1[0].equals(temps[0]))
				{
					try {
						users2[counter2] = users[counter3];
						counter2 ++;
						counter3 ++;
					}
					catch (ArrayIndexOutOfBoundsException e) 
					{
						;
					}

				}
				else 
				{
					counter3 ++;
				}
				temps = null;

			}
			FileWriter writetofile2 = new FileWriter("Login.txt",false);
			PrintWriter printer2 = new PrintWriter(writetofile2);
			for( int i2= 0; i2 != counter2; i2 ++)
			{
				printer2.println(users2[i2]);

			}
			writetofile2.close();
			printer2.close();
			UpdateList(ShowListUser.getSelectedItem().toString());
			auth = false;
		}
	}
}


