package view;

import java.awt.*;

import javax.swing.JFrame;

public class Window extends JFrame{
	

	private static final long serialVersionUID = 1L;
	
	public Window(String title, int largura, int altura)
	{
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		int x = screenWidth/2 - largura/2;
		int y = screenHeight/2 - altura/2; 
		
		setTitle(title);
		setResizable(false);
		setBounds(x, y, largura, altura);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}
