import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.io.*;
import java.util.*;
public class TTGUI {

	private static JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void TT() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TTGUI window = new TTGUI();
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
	public TTGUI() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setResizable(false);
		Color panelcolour = Color.decode("#fefcf4");
		frame.getContentPane().setBackground(panelcolour);
		frame.setBounds(100, 100, 442, 287);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		SpringLayout sl_layeredPane = new SpringLayout();
		layeredPane.setLayout(sl_layeredPane);

		String[] columnNames = {"","Monday","Tuesday","Wednesday","Thursday","Friday"};
		table = new JTable(GetTT(), columnNames);
		table.setRowHeight(30);
		table.setRowHeight(3, 15);
		table.setRowHeight(6,20);
		table.setGridColor(Color.BLACK);
		table.setEnabled(false);
		sl_layeredPane.putConstraint(SpringLayout.NORTH, table, 10, SpringLayout.NORTH, layeredPane);
		sl_layeredPane.putConstraint(SpringLayout.WEST, table, 10, SpringLayout.WEST, layeredPane);
		sl_layeredPane.putConstraint(SpringLayout.SOUTH, table, -10, SpringLayout.SOUTH, layeredPane);
		sl_layeredPane.putConstraint(SpringLayout.EAST, table, 440, SpringLayout.WEST, layeredPane);
		layeredPane.add(table);

	}
	public static String[][] GetTT() throws IOException
	{
		Hashtable<String, Integer> daystoindex = new Hashtable<String, Integer>();
		daystoindex.put("Monday", 0);
		daystoindex.put("Tuesday", 1);
		daystoindex.put("Wednesday", 2);
		daystoindex.put("Thursday", 3);
		daystoindex.put("Friday", 4);
		
		String Tclasses = "";
		String[][] TeacherTT = new String[6][5];

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
					Tclasses += temp[2] + ",";
					
				}
			}
		}
		
		//System.out.println(Tclasses);
		String[] Tclasses1 = Tclasses.split(",");
		ArrayList Tclasses2 = new ArrayList();
		for(int i= 0; i != Tclasses1.length; i ++)
		{
			Tclasses2.add(Tclasses1[i]);
		}

		File f3 = new File("timetable.txt");
		Scanner s5 = new Scanner(f3);
		Scanner s6 = new Scanner(f3);
		int counter2 = 0;
		while(s5.hasNextLine())
		{
			s5.nextLine();
			counter2 ++;
		}
		s5.close();
		String[] adminTT = new String[counter2];
		for(int i = 0; i != counter2; i ++)
		{
			adminTT[i] = s6.nextLine();
		}
		s6.close();
		for(int i = 0; i != counter2; i ++)
		{
			String[] temp2 = adminTT[i].split(":");
			String day = temp2[1];
			String[] temp3 = temp2[2].split(",");
			for(int c = 0; c != temp3.length; c ++)
			{

				String[] temp4 = temp3[c].split("/");
				for(int d = 0; d != temp4.length; d ++)
				{

					if(Tclasses2.contains(temp4[d]))
					{
						TeacherTT[c][daystoindex.get(day)] = temp4[d];
					}
				}
			}

		}
				
		int countery = 1;
		int counterx = 1;
		String[][] TTT = new String[9][6];
		
		TTT[0][1] = "Monday";
		TTT[0][2] = "Tuesday";
		TTT[0][3] = "Wednesday";
		TTT[0][4] = "Thursday";
		TTT[0][5] = "Friday";
		
		TTT[1][0] = "Period 1";
		TTT[2][0] = "Period 2";
		TTT[3][0] = "Break";
		TTT[4][0] = "Period 3";
		TTT[5][0] = "Period 4";
		TTT[6][0] = "Lunch";
		TTT[7][0] = "Period 5 ";
		TTT[8][0] = "Period 6";
	
		
		for(int y = 0; y != TeacherTT.length; y ++)
		{
			for(int x = 0; x != TeacherTT[y].length; x ++)
			{

				TTT[countery][counterx] = TeacherTT[y][x];
				counterx ++;
			}
			counterx = 1;
			countery ++;
			if(countery == 3|| countery == 6)
			{
				countery ++;
			}
		}
		return TTT;
	}
	public static void disframe()
	{
		frame.dispose();
	}
}
