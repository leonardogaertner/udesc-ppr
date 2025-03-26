package controle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import modelo.Sorteio;
import observer.Observador;

public class LoteriasUCImpl implements LoteriasUC {

	private int numSorteio = 0;
	private int idxNumero = 0;
	private Random sorteio = new Random();
	private int[] numeros;
	
	private List<Sorteio> sorteios = new ArrayList<>();
	
	private List<Observador> observadores = new ArrayList<>();
	
	@Override
	public void iniciarSorteio() {
		numSorteio++;
		idxNumero = 0;
		numeros = new int[6];
		
		notificarInicio(numSorteio);
	}
	
	@Override
	public void sortear() {
		boolean existe = false;
		int num = 0;
		do {
			num = sorteio.nextInt(60) + 1;
			existe = false;
			for (int i = 0; i < idxNumero; i++) {
				if (numeros[i] == num) {
					existe = true;
					break;
				}
			}
			
		} while(existe);
		numeros[idxNumero] = num;
		notificarNumSorteado(idxNumero, num);
		
		idxNumero++;
	}
	
	@Override
	public void finalizar() {
		sorteios.add(new Sorteio(numSorteio, numeros));
		notificarFinalizado();
	}

	@Override
	public void addObservador(Observador obs) {
		observadores.add(obs);
	}
	
	@Override
	public void removerObservador(Observador obs) {
		observadores.remove(obs);
	}

	private void notificarInicio(int numSorteio) {
		for (Observador obs:observadores)
			obs.inicioSorteio(numSorteio);
		
	}

	private void notificarNumSorteado(int idxNumero, int num) {
		for (Observador obs:observadores)
			obs.numSorteado(idxNumero, num);
	}

	private void notificarFinalizado() {
		for (Observador obs:observadores)
			obs.finalizado();
		
	}

}



 