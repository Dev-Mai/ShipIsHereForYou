package primary;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
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
	protected static boolean isCharacterBoxOpened = false;
	protected static boolean shouldAddMemoryBox = true;
	private boolean isFirstVisit = true;
	private boolean isPlayerActivated = false;
	private boolean isAtHome2 = false;

	private Image departed100 = new ImageIcon(Main.class.getResource("../imgs/100departed.png")).getImage();

	static Buttons buttons = new Buttons();
	private static Lists lists = new Lists();
	protected static MemoryPickUpBox box = new MemoryPickUpBox();
	private static VoyageMap map = new VoyageMap(); 
	private static Character characterBox = new Character();
	// Music music = new Music();

//	private static ImageIcon openGetMemoryWindowButtonDefault = new ImageIcon(Main.class.getResource("../imgs/home/gacha/openGachaWindowDefault.png"));
//	private ImageIcon openGetMemoryWindowButtonEntered = new ImageIcon(Main.class.getResource("../imgs/home/gacha/openGachaWindowEntered.png"));
//	protected static JButton openGetMemoryWindowButton = new JButton(openGetMemoryWindowButtonDefault);

//	private MyListener listener = new MyListener();

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

		add(characterBox);
		add(buttons.getOpenGetMemoryWindowButton());

		mapSetting();
		add(map);



		add(buttons.getCurrChipButton());
		add(buttons.getShowCharacterButton());
		add(buttons.getGoLeftButton());
		add(buttons.getGoRightButton());

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
		if (isGachaWindowOpened) {
			box.setIgnoreRepaint(true);
			box.setEnabled(false);
			box.setVisible(false);
			shouldAddMemoryBox = false;
		} else if (isCharacterBoxOpened) {
//			characterBox.setIgnoreRepaint(true);
//			characterBox.setEnabled(false);
			characterBox.setVisible(false);
		}
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

			if (buttons.getCurrView() == 0) { // primary window, memory backup window

				buttons.getCurrChipButton().setVisible(true);
				buttons.getGoLeftButton().setVisible(true);
				buttons.getGoRightButton().setVisible(true);
				buttons.getShowCharacterButton().setVisible(false);
				if (!Home.isGachaWindowOpened) {
					buttons.getOpenGetMemoryWindowButton().setVisible(true);
				} else {
					buttons.getOpenGetMemoryWindowButton().setVisible(false);
					if (shouldAddMemoryBox) {
						add(box);
						box.setVisible(true);
						shouldAddMemoryBox = false;
					}
				}
				map.setVisible(false);

			} else if (buttons.getCurrView() == 1) { // map window

				buttons.getCurrChipButton().setVisible(false);
				buttons.getGoLeftButton().setVisible(true);
				buttons.getGoRightButton().setVisible(true);
				buttons.getShowCharacterButton().setVisible(false);
				buttons.getOpenGetMemoryWindowButton().setVisible(false);
				map.setVisible(true);

			} else if (buttons.getCurrView() == 2) { // empty 
				buttons.getCurrChipButton().setVisible(true);	
				buttons.getGoLeftButton().setVisible(true);
				buttons.getGoRightButton().setVisible(true);
				buttons.getShowCharacterButton().setVisible(false);
				buttons.getOpenGetMemoryWindowButton().setVisible(false);
				map.setVisible(false);

			} else if (buttons.getCurrView() == 3) { // character window
				buttons.getCurrChipButton().setVisible(true);
				buttons.getGoLeftButton().setVisible(true);
				buttons.getGoRightButton().setVisible(true);
				buttons.getShowCharacterButton().setVisible(true);
				buttons.getOpenGetMemoryWindowButton().setVisible(false);
				map.setVisible(false);
				if (isCharacterBoxOpened) {
					buttons.getGoLeftButton().setVisible(false);
					buttons.getGoRightButton().setVisible(false);
					characterBox.setVisible(true);
					characterBox.getCloseCharacterWindowButton().setVisible(true);
				} else {
					buttons.getGoLeftButton().setVisible(true);
					buttons.getGoRightButton().setVisible(true);
					characterBox.setVisible(false);
				}

			}

			buttons.getCurrChipButton().setText(Integer.toString(player.getCurrChips()));

		}
		paintComponents(g);
		this.repaint();
	}

}
