package funcionarios;

import java.util.Scanner;

public class Medico extends Funcionario {
	
	private String crm;
	private Scanner entrada;
	
	public Medico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm() {
		entrada = new Scanner(System.in);
		System.out.print("\nCRM: ");
		this.crm = entrada.nextLine();
	}

	@Override
	public void editarDados() {
		// TODO Auto-generated method stub
		super.editarDadosDeFuncionario();
		setCrm();
	}


}
