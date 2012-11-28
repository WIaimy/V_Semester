package v_Semester.Blatt0;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class GutscheinThread extends Thread {

	Socket s;
	DataInputStream in; // Socket
	ObjectOutputStream out; // Socket
	ObjectInputStream fromFile; // Textdatei
	Gutschein gut;
	int knr;
	int amount;
	
	public GutscheinThread(Socket s) throws IOException { 						// Initialisierung
		this.s = s;
		out = new ObjectOutputStream(s.getOutputStream());
		in = new DataInputStream(s.getInputStream());
		}

	public void run() {
		try {
			while (true) {
				fromFile = new ObjectInputStream(new FileInputStream("Gutscheine.dat")); // Zur Textdatei öffnen

				knr = in.readInt();												//Kundennummer einlesen
				amount = fromFile.readInt();									//Anzahl Datensätze
				
				for(int i = 0; i < amount; i++){
					gut = (Gutschein) fromFile.readObject();
					if(gut.getKdNr() == knr)
						out.writeObject(gut);
				}
				out.writeObject(null);											//Signal, dass alle Objekte gesendet wurden
				fromFile.close();
			}
			
		} catch (IOException e) {
			System.out.println("IOException");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException");
			e.printStackTrace();
		} finally {
			try {
				out.close();
				in.close();
				fromFile.close();
				s.close();
			} catch (IOException e) {
				System.out.println("Fehler bei .close()");
			}
		}

	}
}
