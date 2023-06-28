package model;
public class Estacionamento {
	
	private int capacidade;
	private double retornoContratante;
	private boolean situacaoCapacidade;
	
	public Estacionamento() {
		//
	}
	
	public Estacionamento(String nome, int cap, double retorno, boolean permissaoEntrada ) {
		//
	}
	
	public boolean setSituacaoCapacidade(boolean s ) {
		this.situacaoCapacidade = s;
		return situacaoCapacidade;
	}
	
	public void calcularTotalContratante() {
		//
	}
	
	public void pesquisarAcesso() {
		//
	}

}
