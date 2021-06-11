package view;

import java.awt.Color;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.Jogador;
import controller.Teste;

public class TelaJogador extends JPanel {

	private static final long serialVersionUID = 1L;
	private Image img = Toolkit.getDefaultToolkit().getImage("blackjack.png");
	Graphics g;
	// Jogador[] jogadoress;
	JLabel saldoLabel;
	JLabel apostaLabel;

	public TelaJogador(int LARGURA, int ALTURA, Jogador[] jogadores) {

		// jogadoress = jogadores;
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
		saldoLabel = new JLabel(saldo);
		saldoLabel.setFont(new Font("TimesRoman", Font.PLAIN, 21));
		saldoLabel.setForeground(new Color(255, 255, 255));
		saldoLabel.setBounds(65, ALTURA - 77, 120, 40);

		add(saldoLabel);

		Teste teste1 = new Teste();
		String aposta = String.valueOf(teste1.exibeAposta(jogadores[0]));
		apostaLabel = new JLabel(aposta);
		apostaLabel.setFont(new Font("TimesRoman", Font.PLAIN, 21));
		apostaLabel.setForeground(new Color(255, 255, 255));
		apostaLabel.setBounds(65, ALTURA - 116, 120, 40);

		add(apostaLabel);
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
