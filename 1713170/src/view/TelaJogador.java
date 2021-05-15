package view;



import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;


import javax.swing.JButton;
import javax.swing.JPanel;

public class TelaJogador extends JPanel{
	

	private static final long serialVersionUID = 1L;
	private Image img = Toolkit.getDefaultToolkit().getImage("C:\\Users\\paulo\\Desktop\\Imagens\\blackjack.png");
	Graphics g;
	
	
	public TelaJogador(int LARGURA, int ALTURA)
	{
		
		setLayout(null);
		
		JButton botaoDouble = new JButton("");
		botaoDouble.setBorderPainted(false);
		botaoDouble.setContentAreaFilled(false);
		botaoDouble.setFocusPainted(false);
		botaoDouble.setOpaque(false);
		botaoDouble.setBounds(LARGURA/7 + 20, ALTURA - 80, 120, 40);
		botaoDouble.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    
		add(botaoDouble);
		
		JButton botaoSplit = new JButton("");
		botaoSplit.setBorderPainted(false);
		botaoSplit.setContentAreaFilled(false);
		botaoSplit.setFocusPainted(false);
		botaoSplit.setOpaque(false);
		botaoSplit.setBounds(LARGURA/3 - 75, ALTURA - 80, 120, 40);
		botaoSplit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		add(botaoSplit);
		
		JButton botaoClear = new JButton("");
		botaoClear.setBorderPainted(false);
		botaoClear.setContentAreaFilled(false);
		botaoClear.setFocusPainted(false);
		botaoClear.setOpaque(false);
		botaoClear.setBounds(LARGURA/3 + 58, ALTURA - 80, 120, 40);
		botaoClear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    
		add(botaoClear);
		
		JButton botaoDeal = new JButton("");
		botaoDeal.setBorderPainted(false);
		botaoDeal.setContentAreaFilled(false);
		botaoDeal.setFocusPainted(false);
		botaoDeal.setOpaque(false);
		botaoDeal.setBounds(LARGURA/2 - 10, ALTURA - 80, 120, 40);
		botaoDeal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    
		add(botaoDeal);
		
		
		
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
