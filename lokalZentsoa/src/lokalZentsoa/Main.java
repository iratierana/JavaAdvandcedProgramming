package lokalZentsoa;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int aukera = 0;
		Scanner keyboard = new Scanner(System.in);
		Main main = new Main();
		
		do{
			System.out.println("Ongi etorri datu basera");
			System.out.println("1. Lokala sortu");
			System.out.println("2. Pertsona sartu");
			System.out.println("3. Lokala ikusi");
			System.out.println("0. Irten");
			aukera = keyboard.nextInt(); keyboard.nextLine();
			switch(aukera){
			case 1:
				lokalaSortu();
				break;
			case 2:
				pertsonaSartu();
				break;
			case 3:
				lokalaIkusi();
				break;
			}
		}while(aukera != 0);

	}

	private static void lokalaSortu() {
		ArrayList<Lokala> lokalList = new ArrayList<Lokala>();
		Scanner keyboard = new Scanner(System.in);
		Lokala lokala = new Lokala();
		
		try{
			FileInputStream fin = new FileInputStream("lokalZentsoa.dat");
			ObjectInputStream ois = new ObjectInputStream(fin);
			lokalList = (ArrayList<Lokala>) ois.readObject();
			ois.close();
			
		}catch(Exception e){
			System.out.println("Datu basea oraindik ez dago sortua");
		}
		
		System.out.println("Jabea: ");
		lokala.setJabea(keyboard.nextLine());
		System.out.println("Helbidea: ");
		lokala.setHelbidea(keyboard.nextLine());
		System.out.println("Metro Karratuak: ");
		lokala.setMetroKarratuak(keyboard.nextInt()); keyboard.nextLine();
		
		lokalList.add(lokala);
		
		try{
			FileOutputStream fon = new FileOutputStream("lokalZentsoa.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fon);
			oos.writeObject(lokalList);
			oos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private static void pertsonaSartu() {
		ArrayList<Lokala> lokalList = new ArrayList<Lokala>();
		Scanner keyboard = new Scanner(System.in);
		Pertsona pertsona = new Pertsona();
		
		try{
			FileInputStream fin = new FileInputStream("lokalZentsoa.dat");
			ObjectInputStream ois = new ObjectInputStream(fin);
			lokalList = (ArrayList<Lokala>) ois.readObject();
			ois.close();
			
		}catch(Exception e){
			System.out.println("Datu basea oraindik ez dago sortua");
			return;
		}
		
		System.out.println("NAN: ");
		pertsona.setNan(keyboard.nextLine());
		System.out.println("Izena: ");
		pertsona.setIzena(keyboard.nextLine());
		System.out.println("Abizena: ");
		pertsona.setAbizena(keyboard.nextLine());
		
		System.out.println("Zein lokaletan nahi duzu sartu?");
		for(int i = 0; i < lokalList.size(); i++){
			System.out.println(i + 1);
			lokalList.get(i).toString();
		}
		System.out.println("Aukeratu zenbakia: ");
		int lokalZenbakia = keyboard.nextInt(); keyboard.nextLine();
		
		lokalList.get(lokalZenbakia -1).getPertsonaList().add(pertsona);
		
	}

	private static void lokalaIkusi() {
		ArrayList<Lokala> lokalList = new ArrayList<Lokala>();
		int lokalZenbakia = 0;
		Scanner keyboard = new Scanner(System.in);
		
		try{
			FileInputStream fin = new FileInputStream("lokalZentsoa.dat");
			ObjectInputStream ois = new ObjectInputStream(fin);
			lokalList = (ArrayList<Lokala>) ois.readObject();
			ois.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		for(int i = 0; i < lokalList.size(); i++){
			System.out.println(i + 1);
			lokalList.get(i).toString();
		}
		System.out.println("Aukeratu zenbakia: ");
		lokalZenbakia = keyboard.nextInt(); keyboard.nextLine();
		
		lokalList.get(lokalZenbakia - 1).toString();
		
		for(int i = 0; i < lokalList.get(lokalZenbakia - 1).getPertsonaList().size(); i++){
			lokalList.get(lokalZenbakia - 1).getPertsonaList().toString();
		}
		
	}

}
