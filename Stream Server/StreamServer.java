import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.util.concurrent.TimeUnit;

 
public class StreamServer {
   public static void main(String[] args) {
      try {
         ServerSocket ss = new ServerSocket(5045);
         System.out.println("Server is Start wait client connect....");
         Socket s = ss.accept();
         System.out.println("Client: "+s.getInetAddress().getLocalHost()+" is connect to server");
		 DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		 ReadImageFile newClassObj = new ReadImageFile();
		 byte[][] message = newClassObj.getarray();
         int i=0;
		 int page = newClassObj.getpagenum()/4096;
         while(i<page+1){
			 dout.write(message[i]);
			 System.out.println("Send frame "+i+"/"+page);
			 i++;
		 }
		 dout.flush();
         TimeUnit.SECONDS.sleep(5);

      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}