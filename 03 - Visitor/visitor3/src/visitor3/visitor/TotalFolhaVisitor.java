package visitor3.visitor;

import visitor3.empresa.FuncNivelA;
import visitor3.empresa.FuncNivelB;
import visitor3.empresa.Gerente;

public class TotalFolhaVisitor implements FuncionarioVisitor {
	
	double folha;
	
	@Override
	public void visitGerente(Gerente gerente) {
		folha+= gerente.getSalario();
	}

	@Override
	public void visitFuncNivelA(FuncNivelA funcionario) {
		folha+= funcionario.getSalario();
		
	}

	@Override
	public void visitFuncNivelB(FuncNivelB funcionario) {
		folha+= funcionario.getSalario();
	}

	public double getFolha() {
		return folha;
	}

	public void setFolha(double folha) {
		this.folha = folha;
	}
	
	
}
