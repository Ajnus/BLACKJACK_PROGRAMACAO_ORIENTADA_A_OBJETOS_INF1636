package view;



import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;


import javax.swing.JButton;
import javax.swing.JPanel;

public class TelaDealer extends JPanel{
	

	private static final long serialVersionUID = 1L;
	private Image img = Toolkit.getDefaultToolkit().getImage("blackjackBKG.png");
	Graphics g;
	
	
	public TelaDealer(int LARGURA, int ALTURA)
	{
		
		setLayout(null);
		
		
		JButton botaoEncerrar = new JButton("Encerrar");
		botaoEncerrar.setFont(new Font("TimesRoman", Font.PLAIN, 25));
		botaoEncerrar.setForeground(new Color(200, 200, 200));
		botaoEncerrar.setBackground(new Color(17, 68, 26));
		botaoEncerrar.setBorderPainted(false);
		botaoEncerrar.setFocusPainted(false);
		botaoEncerrar.setBounds(LARGURA - 130, ALTURA - 80, 120, 40);
		botaoEncerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    
		add(botaoEncerrar);
		
		
		
		
		
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		try{
			g.drawImage(img, 0, 0, this);
			
		}catch(Exception e) {
			System.err.println("Imagem não encontrada!");
		}
	}
}
