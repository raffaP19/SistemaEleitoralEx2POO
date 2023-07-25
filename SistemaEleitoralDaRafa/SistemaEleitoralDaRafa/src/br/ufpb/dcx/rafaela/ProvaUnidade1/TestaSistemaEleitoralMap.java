package br.ufpb.dcx.rafaela.ProvaUnidade1;

public class TestaSistemaEleitoralMap {
	
    public static void main(String [] args) {

        //new na classe para que possa ser inicializado as operações:/
        SistemaEleitoralMap sistema = new SistemaEleitoralMap();
        
        //a) Estou cadastrando o(a) Candidato(a):
        sistema.cadastraCandidato("Rafaela", 2003, Partido.PARTIDO3);
        sistema.cadastraCandidato("Lucas", 2000, Partido.PARTIDO1);
        
        //b) Estou cadastrando o(a) Eleitor(a):
        sistema.cadastraEleitor("Emanuela", "2007-9");
        sistema.cadastraEleitor("Yan", "928-8");
        
        //c) Tratando a exceção que poderia ser lançada ao votar e testando a parte do voto:
        try {
			sistema.votar("2007-9", 2000);
			
		} catch (TituloInexistenteException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
		}
        
        //d) Chamando o método que conta votos de determinado candidato:
        System.out.println(sistema.contarVotosParaCandidato(2000));
        
        //e) Tratando a exceção que poderia ser lançada com a parte de obter votos de determinado candidato:
        try {
			System.out.println(sistema.obterDadosDoCandidato("Lucas"));
			
		} catch (CandidatoInexistenteException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
		}
        
        //f) Cadastrando candidato com inforações sem parametros:
        sistema.cadastraCandidato("", 0, null);
        
        //g) Testando o voto em branco e passando somente o título do eleitor:
        try {
			sistema.votarEmBranco("2007-9");
			
		} catch (TituloInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
        
        //h) Testando o contar votos em branco, lembrando que foi criado um enum VOTOEMBRANCO: 
        System.out.println(sistema.contarVotosParaCandidato(0));
        
        //i) Testando o método para obter dados do eleitor:
        try {
			System.out.println(sistema.obterDadosDoEleitor("928-8"));
		} catch (EleitorInexistenteException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
		}
        
    }

}
