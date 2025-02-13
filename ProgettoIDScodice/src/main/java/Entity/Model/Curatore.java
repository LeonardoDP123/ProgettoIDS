package Entity;

import Util.Enum.ruolo;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Curatore extends User {



	public Curatore(String username, String nome, String cognome, LocalDate dataNascita, String numeroTelefono, String indirizzo) {
		super(username, nome, cognome, dataNascita, numeroTelefono, ruolo.Curatore, indirizzo);
	}

	public static Curatore creaCuratore()
		{
		Scanner sc = new Scanner(System.in);
		System.out.println("Inserisci username");
		String username = sc.nextLine();

		System.out.println("Inserisci nome");
		String nome = sc.nextLine();

		System.out.println("Inserisci cognome");
		String cognome = sc.nextLine();

		System.out.println("Inserisci data di nascita (formato: YYYY-MM-DD)");
		String dataNascitaStr = sc.nextLine();
		LocalDate dataNascita = LocalDate.parse(dataNascitaStr, DateTimeFormatter.ISO_DATE);

		System.out.println("Inserisci numero di telefono");
		String numeroTelefono = sc.nextLine();

		System.out.println("Inserisci indirizzo");
		String indirizzo = sc.nextLine();

		return new Curatore(username,nome,cognome,dataNascita,numeroTelefono,indirizzo);

	}




	public void approvaProdotto() {

	}

	public void confermaPacchetto() {

	}

}
