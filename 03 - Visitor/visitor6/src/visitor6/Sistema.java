package visitor6;

import java.util.ArrayList;
import java.util.List;

import visitor6.equipe.Funcionario;
import visitor6.equipe.Projeto;
import visitor6.visitor.VisitarCustoProjetoVisitor;
import visitor6.visitor.VisitarFimProjetoVisitor;
import visitor6.visitor.VisitorFuncionario;
import visitor6.visitor.VisitorMontarEquipe;

public class Sistema {

	private static List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	public static void accept(VisitorFuncionario visitor) throws Exception {
		
		for (Funcionario funcionario : funcionarios) 
			funcionario.accept(visitor);
		
	}
	
	public static void main(String[] args) throws Exception {
		
		funcionarios.add(new Funcionario("A", 1500, "Programador"));
		funcionarios.add(new Funcionario("B", 2500, "Analista"));
		funcionarios.add(new Funcionario("C", 3500, "Projetista"));
		funcionarios.add(new Funcionario("D", 5000, "Analista", "Programador"));
		funcionarios.add(new Funcionario("E", 5200, "Programador", "Analista"));
		funcionarios.add(new Funcionario("F", 8500, "Programador", "Projetista", "Analista"));
		funcionarios.add(new Funcionario("G", 8700, "Analista", "Programador", "Projetista"));
		funcionarios.add(new Funcionario("H", 8700, "Programador", "Projetista", "Analista"));
		funcionarios.add(new Funcionario("I", 1500, "Programador"));
		funcionarios.add(new Funcionario("J", 2500, "Analista"));
		funcionarios.add(new Funcionario("K", 3500, "Projetista"));		
		
		// nao pode mudar as linhas acima.... tudo o que for novo deve vir daqui para baixo
                // sugiro que crie metodos estaticos para atender os testes
		

		
		Projeto projetoA = new Projeto("ProjetoA", 1, 0, 3);
		Projeto projetoB = new Projeto("ProjetoB", 1, 2, 2);
		Projeto projetoC = new Projeto("ProjetoC", 1, 3, 3);
		
		//	BuscarTaxi v1 = new BuscarTaxi(c1);
		//		t.accept(v1);

		
		VisitorMontarEquipe v1 = new VisitorMontarEquipe(projetoA);
		Sistema.accept(v1);
		System.out.println(v1.isCompleto() + "\n" + v1.getMembrosEquipe() + "\n");
		
		VisitorMontarEquipe v2 = new VisitorMontarEquipe(projetoB);
		Sistema.accept(v2);
		System.out.println(v2.isCompleto() + "\n" + v2.getMembrosEquipe() + "\n");
		
		VisitorMontarEquipe v3 = new VisitorMontarEquipe(projetoC);
		Sistema.accept(v3);
		System.out.println(v3.isCompleto() + "\n" + v3.getMembrosEquipe() + "\n");
		
		VisitarCustoProjetoVisitor v4 = new VisitarCustoProjetoVisitor(projetoA);
		Sistema.accept(v4);
		System.out.println("Custo do projetoA: R$" + projetoA.getCusto()+ "\n");
		
		VisitarFimProjetoVisitor v5 = new VisitarFimProjetoVisitor(projetoA);
		Sistema.accept(v5);
		System.out.println("Fim do ProjetoA"+ "\n");
		
		VisitorMontarEquipe v6 = new VisitorMontarEquipe(projetoC);
		Sistema.accept(v6);
		System.out.println(v6.isCompleto() + "\n" + v6.getMembrosEquipe() + "\n");
		
		VisitarCustoProjetoVisitor v7 = new VisitarCustoProjetoVisitor(projetoB);
		Sistema.accept(v7);
		System.out.println("Custo do projetoA: R$" + projetoB.getCusto()+ "\n");
		
		VisitarFimProjetoVisitor v8 = new VisitarFimProjetoVisitor(projetoB);
		Sistema.accept(v8);
		System.out.println("Fim do ProjetoB"+ "\n");
		
		VisitorMontarEquipe v9 = new VisitorMontarEquipe(projetoC);
		Sistema.accept(v9);
		System.out.println(v9.isCompleto() + "\n" + v9.getMembrosEquipe() + "\n");
		
		VisitarCustoProjetoVisitor v10 = new VisitarCustoProjetoVisitor(projetoC);
		Sistema.accept(v10);
		System.out.println("Custo do projetoC: R$" + projetoC.getCusto()+ "\n");
		
		VisitarFimProjetoVisitor v11 = new VisitarFimProjetoVisitor(projetoC);
		Sistema.accept(v11);
		System.out.println("Fim do ProjetoC"+ "\n");
		
	}

}
 