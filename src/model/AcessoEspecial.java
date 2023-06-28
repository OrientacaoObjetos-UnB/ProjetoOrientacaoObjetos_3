package model;

public abstract class AcessoEspecial {

	private double TaxaPorcentagem;
	private double valorTotal;
	
	private AcessoEspecial() {
		
	};
	
	public abstract void calcularTotal();
	
}
