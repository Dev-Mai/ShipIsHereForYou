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
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MemoryPickUpBox extends JPanel {

	//	private int tmpInt = 0;

	private ImageIcon closeGetmemoryWindowButtonDefault = new ImageIcon(Main.class.getResource("../imgs/home/gacha/closeButton_x.png"));
	private ImageIcon closeGetmemoryWindowButtonEntered = new ImageIcon(Main.class.getResource("../imgs/home/gacha/closeButton_x_Entered.png"));
	private JButton closeGetmemoryWindowButton = new JButton(closeGetmemoryWindowButtonDefault);

	private Image windowBackgroundDefault = new ImageIcon(Main.class.getResource("../imgs/home/gacha/tmp.png")).getImage();	
	private Image windowBackgroundLoading = new ImageIcon(Main.class.getResource("../imgs/home/gacha/blackWindow_loading.png")).getImage();
	private Image windowBackgroundLoadingBlack = new ImageIcon(Main.class.getResource("../imgs/home/gacha/blackWindow.png")).getImage();

	private Image windowBackground = windowBackgroundDefault;

	private ImageIcon recoverButtonDefault = new ImageIcon(Main.class.getResource("../imgs/home/gacha/recoverButtonDefault.png"));
	private ImageIcon recoverButtonEntered = new ImageIcon(Main.class.getResource("../imgs/home/gacha/recoverButtonEntered.png"));
	private JButton recoverButton = new JButton(recoverButtonDefault);

	private ArrayList<ImageIcon> memory = new ArrayList<>();
	private ArrayList<ImageIcon> memoryField = new ArrayList<>();
	private ArrayList<ImageIcon> frameType = new ArrayList<>();
	private JLabel frame = new JLabel();

	public MemoryPickUpBox() {
		setSize(1600, 900);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);

		memoryListSetUp();

		closeGetMemoryWindowButtonSetting();
		recoverButtonSetting();

		add(closeGetmemoryWindowButton);
		add(recoverButton);
		

		setVisible(true);

	}

	private void memoryListSetUp() {
		frameType.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/frame_00_white.png")));
		frameType.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/frame_01_red.png")));
		frameType.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/frame_02_violet_1.png")));
		frameType.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/frame_03_gold_1.png")));
		frameType.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/frame_04_mint_1.png")));
		memory.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/00.png")));
		memory.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/01.png")));
		memory.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/02.png")));
		memory.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/03.png")));
		memory.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/04.png")));
		memory.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/05.png")));
		memory.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/06_2.png")));
		memory.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/07.png")));
		memory.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/08_2.png")));
		memory.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/09_2.png")));
		memory.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/10.png")));
		memory.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/11.png")));
		memory.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/12.png")));
		memory.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/13.png")));
		memory.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/14.png")));
		memory.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/15.png")));
		memory.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/16.png")));
		memory.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/17.png")));
		memory.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/18.png")));
		memory.add(new ImageIcon(Main.class.getResource("../imgs/home/gacha/data/19.png")));
		int repeat;
		for (int i = 0; i < memory.size(); i++) {
			if (i == 6) {
				repeat = 2;
			} else if (i == 8) {
				repeat = 6;
			} else if (i == 9) {
				repeat = 8;
			} else if (i == 10) {
				repeat = 10;
			} else {
				repeat = 20;
			}
			for (int j = 0; j < repeat; j++) { 
				memoryField.add(memory.get(i));
			}

		}
	}


	private void closeGetMemoryWindowButtonSetting() {
		closeGetmemoryWindowButton.setBounds(1652-160, 91-90, 108, 91);
		closeGetmemoryWindowButton.setBorderPainted(false);
		closeGetmemoryWindowButton.setContentAreaFilled(false);
		closeGetmemoryWindowButton.setFocusPainted(false);
		//		closeGetmemoryWindowButton.addActionListener(this);
		closeGetmemoryWindowButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				closeGetmemoryWindowButton.setIcon(closeGetmemoryWindowButtonEntered);
				closeGetmemoryWindowButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				closeGetmemoryWindowButton.setIcon(closeGetmemoryWindowButtonDefault);
				closeGetmemoryWindowButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {
				if (Home.isGachaWindowOpened) {
					Home.isGachaWindowOpened = false;
					closeGetmemoryWindowButton.setVisible(false);
//					setVisible(false);
//					remove(this);
//					remove();
					if (!Home.openGetMemoryWindowButton.isVisible()) {
						Home.openGetMemoryWindowButton.setVisible(true);
					}
					windowBackground = windowBackgroundDefault;
					Home.closeBox();
				}
			}
		});
	}

	public JButton getCloseGetmemoryWindowButton() {
		return closeGetmemoryWindowButton;
	}

	private void recoverButtonSetting() {
		recoverButton.setBounds(1250, 750, 300, 100);
		recoverButton.setBorderPainted(false);
		recoverButton.setContentAreaFilled(false);
		recoverButton.setFocusPainted(false);
		recoverButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				recoverButton.setIcon(recoverButtonEntered);
				recoverButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				recoverButton.setIcon(recoverButtonDefault);
				recoverButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {
				windowBackground = windowBackgroundLoading;
				closeGetmemoryWindowButton.setVisible(false);
				Home.openGetMemoryWindowButton.setVisible(false);
				recoverButton.setVisible(false);
				if (Home.currChips >= 1000) {
					Home.currChips -= 1000;
					proceedRecovering();
				} else {
					// show unRecoverable message
				}
			}
		});
	}

	public JButton getRecoverButton() {
		return recoverButton;
	}

	private void proceedRecovering() {
		windowBackground = windowBackgroundLoadingBlack;
		setLayout(null);
		frame.setBackground(new Color(0, 0, 0, 0));
		frame.setOpaque(false);
		JLabel p;
		int r;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 5; j++) {
				p = new JLabel();
				p.setBounds(150 + 275 * j, 100 + 400 * i, 200, 300);
				p.setBackground(new Color(0, 0, 0, 0));
				r = (int)(Math.random() * 10000 % memoryField.size());
				p.setIcon(memoryField.get(r));
				p.setOpaque(false);

				frame = new JLabel();
				if (r > 119 && r <= 121) {
					frame.setIcon(frameType.get(4)); 
				} else if (r > 141 && r <= 147) {
					frame.setIcon(frameType.get(3));
				} else if (r > 147 && r <= 155) {
					frame.setIcon(frameType.get(2));
				} else if (r > 155 && r <= 165) {
					frame.setIcon(frameType.get(1));
				} else {
					frame.setIcon(frameType.get(0));
				}
				frame.setBounds(150 + 275 * j, 100 + 400 * i, 200, 300);
				frame.setOpaque(false);

				add(frame);
				add(p);
			}
		}
		closeGetmemoryWindowButton.setVisible(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(windowBackground, 0, 0, null);
	}

	//	@Override
	//	public void actionPerformed(ActionEvent e) {
	//		System.out.println("EnteredActionListener: " + tmpInt++);
	//		
	//		
	//	}

	//	class myListener extends MouseAdapter {
	//		
	//	}

}
