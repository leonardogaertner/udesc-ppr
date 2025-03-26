package model;

public class Pedido {

	private Produto produto;
	private int qtdade;
	
	public Pedido(Produto produto) {
		this.produto = produto;
	    this.qtdade = 1;
	}

	public Produto getProduto() {
		return produto;
	}
	
	public void addQtdade() {
		this.qtdade++;
	}
	
	public int getQtdade() {
		return qtdade;
	}
	
	public double getPcoTotal() {
		return produto.getPcoUnit() * qtdade;
	}
}
