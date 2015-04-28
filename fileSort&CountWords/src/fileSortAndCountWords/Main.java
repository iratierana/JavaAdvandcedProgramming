package fileSortAndCountWords;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

	File file;
	
	public static void main(String[] args) throws FileNotFoundException {
		Main main = new Main();
		main.file = new File("laMancha.txt");
		SortCountWord program = new SortCountWord(main.file);
	}

}
