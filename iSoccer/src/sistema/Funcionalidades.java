package sistema;

import java.util.Scanner;

import funcionarios.*;
import pessoa.*;
import recursos_fisicos.*;
import socios_torcedores.*;

public class Funcionalidades implements ComportamentosDeRecursos {

	private SingletonSistema sistema;
	private Scanner entrada;	
	
	
	public void iniciarSistema() {
		sistema = SingletonSistema.getInstance();
		exibirMenu();
	}
	
	private void exibirMenu() {
		
		int opcao;
		entrada = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n[1] Adicionar funcionario");
			System.out.println("[2] Adicionar socio-torcedor");
			System.out.println("[3] Gerenciar recursos fisicos");
			System.out.println("[4] Solicitar relatorios");
			System.out.println("[5] Habilitar jogador");
			System.out.println("[6] Atualizar socio-torcedor");
			System.out.println("[0] SAIR");
			while(true) {
				try {
					opcao = Integer.parseInt(entrada.next());
				} catch(NumberFormatException e) {
					System.out.println("\nEntrada invalida!");
					continue;
				} break;
			}
			switch (opcao) {
				case 0: return;
				case 1: adicionarFuncionario(); break;
				case 2: adicionarSocioTorcedor(); break;
				case 3: gerenciarRecursosFisicos(); break;
				case 4: solicitarRelatorios(); break;
				case 5: habilitarJogador(); break;
				case 6: atualizarSocioTorcedor(); break;
				default: System.out.println("\nEscolha uma opcao valida!"); break;
			}
		}
	}
	
	private void adicionarFuncionario() {
		sistema.setFuncionarios(FactoryPessoa.getFuncionario());
		System.out.println("\nFuncionario adicionado.");
	}
	
	private void adicionarSocioTorcedor() {
		sistema.setSociosTorcedores(FactoryPessoa.getSocioTorcedor());
		System.out.println("\nSocio-torcedor adicionado.");
	}
	
	private void gerenciarRecursosFisicos() {
		int opcao;
		
		entrada = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n[1] Onibus\n[2] Estadio"
					+ "\n[3] Centro de treinamento");
			while(true) {
				try {
					opcao = Integer.parseInt(entrada.next());
				} catch(NumberFormatException e) {
					System.out.println("\nEntrada invalida!");
					continue;
				} break;
			}
			if(opcao == 1) escolherGerenciamento("onibus");
			else if(opcao == 2) escolherGerenciamento("estadio");
			else if(opcao == 3) escolherGerenciamento("centro");
			else {
				System.out.println("\nOpcao invalida!");
				continue;
			} break;
		}
	}
	
	private void escolherGerenciamento(String recurso) {
		int opcao;
		
		entrada = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n[1] Adicionar recurso");
			System.out.println("[2] Verificar recurso");
			System.out.println("[3] Disponibilizar recurso");
			while(true) {
				try {
					opcao = Integer.parseInt(entrada.next());
				} catch(NumberFormatException e) {
					System.out.println("\nEntrada invalida!");
					continue;
				} break;
			}
			if(opcao == 1) {
				adicionarRecurso(recurso);
			} else if(opcao == 2) {
				if(verificarRecurso(recurso)) {
					System.out.println("\nHa recurso disponivel.");
				} else {
					System.out.println("\nNao ha recurso disponivel.");
				}
			} else if(opcao == 3) {
				disponibilizarRecurso(recurso);
			} else {
				System.out.println("\nOpcao invalida!");
				continue;
			} break;
		}
	}
	
	private void solicitarRelatorios() {
		int opcao;
		
		entrada = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n[1] Relatorio do time");
			System.out.println("[2] Relatorio dos servicos gerais");
			System.out.println("[3] Relatorio dos recursos fisicos");
			System.out.println("[4] Relatorio dos socios-torcedores");
			System.out.println("[0] SAIR");
			while(true) {
				try {
					opcao = Integer.parseInt(entrada.next());
				} catch(NumberFormatException e) {
					System.out.println("\nEntrada invalida!");
					continue;
				} break;
			}
			switch (opcao) {
				case 0: return; 
				case 1: imprimirRelatorioDeTime(); break;
				case 2: imprimirRelatorioDeServicos(); break;
				case 3: imprimirRelatorioDeRecursos(); break;
				case 4: imprimirRelatorioDeSocios(); break;
				default: System.out.println("\nEscolha uma opcao valida!"); break;
			}
		}
	}
	
	private void imprimirRelatorioDeTime() {
		
		for(int i = 0; i < sistema.getFuncionarios().size(); i++) {
			if(sistema.getFuncionarios().get(i) instanceof Tecnico) {
				System.out.println("\nTreinador: " + sistema.getFuncionarios().get(i).getNome());
				System.out.println("Email: " + sistema.getFuncionarios().get(i).geteMail());
				System.out.println("CPF: " + sistema.getFuncionarios().get(i).getCpf());
				System.out.println("Telefone: " + sistema.getFuncionarios().get(i).getTelefone());
				System.out.println("Salario: " + ((Funcionario) sistema.getFuncionarios().get(i)).getSalario());
				break;
			}
		}
		for(int i = 0; i < sistema.getFuncionarios().size(); i++) {
			if(sistema.getFuncionarios().get(i) instanceof Jogador) {
				System.out.println("\nJogador: " + sistema.getFuncionarios().get(i).getNome());
				System.out.println("Email: " + sistema.getFuncionarios().get(i).geteMail());
				System.out.println("CPF: " + sistema.getFuncionarios().get(i).getCpf());
				System.out.println("Telefone: " + sistema.getFuncionarios().get(i).getTelefone());
				System.out.println("Salario: " + ((Funcionario) sistema.getFuncionarios().get(i)).getSalario());
				System.out.println("Tipo: " + ((Jogador) sistema.getFuncionarios().get(i)).getTipoDeJogador());
				if( ((Jogador) sistema.getFuncionarios().get(i)).isAptoAJogar() ) {
					System.out.println("Apto a jogar: Sim");
				} else {
					System.out.println("Apto a jogar: Nao");
				}
			}
		}
	}
	
	private void imprimirRelatorioDeServicos() {
		
		for(int i = 0; i < sistema.getFuncionarios().size(); i++) {
			if(! (sistema.getFuncionarios().get(i) instanceof Jogador) &&
					! (sistema.getFuncionarios().get(i) instanceof Tecnico) &&
					! (sistema.getFuncionarios().get(i) instanceof Presidente)) {
				System.out.println("\nNome: " + sistema.getFuncionarios().get(i).getNome());
				System.out.println("Email: " + sistema.getFuncionarios().get(i).geteMail());
				System.out.println("CPF: " + sistema.getFuncionarios().get(i).getCpf());
				System.out.println("Telefone: " + sistema.getFuncionarios().get(i).getTelefone());
				System.out.println("Salario: " + ((Funcionario) sistema.getFuncionarios().get(i)).getSalario());
			}
		}
		
	}
	
	private void imprimirRelatorioDeRecursos() {
		
		int contOnibus = 0;
		int contEstadio = 0;
		int contCentro = 0;
		boolean aux;
		
		for(int i = 0; i < sistema.getRecursosFisicos().size(); i++) {
			if(sistema.getRecursosFisicos().get(i) instanceof Onibus) {
				aux = ((Onibus) sistema.getRecursosFisicos().get(i)).isEstadoAtual();
				System.out.print("Onibus " + ++contOnibus + ": ");
				if(aux) System.out.println("Disponivel");
				else System.out.println("Indisponivel");
			}
			else if(sistema.getRecursosFisicos().get(i) instanceof Estadio) {
				aux = ((Estadio) sistema.getRecursosFisicos().get(i)).isEstadoAtual();
				System.out.print("Estadio " + ++contEstadio + ": ");
				if(aux) System.out.println("Disponivel");
				else System.out.println("Indisponivel");
			}
			else if(sistema.getRecursosFisicos().get(i) instanceof CentroDeTreinamento) {
				aux = ((CentroDeTreinamento) sistema.getRecursosFisicos().get(i)).isEstadoAtual();
				System.out.print("Centro de treinamento " + ++contCentro + ": ");
				if(aux) System.out.println("Disponivel");
				else System.out.println("Indisponivel");
			}
		}
	}
	
	private void imprimirRelatorioDeSocios() {
		int adimplentes = 0;
		int inadimplentes = 0;
		
		System.out.println("\nQuantidade de socios: " + sistema.getSociosTorcedores().size());
		
		for(int i = 0; i < sistema.getSociosTorcedores().size(); i++) {
			if( ((SocioTorcedor) sistema.getSociosTorcedores().get(i)).isEstadoDePagamento()) {
				adimplentes++;
			} else {
				inadimplentes++;
			}
		}
		System.out.println("Socios adimplentes: " + adimplentes);
		System.out.println("Socios inadimplentes: " + inadimplentes);
		
		for(int i = 0; i < sistema.getSociosTorcedores().size(); i++) {
			System.out.println("\nSocio: "+ sistema.getSociosTorcedores().get(i).getNome());
			System.out.println("Email: " + sistema.getSociosTorcedores().get(i).geteMail());
			System.out.println("CPF: " + sistema.getSociosTorcedores().get(i).getCpf());
			System.out.println("Telefone: " + sistema.getSociosTorcedores().get(i).getTelefone());
			System.out.println("Endereco: " + ((SocioTorcedor) sistema.getSociosTorcedores().get(i)).getEndereco());
			System.out.println("Contribuicao: " + ((SocioTorcedor) sistema.getSociosTorcedores().get(i)).getValorContribuicao());
		}
	}
	
	private void habilitarJogador() {
		int jogador;
		
		jogador = procurarJogador();
		if(jogador == -1) {
			System.out.println("\nJogador nao encontrado!");
			return;
		}
		((Jogador) sistema.getFuncionarios().get(jogador)).setAptoAJogar();
		System.out.println("\nOperacao realizada!");
	}
	
	private int procurarJogador() {
		String nome;
		
		entrada = new Scanner (System.in);
		System.out.print("\nEntre com o nome completo do jogador: ");
		nome = entrada.nextLine();
		
		for(int i = 0; i < sistema.getFuncionarios().size(); i++) {
			if(!(sistema.getFuncionarios().get(i) instanceof Jogador)) {
				continue;
			}
			if(sistema.getFuncionarios().get(i).getNome().equalsIgnoreCase(nome)) {		
				return i;
			}
		}
		return -1;
	}
	
	private void atualizarSocioTorcedor() {
		int socio;
		int opcao;
		
		socio = procurarSocioTorcedor();
		if(socio == -1) {
			System.out.println("\nSocio nao encontrado!");
			return;
		}
		while(true) {
			System.out.println("\n[1] Estado de pagamento");
			System.out.println("[2] Valor de contribuicao");
			while(true) {
				try {
					opcao = Integer.parseInt(entrada.next());
				} catch(NumberFormatException e) {
					System.out.println("\nEntrada invalida!");
					continue;
				} break;
			}
			if(opcao == 1) {
				((SocioTorcedor) sistema.getSociosTorcedores().get(socio)).editarEstadoDePagamento();
			} else if(opcao == 2) {
				((SocioTorcedor) sistema.getSociosTorcedores().get(socio)).editarValorContribuicao();
			} else {
				System.out.println("\nOpcao invalida!");
				continue;
			} break;
		}
		System.out.println("\nOperacao realizada!");
	}
	
	private int procurarSocioTorcedor() {
		String nome;
		
		entrada = new Scanner(System.in);
		System.out.print("\nEntre com o nome completo do socio: ");
		nome = entrada.nextLine();
		
		for(int i = 0; i < sistema.getSociosTorcedores().size(); i++) {
			if(sistema.getSociosTorcedores().get(i).getNome().equalsIgnoreCase(nome)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void adicionarRecurso(String recurso) {
		// TODO Auto-generated method stub
		Object novoRecurso;
		
		if(recurso.equals("onibus")) {
			novoRecurso = new Onibus();
			((Onibus) novoRecurso).setDados();
			sistema.setRecursosFisicos(novoRecurso);
		} else if(recurso.equals("estadio")) {
			novoRecurso = new Estadio();
			((Estadio) novoRecurso).setDados();
			sistema.setRecursosFisicos(novoRecurso);
		} else if(recurso.equals("centro")) {
			novoRecurso = new CentroDeTreinamento();
			((CentroDeTreinamento) novoRecurso).setDados();
			sistema.setRecursosFisicos(novoRecurso);
		}
		System.out.println("\nRecurso adicionado!");
	}

	@Override
	public boolean verificarRecurso(String recurso) {
		// TODO Auto-generated method stub
		int cont = 0;
		
		for(int i = 0; i < sistema.getRecursosFisicos().size(); i++) {
			if(recurso.equals("onibus")) {
				if(!(sistema.getRecursosFisicos().get(i) instanceof Onibus)) {
					continue;
				}
				if(((Onibus) sistema.getRecursosFisicos().get(i)).isEstadoAtual()) {
					cont++;
				}
			} else if(recurso.equals("estadio")) {
				if(!(sistema.getRecursosFisicos().get(i) instanceof Estadio)) {
					continue;
				}
				if(((Estadio) sistema.getRecursosFisicos().get(i)).isEstadoAtual()) {
					cont++;
				}
			} else if(recurso.equals("centro")) {
				if(!(sistema.getRecursosFisicos().get(i) instanceof CentroDeTreinamento)) {
					continue;
				}
				if(((CentroDeTreinamento) sistema.getRecursosFisicos().get(i)).isEstadoAtual()) {
					cont++;
				}
			}
		}
		return (cont != 0);
	}

	@Override
	public void disponibilizarRecurso(String recurso) {
		// TODO Auto-generated method stub
		if(! verificarRecurso(recurso)) {
			System.out.println("\nRecurso indisponivel.");
			return;
		}
		for(int i = 0; i < sistema.getRecursosFisicos().size(); i++) {
			if(recurso.equals("onibus")) {
				if(!(sistema.getRecursosFisicos().get(i) instanceof Onibus)) {
					continue;
				}
				if(((Onibus) sistema.getRecursosFisicos().get(i)).isEstadoAtual()) {
					((Onibus) sistema.getRecursosFisicos().get(i)).setEstadoAtual();
				}
			} else if(recurso.equals("estadio")) {
				if(!(sistema.getRecursosFisicos().get(i) instanceof Estadio)) {
					continue;
				}
				if(((Estadio) sistema.getRecursosFisicos().get(i)).isEstadoAtual()) {
					((Estadio) sistema.getRecursosFisicos().get(i)).setEstadoAtual();
				}
			} else if(recurso.equals("centro")) {
				if(!(sistema.getRecursosFisicos().get(i) instanceof CentroDeTreinamento)) {
					continue;
				}
				if(((CentroDeTreinamento) sistema.getRecursosFisicos().get(i)).isEstadoAtual()) {
					((CentroDeTreinamento) sistema.getRecursosFisicos().get(i)).setEstadoAtual();
				}
			}
			
		}
		
	}
	
	
	
	
}
