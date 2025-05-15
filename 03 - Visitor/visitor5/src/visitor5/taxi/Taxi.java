package visitor5.taxi;

import visitor.VisitorTaxi;

public class Taxi {

	private int pontoTaxi;
	private int numeroRegistro;
	private boolean ocupado;
	
	public Taxi(int numeroRegistro, int pontoTaxi) {

		this.numeroRegistro = numeroRegistro;
		this.pontoTaxi = pontoTaxi;
		
	}
	
	public int getPontoTaxi() {
		return pontoTaxi;
	}
	
	public boolean isOcupado() {
		return ocupado;
	}

	public void atender(Cliente cliente) {
		System.out.println("Taxi " + numeroRegistro + " do ponto " + pontoTaxi + " atendendo " + cliente.getNumeroTelefone()+ ".");
		this.ocupado = true;
	}

	public void accept(VisitorTaxi visitor) {
		visitor.visitTaxi(this);
	}
	
}
