package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Carta;
import model.Jogador;

public class CartaTest {

	@Test
	public void testCriarCarta() {
		// testa o método que cria uma carta.
		Carta carta = new Carta();
		Carta resultadoEsperado = carta.criarCarta("2k", "Copas", "2");
		assertEquals("2k", resultadoEsperado.getId());
		assertEquals("Copas", resultadoEsperado.getNaipe());
		assertEquals("2", resultadoEsperado.getValor());
	}
	
	@Test
	public void testSetId()
	{
		// testa o método que define a id da carta.
		Carta carta = new Carta();
		carta.setId("2K");
		String resultadoId = carta.getId();
		String resultadoEsperado = "2K";
		assertEquals(resultadoEsperado, resultadoId);
	}
	
	@Test
	public void testGetId()
	{
		// testa o método que captura a id da carta.
		Carta carta = new Carta();
		String resultadoEsperado = "2K";
		carta.setId("2K");
		String valorId = carta.getId();
		assertEquals(resultadoEsperado, valorId);	
	}
	
	@Test
	public void testSetNaipe()
	{
		// testa o método que define o naipe da carta.
		Carta carta = new Carta();
		carta.setNaipe("Copas");
		String resultadoNaipe = carta.getNaipe();
		String resultadoEsperado = "Copas";
		assertEquals(resultadoEsperado, resultadoNaipe);
	}
	
	@Test
	public void testGetNaipe()
	{
		// testa o método que captura o naipe da carta.
		Carta carta = new Carta();
		String resultadoEsperado = "Paus";
		carta.setNaipe("Paus");
		String valorNaipe = carta.getNaipe();
		assertEquals(resultadoEsperado, valorNaipe);	
	}
	
	@Test
	public void testSetValor()
	{
		// testa o método que difine o valor da carta.
		Carta carta = new Carta();
		carta.setValor("5");
		String resultadoValor = carta.getValor();
		String resultadoEsperado = "5";
		assertEquals(resultadoEsperado, resultadoValor);
	}
	
	@Test
	public void testGetValor()
	{
		// testa o método que captura o valor da carta.
		Carta carta = new Carta();
		String resultadoEsperado = "6";
		carta.setValor("6");
		String valor = carta.getValor();
		assertEquals(resultadoEsperado, valor);	
	}

}
