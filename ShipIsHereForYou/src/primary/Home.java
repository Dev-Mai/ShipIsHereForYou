package primary;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
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

	private JButton backgroundButton = new JButton(new ImageIcon(Main.class.getResource("../imgs/transparentBackground.png")));
	private ArrayList<Image> prologueList = new ArrayList<>();
	private int index = 0;
	private boolean isPrologue = false;

	private ArrayList<Image> loadingImgList = new ArrayList<>();
	private boolean isLoading = false;

	private boolean isAtHome = false;
	private boolean isPlayerActivated = false;
	private Image departed100 = new ImageIcon(Main.class.getResource("../imgs/100departed.png")).getImage();

	Music music = new Music();
	
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

		addPrologueList();
		addLoadingImgList();

		addExitButton();
		addStartButton();
		addOpenButton();
		addQuitButton();

//		music.musicPlay("src/musics/introBGM.wav");

		menuBar.setBounds(0, 0, 1920, 30)  ;
		add(menuBar);
	}

	private void addExitButton() {
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
	}

	private void addStartButton() {
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
				prologue();
			}
		});
		startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(startButton);		
	}

	private void addOpenButton() {
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
	}

	private void addQuitButton() {
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
	}


	private void addPrologueList() {
		prologueList.add(new ImageIcon(Main.class.getResource("../imgs/prolog1.png")).getImage());
		prologueList.add(new ImageIcon(Main.class.getResource("../imgs/prolog2.png")).getImage());
		prologueList.add(new ImageIcon(Main.class.getResource("../imgs/prolog3.png")).getImage());
		prologueList.add(new ImageIcon(Main.class.getResource("../imgs/prolog4.png")).getImage());
		prologueList.add(new ImageIcon(Main.class.getResource("../imgs/prolog5.png")).getImage());
		prologueList.add(new ImageIcon(Main.class.getResource("../imgs/prolog6.png")).getImage());		
	}

	public void prologue() {
		isPrologue = true;
//		music.musicPlay("src/musics/prologueBGM.wav");
		backgroundButtonSetting();
		add(backgroundButton);
	}

	private void backgroundButtonSetting() {
		backgroundButton.setBounds(0, 0, 1920, 1080);
		backgroundButton.setBorderPainted(false);
		backgroundButton.setContentAreaFilled(false);
		backgroundButton.setFocusPainted(false);
		backgroundButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				backgroundButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mousePressed(MouseEvent e) {
				if (index < prologueList.size()-1)
					index++;
				else {
					isPrologue = false;
					index = 0;
					loading();
				}
			}
		});		
	}

	private void addLoadingImgList() {
		loadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/0.png")).getImage());		
		loadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/0.png")).getImage());		
		loadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/0.png")).getImage());		
		loadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/0.png")).getImage());		
		loadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/0.png")).getImage());		
		loadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/0.png")).getImage());		
		loadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/0.png")).getImage());		
		loadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/0.png")).getImage());		
		loadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/0.png")).getImage());		
		loadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/0.png")).getImage());		
		loadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/0.png")).getImage());		
		loadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/1.png")).getImage());
		loadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/2.png")).getImage());		
		loadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/3.png")).getImage());		
		loadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/4.png")).getImage());		
		loadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/5.png")).getImage());
		loadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/6.png")).getImage());
		loadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/7.png")).getImage());
		loadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/100departed.png")).getImage());
	}

	public void loading() {
		isLoading = true;
		backgroundButton.setVisible(false);
		if (index < loadingImgList.size()) {
			index++;
			try {
				TimeUnit.MILLISECONDS.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else {
			isLoading = false;
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			index = 0;
			atHome();
		}
	}

	public void atHome() {
		isAtHome = true;
		isPlayerActivated = true;
		backgroundButton.setVisible(true);
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		if (isPrologue) {
			g.drawImage(prologueList.get(index), 0, 290, null);
		} else if (isLoading) {
			for (int i = 0; i < index; i++) {
				boolean tmp = (i < loadingImgList.size()-1) ? g.drawImage(loadingImgList.get(i), 0, (i+1) * 30, null) 
						: g.drawImage(loadingImgList.get(i), 0, 290, null);
			}
			loading();
		} else if (isAtHome) {
			if (isPlayerActivated) {
				g.drawImage(departed100, 0, 290, null);
			}
		}
		paintComponents(g);
		this.repaint();
	}

}
