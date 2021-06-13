package view;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JPanel;

public class TelaJogadorPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	int LARGURA = 900;
	int ALTURA = 700;
	public ArrayList<Image> imagemFichas = new ArrayList<Image>();
	private int[] numFichas = { 1, 5, 10, 20, 50, 100 };
	private Image imagemBackGround = Toolkit.getDefaultToolkit().getImage("Imagens/blackjack.png");
	Graphics g;

	public TelaJogadorPanel()
	{
		setLayout(null);
		Image imagemFicha = null;
		for (int i = 0; i < 6; i++)
		{
			try
			{
				imagemFicha = Toolkit.getDefaultToolkit().getImage("Imagens/ficha "+numFichas[i]+"$.png");
				System.out.printf("carregou ficha %d$.png\n", numFichas[i]);
				
			}
			catch(Exception e) 
			{
				System.err.println("Ficha não encontrada!");
			}
			
			imagemFichas.add(imagemFicha);
			
		}
		
		
	}

	public void desenhaFichas(Graphics g, int valor, int idJogador) {
		int i=0;
		int deslocamentoY = 0;
		//imagemFichas.add(imagemFicha);
		
		switch (valor)
		{
		     case 1:
		    	 i = 0;
		    	 break;
		     case 5:
		    	 i = 1;
		    	 break;
		     case 10:
		    	 i = 2;
		    	 break;
		     case 20:
		    	 i = 3;
		    	 break;
		     case 50:
		    	 i = 4;
		    	 break;
		     case 100:
		    	 i = 5;
		    	 break;
		     default:
		    	 break;
		}
		
		switch (idJogador)
		{
		     case 1:
		    	 deslocamentoY = 0;
		    	 break;
		     case 2:
		    	 deslocamentoY = 60;
		    	 break;
		     case 3:
		    	 deslocamentoY = 120;
		    	 break;
		     case 4:
		    	 deslocamentoY = 180;
		    	 break;
		     default:
		    	 break;
		}
		
		//imagemFichas.get
		Image imagemFicha = imagemFichas.get(i);
		
		/*g.clearRect(70 + deslocamento, posY, 50, 50);
		try {
			TimeUnit.MILLISECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		g.drawImage(imagemFicha, LARGURA-80, 117+deslocamentoY, 50, 50, null);
		System.out.println("imprimiu?");

	}

	@Override
	public void paintComponent(Graphics g) {
		try {
			g.drawImage(imagemBackGround, 0, 0, this);
			g.setColor(new Color(17, 68, 26));
			g.fillRect(5, 520, 170, 550);

			/*
			 * desenhaFichas(g, 1, 100); desenhaFichas(g, 5, 200); desenhaFichas(g, 10,
			 * 300); desenhaFichas(g, 20, 400); desenhaFichas(g, 50, 500); desenhaFichas(g,
			 * 100, 600);
			 */

		} catch (Exception e) {
			System.err.println("Imagem não encontrada!");
		}
	}
}
