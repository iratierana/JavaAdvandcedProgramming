package calendarioCumpleaños;

public class Birthday {

	int year;
	int month;
	int day;
	String name;
	
	public static boolean checkBirthday(int year, int month, int day){
		
		boolean correct = false;
		boolean leapYear = false;
		int limit = 0;
		
		if(year>=0){
			if((year%4)==0){
				leapYear = true;
			}
			if((month>0)&&(month<=12)){
				
				switch(month){
					case 2: 
						if(leapYear == true){
							limit=29;
						}
						if (leapYear == false){
							limit=28;	
						}
						break;
					case 4: limit=30;
						break;
					case 6: limit=30;
						break;
					case 9: limit=30;
						break;
					case 11: limit=30;
						break;
					default: limit=31;
						break;
				}
				if(day<=limit){
					correct = true;
				}
			}
		}
		
		return correct;
	}
	
	public boolean setBirthday(int year, int month, int day, String name){
		
		this.year = year;
		this.month = month;
		this.day = day;
		this.name = name;
		
		return true;
	}
	
	public boolean getBirthday(int year, int month, int day){
		if(checkBirthday(year, month, day)){
			if((this.year == year)&&(this.month == month)&&(this.day == day)){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}	
	
}
