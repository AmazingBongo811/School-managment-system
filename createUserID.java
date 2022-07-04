
/**
 * Write a description of class createUserID here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.*;
import java.util.*;
public class createUserID
{
	public static int createID(String data, String path, int tofile) throws IOException
	{
		int currentid = 0;
		try
		{
			File IDS = new File(path);
			Scanner read = new Scanner(IDS);
			Scanner numberofIDS = new Scanner(IDS);
			Scanner users = new Scanner(IDS);
			read.nextLine();
			read.close();
			int numberofusers = 0;
			while(numberofIDS.hasNextLine())
			{
				numberofusers ++;
				numberofIDS.nextLine();
			}
			String users1[] = new String[numberofusers];
			for( int i = 0; i != numberofusers; i ++)
			{
				users1[i] = users.nextLine();
			}
			String lastuser = users1[numberofusers-1];
			String IDAndUser[] = lastuser.split(",");
			String ID = IDAndUser[0];
			int id = Integer.parseInt(ID);
			currentid = id + 1;
			if(tofile == 2)
			{
				FileWriter writetofile = new FileWriter(path,true);
				PrintWriter writetofile1 = new PrintWriter(writetofile);
				writetofile1.println(currentid+","+data);
				writetofile.close();
				writetofile1.close();
			}
			numberofIDS.close();
			users.close();
		}
		catch(IOException | java.util.NoSuchElementException e)
		{
			currentid = 1;
			if(tofile == 2)
			{
				FileWriter writetofile2 = new FileWriter("IDnumber.txt",false);
				PrintWriter writetofile3 = new PrintWriter(writetofile2);
				writetofile3.println(currentid+","+data);
				writetofile2.close();
				writetofile3.close();
			}
		}

		return currentid;
	}
}
