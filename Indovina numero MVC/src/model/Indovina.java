package model;

public class Indovina {

	private int cas;
	private int tent;
	private boolean fine;
	
	public Indovina() {
		cas = (int) (Math.random()*100)+1;
		tent = 0;
		fine = false;
	}
	
	public int Controllo (String num) throws Exception{
		
		if (fine) {
			return 0;
		}
		
		int n;
		
		try {
			n = Integer.parseInt(num);
		} catch (Exception e) {
			throw new Exception();
		}
		
		if ((n>100)||(n<1)) {
			throw new Exception();
		}
		
		tent++;
		
		if (n<cas) {
			return -1;
		}
		
		if (n>cas) {
			return 1;
		}
		
		fine = true;
		return 0;
		
	}
	
	public int getTent() {
		return tent;
	}
	
	public int getCas() {
		return cas;
	}
	
}
