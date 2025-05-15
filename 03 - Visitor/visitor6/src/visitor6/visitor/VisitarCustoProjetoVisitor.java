package visitor6.visitor;


import visitor6.equipe.Funcionario;
import visitor6.equipe.Projeto;

public class VisitarCustoProjetoVisitor implements VisitorFuncionario{
	//private List<Funcionario> equipe;
	private Projeto projeto;
	
	public VisitarCustoProjetoVisitor(Projeto projeto) {
		this.projeto = projeto;
	}
	
	@Override
	public void visitFuncionario(Funcionario funcionario) {
		if(projeto.getEquipe().contains(funcionario)) {
			projeto.setCusto(projeto.getCusto() + funcionario.getSalario());
		}
	}

}
