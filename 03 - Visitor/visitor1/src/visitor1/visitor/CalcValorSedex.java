package visitor1.visitor;

import visitor1.pedido.ItemPedido;

public class CalcValorSedex implements Visitor {

	private double valor;
	
	@Override
	public void visit(ItemPedido itemPedido) {
		 
		valor += itemPedido.getProduto().getPeso() * 0.5 * itemPedido.getQtdade();
	}
	
	public double getValor() {
		return valor;
	}

}
