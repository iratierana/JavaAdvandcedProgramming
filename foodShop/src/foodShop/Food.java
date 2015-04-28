package foodShop;

import java.util.Scanner;

public class Food {
	
	Date useByDate;
	int productSet;
	
	

	public Food() {
		useByDate = new Date();
	}

	public Date getUseByDate() {
		return useByDate;
	}

	public void setUseByDate(Date useByDate) {
		this.useByDate = useByDate;
	}

	public int getProductSet() {
		return productSet;
	}

	public void setProductSet(int productSet) {
		this.productSet = productSet;
	}
	
	public void askFoodData(){
		Scanner keyboard = new Scanner(System.in);
		int day = 0, month = 0, year = 0;
		
		System.out.println("Introduce the Use by Date:");
		System.out.print("Year: ");
		year = keyboard.nextInt(); keyboard.nextLine();
		useByDate.setYear(year);
		System.out.print("Month: ");
		month = keyboard.nextInt(); keyboard.nextLine();
		useByDate.setMonth(month);
		System.out.print("Day: ");
		day = keyboard.nextInt(); keyboard.nextLine();
		useByDate.setDay(day);
		
		
		
		System.out.print("Introduce the Product Set: ");
		productSet = keyboard.nextInt(); keyboard.nextLine();
		
		System.out.println("");
	}
	
	public String toString(){
		return "Use By Date:" +useByDate+ "\nProduct Set: " +productSet;
	}
}
