package br.udesc.exemplomvc.view;

public interface Observador {
	void salvouVeiculo();

	void excluiuVeiculo();

	void achouVeiculo(String modelo, String marca, int ano);

	void naoAchouVeiculo();
}
