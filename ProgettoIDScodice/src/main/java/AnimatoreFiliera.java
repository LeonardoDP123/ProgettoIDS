public class AnimatoreFiliera {
    private String nome;

    public AnimatoreFiliera(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "AnimatoreFiliera{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
