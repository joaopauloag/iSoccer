package recursos_fisicos;

import java.util.Scanner;

public class CentroDeTreinamento {

	private int dormitorios;
	private boolean estadoAtual;
	private Scanner entrada;

	
	public CentroDeTreinamento() {
	}

	public void setDados() {
		entrada = new Scanner(System.in);
		setDormitorios();
	}
	
 	public int getDormitorios() {
		return dormitorios;
	}
	
	private void setDormitorios() {
		System.out.print("\nQuantidade de dormitorios: ");
		this.dormitorios = entrada.nextInt();
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
