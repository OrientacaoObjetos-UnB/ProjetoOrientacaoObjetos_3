package model;

import java.util.LinkedList;
import java.util.List;


public class Acesso {

	private String placaCarro;
	private double valorAcesso;
	private String tipoAcesso;
	private double valorContrato;
	private List<Hora> entradaSaida;
	
	private Acesso() {
		
	}
	
	public Acesso(String placa, String tipo) {
		entradaSaida = new LinkedList<Hora>();
		this.placaCarro = placa;
		this.tipoAcesso = tipo;
	}
	
	public Acesso(String placa, String tipo, int horaEntrada, int minutoEntrada, int minutoSaida) {
		entradaSaida = new LinkedList<Hora>();
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
