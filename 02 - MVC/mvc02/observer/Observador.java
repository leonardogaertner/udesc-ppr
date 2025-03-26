package observer;

public interface Observador {

	void inicioSorteio(int numSorteio);

	void numSorteado(int idxNumero, int num);

	void finalizado();

}
