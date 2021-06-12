package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Observer.Observer;
import Observer.Subject;
import controller.GameController;

public class TelaDealer extends JFrame implements Subject, MouseListener, ActionListener {

	private static final long serialVersionUID = 1L;
	int LARGURA = 900;
	int ALTURA = 700;
	public TelaDealerPanel panelDealer;
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();
	int screenWidth = screenSize.width;
	int screenHeight = screenSize.height;

	private JLabel pontosLabel = new JLabel("Pontos: 0");
	private JButton botaoSave = new JButton("Salvar");
	private JButton botaoFechar = new JButton("Fechar");

	private ArrayList<Observer> observadores;

	public TelaDealer(int LARGURA, int ALTURA) {

		panelDealer = new TelaDealerPanel();

		setTitle("Dealer");
		setBackground(new Color(17, 68, 26));
		setResizable(false);
		int x = screenWidth / 2 - LARGURA / 2;
		int y = screenHeight / 2 - ALTURA / 2;
		setBounds(x, y, LARGURA, ALTURA);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// JLabel
		pontosLabel.setFont(new Font("TimesRoman", Font.PLAIN, 25));
		pontosLabel.setForeground(Color.WHITE);
		pontosLabel.setBounds(6, 500, 100, 70);
		panelDealer.add(pontosLabel);

		// JButton
		botaoFechar.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		botaoFechar.setForeground(Color.WHITE);
		botaoFechar.setBorderPainted(false);
		botaoFechar.setContentAreaFilled(false);
		botaoFechar.setFocusPainted(false);
		botaoFechar.setOpaque(false);
		botaoFechar.setBounds(LARGURA - 100, ALTURA - 120, 100, 40);
		botaoFechar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		// botaoFechar.addActionListener(this);
		panelDealer.add(botaoFechar);

		add(panelDealer);
		addMouseListener(this);
		observadores = new ArrayList<Observer>();

	}

	public void setListeners(GameController controller) {
		botaoFechar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.fechar();
			}
		});
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		int x = arg0.getX();
		int y = arg0.getY();
		System.out.println(x + "," + y);
		if ((x >= 170 && x <= 220) && (y >= 625 && y <= 675))
			notificaObservador(1);

		else if ((x >= 270 && x <= 320) && (y >= 625 && y <= 675))
			notificaObservador(5);

		else if ((x >= 370 && x <= 420) && (y >= 625 && y <= 675))
			notificaObservador(10);

		else if ((x >= 470 && x <= 520) && (y >= 625 && y <= 675))
			notificaObservador(20);

		else if ((x >= 570 && x <= 620) && (y >= 625 && y <= 675))
			notificaObservador(50);

		else if ((x >= 670 && x <= 720) && (y >= 625 && y <= 675))
			notificaObservador(100);

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void adicionaObservador(Observer obj) {
		if (obj != null && !observadores.contains(obj))
			observadores.add(obj);

	}

	@Override
	public void removeObservador(Observer obj) {
		observadores.remove(obj);

	}

	@Override
	public void notificaObservador(int valor) {
		for (Observer o : observadores)
			o.update(valor);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
