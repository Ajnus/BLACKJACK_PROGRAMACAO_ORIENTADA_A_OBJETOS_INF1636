package net.blackjack.view;

import net.blackjack.model.Carta;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class CartaPanel extends JPanel {
	public void desenhaCarta(Graphics g, int posicaoX, int posicaoY, Image imagemCarta) {
		g.drawImage(imagemCarta, posicaoX, posicaoY, 70, 100, null);

	}

	public static ArrayList<Image> criaImagemCarta(List<Carta> baralho) {
		ArrayList<Image> imagemCartas = new ArrayList<Image>();
		Image imagemCarta = null;
		for (Carta carta : baralho) {
			String idCarta = carta.getId().substring(0, 2);
			try {
				imagemCarta = Toolkit.getDefaultToolkit().getImage("Imagens/" + idCarta + ".gif");
				System.out.printf("carregou a carta %s de %s\n", carta.getValor(), carta.getNaipe());

			} catch (Exception e) {
				System.err.println("Carta n�o encontrada!");
			}

			imagemCartas.add(imagemCarta);
		}
		return imagemCartas;
	}
}

/*
 * @Override public void paintComponent(Graphics g) { super.paintComponent(g);
 * 
 * int panelSize = getSize().width; int posX = -50; int posY = 180;
 * 
 * for(Image img: imagemCartas) { if (panelSize < posX + img.getWidth(null)){
 * posX = 10; posY += 60; } else { posX += 60; }
 * 
 * g.drawImage(img, posX, posY, 50, 50, null); } }
 * 
 * 
 * }
 */
