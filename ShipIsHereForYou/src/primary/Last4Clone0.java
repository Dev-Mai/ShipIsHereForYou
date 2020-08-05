package primary;

import java.util.ArrayList;

public class Last4Clone0 {

	private String name = "Clone0";	
	private int currChips = 10000;
	
	private ArrayList<Integer> memoryKeeped = new ArrayList<>();

	
	public Last4Clone0() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getCurrChips() {
		return currChips;
	}
	
	public void setCurrChips(int n) {
		this.currChips = n;
	}
	
	public void addToMemoryKeep(int uniqueNum) {
		memoryKeeped.add(uniqueNum);
	}
	
	
	
}
