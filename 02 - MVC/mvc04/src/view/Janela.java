package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import model.Pedido;
import model.Produto;

@SuppressWarnings("serial")
public class Janela extends JFrame {

	private JButton jbNovo;

	private CardLayout cardLayout;

	private JButton jbAnterior;

	private JButton jbPosterior;

	private JButton jbAdd;

	private JButton jbConcluir;

	private JPanel jpProdutos;

	private JTable jtItens;

	private int idxProduto;
	private List<Produto> tabelaProdutos = new ArrayList<>();
	private List<Pedido> tabelaPedidos = new ArrayList<>();

	private ItensTableModel itModel;

	class ItensTableModel extends AbstractTableModel {

		@Override
		public int getColumnCount() {
			return 3;
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			if (columnIndex == 0) {
				return String.class;
			} else {
				return Number.class;
			}
		}
		
		@Override
		public int getRowCount() {
			return tabelaPedidos.size() + 1;
		}

		@Override
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

		@Override
		public String getColumnName(int column) {
			switch (column) {
			case 0:
				return "Produto";
			case 1:
				return "Qtdade";
			default:
				return "Total";
			}
		}

	}

	class ItensTableRenderer extends DefaultTableCellRenderer {
		
		public ItensTableRenderer() {
			setHorizontalAlignment(JLabel.RIGHT);
		}
		
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int col) {

			// Cells are by default rendered as a JLabel.
			JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

			if (row == tabelaPedidos.size()) {
				l.setFont(new Font(l.getFont().getFontName(), Font.BOLD, l.getFont().getSize()));
			}
			return l;

		}
	}

	public Janela() {
		setTitle("Prova 1 55PPR");
		setSize(400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		tabelaProdutos.add(new Produto("cal\u00E7a", 83));
		tabelaProdutos.add(new Produto("camisa", 57));
		tabelaProdutos.add(new Produto("gravata", 15.7));
		tabelaProdutos.add(new Produto("tenis", 235.8));

		initComponents();
		addEventos();
		
		habilitarComponentes(false);

	}

	private void habilitarComponentes(boolean valor) {
		
		jbNovo.setEnabled(!valor);
		jbAnterior.setEnabled(valor);
		jbPosterior.setEnabled(valor);
		jbAdd.setEnabled(valor);
		jbConcluir.setEnabled(valor);
		jtItens.setEnabled(valor);
		
	}

	private void initComponents() {
		JPanel jp1 = new JPanel();
		jbNovo = new JButton("Novo");

		jp1.add(jbNovo);
		add(jp1, BorderLayout.NORTH);

		JPanel nav = new JPanel();
		nav.setLayout(new BorderLayout());
		nav.setBorder(BorderFactory.createLineBorder(Color.black));

		jpProdutos = new JPanel();
		for (Produto p : tabelaProdutos) {
			Icon icon = new ImageIcon("imagens/" + p.getNome() + ".png");
			JLabel jl = new JLabel(icon);
			jpProdutos.add(jl);
		}

		cardLayout = new CardLayout();
		jpProdutos.setLayout(cardLayout);
		jbAnterior = new JButton("<<");
		jbPosterior = new JButton(">>");

		nav.add(jpProdutos, BorderLayout.CENTER);
		JPanel navBotoes = new JPanel();
		navBotoes.add(jbAnterior);
		navBotoes.add(jbPosterior);
		nav.add(navBotoes, BorderLayout.SOUTH);

		add(nav, BorderLayout.WEST);

		JPanel jp2 = new JPanel();
		jp2.setLayout(new BorderLayout());
		// criar a JTable
		jtItens = new JTable();
		itModel = new ItensTableModel();
		jtItens.setModel(itModel);
		jtItens.setDefaultRenderer(Number.class, new ItensTableRenderer());

		jp2.add(new JScrollPane(jtItens), BorderLayout.CENTER);

		JPanel jpBotoes = new JPanel();

		jbAdd = new JButton("Add ao pedido");
		jbConcluir = new JButton("Concluir o pedido");

		jpBotoes.add(jbAdd);
		jpBotoes.add(jbConcluir);

		jp2.add(jpBotoes, BorderLayout.SOUTH);

		add(jp2, BorderLayout.CENTER);

	}

	private void addEventos() {
		jbNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				habilitarComponentes(true);
			}
		});

		jbAnterior.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.previous(jpProdutos);
				idxProduto = (idxProduto - 1);
				if (idxProduto == -1)
					idxProduto = tabelaProdutos.size() - 1;
			}
		});

		jbPosterior.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.next(jpProdutos);
				idxProduto = (idxProduto + 1) % tabelaProdutos.size();
			}
		});

		jbAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
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

				itModel.fireTableDataChanged();
			}
		});

		jbConcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				tabelaPedidos.clear();
				itModel.fireTableDataChanged();
				cardLayout.first(jpProdutos);
				idxProduto = 0;

				habilitarComponentes(false);
			}
		});
	}

	public static void main(String[] args) {
		Janela j = new Janela();
		j.setVisible(true);
	}

}
