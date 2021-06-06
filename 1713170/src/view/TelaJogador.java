package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.Jogador;
import controller.Teste;

public class TelaJogador extends JPanel {

	private static final long serialVersionUID = 1L;
	private Image img = Toolkit.getDefaultToolkit().getImage("C:\\Users\\ajnas\\git\\INF1636\\Imagens\\blackjack.png");
	Graphics g;

	public TelaJogador(int LARGURA, int ALTURA, Jogador[] jogadores) {

		setLayout(null);

		JButton botaoDouble = new JButton("");
		botaoDouble.setBorderPainted(false);
		botaoDouble.setContentAreaFilled(false);
		botaoDouble.setFocusPainted(false);
		botaoDouble.setOpaque(false);
		botaoDouble.setBounds(LARGURA / 7 + 20, ALTURA - 80, 120, 40);
		botaoDouble.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		add(botaoDouble);

		JButton botaoSplit = new JButton("");
		botaoSplit.setBorderPainted(false);
		botaoSplit.setContentAreaFilled(false);
		botaoSplit.setFocusPainted(false);
		botaoSplit.setOpaque(false);
		botaoSplit.setBounds(LARGURA / 3 - 75, ALTURA - 80, 120, 40);
		botaoSplit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		add(botaoSplit);

		JButton botaoClear = new JButton("");
		botaoClear.setBorderPainted(false);
		botaoClear.setContentAreaFilled(false);
		botaoClear.setFocusPainted(false);
		botaoClear.setOpaque(false);
		botaoClear.setBounds(LARGURA / 3 + 58, ALTURA - 80, 120, 40);
		botaoClear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		add(botaoClear);

		JButton botaoDeal = new JButton("");
		botaoDeal.setBorderPainted(false);
		botaoDeal.setContentAreaFilled(false);
		botaoDeal.setFocusPainted(false);
		botaoDeal.setOpaque(false);
		botaoDeal.setBounds(LARGURA / 2 - 10, ALTURA - 80, 120, 40);
		botaoDeal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		add(botaoDeal);
		
		Teste teste = new Teste();
		String saldo = String.valueOf(teste.exibeSaldo(jogadores[0]));
		JLabel titleLabel = new JLabel(saldo);
		titleLabel.setFont(new Font("TimesRoman", Font.PLAIN, 21));
		titleLabel.setForeground(new Color(255, 255, 255));
		titleLabel.setBounds(62, ALTURA - 78, 120, 40);
		
		add(titleLabel);
	}

	@Override
	public void paintComponent(Graphics g) {
		try {
			g.drawImage(img, 0, 0, this);

		} catch (Exception e) {
			System.err.println("Imagem não encontrada!");
		}
	}
}
