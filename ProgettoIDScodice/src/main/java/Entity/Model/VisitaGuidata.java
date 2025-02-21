package Entity.Model;

import java.time.LocalDate;

public class VisitaGuidata extends Evento {
	private String guida;
	private int numeroPartecipanti;

	public VisitaGuidata(int ID, String nome, LocalDate data, String luogo, String descrizione, String guida, int numeroPartecipanti) {
		super(ID, nome, data, luogo, descrizione);
		this.guida = guida;
		this.numeroPartecipanti = numeroPartecipanti;
	}

	public String getGuida() { return guida; }
	public int getNumeroPartecipanti() { return numeroPartecipanti; }

	@Override
	public String toString() {
		return "VisitaGuidata{" +
				"ID=" + ID +
				", nome='" + nome + '\'' +
				", data=" + data +
				", luogo='" + luogo + '\'' +
				", descrizione='" + descrizione + '\'' +
				", guida='" + guida + '\'' +
				", numeroPartecipanti=" + numeroPartecipanti +
				'}';
	}
}