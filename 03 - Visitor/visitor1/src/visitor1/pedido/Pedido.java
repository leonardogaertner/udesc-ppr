package visitor1.pedido;
import java.util.ArrayList;
import java.util.List;

import visitor1.visitor.Visitor;

public class Pedido {

	private List<ItemPedido> itensPedido = new ArrayList<>();
	
	public void addItemPedido(ItemPedido itemPedido) {
		itensPedido.add(itemPedido);
	}
	
	public void accept(Visitor visitor) throws Exception {
		
		for (ItemPedido item:itensPedido) 
			item.accept(visitor);
		
	}
}
