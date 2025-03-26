package modelo;

public class Mao {

	private int minha;
	private int pc;
	private boolean par;

	public Mao(boolean par, int pc, int minha) {
		this.par = par;
		this.minha = minha;
		this.pc = pc;
	}
	
	public boolean isPar() {
		return par;
	}
	
	public int getMinha() {
		return minha;
	}
	
	public int getPc() {
		return pc;
	}
	
	@Override
	public String toString() {
		boolean vitPar = ((pc + minha) % 2) == 0;
		return (isPar()?"P":"I") + " - " + pc + " - " + minha + " - " + (vitPar == isPar()?"V":"D"); 
	}
}
