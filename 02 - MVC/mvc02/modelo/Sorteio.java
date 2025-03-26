package modelo;

public class Sorteio {

	private int[] numerosSorteados;
	
	private int numSorteio;
	
	public Sorteio(int numSorteio, int[] numerosSorteados) {
		this.numSorteio = numSorteio;
		this.numerosSorteados = numerosSorteados;
	}

	public int[] getNumeros() {
		return numerosSorteados;
	}

	public void setNumeros(int[] numeros) {
		this.numerosSorteados = numeros;
	}

	public int getNumSorteio() {
		return numSorteio;
	}

	public void setNumSorteio(int numSorteio) {
		this.numSorteio = numSorteio;
	}
}
