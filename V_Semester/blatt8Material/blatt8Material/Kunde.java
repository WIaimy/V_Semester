import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "KUNDE")
public class Kunde {

	private long id;
	private String vorname;
	private String nachname;
	private List<Konto> konten;
	
	@OneToMany(mappedBy="kunde")
	public List<Konto> getKonten() {
		return konten;
	}

	public void setKonten(List<Konto> konten) {
		this.konten = konten;
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

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	

}
