package model;

public class Fita {


    private String titulo;
    private TipoFilme tipo;
    
    
    public Fita(String titulo, TipoFilme tipo) {
    	this.titulo = titulo;
    	this.tipo = tipo;
    }


	public String getTitulo() {
		return titulo;
	}
	
	public double getValor(int diasAlugada) {
		return tipo.getValor(diasAlugada);
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public TipoFilme getTipo() {
		return tipo;
	}
 
}
