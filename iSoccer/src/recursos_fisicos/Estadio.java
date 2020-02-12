package recursos_fisicos;

import java.util.Scanner;

public class Estadio {

	private int capacidade;
	private int banheiros;
	private int lanchonetes;
	private boolean estadoAtual;
	
	private Scanner entrada;
	
	public Estadio() {
	}


	public void setDados() {
		entrada = new Scanner(System.in);
		setCapacidade();
	}
	
	public int getCapacidade() {
		return capacidade;
	}

	private void setCapacidade() {
		System.out.print("\nCapacidade: ");
		this.capacidade = entrada.nextInt();
		setBanheiros();
	}

	public int getBanheiros() {
		return banheiros;
	}
	
	private void setBanheiros() {
		System.out.print("\nQuantidade de banheiros: ");
		this.banheiros = entrada.nextInt();
		setLanchonetes();
	}

	public int getLanchonetes() {
		return lanchonetes;
	}
	
	private void setLanchonetes() {
		System.out.print("\nQuantidade de lanchonetes: ");
		this.lanchonetes = entrada.nextInt();
		setEstadoAtual();
	}

	public boolean isEstadoAtual() {
		return this.estadoAtual;
	}
	
	public void setEstadoAtual() {
		int opcao;
		
		while(true) {
			System.out.println("\n[1] Nao disponilizar agora");
			System.out.println("[2] Disponibilizar agora");
			while(true) {
				try {
					opcao = Integer.parseInt(entrada.next());
				} catch(NumberFormatException e) {
					System.out.println("\nEntrada invalida!");
					continue;
				} break;
			}
			if(opcao == 1) {
				this.estadoAtual = true;
			} else if(opcao == 2) {
				this.estadoAtual = false;
			} else {
				System.out.println("\nOpcao invalida!");
				continue;
			} break;
		}
	}
	
}
