package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JPanel;

public class TelaJogadorPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	int LARGURA = 900;
	int ALTURA = 700;
	public ArrayList<Image> imagemFichas = new ArrayList<Image>();
	public ArrayList<Image> imagemFichasPilha = new ArrayList<Image>();
	private int[] numFichas = { 1, 5, 10, 20, 50, 100 };
	// ImageObserver obsere
	private Image imagemBackGround = Toolkit.getDefaultToolkit().getImage("Imagens/blackjack.png");
	// Graphics g = this.getGraphics();

	public TelaJogadorPanel() {
		setLayout(null);
		Image imagemFicha = null;
		// super.paintComponents(g);
		for (int i = 0; i < 6; i++) {
			try {
				imagemFicha = Toolkit.getDefaultToolkit().getImage("Imagens/ficha " + numFichas[i] + "$.png");
				System.out.printf("carregou ficha %d$.png\n", numFichas[i]);

			} catch (Exception e) {
				System.err.println("Ficha não encontrada!");
			}

			imagemFichas.add(imagemFicha);

		}
	}

	// necess�rio para renderizar sem 2 cliques
	public void preDesenhaFichas(Graphics g, int idJogador) {
		desenhaFichas(g, 1, idJogador);
		desenhaFichas(g, 5, idJogador);
		desenhaFichas(g, 10, idJogador);
		desenhaFichas(g, 20, idJogador);
		desenhaFichas(g, 50, idJogador);
		desenhaFichas(g, 100, idJogador);
	}

	public void desenhaFichas(Graphics g, int valor, int idJogador) {
		int i = 0;
		int deslocamentoY = 0;
		// imagemFichas.add(imagemFicha);

		switch (valor) {
		case 1:
			i = 0;
			break;
		case 5:
			i = 1;
			break;
		case 10:
			i = 2;
			break;
		case 20:
			i = 3;
			break;
		case 50:
			i = 4;
			break;
		case 100:
			i = 5;
			break;
		default:
			break;
		}

		switch (idJogador) {
		case 1:
			deslocamentoY = 0;
			break;
		case 2:
			deslocamentoY = 60;
			break;
		case 3:
			deslocamentoY = 120;
			break;
		case 4:
			deslocamentoY = 180;
			break;
		default:
			break;
		}

		Image imagemFicha = this.imagemFichas.get(i);
		imagemFichasPilha.add(imagemFicha);
		g.drawImage(imagemFicha, LARGURA - 80, 117 + deslocamentoY, null);
		System.out.println("imprimiu?");

	}

	@Override
	public void paintComponent(Graphics g) {
		try {
			g.drawImage(imagemBackGround, 0, 0, this);
			g.setColor(new Color(17, 68, 26));
			g.fillRect(5, 520, 170, 550);

		} catch (Exception e) {
			System.err.println("Imagem não encontrada!");
		}
	}
}
