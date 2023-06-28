package model;

import java.util.LinkedList;
import java.util.List;

public class Estacionamento {
	
	private Hora[] horarioFuncionamento;
	private List<Acesso> acessos;
	
	private int capacidade;
	private double retornoContratante;
	private boolean situacaoCapacidade;
	
	
	public Estacionamento() {
		//
	}
	
	public Estacionamento(String nome, int cap, double retorno, boolean permissaoEntrada ) {
		
	}
	
	public boolean setSituacaoCapacidade(boolean s ) {
		this.situacaoCapacidade = s;
		return situacaoCapacidade;
	}
	
	public double calcularTotalContratante() {
		pesquisarAcesso();
		return retornoContratante;
	}
	
	public Acesso pesquisarAcesso(String placaCarro) {
		for (Acesso a : acessos) {
			if (a.getPlacaCarro() == placaCarro ) {
				return a;
			}
		}
		return null;
	}

}
