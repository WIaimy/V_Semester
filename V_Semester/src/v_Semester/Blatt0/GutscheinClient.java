package v_Semester.Blatt0;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.Socket;

public class GutscheinClient {

	public static void main(String[] para) {
		try {
			Socket s = new Socket("127.0.0.1", 11111); 								// Sockets
			ObjectInputStream in = new ObjectInputStream(s.getInputStream());
			DataOutputStream out = new DataOutputStream(s.getOutputStream());

			BufferedReader clientInput = new BufferedReader(
					new InputStreamReader(System.in)); 								// Für Eingabe der KNR
			int knr;
			Gutschein gut;

			System.out.println("Abfragen von Gutscheinen vom GutscheinServer:");

				while (true) {				
					System.out.println("Kunden-Nummer (-1 fuer Abbruch):\t");
					knr = Integer.parseInt(clientInput.readLine());
					
					if(knr == -1){
						in.close(); 												// Datenströme schließen
						out.close();
						clientInput.close();
						s.close();
						break;
					}
					
					out.writeInt(knr);
					System.out.println("Alle Gutscheine für KNR " + knr + ":");

					while ((gut = (Gutschein) in.readObject()) != null) {
						System.out.println(gut.toString()); 						// Objekte ausgeben
					}
				}
		}

		catch (IOException e) {
			System.out.println("IOException");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException");
			e.printStackTrace();
		} finally {
			System.out.println("Alle Ströme geschlossen, Client beendet");
		}
	}
}
