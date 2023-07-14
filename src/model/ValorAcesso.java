package model;

import java.util.LinkedList;
import java.util.List;

public class ValorAcesso {
	
	private List<AcessoEvento> valorEvento;
	private AcessoHoraCheia valorHoraCheia;
	
	private double fracao;
	private double diurno;
	private double mensalista; 
	
	public void ValoresAcessos(double ValorMensalista, double ValorFracao, double ValorDiurno) {
		valorEvento = new LinkedList<AcessoEvento>();
		
		this.mensalista = ValorMensalista;
		this.fracao = ValorFracao; 
		this.diurno = ValorDiurno;	
		 
	}
	public void setNovoEvento(AcessoEvento e) {
		valorEvento.add(e); 
	}
	public List<AcessoEvento> getNovoEvento() {
		return valorEvento;
	}
	
	public double getFracao() {
		return fracao;
	} 
	public void setFracao(double ValorFracao) {
		this.fracao = ValorFracao;
	} 
	public double getMensalista() {
		return mensalista;
	} 
	public void setMensalsita(double ValorMensalista) {
		this.mensalista = ValorMensalista;
	} 
	public double getDiurno() {
		return diurno;
	} 
	public void setDiurno(double ValorDiurno) {
		this.diurno = ValorDiurno;
		
	}
	public AcessoHoraCheia getValorHoraCheia() {
		return valorHoraCheia;
	}
	public void setValorHoraCheia(AcessoHoraCheia valorHoraCheia) {
		this.valorHoraCheia = valorHoraCheia;
	} 
}  		
		
	
	
