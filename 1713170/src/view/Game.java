package view;

import java.awt.Point;

//import java.util.Scanner;

import model.Jogador;

public class Game {
	private final int LARGURA = 1200;
	private final int ALTURA = 700;

	public Game() {
		Jogador[] jogadores = new Jogador[4];
		// Scanner n = new Scanner(System.in);
		String[] nomes = { "Jam", "Luan", "Paulo", "GBG" };
		TelaInicio telaInicio = new TelaInicio(LARGURA, ALTURA);
		Window windowInicio = new Window("BlackJack", LARGURA, ALTURA);
		windowInicio.getContentPane().add(telaInicio);
		boolean ligado = true;

		// jogadores = ;

		for (int i = 0; i < 4; i++) {
			System.out.println("Nome do jogador " + (i + 1) + ':');
			// nomes = n.next();
			jogadores[i] = new Jogador(i + 1);
			jogadores[i].setNome(nomes[i]);
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
			telaJogador.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent evt) {
					System.out.println("mouseClicked");
					Point p = evt.getPoint();
					System.out.printf("X: %d, Y: %d\n", p.x, p.y);

					// FICHAS
					if ((p.x >= 752 && p.x <= 787) && (p.y >= 597 && p.y <= 627)) {
						System.out.println("FICHA 1");
						//if (jogadores[0].verificarAposta())
							jogadores[0].adicionarAposta(1);
						System.out.printf("Valor aposta: %d\n", jogadores[0].getAposta());
						System.out.printf("Valor saldo: %d\n", jogadores[0].getSaldo());
						telaJogador.apostaLabel.setText(String.valueOf(jogadores[0].getAposta()));
						telaJogador.saldoLabel.setText(String.valueOf(jogadores[0].getSaldo()));
					}

					else if ((p.x >= 797 && p.x <= 828) && (p.y >= 597 && p.y <= 627)) {
						System.out.println("FICHA 5");
						//if (jogadores[0].verificarAposta())
							jogadores[0].adicionarAposta(5);
						System.out.printf("Valor aposta: %d\n", jogadores[0].getAposta());
						System.out.printf("Valor saldo: %d\n", jogadores[0].getSaldo());
						telaJogador.apostaLabel.setText(String.valueOf(jogadores[0].getAposta()));
						telaJogador.saldoLabel.setText(String.valueOf(jogadores[0].getSaldo()));
					}

					else if ((p.x >= 837 && p.x <= 870) && (p.y >= 597 && p.y <= 627)) {
						System.out.println("FICHA 10");
						//if (jogadores[0].verificarAposta())
							jogadores[0].adicionarAposta(10);
						System.out.printf("Valor aposta: %d\n", jogadores[0].getAposta());
						System.out.printf("Valor saldo: %d\n", jogadores[0].getSaldo());
						telaJogador.apostaLabel.setText(String.valueOf(jogadores[0].getAposta()));
						telaJogador.saldoLabel.setText(String.valueOf(jogadores[0].getSaldo()));
					}

					else if ((p.x >= 750 && p.x <= 782) && (p.y >= 633 && p.y <= LARGURA)) {
						System.out.println("FICHA 20");
						//if (jogadores[0].verificarAposta())
							jogadores[0].adicionarAposta(20);
						System.out.printf("Valor aposta: %d\n", jogadores[0].getAposta());
						System.out.printf("Valor saldo: %d\n", jogadores[0].getSaldo());
						telaJogador.apostaLabel.setText(String.valueOf(jogadores[0].getAposta()));
						telaJogador.saldoLabel.setText(String.valueOf(jogadores[0].getSaldo()));
					}

					else if ((p.x >= 797 && p.x <= 828) && (p.y >= 633 && p.y <= LARGURA)) {
						System.out.println("FICHA 50");
						//if (jogadores[0].verificarAposta())
							jogadores[0].adicionarAposta(50);
						System.out.printf("Valor aposta: %d\n", jogadores[0].getAposta());
						System.out.printf("Valor saldo: %d\n", jogadores[0].getSaldo());
						telaJogador.apostaLabel.setText(String.valueOf(jogadores[0].getAposta()));
						telaJogador.saldoLabel.setText(String.valueOf(jogadores[0].getSaldo()));
					}

					else if ((p.x >= 844 && p.x <= 877) && (p.y >= 633 && p.y <= LARGURA)) {
						System.out.println("FICHA 100");
						//if (jogadores[0].verificarAposta())
							jogadores[0].adicionarAposta(100);
						System.out.printf("Valor aposta: %d\n", jogadores[0].getAposta());
						System.out.printf("Valor saldo: %d\n", jogadores[0].getSaldo());
						telaJogador.apostaLabel.setText(String.valueOf(jogadores[0].getAposta()));
						telaJogador.saldoLabel.setText(String.valueOf(jogadores[0].getSaldo()));
					}
				}
			});

			Window windowJogador = new Window("BlackJack", LARGURA, ALTURA);
			windowJogador.getContentPane().add(telaJogador);

			/*
			 * TelaDealer telaDealer = new TelaDealer(LARGURA, ALTURA); Window windowDealer
			 * = new Window("BlackJack", LARGURA, ALTURA);
			 * windowDealer.getContentPane().add(telaDealer);
			 */
		}
	}
}
