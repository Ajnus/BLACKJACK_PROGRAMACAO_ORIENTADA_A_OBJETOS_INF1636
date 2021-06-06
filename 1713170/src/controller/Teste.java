package controller;

import model.Jogador;

public class Teste {
	
	public Teste() {
	}
	
	public String exibeSaldo(Jogador jogador) {
		String saldo = String.valueOf(jogador.getSaldo());
		return saldo;
	}

}