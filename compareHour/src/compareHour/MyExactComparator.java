package compareHour;

import java.util.Comparator;

public class MyExactComparator implements Comparator<ExactHour>{

	@Override
	public int compare(ExactHour hour1, ExactHour hour2) {
		if(hour1.hour<hour2.hour){
			return -1;
		}
		if(hour1.hour==hour2.hour){
			if(hour1.minute<hour2.minute){
				return -1;
			}
			if(hour1.minute==hour2.minute){
				if(hour1.seconds<hour2.seconds){
					return -1;
				}
				if(hour1.seconds==hour2.seconds){
					return 0;
				}
				if(hour1.seconds>hour2.seconds){
					return 1;
				}
			}
			if(hour1.minute>hour2.minute){
				return 1;
			}
		}
		return 1;
	}

}
