package fileDuplicatorWithLoadBar;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Duplicator {
	
	FileReader originFile;
	
	public Duplicator(String fileName) throws FileNotFoundException{
		originFile = new FileReader(fileName);
	}
	
	public void duplicate(String destination) throws IOException{
		FileWriter destinationFile = new FileWriter( destination);
		int word = 0;
		boolean finish = false;
		
		try {
			while(finish == false){
				word = Integer.valueOf(originFile.read());
				destinationFile.write(word);
				if(word == -1){
					finish = true;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(originFile != null){
				try {
					originFile.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(destinationFile != null){
				try {
					destinationFile.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		System.out.println("Final");
	}

}
