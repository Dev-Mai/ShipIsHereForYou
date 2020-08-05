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
	private boolean isFirstVisit = true;
	private boolean isPlayerActivated = false;
	private boolean isAtHome2 = false;

	private Image departed100 = new ImageIcon(Main.class.getResource("../imgs/100departed.png")).getImage();

	private static Buttons buttons = new Buttons();
	private static Lists lists = new Lists();
	private static MemoryPickUpBox box = new MemoryPickUpBox();
	private static VoyageMap map = new VoyageMap(); 
	// Music music = new Music();

	private static ImageIcon openGetMemoryWindowButtonDefault = new ImageIcon(Main.class.getResource("../imgs/home/gacha/openGachaWindowDefault.png"));
	private ImageIcon openGetMemoryWindowButtonEntered = new ImageIcon(Main.class.getResource("../imgs/home/gacha/openGachaWindowEntered.png"));
	protected static JButton openGetMemoryWindowButton = new JButton(openGetMemoryWindowButtonDefault);

	private MyListener listener = new MyListener();
	
	protected static Last4Clone0 player;


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
		if (isFirstVisit) {
			add(buttons.getBackgroundButton());
			player = new Last4Clone0();
			// add name input panel
			player.setName("Admin");
		}
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

		mapSetting();
		add(map);
		

		add(buttons.getCurrChipButton());
		add(buttons.getGoLeftButton());
		add(buttons.getGoRightButton());

	}

	private void openGetMemoryWindowButtonSetting() {
		openGetMemoryWindowButton.setBounds(1200, 300, 400, 100);
		openGetMemoryWindowButton.setBorderPainted(false);
		openGetMemoryWindowButton.setContentAreaFilled(false);
		openGetMemoryWindowButton.setFocusPainted(false);
		openGetMemoryWindowButton.addMouseListener(listener);
		openGetMemoryWindowButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	private void mapSetting() {
		map.setBounds(360, 140, 1200, 800);
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

	public static void closeBox() {
		box.setIgnoreRepaint(true);
		box.setEnabled(false);
		box.setVisible(false);
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
			
			g.drawImage(lists.homepageList.get(buttons.getCurrView()), 0, 0, null);
			
			if (buttons.getCurrView() == 0) {
				
				buttons.getCurrChipButton().setVisible(true);
				if (!Home.isGachaWindowOpened) {
					openGetMemoryWindowButton.setVisible(true);
				} else {
					openGetMemoryWindowButton.setVisible(false);
				}
				map.setVisible(false);

				
			} else if (buttons.getCurrView() == 1) {

				buttons.getCurrChipButton().setVisible(false);
				openGetMemoryWindowButton.setVisible(false);
				map.setVisible(true);
				
			} else if (buttons.getCurrView() == 2) {
				
				buttons.getCurrChipButton().setVisible(true);
				openGetMemoryWindowButton.setVisible(false);
				map.setVisible(false);
				
			}

			buttons.getCurrChipButton().setText(Integer.toString(player.getCurrChips()));


		}
		paintComponents(g);
		this.repaint();
	}

	class MyListener extends MouseAdapter {
		public void mouseEntered(MouseEvent e) {
			if (buttons.getCurrView() == 0) {
				if (!Home.isGachaWindowOpened) {
					openGetMemoryWindowButton.setIcon(openGetMemoryWindowButtonEntered);
					openGetMemoryWindowButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				} else {
					openGetMemoryWindowButton.setIcon(openGetMemoryWindowButtonDefault);
					openGetMemoryWindowButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			}
		}
		public void mouseExited(MouseEvent e) {
			if (buttons.getCurrView() == 0) {
				openGetMemoryWindowButton.setIcon(openGetMemoryWindowButtonDefault);
				openGetMemoryWindowButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		}
		public void mousePressed(MouseEvent e) {
			if (buttons.getCurrView() == 0) {
				if (!Home.isGachaWindowOpened) {
					Home.isGachaWindowOpened = true;
					box = new MemoryPickUpBox();
					box.setBounds(160, 90, 1600, 900);
					add(box);
					openGetMemoryWindowButton.setVisible(false);
				}
			}
		}
	}

}
