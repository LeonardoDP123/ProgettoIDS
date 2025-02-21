package Entity.Model;

import java.time.LocalDate;

public class Fiera extends Evento {
	private int numeroEspositori;

	public Fiera(int ID, String nome, LocalDate data, String luogo, String descrizione, int numeroEspositori) {
		super(ID, nome, data, luogo, descrizione);
		this.numeroEspositori = numeroEspositori;
	}

	public int getNumeroEspositori() { return numeroEspositori; }

	@Override
	public String toString() {
		return "Fiera{" +
				"ID=" + ID +
				", nome='" + nome + '\'' +
				", data=" + data +
				", luogo='" + luogo + '\'' +
				", descrizione='" + descrizione + '\'' +
				", numeroEspositori=" + numeroEspositori +
				'}';
	}
}