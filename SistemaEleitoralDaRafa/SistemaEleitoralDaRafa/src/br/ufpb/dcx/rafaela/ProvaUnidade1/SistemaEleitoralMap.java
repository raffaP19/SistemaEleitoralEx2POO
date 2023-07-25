package br.ufpb.dcx.rafaela.ProvaUnidade1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaEleitoralMap implements SistemaEleitoralInterface {

    private Map<String, Eleitor> eleitores;
    private Map<String, Candidato> candidatos;
    private List<Voto> votos;

    public SistemaEleitoralMap() {
        this.eleitores = new HashMap<>();
        this.candidatos = new HashMap<>();
        this.votos = new ArrayList<>();
    }

    @Override
    public Candidato obterDadosDoCandidato(String nome) throws CandidatoInexistenteException {
        Candidato candidato = this.candidatos.get(nome);
        if (candidato == null) {
            throw new CandidatoInexistenteException("Não existe candidato com o nome " + nome);
        } else {
            return candidato;
        }

    }

    @Override
    public int contarVotosParaCandidato(int numero) {
        int  cont = 0;
        for (Voto v: this.votos) {
            if (v.getNumeroVotado() == numero) {
                cont++;
            }

        }
        return cont;

    }

    @Override
    public boolean cadastraCandidato(String nome, int numero, Partido partido) {
        if (this.candidatos.containsKey(nome)) {
            return false;

        }else{
            Candidato candidato = new Candidato(nome, numero, partido);
            this.candidatos.put(nome, candidato);
            return true;

        }

    }

    @Override
    public boolean cadastraEleitor(String nome, String titulo) {
        if (this.eleitores.containsKey(titulo)) {
            return false;

        }else {
            Eleitor eleitor = new Eleitor(nome, titulo);
            this.eleitores.put(titulo, eleitor);
            return true;

        }

    }

    @Override
    public void votar(String numTitulo, int numeroVotado) throws TituloInexistenteException {
        boolean existeEleitor = false;
        for (Eleitor e : this.eleitores.values()) {
            if (e.getTitulo().equals(numTitulo)) {
                existeEleitor = true;
                break;

            }
        }
        if(existeEleitor) {
            this.votos.add(new Voto(numeroVotado));

        }else {
            throw new TituloInexistenteException("Não foi localizado nenhum eleitor com esse título :/");

        }

    }
    
    public void votarEmBranco(String numeroTitulo) throws TituloInexistenteException {
    	boolean existeEleitor = false;
    	for (Eleitor e : this.eleitores.values()) {
            if (e.getTitulo().equals(numeroTitulo)) {
                existeEleitor = true;
                break;

            }
            
        }
    	if(existeEleitor) {
            this.votos.add(new Voto());

        }else {
            throw new TituloInexistenteException("Não foi localizado nenhum eleitor com esse título :/");

        }
    	
    }
    
    public Eleitor obterDadosDoEleitor(String titulo) throws EleitorInexistenteException {
        Eleitor eleitor = this.eleitores.get(titulo);
        if (eleitor == null) {
            throw new EleitorInexistenteException("Não existe eleitor de título " + titulo);
        } else {
            return eleitor;
        }

    }

}

