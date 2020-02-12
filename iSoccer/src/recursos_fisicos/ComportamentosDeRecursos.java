package recursos_fisicos;

public interface ComportamentosDeRecursos {

	void adicionarRecurso(String recurso);
	
	boolean verificarRecurso(String recurso);
	
	void disponibilizarRecurso(String recurso);
	
}
