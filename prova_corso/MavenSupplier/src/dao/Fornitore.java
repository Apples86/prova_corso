package dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fornitori")
public class Fornitore {

	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codiceFornitore;

	@Column(name = "Nome")
	private String Nome;

	@Column(name = "Cognome")
	private String Cognome;

	@Column(name = "Citta")
	private String Citta;

	@Column(name = "Indirizzo")
	private String Indirizzo;

	@Column(name = "numTelefono")
	private String numTelefono;


	public void setcodiceFornitore(int CodiceFornitore) {
		this.codiceFornitore = CodiceFornitore;
	}
	
	public int getCodiceFornitore() {
		return codiceFornitore;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String Nome) {
		this.Nome = Nome;
	}

	public String getCognome() {
		return Cognome;
	}

	public void setCognome(String Cognome) {
		this.Cognome = Cognome;
	}

	public String getCitta() {
		return Citta;
	}

	public void setCitta(String Citta) {
		this.Citta = Citta;
	}

	public String getIndirizzo() {
		return Indirizzo;
	}

	public void setIndirizzo(String Indirizzo) {
		this.Indirizzo = Indirizzo;
	}

	public String getNumTelefono() {
		return numTelefono;
	}

	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}


}
