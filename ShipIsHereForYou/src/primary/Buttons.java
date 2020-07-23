package primary;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Buttons implements ActionListener {

	private int index = 0;
	private int currView = 0;

	private ImageIcon startButtonEntered = new ImageIcon(Main.class.getResource("../imgs/start_white.png"));
	private ImageIcon startButtonDefault = new ImageIcon(Main.class.getResource("../imgs/start_grey.png"));
	private ImageIcon openButtonEntered = new ImageIcon(Main.class.getResource("../imgs/open_white.png"));
	private ImageIcon openButtonDefault = new ImageIcon(Main.class.getResource("../imgs/open_grey.png"));
	private ImageIcon quitButtonEntered = new ImageIcon(Main.class.getResource("../imgs/quit_white.png"));
	private ImageIcon quitButtonDefault = new ImageIcon(Main.class.getResource("../imgs/quit_grey.png"));

	private Image background = new ImageIcon(Main.class.getResource("../imgs/introBackground_title.jpg")).getImage();
	private JButton backgroundButton = new JButton(new ImageIcon(Main.class.getResource("../imgs/transparentBackground.png")));

	private JButton exitButton = new JButton(new ImageIcon(Main.class.getResource("../imgs/exitButton.png")));
	private JButton startButton = new JButton(startButtonDefault);
	private JButton openButton = new JButton(openButtonDefault);
	private JButton quitButton = new JButton(quitButtonDefault);

	private ImageIcon goLeftButtonEntered = new ImageIcon(Main.class.getResource("../imgs/goLeftButtonEntered.png"));
	private ImageIcon goLeftButtonDefault = new ImageIcon(Main.class.getResource("../imgs/goLeftButtonDefault.png"));
	private ImageIcon goRightButtonEntered = new ImageIcon(Main.class.getResource("../imgs/goRightButtonEntered.png"));
	private ImageIcon goRightButtonDefault = new ImageIcon(Main.class.getResource("../imgs/goRightButtonDefault.png"));
	private JButton goLeftButton = new JButton(goLeftButtonDefault);
	private JButton goRightButton = new JButton(goRightButtonDefault);

	private ImageIcon currChipButtonImage = new ImageIcon(Main.class.getResource("../imgs/chip.png"));
	private JButton currChipButton = new JButton("NULL", currChipButtonImage);

	public Buttons() {
		exitButtonSetting();
		startButtonSetting();
		openButtonSetting();
		quitButtonSetting();
		backgroundButtonSetting();
		goLeftButtonSetting();
		goRightButtonSetting();
		showCurrChipButtonSetting();
	}

	private void exitButtonSetting() {
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
	}

	public JButton getExitButton() {
		return exitButton;
	}

	private void startButtonSetting() {
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
				Home.isPrologue = true;	
			}
		});
		startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	public JButton getStartButton() {
		return startButton;
	}

	private void openButtonSetting() {
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
	}

	public JButton getOpenButton() {
		return openButton;
	}

	private void quitButtonSetting() {
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
	}

	public JButton getQuitButton() {
		return quitButton;
	}

	private void goLeftButtonSetting() {
		goLeftButton.setBounds(0, 0, 70, 1080);
		goLeftButton.setBorderPainted(false);
		goLeftButton.setContentAreaFilled(false);
		goLeftButton.setFocusPainted(false);
		goLeftButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				if (!Home.isGachaWindowOpened) {
					goLeftButton.setIcon(goLeftButtonEntered);
					goLeftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				} else {
					goLeftButton.setIcon(goLeftButtonDefault);
					goLeftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			}
			public void mouseExited(MouseEvent e) {
				goLeftButton.setIcon(goLeftButtonDefault);
				goLeftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {
				if (!Home.isGachaWindowOpened) {
					if (currView > 0) {
						currView--;
					} else {
						currView = Home.getList().homepageList.size()-1;
					}
				}
			}
		});
		goLeftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	public JButton getGoLeftButton() {
		return goLeftButton;
	}

	private void goRightButtonSetting() {
		goRightButton.setBounds(1850, 0, 70, 1080);
		goRightButton.setBorderPainted(false);
		goRightButton.setContentAreaFilled(false);
		goRightButton.setFocusPainted(false);
		goRightButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				if (!Home.isGachaWindowOpened) {
					goRightButton.setIcon(goRightButtonEntered);
					goRightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				} else {
					goRightButton.setIcon(goRightButtonDefault);
					goRightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			}
			public void mouseExited(MouseEvent e) {
				goRightButton.setIcon(goRightButtonDefault);
				goRightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {
				if (!Home.isGachaWindowOpened) {
					if (currView < Home.getList().homepageList.size()-1) {
						currView++;
					} else {
						currView = 0;
					}
				}
			}
		});
		goRightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	public JButton getGoRightButton() {
		return goRightButton;
	}

	private void showCurrChipButtonSetting() {
		currChipButton.setBounds(1000, 50, 300, 100);
		currChipButton.setBorderPainted(false);
		currChipButton.setContentAreaFilled(false);
		currChipButton.setFocusPainted(false);		
//		currChipButton.setHorizontalAlignment(SwingConstants.RIGHT);
		currChipButton.setHorizontalTextPosition(JButton.CENTER);
		currChipButton.setVerticalTextPosition(JButton.CENTER);
		currChipButton.setFont(new Font("KoPubµ¸¿òÃ¼ Light", Font.BOLD, 20));
		//		currChipButton
	}

	public JButton getCurrChipButton() {
		return currChipButton;
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
//				if (Home.isPrologue) {
//					if (index < Home.getList().prologueList.size()-1)
//						index++;
//					else {
//						index = 0;
//						Home.isPlayerLoading = true;
//						Home.isPrologue = false;
//					}
//				} else if(Home.isAtHome1) {
//					Home.isAtHome1 = false;
//					Home.isLoading = true;
//				}
			}
		});
		backgroundButton.addActionListener(this);

	}



	public JButton getBackgroundButton() {
		return backgroundButton;
	}

	public void setBackgroundButtonVisible(boolean trueOrFalse) {
		backgroundButton.setVisible(trueOrFalse);
	}

	public Image getBackground() {
		return background;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int n) {
		index = n;
	}

	public int getCurrView() {
		return currView;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (Home.isPrologue) {
			if (index < Home.getList().prologueList.size()-1)
				index++;
			else {
				index = 0;
				Home.isPlayerLoading = true;
				Home.isPrologue = false;
			}
		} else if(Home.isAtHome1) {
			Home.isAtHome1 = false;
			Home.isLoading = true;
		}		
	}
}
