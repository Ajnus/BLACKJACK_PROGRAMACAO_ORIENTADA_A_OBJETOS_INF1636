package view;


public class Game {
	
	private final int LARGURA = 1200;
	private final int ALTURA = 700;

	public Game()
	{
		
		
		Tela1 tela1 = new Tela1(LARGURA, ALTURA);
		Window window = new Window("BlackJack", LARGURA, ALTURA);
		window.getContentPane().add(tela1);
		
		
		boolean ligado = true;
		while(ligado)
		{
			System.out.println("");
			if (tela1.getStateIniciar() == false)
			{
				ligado = false;
				
				window.setVisible(false);
			}
		}
		
		
		if (tela1.getStateIniciar() == false)
		{
			Tela2 tela2 = new Tela2(LARGURA, ALTURA);
			Window window2 = new Window("BlackJack", LARGURA, ALTURA);
			window2.getContentPane().add(tela2);
		}
	}
}
