package exercise3;

import java.util.Random;

public class Exercise3 {

	public static void main(String[] args) {
		Exercise3 exercise = new Exercise3();
		
		
		
		if(args[0].equals("primos")){
			exercise.primos();
		}
		if(args[0].equals("capicua")){
			exercise.capicua();
		}
		if(args[0].equals("sumatrece")){
			exercise.sumatrece();
		}
	}
	
	public int randomNumberGenerator(){
		Random generator = new Random();
		
		int randomNumber = generator.nextInt(1001);
		
		return randomNumber;
	}

	public void primos(){
		int kont = 0;
		int number = 0;
		
		System.out.println("Primos:");
		while(kont<10){
			number = randomNumberGenerator();
			if(checkPrimos(number)){
				System.out.println(number);
				kont++;
			}
		}
	}
	
	private boolean checkPrimos(int number) {
		for(int i=2; i<(number); i++){
			if((number%i)==0){
				return false;
			}
		}
		return true;
	}

	public void capicua(){
		int kont = 0;
		int number = 0;
		
		System.out.println("Capicua:");
		while(kont<10){
			number = randomNumberGenerator();
			if(checkcapicua(number)){
				System.out.println(number);
				kont++;
			}
		}
	}
	
	private boolean checkcapicua(int number) {
		int digit1 = 0;
		int digit2 = 0;
		int digit3 = 0;
		int digit4 = 0;
		
		digit1 = number/1000;
		digit2 = (number - digit1*1000)/100;
		digit3 = (number - digit1*1000 - digit2*100)/10;
		digit4 = number - digit1*1000 - digit2*100 - digit3*10;
		
		if(number == 1000){
			return false;
		}
		
		if((digit2 == digit4)&&(digit2!=0)){
			return true;
		}
		
		if(digit2==0){
			if(digit3==digit4){
				return true;
			}
		}
		
		return false;
	}

	public void sumatrece(){
		int kont = 0;
		int number = 0;
		
		System.out.println("SumaTrece:");
		while(kont<10){
			number = randomNumberGenerator();
			if(checksumatrece(number)){
				System.out.println(number);
				kont++;
			}
		}
	}

	private boolean checksumatrece(int number) {
		int digit1 = 0;
		int digit2 = 0;
		int digit3 = 0;
		int digit4 = 0;
		int suma = 0;
		
		digit1 = number/1000;
		digit2 = (number - digit1*1000)/100;
		digit3 = (number - digit1*1000 - digit2*100)/10;
		digit4 = number - digit1*1000 - digit2*100 - digit3*10;
		
		suma = digit1 + digit2 + digit3 + digit4;
		
		if(suma==13){
			return true;
		}
		else{
			return false;
		}
	}
	
}
