package fileWordCounter;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

	File file;
	
	public static void main(String[] args) throws FileNotFoundException {
		Main main = new Main();
		main.file = new File("DonQuijoteDeLaMancha.txt");
		WordCounter counter = new WordCounter(main.file);
		System.out.println(counter.counter());
	}

}
