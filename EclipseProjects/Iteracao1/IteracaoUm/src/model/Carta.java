package model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Carta {
    private String id;
    private String naipe;
    private String valor;

    public List<Carta> criarBaralho(){
        String cod;
        List<Carta> megaBaralho = new ArrayList<>();
        List<String> valorLetras = new ArrayList<>();
        valorLetras.add("K");
        valorLetras.add("J");
        valorLetras.add("Q");
        valorLetras.add("A");

        for (String valorLetra:valorLetras){
            cod = valorLetra;
            for(int i = 2; i < 10; i++){
                megaBaralho.add(criarCarta(Integer.toString(i)+cod, "Copas", Integer.toString(i)));
                megaBaralho.add(criarCarta(Integer.toString(i)+cod, "Paus", Integer.toString(i)));
                megaBaralho.add(criarCarta(Integer.toString(i)+cod, "Ouros", Integer.toString(i)));
                megaBaralho.add(criarCarta(Integer.toString(i)+cod, "Espadas", Integer.toString(i)));
            }
        }

        return megaBaralho;
    }

    public Carta criarCarta(String id, String naipe, String valor){
        Carta carta = new Carta();
        carta.setId(id);
        carta.setValor(valor);
        carta.setNaipe(naipe);
        return carta;
    }

}
