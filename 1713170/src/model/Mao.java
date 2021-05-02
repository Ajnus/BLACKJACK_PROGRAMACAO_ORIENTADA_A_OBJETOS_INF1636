package model;

public class Mao {
	
	private Carta[] cartasMao = new Carta[21];
	private int numeroDeCartas = 0;
	
	
	public void adicionarCarta(Carta carta)
	{
		cartasMao[numeroDeCartas++] = carta;
	}
	
	public void esvaziarMao()
	{
		numeroDeCartas = 0;
	}
	
	
	public int getNumeroDeCartas()
	{
		return numeroDeCartas;
	}
	
}
