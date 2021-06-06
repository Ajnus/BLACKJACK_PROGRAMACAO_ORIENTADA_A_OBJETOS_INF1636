package view;

import java.util.Scanner;

import model.Jogador;

public class Game {
	private final int LARGURA = 1200;
	private final int ALTURA = 700;

	public Game() {
		Jogador[] jogadores;
		Scanner n = new Scanner(System.in);
		String nomes;
		TelaInicio telaInicio = new TelaInicio(LARGURA, ALTURA);
		Window windowInicio = new Window("BlackJack", LARGURA, ALTURA);
		windowInicio.getContentPane().add(telaInicio);
		boolean ligado = true;
		
		jogadores = new Jogador[4];

		for (int i = 0; i < 4; i++) {
			System.out.println("Nome do jogador " + (i + 1) + ':');
			nomes = n.next();
			jogadores[i] = new Jogador(i + 1);
			jogadores[i].setNome(nomes);
		}

		for (int i = 0; i < 4; i++) {
			System.out.println("Jogador: " + jogadores[i].getNome());
			System.out.println("Codigo: " + jogadores[i].getId());
			System.out.println("Saldo: " + jogadores[i].getSaldo());
		}
		
		while (ligado) {
			System.out.println("");
			if (telaInicio.getStateIniciar() == false) {
				ligado = false;

				windowInicio.setVisible(false);
			}
		}

		if (telaInicio.getStateIniciar() == false) {
			TelaJogador telaJogador = new TelaJogador(LARGURA, ALTURA, jogadores);
			Window windowJogador = new Window("BlackJack", LARGURA, ALTURA);
			windowJogador.getContentPane().add(telaJogador);

			TelaDealer telaDealer = new TelaDealer(LARGURA, ALTURA);
			Window windowDealer = new Window("BlackJack", LARGURA, ALTURA);
			windowDealer.getContentPane().add(telaDealer);
		}
	}
}
