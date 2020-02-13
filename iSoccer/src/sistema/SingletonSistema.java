package sistema;

import java.util.ArrayList;
import pessoa.*;

class SingletonSistema {

	private ArrayList<Pessoa> funcionarios;
	private ArrayList<Pessoa> sociosTorcedores;
	private ArrayList<Object> recursosFisicos;
	private static SingletonSistema unicaInstancia;

	private SingletonSistema() {
		this.funcionarios = new ArrayList<Pessoa>();
		this.sociosTorcedores = new ArrayList<Pessoa>();
		this.recursosFisicos = new ArrayList<Object>();
	}
	
	public static synchronized SingletonSistema getInstance() {
		if(unicaInstancia == null) {
			unicaInstancia = new SingletonSistema();
		}
		return unicaInstancia;
	}

	ArrayList<Pessoa> getFuncionarios() {
		return funcionarios;
	}

	void setFuncionarios(Pessoa funcionario) {
		this.funcionarios.add(funcionario);
	}
	
	ArrayList<Pessoa> getSociosTorcedores() {
		return sociosTorcedores;
	}
	
	void setSociosTorcedores(Pessoa socioTorcedor) {
		this.sociosTorcedores.add(socioTorcedor);
	}

	ArrayList<Object> getRecursosFisicos() {
		return recursosFisicos;
	}

	void setRecursosFisicos(Object recursoFisico) {
		this.recursosFisicos.add(recursoFisico);
	}
	
	
}
