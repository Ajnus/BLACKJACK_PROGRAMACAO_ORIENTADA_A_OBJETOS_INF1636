package model;

public class Dealer {

	private Mao mao = new Mao();

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

}
