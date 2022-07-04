import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class hash
//https://howtodoinjava.com/java/java-security/how-to-generate-secure-password-hash-md5-sha-pbkdf2-bcrypt-examples/
{
 
   public String cypher(String password)
   {
       String generatedpass = null;
       try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedpass = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) 
        {
           ;
        }
       return generatedpass;
   }
}
