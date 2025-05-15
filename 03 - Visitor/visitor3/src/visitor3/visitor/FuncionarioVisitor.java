package visitor3.visitor;

import visitor3.empresa.FuncNivelA;
import visitor3.empresa.FuncNivelB;
import visitor3.empresa.Gerente;

public interface FuncionarioVisitor {

	void visitGerente(Gerente gerente);
	void visitFuncNivelA(FuncNivelA funcionario);
	void visitFuncNivelB(FuncNivelB funcionario);
	
	
	
}
