package networking2;
// Java implementation of Server side
// It contains two classes : Server and ClientHandler
// Save file as Server.java
import java.io.*;
import java.util.*;
import java.net.*;
// Server class
public class GroupChat101
{
 // Vector to store active clients 6
 static Vector<ClientHandler> ar = new Vector<>();
 // counter for clients
 static int i = 0;
 public static void main(String[] args) throws IOException
 {
 System.out.println("\nAlways first run the Server (i.e GroupChat command) in a
window --- and then run the Client/Sender (i.e Members command) another window \n");
 System.out.println("Processing port configuration..."); 
 System.out.println("Wait for a few seconds...\n");
 System.out.println("Now open another window and run Members..." );


 // server is listening on port 1234
 @SuppressWarnings("resource")
 ServerSocket ss = new ServerSocket(1234);
 Socket s;
 // running infinite loop for getting
 // client request
 while (true)
 {
 // Accept the incoming request
 s = ss.accept();
 System.out.println("\nNew client request received : " + s);
 // obtain input and output streams
 DataInputStream dis = new DataInputStream(s.getInputStream());
 DataOutputStream dos = new DataOutputStream(s.getOutputStream());
 System.out.println("Creating a new handler for this client...");

 // Create a new handler object for handling this request.
 ClientHandler mtch = new ClientHandler(s, "User " + i , dis, dos);
 // Create a new Thread with this object.
 Thread t = new Thread(mtch); 
 System.out.println("Adding this client to active client list\n");
 System.out.println("\nThe Name of this User is : ");
 System.out.println("\n User : "+i);
 System.out.println("\n");

 // add this client to active clients list
 ar.add(mtch);
 // start the thread.
 t.start();
 // increment i for new client.
 // i is used for naming only, and can be replaced
 // by any naming scheme
 i++;
 }
 }
}
// ClientHandler class
 class ClientHandler implements Runnable
{
 public String name;
 final DataInputStream dis;
 public final DataOutputStream dos;
 Socket s;
 boolean isloggedin;
 // constructor
 public ClientHandler(Socket s, String name,DataInputStream dis, DataOutputStream dos) { 
 this.dis = dis;
 this.dos = dos;
 this.name = name;
 this.s = s;
 this.isloggedin=true;
 }

 @Override
 public void run() {
 String received;
 while (true)
 {
 try
 {
 // receive the string
 received = dis.readUTF();
 System.out.println(received);
 if(received.equals("logout"))
 {
 this.isloggedin=false;
 this.s.close();
 break;
 }

 // break the string into message and recipient part
 StringTokenizer st = new StringTokenizer(received, "--");
 String MsgToSend = st.nextToken();
 String recipient = st.nextToken(); 
 // search for the recipient in the connected devices list.
 // ar is the vector storing client of active users
 for (ClientHandler mc : GroupChat101.ar)
 {

 // if the recipient is found, write on its
 // output stream
 if (mc.name.equals(recipient) && mc.isloggedin==true)
 {
 System.out.println("\n");
 System.out.println("New Message : ");
 System.out.println("Msg is sent from : "+name+" :
"+MsgToSend);
 mc.dos.writeUTF("Msg is sent from : "+name+" :
"+MsgToSend );
 System.out.println(" ");
 break;
 }
 }

 } catch (IOException e) {
 e.printStackTrace();
 }
 }

 try
 {
 // closing resources
 this.dis.close();
 this.dos.close(); 
 }catch(IOException e){
 e.printStackTrace();
 }
 }
} 
