package primary;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Home extends JFrame{

	private Image screenImage;
	private Graphics screenGraphic;

	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../imgs/menuBar.png")));
	private int homeIndex = 0;

	protected static boolean isPrologue = false;
	protected static boolean isPlayerLoading = false;
	protected static boolean isLoading = false;
	protected static boolean isAtHome1 = false;
	protected static boolean isGachaWindowOpened = false;
	private boolean isPlayerActivated = false;
	private boolean isAtHome2 = false;

	private Image departed100 = new ImageIcon(Main.class.getResource("../imgs/100departed.png")).getImage();

	private static Buttons buttons = new Buttons();
	private static Lists lists = new Lists();
	private static MemoryPickUpBox box = new MemoryPickUpBox();
	// Music music = new Music();

	private static ImageIcon openGetMemoryWindowButtonDefault = new ImageIcon(Main.class.getResource("../imgs/home/gacha/openGachaWindowDefault.png"));
	private ImageIcon openGetMemoryWindowButtonEntered = new ImageIcon(Main.class.getResource("../imgs/home/gacha/openGachaWindowEntered.png"));
	protected static JButton openGetMemoryWindowButton = new JButton(openGetMemoryWindowButtonDefault);
	
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

		add(buttons.getExitButton());
		add(buttons.getStartButton());
		add(buttons.getOpenButton());
		add(buttons.getQuitButton());

		//		music.musicPlay("src/musics/introBGM.wav");

		menuBar.setBounds(0, 0, 1920, 30);
		add(menuBar);
	}

	public static Lists getList() {
		return lists;
	}

	public void prologue() {
		//		music.musicPlay("src/musics/prologueBGM.wav");
		add(buttons.getBackgroundButton());
	}

	public void playerLoading() {
		buttons.setBackgroundButtonVisible(false);
		if (homeIndex < lists.playerLoadingImgList.size()) {
			homeIndex++;
			try {
				//				TimeUnit.MILLISECONDS.sleep(300);
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else {
			isPlayerLoading = false;
			try {
				//				TimeUnit.SECONDS.sleep(2);
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			homeIndex = 0;
			atHome1();
		}
	}

	public void atHome1() {
		isAtHome1 = true;
		isPlayerActivated = true;
		buttons.setBackgroundButtonVisible(true);
		add(buttons.getBackgroundButton());
		if (isLoading) loading();
	}

	public void atHome2() {
		isAtHome2 = true;
		buttons.setBackgroundButtonVisible(false);

		openGetMemoryWindowButtonSetting();
		add(openGetMemoryWindowButton);
		// 기타 다른 버튼들 추가
		
//		if (buttons.getCurrView() == 0) {
//			openGetMemoryWindowButton.setVisible(true);
//		} else if (buttons.getCurrView() == 1) {
//			openGetMemoryWindowButton.setVisible(false);
//		} else if (buttons.getCurrView() == 2) {
//			openGetMemoryWindowButton.setVisible(false);
//		}

		add(buttons.getGoLeftButton());
		add(buttons.getGoRightButton());

	}
	
	private void openGetMemoryWindowButtonSetting() {
		openGetMemoryWindowButton.setBounds(1200, 300, 400, 100);
		openGetMemoryWindowButton.setBorderPainted(false);
		openGetMemoryWindowButton.setContentAreaFilled(false);
		openGetMemoryWindowButton.setFocusPainted(false);
		openGetMemoryWindowButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				if (!Home.isGachaWindowOpened) {
					openGetMemoryWindowButton.setIcon(openGetMemoryWindowButtonEntered);
					openGetMemoryWindowButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				} else {
					openGetMemoryWindowButton.setIcon(openGetMemoryWindowButtonDefault);
					openGetMemoryWindowButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			}
			public void mouseExited(MouseEvent e) {
				openGetMemoryWindowButton.setIcon(openGetMemoryWindowButtonDefault);
				openGetMemoryWindowButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {
				if (!Home.isGachaWindowOpened) {
					setVisible(true);
					Home.isGachaWindowOpened = true;
					box = new MemoryPickUpBox();
					box.setBounds(160, 90, 1600, 900);
					add(box);
//					closeGetmemoryWindowButton.setVisible(true);
				}
			}
		});
		openGetMemoryWindowButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	public void loading() {
		buttons.setBackgroundButtonVisible(false);
		if (homeIndex < lists.loadingImgList.size()-1) {
			homeIndex++;
			try {
				//				TimeUnit.MILLISECONDS.sleep(300);
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else {
			isLoading = false;
			try {
				//				TimeUnit.SECONDS.sleep(1);
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			homeIndex = 0;
			atHome2();
		}
	}
	
	public static MemoryPickUpBox getBox() {
		return box;
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(buttons.getBackground(), 0, 0, null);
		if (isPrologue) {
			prologue();
			g.drawImage(lists.prologueList.get(buttons.getIndex()), 0, 290, null);
		} else if (isPlayerLoading) {
			playerLoading();
			for (int i = 0; i < homeIndex; i++) {
				g.drawImage(lists.playerLoadingImgList.get(i), 0, (i+1) * 30, null);
			}
		} else if (isAtHome1) {
			if (isPlayerActivated) {
				g.drawImage(departed100, 0, 290, null);
			}
		} else if (isLoading) {
			loading();
			g.drawImage(lists.loadingImgList.get(homeIndex), 710, 475, null);
		} else if (isAtHome2) {
			atHome2();
			g.drawImage(lists.homepageList.get(buttons.getCurrView()), 0, 0, null);
			if (buttons.getCurrView() == 0) {
				openGetMemoryWindowButton.setVisible(true);
			} else if (buttons.getCurrView() == 1) {
				openGetMemoryWindowButton.setVisible(false);
			} else if (buttons.getCurrView() == 2) {
				openGetMemoryWindowButton.setVisible(false);
			}

		}
		paintComponents(g);
		this.repaint();
	}

}
