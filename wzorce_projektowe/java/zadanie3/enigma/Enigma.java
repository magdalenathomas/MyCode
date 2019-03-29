package zadanie3.enigma;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Enigma {
	
	public static String nowyTekst;
	//public static File file;
	
	public static void main(String[] args) throws IOException {	
		
		//String filePath;
		String textLine;
		
		while(true) {
		System.out.println("Aby przerwać pracę programu wciśnij q");
		System.out.println("Wprowadz ścieżkę do pliku:");
		Scanner read = new Scanner(System.in);
		String wprowadzenie = read.nextLine();
		if (wprowadzenie == "q") {
			System.out.println("Koniec pracy programu");
			break;
		}
		
		FileReader fileReader = new FileReader(wprowadzenie);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		if (wprowadzenie.endsWith("t")) {
			while ((textLine = bufferedReader.readLine()) != null) {
				nowyTekst = textLine.replace("e", "*"); }
		} else if (wprowadzenie.endsWith("c")) {
			while ((textLine = bufferedReader.readLine()) != null) {
				nowyTekst = textLine.replace("*", "e");}
		}
		
			bufferedReader.close();
			
		if (wprowadzenie.endsWith("t")) {
			File file = new File("c:/ja/magda3.src");
			file.createNewFile();
			FileWriter fileWriter = new FileWriter(file);
	        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	 
	        bufferedWriter.write(nowyTekst);
	        bufferedWriter.close();
		} else {
			File file = new File("c:/ja/magda3.txt");
			file.createNewFile();
			FileWriter fileWriter = new FileWriter(file);
	        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	 
	        bufferedWriter.write(nowyTekst);
	        bufferedWriter.close();
		}
		} 	  
	}
}
