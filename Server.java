import java.io.*;  
import java.net.*;  
import java.util.Scanner;
public class Server {  
public static void main(String[] args){
	Scanner sc=new Scanner(System.in);
		System.out.println("--------------------------------------------");  
		System.out.println("-------------------Chaty--------------------");  
		System.out.println("--------------------------------------------");
		System.out.println("-------developed by sachira madhushan-------");
		System.out.println("--------------------------------------------");
		System.out.println();
		System.out.println();
		System.out.print("[?]Enter your name :");
		String userName=sc.nextLine();
		System.out.println();
		System.out.print("[?]Enter port number :");
		int portNumber=sc.nextInt();
try{  
	ServerSocket ss=new ServerSocket(portNumber); 
	System.out.println("[+]Waitting for client......");
	Socket s=ss.accept();
	System.out.println("[+]Client Connected !");
	System.out.println();
	System.out.println();
	
	DataInputStream din=new DataInputStream(s.getInputStream());  
	DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
  
	String str="",str2="";  
	while(!str.equals("stop")){  
		str=din.readUTF();  
		System.out.println(str);  
		System.out.print("[+]Me : ");  
		
		str2=br.readLine();  
		dout.writeUTF("[-]"+userName+" :"+str2);  
		dout.flush();  
	}  
	din.close();  
	s.close();  
	ss.close();  
}catch(Exception e){
	System.out.println("[*]Error while Connecting to the server !");
		}
	}
}