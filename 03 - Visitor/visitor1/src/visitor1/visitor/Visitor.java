package visitor1.visitor;

import visitor1.pedido.ItemPedido;

public interface Visitor {

	void visit(ItemPedido itemPedido) throws Exception;
	
}
