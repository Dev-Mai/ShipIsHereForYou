package primary;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Lists {
	
	protected ArrayList<Image> prologueList = new ArrayList<>();
	protected ArrayList<Image> playerLoadingImgList = new ArrayList<>();
	protected ArrayList<Image> loadingImgList = new ArrayList<>();

	public Lists() {
		addPrologueList();
		addPlayerLoadingImgList();
		addLoadingImgList();
	}

	private void addPrologueList() {
		prologueList.add(new ImageIcon(Main.class.getResource("../imgs/prolog1.png")).getImage());
		prologueList.add(new ImageIcon(Main.class.getResource("../imgs/prolog2.png")).getImage());
		prologueList.add(new ImageIcon(Main.class.getResource("../imgs/prolog3.png")).getImage());
		prologueList.add(new ImageIcon(Main.class.getResource("../imgs/prolog4.png")).getImage());
		prologueList.add(new ImageIcon(Main.class.getResource("../imgs/prolog5.png")).getImage());
		prologueList.add(new ImageIcon(Main.class.getResource("../imgs/prolog6.png")).getImage());		
	}
	
	private void addPlayerLoadingImgList() {
		playerLoadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/0.png")).getImage());		
		playerLoadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/0.png")).getImage());		
		playerLoadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/0.png")).getImage());		
		playerLoadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/0.png")).getImage());		
		playerLoadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/0.png")).getImage());		
		playerLoadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/0.png")).getImage());		
		playerLoadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/0.png")).getImage());		
		playerLoadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/0.png")).getImage());		
		playerLoadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/0.png")).getImage());		
		playerLoadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/0.png")).getImage());		
		playerLoadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/0.png")).getImage());		
		playerLoadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/1.png")).getImage());
		playerLoadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/2.png")).getImage());		
		playerLoadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/3.png")).getImage());		
		playerLoadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/4.png")).getImage());		
		playerLoadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/5.png")).getImage());
		playerLoadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/6.png")).getImage());
		playerLoadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/7.png")).getImage());
	}
	
	private void addLoadingImgList() {
		loadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/loadingImgs/loading00.png")).getImage());		
		loadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/loadingImgs/loading01.png")).getImage());		
		loadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/loadingImgs/loading02.png")).getImage());		
		loadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/loadingImgs/loading03.png")).getImage());		
		loadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/loadingImgs/loading04.png")).getImage());		
		loadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/loadingImgs/loading05.png")).getImage());		
		loadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/loadingImgs/loading06.png")).getImage());		
		loadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/loadingImgs/loading07.png")).getImage());		
		loadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/loadingImgs/loading08.png")).getImage());		
		loadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/loadingImgs/loading09.png")).getImage());		
		loadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/loadingImgs/loading10.png")).getImage());		
		loadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/loadingImgs/loading11.png")).getImage());
		loadingImgList.add(new ImageIcon(Main.class.getResource("../imgs/loadingImgs/loading12.png")).getImage());		
	}
}
