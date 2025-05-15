package visitor6.equipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import visitor6.visitor.VisitorFuncionario;

/*
 * O que jah existe na classe nao pode ser modificado (alterado).
 * Mas podes adicionar novas funcionalidades.
 */
public class Funcionario {

	private String nome;
	private List<String> funcoes;
	private double salario;
	private String projetoAtual;

	public Funcionario(String nome, double salario, String... funcoes) {
		this.nome = nome;
		this.funcoes = new ArrayList<String>(Arrays.asList(funcoes));
		this.salario = salario;
	}
	
	public String getNome() {
		return nome;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public List<String> getFuncoes() {
		return funcoes;
	}
	
	public String getProjetoAtual() {
		return projetoAtual;
	}
	
	public void setProjetoAtual(String projeto) {
		this.projetoAtual = projeto;
	}
	
	@Override
	public String toString() {
		return nome;
	}

	public void accept(VisitorFuncionario visitor) {
		visitor.visitFuncionario(this);
	}

}
