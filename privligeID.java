
/**
 * Write a description of class privligeID here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.*;
import java.util.*;
public class privligeID
{
    public static void getPrivlageID() throws IOException
    {
    boolean x = false;
    String userprivlige = "";
    while(x != true)
    {
        try{
            File currentUser = new File("Just Logged In.txt");
            Scanner loggedInUser = new Scanner(currentUser);
            String userDetails = loggedInUser.nextLine();
            loggedInUser.close();
            String currentUserDetails[] = new String[4];
            currentUserDetails = userDetails.split(",");
            userprivlige = currentUserDetails[3];
            String user = currentUserDetails[1];
            String idnumber = currentUserDetails[0];
            x = true;
        }
   catch(NoSuchElementException e)
   {
       ;
    }
    
    }
    if(userprivlige.equals("Admin"))
    {
       
        AdminGUI.GUI();
    }
     else if(userprivlige.equals("Teacher"))
     {   
        TeacherGUI.Teacher();
     }
     else if(userprivlige.equals("Student"))
     {   
         StudentGUI.GUI();
     }
    
    }
 }

 
