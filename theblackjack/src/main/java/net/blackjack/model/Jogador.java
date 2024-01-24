package net.blackjack.model;


//Betting(2), Playing(3), Waiting(4), Surrendered(5), Broke(6),
//Won(1), Lost(-1), Draw(0);


public class Jogador {
	private int id;
	private String nome;
	private int aposta;
	private int totalFichas;
	private int pontos;
	private int state;
	private Mao mao;

	public Jogador(int id) {
		this.id = id;
		totalFichas = 500;
		pontos = 0;
		state = 2;
		mao = new Mao();
	}

	public void adicionarCarta(Carta carta) {
		mao.adicionarCarta(carta);
	}

	public void adicionarAposta(int novaAposta) {
		aposta += novaAposta;
		//totalFichas -= novaAposta;
	}

	public boolean verificarAposta() {
		if (aposta >= 20 && aposta <= 100)
			return true;
		return false;
	}

	public void removerAposta() {
		totalFichas -= aposta;
		aposta = 0;
	}

	public void esvaziarMao() {
		mao.esvaziarMao();
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public Mao getMao() {
		return mao;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setAposta(int aposta) {
		this.aposta = aposta;
	}

	public int getAposta() {
		return aposta;
	}

	public void setTotalFichas(int saldo) {
		this.totalFichas = saldo;
	}

	public int getTotalFichas() {
		return totalFichas;
	}
	
	public void setPontos(int pontos)
	{
		this.pontos = pontos;
	}
	
	public int getPontos()
	{
		return pontos;
	}
	
	public void adicionarPontos(int pontos)
	{
		this.pontos += pontos;
	}
	
	public void adicionarNovasFichas(int fichas)
	{
		totalFichas += fichas;
		aposta = 0;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getState() {
		return state;
	}

}
