package networking2;
import java.net.*;
import java.util.*;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.nio.channels.*;
import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.*;
public class TrailNet15
{
 public static void main(String[] args) throws Exception
 {
 Class.forName("com.mysql.cj.jdbc.Driver");
 Connection
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/imt","root","Imtiaztoff@9");
 Statement stmt =con.createStatement();

 System.out.println(" ");
 String x;
 System.out.println("( --Type -help to see the valid set of commands-- )");
 do {
 System.out.println(" ");
 System.out.println("Enter the command : ");
 @SuppressWarnings("resource")
 Scanner sc=new Scanner(System.in);
 x=sc.next();
 System.out.println("");
 if("-help".equals(x))
 { 
 System.out.println("----------------------------------------------------------------
-------------");
 System.out.println("|Commands | Function
|");
 System.out.println("|--------------------------------------------------------------
-------------|");
 System.out.println("| | |");
 System.out.println("| -help | SHOW ALL THE AVAILABLE
COMMANDS ON THIS TERMINAL |");
 System.out.println("| newuser | LOGIN INTO THE PROGRAM AS A
NEW USER |");
 System.out.println("| olduser | LOGIN INTO THE PROGRAM AS AN
EARLIER USER |");
 System.out.println("| logout | LOGOUT FROM THE TERMINAL
|");
 System.out.println("| myip | GENERATE MY SYSTEM IP &
COMUTER NAME |");
 System.out.println("| netcon | TO CHECK INTERNET
CONNECTIVITY OF THE USER |");
 System.out.println("| filedown | TO DOWNLOAD A FILE FROM THE
URL AND SAVE IT INTO SYSTEM |");
 System.out.println("| sendmail | TO SEND A MAIL ONLY BY USING
JAVA NETWORKING |");
 System.out.println("| GroupChat | TO RUN THE SERVER TO
DISPLAY THE SERVER |");
 System.out.println("| Members | TO SEND MESSAGE TO THE
GROUP AS A MEMBER |");
 System.out.println("| Dreci | TO RECEIVE THE MESSAGE
THROUGH NETWORKING (UDP) PORT |");
 System.out.println("| Dsend | TO SEND THE MESSAGE THROUGH
NETWORKING (UDP) PORT |");
 System.out.println("| CreCookie | TO CREATE A COOKIE IN A
DOMAIN VISIBLE TO SERVER IN DNS |"); 
 System.out.println("| DelCookie | TO DISCARD A COOKIE FROM
THE USER SIDE |");
 System.out.println("| webpgsrc | TO VIEW THE HTML CODE OF
THE WEB PAGE |");
 System.out.println("| webip | GENERATE HOSTNAME & IP OF
URL |");
 System.out.println("| URLstats | DATE, CACHE, CONTENT TYPE,
P3P, SERVER, X-FRAME-OPT |");
 System.out.println("| checkURL | CHECK URL AND RETURNS
RESULT IN THE FORM OF CODES |");
 System.out.println("| URLinfo | VAILDITY, PROTOCOL, HOST,
PORT, PATH, FILE, QUERY |");
 System.out.println("| pgtittle | TO VIEW THE TITTLE ON THE WEB
PAGE |");
 System.out.println("| exit | TERMINATE CODE
|");
 System.out.println("| | |");
 System.out.println("----------------------------------------------------------------
-------------");
 }
 else if("myip".equals(x))
 {
 InetAddress ip = InetAddress.getLocalHost();
 String hostname = ip.getHostName();
 InetAddress address = InetAddress.getByName("localhost");
 String sql = "insert into myip " 
 + " (ip, hostname, address)" + " values (?, ?, ?)";
 stmt = con.prepareStatement(sql);
 stmt.executeUpdate("insert into myip
values('"+ip+"','"+hostname+"','"+address+"')");



 ResultSet rs=stmt.executeQuery("select * from myip");
 while(rs.next())
 {
 String Ip=rs.getString("ip");
 String Hostname=rs.getString("hostname");
 String Address=rs.getString("address");
 System.out.println(Ip+" "+Hostname+" "+Address);
 }
 }
 else if("webip".equals(x))
 {
 try{
 System.out.println("Enter web site url (Eg:www.google.com)
: ");
 String s1=sc.next();
 InetAddress ip=InetAddress.getByName(s1); 
 String Host_name = ip.getHostName();
 String ip_address=ip.getHostAddress();
 String sql = "insert into webip "
 + " ( Host_name,ip_address)" + " values (?,
?)";
 stmt = con.prepareStatement(sql);
 stmt.executeUpdate("insert into webip
values('"+Host_name+"','"+ip_address+"')");



 ResultSet ts=stmt.executeQuery("select * from webip");
 while(ts.next())
 {
 String host_name=ts.getString("Host_name");
 String Address=ts.getString("ip_address");
 System.out.println(host_name+" "+Address);
 }
 }
 catch(Exception e)
 {
 System.out.print(e);
 } 

 }

 else if("GroupChat".equals(x))
 {
 GroupChat101.main(args);
 }

 else if("Members".equals(x))
 {
 Members101.main(args);
 break;
 }

 else if("netcon".equals(x))
 {
 try {
 System.out.println("Enter the URL to check your
connectivity (Eg:https://www.google.com) : ");
 String url1=sc.next();
 URL url = new URL(url1);
 URLConnection connection = url.openConnection();
 connection.connect();
 System.out.println("Connection was Successful ");
 System.out.println("You are connected to the Internet ");
 } 
 catch (Exception e) {
 System.out.println("Internet Not Connected");
 }
 }
 else if("webpgsrc".equals(x))
 {

 System.out.println("Enter the URL
(Eg:https://www.google.com) : ");
 String url1=sc.next();
 URL url = new URL(url1);
 URLConnection urlcon=url.openConnection();
 InputStream stream=urlcon.getInputStream();
 int i;

 while((i=stream.read())!=-1){

 System.out.print((char)i);

 }


 } 
 else if("URLstats".equals(x))
 {


 System.out.println ("Enter a URL
(Eg:https://www.google.com) : ");
 String url2 = sc.next();
 URL url = new URL(url2);
 HttpURLConnection
huc=(HttpURLConnection)url.openConnection();





 String sql = "insert into urlstats "
 + "
(date_n,date,catch_c,catch_control,content_type_n,content,p3p_n,p3p,"
 +
"server_n,server,x_xss_n,x_xss,x_frame,x_frame_options,set_cookie_n,set_cookie,set_cookie_1n,"
 +
"set_cookie_1,alt_svc_n,alt_svc,accept_range_n,accept_range,vary,vary_1,transfor_n,transfor)"
 + " values (?, ?, ?, ?,?, ?, ?,?, ?, ?,?,
?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?)";
 stmt = con.prepareStatement(sql); 
 stmt.executeUpdate("insert into urlstats
values('"+huc.getHeaderFieldKey(1)+"','"+huc.getHeaderField(1)+"','"+huc.getHeaderFieldKey(3)+"','
"+huc.getHeaderField(3)+"','"+huc.getHeaderFieldKey(4)+"','"+huc.getHeaderField(4)+"','"+huc.getH
eaderFieldKey(5)+"','"+huc.getHeaderField(5)+"','"+huc.getHeaderFieldKey(6)+"','"+huc.getHeaderFi
eld(6)+"','"+huc.getHeaderFieldKey(7)+"','"+huc.getHeaderField(7)+"','"+huc.getHeaderFieldKey(8)+"
','"+huc.getHeaderField(8)+"','"+huc.getHeaderFieldKey(9)+"','"+huc.getHeaderField(9)+"','"+huc.get
HeaderFieldKey(10)+"','"+huc.getHeaderField(10)+"','"+huc.getHeaderFieldKey(11)+"','"+huc.getHea
derField(11)+"','"+huc.getHeaderFieldKey(12)+"','"+huc.getHeaderField(12)+"','"+huc.getHeaderField
Key(13)+"','"+huc.getHeaderField(13)+"','"+huc.getHeaderFieldKey(14)+"','"+huc.getHeaderField(14)
+"')");



 ResultSet rs=stmt.executeQuery("select * from
urlstats");
 while(rs.next())
 {
 String date_n=rs.getString("date_n");
 String date=rs.getString("date");

 String catch_c=rs.getString("catch_c");
 String catch_con=rs.getString("catch_control");
 String content_n=rs.getString("content_type_n");
 String content=rs.getString("content");
 String p3p_n=rs.getString("p3p_n");
 String p3p=rs.getString("p3p");
 String server_n=rs.getString("server_n");
 String server=rs.getString("server");
 String x_xss=rs.getString("x_xss_n");
 String x_xs=rs.getString("x_xss");
 String x_frame=rs.getString("x_frame"); 
 String x_fram=rs.getString("x_frame_options");
 String set_cookie=rs.getString("set_cookie_n");
 String set_cook=rs.getString("set_cookie");
 String set_cookie1=rs.getString("set_cookie_1n");
 String set_cook1=rs.getString("set_cookie_1");

 String alt_svc_n=rs.getString("alt_svs_n");
 String alt_sv=rs.getString("alt_svs");
 String
accept_range=rs.getString("accept_range_n");
 String accept_rang=rs.getString("accept_range");
 String vary=rs.getString("vary");
 String var=rs.getString("vary_1");
 String transfor=rs.getString("transfor_n");
 String trans=rs.getString("transfor");

 System.out.println(date_n);
 System.out.println(date);

 System.out.println(catch_c);
 System.out.println(catch_con);
 System.out.println(content_n);
 System.out.println(content);
 System.out.println(p3p_n);
 System.out.println(p3p);
 System.out.println(server_n); 
 System.out.println(server);
 System.out.println(x_xss);
 System.out.println(x_xs);
 System.out.println(x_frame);
 System.out.println(x_fram);
 System.out.println(set_cookie);
 System.out.println(set_cook);
 System.out.println(set_cookie1);
 System.out.println(set_cook1);

 System.out.println(alt_svc_n);
 System.out.println(alt_sv);
 System.out.println(accept_range);
 System.out.println(accept_rang);
 System.out.println(vary);
 System.out.println(var);
 System.out.println(transfor);
 System.out.println(trans);
 }


 huc.disconnect();

 } 
 else if("checkURL".equals(x))
 {
 System.out.println("Results and what does the result indicates -->");
 System.out.println("200--The URL is correct");
 System.out.println("301 -- Permanent redirect to another
webpage");
 System.out.println("400 -- Bad request, 404 -- Not found");
 System.out.println("403 -- redirected twice hence server denied the
permission for access");
 System.out.println("");
 System.out.println("Enter the Url to be checked :
(Eg:https://www.google.com) : ");
 String url3 = sc.next();
 URL url = new URL(url3);
 int responseCode = ((HttpURLConnection)
url.openConnection()).getResponseCode();

 String sql = "insert into checkurl "
 + " ( url,result)" + " values (?, ?)";
 stmt = con.prepareStatement(sql);
 stmt.executeUpdate("insert into checkurl
values('"+url3+"','"+responseCode+"')");


 ResultSet ts=stmt.executeQuery("select * from checkurl");
 while(ts.next()) 
 {
 String Url=ts.getString("url");
 String Result=ts.getString("result");
 System.out.println(Url+" "+Result);
 }
 }
 else if("URLinfo".equals(x))
 {
 boolean urlValid = false;
 URL url = null;
 while(!urlValid) {
 System.out.println("Enter the URL
(Eg:https://www.google.com)");
 System.out.println("Or");
 System.out.println("(Eg:
https://www.google.com/search?q=What+is+java&rlz=1C1CHWL_enIN921IN921&oq=What+is+java
&aqs=chrome..69i57j69i64j69i65l2j69i60.10427j0j1&sourceid=chrome&ie=UTF-8) : ");
 String url4=sc.next();
 url = new URL(url4);
 urlValid = true;
 System.out.println("The url was valid"); 
 }

 String sql = "insert into urlinfo "
 + " (url,protocol,
host_name,port_number,default_portno,query_string,path,file)"
 + " values (?, ?, ?)";
 stmt = con.prepareStatement(sql);
 stmt.executeUpdate("insert into urlinfo
values('"+url.toString()+"','"+url.getProtocol()+"',"
 +
"'"+url.getHost()+"','"+url.getPort()+"','"+url.getDefaultPort()+"','"+url.getQuery()+"',"
 +
"'"+url.getPath()+"','"+url.getFile()+"')");



 ResultSet rs=stmt.executeQuery("select * from urlinfo");
 while(rs.next())
 {
 String Url1=rs.getString("urll");
 String Protocol=rs.getString("protocol");
 String Host_name=rs.getString("host_name");
 String port=rs.getString("port_number");
 String default_port1=rs.getString("default_portno"); 
 String Query_string=rs.getString("query_string");
 String Path=rs.getString("path");
 String File=rs.getString("file");
 System.out.println(Url1);
 System.out.println(Protocol);
 System.out.println(Host_name);
 System.out.println(port);
 System.out.println(default_port1);
 System.out.println(Query_string);
 System.out.println(Path);
 System.out.println(File);
 }
 }
 else if("filedown".equals(x))
 {
 {
 System.out.println("Enter the URL of file (Eg:
https://www.w3.org/TR/PNG/iso_8859-1.txt ) :");
 String url = sc.next();
 System.out.println(" ");
 System.out.println("Enter the location where the file is to be
saved on ur system :");
 System.out.println("Eg:
C:\\Users\\NIKHIL\\Downloads/iso_8859-1.txt");
 String s2=sc.next();
 System.out.println(" "); 
 System.out.println("Enter the location where the file is to be
saved Again to confirm the location : ");
 System.out.println("Eg:
C:\\Users\\NIKHIL\\Downloads/iso_8859-1.txt");
 String s3=sc.next();

 String sql = "insert into filedown "
 + " (url, location, location1)" + " values (?, ?,
?)";
 stmt = con.prepareStatement(sql);
 stmt.executeUpdate("insert into filedown
values('"+url+"','"+s2+"','"+s3+"')");


 ResultSet rs=stmt.executeQuery("select * from filedown");
 while(rs.next())
 {
 String url1=rs.getString("url");
 String location=rs.getString("location");
 String location1=rs.getString("location1");
 System.out.println(url1+" "+location+" "+location1);
 }
 try {
 downloadUsingNIO(url,s2);
 downloadUsingStream(url,s3); 
 } catch (IOException e) {
 e.printStackTrace();
 }
 System.out.println("Processing... ");
 System.out.println(" File Saved ");
 }
 }
 else if("pgtittle".equals(x))
 {
 System.out.println("Please type in a URL
(Eg:https://www.google.com) : :");
 String url5 = sc.next();
 if (url5.length() == 0)
 { System.out.println("Wrong Input");}
 String content = readURLContent(url5);
 String title = findTitle(content);

 String sql = "insert into pgtitle "
 + " (url,title)" + " values (?, ?)";
 stmt = con.prepareStatement(sql);
 stmt.executeUpdate("insert into pgtitle
values('"+url5+"','"+title+"')"); 



 ResultSet rs=stmt.executeQuery("select * from pgtitle");
 while(rs.next())
 {

 String Url=rs.getString("url");
 String Title=rs.getString("title");
 System.out.println(Url+" "+Title);
 }

 }

 else if("sendmail".equals(x))
 {
 {
 String host = "smtp.gmail.com";
 String port = "smtp.gmail.com";
 System.out.println(" ");
 System.out.println("Enter the your usermail id :");
 String mailFrom = sc.next();
 System.out.println("Enter the password :");
 String password = sc.next(); 
 // outgoing message information
 System.out.println("Enter the mail id of reciever :");
 String mailTo = sc.next();
 System.out.println("Enter the Subject :");
 String subject = sc.nextLine();
 subject+=sc.nextLine();
 System.out.println("Enter the Message to be sent :");
 String message = sc.nextLine();
 message+=sc.nextLine();

 String sql = "insert into sendmail "
 + " (send_to,subject,msg)" + " values (?,?,
?)";
 stmt = con.prepareStatement(sql);
 stmt.executeUpdate("insert into sendmail
values('"+mailTo+"','"+subject+"','"+message+"')");



 ResultSet rs=stmt.executeQuery("select * from sendmail");
 while(rs.next())
 {

 String send=rs.getString("send_to"); 
 String sub=rs.getString("subject");
 String msg=rs.getString("msg");
 System.out.println(send);
 System.out.println(sub);
 System.out.println(msg);
 }

 System.out.println("Press Enter again to confirm the
message and wait for a few seconds.");
 System.out.println("Processing...");
 TrailNet15 mailer = new TrailNet15();
 try {
 mailer.sendPlainTextEmail(host, port, mailFrom,
password, mailTo,
 subject, message);
 System.out.println("Done.");
 System.out.println("Email sent.");
 } catch (Exception ex) {
 System.out.println("Failed to sent email.");
 System.out.println(" ");
 System.out.println("If your mail is not sent properly
please Go to this link below and disable the feature : ");

 System.out.println("https://myaccount.google.com/lesssecureapps?pli=1");
 System.out.println("If still failed to send the mail");
 System.out.println(" Turn off your network firewall
"); 
 System.out.println(" ");
 ex.printStackTrace();
 }
 }
 }
 else if("Dreci".equals(x))
 {
 System.out.println("Always first run the Server/Receiver (i.e Dreci
command) in a window --- and then run the Client/Sender (i.e Dsend command) another window
\n");
 System.out.println("Enter a port number to establish connection :
(i.e Any Random 4 digit Number Between 4000-9000) : \n");
 int i=sc.nextInt();
 System.out.println("Processing port configuration...");
 System.out.println("Wait for a few seconds...\n");
 System.out.println("Now open another window and run Dsend");
 System.out.println(" ");

 DatagramSocket ds = new DatagramSocket(i);
 byte[] buf = new byte[1024];
 DatagramPacket dp = new DatagramPacket(buf, 1024);
 ds.receive(dp);
 String str = new String(dp.getData(), 0, dp.getLength());
 System.out.println("... ");
 System.out.println("... ... "); 
 System.out.println(" ");
 System.out.println("Configuration Successful \n");
 System.out.println("You are now CONNECTED \n");
 System.out.println("The message received form the sender is : \n");
 String sql = "insert into reci "
 + " (msg)" + " values ( ?)";
 stmt = con.prepareStatement(sql);
 stmt.executeUpdate("insert into reci values('"+str+"')");



 ResultSet rs=stmt.executeQuery("select * from reci");
 while(rs.next())
 {
 String inp=rs.getString("msg");
 System.out.println(inp);
 }
 ds.close();
 System.out.println(" ");
 System.out.println("Hence Connection Established");
 }
 else if("Dsend".equals(x)) 
 {
 {
 System.out.println("Always run the Server/Receiver (i.e
Dreci command) first in another window and then run the Client/Sender ");
 System.out.println(" ");
 System.out.println("Enter the SAME port number to
establish connection :");
 int i=sc.nextInt();
 System.out.println("Enter the data to be send : ");
 String str = sc.nextLine();
 str+=sc.nextLine();
 DatagramSocket ds = new DatagramSocket();
 InetAddress ip = InetAddress.getByName("127.0.0.1");
 DatagramPacket dp = new DatagramPacket(str.getBytes(),
str.length(), ip, i);
 ds.send(dp);
 ds.close();
 }
 }

 else if("CreCookie".equals(x))
 {
 System.out.println("Enter a name of the Cookie: ");
 String x1=sc.next();
 HttpCookie object = new HttpCookie(x1, "1"); 
 System.out.println("Enter a comment for the Cookie: ");
 String x2=sc.next();
 object.setComment(x2);
 System.out.println("Enter the domain name for the Cookie: ");
 String x3=sc.next();
 object.setDomain(x3);
 object.setMaxAge(2000);
 /*System.out.println("\nComment: "+object.getComment());
 System.out.println("The required domain is: "+object.getDomain());

 System.out.println("The maximum age is given as:
"+object.getMaxAge()+"sec");
 System.out.println("Name for the cookie is given as:
"+object.getName());
 System.out.println("The hash code for the given cookie is given as:
"+object.hashCode());*/

 String sql = "insert into crecookie "
 + " (name,comment,domain,maxage,hash_code)"
 + " values (?, ?, ?)";
 stmt = con.prepareStatement(sql);
 stmt.executeUpdate("insert into crecookie
values('"+object.getName()+"','"+object.getComment()+"','"+object.getDomain()+"','"+object.getMa
xAge()+"','"+object.hashCode()+"')");
 


 ResultSet rs=stmt.executeQuery("select * from crecookie");
 while(rs.next())
 {
 String Name=rs.getString("name");
 String Comment=rs.getString("comment");
 String domain=rs.getString("domain");
 String maxage=rs.getString("maxage");
 String hash_code=rs.getString("hash_code");

 System.out.println("Name for the cookie is given as: "+Name);
 System.out.println("\nComment: "+ Comment);
 System.out.println("The required domain is: "+domain);
 System.out.println("The maximum age is given as: "+maxage);
 System.out.println("The hash code for the given cookie is given as:
"+hash_code);

 }
 }

 else if("DelCookie".equals(x))
 {
 {
 System.out.println("Enter a name of the Cookie: "); 
 String x1=sc.next();
 HttpCookie cookie = new HttpCookie(x1, "1");
 System.out.println("Enter the value for the Cookie:
");
 String x2=sc.next();
 cookie.setDiscard(true);
 System.out.println("\nThe discard attribute is given
as: "+cookie.getDiscard());
 cookie.setVersion(1);
 System.out.println("The version is given as: "+
cookie.getVersion());
 cookie.setValue(x2);
 System.out.println("The value is given as:
"+cookie.getValue());
 System.out.println("Check whether cookie has
expired or not: "+ cookie.hasExpired());
 cookie.setHttpOnly(true);
 System.out.println("Check whether the cookie
contains the HttpOnly attribute or not: " +cookie.isHttpOnly());
 }
 } 
 else if("exit".equals(x))
 {
 System.out.println("! Code Terminated !");
 }

 else
 {
 System.out.println(" Input Error ");
 System.out.println(" TRY AGAIN WITH VALID COMMAND (ENTER -
help COMMAND TO VIEW THE VALID COMMANDS ) ");
 }
 System.out.println(" ");
 }
 while(!x.equals("exit"));
 {
 System.out.println(" ");
 }
 stmt.close();
 con.close();

 }

 public void sendPlainTextEmail(String host, String port,
 final String userName, final String password, String toAddress, 
 String subject, String message) throws AddressException,
 MessagingException {
 // sets SMTP server properties
 Properties properties = new Properties();
 properties.put("mail.smtp.host", host);
 properties.put("mail.smtp.port", port);
 properties.put("mail.smtp.auth", "true");
 properties.put("mail.smtp.starttls.enable", "true");
 // creates a new session with an authenticator
 Authenticator auth = new Authenticator() {
 public PasswordAuthentication getPasswordAuthentication() {
 return new PasswordAuthentication(userName, password);
 }
 };
 Session session = Session.getInstance(properties, auth);
 // creates a new e-mail message
 Message msg = new MimeMessage(session);
 msg.setFrom(new InternetAddress(userName));
 InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
 msg.setRecipients(Message.RecipientType.TO, toAddresses); 
 msg.setSubject(subject);
 msg.setSentDate(new Date());
 // set plain text message
 msg.setText(message);
 // sends the e-mail
 Transport.send(msg);
 }


// filedown
 private static void downloadUsingStream(String urlStr, String file) throws IOException
 {
 URL url = new URL(urlStr);
 BufferedInputStream bis = new BufferedInputStream(url.openStream());
 FileOutputStream fis = new FileOutputStream(file);
 byte[] buffer = new byte[1024];
 int count=0;
 while((count = bis.read(buffer,0,1024)) != -1)
 {
 fis.write(buffer, 0, count);
 }
 fis.close();
 bis.close(); 
 }
 //filedown
 private static void downloadUsingNIO(String urlStr, String file) throws IOException
 {
 URL url = new URL(urlStr);
 ReadableByteChannel rbc = Channels.newChannel(url.openStream());
 FileOutputStream fos = new FileOutputStream(file);
 fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
 fos.close();
 rbc.close();
 }
// pg tittle
 public static String readURLContent(String urlString)throws IOException
 {
 URL url = new URL(urlString);
 Scanner sc = new Scanner(url.openStream());
 String content = new String();
 while (sc.hasNext())
 content += sc.next();
 sc.close();
 return content;
 } 
//pg tittle
 public static String findTitle(String str)
 {
 String tagOpen = "<title>";
 String tagClose = "</title>";
 int begin = str.indexOf(tagOpen) + tagOpen.length();
 int end = str.indexOf(tagClose);
 return str.substring(begin, end);
 }
} 
