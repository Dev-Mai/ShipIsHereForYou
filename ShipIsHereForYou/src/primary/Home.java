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
	private boolean isPlayerActivated = false;
	private boolean isAtHome2 = false;

	private Image departed100 = new ImageIcon(Main.class.getResource("../imgs/100departed.png")).getImage();

	private int currView = 0;
	private Image homepage;
	
	private static Buttons buttons = new Buttons();
	private static Lists lists = new Lists();
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


		//		addPrologueList();
		//		addPlayerLoadingImgList();
		//		addLoadingImgList();

		add(buttons.getExitButton());
		add(buttons.getStartButton());
		add(buttons.getOpenButton());
		add(buttons.getQuitButton());

		if (isPrologue) prologue();
		//		music.musicPlay("src/musics/introBGM.wav");

		menuBar.setBounds(0, 0, 1920, 30)  ;
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
				TimeUnit.MILLISECONDS.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else {
			isPlayerLoading = false;
			try {
				TimeUnit.SECONDS.sleep(2);
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

		if (currView == 0) {

		} else if (currView == 1) {

		} else {

		}

		add(buttons.getGoLeftButton());
		add(buttons.getGoRightButton());

	}

	public void loading() {
		buttons.setBackgroundButtonVisible(false);
		if (homeIndex < lists.loadingImgList.size()-1) {
			homeIndex++;	
			try {
				TimeUnit.MILLISECONDS.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else {
			isLoading = false;
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			homeIndex = 0;
			atHome2();
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

		}
		paintComponents(g);
		this.repaint();
	}

}
