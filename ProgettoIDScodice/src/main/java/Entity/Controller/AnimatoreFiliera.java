package Entity.Controller;

import Entity.Controller.Evento;
import Util.Enum.ruolo;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class AnimatoreFiliera extends Entity.User {

	private int ID;
	private List<Entity.Evento> eventi;

	public AnimatoreFiliera(String username, String nome, String cognome, Date dataNascita, String numeroTelefono, ruolo role, String indirizzo) {
		super(username, nome, cognome, dataNascita, numeroTelefono, role, indirizzo);
	}

	/**
	 * 
	 * @param evento
	 */
	public void organizzaEvento(Entity.Evento evento) {
		// TODO - implement AnimatoreFiliera.organizzaEvento
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param venditore
	 * @param evento
	 */
	public void invitaVenditoreAllEvento(Entity.Venditore venditore, Entity.Evento evento) {
		// TODO - implement AnimatoreFiliera.invitaVenditoreAllEvento
		throw new UnsupportedOperationException();
	}

}