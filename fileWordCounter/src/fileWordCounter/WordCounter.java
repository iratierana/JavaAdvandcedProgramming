package fileWordCounter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WordCounter {
	BufferedReader file;
	
	public WordCounter (File origin) throws FileNotFoundException{
		file = new BufferedReader (new FileReader(origin));
	}
	
	public int counter(){
		String line;
		int wordsCounter = 0;
		
		try {
			while((line = file.readLine())!= null){
				String [] words = line.toLowerCase().split("[^a-z^á^é^í^ó^ú]");
				
				for (String word: words){
					if(word.length()>0){
						wordsCounter++;
					}
				}
						
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(file != null)
				try {
					file.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
		
		return wordsCounter;
	}
	
}
