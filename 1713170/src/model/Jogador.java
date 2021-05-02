package model;


public class Jogador {
	 private int id;
	 private String nome;
	 private int aposta;
	 private int saldo;
	 private boolean state;
	 private Mao mao;
	 
	 public Jogador(int id)
	 {
		 this.id = id; 
		 saldo = 500;
		 state = false;
		 mao = new Mao();
	 }
	 
	 public void adicionarCarta(Carta carta)
	 {
		 mao.adicionarCarta(carta);
	 }
	 
	 public void adicionarAposta()
	 {
		 saldo += aposta;
		 aposta = 0;
	 }
	 
	 public void removerAposta()
	 {
		 saldo -= aposta;
		 aposta = 0;
	 }
	 
	 public void esvaziarMao()
	 {
		 mao.esvaziarMao();
	 }
	 
	 
	 public int getId()
	 {
		 return this.id;
	 }
	 
	 public void setNome(String nome)
	 {
		 this.nome = nome;
	 }
	 
	 public String getNome()
	 {
		 return nome;
	 }
	 
	 public void setAposta(int aposta)
	 {
		 this.aposta = aposta;
	 }
	 
	 public int getAposta()
	 {
		 return aposta;
	 }
	 
	 public void setSaldo(int saldo)
	 {
		 this.saldo = saldo;
	 }
	 
	 public int getSaldo()
	 {
		 return saldo;
	 }
	 
	 public void setState()
	 {
		 state = !state;
	 }
	 
	 public boolean getState()
	 {
		 return state;
	 }
	 
	 
	 

}
