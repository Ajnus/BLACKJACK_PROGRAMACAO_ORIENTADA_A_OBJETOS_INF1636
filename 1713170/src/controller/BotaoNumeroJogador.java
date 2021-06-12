package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class BotaoNumeroJogador implements ActionListener {
	
	private int numeroJogadores;
	private JFrame frame;
	
	public BotaoNumeroJogador(int numeroJogadores, JFrame frame) {
		this.numeroJogadores = numeroJogadores;
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.setVisible(false);
		
		GameController game = GameController.getInstancia();
		game.inicializaGame(numeroJogadores);
	}

}
