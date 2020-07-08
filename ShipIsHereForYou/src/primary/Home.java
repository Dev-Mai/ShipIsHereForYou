package primary;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Home extends JFrame{

	private Image screenImage;
	private Graphics screenGraphic;
	
	private ImageIcon startButtonEntered = new ImageIcon(Main.class.getResource("../imgs/start_white.png"));
	private ImageIcon startButtonDefault = new ImageIcon(Main.class.getResource("../imgs/start_grey.png"));
	private ImageIcon openButtonEntered = new ImageIcon(Main.class.getResource("../imgs/open_white.png"));
	private ImageIcon openButtonDefault = new ImageIcon(Main.class.getResource("../imgs/open_grey.png"));
	private ImageIcon quitButtonEntered = new ImageIcon(Main.class.getResource("../imgs/quit_white.png"));
	private ImageIcon quitButtonDefault = new ImageIcon(Main.class.getResource("../imgs/quit_grey.png"));
	
	
	private Image background = new ImageIcon(Main.class.getResource("../imgs/introBackground_title.jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../imgs/menuBar.png")));
	private JButton exitButton = new JButton(new ImageIcon(Main.class.getResource("../imgs/exitButton.png")));
	
	private JButton startButton = new JButton(startButtonDefault);
	private JButton openButton = new JButton(openButtonDefault);
	private JButton quitButton = new JButton(quitButtonDefault);
	
	public Home() {
		setUndecorated(true);
		setTitle("Ship Is Here For You");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		
		// exitButton
		exitButton.setBounds(1880, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(exitButton);

		// startButton
		startButton.setBounds(100, 550, 400, 100);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEntered);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonDefault);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {
				// start game
				startButton.setVisible(false);
				openButton.setVisible(false);
				quitButton.setVisible(false);
				background = new ImageIcon(Main.class.getResource("../imgs/prolog1background.png")).getImage();
			}
		});
		startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(startButton);
		
		// openButton
		openButton.setBounds(100, 700, 400, 100);
		openButton.setBorderPainted(false);
		openButton.setContentAreaFilled(false);
		openButton.setFocusPainted(false);
		openButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				openButton.setIcon(openButtonEntered);
				openButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				openButton.setIcon(openButtonDefault);
				openButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {
				// open files
			}
		});
		openButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(openButton);
		
		// quitButton
		quitButton.setBounds(100, 850, 400, 100);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEntered);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonDefault);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(quitButton);
		
		menuBar.setBounds(0, 0, 1920, 30)  ;
		add(menuBar);
	}
	
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}
	
}
