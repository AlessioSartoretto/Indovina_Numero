package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Indovina;
import view.Grafica;

public class Controller implements ActionListener {

	private Indovina i;
	private Grafica g;
	
	public Controller(Indovina i, Grafica g) {
		this.i = i;
		this.g = g;
		g.registraController(this);
	}
	
	public void inizio() {
		g.mostra();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equalsIgnoreCase("Prova")) {
			String n = g.txt();
			int r = -2;
			try {
				r = i.Controllo(n);
			} catch (Exception e) {}
			g.tentativo(r, i.getTent(), i.getCas());
		}
		if(arg0.getActionCommand().equalsIgnoreCase("Ricomincia")) {
			g.riparti();
			i = new Indovina();
		}
	}

}
