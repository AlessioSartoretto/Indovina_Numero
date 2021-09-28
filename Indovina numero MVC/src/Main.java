import controller.Controller;
import model.Indovina;
import model.Log;
import view.Grafica;

public class Main {

	public static void main(String[] args) {
		Log l = new Log();
		Indovina i = new Indovina(l);
		Grafica g = new Grafica(l);
		Controller c = new Controller(i, l, g);
		c.inizio();
	}
	
}
