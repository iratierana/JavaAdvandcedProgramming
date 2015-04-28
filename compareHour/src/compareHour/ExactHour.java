package compareHour;

public class ExactHour extends Hour{

	int seconds;
	
	public ExactHour(int hour, int minute, int seconds) {
		super(hour, minute);		
		this.seconds = seconds;
	}
	
	public String toString(){
		return this.hour + " : " + this.minute + " : " + this.seconds ;
	}

}
