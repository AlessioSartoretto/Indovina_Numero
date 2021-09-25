package model;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {

	public Log() {
	}

	public void writeInizio() {
		FileWriter fw = null;
		try {
			fw = new FileWriter("log.txt");
			fw.write(adesso() + "Inizio gioco");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String adesso() {
		SimpleDateFormat f = new SimpleDateFormat("[dd-MM-yyyy hh:mm:ss:SSS] ");
		String d = f.format(new Date());
		return d;
	}
	
	
}
