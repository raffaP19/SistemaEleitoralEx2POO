package br.ufpb.dcx.rafaela.ProvaUnidade1;

public interface SistemaEleitoralInterface {

    void votar(String numTitulo, int numeroVotado) throws TituloInexistenteException;
    Candidato obterDadosDoCandidato(String nome) throws CandidatoInexistenteException;
    int contarVotosParaCandidato(int numero);
    boolean cadastraCandidato(String nome, int numero, Partido partido);
    boolean cadastraEleitor(String nome, String titulo);

}

