package model;

public class Jogada {

	private int minha;
	private int pc;

	public Jogada(int minha, int pc) {
		this.minha = minha;
		this.pc = pc;
	}

	public int getMinha() {
		return minha;
	}

	public int getPc() {
		return pc;
	}
	
	public int getVitorioso() {
		return Integer.parseInt("" + Math.min(pc, minha) + Math.max(pc, minha));
	}
}
