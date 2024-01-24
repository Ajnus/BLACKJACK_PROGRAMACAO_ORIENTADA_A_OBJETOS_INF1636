package net.blackjack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import net.blackjack.model.Carta;
import net.blackjack.model.Jogador;

public class CartaTest {

	@Test
	public void testCriarCarta() {
		// testa o m�todo que cria uma carta.
		Carta carta = new Carta();
		Carta resultadoEsperado = carta.criarCarta("2k", "Copas", "2");
		assertEquals("2k", resultadoEsperado.getId());
		assertEquals("Copas", resultadoEsperado.getNaipe());
		assertEquals("2", resultadoEsperado.getValor());
	}

	@Test
	public void testSetId() {
		// testa o m�todo que define a id da carta.
		Carta carta = new Carta();
		carta.setId("2K");
		String resultadoId = carta.getId();
		String resultadoEsperado = "2K";
		assertEquals(resultadoEsperado, resultadoId);
	}

	@Test
	public void testGetId() {
		// testa o m�todo que captura a id da carta.
		Carta carta = new Carta();
		String resultadoEsperado = "2K";
		carta.setId("2K");
		String valorId = carta.getId();
		assertEquals(resultadoEsperado, valorId);
	}

	@Test
	public void testSetNaipe() {
		// testa o m�todo que define o naipe da carta.
		Carta carta = new Carta();
		carta.setNaipe("Copas");
		String resultadoNaipe = carta.getNaipe();
		String resultadoEsperado = "Copas";
		assertEquals(resultadoEsperado, resultadoNaipe);
	}

	@Test
	public void testGetNaipe() {
		// testa o m�todo que captura o naipe da carta.
		Carta carta = new Carta();
		String resultadoEsperado = "Paus";
		carta.setNaipe("Paus");
		String valorNaipe = carta.getNaipe();
		assertEquals(resultadoEsperado, valorNaipe);
	}

	@Test
	public void testSetValor() {
		// testa o m�todo que difine o valor da carta.
		Carta carta = new Carta();
		carta.setValor("5");
		String resultadoValor = carta.getValor();
		String resultadoEsperado = "5";
		assertEquals(resultadoEsperado, resultadoValor);
	}

	@Test
	public void testGetValor() {
		// testa o m�todo que captura o valor da carta.
		Carta carta = new Carta();
		String resultadoEsperado = "6";
		carta.setValor("6");
		String valor = carta.getValor();
		assertEquals(resultadoEsperado, valor);
	}
}
