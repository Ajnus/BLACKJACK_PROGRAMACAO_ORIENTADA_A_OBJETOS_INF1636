/*
 * @authors Jam Ajna, Luan Ferreira e Paulo Rodrigues
 */

package model;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args)
	{
		Jogador[] jogadores;
		Scanner n = new Scanner(System.in);
		String nomes; 
		
		jogadores = new Jogador[4];
		
		for (int i = 0; i < 4; i++)
		{
			System.out.println("Nome do jogador " + (i+1) + ':');
			nomes = n.next();
			jogadores[i] = new Jogador(i+1);
			jogadores[i].setNome(nomes);
		}
		
		
		
		for (int i = 0; i < 4; i++)
		{
			System.out.println("Jogador: " + jogadores[i].getNome());
			System.out.println("Codigo: " + jogadores[i].getId());
			System.out.println("Saldo: " + jogadores[i].getSaldo());
		}
		
		Carta carta = new Carta();
		System.out.println(carta.criarBaralho());
	}
}
