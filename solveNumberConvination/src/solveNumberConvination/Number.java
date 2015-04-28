package solveNumberConvination;

public class Number {
	int number = 0;
	int digit1 = 0;
	int digit2 = 0;
	int digit3 = 0;
	int digit4 = 0;
	
	public Number(int digit1, int digit2, int digit3, int digit4){
		this.digit1 = digit1;
		this.digit2 = digit2;
		this.digit3 = digit3;
		this.digit4 = digit4;
		this.number = digit1*1000 + digit2*100 + digit3*10 + digit4;
	}
	
	public boolean checkNumber(int digit){
		if((digit==digit1)||(digit==digit1)||(digit==digit1)||(digit==digit1)){
			return false;
		}
		else{
			return true;
		}
	}
}
