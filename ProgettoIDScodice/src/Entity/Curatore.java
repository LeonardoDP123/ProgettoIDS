package Entity;

import Util.Enum.ruolo;

import java.util.Date;

public class Curatore extends User {

	private int ID;

	public Curatore(String username, String nome, String cognome, Date dataNascita, String numeroTelefono, ruolo role, String indirizzo) {
		super(username, nome, cognome, dataNascita, numeroTelefono, role, indirizzo);
	}


	public void approvaProdotto() {

	}

	public void confermaPacchetto() {

	}

}
