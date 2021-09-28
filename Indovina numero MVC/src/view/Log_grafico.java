package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Log;

import javax.swing.JTextPane;
import javax.swing.JScrollPane;

public class Log_grafico extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextPane textPane;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public void open(Log l) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Log_grafico frame = new Log_grafico(l);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param l 
	 */
	public Log_grafico(Log l) {
		setResizable(false);
		setTitle("Log");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		textPane = new JTextPane();
		textPane.setEditable(false);
		scrollPane = new JScrollPane(textPane);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		textPane.setText(l.stampa());
	}

}
