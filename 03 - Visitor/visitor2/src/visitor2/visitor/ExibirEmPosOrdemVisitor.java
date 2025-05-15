package visitor2.visitor;

import visitor2.arvore.Noh;

public class ExibirEmPosOrdemVisitor implements ArvoreVisitor  {
	
	@Override
	public void visit(Noh noh) throws Exception {
	       if (noh == null) {
	            return;
	        }
	        this.visit(noh.getEsquerdo());
	        
	        this.visit(noh.getDireito());
	        System.out.println(noh);
	}
}
