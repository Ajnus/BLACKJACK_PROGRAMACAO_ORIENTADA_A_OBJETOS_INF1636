package model;

public class Jogador {
	private String nome;
	private int id;
	private int valorAposta;
	private Mao mao;
	private boolean state;
	private int saldo; 
	
	// Cria objeto jogador
	public Jogador()
	{
		saldo = 500;
		mao = new Mao();
		state = true; 
	}	
	
	// Seta o nome do jogador
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	// Pega o nome do jogador
	public String getNome()
	{
		return nome;
	}
	
	// Pega o id do jogador
	public int getId()
	{
		return id;
	}
	
	// Seta o valor da aposta
	public void setValorAposta(int valorAposta)
	{
		this.valorAposta = valorAposta;
	}
	
	// Pega o valor da aposta
	public int getValorAposta()
	{
		return valorAposta;
	}
	
	// Seta o estado do jogador
	public void setState()
	{
		state = !state;
	}
	
	// Pega o estado do jogador
	boolean getState()
	{
		return state;
	}
}
