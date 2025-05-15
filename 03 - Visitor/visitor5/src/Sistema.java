import visitor.BuscarTaxi;
import visitor5.taxi.Cliente;
import visitor5.taxi.Taxi;
import visitor5.taxi.Tuber;

public class Sistema {

	public static void main(String[] args) throws Exception {
		Taxi t1 = new Taxi(100, 1);
		Taxi t2 = new Taxi(101, 2);
		Taxi t3 = new Taxi(102, 2);
		Taxi t4 = new Taxi(103, 1);
		Taxi t5 = new Taxi(104, 3);
		
		Cliente c1 = new Cliente(1, "91234");
		Cliente c2 = new Cliente(2, "95678");
		Cliente c3 = new Cliente(4, "90000");
		Cliente c4 = new Cliente(1, "92468");
		Cliente c5 = new Cliente(1, "90001");
		
		Tuber t = new Tuber();
		
		t.add(t1);
		t.add(t2);
		t.add(t3);
		t.add(t4);
		t.add(t5);
		
		BuscarTaxi v1 = new BuscarTaxi(c1);
		t.accept(v1);
		if(v1.isAtendendo() == false) {
			System.out.println("Atendimento ligou para o cliente " + c1.getNumeroTelefone() + " avisando que nao tem taxi.");		
			}
		BuscarTaxi v2 = new BuscarTaxi(c2);
		t.accept(v2);
		if(v2.isAtendendo() == false) {
			System.out.println("Atendimento ligou para o cliente " + c2.getNumeroTelefone() + " avisando que nao tem taxi.");		
		}
		BuscarTaxi v3 = new BuscarTaxi(c3);
		t.accept(v3);
		if(v3.isAtendendo() == false) {
			System.out.println("Atendimento ligou para o cliente " + c3.getNumeroTelefone() + " avisando que nao tem taxi.");		
		}
		BuscarTaxi v4 = new BuscarTaxi(c4);
		t.accept(v4);
		if(v4.isAtendendo() == false) {
			System.out.println("Atendimento ligou para o cliente " + c4.getNumeroTelefone() + " avisando que nao tem taxi.");		
		}
		BuscarTaxi v5 = new BuscarTaxi(c5);
		t.accept(v5);
		if(v5.isAtendendo() == false) {
			System.out.println("Atendimento ligou para o cliente " + c5.getNumeroTelefone() + " avisando que nao tem taxi.");		
		}
		
		
		

		
		
	}

}
