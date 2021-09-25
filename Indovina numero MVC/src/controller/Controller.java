package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Indovina;
import model.Log;
import view.Grafica;

public class Controller implements ActionListener {

	private Indovina i;
	private Log l;
	private Grafica g;
	
	public Controller(Indovina i, Log l, Grafica g) {
		this.i = i;
		this.l = l;
		this.g = g;
		g.registraController(this);
	}
	
	public void inizio() {
		g.mostra();
		l.writeInizio();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equalsIgnoreCase("Prova")) {
			String n = g.txt();
			int r = -2;
			try {
				r = i.Controllo(n);
			} catch (Exception e) {
				
			}
			g.tentativo(r, i.getTent(), i.getCas());
		}
		if(arg0.getActionCommand().equalsIgnoreCase("Ricomincia")) {
			g.riparti();
			i = new Indovina();
		}
	}

}
