package contoller;

import java.util.ArrayList;
import java.util.List;

import model.Pedido;
import model.Produto;

public class Controller {
	private int idxProduto;
	private List<Produto> tabelaProdutos = new ArrayList<>();
	private List<Pedido> tabelaPedidos = new ArrayList<>();
	private List<Observer> obss = new ArrayList<>();
	
	public void addObserver(Observer obs) {
		obss.add(obs);
	}
	
	
	public int getRowCount() {
		return tabelaPedidos.size() + 1;
	}

	public Object getValueAt(int rowIndex, int colIndex) {
		if (rowIndex == tabelaPedidos.size()) {
			if (colIndex == 2) {
				double total = 0;
				for (Pedido ped : tabelaPedidos) {
					total += ped.getPcoTotal();
				}
				return total;

			} else {
				return null;
			}
		} else {
			Pedido p = tabelaPedidos.get(rowIndex);
			switch (colIndex) {
			case 0:
				return p.getProduto().getNome();
			case 1:
				return p.getQtdade();
			default:
				return p.getPcoTotal();
			}
		}
	}


	public int tabelaPedidosSize(){
		return tabelaPedidos.size();	
		}
	
	public void addproduto(Produto prd){
		tabelaProdutos.add(prd);
	}

	public List<Produto> getTabelaProdutos() {
		return tabelaProdutos;
	}

	public void anterior() {
		idxProduto = (idxProduto - 1);
		if (idxProduto == -1)
			idxProduto = tabelaProdutos.size() - 1;
		
		for (Observer obs : obss) {
			obs.previous();
		}
	}

	public void posterior() {
		idxProduto = (idxProduto + 1) % tabelaProdutos.size();
		for (Observer obs : obss) {
			obs.next();
		}
	}

	public void addItem() {
		Produto prod = tabelaProdutos.get(idxProduto);
		Pedido alvo = null;
		for (Pedido ped : tabelaPedidos) {
			if (ped.getProduto() == prod) {
				alvo = ped;
				break;
			}
		}
		if (alvo == null) {
			alvo = new Pedido(prod);
			tabelaPedidos.add(alvo);
		} else
			alvo.addQtdade();		
	
		for (Observer obs : obss) {
			obs.addItem();
		}
	}

	public void concluir() {
		tabelaPedidos.clear();
		idxProduto = 0;
		for (Observer obs : obss) {
			obs.concluir();
		}
	}


	public void iniciar() {
		for (Observer obs : obss) {
			obs.iniciarCompra();
		}
	}
	
	


}
