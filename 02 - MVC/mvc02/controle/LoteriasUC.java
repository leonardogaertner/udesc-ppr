package controle;

import observer.Observador;

public interface LoteriasUC {

	void iniciarSorteio();

	void sortear();

	void finalizar();

	void addObservador(Observador obs);

	void removerObservador(Observador obs);

}
