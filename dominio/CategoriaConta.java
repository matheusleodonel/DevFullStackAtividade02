package dominio;

public enum CategoriaConta {
	SIMPLES("Simples"),
	EXECUTIVA("Executiva"),
	PREMIUM("Premium"),
	PERSONALITE("Personalite");
	
	private final String categoria;
	
	CategoriaConta(String categoria){
		this.categoria = categoria;
	}
	
	public String getCategoria(){
		return categoria;
	}
}
