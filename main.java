import java.io.*;
import java.util.Random;
import javax.swing.JFrame;

public class main {

	public static void main(String[] args) throws IOException, InterruptedException {
		 FileWriter emptyFile = new FileWriter("Just Logged In.txt",false);
		 PrintWriter empty = new PrintWriter(emptyFile);
	     empty.println("");
	     empty.close();
	     emptyFile.close();
	     LoadingScreen.loadgui();
	     Random rand = new Random(); 
	      int max = 6000;
	      int min = 2000;
	      int int_random = rand.nextInt(max-min) + min;
	     Thread.sleep(int_random);
	     LoadingScreen.disposeframe();
	     Thread.sleep(800);
	     LoginGUI_project.GUI();
	}

}
