package main;

import java.util.Scanner;
import sistema.Funcionalidades;

class Login {
	
	private static Scanner entrada;
	private static Administrador administrador;
	private static Funcionalidades funcionalidades;
	private static boolean validou;
	
	static void validarAdministrador() {
		
		entrada = new Scanner(System.in);
		administrador = new Administrador();
		validou = true;
		
		while(true) {
			System.out.print("\nLogin: ");
			if(! entrada.nextLine().equals(administrador.getLogin())) {
				validou = false;
			}
			System.out.print("\nSenha: ");
			if(! entrada.nextLine().equals(administrador.getSenha())) {
				validou = false;
			}
			if(validou) {
				break;
			} else {
				System.out.println("\nLogin ou senha incorretos!\n");
				validou = true;
			}
		}
		funcionalidades = new Funcionalidades();
		funcionalidades.iniciarSistema();
	}
}
