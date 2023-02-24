package networking2;
// Java implementation for multithreaded chat client
// Save file as Client.java
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Members101
{
 final static int ServerPort = 1234;
 public static void main(String args[]) throws UnknownHostException, IOException,
InterruptedException
 {
 System.out.println("\nAlways first run the Server (i.e GroupChat command) in a
window --- and then run the Client/Sender (i.e Members command) another window \n");
 System.out.println("Processing port configuration...");

 System.out.println("\n Type logout to end the GroupChat..\n");
 System.out.println("Type the Message to be sent : Eg: hi--User 1\n"); 
 @SuppressWarnings("resource")
 Scanner sc = new Scanner(System.in);

 // getting localhost ip
 InetAddress ip = InetAddress.getByName("localhost");

 // establish the connection
 @SuppressWarnings("resource")
 Socket s = new Socket(ip, ServerPort);
 // obtaining input and out streams
 DataInputStream dis = new DataInputStream(s.getInputStream());
 DataOutputStream dos = new DataOutputStream(s.getOutputStream());

 // sendMessage thread
 // sendMessage thread
 Thread sendMessage = new Thread(new Runnable()
 {
 @Override
 public void run() {
 while (true) {
 // read the message to deliver.
 try {
 String msg1 = sc.nextLine();
 System.out.println("\n");
 System.out.println("Message-->"+msg1+"<--sent
to");
 String s1="Message-->"+msg1+"<--sent to";
 // write on the output stream
 dos.writeUTF(s1);
 dos.writeUTF(msg1);
 
 } catch (IOException e) {
 e.printStackTrace();
 }
 }
 }
 });
 // readMessage thread
 Thread readMessage = new Thread(new Runnable()
 { @Override
 public void run() {
 while (true) {
 try {
 // read the message sent to this client
 String msg1 = dis.readUTF();
 System.out.println(msg1);
 } catch (IOException e) {
 e.printStackTrace();
 }
 }
 }
 });
 sendMessage.start();
 readMessage.start();
 System.out.println("User : i is assigned according to the execution");
 System.out.println("\n");
 }
}
