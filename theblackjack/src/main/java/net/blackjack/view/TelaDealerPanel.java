package net.blackjack.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;


import javax.swing.JPanel;

import java.awt.image.BufferedImage;
import org.imgscalr.Scalr;
import java.awt.MediaTracker;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;


public class TelaDealerPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	int LARGURA = 900;
	int ALTURA = 700;
	public ArrayList<Image> imagemCartas = new ArrayList<Image>();
	private Image imagemBackground = Toolkit.getDefaultToolkit().getImage("theblackjack/Imagens/invblackjackBKG.png");

	// Criar um MediaTracker para aguardar o carregamento da imagem
	MediaTracker mediaTracker = new MediaTracker(new java.awt.Component(){});

	private BufferedImage bufferedImagemBackground;
    private BufferedImage redimensionedBackground;

	/*BufferedImage simpleResizeImage(BufferedImage imagemBackGround, int targetWidth) throws Exception {
		return Scalr.resize(imagemBackGround, targetWidth);
	}*/
	//Graphics g;
	
	public TelaDealerPanel()
	{
		setLayout(null);


		// Adicionar a imagem ao MediaTracker
		mediaTracker.addImage(imagemBackground, 0);

		try {

			// Aguardar o carregamento completo da imagem
			mediaTracker.waitForAll();
		
			// Convertendo Image para BufferedImage
			bufferedImagemBackground = toBufferedImage(imagemBackground);

			// Verificando as dimensões da imagem original
			int larguraOriginal = verificarDimensoes(bufferedImagemBackground, "largura");
			int alturaOriginal = verificarDimensoes(bufferedImagemBackground, "altura");

			if (larguraOriginal > 0 && alturaOriginal > 0) {
                // Redimensionar para a largura desejada
                BufferedImage resizedWidth = Scalr.resize(bufferedImagemBackground, Scalr.Method.QUALITY,
                        Scalr.Mode.FIT_TO_WIDTH, larguraOriginal, Scalr.OP_ANTIALIAS);

                // Redimensionar para a altura desejada
                redimensionedBackground = Scalr.resize(resizedWidth, Scalr.Method.QUALITY,
                        Scalr.Mode.FIT_TO_HEIGHT, alturaOriginal, Scalr.OP_ANTIALIAS);
            }

			 // Adicionar um ouvinte de evento para redimensionar a imagem quando a janela for redimensionada
			 addComponentListener(new ComponentAdapter() {
				@Override
				public void componentResized(ComponentEvent e) {
					redimensionedBackground = Scalr.resize(bufferedImagemBackground, getWidth(), getHeight());
					repaint(); // Redesenha a imagem após a redimensionamento da janela
				}
			});

		} catch (Exception e) {
			System.err.println("TELADEALERPANEL: Erro durante a inicialização da imagem: " + e.getMessage());
			e.printStackTrace(); // Isso imprimirá o rastreamento da pilha para que você possa ver exatamente onde ocorreu o erro.ASS
		}

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
			//super.paintComponent(g);

			// Ajusta a escala da imagem para corresponder às dimensões da janela
			//Image scaledImage = imagemBackGround.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
			
			g.drawImage(redimensionedBackground, 0, 0, this);
			g.setColor(new Color(128,0,0));
			g.fillRect(5, 574, 170, 550);
			
			/*desenhaFichas(g, 1, 100);
			desenhaFichas(g, 5, 200);
			desenhaFichas(g, 10, 300);
			desenhaFichas(g, 20, 400);
			desenhaFichas(g, 50, 500);
			desenhaFichas(g, 100, 600);*/
			
			
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

	// Método para converter Image para BufferedImage
    private static BufferedImage toBufferedImage(Image image) {
        if (image instanceof BufferedImage) {
			System.out.println("Entrou no IF");
            return (BufferedImage) image;
        }

		//System.out.println(image.getWidth(null));
		//System.out.println(image.getHeight(null));

        // Cria uma BufferedImage com o mesmo tamanho e tipo da Image
        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Desenha a Image na BufferedImage
        bufferedImage.getGraphics().drawImage(image, 0, 0, null);

        return bufferedImage;
    }

	private int verificarDimensoes(BufferedImage imagem, String dimensao) {
		if (dimensao == "largura")
		{
			int largura = imagem.getWidth();

			if (largura <= 0) {
				System.out.println("As dimensões da imagem não são válidas.");
			}
			else{
				System.out.println("LARGURA:");
				System.out.println(largura);
			}

			return largura;
		}
		else if (dimensao == "altura")
		{
			int altura = imagem.getWidth();

			if (altura <= 0) {
				System.out.println("As dimensões da imagem não são válidas.");
			}
			else{
				System.out.println("ALTURA:");
				System.out.println(altura);
			}

			return altura;
		}

		return 0;
	}
}
