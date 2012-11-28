package v_Semester.Blatt0;

import java.net.ServerSocket;
import java.net.Socket;

public class GutscheinServer {

	public static void main(String[] port) {
		try {
//			ServerSocket mySocket = new ServerSocket(Integer.parseInt(port[counter]));
			@SuppressWarnings("resource")
			ServerSocket mySocket = new ServerSocket(11111);
			System.out.println("Server's running!");
		
			while(true){
				Socket s = mySocket.accept();
				new GutscheinThread(s).start();
			}
		
		} catch(ArrayIndexOutOfBoundsException ie){
			System.out.println("Falscher Aufruf - Port vergessen?");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
