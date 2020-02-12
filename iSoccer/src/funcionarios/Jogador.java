package funcionarios;

import java.util.Scanner;

public class Jogador extends Funcionario {

	private String tipoDeJogador;
	private boolean aptoAJogar;
	private Scanner entrada;

	public Jogador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTipoDeJogador() {
		return tipoDeJogador;
	}

	public void setTipoDeJogador() {
		int opcao;
		
		entrada = new Scanner(System.in);
		
		while(true) {
			System.out.println("\nEscolha o tipo de jogador:");
			System.out.println("[1] volante\t[5] atacante");
			System.out.println("[2] zagueiro\t[6] lateral esquerdo");
			System.out.println("[3] meia\t[7] lateral direito");
			System.out.println("[4] goleiro");
			while(true) {
				try {
					opcao = Integer.parseInt(entrada.next());
				} catch(NumberFormatException e) {
					System.out.println("\nEntrada invalida!");
					continue;
				} break;
			}
			switch (opcao) {
				case 1: this.tipoDeJogador = "volante"; break;
				case 2: this.tipoDeJogador = "zagueiro";  break;
				case 3: this.tipoDeJogador = "meia"; break;
				case 4: this.tipoDeJogador = "goleiro"; break;
				case 5: this.tipoDeJogador = "atacante"; break;
				case 6: this.tipoDeJogador = "lateral esquerdo"; break;
				case 7: this.tipoDeJogador = "lateral direito"; break;
				default: System.out.println("\nEscolha uma opcao valida!"); continue;
			}
			break;
		}
	}

	public boolean isAptoAJogar() {
		return aptoAJogar;
	}

	public void setAptoAJogar() {
		int opcao;
		
		entrada = new Scanner(System.in);
		
		while(true) {
			System.out.println("\nO jogador esta apto a jogar?");
			System.out.println("[1] sim\t[2] nao");
			while(true) {
				try {
					opcao = Integer.parseInt(entrada.next());
				} catch(NumberFormatException e) {
					System.out.println("\nEntrada invalida!");
					continue;
				} break;
			}
			if(opcao == 1) {
				this.aptoAJogar = true;
			} else if(opcao == 2) {
				this.aptoAJogar = false;
			} else {
				System.out.println("\nOpcao invalida!");
				continue;
			} break;
		}
	}

	@Override
	public void editarDados() {
		// TODO Auto-generated method stub
		super.editarDadosDeFuncionario();
		setTipoDeJogador();
		setAptoAJogar();
	}
	
	
}
