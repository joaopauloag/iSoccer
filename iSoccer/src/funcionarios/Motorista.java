package funcionarios;

import java.util.Scanner;

public class Motorista extends Funcionario {
	
	private String numeroDeHabilitacao;
	private Scanner entrada;
	
	public Motorista() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNumeroDeHabilitacao() {
		return numeroDeHabilitacao;
	}

	public void setNumeroDeHabilitacao() {
		
		entrada = new Scanner(System.in);
		
		while(true) {
			System.out.print("\nNumero de habilitacao: ");
			try {
				this.numeroDeHabilitacao = String.valueOf(entrada.nextLong());
			} catch(NumberFormatException e) {
				System.out.println("\nEntrada invalida!");
				continue;
			}
			break;
		}
	}

	@Override
	public void editarDados() {
		// TODO Auto-generated method stub
		super.editarDadosDeFuncionario();
		setNumeroDeHabilitacao();
	}

	
}