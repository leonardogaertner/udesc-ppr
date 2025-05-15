package visitor6.visitor;

import visitor6.equipe.Funcionario;
import visitor6.equipe.Projeto;

public class VisitarFimProjetoVisitor implements VisitorFuncionario{

	private Projeto projeto;
	
	public VisitarFimProjetoVisitor(Projeto projeto) {
		this.projeto = projeto;
	}
	
	@Override
	public void visitFuncionario(Funcionario funcionario) {
		if(projeto.getEquipe().contains(funcionario)) {
			funcionario.setProjetoAtual(null);
			for (int i = 0; i < projeto.getEquipe().size(); i++) {
				projeto.getEquipe().remove(i);
			}
		}
	}

}
