package networking2;
// JavaFileAppendFileWriterExample.java
//Created by https://alvinalexander.com
import java.io.*;
import java.net.UnknownHostException;
import java.util.Scanner;
public class JavaFileAppendFileWriter {
 public static void main (String[] args) throws UnknownHostException, IOException, Exception
{
 JavaFileAppendFileWriter a = new JavaFileAppendFileWriter(); 
 a.appendToCheckbook();
 }
 public void appendToCheckbook () {
 BufferedWriter bw = null;
 @SuppressWarnings("resource")
 Scanner sc=new Scanner (System.in);
 System.out.println("Enter the New UserName");
 String x=sc.nextLine();
 System.out.println("Enter the New Password : ");
 String y=sc.nextLine();
 try {
 bw = new BufferedWriter(new
FileWriter("C:\\Users\\NIKHIL\\Downloads/Logins.txt", true));
 bw.write(x+","+y);
 bw.newLine();
 bw.flush();
 System.out.println("Login Created ");
 } catch (IOException ioe) {
 ioe.printStackTrace();
 } finally {
 if (bw != null) try {
 bw.close();
 } catch (IOException ioe2) {
 }
 } 
 }
} 
