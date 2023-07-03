package model;

import java.util.List;

public class AcessoHoraCheia extends AcessoEspecial{

	public AcessoHoraCheia(double taxa) {
		super(taxa);
	}

	public double calcularTotal(double valor) {
		double valorFinal = 0;
		List<Hora> tempoPermanencia = getRelacaoTempo();
		
		calcularDiferençaHoras(tempoPermanencia);
		
		
		
		return valorFinal;
	}
	
	public int[] calcularDiferençaHoras(List<Hora> tempoPermanencia) {
		
		int[] referenciaHoras = new int[2];
		int[] referenciaMinutos = new int[2];
		int[] diferenca = new int[2];
		boolean casoEspecial = false;
		
		referenciaHoras[0] = tempoPermanencia.get(0).getHora();
		referenciaHoras[1] = tempoPermanencia.get(1).getHora();
		
		referenciaMinutos[0] = tempoPermanencia.get(0).getMinuto();
		referenciaMinutos[1] = tempoPermanencia.get(1).getMinuto();
		
		// CÁLCULO DA DIFERENÇA DE HORAS:
		if (referenciaHoras[0] > referenciaHoras[1]) {
			diferenca[0] = (24 - referenciaHoras[0]) + (referenciaHoras[1]);
			if (referenciaMinutos[0] != 0) {
				casoEspecial = true;
			} 
		}
		else if (referenciaHoras[0] == referenciaHoras[1]) {
			diferenca[0] = 0;
		}
		else{
			diferenca[0] = referenciaHoras[1] - referenciaHoras[0];
		}
		
		return diferenca;
	}
	
	
	
}
