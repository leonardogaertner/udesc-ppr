package visitor6.equipe;

import java.util.ArrayList;
import java.util.List;

public class Projeto {
	
	private String nomeProjeto;
	private int qtdAnalistas;
	private int qtdProjetistas;
	private int qtdProgramadores;
	private List<Funcionario> equipe = new ArrayList<>();
	private double custo;
	
	public Projeto(String nomeProjeto, int qtdAnalistas, int qtdProjetistas, int qtdProgramadores) {
		this.nomeProjeto = nomeProjeto;
		this.qtdAnalistas = qtdAnalistas;
		this.qtdProjetistas = qtdProjetistas;
		this.qtdProgramadores = qtdProgramadores;
	}
	
	public String getNomeProjeto() {
		return nomeProjeto;
	}
	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}
	public int getQtdAnalistas() {
		return qtdAnalistas;
	}
	public void setQtdAnalistas(int qtdAnalistas) {
		this.qtdAnalistas = qtdAnalistas;
	}
	public int getQtdProjetistas() {
		return qtdProjetistas;
	}
	public void setQtdProjetistas(int qtdProjetistas) {
		this.qtdProjetistas = qtdProjetistas;
	}
	public int getQtdProgramadores() {
		return qtdProgramadores;
	}
	public void setQtdProgramadores(int qtdProgramadores) {
		this.qtdProgramadores = qtdProgramadores;
	}

	public List<Funcionario> getEquipe() {
		return equipe;
	}

	public void setEquipe(List<Funcionario> equipe) {
		this.equipe = equipe;
	}

	public double getCusto() {
		return custo;
	}

	public void setCusto(double custo) {
		this.custo = custo;
	}
	
	
	
	
	
}
