package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Carta;
import model.Mao;

public class MaoTest {

	@Test
	public void testAdicionarCarta() {
		// testa o método que adiciona a carta na mão do jogador.
		Mao mao = new Mao();
		Carta carta = new Carta();
		mao.adicionarCarta(carta);
		int valorEsperado = 1;
		assertEquals(valorEsperado, mao.getNumeroDeCartas());
	}

	@Test
	public void testEsvaziarMao() {
		// testa o método que esvazia a mão do jogador.
		Mao mao = new Mao();
		Carta carta = new Carta();
		mao.adicionarCarta(carta);
		mao.esvaziarMao();
		assertEquals(0, mao.getNumeroDeCartas());
	}

	@Test
	public void setNumeroDeCartas() {
		// testa o método que setta o número de cartas na mão do jogador.
		Mao mao = new Mao();
		assertEquals(0, mao.getNumeroDeCartas());
	}

	@Test
	public void testGetNumeroDeCartas() {
		// testa o método que pega o número de cartas na mão do jogador.
		Mao mao = new Mao();
		int valorNumeroDeCartas = mao.getNumeroDeCartas();
		assertEquals(0, valorNumeroDeCartas);
	}

	@Test
	public void testSetCartasMao() {
		// testa o método que setta as cartas que estão na mão do jogador.
		Mao mao = new Mao();
		Carta[] cartas = new Carta[2];
		cartas[0] = new Carta();
		cartas[1] = new Carta();
		cartas[0].criarCarta("2K", "Ouro", "2");
		cartas[1].criarCarta("3K", "Copas", "3");
		mao.adicionarCarta(cartas[0]);
		mao.adicionarCarta(cartas[1]);
		mao.setCartasMao(cartas);
		assertEquals(cartas[0], mao.getCartasMao()[0]);
		assertEquals(cartas[1], mao.getCartasMao()[1]);
	}

	@Test
	public void testGetCartasMao() {
		// testa o método que pega as cartas que estão na mão do jogador.
		Mao mao = new Mao();
		Carta[] cartas = new Carta[2];
		cartas[0] = new Carta();
		cartas[1] = new Carta();
		cartas[0].criarCarta("2K", "Ouro", "2");
		cartas[1].criarCarta("3K", "Copas", "3");
		mao.adicionarCarta(cartas[0]);
		mao.adicionarCarta(cartas[1]);
		assertEquals(cartas[0], mao.getCartasMao()[0]);
		assertEquals(cartas[1], mao.getCartasMao()[1]);
	}
}
