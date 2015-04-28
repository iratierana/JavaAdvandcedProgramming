package exercise2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import java.util.Scanner;

public class Exercise2 {
	
	ArrayList figureList;
	ListIterator figureListIt;

	public static void main(String[] args) {
		Exercise2 exercise = new Exercise2();
		exercise.Menu();

	}
	
	public void Menu(){
		Scanner keyboard = new Scanner (System.in);
		int option = 0;
		int figureOption;
		figureList = new ArrayList<Figure>();
		
		System.out.println("Figures program");
		
		do{
			System.out.println("1. Create figure");
			System.out.println("2. See figures sort by area");
			System.out.println("3. See figures sort by position");
			System.out.println("0. Exit");
		
			option = keyboard.nextInt(); keyboard.nextLine();
			
			switch (option){	
			
			case 1:
				int posX, posY;
				System.out.println("Select Figure");
				
				
					System.out.println("1. Square");
					System.out.println("2. Rectangle");
					System.out.println("3. Triangle");
					System.out.println("4. Circle");
				
					figureOption = keyboard.nextInt(); keyboard.nextLine();
					
					System.out.println("Position X: ");
					posX = keyboard.nextInt(); keyboard.nextLine();
					System.out.println("Position Y: ");
					posY = keyboard.nextInt(); keyboard.nextLine();
					
					switch (figureOption){	
					
					case 1:
						int side;
						System.out.println("Side: ");
						side = keyboard.nextInt(); keyboard.nextLine();
						Square square = new Square(posX, posY, side);
						figureList.add(square);
					break;
					
					case 2:
						int side1, side2;
						System.out.println("Side 1: ");
						side1 = keyboard.nextInt(); keyboard.nextLine();
						System.out.println("Side 2: ");
						side2 = keyboard.nextInt(); keyboard.nextLine();
						Rectangle rectangle = new Rectangle(posX, posY, side1, side2);
						figureList.add(rectangle);
					break;
					
					case 3:
						int base, height;
						System.out.println("Base: ");
						base = keyboard.nextInt(); keyboard.nextLine();
						System.out.println("Height: ");
						height = keyboard.nextInt(); keyboard.nextLine();
						Triangle triangle = new Triangle(posX, posY, base, height);
						figureList.add(triangle);
					break;
					
					case 4:
						int radio;
						System.out.println("Radio: ");
						radio = keyboard.nextInt(); keyboard.nextLine();
						Circle circle = new Circle(posX, posY, radio);
						figureList.add(circle);
					break;
					}
					
				
			break;
			
			case 2:
				sortByPosition();
			break;
			
			case 3:
				sortByArea();
			break;
			
			}
			
		}while (option!=0);
	}

	public void goOverList(){
		figureListIt = figureList.listIterator();
		
		while(figureListIt.hasNext()){
			System.out.println(figureListIt.next().toString());
		}
	}
	
	public void sortByPosition(){
		PositionComparator positionComparator = new PositionComparator();
		
		Collections.sort(figureList, positionComparator);
		
		goOverList();
	}
	
	public void sortByArea(){
		AreaComparator areaComparator = new AreaComparator();
		
		Collections.sort(figureList, areaComparator);
		
		goOverList();
	}
}
