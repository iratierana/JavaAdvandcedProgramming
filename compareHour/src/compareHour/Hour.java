package compareHour;

public class Hour {

	int hour = 0;
	int minute = 0;
	
	public Hour(int hour, int minute){
		this.hour = hour;
		this.minute = minute;
	}
	
	public int compareHour(Hour hour){
		if(this.hour<hour.hour){
			return -1;
		}
		if(this.hour==hour.hour){
			if(this.minute<minute){
				return -1;
			}
			if(this.minute==hour.minute){
				return 0;
			}
			if(this.minute>minute){
				return 1;
			}
		}
		return 1;		
		
	}
	
	public String toString(){
		return this.hour + " : " + this.minute;
	}
		
}
