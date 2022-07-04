
/**
 * Write a description of class login here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.*;
import java.util.*;

public class authorization
{
    public boolean login(String username, String password) throws IOException
    {
       boolean authorized = false;
       
       hash passwordhash = new hash();

        try
        {
        File loginFile = new File("Login.txt");
        Scanner users = new Scanner(loginFile);
        Scanner processingUsers = new Scanner(loginFile);
        Scanner error = new Scanner(loginFile);
        error.nextLine();
        int numberOfUsers = 0;
        while(users.hasNextLine())
        {
            numberOfUsers ++;
            users.nextLine();
        }
        String accounts[] = new String[numberOfUsers];
        for( int x = 0; x != numberOfUsers; x ++)
        {
            accounts[x] = processingUsers.nextLine();
        }
        String acountDetails[] = new String[4];
        
        for (String i:accounts)
        {
            acountDetails = i.split(",");
            if(username.equals(acountDetails[1]) && passwordhash.cypher(password).equals(acountDetails[2]))
            {
               authorized = true; 
               //LoginGUI_project.disfarme();
               FileWriter justLoggedIn = new FileWriter("Just Logged In.txt",false);
               PrintWriter writeToFile2 = new PrintWriter(justLoggedIn);
               writeToFile2.println(acountDetails[0]+","+acountDetails[1]+","+acountDetails[2]+","+acountDetails[3]);
               justLoggedIn.close();
               writeToFile2.close();
              // privligeID.getPrivlageID();
              // System.out.println("Login" + " " +acountDetails[3]);
//            }
//            else
//            {
//            	LoginGUI_project.errorlable();
//            }
        }
        }
        users.close();
        processingUsers.close();
        error.close();
        
    }
 
        catch(IOException | java.util.NoSuchElementException exc)
        {
        FileWriter loginFile = new FileWriter("Login.txt",true);
        PrintWriter writeToFile = new PrintWriter(loginFile);
        String path1 = "IDnumber.txt";
        int id = createUserID.createID(username,path1,2);
        writeToFile.println(id +","+username + "," + passwordhash.cypher(password) + "," + "Admin");
        loginFile.close();
        writeToFile.close();
    }
    return authorized;
    }
}
