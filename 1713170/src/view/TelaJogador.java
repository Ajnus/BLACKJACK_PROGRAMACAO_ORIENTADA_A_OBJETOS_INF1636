package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.JogadorController;

public class TelaJogador extends JFrame{
	
	
	private static final long serialVersionUID = 1L;
	
	
	public TelaJogadorPanel jogadorPanel;
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();
	int screenWidth = screenSize.width;
	int screenHeight = screenSize.height;
	
	private JLabel pontosLabel = new JLabel("Pontos: 0");
	private JLabel apostaLabel = new JLabel("Aposta: 0");
	private JLabel fichasLabel = new JLabel("Fichas: 500");
	private JLabel erroLabel = new JLabel("");
	
	private JButton botaoDouble = new JButton("");
	private JButton botaoSplit= new JButton("");
	private JButton botaoClear= new JButton("");
	private JButton botaoDeal= new JButton("");   
	private JButton botaoAposta = new JButton("Apostar");
	private JButton botaoRender = new JButton("Render");
	
	
	

	public TelaJogador(int LARGURA, int ALTURA) {
		
		jogadorPanel = new TelaJogadorPanel();
		
		
		setTitle("Jogador");
		setBackground(new Color(17, 68, 26));
		setResizable(false);
		int x = screenWidth / 2 - LARGURA / 2;
		int y = screenHeight / 2 - ALTURA / 2;
		setBounds(x, y, LARGURA, ALTURA);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Trata JLabel
		pontosLabel.setForeground(Color.WHITE);
		pontosLabel.setBounds(6, 500, 70, 70);
		
		jogadorPanel.add(pontosLabel);
		
		apostaLabel.setForeground(Color.WHITE);
		apostaLabel.setBounds(6, 525, 70, 70);
		
		jogadorPanel.add(apostaLabel);
		
		fichasLabel.setForeground(Color.WHITE);
		fichasLabel.setBounds(6, 550, 70, 70);
		
		jogadorPanel.add(fichasLabel);
		
		
		//Trata JButton ações do jogador
		
		botaoDouble.setBorderPainted(false);
		botaoDouble.setContentAreaFilled(false);
		botaoDouble.setFocusPainted(false);
		botaoDouble.setOpaque(false);
		botaoDouble.setBounds(LARGURA / 7 + 58, ALTURA - 80, 128, 40);
		botaoDouble.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		jogadorPanel.add(botaoDouble);

		botaoSplit.setBorderPainted(false);
		botaoSplit.setContentAreaFilled(false);
		botaoSplit.setFocusPainted(false);
		botaoSplit.setOpaque(false);
		botaoSplit.setBounds(LARGURA / 3 + 22, ALTURA - 80, 128, 40);
		botaoSplit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		jogadorPanel.add(botaoSplit);

		botaoClear.setBorderPainted(false);
		botaoClear.setContentAreaFilled(false);
		botaoClear.setFocusPainted(false);
		botaoClear.setOpaque(false);
		botaoClear.setBounds(LARGURA / 2 + 5, ALTURA - 80, 128, 40);
		botaoClear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		jogadorPanel.add(botaoClear);

		botaoDeal.setBorderPainted(false);
		botaoDeal.setContentAreaFilled(false);
		botaoDeal.setFocusPainted(false);
		botaoDeal.setOpaque(false);
		botaoDeal.setBounds(LARGURA/2 + 136, ALTURA - 80, 128, 40);
		botaoDeal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		jogadorPanel.add(botaoDeal);
		
		botaoAposta.setForeground(Color.WHITE);
		botaoAposta.setBackground(new Color(17, 68, 26));
		botaoAposta.setBorderPainted(false);
		botaoAposta.setFocusPainted(false);
		botaoAposta.setBounds(5, 650, 80, 20);
		botaoAposta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		jogadorPanel.add(botaoAposta);
		

		botaoRender.setForeground(Color.WHITE);
		botaoRender.setBackground(new Color(17, 68, 26));
		botaoRender.setBorderPainted(false);
		botaoRender.setFocusPainted(false);
		botaoRender.setBounds(85, 650, 90, 20);
		botaoRender.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		jogadorPanel.add(botaoRender);
		
		add(jogadorPanel);
		
	}
	
	public void setListeners(JogadorController controller)
	{
		
		botaoRender.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {		
				controller.render();
			}
		});
		
		
		botaoAposta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {		
				controller.fimAposta();
			}
		});
	}
	
	public void updateLabelFicha(int aposta, int totalFichas)
	{
		fichasLabel.setText("Fichas: " + String.valueOf(totalFichas));
		apostaLabel.setText("Aposta: " + String.valueOf(aposta));
		
	}
	
	public void mensagemErro(String mensagem)
	{
		erroLabel.setText(mensagem);
		erroLabel.setForeground(new Color(128, 44, 49));
		erroLabel.setBounds(6, 500, 70, 70);
		erroLabel.setVisible(true);
		
		jogadorPanel.add(erroLabel);
		jogadorPanel.validate();
	}

}
