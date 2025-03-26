package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Card;

/**
 * The Memory class creates the GUI for the MemoryUI House application.
 */

// Adaptado de https://github.com/moon-tea/Memory/

public class Memory extends JFrame {

	private static final long serialVersionUID = 1L;

	// constantes: nao tem problema mante-las publicas
	public static final int ROWS = 2;
	public static final int COLUMNS = 3;

	private MemoryButton[][] memButtons = new MemoryButton[ROWS][COLUMNS];
	private JLabel[][] imgLabel = new JLabel[ROWS][COLUMNS];
	private JPanel[][] memPanel = new JPanel[ROWS][COLUMNS];

	private Card[] cards = new Card[COLUMNS * ROWS];
	private int compareCards = 0;
	private int holdCardRow = 0;
	private int holdCardColumn = 0;
	private boolean isFirst = true;
	private int win = 0;

	private ImageIcon versoCarta;

	public Memory() {
		versoCarta = new ImageIcon("imagens/Card0.jpg");
		
		Random rgen = new Random(); 
		int z = 1;
		
		for (int i = 0; i < cards.length; i++) {
			cards[i] = new Card(-1, -1, z, false);
			if (i % 2 == 1) {
				z++;
			}
		}
		
		// --- embaralhar
		for (int i = 0; i < cards.length; i++) {
			int randomPosition = rgen.nextInt(cards.length);
			Card temp = cards[i];

			cards[i] = cards[randomPosition];
			cards[i].setX(i / COLUMNS);
			cards[i].setY(i % COLUMNS);

			cards[randomPosition] = temp;

			temp.setX(randomPosition / COLUMNS);
			temp.setY(randomPosition % COLUMNS);
		}

		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				buildMemPanel(i, j);
				add(memPanel[i][j]);
			}
		}

		setTitle("Prova 1 - 2024/1");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(ROWS, COLUMNS));

		// Empacotar (organizar) a janela
		pack();

		setLocationRelativeTo(null);
		setResizable(false);

	}

	// criar o visual do jogo de memoria
	private void buildMemPanel(int _i, int _j) {
		memPanel[_i][_j] = new JPanel();

		memPanel[_i][_j].setLayout(new GridLayout(2, 1));

		memButtons[_i][_j] = new MemoryButton(_i, _j);

		memButtons[_i][_j].addActionListener(new FlipListener());
		memButtons[_i][_j].setText("Virar!");

		imgLabel[_i][_j] = new JLabel(versoCarta);

		memPanel[_i][_j].setBorder(BorderFactory.createTitledBorder(" "));

		memPanel[_i][_j].add(imgLabel[_i][_j]);
		memPanel[_i][_j].add(memButtons[_i][_j]);
	}

	private class FlipListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			MemoryButton clicked = (MemoryButton) obj;
			int r = clicked.getRow();
			int c = clicked.getColumn();
			
			int index = (r * COLUMNS) + c ;
			
			ImageIcon tempImg = new ImageIcon("imagens/Card" + cards[index].getImgNum() + ".jpg");
			imgLabel[r][c].setIcon(tempImg);

			// guarda as variaveis da primeira carta a ser virada
			if (isFirst) {
				compareCards = cards[index].getImgNum();
				holdCardRow = r;
				holdCardColumn = c;
				memButtons[holdCardRow][holdCardColumn].setEnabled(false);
				isFirst = false;
			} else {
				// cartas iguais
				if (compareCards == cards[index].getImgNum()) {
					win++;
					// encontrou todas entao fim de jogo
					if (win == COLUMNS) {
						JOptionPane.showMessageDialog(null, "Voc\u00EA venceu!");
						dispose();

					} else {
						// encontrou um par entao desabilita para nao fazer mais pares
						JOptionPane.showMessageDialog(null, "Voc\u00EA encontrou um par!");
						cards[(holdCardRow * COLUMNS)+holdCardColumn].setCorrect(true);
						cards[index].setCorrect(true);
						memButtons[r][c].setEnabled(false);
					}
				} else {
					// cartas diferentes
					JOptionPane.showMessageDialog(null, "Gah! Erradas!");
					memButtons[holdCardRow][holdCardColumn].setEnabled(true);
					tempImg = versoCarta;
					imgLabel[r][c].setIcon(tempImg);
					imgLabel[holdCardRow][holdCardColumn].setIcon(tempImg);
				}
				isFirst = true;
			}
		}
	}

	class MemoryButton extends JButton {

		private static final long serialVersionUID = 1L;

		private int row;
		private int column;

		public MemoryButton(int _i, int _j) {
			this.row = _i;
			this.column = _j;
		}

		public int getRow() {
			return row;
		}

		public int getColumn() {
			return column;
		}
	}

	public static void main(String[] args) {
		Memory m = new Memory();
		m.setVisible(true);
	}
}