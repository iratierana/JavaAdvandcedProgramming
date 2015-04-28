package fileDuplicator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Duplicator {
	BufferedReader originFile;
	
	public Duplicator (File origin) throws IOException{
		originFile = new BufferedReader (new FileReader(origin));
	}
	
	public int duplicate(File destination) throws IOException{
		BufferedWriter destinationFile = new BufferedWriter(new FileWriter(destination));
		String line;
		int lines = 0;
		
		try {
			while((line = originFile.readLine())!= null){
				destinationFile.write(line + "\n");
				lines++;
						
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
		
		
		
		return lines;
	}
	
}
