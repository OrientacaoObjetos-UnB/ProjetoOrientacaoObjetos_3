package model;

public class AcessoEvento {
	
	private String nomeEvento;
	private double valor; 

	public AcessoEvento(String n, double v) {
		this.nomeEvento = n; 
		this.valor = v; 
		
	}
	public String getnomeEvento() {
		return nomeEvento;
	}
	public double getvalor() {
		return valor; 
	}
	public void setnomeEvento(String n) {
		this.nomeEvento = n; 
		
	}
	public void setvalor(double v) {
		this.valor = v;
	}	
}
