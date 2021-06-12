package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Carta;
import model.Jogador;

public class JogadorTest {

	@Test
	public void testAdicionarMao() {
		// testa se foi adicionado carta na m�o do jogador.
		Jogador jogador = new Jogador(1);
		Carta carta = new Carta();
		jogador.adicionarCarta(carta);
		int resultadoEsperado = 1;
		assertEquals(resultadoEsperado, jogador.getMao().getNumeroDeCartas());
	}

	@Test
	public void testEsvaziarMao() {
		// testa se a m�o do jogador est� vazia.
		Jogador jogador = new Jogador(1);
		Carta carta = new Carta();
		jogador.adicionarCarta(carta);
		jogador.esvaziarMao();
		assertEquals(0, jogador.getMao().getNumeroDeCartas());
	}

	@Test
	public void testVerificarApostaMenor20() {
		// testa m�todo de verificar a aposta, neste caso o valor da aposta � menor que
		// 20.
		Jogador jogador = new Jogador(1);
		jogador.setAposta(10);
		boolean resultado = jogador.verificarAposta();
		boolean resultadoEsperado = false;
		assertEquals(resultadoEsperado, resultado);
	}

	@Test
	public void testVerificarApostaMaior100() {
		// testa m�todo de verificar a aposta, neste caso o valor da aposta � maior que
		// 100.
		Jogador jogador = new Jogador(1);
		jogador.setAposta(200);
		boolean resultado = jogador.verificarAposta();
		boolean resultadoEsperado = false;
		assertEquals(resultadoEsperado, resultado);
	}

	@Test
	public void testVerificarApostaTrue() {
		// testa m�todo de verificar a aposta, neste caso � quando valor da aposta est�
		// entre 20 e 100.
		Jogador jogador = new Jogador(1);
		jogador.setAposta(75);
		boolean resultado = jogador.verificarAposta();
		boolean resultadoEsperado = true;
		assertEquals(resultadoEsperado, resultado);
	}

	@Test
	public void testRemoverAposta() {
		// testa m�todo da remo��o da aposta.
		Jogador jogador = new Jogador(1);
		jogador.removerAposta();
		int valorAposta = jogador.getAposta();
		assertEquals(0, valorAposta);
	}

	@Test
	public void testGetId() {
		// testa o valor id pego do jogador.
		Jogador jogador = new Jogador(2);
		int resultadoEsperado = 2;
		int valorId = jogador.getId();
		assertEquals(resultadoEsperado, valorId);
	}

	@Test
	public void testSetId() {
		// testa o m�todo de definir o id do jogador.
		Jogador jogador = new Jogador(3);
		jogador.setNome("Jogador3");
		int resultadoNome = jogador.getId();
		int resultadoEsperado = 3;
		assertEquals(resultadoEsperado, resultadoNome);
	}

	@Test
	public void testSetNome() {
		// testa o m�todo de definir o nome do jogador.
		Jogador jogador = new Jogador(3);
		jogador.setNome("Jogador3");
		String resultadoNome = jogador.getNome();
		String resultadoEsperado = "Jogador3";
		assertEquals(resultadoEsperado, resultadoNome);
	}

	@Test
	public void testGetNome() {
		// testa o m�todo de pegar o nome do jogador.
		Jogador jogador = new Jogador(3);
		jogador.setNome("Jogador3");
		String resultadoEsperado = "Jogador3";
		assertEquals(resultadoEsperado, jogador.getNome());
	}

	@Test
	public void testSetAposta() {
		// testa o m�todo de definir o valor da aposta.
		Jogador jogador = new Jogador(1);
		jogador.setAposta(100);
		int resultadoEsperado = 100;
		int resultadoAposta = jogador.getAposta();
		assertEquals(resultadoEsperado, resultadoAposta);
	}

	@Test
	public void testGetAposta() {
		// testa o m�todo de pegar o valor da aposta do jogador.
		Jogador jogador = new Jogador(1);
		jogador.setAposta(200);
		int resultadoEsperado = 200;
		assertEquals(resultadoEsperado, jogador.getAposta());
	}

	@Test
	public void testSaldoInicial() {
		// testa o valor do saldo inicial que � no valor de 500.
		Jogador jogador = new Jogador(2);
		int resultadoEsperado = 500;
		int resultadoSaldoInicial = jogador.getTotalFichas();
		assertEquals(resultadoEsperado, resultadoSaldoInicial);
	}

	@Test
	public void testSaldo() {
		// testa saldo quando subtra�do com algum valor.
		Jogador jogador = new Jogador(2);
		int resultadoSaldo = jogador.getTotalFichas() - 100;
		jogador.setTotalFichas(resultadoSaldo);
		int resultadoEsperado = 400;
		assertEquals(resultadoEsperado, resultadoSaldo);
	}

	@Test
	public void testState() {
		// testa estado do objeto criado.
		Jogador jogador = new Jogador(1);
		int resultadoEsperado = 0;
		assertTrue(resultadoEsperado == jogador.getState());
	}

	@Test
	public void testSetState() {
		// testa o estado do objeto quando � settado.
		Jogador jogador = new Jogador(1);
		int resultadoEsperado = 1;
		jogador.setState(1);
		assertTrue(resultadoEsperado == jogador.getState());

	}
}
