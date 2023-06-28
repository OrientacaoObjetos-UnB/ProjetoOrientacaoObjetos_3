package model;

public class Acesso {

	private String placaCarro;
	private double valorAcesso;
	private String tipoAcesso;
	private double valorContrato;
	private Hora entradaSaida[];
	
	private Acesso() {
		
	}
	
	public Acesso(String placa, String tipo) {
		this.placaCarro = placa;
		this.tipoAcesso = tipo;
	}
	
	public void setPlacaCarro(String placa) {
		this.placaCarro = placa;
	}
	
	public String getPlacaCarro() {
		return placaCarro;
	}
	
	public void serValorAcesso(double valor) {
		this.valorAcesso = valor;
	}
	
	public double getValorAcesso() {
		return valorAcesso;
	}
	
	public void setTipoAcesso(String tipo) {
		this.tipoAcesso = tipo;
	}
	
}
