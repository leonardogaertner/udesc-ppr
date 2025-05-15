package visitor2.visitor;

import visitor2.arvore.Noh;

public class ExibirEmOrdemVisitor implements ArvoreVisitor {

	@Override
	public void visit(Noh noh) throws Exception {
	       if (noh == null) {
	            return;
	        }
	        this.visit(noh.getEsquerdo());
	        System.out.println(noh);
	        this.visit(noh.getDireito());

	}

}
