package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Reader;
import java.io.Writer;

public class Read {

	public void reader(){
		
		try {
			FileReader reader = new FileReader("myfile.txt");

		    int data = reader.read();
		    while(data != -1){
		        char dataChar = (char) data;
		        data = reader.read();
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void bufferedReader(){
		String line;
		
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader("myfile.txt"));
			while((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
			bufferedReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void objectInputStream(){
		Object obj;
		try{
			FileInputStream fin = new FileInputStream("myFile.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			obj = (Object) ois.readObject();
			ois.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
