package net.blackjack.model;

import java.util.ArrayList;

public class Dealer {

	private int id;
	private Mao mao;
	public ArrayList<Carta> cartas;
	private boolean state;
	private int pontos;

	public Dealer()
	{
		Carta c = new Carta();
		cartas = c.criarBaralho();
		pontos = 0;
	}
	
	public void adicionarCarta(Carta carta) {
		if (mao.getNumeroDeCartas() <= 17)
			mao.adicionarCarta(carta);
	}

	public void esvaziarMao() {
		mao.esvaziarMao();
	}

	public Mao getMao() {
		return mao;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setPontos(int pontos)
	{
		this.pontos = pontos;
	}
	
	public int getPontos()
	{
		return pontos;
	}

}
