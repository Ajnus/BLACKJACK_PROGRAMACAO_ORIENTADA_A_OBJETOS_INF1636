package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.BotaoNumeroJogador;
import controller.GameController;

import java.awt.*;

public class TelaInicio extends JFrame {

	private static final long serialVersionUID = 1L;

	// Ajustes de tela
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();
	int screenWidth = screenSize.width;
	int screenHeight = screenSize.height;
	JPanel panel = new JPanel();

	private JButton[] jogadores = new JButton[4];

	public TelaInicio(GameController game, int LARGURA, int ALTURA) {

		// Configuração JFrame
		setTitle("BlackJack");
		setResizable(false);
		int x = screenWidth / 2 - LARGURA / 2;
		int y = screenHeight / 2 - ALTURA / 2;
		setBounds(x, y, LARGURA, ALTURA);

		// Configuração JPanel
		panel.setLayout(null);
		panel.setBackground(new Color(5, 83, 22));
		JLabel titleLabel = new JLabel("BlackJack");
		titleLabel.setFont(new Font("TimesRoman", Font.PLAIN, 50));
		titleLabel.setForeground(new Color(200, 200, 200));
		titleLabel.setBounds(LARGURA / 2 - 120, -300, LARGURA, ALTURA);
		panel.add(titleLabel);

		for (int i = 0; i < 4; i++) {
			if (i == 0) {
				jogadores[i] = new JButton(String.format("%d jogador", i + 1));
				jogadores[i].setFont(new Font("TimesRoman", Font.PLAIN, 25));
				jogadores[i].setForeground(new Color(200, 200, 200));
				jogadores[i].setBorderPainted(false);
				jogadores[i].setContentAreaFilled(false);
				jogadores[i].setFocusPainted(false);
				jogadores[i].setOpaque(false);
				jogadores[i].setBounds(LARGURA / 2 - 140, (ALTURA / 2 - 50) + 50 * i, 200, 30);
				jogadores[i].addActionListener(new BotaoNumeroJogador(i + 1, this));
				panel.add(jogadores[i]);
			} else {
				jogadores[i] = new JButton(String.format("%d jogadores", i + 1));
				jogadores[i].setFont(new Font("TimesRoman", Font.PLAIN, 25));
				jogadores[i].setForeground(new Color(200, 200, 200));
				jogadores[i].setBorderPainted(false);
				jogadores[i].setContentAreaFilled(false);
				jogadores[i].setFocusPainted(false);
				jogadores[i].setOpaque(false);
				jogadores[i].setBounds(LARGURA / 2 - 130, (ALTURA / 2 - 50) + 50 * i, 200, 30);
				jogadores[i].addActionListener(new BotaoNumeroJogador(i + 1, this));
				panel.add(jogadores[i]);
			}
		}
		add(panel);
	}

}
