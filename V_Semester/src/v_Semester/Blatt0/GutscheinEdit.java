package v_Semester.Blatt0;

import java.io.*;
import Prog1Tools.IOTools;
public class GutscheinEdit {
  public static void main (String[] summand) {
    try {
      String dateiname = "Gutscheine.dat";
      FileOutputStream datAus = new FileOutputStream(dateiname);
      ObjectOutputStream oAus = new ObjectOutputStream(datAus);
      int anzahl = IOTools.readInteger("Anzahl der zu erzeugenden Gutscheine: ");
      oAus.writeInt(anzahl);   // Anzahl der Datensaetze
      Gutschein a;
      long nummer = 20051200000000L;
      for (int i=1; i<=anzahl; i++) {
        nummer++;
        System.out.println("Daten für Gutschein-Nummer " + nummer);
        a = new Gutschein (nummer,
               IOTools.readLine("Name des Gutschein-Besitzers: "),
               IOTools.readInteger("Kundennummer des Gutschein-Besitzers: "),
               IOTools.readDouble("Wert des Gutscheins in EUR: "));
        oAus.writeObject(a); 
      }
      oAus.close();
      System.out.println();
      System.out.println(anzahl + " Gutscheine in die Datei " + 
                         dateiname + " geschrieben");
    }
    catch (Exception e) {
      System.out.println("Fehler beim Schreiben: " + e);
    }
  }
}
