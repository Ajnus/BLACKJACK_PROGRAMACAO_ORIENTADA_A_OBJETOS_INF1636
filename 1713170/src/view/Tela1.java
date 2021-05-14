package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Tela1 extends JPanel implements ActionListener{
	
	
	
	private static final long serialVersionUID = 1L;
	private int quantidadeJogador = 0;
	private boolean stateIniciar = true;
	
	private JButton iniciar; 
	private JButton jogador1;
	private JButton jogador2;
	private JButton jogador3;
	private JButton jogador4;
	
	private boolean state1;
	private boolean state2;
	private boolean state3;
	private boolean state4;
	
	public Tela1(int LARGURA, int ALTURA)
	{
		setLayout(null);
		setBackground(new Color(5, 83, 22));
		JLabel titleLabel = new JLabel("BlackJack");
		titleLabel.setFont(new Font("TimesRoman", Font.PLAIN, 50));
		titleLabel.setForeground(new Color(200, 200, 200));
		titleLabel.setBounds(LARGURA/2 - 120, -300, LARGURA, ALTURA);
		add(titleLabel);
		
		
		jogador1 = new JButton("1 Jogador");
		jogador1.setFont(new Font("TimesRoman", Font.PLAIN, 25));
		jogador1.setForeground(new Color(200, 200, 200));
		jogador1.setBorderPainted(false);
		jogador1.setContentAreaFilled(false);
		jogador1.setFocusPainted(false);
		jogador1.setOpaque(false);
		jogador1.setBounds(LARGURA/2 - 130, ALTURA/2 - 100, 200, 30);
		jogador1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state1 = true;
				state2 = false;
				state3 = false;
				state4 = false;
				jogador1.setForeground(new Color(0, 0, 0));
				jogador2.setForeground(new Color(200, 200, 200));
				jogador3.setForeground(new Color(200, 200, 200));
				jogador4.setForeground(new Color(200, 200, 200));
			}
		});
		add(jogador1);
		
		jogador2 = new JButton("2 Jogadores");
		jogador2.setFont(new Font("TimesRoman", Font.PLAIN, 25));
		jogador2.setForeground(new Color(200, 200, 200));
		jogador2.setBorderPainted(false);
		jogador2.setContentAreaFilled(false);
		jogador2.setFocusPainted(false);
		jogador2.setOpaque(false);
		jogador2.setBounds(LARGURA/2 - 120, ALTURA/2 - 50, 200, 30);
		jogador2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state1 = false;
				state2 = true;
				state3 = false;
				state4 = false; 
				jogador1.setForeground(new Color(200, 200, 200));
				jogador2.setForeground(new Color(0, 0, 0));
				jogador3.setForeground(new Color(200, 200, 200));
				jogador4.setForeground(new Color(200, 200, 200));
			}
		});
		add(jogador2);
		
		jogador3 = new JButton("3 Jogadores");
		jogador3.setFont(new Font("TimesRoman", Font.PLAIN, 25));
		jogador3.setForeground(new Color(200, 200, 200));
		jogador3.setBorderPainted(false);
		jogador3.setContentAreaFilled(false);
		jogador3.setFocusPainted(false);
		jogador3.setOpaque(false);
		jogador3.setBounds(LARGURA/2 - 120, ALTURA/2, 200, 30);
		jogador3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state1 = false;
				state2 = false;
				state3 = true;
				state4 = false;
				jogador1.setForeground(new Color(200, 200, 200));
				jogador2.setForeground(new Color(200, 200, 200));
				jogador3.setForeground(new Color(0, 0, 0));
				jogador4.setForeground(new Color(200, 200, 200));
			}
		});
		add(jogador3);
		
		jogador4 = new JButton("4 Jogadores");
		jogador4.setFont(new Font("TimesRoman", Font.PLAIN, 25));
		jogador4.setForeground(new Color(200, 200, 200));
		jogador4.setBorderPainted(false);
		jogador4.setContentAreaFilled(false);
		jogador4.setFocusPainted(false);
		jogador4.setOpaque(false);
		jogador4.setBounds(LARGURA/2 - 120, ALTURA/2 + 50, 200, 30);
		jogador4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state1 = false;
				state2 = false;
				state3 = false;
				state4 = true;
				jogador1.setForeground(new Color(200, 200, 200));
				jogador2.setForeground(new Color(200, 200, 200));
				jogador3.setForeground(new Color(200, 200, 200));
				jogador4.setForeground(new Color(0, 0, 0));
			}
		});
		add(jogador4);
		
	
		
		iniciar= new JButton("Iniciar!");
		iniciar.setFont(new Font("TimesRoman", Font.PLAIN, 25));
		iniciar.setForeground(new Color(200, 200, 200));
		iniciar.setBorderPainted(false);
		iniciar.setContentAreaFilled(false);
		iniciar.setFocusPainted(false);
		iniciar.setOpaque(false);
		iniciar.setBounds(LARGURA - 170, ALTURA - 100, 200, 30);
		iniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (state1 == false && state2 == false && state3 == false && state4 == false)
				{
					JOptionPane.showMessageDialog(null, "Escolha uma das opções!");
				}
				else
				{
					if (state1 == true) quantidadeJogador = 1;
					else if (state2 == true) quantidadeJogador = 2;
					else if (state3 == true) quantidadeJogador = 3;
					else if (state4 == true) quantidadeJogador = 4;
					stateIniciar = false;
					System.exit(0);
				}
			}
		});
		add(iniciar);
		
		
	}
	
	public int getQuantidadeJogador()
	{
		return quantidadeJogador;
	}
	
	public boolean getStateIniciar()
	{
		return stateIniciar;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {}
	
	
}
