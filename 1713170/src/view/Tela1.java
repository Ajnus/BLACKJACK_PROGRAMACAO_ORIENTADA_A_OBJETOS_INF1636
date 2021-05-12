package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;

public class Tela1 extends JPanel{
	
	
	
	private static final long serialVersionUID = 1L;
	private int quantidadeJogador = 0;
	
	public Tela1(int LARGURA, int ALTURA)
	{
		
		setLayout(null);
		setBackground(new Color(5, 83, 22));
		JLabel titleLabel = new JLabel("BlackJack");
		titleLabel.setFont(new Font("TimesRoman", Font.PLAIN, 50));
		titleLabel.setForeground(new Color(200, 200, 200));
		titleLabel.setBounds(LARGURA/2 - 120, -300, LARGURA, ALTURA);
		add(titleLabel);
		
		JLabel okLabel = new JLabel("ok!");
		okLabel.setFont(new Font("TimesRoman", Font.PLAIN, 25));
		okLabel.setForeground(new Color(200, 200, 200));
		okLabel.setBounds(LARGURA - 100, ALTURA/2 - 100, LARGURA, ALTURA);
		add(okLabel);
		
		JLabel[] jogadores = new JLabel[4];
		for (int i = 0; i < 4; i++)
		{
			if (i == 0)
			{
				jogadores[i] = new JLabel(String.format("%d Jogador", i + 1));
				jogadores[i].setFont(new Font("TimesRoman", Font.PLAIN, 25));
				jogadores[i].setForeground(new Color(200, 200, 200));
				jogadores[i].setBounds(LARGURA/2 - 75, -50 + 50*i, LARGURA, ALTURA);
				add(jogadores[i]);
			}
			else
			{
				jogadores[i] = new JLabel(String.format("%d Jogador", i + 1));
				jogadores[i].setFont(new Font("TimesRoman", Font.PLAIN, 25));
				jogadores[i].setForeground(new Color(200, 200, 200));
				jogadores[i].setBounds(LARGURA/2 - 75, -50 + 50*i, LARGURA, ALTURA);
				add(jogadores[i]);
			}
		}
		addMouseListener(new MouseListener()
				{

					@Override
					public void mouseClicked(MouseEvent event) {
						//System.out.println(event.getX() + "," + event.getY());
						int x = event.getX();
						int y = event.getY();
						int xiOk = 1100; //x inicial do botao ok
						int xfOk = 1135; //x final do botao ok
						int yiOk = 590; //y inicial do botao ok
						int yfOk = 610; //y final do botao ok
						int xi = 525; //menor coordenada x da label 1 jogador
						int xf = 680; //maior coordenada x da label 1 jogador
						int yi = 290; //menor coordenada y da label 1 jogador
						int yf = 315; //maior coordenada y da label 1 jogador
						int espaco1 = 40; //espaco da menor coordenada de y da primeira label para segunda label
						int espaco2 = 50; //espaco da maior coordenada de y da primeira label para segunda label
						
						if ((x >= xi && x <= xf) && (y >= yi && y <= yf))
						{
							
							quantidadeJogador = 1;
							jogadores[0].setForeground(new Color(0, 0, 0));
							for (int i = 1; i < 4; i++)
								jogadores[i].setForeground(new Color(200, 200, 200));
							
						}
						else if ((x >= xi && x <= xf) && (y >= yi + espaco1 && y <= yf + espaco2))
						{
							
							quantidadeJogador = 2;
							jogadores[1].setForeground(new Color(0, 0, 0));
							for (int i = 0; i < 4; i++)
							{
								if (i == 1) i++;
								jogadores[i].setForeground(new Color(200, 200, 200));
							}
							
						}
						else if ((x >= xi && x <= xf) && (y >= yi + 2*espaco1 && y <= yf + 2*espaco2))
						{
							quantidadeJogador = 3;
							jogadores[2].setForeground(new Color(0, 0, 0));
							for (int i = 0; i < 4; i++)
							{
								if (i == 2) i++;
								jogadores[i].setForeground(new Color(200, 200, 200));
							}
							
						}
						else if ((x >= xi && x <= xf) && (y >= yi + 3*espaco1 && y <= yf + 3*espaco2))
						{
							quantidadeJogador = 4;
							jogadores[3].setForeground(new Color(0, 0, 0));
							for (int i = 0; i < 3; i++)
								jogadores[i].setForeground(new Color(200, 200, 200));
							
							
						}
						else if ((x >= xiOk && x <= xfOk) && (y >= yiOk && y <= yfOk))
						{
					
							okLabel.setForeground(new Color(0, 0, 0));
							System.exit(0);
							
						}
						
					}

					@Override
					public void mouseEntered(MouseEvent arg0) {}

					@Override
					public void mouseExited(MouseEvent arg0) {}

					@Override
					public void mousePressed(MouseEvent arg0) {}

					@Override
					public void mouseReleased(MouseEvent arg0) {}
				
				});	
	}
	
	public int getQuantidadeJogador()
	{
		return quantidadeJogador;
	}
	
	

}
