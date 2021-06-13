package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;


import javax.swing.JPanel;

public class TelaDealerPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	int LARGURA = 900;
	int ALTURA = 700;
	public ArrayList<Image> imagemCartas = new ArrayList<Image>();
	private Image imagemBackGround = Toolkit.getDefaultToolkit().getImage("Imagens/invblackjackBKG.png");
	Graphics g;
	
	public TelaDealerPanel()
	{
		setLayout(null);
	}
	
	public void desenhaCarta(String carta)
	{
		Image imagemCarta = null;
		
		try
		{
			imagemCarta = Toolkit.getDefaultToolkit().getImage("Imagens/"+carta+".png");
			
		}
		catch(Exception e) 
		{
			System.err.println("Imagem não encontrada!");
		}
		
		imagemCartas.add(imagemCarta);
		repaint();
		
	}
	
	private void desenhaFichas(Graphics g, int valor, int deslocamento)
	{
		Image imagemFicha = null;
		
		try
		{
			imagemFicha = Toolkit.getDefaultToolkit().getImage("Imagens/ficha"+valor+".png");
			
		}
		catch(Exception e) 
		{
			System.err.println("Ficha não encontrada!");
		}
		
		int posY = ALTURA - 100;
		g.drawImage(imagemFicha, 70 + deslocamento, posY, 50, 50, null);
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.drawImage(imagemBackGround, 0, 0, this);
			g.setColor(new Color(128,0,0));
			g.fillRect(5, 574, 170, 550);
			
			desenhaFichas(g, 1, 100);
			desenhaFichas(g, 5, 200);
			desenhaFichas(g, 10, 300);
			desenhaFichas(g, 20, 400);
			desenhaFichas(g, 50, 500);
			desenhaFichas(g, 100, 600);
			
			
			int panelWidth = getSize().width;
			int posX = panelWidth / 3 - 50;
			int posY = getSize().height / 2 - 50;
			
			for(Image img: imagemCartas) {
				if (panelWidth < posX + img.getWidth(null)){
					posX = panelWidth;
					posY += 60;
				}
				else {
					posX += 60;
				}
				
				g.drawImage(img, posX, posY, 50, 50, null);
			}
		
	}
}
