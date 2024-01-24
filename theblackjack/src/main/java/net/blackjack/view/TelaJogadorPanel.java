package net.blackjack.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import org.imgscalr.Scalr;
import java.awt.MediaTracker;

public class TelaJogadorPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	int LARGURA = 900;
	int ALTURA = 700;
	public ArrayList<Image> imagemFichas = new ArrayList<Image>();
	private int[] numFichas = { 1, 5, 10, 20, 50, 100 };
	// ImageObserver obsere
	private Image imagemBackground = Toolkit.getDefaultToolkit().getImage("theblackjack/Imagens/blackjack.png");

	// Criar um MediaTracker para aguardar o carregamento da imagem
	MediaTracker mediaTracker = new MediaTracker(new java.awt.Component(){});

	private BufferedImage bufferedImagemBackground;
    private BufferedImage redimensionedBackground;

	/*BufferedImage simpleResizeImage(BufferedImage imagemBackGround, int larguraDesejada)
	 throws Exception {
		return Scalr.resize(imagemBackGround, larguraDesejada);
	}*/
	

	public TelaJogadorPanel() {
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
			System.err.println("TELAJOGADORPANEL: Erro durante a inicialização da imagem: " + e.getMessage());
			e.printStackTrace(); // Isso imprimirá o rastreamento da pilha para que você possa ver exatamente onde ocorreu o erro.ASS
		}




		Image imagemFicha = null;
		// super.paintComponents(g);
		for (int i = 0; i < 6; i++) {
			try {
				imagemFicha = Toolkit.getDefaultToolkit().getImage("Imagens/ficha " + numFichas[i] + "$.png");
				System.out.printf("carregou ficha %d$.png\n", numFichas[i]);

			} catch (Exception e) {
				System.err.println("Ficha não encontrada!");
			}

			imagemFichas.add(imagemFicha);

		}
	}

	// necess�rio para renderizar sem 2 cliques
	public void preDesenhaFichas(Graphics g, int idJogador) {
		desenhaFichas(g, 1, idJogador);
		desenhaFichas(g, 5, idJogador);
		desenhaFichas(g, 10, idJogador);
		desenhaFichas(g, 20, idJogador);
		desenhaFichas(g, 50, idJogador);
		desenhaFichas(g, 100, idJogador);
	}

	public void desenhaFichas(Graphics g, int valor, int idJogador) {
		int i = 0;
		int deslocamentoY = 0;
		// imagemFichas.add(imagemFicha);

		switch (valor) {
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

		switch (idJogador) {
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

		Image imagemFicha = this.imagemFichas.get(i);
		g.drawImage(imagemFicha, LARGURA - 80, 117 + deslocamentoY, null);
		System.out.println("imprimiu?");

	}

	@Override
	public void paintComponent(Graphics g) {

		// Ajusta a escala da imagem para corresponder às dimensões da janela
		//Image scaledImage = imagemBackGround.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);

		
		//final Image img = ...;
        /*ComponentListener cl = new ComponentAdapter() {
            public void componentResized(ComponentEvent ce) {
                Component c = ce.getComponent();
                Image scaledImage = imagemBackGround.getScaledInstance(c.getWidth(), c.getHeight(), Image.SCALE_SMOOTH);
*/
				try {
					g.drawImage(redimensionedBackground, 0, 0, this);
					g.setColor(new Color(17, 68, 26));
					g.fillRect(5, 520, 170, 550);
		
				} catch (Exception e) {
					System.err.println("Erro ao desenhar a imagem redimensionada: " + e.getMessage());
				}
           // }
//};
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
