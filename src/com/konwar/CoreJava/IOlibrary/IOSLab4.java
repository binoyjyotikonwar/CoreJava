package com.konwar.CoreJava.IOlibrary;

import java.io.File;

//Example using file
public class IOSLab4 {
	public static void main(String[] args) {
		System.out.println("File.pathSeparator\t:" +File.pathSeparator);
		System.out.println("File.pathSeparatorChar\t:" +File.pathSeparatorChar);
		System.out.println("File.separator\t:" +File.separator);
		System.out.println("File.separatorChar\t:" +File.separatorChar);
		File[] far = File.listRoots();
		System.out.println(far.length);
		System.out.println("FileName\tisDirectory\tisFile\tisAbsolute\tgetPath");
		for(int i=0; i<far.length;i++)
		{
			System.out.println(far[i].getName()+"\t\t"+ far[i].isDirectory()+"\t\t"+far[i].isFile()+"\t\t"+far[i].isDirectory()+"\t\t"+
		far[i].getPath());
		}
}
}
