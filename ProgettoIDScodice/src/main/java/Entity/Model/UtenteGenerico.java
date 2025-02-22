package Entity.Model;

import java.time.LocalDate;
import java.util.List;

/**
 * Classe astratta per un utente generico.
 */
public abstract class UtenteGenerico {
	private int ID;
	private String username;
	private String nome;
	private String cognome;
	private LocalDate dataDiNascita;
	private String numeroDiTelefono;
	private String indirizzo;
	private Ruolo ruolo;

	public UtenteGenerico(int ID, String username, String nome, String cognome, LocalDate dataDiNascita,
						  String numeroDiTelefono, String indirizzo, Ruolo ruolo) {
		this.ID = ID;
		this.username = username;
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.numeroDiTelefono = numeroDiTelefono;
		this.indirizzo = indirizzo;
		this.ruolo = ruolo;
	}

	public abstract void mostraDettagli();

	public void visualizzaArticoli() {
		Marketplace marketplace = Marketplace.getInstance();
		List<Articolo> articoli = marketplace.getArticoli();

		if (articoli.isEmpty()) {
			System.out.println("Nessun articolo disponibile nel marketplace.");
			return;
		}

		System.out.println("Articoli disponibili nel marketplace:");
		for (Articolo articolo : articoli) {
			System.out.println(articolo);
		}
	}

	// Getter
	public int getID() { return ID; }
	public String getUsername() { return username; }
	public String getNome() { return nome; }
	public String getCognome() { return cognome; }
	public LocalDate getDataDiNascita() { return dataDiNascita; }
	public String getNumeroDiTelefono() { return numeroDiTelefono; }
	public String getIndirizzo() { return indirizzo; }
	public Ruolo getRuolo() { return ruolo; }

	// Setter
	public void setRuolo(Ruolo ruolo) { this.ruolo = ruolo; }
}