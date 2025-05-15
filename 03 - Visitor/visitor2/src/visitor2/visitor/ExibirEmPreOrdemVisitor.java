package visitor2.visitor;

import visitor2.arvore.Noh;

public class ExibirEmPreOrdemVisitor implements ArvoreVisitor {
	
	@Override
	public void visit(Noh noh) throws Exception {
	       if (noh == null) {
	            return;
	        }
			System.out.println(noh);

	        this.visit(noh.getEsquerdo());
	        this.visit(noh.getDireito());

	}
}
