package fileDuplicator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	File originFile;
	File destinationFile;
	
	public static void main(String[] args) throws IOException {
		Scanner keyboard = new Scanner(System.in);
		Main main = new Main();
		
		System.out.println("Introduce the origin file name:");
		main.originFile = new File(keyboard.nextLine());
		
		System.out.println("Introduce the destination file name:");
		main.destinationFile = new File(keyboard.nextLine());
	
		
		Duplicator duplicator = new Duplicator(main.originFile);
		System.out.println(duplicator.duplicate(main.destinationFile));
	}

}
