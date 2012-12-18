package v_Semester.Blatt4;

import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

import v_Semester.Blatt0.Gutschein;

public class GutscheinClientR {

	public static void main(String[] para) {
		Scanner sc = new Scanner(System.in);

		try {
			GutscheinInterface gi = (GutscheinInterface) Naming
					.lookup("rmi://localhost:1099/Gutschein");
			while (true) {
				System.out.println("Kundennummer:\t");
				int knr = sc.nextInt();
				if (knr == -1)
					return;
		
				// Liste holen
				List<Gutschein> l = gi.getGutscheine(knr);
				
				// Ausgeben
				for (Gutschein g : l)
					System.out.println(g);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}
}
