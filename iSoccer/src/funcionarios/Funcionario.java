package funcionarios;

import java.util.Scanner;
import pessoa.*;

public abstract class Funcionario extends Pessoa{
	
	private double salario;
	
	private Scanner entrada;

	
	public Funcionario() {
		super();
	}

	public double getSalario() {
		return salario;
	}
	
	void editarDadosDeFuncionario() {
		super.editarDadosDePessoa();
		editarSalario();
	}
	
	private void editarSalario() {
		
		entrada = new Scanner(System.in);
		
		while(true) {
			System.out.print("\nSalario: ");
			try {
				this.salario = Double.parseDouble(entrada.next());
			} catch(NumberFormatException e) {
				System.out.println("\nEntrada invalida!");
				continue;
			} finally {
				if(this.salario < 0) {
					System.out.println("\nO salario nao pode ser negativo!");
					continue;
				}
			}
			break;
		}
	}
	
}
