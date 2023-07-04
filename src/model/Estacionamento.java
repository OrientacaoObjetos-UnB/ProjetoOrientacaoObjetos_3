package model;

import java.util.LinkedList;
import java.util.List;

public class Estacionamento {
	
	private List<Hora> horarioFuncionamento;
	private List<Acesso> acessos;
	
	private String nome;
	private int capacidade;
	private double retornoContratante;
	private boolean situacaoCapacidade;
	
	
	public Estacionamento(String n, int cap, double retorno, int hI, int mI, int hF, int mF) {
		acessos = new LinkedList<Acesso>();
		horarioFuncionamento = new LinkedList<Hora>();
		this.capacidade = cap;
		this.retornoContratante = retorno;
		this.nome = n;
		this.situacaoCapacidade = true;
		setHorarioFuncionamento(hI, mI, hF, mF);
	}

	public void setRetornoContratante(double rC) {
		this.retornoContratante = rC;
	}
	
	public double getRetornoContratante() {
		return retornoContratante;
	}
	
	public void setSituacaoCapacidade(boolean s) {
		this.situacaoCapacidade = s;
	}
	
	public boolean getSituacaoCapacidade() {
		return situacaoCapacidade;
	}
	
	public void setNome(String n) {
		this.nome = n;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setCapacidade(int c) {
		this.capacidade = c;
	}
	
	public int getCapacidade() {
		return capacidade;
	}
	
	public double calcularTotalContratante() {
		List<Acesso> lista = getAcessos();
		
		double resultadoFinal = 0;
		double valorReal;
		
		if (lista.size() == 0) {
			return 0;
		}
		else {
			for(Acesso v: lista) {
				resultadoFinal += v.getValorAcesso();
			}
			
			valorReal = (resultadoFinal*retornoContratante)/100;
			
			return valorReal;	
		}
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
