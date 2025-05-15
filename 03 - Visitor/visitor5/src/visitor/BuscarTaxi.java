package visitor;

import visitor5.taxi.Cliente;
import visitor5.taxi.Taxi;

public class BuscarTaxi implements VisitorTaxi{
	private Cliente cliente;
	boolean atendendo = false;
	
	public BuscarTaxi(Cliente cliente) {
		super();
		this.cliente = cliente;
	}

	
	
	@Override
	public void visitTaxi(Taxi taxi) {
		if(atendendo == false && taxi.isOcupado() == false && taxi.getPontoTaxi() == cliente.getPontoProximo()) {
			taxi.atender(cliente);
			atendendo = true;
		}
	}

	public boolean isAtendendo() {
		return atendendo;
	}



	public Cliente getCliente() {
		return cliente;
	}
	
	
	

}
