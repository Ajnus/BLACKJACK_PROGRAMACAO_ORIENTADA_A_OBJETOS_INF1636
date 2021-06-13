package controller;

import Observer.Observer;
import model.Carta;
import model.Jogador;
import view.TelaJogador;
import view.TelaInicio;

public class JogadorController implements Observer {
	private static GameController game = GameController.getInstancia();
	private final int LARGURA = 900;
	private final int ALTURA = 700;
	private TelaJogador telaJogador;
	private Jogador jogador;

	public JogadorController(int id) {
		jogador = new Jogador(id);
		telaJogador = new TelaJogador(LARGURA, ALTURA);
		telaJogador.setListeners(this);
		telaJogador.adicionaObservador(this);
		telaJogador.updateLabelFicha(jogador.getAposta(), jogador.getTotalFichas());
		telaJogador.setVisible(true);
	}

	public int getJogadorFichas() {
		return jogador.getTotalFichas();
	}

	public void aposta(int valorFicha) {
		if (jogador.getTotalFichas() >= 0 && valorFicha <= jogador.getTotalFichas()) {
			jogador.adicionarAposta(valorFicha);
			telaJogador.updateLabelFicha(jogador.getAposta(), jogador.getTotalFichas());
		} else if (jogador.getAposta() < jogador.getTotalFichas())
			telaJogador.mensagemErro("Aposta menor que o total de fichas!");
	}

	public void fimAposta() {
		if (jogador.getAposta() == 0) {
			telaJogador.mensagemErro("voce tem que pelo menos apostar uma ficha!");
			System.out.println("voce tem que pelo menos apostar uma ficha!");
		} else {
			// desabilitar botao de aposta
			game.proximoJogadorAposta();
		}
	}

	public void render() {
		setResultado(5); // render
		if (jogador.getState() == 3) // jogando
		{
			game.finalizarRodada();
		} else {
			game.proximoJogadorAposta();
		}
	}

	public void joga() {
		jogador.setState(3);
		// desabilita os botoes do jogador
	}

	public void setResultado(int resultado) {
		jogador.setState(resultado);
		if (resultado == 1) {
			if (jogador.getPontos() == 21) {
				jogador.adicionarNovasFichas((5 * jogador.getAposta()) / 2);
			} else {
				jogador.adicionarNovasFichas(2 * jogador.getAposta());
			}
		}
	}

	public void setJogadorState(int state) {
		jogador.setState(state);
	}

	@Override
	public void update(int valorAposta) {
		aposta(valorAposta);
		fimAposta();
		System.out.printf("valor da aposta: %d\n", valorAposta);
	}

}
