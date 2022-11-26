package com.konwar.CoreJava.IOlibrary;
// Example using FileReader and FileWriter
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class IOLab2 {
	public static void main(String[] args) {
		writeToFile();
		readFromFile();
	}

	static void writeToFile() {
		InputStreamReader isr = null;
		BufferedReader br = null;
		FileWriter fw = null;
		try {
			isr = new InputStreamReader(System.in);
			br = new BufferedReader(isr);
			fw = new FileWriter("jlc.dat");
			System.out.println("Enter Data");
			char ch = ' ';

			do {
				int b = br.read();
				ch = (char) b;
				fw.write(b);
			} while (ch != '\n');
			System.out.println("Done");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fw != null)
					fw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	static void readFromFile() {
		PrintStream ps = null;
		FileReader fr = null;
		try {
			ps = System.out;
			fr = new FileReader("jlc.dat");
			char ch = ' ';
			do {
				int b = fr.read();
				ch = (char) b;
				ps.write(b);
			} while (ch != '\n');
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (fr != null)
					fr.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}