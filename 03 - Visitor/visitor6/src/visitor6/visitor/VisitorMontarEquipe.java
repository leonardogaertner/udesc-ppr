package visitor6.visitor;

import java.util.ArrayList;
import java.util.List;

import visitor6.equipe.Funcionario;
import visitor6.equipe.Projeto;

public class VisitorMontarEquipe implements VisitorFuncionario {
	
	private Projeto prj;
	private int analistasFaltantes;
	private int projetistasFaltantes;
	private int programadoresFaltantes;
	
	public VisitorMontarEquipe(Projeto prj) {
		this.prj = prj;
		this.analistasFaltantes =  prj.getQtdAnalistas();
		this.projetistasFaltantes = prj.getQtdProjetistas();
		this.programadoresFaltantes = prj.getQtdProgramadores();
	}
	


	@Override
	public void visitFuncionario(Funcionario funcionario) {
		if(funcionario.getProjetoAtual() == null) {
			for(int i = 0; i < funcionario.getFuncoes().size(); i++) {
				if(funcionario.getFuncoes().get(i).equalsIgnoreCase("Analista") && analistasFaltantes > 0) {
					analistasFaltantes--;
					funcionario.setProjetoAtual(prj.getNomeProjeto());
					if(prj.getEquipe().contains(funcionario) == false) {
						prj.getEquipe().add(funcionario);
					}
				}

				if(funcionario.getFuncoes().get(i).equalsIgnoreCase("Projetista") && projetistasFaltantes > 0) {
					projetistasFaltantes--;
					funcionario.setProjetoAtual(prj.getNomeProjeto());
					if(prj.getEquipe().contains(funcionario) == false) {
						prj.getEquipe().add(funcionario);
					}
				}
				
				if(funcionario.getFuncoes().get(i).equalsIgnoreCase("Programador") && programadoresFaltantes > 0) {
					programadoresFaltantes--;
					funcionario.setProjetoAtual(prj.getNomeProjeto());
					if(prj.getEquipe().contains(funcionario) == false) {
						prj.getEquipe().add(funcionario);
					}
				}
			}
		}
	}
	
	public String isCompleto() {
		if(analistasFaltantes <= 0 && projetistasFaltantes <= 0 && programadoresFaltantes <= 0) {
			return "Equipe Completa para o " + prj.getNomeProjeto();
		}
		return "Equipe incompleta";
	}
	
	public String getMembrosEquipe() {
		String f="Equipe | ";
		for (Funcionario funcionario: prj.getEquipe()) {
			f += funcionario.getNome() + " | ";
		}
		return f;
	}
	
}
