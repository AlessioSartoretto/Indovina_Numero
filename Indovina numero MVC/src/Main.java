import controller.Controller;
import model.Indovina;
import view.Grafica;

public class Main {

	public static void main(String[] args) {
		Indovina i = new Indovina();
		Grafica g = new Grafica();
		Controller c = new Controller(i, g);
		c.inizio();
	}
	
}
