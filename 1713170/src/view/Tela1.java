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
	
	private boolean stateIniciar = true;
	private JButton[] jogadores = new JButton[4];
	
	
	public Tela1(int LARGURA, int ALTURA)
	{
		setLayout(null);
		setBackground(new Color(5, 83, 22));
		JLabel titleLabel = new JLabel("BlackJack");
		titleLabel.setFont(new Font("TimesRoman", Font.PLAIN, 50));
		titleLabel.setForeground(new Color(200, 200, 200));
		titleLabel.setBounds(LARGURA/2 - 120, -300, LARGURA, ALTURA);
		add(titleLabel);
		
		for (int i = 0; i < 4; i++)
		{
			if (i == 0)
			{
				jogadores[i] = new JButton(String.format("%d jogador", i + 1));
				jogadores[i].setFont(new Font("TimesRoman", Font.PLAIN, 25));
				jogadores[i].setForeground(new Color(200, 200, 200));
				jogadores[i].setBorderPainted(false);
				jogadores[i].setContentAreaFilled(false);
				jogadores[i].setFocusPainted(false);
				jogadores[i].setOpaque(false);
				jogadores[i].setBounds(LARGURA/2 - 140, (ALTURA/2 - 50) + 50*i, 200, 30);
				jogadores[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) { // jogar futuramente essa funcionalidade para o controller para poder pegar a quantidade de jogadores.
						stateIniciar = false;
					}
				});
				add(jogadores[i]);
			}	
			else
			{
				jogadores[i] = new JButton(String.format("%d jogadores", i + 1));
				jogadores[i].setFont(new Font("TimesRoman", Font.PLAIN, 25));
				jogadores[i].setForeground(new Color(200, 200, 200));
				jogadores[i].setBorderPainted(false);
				jogadores[i].setContentAreaFilled(false);
				jogadores[i].setFocusPainted(false);
				jogadores[i].setOpaque(false);
				jogadores[i].setBounds(LARGURA/2 - 130, (ALTURA/2 - 50) + 50*i, 200, 30);
				jogadores[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) { // jogar futuramente essa funcionalidade para o controller para poder pegar a quantidade de jogadores.
						stateIniciar = false;
					}
				});
				add(jogadores[i]);
			}
			
		}
		
	}
	
	public boolean getStateIniciar()
	{
		return stateIniciar;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {}
	
	
}
