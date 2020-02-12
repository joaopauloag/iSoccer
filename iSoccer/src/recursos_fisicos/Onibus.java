package recursos_fisicos;

import java.util.Scanner;

public class Onibus {
	
	private boolean estadoAtual;
	private Scanner entrada;
	
	public Onibus() {
	}

	public void setDados() {
		setEstadoAtual();
	}

	public boolean isEstadoAtual() {
		return this.estadoAtual;
	}
	
	public void setEstadoAtual() {
		int opcao;
		entrada = new Scanner(System.in);
		
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
