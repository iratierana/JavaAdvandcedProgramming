package fileSortAndCountWords;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

public class SortCountWord {
	BufferedReader file;
	ArrayList list;
	ListIterator listIt;
	
	public SortCountWord (File origin) throws FileNotFoundException{
		file = new BufferedReader (new FileReader(origin));
		list = new ArrayList();
		createList();
		sortList();
		countWords();
	}

	public int createList(){
		String line;
		int wordsCounter = 0;
		
		try {
			while((line = file.readLine())!= null){
				String [] words = line.toLowerCase().split("[^a-z^á^é^í^ó^ú]");
				
				for (String word: words){
					if(word.length()>0){
						list.add(word);
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
	
	private void sortList() {
		Collections.sort(list);
		
	}

	private void countWords() {
		listIt = list.listIterator();
		String previousString = null;
		String string = null;
		int cont = 0;
		
		while(listIt.hasNext()){
			string = (String) listIt.next();
			if (string.equals(previousString)){
				cont++;
			}
			else{
				if(previousString != null){
					System.out.print(string + ": " + cont);
				}
			}
		}
		
	}
}
