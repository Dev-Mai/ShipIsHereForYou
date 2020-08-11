package primary;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * This Panel will show all the characters
 * @author Dev-mai
 *
 */
@SuppressWarnings("serial")
public class Character extends JPanel {

	private ImageIcon closeGetCharacterWindowButtonDefault = new ImageIcon(Main.class.getResource("../imgs/home/gacha/closeButton_x.png"));
	private ImageIcon closeGetCharacterWindowButtonEntered = new ImageIcon(Main.class.getResource("../imgs/home/gacha/closeButton_x_Entered.png"));
	private JButton closeCharacterWindowButton = new JButton(closeGetCharacterWindowButtonDefault);

	private Image windowBackgroundDefault = new ImageIcon(Main.class.getResource("../imgs/home/characters/1920x1080.png")).getImage();	
	private Image windowBackground = windowBackgroundDefault;

	private ArrayList<JButton> buttonList = new ArrayList<>();
	private ArrayList<ImageIcon> buttonsEnteredList = new ArrayList<>();
	private ArrayList<ImageIcon> buttonsDefaultList = new ArrayList<>();
	private ArrayList<ImageIcon> characterData = new ArrayList<>();

	private static ArrayList<ImageIcon> characterData_small = new ArrayList<>();

	//temporary image
	private ImageIcon tmp = new ImageIcon(Main.class.getResource("../imgs/home/characters/characterImgs/00.png"));

	private MyListener characterListener = new MyListener();

	private JButton profileL = new JButton(tmp);
	private JButton profileR = new JButton(new ImageIcon(Main.class.getResource("../imgs/home/characters/profiles/defaultProfile.png")));

	public Character() {
		setSize(1920, 1080);
		setBackground(new Color(255, 255, 255, 0));
		setLayout(null);

		memorySetUp();
		buttonsEnteredListSetUp();
		buttonsDefaultListSetUp();
		buttonListSetUp();
		buttonsSetUp();
		closeCharacterWindowButtonSetting();
		characterDataSetUp();
		profileLRSetUp();

		add(closeCharacterWindowButton);

		setVisible(false);

	}

	private void memorySetUp() {
		characterData_small.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/00.png")));
		characterData_small.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/01.png")));
		characterData_small.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/02.png")));
		characterData_small.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/03.png")));
		characterData_small.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/04.png")));
		characterData_small.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/05.png")));
		characterData_small.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/06_2.png")));
		characterData_small.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/07.png")));
		characterData_small.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/08_2.png")));
		characterData_small.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/09_2.png")));
		characterData_small.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/10.png")));
		characterData_small.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/11.png")));
		characterData_small.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/12.png")));
		characterData_small.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/13.png")));
		characterData_small.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/14.png")));
		characterData_small.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/15.png")));
		characterData_small.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/16.png")));
		characterData_small.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/17.png")));
		characterData_small.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/18.png")));
		characterData_small.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/19.png")));		
	}

	private void buttonsEnteredListSetUp() {
		buttonsEnteredList.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/buttonsEntered/00_entered.png")));
		buttonsEnteredList.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/buttonsEntered/01_entered.png")));
		buttonsEnteredList.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/buttonsEntered/02_entered.png")));
		buttonsEnteredList.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/buttonsEntered/03_entered.png")));
		buttonsEnteredList.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/buttonsEntered/04_entered.png")));
		buttonsEnteredList.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/buttonsEntered/05_entered.png")));
		buttonsEnteredList.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/buttonsEntered/06_entered.png")));
		buttonsEnteredList.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/buttonsEntered/07_entered.png")));
		buttonsEnteredList.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/buttonsEntered/08_entered.png")));
		buttonsEnteredList.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/buttonsEntered/09_entered.png")));
		buttonsEnteredList.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/buttonsEntered/10_entered.png")));
		buttonsEnteredList.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/buttonsEntered/11_entered.png")));
		buttonsEnteredList.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/buttonsEntered/12_entered.png")));
		buttonsEnteredList.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/buttonsEntered/13_entered.png")));
		buttonsEnteredList.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/buttonsEntered/14_entered.png")));
		buttonsEnteredList.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/buttonsEntered/15_entered.png")));
		buttonsEnteredList.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/buttonsEntered/16_entered.png")));
		buttonsEnteredList.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/buttonsEntered/17_entered.png")));
		buttonsEnteredList.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/buttonsEntered/18_entered.png")));
		buttonsEnteredList.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/buttonsEntered/19_entered.png")));
	}

	private void buttonsDefaultListSetUp() {
		buttonsDefaultList.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/buttons/00.png")));
		buttonsDefaultList.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/buttons/01.png")));
		buttonsDefaultList.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/buttons/02.png")));
		buttonsDefaultList.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/buttons/03.png")));
		buttonsDefaultList.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/buttons/04.png")));
		buttonsDefaultList.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/buttons/05.png")));
		buttonsDefaultList.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/buttons/06.png")));
		buttonsDefaultList.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/buttons/07.png")));
		buttonsDefaultList.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/buttons/08.png")));
		buttonsDefaultList.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/buttons/09.png")));
		buttonsDefaultList.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/buttons/10.png")));
		buttonsDefaultList.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/buttons/11.png")));
		buttonsDefaultList.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/buttons/12.png")));
		buttonsDefaultList.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/buttons/13.png")));
		buttonsDefaultList.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/buttons/14.png")));
		buttonsDefaultList.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/buttons/15.png")));
		buttonsDefaultList.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/buttons/16.png")));
		buttonsDefaultList.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/buttons/17.png")));
		buttonsDefaultList.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/buttons/18.png")));
		buttonsDefaultList.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/buttons/19.png")));
	}

	private void buttonListSetUp() {
		for (int i = 0; i < buttonsDefaultList.size(); i++) {
			buttonList.add(new JButton(buttonsDefaultList.get(i)));
			buttonList.get(i).addMouseListener(characterListener);
		}
	}

	private void buttonsSetUp() {
		int countX = 0, countY = 0;
		int x, y;
		for(JButton b : buttonList) {
			x = 85 + countX * 125;
			y = (countY % 3 == 0) ? 135 : ((countY % 3 == 2) ? 73 : 197);
			b.setBounds(x, y, 125, 125);
			b.setBorderPainted(false);
			b.setContentAreaFilled(false);
			b.setFocusPainted(false);
			add(b);
			if (countY % 3 != 1) countX++;
			countY++;
		}
	}

	private void profileLRSetUp() {
		profileL.setBounds(150, 350, 430, 650);
		profileL.setBorderPainted(false);
		profileL.setContentAreaFilled(false);
		profileL.setFocusPainted(false);
		add(profileL);
		profileR.setBounds(630, 350, 1200, 650);
		profileR.setBorderPainted(false);
		profileR.setContentAreaFilled(false);
		profileR.setFocusPainted(false);
		add(profileR);
	}

	private void closeCharacterWindowButtonSetting() {
		closeCharacterWindowButton.setBounds(1920-108, 30, 108, 91);
		closeCharacterWindowButton.setBorderPainted(false);
		closeCharacterWindowButton.setContentAreaFilled(false);
		closeCharacterWindowButton.setFocusPainted(false);
		closeCharacterWindowButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				closeCharacterWindowButton.setIcon(closeGetCharacterWindowButtonEntered);
				closeCharacterWindowButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				closeCharacterWindowButton.setIcon(closeGetCharacterWindowButtonDefault);
				closeCharacterWindowButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {
				if (Home.isCharacterBoxOpened) {
					closeCharacterWindowButton.setVisible(false);
					if (!Home.buttons.getShowCharacterButton().isVisible()) {
						Home.buttons.getShowCharacterButton().setVisible(true);
					}
					windowBackground = windowBackgroundDefault;
					Home.closeBox();
					Home.isCharacterBoxOpened = false;
				}
			}
		});
	}

	private void characterDataSetUp() {
		characterData.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/characterImgs/00.png")));
		characterData.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/characterImgs/01.png")));
		characterData.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/characterImgs/02.png")));
		characterData.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/characterImgs/03.png")));
		characterData.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/characterImgs/04.png")));
		characterData.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/characterImgs/05.png")));
		characterData.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/characterImgs/06.png")));
		characterData.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/characterImgs/07.png")));
		characterData.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/characterImgs/08.png")));
		characterData.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/characterImgs/09.png")));
		characterData.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/characterImgs/10.png")));
		characterData.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/characterImgs/11.png")));
		characterData.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/characterImgs/12.png")));
		characterData.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/characterImgs/13.png")));
		characterData.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/characterImgs/14.png")));
		characterData.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/characterImgs/15.png")));
		characterData.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/characterImgs/16.png")));
		characterData.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/characterImgs/17.png")));
		characterData.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/characterImgs/18.png")));
		characterData.add(new ImageIcon(Main.class.getResource("../imgs/home/characters/characterImgs/19.png")));
	}

	public static ArrayList<ImageIcon> getMemoryList() {
		return characterData_small;
	}

	public static int getMemoryListSize() {
		return characterData_small.size();
	}

	public JButton getCloseCharacterWindowButton() {
		return closeCharacterWindowButton;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(windowBackground, 0, 0, null);
		repaint();
	}

	class MyListener extends MouseAdapter {
		public void mouseEntered(MouseEvent e) {
			setCursor(new Cursor(Cursor.HAND_CURSOR));
			for (int i = 0; i < buttonList.size(); i++) {
				if (e.getSource().equals(buttonList.get(i))) {
					buttonList.get(i).setIcon(buttonsEnteredList.get(i));
				}
			}
		}
		public void mouseExited(MouseEvent e) {
			setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			for (int i = 0; i < buttonList.size(); i++) {
				if (e.getSource().equals(buttonList.get(i))) {
					buttonList.get(i).setIcon(buttonsDefaultList.get(i));
				}
			}
		}
		public void mousePressed(MouseEvent e) {
			for (int i = 0; i < buttonList.size(); i++) {
				if (e.getSource().equals(buttonList.get(i))) {
					profileL.setIcon(characterData.get(i));
				}
			}
		}
	}

}
