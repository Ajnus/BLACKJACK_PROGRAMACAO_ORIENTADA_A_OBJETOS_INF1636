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
	
	public void setNumeroDeCartas(int numero)
	{
		numeroDeCartas = numero;
		
	}
	
	public int getNumeroDeCartas()
	{
		return numeroDeCartas;
	}
	
	public void setCartasMao(Carta[] carta)
	{
		cartasMao = carta;
	}
	
	public Carta[] getCartasMao()
	{
		return cartasMao;
	}
	
}
