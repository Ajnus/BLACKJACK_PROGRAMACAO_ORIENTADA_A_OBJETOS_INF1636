package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Carta;
import model.Dealer;

public class DealerTest {

	
	@Test
	public void testAdicionarCarta()
	{
		// méoto que adiciona carta ao dealer.
		Dealer dealer = new Dealer();
		Carta carta = new Carta();
		dealer.adicionarCarta(carta);
		int valorEsperado = 1;
		int numeroCartasDealer = dealer.getMao().getNumeroDeCartas();
		assertEquals(valorEsperado, numeroCartasDealer);
	}
	
	@Test
	public void testEsvaziarMao() {
		// método que testa se a mão do dealer está vazia.
		Dealer dealer = new Dealer();
		Carta carta = new Carta();
		dealer.getMao().adicionarCarta(carta);
		dealer.esvaziarMao();
		int numeroCartasDealer = dealer.getMao().getNumeroDeCartas();
		assertEquals(0, numeroCartasDealer);
	}

}
