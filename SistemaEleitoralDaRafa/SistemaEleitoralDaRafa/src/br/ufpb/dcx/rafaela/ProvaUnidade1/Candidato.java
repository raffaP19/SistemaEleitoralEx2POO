package br.ufpb.dcx.rafaela.ProvaUnidade1;

public class Candidato {

    private String nome;
    private int numero;
    private Partido partido;

    public Candidato() {
        this("", 0, null);

    }

    public Candidato(String nome, int numero, Partido partido) {
        this.nome = nome;
        this.numero = numero;
        this.partido = partido;

    }

    @Override
    public String toString() {
        return "Candidato(a) " + getNome() + ", de número " + getNumero()
                + ", partido " + getPartido();

    }

    public String getNome() {
        return this.nome;

    }

    public void setNome(String nome) {
        this.nome = nome;

    }

    public int getNumero() {
        return this.numero;

    }

    public void setNumero(int numero) {
        this.numero = numero;

    }

    public Partido getPartido() {
        return this.partido;

    }

    public void setPartido(Partido partido) {
        this.partido = partido;

    }

}
