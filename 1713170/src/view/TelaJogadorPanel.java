package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class TelaJogadorPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	int LARGURA = 900;
	int ALTURA = 700;
	private Image imagemBackGround = Toolkit.getDefaultToolkit().getImage("Imagens/blackjack.png");
	Graphics g;
	
	public TelaJogadorPanel()
	{
		setLayout(null);
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
