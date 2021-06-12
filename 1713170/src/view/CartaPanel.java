package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JPanel;

public class CartaPanel extends JPanel{
 static final long serialVersionUID = 1L;
	public ArrayList<Image> imagemCartas = new ArrayList<Image>();
	
	
	public void desenhaCarta(String carta)
	{
		Image imagemCarta = null;
		
		try {
			imagemCarta = Toolkit.getDefaultToolkit().getImage("Imagens/"+carta+".png");;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		imagemCartas.add(imagemCarta);
		repaint();
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int panelSize = getSize().width;
		int posX = -50;
		int posY = 180;
		
		for(Image img: imagemCartas) {
			if (panelSize < posX + img.getWidth(null)){
				posX = 10;
				posY += 60;
			}
			else {
				posX += 60;
			}
			
			g.drawImage(img, posX, posY, 50, 50, null);
		}
	}
	
	
}
