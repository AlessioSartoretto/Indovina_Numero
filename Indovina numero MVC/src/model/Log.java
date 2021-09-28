package model;

import java.io.BufferedReader;
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
		BufferedReader reader = null;
		String l = "";
		String s = "";
		try {
			reader = new BufferedReader (new FileReader ("log.txt"));
			while ( (l = reader.readLine()) != null) {
				s += l + "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(s);
		return s;
	}
	
	public int file() {
		SimpleDateFormat d = new SimpleDateFormat("yyyyMMddhhmmss");
		String f = d.format(new Date());
		f += "_log.txt";
		String s = stampa();
		//System.out.println(s);
		FileWriter fw;
		try {
			fw = new FileWriter(f);
			fw.write(s);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
