package intGraphicCelsiusFarenheit;

public class Temperature {
	
	public int celciusToFarenheit(int celcius){
		int farenheit = 0;
		farenheit = (int) ((celcius * 1.8) - 32);
		return farenheit;
	}
	
	public int farenheitToCelcius(int farenheit){
		int celcius = 0;
		celcius = (int) ((farenheit - 32)/1.8);
		return celcius;
	}
}
