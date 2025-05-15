package visitor1.pedido;

public class Produto {

	private String descricao;
	private double peso;
	private double dimensoes;
	
	public Produto(String descricao, double peso, double dimensoes) {
		super();
		this.descricao = descricao;
		this.peso = peso;
		this.dimensoes = dimensoes;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getPeso() {
		return peso;
	}

	public double getDimensoes() {
		return dimensoes;
	}
	
	
	
}
