package model;

public class Indovina {

	private Log l;
	private int cas;
	private int tent;
	
	public Indovina(Log l) {
		this.l = l;
		cas = (int) (Math.random()*100)+1;
		tent = 0;
	}
	
	public int Controllo (String num) throws Exception{
		
		int n;
		
		try {
			n = Integer.parseInt(num);
		} catch (Exception e) {
			l.scrivi("Errore di input: " + num + "\n");
			throw new Exception();
		}
		
		if ((n>100)||(n<1)) {
			l.scrivi("Errore di input: " + num + "\n");
			throw new Exception();
		}
		
		tent++;
		
		if (n<cas) {
			l.scrivi("Tentativo n." + tent + ": " + num + "\n");
			return -1;
		}
		
		if (n>cas) {
			l.scrivi("Tentativo n." + tent + ": " + num + "\n");
			return 1;
		}
		
		l.scrivi("Tentativo n." + tent + ": numero indovinato\n");
		return 0;
		
	}
	
	public int getTent() {
		return tent;
	}
	
	public int getCas() {
		return cas;
	}
	
}
