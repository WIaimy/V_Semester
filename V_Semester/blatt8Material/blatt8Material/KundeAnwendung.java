import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import Prog1Tools.IOTools;

public class KundeAnwendung {

	public static void main(String[] args) {
		int auswahl = IOTools.readInteger("(1) Suchen\n" +
				                          "(2) Kunden erstellen\n" +
				                          "(3) Beenden\n" +
				                          "Auswahl: ");
		while (auswahl != 3) {
			switch (auswahl) {
			  case 1:
				suche();
				break;
			  case 2:
				erstelleKunde();
				break;
			}
			auswahl = IOTools.readInteger("(1) Suchen\n" +
                                          "(2) Kunden erstellen\n" +
                                          "(3) Beenden\n" +
                                          "Auswahl: ");
		}
	}

	private static void erstelleKunde() {
		Kunde kunde = new Kunde();
		EntityManager entityManager = EMProvider.getEntityManager();
		entityManager.getTransaction().begin();
		kunde.setVorname(IOTools.readString("Geben Sie den Vornamen des Kunden ein: "));
		kunde.setNachname(IOTools.readString("Geben Sie den Nachnamen des Kunden ein: "));
		kunde.setKonten(new ArrayList<Konto>());
		entityManager.persist(kunde);

		int anzahlKonten = IOTools.readInteger("Wieviele Konten des Kunden sollen erstellt werden? ");

		for (int i = 0; i < anzahlKonten; i++) {
			System.out.println("Erstelle Konto " + i);
			Konto konto = new Konto();
			konto.setKontonummer(IOTools.readString("Geben Sie die Kontonummer ein: "));
			konto.setBetrag(IOTools.readDouble("Geben Sie den aktuellen Betrag des Kontos ein: "));
			konto.setUeberziehungMoeglich(IOTools.readBoolean("Ist eine Überziehung des Kontos möglich?(true/false): "));
			konto.setKunde(kunde);
			kunde.getKonten().add(konto);
			entityManager.persist(konto);
		}
		entityManager.flush();
		entityManager.getTransaction().commit();
		kundeAusgeben(kunde);
	}

	private static void kundeAusgeben(Kunde kunde) {
		System.out.println();
		System.out.println("Kundenname: " + kunde.getVorname() + " " + kunde.getNachname());
		System.out.println("Anzahl Konten: " + kunde.getKonten().size());
		System.out.println();
		for (Konto konto : kunde.getKonten()) {
			kontoAusgeben(konto);
			System.out.println();
		}
	}

	private static void kontoAusgeben(Konto konto) {
		System.out.println("Kontonummer: " + konto.getKontonummer());
		System.out.println("Aktueller Kontostand: " + konto.getBetrag());
		System.out.println("Überziehung möglich: "+ (konto.isUeberziehungMoeglich() ? "JA" : "NEIN"));
	}

	private static void suche() {
		System.out.println();
		int auswahl = IOTools.readInt("Möchten Sie nach einem Kunden (1) oder einem Konto (2) suchen? ");
		switch (auswahl) {
		case 1:
			sucheKunde();
			break;
		case 2:
			sucheKonto();
			break;
		}

	}

	private static void sucheKonto() {
    // noch zu vervollständigen














	}

	private static void sucheKunde() {
    // noch zu vervollständigen

















	}

}
