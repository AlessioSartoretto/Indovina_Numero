package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import controller.Controller;
import model.Log;

import java.awt.Color;

public class Grafica {
	
	private JFrame frmIndovinaNumero;
	private JTextField num;
	private JLabel lblNewLabel;
	private JButton prova;
	private JButton ricomincia;
	private JButton stampa;
	private JLabel tentativi;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel notifica;
	private JLabel indizio;

	public Grafica(Log l) {
		ImageIcon ico = new ImageIcon(getClass().getClassLoader().getResource("img/punto.jpg"));
		frmIndovinaNumero = new JFrame();
		frmIndovinaNumero.setIconImage(ico.getImage());
		frmIndovinaNumero.getContentPane().setForeground(Color.BLACK);
		frmIndovinaNumero.setResizable(false);
		frmIndovinaNumero.setTitle("Indovina numero");
		frmIndovinaNumero.setBounds(100, 100, 450, 470);
		frmIndovinaNumero.setDefaultCloseOperation(fine(l));
		frmIndovinaNumero.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Ho generato un numero tra 1 e 100, lo scopo del gioco \u00E8 quello di");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(12, 13, 420, 16);
		frmIndovinaNumero.getContentPane().add(lblNewLabel);
		
		num = new JTextField();
		num.setBounds(12, 216, 116, 22);
		frmIndovinaNumero.getContentPane().add(num);
		num.setColumns(10);
		
		prova = new JButton("Prova");
		prova.setForeground(Color.BLACK);
		prova.setBounds(12, 251, 97, 25);
		frmIndovinaNumero.getContentPane().add(prova);
		
		ricomincia = new JButton("Ricomincia");
		ricomincia.setBounds(12, 385, 97, 25);
		frmIndovinaNumero.getContentPane().add(ricomincia);
		
		tentativi = new JLabel("Tentativi effettuati: 0");
		tentativi.setForeground(Color.GREEN);
		tentativi.setHorizontalAlignment(SwingConstants.LEFT);
		tentativi.setBounds(12, 289, 420, 16);
		frmIndovinaNumero.getContentPane().add(tentativi);
		
		lblNewLabel_1 = new JLabel("indovinare il numero generato nel minor numero di tentativi possibili.");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(12, 42, 420, 16);
		frmIndovinaNumero.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Buona fortuna!");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(12, 71, 116, 16);
		frmIndovinaNumero.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Inserisci qua sotto il numero che credi sia stato generato");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setBounds(12, 158, 397, 16);
		frmIndovinaNumero.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("e premi il pulsante \"Prova\" per vedere se hai indovinato.");
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setBounds(12, 187, 351, 16);
		frmIndovinaNumero.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Per rigiocare premi il pulsante \"Ricomincia\".");
		lblNewLabel_5.setForeground(Color.MAGENTA);
		lblNewLabel_5.setBounds(12, 356, 308, 16);
		frmIndovinaNumero.getContentPane().add(lblNewLabel_5);
		
		notifica = new JLabel("");
		notifica.setHorizontalAlignment(SwingConstants.CENTER);
		notifica.setBounds(140, 219, 280, 16);
		frmIndovinaNumero.getContentPane().add(notifica);
		
		indizio = new JLabel("");
		indizio.setHorizontalAlignment(SwingConstants.CENTER);
		indizio.setBounds(140, 255, 280, 16);
		frmIndovinaNumero.getContentPane().add(indizio);
		
		stampa = new JButton("Stampa log");
		stampa.setBounds(318, 385, 103, 25);
		frmIndovinaNumero.getContentPane().add(stampa);
	}
	
	public void registraController(Controller controller) {
		prova.addActionListener(controller);
		ricomincia.addActionListener(controller);
		stampa.addActionListener(controller);
	}

	public void mostra() {
		frmIndovinaNumero.setVisible(true);
	}
	
	public void tentativo(int n, int tent, int cas) {
		
		switch (n) {
			case (-2): {
				notifica.setText("Errore:");
				indizio.setText("Inserisci un numero intero tra 1 e 100 compresi!");
				num.setText("");
				break;
			}
			case (-1): {
				notifica.setText("Sbagliato:");
				indizio.setText("Il numero che stai cercando è più grande!");
				tentativi.setText("Tentativi effettuati: " + tent);
				num.setText("");
				break;
			}
			case (1): {
				notifica.setText("Sbagliato:");
				indizio.setText("Il numero che stai cercando è più piccolo!");
				tentativi.setText("Tentativi effettuati: " + tent);
				num.setText("");
				break;
			}
			case (0): {
				notifica.setText("Hai vinto!");
				indizio.setText("Il nummero generato era " + cas);
				tentativi.setText("Hai indovinato in " + tent + " tentativi.");
				num.setText("");
				num.setEnabled(false);
				prova.setEnabled(false);
				break;
			}
		}
	}
	
	public void riparti() {
		notifica.setText("");
		indizio.setText("");
		num.setText("");
		prova.setEnabled(true);
		num.setEnabled(true);
		tentativi.setText("Tentativi effettuati: 0");
	}
	
	public String txt() {
		return num.getText();
	}
	
	private int fine(Log l) {
		l.file();
		return JFrame.EXIT_ON_CLOSE;
	}
	
}
