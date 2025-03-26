package model;

public class Produto {

	private String nome;
	private double pcoUnit;
	
	public Produto(String nome, double pcoUnit) {
      this.nome = nome;
      this.pcoUnit = pcoUnit;
	}
	
	public String getNome() {
		return nome;
	}
	
	public double getPcoUnit() {
		return pcoUnit;
	}
	
}
