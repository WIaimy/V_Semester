import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "KONTO")
public class Konto {

	private long id;
	private String kontonummer;
	private double betrag;
	private boolean ueberziehungMoeglich;
	private Kunde kunde;

	@ManyToOne
	@JoinColumn(name = "KUNDE_ID")
	public Kunde getKunde() {
		return kunde;
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

	@Id
	@TableGenerator(name = "idGenerator", table = "ARG_IDPOOL", pkColumnName = "ARGON2", valueColumnName = "GEN_ID", pkColumnValue = "ID", allocationSize = (int) 10)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGenerator")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getKontonummer() {
		return kontonummer;
	}

	public void setKontonummer(String kontonummer) {
		this.kontonummer = kontonummer;
	}

	public double getBetrag() {
		return betrag;
	}

	public void setBetrag(double betrag) {
		this.betrag = betrag;
	}

	public boolean isUeberziehungMoeglich() {
		return ueberziehungMoeglich;
	}

	public void setUeberziehungMoeglich(boolean ueberziehungMoeglich) {
		this.ueberziehungMoeglich = ueberziehungMoeglich;
	}

}
