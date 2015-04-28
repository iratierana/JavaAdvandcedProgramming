package file;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Write {

	public void writer(){
		try {
			FileWriter writer = new FileWriter("c:\\data\\file-output.txt");

			writer.write("Hello World Writer");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void bufferedWriter(){
		String line = "aaa";
		int kont = 0;
		
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("myfile.txt"));
			while(kont < 10) {
				bufferedWriter.write(line);
				bufferedWriter.newLine();
				kont++;
			}
			bufferedWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void objectOutputStream(){
		Object obj = null;
		try{
			FileOutputStream fon = new FileOutputStream("myFile.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fon);
			oos.writeObject(obj);
			oos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
