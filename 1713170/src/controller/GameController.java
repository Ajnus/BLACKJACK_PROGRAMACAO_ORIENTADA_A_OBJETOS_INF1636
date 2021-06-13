package controller;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Observer.Observer;
import model.Carta;
import model.Dealer;
import view.TelaDealer;
import view.TelaInicio;
import view.CartaPanel;

public class GameController implements Observer {

	private final int LARGURA = 900;
	private final int ALTURA = 700;
	TelaDealer telaDealer;
	private Dealer dealer;

	private int numeroJogadores;
	public int jogadorAtual;
	public ArrayList<JogadorController> jogadoresController;
	Carta carta = new Carta();
	List<Carta> deck = carta.criarBaralho();
	List<Image> deckImage = CartaPanel.criaImagemCarta(deck);

	// Singleton
	private static final GameController instanciaGameController = new GameController();

	public static GameController getInstancia() {
		return instanciaGameController;
	}

	private GameController() {
		TelaInicio telaInicial = new TelaInicio(this, LARGURA, ALTURA);
		telaInicial.setVisible(true);
	}

	public void inicializaGame(int numeroJogadores) {
		dealer = new Dealer();
		telaDealer = new TelaDealer(LARGURA, ALTURA); 
		telaDealer.setListeners(this);
		telaDealer.adicionaObservador(this);
		telaDealer.setVisible(true);

		this.numeroJogadores = numeroJogadores;
		jogadorAtual = -1;
		jogadoresController = new ArrayList<JogadorController>();
		for (int i = numeroJogadores - 1; i >= 0; i--)
			jogadoresController.add(new JogadorController(i + 1));

		proximoJogadorAposta();
	}

	public void proximoJogadorAposta() {
		jogadorAtual++;
		if (jogadorAtual == numeroJogadores) {
			jogadorAtual = 0;
		}

	}

	public void finalizarRodada() {

	}

	public Carta retiraCarta() {
		if (deck.isEmpty())
			return null;
		return deck.remove(0);
	}

	public void embaralhaDeck() {
		Collections.shuffle(deck);
	}

	public static List<Integer> calculaPontos(List<Carta> cartas) {
		int pontos1 = 0;
		int pontos2 = 0;
		List<Integer> pontos = new ArrayList<>();
		for (Carta carta : cartas) {
			if (carta.getValor() == "J" || carta.getValor() == "Q" || carta.getValor() == "K") {
				pontos1 = pontos1 + 10;
				pontos2 = pontos2 + 10;
			} else if (carta.getValor().equals("A")) {
				pontos1 = (pontos1 + 11 > 21) ? pontos1 + 1 : pontos1 + 11;
				pontos2 = pontos2 + 1;
			} else {
				pontos1 = pontos1 + Integer.parseInt(carta.getValor());
				pontos2 = pontos2 + Integer.parseInt(carta.getValor());
			}
		}
		pontos.add(pontos1);
		pontos.add(pontos2);

		return pontos;
	}

	public void fechar() {
		System.exit(0);
	}

	@Override
	public void update(int valor) {
		if (jogadoresController.get(jogadorAtual).getJogadorFichas() == 0)
			System.out.println("ok não");

		jogadoresController.get(jogadorAtual).aposta(valor);
		// System.out.println("ok");
	}
}
