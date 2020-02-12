package socios_torcedores;

import java.util.Scanner;
import pessoa.*;

public abstract class SocioTorcedor extends Pessoa{

	private String endereco;
	private double valorContribuicao;
	private boolean estadoDePagamento;
	
	private Scanner entrada;
	
	public SocioTorcedor() {
		super();
	}

	public String getEndereco() {
		return endereco;
	}

	public double getValorContribuicao() {
		return valorContribuicao;
	}

	public boolean isEstadoDePagamento() {
		return estadoDePagamento;
	}
	
	void editarDadosDeSocioTorcedor() {
		entrada = new Scanner(System.in);
		super.editarDadosDePessoa();
		editarEndereco();
		editarValorContribuicao();
		editarEstadoDePagamento();
	}
	
	private void editarEndereco() {
		System.out.print("\nEndereco: ");
		this.endereco = entrada.nextLine();
	}
	
	public void editarValorContribuicao() {
		
		while(true) {
			System.out.print("\nContribuicao: ");
			try {
				this.valorContribuicao = Double.parseDouble(entrada.next());
			} catch(NumberFormatException e) {
				System.out.println("\nEntrada invalida!");
				continue;
			} finally {
				if(this.valorContribuicao < 0) {
					System.out.println("\nA contribuicao nao pode ser negativa!");
					continue;
				}
			}
			break;
		}
		
	}
	
	public void editarEstadoDePagamento() {
		
		int opcao;
		
		while(true) {
			System.out.println("\nO socio esta adimplente?");
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
				this.estadoDePagamento = true;
			} else if(opcao == 2) {
				this.estadoDePagamento = false;
			} else {
				System.out.println("\nOpcao invalida!");
				continue;
			} break;
		}
		
	}
	
	
}
