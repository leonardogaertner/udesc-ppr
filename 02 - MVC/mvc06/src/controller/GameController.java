package controller;

import java.awt.Container;
import java.util.ArrayList;
import java.util.List;

import model.Jogada;
import view.Game;

public class GameController {
	
	private int score_human;
	private int score_win = 0;
	private int score_tie = 0;

	private List<Jogada> jogadas = new ArrayList<>();
	
	private List<Observer> obss = new ArrayList<>();

	public void addObserver(Game game) {
		
	}

	public List<Jogada> getJogadas() {
		return jogadas;
	}

	public void setScore_human(int score_human) {
		this.score_human = score_human;
	}
	
	public void addScoreTie() {
		score_tie += 1;
	}

	public int getScore_human() {
		return score_human;
	}
	
	public void addScoreWin() {
		score_win += 1;
	}

	public int getScore_win() {
		return score_win;
	}

	public int getScore_tie() {
		return score_tie;
	}
	
	
	
	
	
}
