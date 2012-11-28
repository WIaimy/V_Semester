package v_Semester.Blatt0;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class GutscheinKlasse {
	
	public static void main(String[] args){
		InputStream reader = null;
		String file = "Gutscheine.dat";
		Gutschein gut;
		
		try{
			reader = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(reader);
			int number = ois.readInt();
			System.out.println("Die Datei " + file + " enthält " + number + " Datensätze.");
		
			for(int i = 0; i < number; i++){
				gut = (Gutschein) ois.readObject();
				System.out.println(gut.toString());
			}
			ois.close();
			
		}catch(Exception io){
			System.out.println("Nope, Chuck Testa!");
		}
	}
}
