package pessoa;

import java.util.Scanner;
import funcionarios.*;
import socios_torcedores.*;

public class FactoryPessoa {

	private static Scanner entrada;
	
	public static Pessoa getFuncionario() {
		
		int opcao;
		Pessoa novoFuncionario = null;
		entrada = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n[1] Presidente");
			System.out.println("[2] Medico");
			System.out.println("[3] Tecnico");
			System.out.println("[4] Preparador fisico");
			System.out.println("[5] Motorista");
			System.out.println("[6] Cozinheiro");
			System.out.println("[7] Advogado");
			System.out.println("[8] Jogador");
			while(true) {
				try {
					opcao = Integer.parseInt(entrada.next());
				} catch(NumberFormatException e) {
					System.out.println("\nEntrada invalida!");
					continue;
				} break;
			}
			switch (opcao) {
				case 1: novoFuncionario = new Presidente(); break;
				case 2: novoFuncionario = new Medico(); break;
				case 3: novoFuncionario = new Tecnico(); break;
				case 4: novoFuncionario = new PreparadorFisico(); break;
				case 5: novoFuncionario = new Motorista(); break;
				case 6: novoFuncionario = new Cozinheiro(); break;
				case 7: novoFuncionario = new Advogado(); break;
				case 8: novoFuncionario = new Jogador(); break;
				default: System.out.println("\nEscolha uma opcao valida!"); continue;
			}
			novoFuncionario.editarDados();
			return novoFuncionario;
		}
	}
	
	public static Pessoa getSocioTorcedor() {
		
		int opcao;
		Pessoa novoSocioTorcedor = null;
		entrada = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n[1] Junior");
			System.out.println("[2] Senior");
			System.out.println("[3] Elite");
			while(true) {
				try {
					opcao = Integer.parseInt(entrada.next());
				} catch(NumberFormatException e) {
					System.out.println("\nEntrada invalida!");
					continue;
				} break;
			}
			switch (opcao) {
				case 1: novoSocioTorcedor = new Junior(); break;
				case 2: novoSocioTorcedor = new Senior(); break;
				case 3: novoSocioTorcedor = new Elite(); break;
				default: System.out.println("\nEscolha uma opcao valida!"); continue;
			}
			novoSocioTorcedor.editarDados();
			return novoSocioTorcedor;
		}	
	}
	
		
}
