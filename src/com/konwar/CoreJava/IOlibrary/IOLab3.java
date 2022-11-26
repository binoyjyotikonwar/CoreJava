package com.konwar.CoreJava.IOlibrary;
//Example using BufferReader and PrintStream
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;

public class IOLab3 {
	public static void main(String[] args) {
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			Reader rd = new BufferedReader(isr);
			PrintStream ps= System.out;
			System.out.println("Enter Data");
			char ch =' ';
			do {
				int b = rd.read();
				ch = (char)b;
				ps.write(b);
			}while(ch != '\n');
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
