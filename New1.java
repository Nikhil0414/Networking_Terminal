package networking2;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;
public class New1
{
static Scanner x=new Scanner(System.in);

 public static void main(String[] args) throws UnknownHostException, IOException, Exception

 { 

 @SuppressWarnings("resource")
 Scanner x1=new Scanner(System.in);
 System.out.println("\nEnter the Username : ");
 String username=x1.next();
 System.out.println("\nEnter the Password : ");
 String password =x1.next();
 String filepath = "C:\\Users\\NIKHIL\\Downloads/Logins.txt";

 boolean found = false;
 String tempUsername="";
 String tempPassword="";
 x1=new Scanner(new File(filepath));
 x1.useDelimiter("[,\n]");

 while(x1.hasNext() && !found)
 {
 tempUsername=x1.next();
 tempPassword=x1.next();

 if(tempUsername.trim().equals(username.trim()) &&
tempPassword.trim().equals(password.trim()))
 {
 found=true;
 }
 System.out.println(found);
 }
 if(found==true)
 { 
 System.out.println("Login Successful");
 TrailNet11.main(args);
 }
 else
 {
 System.out.println("Login Unsuccessful");
 System.out.println("\nKindly use the newuser command to create
new credentials and login again as a new user. \n");
 }
 }
} 
