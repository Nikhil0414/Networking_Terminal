package networking2;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;
public class New2
{
static Scanner x=new Scanner(System.in);

 public static void main(String[] args) throws UnknownHostException, IOException, Exception

 {
 String x;
 do {
 System.out.println("\n------------------------------Login--------------------------------------\n");
 System.out.println("( --These are the valid set of commands for Login-- )\n");
 System.out.println("-----------------------------------------------------------------------------");
 System.out.println("|Commands | Function |");
 System.out.println("|---------------------------------------------------------------------------|");
 System.out.println("| newuser | LOGIN INTO THE PROGRAM AS A NEW USER
|");
 System.out.println("| olduser | LOGIN INTO THE PROGRAM AS AN EARLIER USER
|");
 System.out.println("| logout | LOGOUT FROM THE TERMINAL
|");
 System.out.println("-----------------------------------------------------------------------------");
 System.out.println("\nEnter the command : \n");
 @SuppressWarnings("resource") 
 Scanner sc=new Scanner(System.in);
 x=sc.next();

 if("newuser".equals(x))
 {
 JavaFileAppendFileWriter.main(args);
 TrailNet11.main(args);
 }

 else if("olduser".equals(x))
 {
 New1.main(args);
 }

 else if("logout".equals(x))
 {
 System.out.println(" ");
 }

 else
 {
 System.out.println("Wrong Command Entered");
 }

 }
 while(!x.equals("logout"));
 {
 System.out.println("You have been logged out Successfully");
 System.out.println("Code Terminated");
 } 
 }
} 
