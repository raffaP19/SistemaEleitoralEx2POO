package br.ufpb.dcx.rafaela.ProvaUnidade1;

import javax.swing.JOptionPane;

public class MenuUrnaEleitoralDaRafa {

    public static void main(String [] args) {

        SistemaEleitoralMap sistema = new SistemaEleitoralMap();
        JOptionPane.showMessageDialog(null, "Siga os passos indicados ;-; ");
        boolean continuar = true;
      
        while (continuar) {
        	String opcao = JOptionPane.showInputDialog("Digite uma opção:\n1. Cadastrar Candidato\n2. Cadastrar Eleitor " +
                     "\n3. Obter Dados do Candidato\n4. Obter dados do Eleitor\n5. Votar\n6. Contar votos em branco\n7. Contar Votos para Candidato\n8. Sair");
            if (opcao.equals("1")) {
            	String nome = JOptionPane.showInputDialog("Digite seu nome: ");
            	int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de seu candidato: "));
            	int partido = 0;
            	try {
            		
            		partido = Integer.parseInt(JOptionPane.showInputDialog("Qual o seu partido? "));
            	
            	}catch (NumberFormatException e) {
            		JOptionPane.showMessageDialog(null, "Informe apenas números");
            	
            	}
            	
            	if (partido == 1) {
            		sistema.cadastraCandidato(nome, numero, Partido.PARTIDO1);
            		JOptionPane.showMessageDialog(null, "Candidato cadastrado com sucesso");
            		
            	} else if (partido == 2) {
            		sistema.cadastraCandidato(nome, numero, Partido.PARTIDO2);
            		JOptionPane.showMessageDialog(null, "Candidato cadastrado com sucesso");

            		
            	} else if (partido == 3) {
            		sistema.cadastraCandidato(nome, numero, Partido.PARTIDO3);
            		JOptionPane.showMessageDialog(null, "Candidato cadastrado com sucesso");

            		
            	} else {
            		JOptionPane.showMessageDialog(null, "Partido não cadastrado :/");
            		
            	}
            
            }else if (opcao.equals("2")) {
            	String nome = JOptionPane.showInputDialog("Digite seu nome: ");
            	String titulo = JOptionPane.showInputDialog("Digite o número do seu título: ");
            	sistema.cadastraEleitor(nome, titulo);	
            	
            }else if (opcao.equals("3")) {
            	String nome = JOptionPane.showInputDialog("Digite o nome do candidato: ");
            	try {
					JOptionPane.showMessageDialog(null, sistema.obterDadosDoCandidato(nome));
				} catch (CandidatoInexistenteException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
            	
            }else if (opcao.equals("4")) {
            	String titulo = JOptionPane.showInputDialog("Digite o titulo do eleitor: ");
            	try {
            		JOptionPane.showMessageDialog(null, sistema.obterDadosDoEleitor(titulo));
				} catch (EleitorInexistenteException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
            	
            }else if (opcao.equals("5")) {
            	
            	String titulo = JOptionPane.showInputDialog("Digite o número do seu título: ");
            	int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o número: "));
            	try {
					sistema.votar(titulo, numero);
				} catch (TituloInexistenteException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
            	
            }else if (opcao.equals("6")) {
            	JOptionPane.showMessageDialog(null, sistema.contarVotosParaCandidato(0));
            	
            }else if (opcao.equals("7")) {
            	int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do candidato: "));
            	JOptionPane.showMessageDialog(null, sistema.contarVotosParaCandidato(numero));
            	
            }else if (opcao.equals("8")) {
            	continuar = false;
            	
            }

        }

    }

}
