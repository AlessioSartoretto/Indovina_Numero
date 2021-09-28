package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Indovina;
import model.Log;
import view.Grafica;
import view.Log_grafico;

public class Controller implements ActionListener {

	private Indovina i;
	private Log l;
	private Grafica g;
	private Log_grafico log;
	
	public Controller(Indovina i, Log l, Grafica g) {
		this.i = i;
		this.l = l;
		this.g = g;
		log = new Log_grafico(l);
		g.registraController(this);
	}
	
	public void inizio() {
		g.mostra();
		l.scrivi("Inizio gioco\n");
		l.scrivi("Numero generato: " + i.getCas() + "\n");
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
			i = new Indovina(l);
			l.scrivi("Numero generato: " + i.getCas() + "\n");
		}
		if(arg0.getActionCommand().equalsIgnoreCase("Stampa log")) {
			l.stampa();
			log.open(l);
		}
	}

}
