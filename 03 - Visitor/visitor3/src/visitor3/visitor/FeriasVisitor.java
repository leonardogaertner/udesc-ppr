package visitor3.visitor;

import visitor3.empresa.FuncNivelA;
import visitor3.empresa.FuncNivelB;
import visitor3.empresa.Gerente;

public class FeriasVisitor implements FuncionarioVisitor {
	private int funcFerias;
	
	@Override
	public void visitGerente(Gerente gerente) {
		if(gerente.getFeriasAGozar() >= 10) {
			gerente.setFeriasAGozar(gerente.getFeriasAGozar()-10);
			funcFerias++;
		}
		
	}

	@Override
	public void visitFuncNivelA(FuncNivelA funcionario) {
		if(funcionario.getFeriasAGozar() >= 10 && funcionario.getSalario() >=5000) {
			funcionario.setFeriasAGozar(funcionario.getFeriasAGozar()-10);
			funcFerias++;
		}
	}

	@Override
	public void visitFuncNivelB(FuncNivelB funcionario) {
		if(funcionario.getFeriasAGozar() >= 10 && funcionario.getSalario() >=1500) {
			funcionario.setFeriasAGozar(funcionario.getFeriasAGozar()-5);
			funcFerias++;
		}
	}

	public int getFuncFerias() {
		return funcFerias;
	}

	public void setFuncFerias(int funcFerias) {
		this.funcFerias = funcFerias;
	}
	
	
}
