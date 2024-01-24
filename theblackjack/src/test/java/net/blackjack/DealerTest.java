package net.blackjack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import net.blackjack.model.Carta;
import net.blackjack.model.Dealer;

public class DealerTest {

	@Test
	public void testAdicionarCarta() {
		// m�oto que adiciona carta ao dealer.
		Dealer dealer = new Dealer();
		Carta carta = new Carta();
		dealer.adicionarCarta(carta);
		int valorEsperado = 1;
		int numeroCartasDealer = dealer.getMao().getNumeroDeCartas();
		assertEquals(valorEsperado, numeroCartasDealer);
	}

	@Test
	public void testEsvaziarMao() {
		// m�todo que testa se a m�o do dealer est� vazia.
		Dealer dealer = new Dealer();
		Carta carta = new Carta();
		dealer.getMao().adicionarCarta(carta);
		dealer.esvaziarMao();
		int numeroCartasDealer = dealer.getMao().getNumeroDeCartas();
		assertEquals(0, numeroCartasDealer);
	}
}
