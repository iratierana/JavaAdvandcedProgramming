package secureTakeDate;

public class Date {

	int year = 0;
	int month = 0;
	int day = 0;
	
	public Date(int year, int month, int day) throws Exception{
		this.checkDate(year, month, day);
		this.year = year;
		this.month = month;
		this. day = day;
	}
	
	public boolean checkDate(int year, int month, int day) throws Exception{
		boolean bisiesto = false;
		boolean correct = false;
		int limit = 0;
		
		if(year>=0){
			if((year%4)==0){
				bisiesto = true;
			}
			if((month>0)&&(month<=12)){
				
				switch(month){
					case 2: 
						if(bisiesto == true){
							limit=29;
						}
						if (bisiesto == false){
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
				else{
					throw new Exception ("Incorrect day");
				}
			}
			else{
				throw new Exception ("Incorrect month");
			}
		}
		else{
			throw new Exception ("Incorrect year");
		}
		
		return correct;
	}
	
	
}
