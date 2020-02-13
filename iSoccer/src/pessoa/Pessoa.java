package pessoa;

import java.util.Scanner;

public abstract class Pessoa {

	private String nome;
	private String eMail;
	private String cpf;
	private String telefone;
	
	private Scanner entrada;
	
	// template method
	final void acoesDePessoa() {
		editarDados();
		editarNome();
		editarEmail();
		editarCpf();
		editarTelefone();
	}
	
	public Pessoa() {
	}

	public String getNome() {
		return nome;
	}

	public String geteMail() {
		return eMail;
	}

	public String getCpf() {
		return cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public abstract void editarDados();
	
	protected void editarDadosDePessoa() {
		
		entrada = new Scanner(System.in);
		
		editarNome();
		editarEmail();
		editarCpf();
		editarTelefone();
	}

	private void editarNome() {
		System.out.print("\nNome completo: ");
		this.nome = entrada.nextLine();
	}
	
	private void editarEmail() {
		System.out.print("\nEmail: ");
		this.eMail = entrada.nextLine();
	}
	
	private void editarCpf() {
		
		while(true) {
			System.out.print("\nCPF (somente os 11 digitos): ");
			try {
				this.cpf = String.valueOf(entrada.nextLong());
			} catch(NumberFormatException e) {
				System.out.println("\nEntrada invalida!");
				continue;
			} finally {
				if(this.cpf.length() != 11) {
					System.out.println("\nVoce nao digitou os 11 digitos do cpf!");
					continue;
				}
			}
			break;
		}
	}
	
	private void editarTelefone() {
		
		while(true) {
			System.out.print("\nTelefone: ");
			try {
				this.telefone = String.valueOf(entrada.nextLong());
			} catch(NumberFormatException e) {
				System.out.println("\nEntrada invalida!");
				continue;
			} finally {
				if(this.telefone.length() < 8) {
					System.out.println("\nNumero invalido!");
					continue;
				}
			}
			break;
		}
	}


}
