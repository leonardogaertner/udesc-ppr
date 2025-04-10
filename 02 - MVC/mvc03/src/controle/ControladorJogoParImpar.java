package controle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JList;

import modelo.Mao;

public class ControladorJogoParImpar {
	private int minhaVit, pcVit;
	private List<Observador> obss = new ArrayList<>();
	private List<Mao> maos = new ArrayList<>();
	private int idxMao;
	private Random sorteio;
	

	public ControladorJogoParImpar() {
		sorteio = new Random();
	}

	public void addObservador(Observador obs) {
		obss.add(obs);
	}

	public void novo() {
		maos.clear();
		minhaVit = 0;
		pcVit = 0;
		for (Observador obs : obss) {
			obs.iniciouJogo();
		}
	}

	public void posterior() {
		idxMao = (idxMao + 1) % 6;
		for (Observador obs : obss) {
			obs.posteriorJogo();
		}
	}

	public void jogar(boolean ehPar) {
		int maoPC = sorteio.nextInt(6);

		Mao mao = new Mao(ehPar, maoPC, idxMao);
		maos.add(mao);

		for (Observador obs : obss) {
			obs.maoPC(maoPC);
		}

		boolean vencePar = ((maoPC + idxMao) % 2) == 0;
		if (mao.isPar() == vencePar) {
			minhaVit++;

			if (minhaVit == 3) {
				for (Observador obs : obss) {
					obs.vitoriaJogo();
				}
			}
		} else {
			pcVit++;
			if (pcVit == 3) {
				for (Observador obs : obss) {
					obs.derrotaJogo();
				}
			}
		}

	}
	
	public Mao getMao(int index) {
		return maos.get(index);
	}
	
	public int MaoSize() {
		return maos.size();
	}
}
