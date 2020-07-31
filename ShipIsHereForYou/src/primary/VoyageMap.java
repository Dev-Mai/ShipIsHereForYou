package primary;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class VoyageMap extends JPanel {

	private final int WIDTH = 1200;
	private final int HEIGHT = 800;

	private Image mapImage = new ImageIcon(Main.class.getResource("../imgs/map/tmpMapImage_1.jpg")).getImage();

	private Point mousePoint;
	private Point mapPoint = new Point(WIDTH / 2, HEIGHT / 2);

	public VoyageMap() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				setSize(1000, 1000);
				setBackground(new Color(255, 0, 255, 255));
				setLayout(null);

				addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent e) {
						mousePoint = e.getPoint();
						repaint();
					}
				});

				addMouseMotionListener(new MouseMotionAdapter() {
					public void mouseDragged(MouseEvent e) {
						int x = e.getX() - mousePoint.x;
						int y = e.getY() - mousePoint.y;
						mapPoint.setLocation(mapPoint.x + x, mapPoint.y + y);
						mousePoint = e.getPoint();
						repaint();
					}
				});

				setVisible(false);
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(mapImage, mapPoint.x - mapImage.getWidth(null)/2, mapPoint.y - mapImage.getHeight(null)/2, null);
	}
	
}
