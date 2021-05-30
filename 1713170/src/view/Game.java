package view;

public class Game {
	private final int LARGURA = 1200;
	private final int ALTURA = 700;

	public Game() {
		TelaInicio telaInicio = new TelaInicio(LARGURA, ALTURA);
		Window windowInicio = new Window("BlackJack", LARGURA, ALTURA);
		windowInicio.getContentPane().add(telaInicio);
		boolean ligado = true;
		while (ligado) {
			System.out.println("");
			if (telaInicio.getStateIniciar() == false) {
				ligado = false;

				windowInicio.setVisible(false);
			}
		}

		if (telaInicio.getStateIniciar() == false) {
			TelaJogador telaJogador = new TelaJogador(LARGURA, ALTURA);
			Window windowJogador = new Window("BlackJack", LARGURA, ALTURA);
			windowJogador.getContentPane().add(telaJogador);

			TelaDealer telaDealer = new TelaDealer(LARGURA, ALTURA);
			Window windowDealer = new Window("BlackJack", LARGURA, ALTURA);
			windowDealer.getContentPane().add(telaDealer);
		}
	}
}
