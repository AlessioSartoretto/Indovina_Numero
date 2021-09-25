import controller.Controller;
import model.Indovina;
import model.Log;
import view.Grafica;

public class Main {

	public static void main(String[] args) {
		Indovina i = new Indovina();
		Log l = new Log();
		Grafica g = new Grafica();
		Controller c = new Controller(i, l, g);
		c.inizio();
	}
	
}
