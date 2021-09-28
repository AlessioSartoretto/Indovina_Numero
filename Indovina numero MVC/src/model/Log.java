package model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {

	public Log() {
		FileWriter fw;
		try {
			fw = new FileWriter("log.txt");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void scrivi(String s) {
		FileWriter fw = null;
		try {
			fw = new FileWriter("log.txt", true);
			fw.write(adesso() + s);
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

	public String stampa() {
		FileReader fr = null;
		String s = "";
		try {
			fr = new FileReader("log.txt");
			int i = 0;
			while ((i = fr.read()) != -1) {
				s += ((char) i);
			}
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}
	
}
