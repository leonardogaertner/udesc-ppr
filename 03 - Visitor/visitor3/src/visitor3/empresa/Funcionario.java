package visitor3.empresa;

import visitor3.visitor.FuncionarioVisitor;

public abstract class Funcionario {

	private String nome;
	private double salario;
	private int feriasAGozar;

	public Funcionario(String nome, double salario, int feriasAGozar) {
		this.nome = nome;
		this.salario = salario;
		this.feriasAGozar = feriasAGozar; 
	}
	
	public String getNome() {
		return nome;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public int getFeriasAGozar() {
		return feriasAGozar;
	}
	
	public void setFeriasAGozar(int feriasAGozar) {
		this.feriasAGozar = feriasAGozar;
	}
	
	public abstract void accept(FuncionarioVisitor visitor)throws Exception; 
}
