import java.awt.EventQueue;
import java.awt.Image;
import java.awt.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SpringLayout;
import javax.swing.JEditorPane;
import java.awt.Choice;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.net.URL;


public class LoadingScreen {

	public static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void loadgui() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoadingScreen window = new LoadingScreen();
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
	public LoadingScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws InterruptedException 
	 */
	private void initialize()  {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);

		
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		frame.setLocationRelativeTo(null);
		JLayeredPane layeredPane = new JLayeredPane();
		springLayout.putConstraint(SpringLayout.NORTH, layeredPane, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, layeredPane, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, layeredPane, 0, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, layeredPane, 0, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(layeredPane);
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(138, 184, 160, 88);
		layeredPane.add(lblNewLabel_1);
		URL url2 = getClass().getResource("Resources/1.gif");
		ImageIcon img2 = new ImageIcon(url2);
		lblNewLabel_1.setIcon(img2);



		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 450, 278);
		layeredPane.add(lblNewLabel);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 132, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 158, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, frame.getContentPane());
		URL url = getClass().getResource("Resources/5.png");
		ImageIcon img = new ImageIcon(url);
		lblNewLabel.setIcon(img);
		
	}
	public static void disposeframe()
	{
		
		frame.dispose();
	}
}
