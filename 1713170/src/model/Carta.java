package model;

import java.util.ArrayList;
import java.util.Collections;

public class Carta {
	private String id;
	private String naipe;
	private String valor;

	public ArrayList<Carta> criarBaralho() {
		ArrayList<Carta> megaBaralho = new ArrayList<>();
		ArrayList<String> codBaralho = new ArrayList<>();
		ArrayList<String> letrasBaralho = new ArrayList<>();
		codBaralho.add("A");
		codBaralho.add("B");
		codBaralho.add("C");
		codBaralho.add("D");
		letrasBaralho.add("J");
		letrasBaralho.add("Q");
		letrasBaralho.add("K");
		letrasBaralho.add("A");

		for (String cod : codBaralho) {
			for (int i = 2; i < 12; i++) {
				if (i < 10) {
					megaBaralho.add(criarCarta(i + "h" + cod, "Copas", Integer.toString(i)));
					megaBaralho.add(criarCarta(i + "c" + cod, "Paus", Integer.toString(i)));
					megaBaralho.add(criarCarta(i + "d" + cod, "Ouros", Integer.toString(i)));
					megaBaralho.add(criarCarta(i + "s" + cod, "Espadas", Integer.toString(i)));
				} else if (i == 10) {
					megaBaralho.add(criarCarta("t" + "h" + cod, "Copas", Integer.toString(i)));
					megaBaralho.add(criarCarta("t" + "c" + cod, "Paus", Integer.toString(i)));
					megaBaralho.add(criarCarta("t" + "d" + cod, "Ouros", Integer.toString(i)));
					megaBaralho.add(criarCarta("t" + "s" + cod, "Espadas", Integer.toString(i)));
				} else {
					for (String letra : letrasBaralho) {
						megaBaralho.add(criarCarta(letra.toLowerCase() + "h" + cod, "Copas", letra));
						megaBaralho.add(criarCarta(letra.toLowerCase() + "c" + cod, "Paus", letra));
						megaBaralho.add(criarCarta(letra.toLowerCase() + "d" + cod, "Ouros", letra));
						megaBaralho.add(criarCarta(letra.toLowerCase() + "s" + cod, "Espadas", letra));
					}
				}
			}
		}
		Collections.shuffle(megaBaralho);
		return megaBaralho;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public void setNaipe(String naipe) {
		this.naipe = naipe;
	}

	public String getId() {
		return id;
	}

	public String getValor() {
		return valor;
	}

	public String getNaipe() {
		return naipe;
	}

	public Carta criarCarta(String id, String naipe, String valor) {
		Carta carta = new Carta();
		carta.setId(id);
		carta.setValor(valor);
		carta.setNaipe(naipe);
		return carta;
	}

}
