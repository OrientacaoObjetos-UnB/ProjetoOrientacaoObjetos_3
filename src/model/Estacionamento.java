package model;

import java.util.LinkedList;
import java.util.List;

public class Estacionamento {
	
	private List<Hora> horarioFuncionamento;
	private List<Acesso> acessos;
	
	private int capacidade;
	private double retornoContratante;
	private boolean situacaoCapacidade;
	
	
	private Estacionamento() {
		acessos = new LinkedList<Acesso>();
		horarioFuncionamento = new LinkedList<Hora>();
	}
	
	public Estacionamento(int cap, double retorno) {
		acessos = new LinkedList<Acesso>();
		horarioFuncionamento = new LinkedList<Hora>();
		this.capacidade = cap;
		this.retornoContratante = retorno;
	}
	
	public Estacionamento(int cap, double retorno, boolean permissaoEntrada ) {
		acessos = new LinkedList<Acesso>();
		horarioFuncionamento = new LinkedList<Hora>();
		this.capacidade = cap;
		this.retornoContratante = retorno;
		this.situacaoCapacidade = permissaoEntrada;
	}
	
	public boolean setSituacaoCapacidade(boolean s) {
		this.situacaoCapacidade = s;
		return situacaoCapacidade;
	}
	
	public double calcularTotalContratante() {
		List<Acesso> lista = getAcessos();
		
		double resultadoFinal = 0;
		double valorReal;
		
		for(Acesso v: lista) {
			resultadoFinal += v.getValorAcesso();
		}
		
		valorReal = (resultadoFinal*retornoContratante)/100;
		
		return valorReal;
	}
	
	public void setHorarioFuncionamento(int hI, int mI, int hF, int mF) {
		Hora inicio = new Hora(hI, mI);
		Hora fim = new Hora(hF, mF);
		
		if(horarioFuncionamento.size() == 0 ) {
			horarioFuncionamento.add(inicio);
			horarioFuncionamento.add(fim);
		} else {
			horarioFuncionamento.clear();
			horarioFuncionamento.add(inicio);
			horarioFuncionamento.add(fim);
		}
	}
	
	public List<Hora> getHorarioFuncionamento() {
		return horarioFuncionamento;
	}
	
	public void setAcessos(String placa) {
		Acesso veiculo = new Acesso(placa);
		
		acessos.add(veiculo);
	}
	
	public void removeAcessos(String placa) {
		for(Acesso v: acessos) {
			if(v.getPlacaCarro() == placa) {
				acessos.remove(v);
			}
		}
	}
	
	public List<Acesso> getAcessos() {
		return acessos;
	}
	
}
